package com.example.demo10.stream.pub_mp_sub;


import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

//定义订阅者
public class NewSubscriber implements Flow.Subscriber<String> {
    //声明订阅关系
    private Flow.Subscription subscription;
    //当订阅关系建立时该方法会被发布者自动调用
    //发布者会将订阅令牌传入
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        ///保存传入的令牌
        this.subscription = subscription;
        //甚至一个请求所要订阅的消息数
        //背压策略在这里体现
        this.subscription.request(10);
    }
    //订阅者每接收一次订阅消息数据时，该方法会被发布者自动调用一次
    @Override
    public void onNext(String item) {
        System.out.println("消息为="+item);
        try {
            TimeUnit.MILLISECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置再次请求所要订阅消息的数量
        this.subscription.request(10);
        if(false){//满足条件了取消订阅不再接收消息
            this.subscription.cancel();
        }
    }
    //订阅、消费过程中出现异常时该方法会被发布者自动调用
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        this.subscription.cancel();
    }
    //当令牌的所有消息全部正常处理完毕后调用
    @Override
    public void onComplete() {
        System.out.println("令牌的所有消息全部正常处理完毕后=");

    }
}
