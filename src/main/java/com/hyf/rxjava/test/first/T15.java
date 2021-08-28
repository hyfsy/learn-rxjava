package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author baB_hyf
 * @date 2021/06/03
 */
public class T15 {

    public static void main(String[] args) {
        // Subscriber
        Observable.just(1).
                subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("complete"));
    }
}
