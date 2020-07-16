package com.example.demo11.controller;

import com.example.demo11.bean.ResponseEntity;
import com.example.demo11.bean.Student;
import com.example.demo11.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

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

    @PostMapping(value = "/save")
    public Mono<Student> save(){
        return studentRepository.save(new Student());
    }

    //无状态删除
    @DeleteMapping(value = "/del")
    public Mono<Void> del(){
        return studentRepository.deleteById("");
    }
    //有状态删除
    //ResponseEntity 可以封装响应体中所携带的数据及响应码，其泛型用于指定携带数据的
    //类型。若响应体中没有携带数据，则泛型为 Void。本例中要返回的 ResponseEntity 中仅 封装了响应码不携带任何数据，所以泛型为 Void。
    // 响应码只能采用 HttpStatus 枚举类型 常量表示，这是 ResponseEntity 的构造器所要求的。
    //为什么做映射时使用 flatMap()，不使用 map()?首先这两个方法都是 Mono 的方法，不 是 Stream 的方法，与 Stream 的两个同名方法无关，但均是做映射的。
    // 若需要对对象数 据先执行操作后再做映射，则使用 flatMap();若纯粹是一种数据映射，没有数据操作， 则使用 map()。
    // 在 Mono 的访求中，对于没有返回值的方法，若想为其添加返回值，则可链式调用 then()
    //方法，由 then()方法返回想返回的值。对于本例，由于 Spring-Data-JPA 的 delete()方法没
    //有返回值，所以这里使用 then()为其添加返回值。
    @DeleteMapping(value = "/delStauts")
    public Mono<ResponseEntity<Void>> delStauts(){
         Mono<Void>  m = studentRepository.findById("").flatMap(stu->studentRepository.deleteById(stu.getId()));
              return  m.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(value = "/update")
    public Mono<ResponseEntity<Student>> update(){
        //map 转换数据参数
        return studentRepository.findById("").flatMap(stu->studentRepository.save(stu)).map(stu->new ResponseEntity<Student>(HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<Student>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(value = "/age/{below}/{top}")
    public Flux<Student> findByAge(@PathVariable("below") int below,@PathVariable("top") int top){
        //map 转换数据参数
        return studentRepository.findByAgeBetween(below,top);
    }
}
