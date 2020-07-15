package com.example.demo11.repository;

import com.example.demo11.bean.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//第一个范型是该repository处理的对象
//第二个是操作对象主键的类型
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {
}
