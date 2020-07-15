package com.example.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories//开启mongodb
@SpringBootApplication
public class Demo11Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo11Application.class, args);
    }

}
