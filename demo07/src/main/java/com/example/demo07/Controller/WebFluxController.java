package com.example.demo07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;

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
    private String doSome(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "000000";
    }

}
