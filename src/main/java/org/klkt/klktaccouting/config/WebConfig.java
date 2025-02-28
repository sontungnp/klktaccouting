package org.klkt.klktaccouting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Cho phép tất cả các endpoint
                .allowedOrigins("http://localhost:9527")  // Thay bằng URL của ứng dụng Vue.js
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Các phương thức cho phép
                .allowedHeaders("*")  // Cho phép tất cả các header
                .allowCredentials(true);
    }
}