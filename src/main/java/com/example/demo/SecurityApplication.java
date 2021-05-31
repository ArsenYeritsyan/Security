package com.example.demo;

import com.example.demo.configuration.JpaConfig;
import com.example.demo.jwt.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;


@SpringBootApplication
@EnableConfigurationProperties({JwtConfig.class})
public class SecurityApplication {

    public static void main(String[] args)  throws IOException {
        SpringApplication.run(SecurityApplication.class, args);

    }
}
