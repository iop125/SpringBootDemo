package com.example.demo02.service.impl;

import com.example.demo02.service.MessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMessageServiceImpl implements MessageService {
    @Override
    public String send() {
        System.out.println("-----DevMessageServiceImpl-------");
        return "dev";
    }
}
