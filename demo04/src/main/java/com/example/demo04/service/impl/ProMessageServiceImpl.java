package com.example.demo04.service.impl;

import com.example.demo04.service.MessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ProMessageServiceImpl implements MessageService {
    @Override
    public String send() {
        System.out.println("-----ProMessageServiceImpl-------");return "pro";
    }
}
