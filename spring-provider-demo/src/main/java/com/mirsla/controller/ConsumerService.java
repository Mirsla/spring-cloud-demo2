package com.mirsla.controller;

import com.mirsla.entities.Consumers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  11:03 2019/1/21
 * @modified By:
 */
@RestController
@RequestMapping("consumer")
public class ConsumerService {

    @RequestMapping("get")
    public Object getConsumer() {
        return new Consumers(1, "ziyang", "15879452145");
    }
}
