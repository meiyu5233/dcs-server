# Data cleaning system

## 依赖服务

### bloom

```shell
    docker run -d -p 6379:6379 --name bloomfilter redislabs/rebloom
```

### chineseSentimentAnalysisProcess

```shell
    git clone ssh://git@gitlab.tmxmall.com:9422/tmxmall_nmt/chinese_sentiment_analysis.git
    cd chinese_sentiment_analysis
    sh build.sh
    docker run -it -d -p 8666:8666 --name chinese-ana-app -d chinese-ana-app
```
