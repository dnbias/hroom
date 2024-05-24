package com.hroom.user.security;

import java.io.IOException;

import com.hroom.user.entity.CustomOAuth2User;
import com.hroom.user.service.CustomOAuth2UserService;
import com.hroom.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Autowired
    private UserService userService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http)
                                                       throws Exception {
        return http
            .cors(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/signup", "/login", "/oauth/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(auth -> auth
                .loginPage("/login")
                .userInfoEndpoint(endpoint -> endpoint
                    .userService(oauthUserService)
                )
                .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request,
                                                            HttpServletResponse response,
                                                            Authentication authentication)
                                                     throws IOException, ServletException {

                            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
                            userService.processOAuthPostLogin(oauthUser.getEmail());
                            response.sendRedirect("/list");
                        }
                    })
            )
            .formLogin(auth -> auth
                .permitAll()
            ).build();
    }

}
