package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * emit the most recent items emitted by an Observable within periodic time intervals
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Sample {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.sample(1, TimeUnit.SECONDS, Schedulers.computation(), false);
        just.sample(Observable.timer(1, TimeUnit.SECONDS)); // 按照Observable没发射一次，采样一次

        just.throttleLast(1, TimeUnit.SECONDS);
    }
}
