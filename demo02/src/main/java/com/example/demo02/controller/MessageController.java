package com.example.demo02.controller;

import com.example.demo02.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {
    @Resource
    private MessageService messageService;
    @GetMapping("/send")
    public String msgSend(){
        return messageService.send();
    }
}
