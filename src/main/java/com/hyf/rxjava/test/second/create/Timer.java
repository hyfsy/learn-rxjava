package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * create an Observable that emits a particular item after a given delay
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Timer {

    public static void main(String[] args) {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(System.out::println); // TODO test get 0
    }
}
