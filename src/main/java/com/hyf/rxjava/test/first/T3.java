package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start ready");
        Observable<Long> timer = Observable.timer(3, TimeUnit.SECONDS);
        timer.blockingSubscribe( v -> System.out.println("is ready"));
        // Thread.currentThread().join();

        Observable<Object> empty = Observable.empty(); // 在信号源订阅后，立即完成
        empty.subscribe(System.out::println);

        // 不触发 onNext, onSuccess, onError or onComplete
        Observable<Object> never = Observable.never(); // 在测试或在组合运算符中“禁用”某些源时很有用
        never.subscribe(
                (s) -> System.out.println("never print"),
                e -> System.out.println("also"),
                () -> System.out.println("also"));

        Observable<Object> error = Observable.error(RuntimeException::new);
        error.subscribe((s) -> System.out.println("never print"));

        // use error
        Observable<String> observable = Observable.fromCallable(() -> {
            if (Math.random() < 0.5) {
                throw new IOException();
            }
            throw new IllegalArgumentException();
        });
        Observable<String> result = observable.onErrorResumeNext(e -> {
            if (e instanceof IllegalArgumentException) {
                return Observable.empty();
            }
            return Observable.error(e);
        });
    }
}
