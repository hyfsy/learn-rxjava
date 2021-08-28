package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * do not create the Observable until the observer subscribes,
 * and create a fresh Observable for each observer
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Defer {

    public static void main(String[] args) {
        Observable<Long> defer = Observable.defer(() -> Observable.just(System.currentTimeMillis()));
        for (int i = 0; i < 5; i++) {
            defer.subscribe(System.out::println);
        }
    }
}
