package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * create an Observable that emits a particular item
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Just {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
