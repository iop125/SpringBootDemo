package com.example.demo06.demain;

import lombok.Data;

@Data
public class Employee {

    public Employee(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    private String userName;
    private String passWord;
}
