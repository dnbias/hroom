package com.hroom.insertion.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hroom.insertion.repository.InsertionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RabbitListener(queues = "${queue.name}")
public class RabbitMQInsertionService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private InsertionRepository repository;

    @RabbitHandler
    public void receiver(Long insertionId) {
        LOGGER.info("insertionId listener invoked - Consuming Message w/ Identifier : " + insertionId);
        repository.deleteById(insertionId);
        LOGGER.info("Deleted insertion: " + insertionId);
    }
}
