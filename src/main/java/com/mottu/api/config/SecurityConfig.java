package com.mottu.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/**").permitAll()
                        .anyRequest().permitAll()
                )
                .headers(headers -> headers
                        .defaultsDisabled()
                        .cacheControl(cache -> {})  // opcional
                        .frameOptions(frame -> frame.disable()) // nova forma
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
