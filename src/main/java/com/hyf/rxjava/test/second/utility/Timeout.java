package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * mirror the source Observable, but issue an error notification
 * if a particular period of time elapses without any emitted items
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Timeout {

    public static void main(String[] args) {
        Observable.just(1).timeout(Observable.just(1),
                i -> Observable.timer(1, TimeUnit.SECONDS),
                Observable.just(999));
    }
}
