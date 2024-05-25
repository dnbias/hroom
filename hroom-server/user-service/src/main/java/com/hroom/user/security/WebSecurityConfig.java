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
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**", "/api/v1/signup", "/api/v1/login", "/login/oauth/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin().disable()
            .oauth2Login(auth -> auth
                .loginPage("http://localhost:4200/home")
                .userInfoEndpoint()
                         .userService(oauthUserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request,
                                                            HttpServletResponse response,
                                                            Authentication authentication)
                                                     throws IOException, ServletException {

                            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
                            userService.processOAuthPostLogin(oauthUser.getEmail());
                            response.sendRedirect("http://localhost:4200/home");
                        }
                    })
            ).build();
    }

}
