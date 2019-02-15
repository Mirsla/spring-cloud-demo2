package com.mirsla.controller;

import com.mirsla.entities.Consumers;
import com.mirsla.hystrix.ConsumerHystrix;
import com.mirsla.service.HelloService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  18:04 2018/12/28
 * @modified By:
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloController() {
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
//        String body = responseEntity.getBody();
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        StringBuffer result = new StringBuffer();
//        result.append("responseEntity.getBody()：").append(body).append("<hr>")
//                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
//                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
//                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return helloService.hello();
    }

    @RequestMapping(value = "consumer")
    public Object getConsumer() {
        ResponseEntity<Consumers> consumer = restTemplate.getForEntity("http://hello-service/consumer/get", Consumers.class);
        return consumer.getBody();
    }

    @RequestMapping("/test1")
    public Consumers test1() throws ExecutionException, InterruptedException {
        ConsumerHystrix bookCommand = new ConsumerHystrix(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        //同步调用
        //Book book1 = bookCommand.execute();
        //异步调用
        Future<Consumers> queue = bookCommand.queue();
        Consumers consumer = queue.get();
        return consumer;
    }
}
