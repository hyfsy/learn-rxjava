package com.hyf.rxjava.test.second.errorhandler;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * if a source Observable emits an error, resubscribe to it in the hopes that it will complete without error
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Retry {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.retry(2, e -> e instanceof RuntimeException);
        just.retryWhen(oe -> Observable.timer(1, TimeUnit.SECONDS)); // 超出周期停止重试
    }
}
