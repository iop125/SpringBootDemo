package com.example.demo04.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource(value="classpath:coustom.properties",encoding = "utf-8")
@ConfigurationProperties("group")
@Data
public class GroupDTO {
    private List<Users> user;
    private List<Users> user1;
}
