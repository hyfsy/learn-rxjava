package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * emit only the first n items emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Take {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.take(1, TimeUnit.SECONDS);
    }
}
