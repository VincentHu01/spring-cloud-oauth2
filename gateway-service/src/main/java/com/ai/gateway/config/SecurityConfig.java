package com.ai.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    //security的鉴权排除列表
    private static final String[] excludedAuthPages = {
            "/login",
            "/logout",
            "/home/**",
            "/user/**",
            "/category/**",
            "/uaa/**",
            "/order/**"
    };

    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll();  //无需进行权限过滤的请求路径

        http.csrf().disable();

        return http.build();
    }
}
