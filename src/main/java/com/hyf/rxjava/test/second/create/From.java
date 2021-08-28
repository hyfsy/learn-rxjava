package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * convert various other objects and data types into Observables
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class From {

    public static void main(String[] args) {
        Observable.fromPublisher(System.out::println);
    }
}
