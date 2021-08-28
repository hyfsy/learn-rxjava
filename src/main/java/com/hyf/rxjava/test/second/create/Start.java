package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * create an Observable that emits the return value of a function-like directive
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Start {

    public static void main(String[] args) {
        Observable.defer(() -> Observable.fromFuture(null));
        Observable.fromAction(System.out::println);
        Observable.fromRunnable(System.out::println);
        Observable.fromCallable(() -> 1);
    }
}
