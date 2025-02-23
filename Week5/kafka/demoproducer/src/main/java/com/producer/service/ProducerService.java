package com.producer.service;

import com.producer.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void produce(Product product) {
        System.out.println("Order sending from producer");
        kafkaTemplate.send("order-topic", product);
    }
}

