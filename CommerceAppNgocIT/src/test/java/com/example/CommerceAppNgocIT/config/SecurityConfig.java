package com.example.CommerceAppNgocIT.config;

import com.example.CommerceAppNgocIT.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
                .csrf((csrf) -> {
                    try {
                        csrf.disable()
                                .authorizeHttpRequests((authz) -> authz
                                        .requestMatchers("/").permitAll()
                                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/api/user/**").hasRole("USER")
                                        .anyRequest().authenticated()
                                ).formLogin(login -> login.loginPage("/login").loginProcessingUrl("/login")
                                        .usernameParameter("username").passwordParameter("password")
                                        .defaultSuccessUrl("/admin", true));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        return http.build();
    }
    }


