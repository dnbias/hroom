package com.hroom.admin.service.impl;

import com.hroom.admin.repository.AdminRepository;
import com.hroom.admin.service.AdminService;
import com.hroom.admin.entity.Admin;
import com.hroom.admin.entity.User;
import com.hroom.admin.exception.MissingUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hroom.admin.security.SecurityTools.isSanitized;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdminRepository repository;
    private static final String TENANT_BASE_URL = "http://TENANT-SERVICE:8761/api/v1";
    private static final String LANDLORD_BASE_URL = "http://LANDLORD-SERVICE:8761/api/v1";
    private static final String USER_BASE_URL = "http://USER-SERVICE:9000/api/v1";
    private final RestTemplate restTemplate = new RestTemplate();


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
    public ResponseEntity<?> banTenantById(Long userId) {
        LOGGER.info("AdminServiceImpl > banTenantById started");
        LOGGER.info("AdminServiceImpl > banTenantById > userId : " + userId);

        String result = getRoleInfo();

        LOGGER.info("AdminServiceImpl > banTenantById > role result : " + result);

        if(result.equals("ROLE_ADMIN")){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity < String > entity = new HttpEntity < > (httpHeaders);
            return restTemplate.exchange(TENANT_BASE_URL + userId,
                                         HttpMethod.DELETE, entity, String.class);
        }

        return null;
    }

    @Override
    public ResponseEntity<?> banLandlordById(Long userId) {
        LOGGER.info("AdminServiceImpl > banLandlordById started");
        LOGGER.info("AdminServiceImpl > banLandlordById > userId : " + userId);

        String result = getRoleInfo();

        LOGGER.info("AdminServiceImpl > banLandlordById > role result : " + result);

        if(result.equals("ROLE_ADMIN")){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity < String > entity = new HttpEntity < > (httpHeaders);
            return restTemplate.exchange(LANDLORD_BASE_URL + userId,
                                         HttpMethod.DELETE, entity, String.class);
        }

        return null;
    }

    private String getRoleInfo() {

        LOGGER.info("AdminServiceImpl > getRoleInfo is started");

        String result = this.restTemplate.getForObject(USER_BASE_URL + "/info",String.class);

        LOGGER.info("AdminServiceImpl > getRoleInfo > role result : " + result);

        return result;
    }

}
