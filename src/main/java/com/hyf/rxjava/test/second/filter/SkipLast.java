package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * suppress the final n items emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class SkipLast {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.skipLast(1, TimeUnit.SECONDS, true);
    }
}
