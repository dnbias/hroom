package com.hroom.user.service;

import com.hroom.user.dto.LoginRequest;
import com.hroom.user.dto.SignUpRequest;
import com.hroom.user.entity.User;
import com.hroom.user.exception.MissingUserException;

public interface UserService {
    public String signUpUser(SignUpRequest signUpRequest);
    public User login(LoginRequest request) throws MissingUserException;
    public String infoUser(String username) throws MissingUserException;
    public String roleUser(String username) throws MissingUserException;
}
