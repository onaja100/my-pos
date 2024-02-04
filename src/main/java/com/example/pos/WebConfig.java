package com.example.pos;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Specify the domain of your frontend app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // You can customize the methods
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}