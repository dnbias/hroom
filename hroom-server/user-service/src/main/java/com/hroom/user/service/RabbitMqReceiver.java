package com.hroom.user.service;

import com.hroom.user.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RabbitListener(queues = "${queue.name}")
public class RabbitMqReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqReceiver.class);
    @Autowired
    UserRepository repository;

    @RabbitHandler
    public void receiver(Long userId) {
        LOGGER.info("userId listener invoked - Consuming Message w/ Identifier : " + userId);
        repository.deleteById(userId);
        LOGGER.info("Deleted user: " + userId);
    }
}
