package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * create an Observable that emits a particular item multiple times
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Repeat {

    public static void main(String[] args) {
        Observable<Integer> repeat = Observable.just(1).repeat(2);
    }
}
