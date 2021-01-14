package com.tmxbase.dcsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tmxbase.dcsserver.dal.mapper")
public class DcsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcsServerApplication.class, args);
    }

}
