package com.hroom.insertion.service;

import com.hroom.insertion.repository.PhotoRepository;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RabbitListener(queues = "${queue.photo.name}")
public class RabbitMQPhotoService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private PhotoRepository repository;

    @RabbitHandler
    public void receiver(Long photoId) {
        LOGGER.info("photoId listener invoked - Consuming Message w/ Identifier : " + photoId);
        repository.deleteById(photoId);
        LOGGER.info("Deleted photo: " + photoId);
    }
}
