package com.example.demo10.stream.pub_mp_sub;

import io.netty.channel.ChannelOutboundBuffer;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class MyTestMain {

    public static void main(String[] args) {
        //创建发布者
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        //定义订阅者
        NewSubscriber newSubscriber = new NewSubscriber();
        //创建处理器对消息进行转换
        MessageProcessor messageProcessor= new MessageProcessor();
        //创建发布者和消息处理器的订阅关系
        publisher.subscribe(messageProcessor);
        //创建消息处理器和订阅者的订阅关系
        messageProcessor.subscribe(newSubscriber);
        //生产消息发布
        for (int i = 0; i < 300; i++) {
            System.out.println("生产第"+i);
            publisher.submit(i);
        }
        publisher.close();
        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
