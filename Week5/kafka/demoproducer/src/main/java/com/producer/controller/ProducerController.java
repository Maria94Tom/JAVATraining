package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @GetMapping("/hello")
    public String basicMessage() {
        return "hello";
    }
    @Autowired
    private ProduceService produceService;
    @PostMapping("order")
    public String callProducer(@RequestBody Order order) {
        produceService.produce(order);
        return "order added";
    }
}