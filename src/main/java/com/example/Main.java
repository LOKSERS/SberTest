package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.example")
@EnableWebMvc
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.Repo")
public class Main {
    public static void main(String[] args) {

    }
}
