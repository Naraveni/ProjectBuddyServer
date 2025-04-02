package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityConfig loaded: Permitting /api/email/send");
        http
            .csrf().disable() // Disable CSRF for simplicity (re-enable in production if needed)
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/email/send").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }
}