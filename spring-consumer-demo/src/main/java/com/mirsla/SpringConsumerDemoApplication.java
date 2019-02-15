package com.mirsla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //自动发现服务的能力
@SpringBootApplication
@EnableCircuitBreaker //开启断路器功能
public class SpringConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumerDemoApplication.class, args);
    }

    @LoadBalanced  // 自动开启负载均衡
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

