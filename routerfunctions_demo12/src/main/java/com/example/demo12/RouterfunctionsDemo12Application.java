package com.example.demo12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class RouterfunctionsDemo12Application {

    public static void main(String[] args) {
        SpringApplication.run(RouterfunctionsDemo12Application.class, args);
    }

}
