package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * create an Observable that emits a sequence of integers spaced by a given time interval
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Interval {

    public static void main(String[] args) {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS); // 周期
        Observable.timer(1, TimeUnit.SECONDS); // 延迟
    }
}
