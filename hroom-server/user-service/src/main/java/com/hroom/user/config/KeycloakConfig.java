package com.hroom.user.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    public final static String serverUrl = "http://localhost:8181";
    public final static String realm = "master";
    public final static String clientId = "user-service";
    public final static String clientSecret = "gu9zs4xMmGpuWcnppL6ThQdwSGbqCest";
    final static String userName = "admin";
    final static String password = "admin";

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public Keycloak keycloak(){
          return Keycloak.getInstance(serverUrl,
                realm,
                userName,
                password,
                clientId,
                clientSecret);
    }
}
