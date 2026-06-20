package com.richa.aimockinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.richa.aimockinterview.repository")
public class AimockinterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimockinterviewApplication.class, args);
    }
}