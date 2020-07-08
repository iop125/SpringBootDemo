package com.example.demo04.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:coustom.properties",encoding = "utf-8")
@ConfigurationProperties("student")
@Data
public class StudentDTO {
    private String name;
    private int age;
    private double score;
}
