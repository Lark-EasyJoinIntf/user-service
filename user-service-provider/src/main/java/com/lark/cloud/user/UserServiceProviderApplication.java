package com.lark.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lark.cloud.user.mapper") //mapper的包
public class UserServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }
}

