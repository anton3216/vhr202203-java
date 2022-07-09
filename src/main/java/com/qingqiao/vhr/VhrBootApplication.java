package com.qingqiao.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.qingqiao.vhr.mapper")
//@EnableCaching
public class VhrBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrBootApplication.class, args);
    }

}
