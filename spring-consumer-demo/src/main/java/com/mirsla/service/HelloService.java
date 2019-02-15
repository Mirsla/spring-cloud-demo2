package com.mirsla.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  16:21 2019/2/15
 * @modified By:
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    // 同步调用
    @HystrixCommand(fallbackMethod = "error")
    public String hello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        return responseEntity.getBody();
    }

    public String error() {
        return "error";
    }

}
