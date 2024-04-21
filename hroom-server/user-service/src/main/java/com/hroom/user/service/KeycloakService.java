package com.hroom.user.service;

import com.hroom.user.dto.KeycloakUser;
import com.hroom.user.dto.LoginRequest;
import org.keycloak.representations.AccessTokenResponse;

public interface KeycloakService {
    public AccessTokenResponse loginWithKeycloak(LoginRequest request);
    public int createUserWithKeycloak(KeycloakUser keycloakUser);
}
