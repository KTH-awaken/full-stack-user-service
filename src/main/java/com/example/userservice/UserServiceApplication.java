package com.example.userservice;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @PostConstruct
    public void logDataSourceUrl() {
        logger.info("Datasource URL: {}", datasourceUrl);
    }
}
