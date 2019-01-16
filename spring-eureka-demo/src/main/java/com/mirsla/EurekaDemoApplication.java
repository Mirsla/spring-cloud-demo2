package com.mirsla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Mirsla
 * @descripTion: Eureka注册中心启动类
 * @date: Created in  11:36 2018/12/28
 * @modified By:
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApplication.class, args);
    }
}
