package com.example.demo12.repository;

import com.example.demo12.bean.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

//第一个范型是该repository处理的对象
//第二个是操作对象主键的类型
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {
    /**
     * 根据年龄上下线查询
     * @param below
     * @param top
     * @return
     */
    Flux<Student> findByAgeBetween(int below ,int top);
}
