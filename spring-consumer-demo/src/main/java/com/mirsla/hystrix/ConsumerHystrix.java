package com.mirsla.hystrix;

import com.mirsla.entities.Consumers;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  17:00 2019/2/15
 * @modified By:
 */
public class ConsumerHystrix extends HystrixCommand<Consumers> {

    private RestTemplate restTemplate;

    @Override
    protected Consumers getFallback() {
        return new Consumers(123, "ziyang", "15618142143");
    }

    public ConsumerHystrix(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Consumers run() throws Exception {
        return restTemplate.getForObject("http://hello-service/consumer/get", Consumers.class);
    }
}
