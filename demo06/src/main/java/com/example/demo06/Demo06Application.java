package com.example.demo06;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo06.dao")
public class Demo06Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo06Application.class, args);
    }

}
