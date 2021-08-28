package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Cancellable;

import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T2 {

    public static void main(String[] args) throws InterruptedException {

        // 连接非响应式编程的对象
        FlowableOnSubscribe onSubscribe = emitter -> {
            emitter.onNext("1");
            emitter.onNext("2");
            emitter.onComplete();
            Cancellable cancellable = () -> {
                emitter.onNext("3");
                emitter.onNext("4");
            };
            emitter.setCancellable(cancellable);
        };

        // 当用户提供的函数生成的项超过下游消费者的请求时，还必须指定应用的反压力行为（背压）
        Flowable.create(onSubscribe, BackpressureStrategy.DROP); // 提供背压行为，Observable不需要


        Observable<Long> defer = Observable.defer(() -> { // 用户实际使用时再创建
            long l = System.currentTimeMillis();
            return Observable.just(l);
        });
        defer.subscribe(System.out::println);
        Thread.sleep(1000);
        defer.subscribe(System.out::println);

        String s = "123456";
        Observable<Integer> range = Observable.range(1, 4);
        Observable<Character> map = range.map(i -> s.charAt(i));
        map.subscribe(System.out::println);

        // 0 开始，周期生成
        Observable<Long> interval = Observable.interval(1, 1, TimeUnit.SECONDS);
        interval.subscribe(time -> {
            System.out.println(time);
        });
        Thread.currentThread().join();

    }
}
