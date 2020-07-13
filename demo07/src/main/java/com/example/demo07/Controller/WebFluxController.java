package com.example.demo07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WebFluxController {
    @GetMapping("commonHandle")
    public String commonHandle() throws InterruptedException {
        System.out.println("commonHandle="+new Date().getTime());
        doSome();
        System.out.println("commonHandle="+new Date().getTime());
        return "commonHandle";
    }

    @GetMapping("monoHandle")
    public Mono<String> monoHandle() throws InterruptedException {
        //Mono 表示包含0或一个异步序列
        System.out.println("monoHandle="+new Date().getTime());
        Mono.fromSupplier(()->doSome());
        System.out.println("monoHandle="+new Date().getTime());

        return Mono.just("monoHandle");
    }

    @GetMapping("fluxHandle")
    public Flux<String> fluxHandle() {
        return Flux.just("monoHandle","-","|");
    }
    @GetMapping("fluxArrayHandle")
    public Flux<String> fluxArrayHandle() {
            String[] arr =new String[]{"123123","qweq","asd"};
        return Flux.fromArray(arr);
    }
    @GetMapping("fluxListHandle")
    public Flux<String> fluxListHandle() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return Flux.fromStream(list.stream());
    }
    @GetMapping("fluxListMethodHandle")
    public Flux<String> fluxListMethodHandle() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return Flux.fromStream(list.stream().map(i->doSome()));
    }
    @GetMapping("sse")
    public Flux<String> sse() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return Flux.fromStream(list.stream().map(i->doSome()));
    }
    private String doSome(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "000000";
    }

}
