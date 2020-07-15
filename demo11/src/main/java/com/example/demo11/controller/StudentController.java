package com.example.demo11.controller;

import com.example.demo11.bean.Student;
import com.example.demo11.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import java.awt.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentRepository studentRepository;
    //一次行返回数据
    @GetMapping("/all")
    public Flux<Student> getAll(){
        return studentRepository.findAll();
    }
    //sse实时返回数据
    @GetMapping(value = "/sse/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAllSSE(){
        return studentRepository.findAll();
    }
}
