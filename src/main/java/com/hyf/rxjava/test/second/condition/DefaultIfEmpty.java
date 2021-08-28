package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * emit items from the source Observable, or a default item if the source Observable emits nothing
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class DefaultIfEmpty {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.defaultIfEmpty(1);
        just.switchIfEmpty(Observable.just(2));
    }
}
