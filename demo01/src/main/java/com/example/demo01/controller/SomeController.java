package com.example.demo01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @GetMapping("/some")
    public String some(){
        return "Hello world";
    }
}
