package com.consumer.service;

import com.consumer.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "order-topic", groupId = "order_topic_group_id")
    public void consume(Product product) {
        logger.info("Order received: {}", product);
        try {
            logger.info("Processing order with id: {}", product.getProductID());
            Thread.sleep(2000);
            logger.info("order with id {} processed successfully.", product.getProductID());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Error processing order ID {}: {}", product.getProductID(), e.getMessage());
        }
    }

}