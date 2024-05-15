package com.hroom.user.controller;

import com.hroom.user.dto.LoginRequest;
import com.hroom.user.dto.SignUpRequest;
import com.hroom.user.entity.User;
import com.hroom.user.exception.MissingUserException;
import com.hroom.user.service.KeycloakService;
import com.hroom.user.service.UserService;
import com.hroom.user.utils.UserContextHolder;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final UserService userService;
    private final KeycloakService keycloakService;

    // fetchall
    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody SignUpRequest signUpRequest){

        LOGGER.info("UserController | signUpUser is started");
        LOGGER.info("UserController | signUpUser | SignUpRequest role : " + signUpRequest.getRole());
        LOGGER.info("UserController | signUpUser | SignUpRequest email : " + signUpRequest.getEmail());
        LOGGER.info("UserController | signUpUser | SignUpRequest name : " + signUpRequest.getName());

        return ResponseEntity.ok(userService.signUpUser(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request){

        LOGGER.info("UserController | login is started");
        LOGGER.info("UserController | request: "+ request);

        // AccessTokenResponse accessTokenResponse =keycloakService.loginWithKeycloak(request);
        // if (accessTokenResponse == null){
        //     LOGGER.info("UserController | login | Http Status Bad Request");
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accessTokenResponse);
        // }
        User response;
        try {
            response = userService.login(request);
        } catch (MissingUserException e) {
            LOGGER.info("UserController | login | MissingUserException caught");
            return null;
        }

        LOGGER.info("UserController | login | Http Status Ok");

        return ResponseEntity.ok(response);
    }


    @GetMapping("/info/{username}")
    public ResponseEntity<String> infoUser(@PathVariable String username){

        LOGGER.info("UserController | infoUser is started");

        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // LOGGER.info("UserController | infoUser | auth toString : " + auth.toString());
        // LOGGER.info("UserController | infoUser | auth getPrincipal : " + auth.getPrincipal());

        // KeycloakPrincipal principal = (KeycloakPrincipal)auth.getPrincipal();
        // KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        // AccessToken accessToken = session.getToken();

        // String username = accessToken.getPreferredUsername();
        // String email = accessToken.getEmail();
        // String lastname = accessToken.getFamilyName();
        // String firstname = accessToken.getGivenName();
        // String realmName = accessToken.getIssuer();
        // AccessToken.Access access = accessToken.getRealmAccess();
        // Set<String> roles = access.getRoles();

        // String role = roles.stream()
        //         .filter(s -> s.equals("ROLE_USER") || s.equals("ROLE_ADMIN"))
        //         .findAny()
        //         .orElse("noElement");
        String info;
        try {
            info = userService.infoUser(username);
        } catch (MissingUserException e) {
            LOGGER.info("UserController | infoUser | MissingUserException caught");
            return null;
        }

        LOGGER.info("UserController | infoUser | user: "+username);
        LOGGER.info("UserController | infoUser | OK");

        return ResponseEntity.ok(info);
    }

    @GetMapping("/role/{username}")
    public ResponseEntity<String> roleUser(@PathVariable String username){

        LOGGER.info("UserController | roleUser is started");

        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // LOGGER.info("UserController | roleUser | auth toString : " + auth.toString());
        // LOGGER.info("UserController | roleUser | auth getPrincipal : " + auth.getPrincipal());

        // KeycloakPrincipal principal = (KeycloakPrincipal)auth.getPrincipal();
        // KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        // AccessToken accessToken = session.getToken();

        // String username = accessToken.getPreferredUsername();
        // AccessToken.Access access = accessToken.getRealmAccess();
        // Set<String> roles = access.getRoles();

        // String role = roles.stream()
        //         .filter(s -> s.equals("ROLE_USER") || s.equals("ROLE_ADMIN"))
        //         .findAny()
        //         .orElse("noElement");

        String role;
        try {
            role = userService.roleUser(username);
        } catch (MissingUserException e) {
            LOGGER.info("UserController > roleUser > MissingUserException caught");
            return null;
        }

        LOGGER.info("UserController | roleUser | username : " + username);
        LOGGER.info("UserController | roleUser | role : " + role);
        LOGGER.info("UserController | roleUser | OK");

        return ResponseEntity.ok(role);
    }

}
