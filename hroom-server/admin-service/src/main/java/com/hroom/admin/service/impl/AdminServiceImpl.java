package com.hroom.admin.service.impl;

import com.hroom.admin.repository.AdminRepository;
import com.hroom.admin.service.AdminService;
import com.hroom.admin.entity.Admin;
import com.hroom.admin.entity.User;
import com.hroom.admin.exception.MissingUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static com.hroom.admin.security.SecurityTools.isSanitized;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;


    @Autowired
    private AdminRepository repository;
    private static final String USER_BASE_URL = "http://user-microservice/api/v1";
    private final RestTemplate restTemplate = new RestTemplate();
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AdminServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public Admin saveAdmin(Admin admin) {
        LOGGER.info("AdminServiceImpl > saveAdmin started");
        return repository.save(admin);
    }

    @Override
    public List<Admin> fetchAdminList() {
        LOGGER.info("AdminServiceImpl > fetchAdminList started");
        return (List<Admin>) repository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin, Long userId)
        throws MissingUserException {
        LOGGER.info("AdminServiceImpl > updateAdmin started");
        Optional<Admin> optional= repository.findById(userId);

        if(optional.isEmpty()) {
            throw new MissingUserException(userId);
        }

        Admin userDB = optional.get();

        if (isSanitized(admin.getUsername())) userDB.setUsername(admin.getUsername());
        if (isSanitized(admin.getName())) userDB.setName(admin.getName());
        if (isSanitized(admin.getSurname())) userDB.setSurname(admin.getSurname());
        if (isSanitized(admin.getBirthdate())) userDB.setBirthdate(admin.getBirthdate());
        if (isSanitized(admin.getCapability())) userDB.setCapability(admin.getCapability());
        if (isSanitized(admin.getPassword())) userDB.setPassword(admin.getPassword());

        return repository.save(userDB);
    }

    @Override
    public void deleteAdminById(Long userId) {
        LOGGER.info("AdminServiceImpl > deleteAdminById started");
        repository.deleteById(userId);
    }

    @Override
    public ResponseEntity<?> banUserById(Long userId) {
        LOGGER.info("AdminServiceImpl > banUserById started");
        LOGGER.info("AdminServiceImpl > banUserById > userId : " + userId);

        // String result = getRoleInfo();

        // LOGGER.info("AdminServiceImpl > banUserById > role result : " + result);

        // if(result.equals("ROLE_ADMIN")){
            // HttpHeaders httpHeaders = new HttpHeaders();
            // httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            // HttpEntity < String > entity = new HttpEntity < > (httpHeaders);
            // return restTemplate.exchange(USER_BASE_URL + userId,
            //                              HttpMethod.DELETE, entity, String.class);
        // }

        LOGGER.info("AdminServiceImpl > banUserById > Invoking RabbitMq");
        rabbitTemplate.convertAndSend(exchange, routingkey, userId);

        return null;
    }

    private String getRoleInfo() {

        LOGGER.info("AdminServiceImpl > getRoleInfo is started");

        String result = this.restTemplate.getForObject(USER_BASE_URL + "/info",String.class);

        LOGGER.info("AdminServiceImpl > getRoleInfo > role result : " + result);

        return result;
    }

}
