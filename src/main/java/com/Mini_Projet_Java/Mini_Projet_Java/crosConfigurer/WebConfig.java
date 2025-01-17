package com.Mini_Projet_Java.Mini_Projet_Java.crosConfigurer;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Permet tous les endpoints
                        .allowedOrigins("http://localhost:3000") // L'origine de votre application React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Les méthodes HTTP autorisées
                        .allowedHeaders("*") // Autorise tous les en-têtes
                        .allowCredentials(true); // Autorise l'envoi des cookies
            }
        };
    }

}

