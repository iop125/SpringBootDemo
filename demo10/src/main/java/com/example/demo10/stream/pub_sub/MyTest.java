package com.example.demo10.stream.pub_sub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class MyTest {

    public static void main(String[] args) {
        SubmissionPublisher<Integer> publisher = null;
        //定义发布者
        publisher = new SubmissionPublisher<>();
        //定义订阅者
        MySubscriber subscriber = new MySubscriber();
        //创建发布者和订阅者的订阅关系
        publisher.subscribe(subscriber);
        //生产消息发布
        for (int i = 0; i < 300; i++) {
            System.out.println("生产第"+i);
            publisher.submit(i);
        }
        publisher.close();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
