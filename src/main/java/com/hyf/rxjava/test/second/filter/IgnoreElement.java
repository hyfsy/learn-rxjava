package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

/**
 * do not emit any items from an Observable but mirror its termination notification
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class IgnoreElement {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        Completable completable = just.ignoreElements(); // 调用 onError / onCompletion
    }
}
