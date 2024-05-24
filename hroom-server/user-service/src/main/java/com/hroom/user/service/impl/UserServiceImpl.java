package com.hroom.user.service.impl;

import com.hroom.user.convertor.UserMapper;
import com.hroom.user.dto.KeycloakUser;
import com.hroom.user.dto.LoginRequest;
import com.hroom.user.dto.SignUpRequest;
import com.hroom.user.entity.Admin;
import com.hroom.user.entity.Landlord;
import com.hroom.user.entity.Provider;
import com.hroom.user.entity.Tenant;
import com.hroom.user.entity.User;
import com.hroom.user.exception.MissingUserException;
import com.hroom.user.repository.UserRepository;
import com.hroom.user.service.KeycloakService;
import com.hroom.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private final UserRepository repository;
    // private final KeycloakService keycloakService;

    @Override
    public List<User> fetchUserList() {
        LOGGER.info("UserServiceImpl | fetchUserList is started");
        List<User> list = repository.findAll();
        LOGGER.info("UserServiceImpl | fetchUserList OK");
        return list;
    }

    @Override
    public User login(LoginRequest request) throws MissingUserException {
        LOGGER.info("UserServiceImpl | login is started");
        List<User> list = repository.findByUsername(request.getUsername());
        if (list.isEmpty()) {
            throw new MissingUserException(request.getUsername());
        }
        User response = list.get(0);
        LOGGER.info("UserServiceImpl | login OK");
        return response;
    }

    @Override
    public String signUpUser(SignUpRequest signUpRequest) {

        LOGGER.info("UserServiceImpl | signUpUser is started");

        // KeycloakUser keycloakUser = new KeycloakUser();
        // keycloakUser.setFirstName(signUpRequest.getName());
        // keycloakUser.setLastName(signUpRequest.getSurname());
        // keycloakUser.setEmail(signUpRequest.getEmail());
        // keycloakUser.setPassword(signUpRequest.getPassword());
        // keycloakUser.setRole(signUpRequest.getRole());
        // keycloakUser.setUsername(signUpRequest.getUsername());

        // int status = keycloakService.createUserWithKeycloak(keycloakUser);
        int status = 201;

        if(status == 201){

            LOGGER.info("UserServiceImpl | signUpUser | status : " + status);

            User signUpUser = UserMapper.signUpRequestToUser(signUpRequest);
            signUpUser.setCreatedAt(LocalDateTime.now());
            LOGGER.info("UserServiceImpl | signUpUser | user : " + signUpUser.getUsername());
            LOGGER.info("UserServiceImpl | signUpUser | password : " + signUpUser.getPassword());
            LOGGER.info("UserServiceImpl | signUpUser | name : " + signUpUser.getName());
            LOGGER.info("UserServiceImpl | signUpUser | surname : " + signUpUser.getSurname());
            LOGGER.info("UserServiceImpl | signUpUser | phone : " + signUpUser.getPhoneNumber());
            LOGGER.info("UserServiceImpl | signUpUser | email : " + signUpUser.getEmail());
            LOGGER.info("UserServiceImpl | signUpUser | timestamp : " + signUpUser.getCreatedAt());

            switch (signUpRequest.getRole()) {
                case "admin":
                    repository.save(new Admin(signUpUser));
                    break;
                case "tenant":
                    repository.save(new Tenant(signUpUser));
                    break;
                case "landlord":
                    repository.save(new Landlord(signUpUser));
                    break;
                default:
                    repository.save(new Tenant(signUpUser));
            }

            repository.save(signUpUser);

            return "Sign Up completed";
        }

        return "No Register";
    }

    @Override
    public String infoUser(String username) throws MissingUserException {
        LOGGER.info("UserServiceImpl | infoUser is started");
        List<User> list = repository.findByUsername(username);
        if (list.isEmpty()) {
            throw new MissingUserException(username);
        }
        User user = list.get(0);
        LOGGER.info("UserServiceImpl | infoUser OK");

        String response = user.getUsername() + ", " + user.getName() + ", " +
            user.getSurname();

        return response;
    }

    public String roleUser(String username) throws MissingUserException {
        LOGGER.info("UserServiceImpl | infoUser is started");
        List<User> list = repository.findByUsername(username);
        if (list.isEmpty()) {
            throw new MissingUserException(username);
        }
        User user = list.get(0);
        LOGGER.info("UserServiceImpl | infoUser OK");

        String response = user.getRole();

        return response;
    }

    @Override
    public void processOAuthPostLogin(String username) {
        List<User> existUser = repository.findByUsername(username);

        if (existUser.isEmpty()) {
            User newUser = new Tenant();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setCreatedAt(LocalDateTime.now());

            repository.save(newUser);
        }
    }

}
