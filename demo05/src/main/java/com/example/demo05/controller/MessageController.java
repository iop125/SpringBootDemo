package com.example.demo05.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/getJsp")
    public String getJsp(){
    return "we";
    }

}
