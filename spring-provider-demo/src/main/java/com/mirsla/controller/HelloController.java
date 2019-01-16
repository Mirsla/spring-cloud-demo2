package com.mirsla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  17:28 2018/12/28
 * @modified By:
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instances = discoveryClient.getInstances("hello-service");
        for (int i = 0; i < instances.size(); i++) {
            System.out.println("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
//            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "Hello World";
    }
}
