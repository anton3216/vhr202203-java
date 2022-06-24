package com.qingqiao.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qingqiao.vhr.mapper")
public class VhrBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrBootApplication.class, args);
    }

}
