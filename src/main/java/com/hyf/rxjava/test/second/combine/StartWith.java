package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

/**
 * emit a specified sequence of items before beginning to emit the items from the source Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class StartWith {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(2);
        just.startWith(Observable.just(1));
        just.concatWith(Observable.just(3));

    }
}
