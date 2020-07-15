package com.example.demo10.stream.pub_mp_sub;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

//消息处理起
public class MessageProcessor extends SubmissionPublisher<String> implements Flow.Processor<Integer,String> {
    //声明订阅关系
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        ///保存传入的令牌
        this.subscription = subscription;
        //甚至一个请求所要订阅的消息数
        //背压策略在这里体现
        this.subscription.request(8);
    }

    @Override
    public void onNext(Integer item) {
        if(item>50){
            this.submit(item+" ---");
        }
        this.subscription.request(8);
    }


    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {

        System.out.println("令牌中消息处理完毕");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
