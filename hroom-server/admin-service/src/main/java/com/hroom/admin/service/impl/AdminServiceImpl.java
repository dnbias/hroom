package com.hroom.admin.service.impl;

import com.hroom.admin.service.AdminService;
import com.hroom.admin.entity.Admin;
import com.hroom.admin.entity.User;
import com.hroom.admin.exception.MissingUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;
    private final String routingkeyPhoto="photo-routing";
    private final String routingkeyInsertion="photo-insertion";
    private final String exchangePhoto="photo-exchange";
    private final String exchangeInsertion="insertion-exchange";


    private static final String USER_BASE_URL = "http://user-microservice/api/v1";
    private final RestTemplate restTemplate = new RestTemplate();
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AdminServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public String deletePhotoById(Long photoId) {
        LOGGER.info("AdminServiceImpl > deletePhotoById started");
        LOGGER.info("AdminServiceImpl > deletePhotoById > photoId : " + photoId);

        LOGGER.info("AdminServiceImpl > deletePhotoById > Invoking RabbitMq");
        rabbitTemplate.convertAndSend(exchangePhoto, routingkeyPhoto, photoId);
        return "Photo Deleted";
    }

    @Override
    public String deleteInsertionById(Long insId) {
        LOGGER.info("AdminServiceImpl > deleteInsertionById started");
        LOGGER.info("AdminServiceImpl > deleteInseritonById > insId : " + insId);

        LOGGER.info("AdminServiceImpl > deleteInsertionById > Invoking RabbitMq");
        rabbitTemplate.convertAndSend(exchangeInsertion, routingkeyInsertion, insId);
        return "Insertion Deleted";
    } 

    @Override
    public String banUserById(Long userId) {
        LOGGER.info("AdminServiceImpl > banUserById started");
        LOGGER.info("AdminServiceImpl > banUserById > userId : " + userId);

        LOGGER.info("AdminServiceImpl > banUserById > Invoking RabbitMq");
        rabbitTemplate.convertAndSend(exchange, routingkey, userId);
        return "User Banned";
    }

    private String getRoleInfo() {

        LOGGER.info("AdminServiceImpl > getRoleInfo is started");

        String result = this.restTemplate.getForObject(USER_BASE_URL + "/info",String.class);

        LOGGER.info("AdminServiceImpl > getRoleInfo > role result : " + result);

        return result;
    }

}
