package com.example.demo12.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_student")//指定在mongodb中的表明，没有会自动生成
public class Student {
    @Id //会自动生成id
    private String id;
    private String name;
    private int age;
}