package com.tmxbase.dcsserver.service.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.alibaba.fastjson.JSONObject;
import com.tmxbase.dcsserver.base.model.CrawlerSource;
import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.mq.producer.QueueProducer;
import com.tmxbase.utils.ExceptionUtil;
import com.tmxbase.utils.FileUtil;
import com.tmxbase.utils.LoggerUtil;
import com.tmxbase.utils.StringUtil;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

public class WebCollectorGeneral extends BreadthCrawler {

    private static final Logger logger = LoggerFactory.getLogger(WebCollectorGeneral.class);

    protected QueueProducer queueProducer;

    protected SiteSource siteSource;

    protected List<String> urlRegexList = new ArrayList<>();

    protected String crawlPath;

    protected String crawlFilePath;

    protected String extractor;

    protected ConcurrentSkipListSet<String> dataSet = new ConcurrentSkipListSet<>();

    protected volatile int fileNum = 1;

    protected volatile File file = null;

    protected volatile FileWriter fileWriter = null;

    protected volatile PrintWriter printWriter = null;

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        for (String regex : urlRegexList) {
            if (!url.matches(regex)) {
                return;
            }
        }

        LoggerUtil.info(logger, "page.url" + url);

        // 下载网页
        String html = page.html();
//        String html = downloadPage(url);
        if (StringUtil.isBlank(html)) {
            LoggerUtil.warn(logger, "[visit] html为空");
            return;
        }
        BufferedWriter writer = null;
        String htmlPath = crawlPath + "web/" + StringUtil.getRandomId() + new Date().getTime() + ".html";
        LoggerUtil.info(logger, "htmlPath" + htmlPath);
        try {
            FileUtil.createFileAnyway(htmlPath);
            writer = new BufferedWriter(new FileWriter(htmlPath));
            LoggerUtil.info(logger, "[html] 的内容" + html);
            writer.write(html);
            writer.close();
        } catch (Exception e) {
            ExceptionUtil.caught(e, "写入出错");
        }

        // 数据写入
        String filePath = writeData(url, htmlPath);
        if (StringUtil.isBlank(filePath)) {
            return;
        }

    }

    private String downloadPage(String url) throws IOException {
        StringBuilder builder = new StringBuilder();
        // 目标网页链接
        String inputLine = null;
        try {
            URL pageUrl = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(pageUrl.openStream(), "utf-8"));
            // 将输入流读入到变量中，再写入到文件

            while ((inputLine = br.readLine()) != null) {
                builder.append(inputLine);
                System.out.println(inputLine);
            }
            br.close();
            System.err.println("下载完毕!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


    public WebCollectorGeneral(String crawlPath, boolean autoParse, String seed, List<String> regexList, QueueProducer queueProducer) {
        super(crawlPath + "crawlerDB", autoParse);
        this.crawlPath = crawlPath;
        this.queueProducer = queueProducer;
        /*start page*/
        this.addSeed(seed);
        LoggerUtil.info(logger, "regexList" + regexList);
        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        for (String string : regexList) {
            this.addRegex(string);
            urlRegexList.add(string);
        }
        /*do not fetch jpg|png|gif*/
        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        this.addRegex("-.*#.*");
    }

    private synchronized String writeData(String url, String htmlPath) {
        try {
            if (file == null) {
                file = new File(crawlPath + "crawler" + fileNum + ".txt");
                this.crawlFilePath = file.getPath();
            }

            if (!file.exists()) {
                FileUtil.createFileAnyway(file.getPath());
            }

            JSONObject data = new JSONObject();
            data.put("url", url);
            data.put("htmlPath", htmlPath);
            data.put("extractor", extractor);

            LoggerUtil.info(logger, "data" + data.toJSONString());
            List<Object> alist = new ArrayList<>();
            alist.add(data);
            dataSet.add(data.toJSONString());
            dataSet.stream().sorted();

            // 写文件时确保每个文件1000行数据，当文件满1000行，则发布mq处理该文件，接下来的任务新建下一个文件继续写入
            if (dataSet.size() >= 1000) {
                if (fileWriter == null || printWriter == null) {
                    fileWriter = new FileWriter(file, true);
                    printWriter = new PrintWriter(fileWriter);
                }

                for (String str : dataSet) {
                    printWriter.println(str);
                }

                printWriter.flush();
                fileWriter.flush();

                dataSet.clear();

                if (file.exists()) {
                    this.crawlFilePath = file.getPath();
                    CrawlerSource crawlerSource = new CrawlerSource(siteSource.getSiteSourceId(), siteSource.getSiteSourceName(), siteSource.getSiteSourceUri(), siteSource.getLan(), siteSource.getCountry(),
                            siteSource.getSource(), siteSource.getPlatform(), siteSource.getParser(), crawlFilePath, siteSource.getMedia());
                    queueProducer.publishCrawlerSourceProcessTask(crawlerSource);
                    LoggerUtil.info(logger, "[writeData] 发布任务:" + crawlerSource);
                }

                fileNum++;
                file = new File(crawlPath + "crawler" + fileNum + ".txt");

                this.crawlFilePath = file.getPath();

                if (printWriter != null) {
                    printWriter.close();
                    printWriter = null;
                }
                if (fileWriter != null) {
                    fileWriter.close();
                    fileWriter = null;
                }
            }

            return file.getPath();
        } catch (IOException e) {
            ExceptionUtil.caught(e, "写入出错");
            return "";
        }
    }

    public void execute(SiteSource siteSource) throws Exception {
        this.siteSource = siteSource;
        this.extractor = siteSource.getParser().split("\\|\\|\\|")[1];

        this.setThreads(siteSource.getCrawlThreads());
        this.start(siteSource.getCrawlDepth());

        LoggerUtil.info(logger, "extractor:" + extractor);
        // 将不满1000行的数据写入
        if (fileWriter == null || printWriter == null) {
            LoggerUtil.info(logger, "[WebCollectorGeneral]");
            try {
                fileWriter = new FileWriter(file, true);
                printWriter = new PrintWriter(fileWriter);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                LoggerUtil.info(logger, "wrong");
            }
            LoggerUtil.info(logger, "[WebCollectorGeneral]");
        }

        for (String str : dataSet) {
            printWriter.println(str);
        }

        if (printWriter != null) {
            printWriter.close();
            printWriter = null;
        }
        if (fileWriter != null) {
            fileWriter.close();
            fileWriter = null;
        }

        // 删除BerkeleyDB文件
        FileUtil.deleteDirOrFile(crawlPath + "crawlerDB");

        // 发送mq处理后续任务
        CrawlerSource crawlerSource = new CrawlerSource(siteSource.getSiteSourceId(), siteSource.getSiteSourceName(), siteSource.getSiteSourceUri(), siteSource.getLan(), siteSource.getCountry(),
                siteSource.getSource(), siteSource.getPlatform(), siteSource.getParser(), crawlFilePath, siteSource.getMedia());
        LoggerUtil.info(logger, "crawlerSource" + siteSource.getSiteSourceId(), siteSource.getSiteSourceName(), siteSource.getSiteSourceUri(), siteSource.getLan(), siteSource.getCountry(),
                siteSource.getSource(), siteSource.getPlatform(), siteSource.getParser(), crawlFilePath, siteSource.getMedia());
        queueProducer.publishCrawlerSourceProcessTask(crawlerSource);

        LoggerUtil.info(logger, "[execute] 发布任务:" + crawlerSource);
    }
}
