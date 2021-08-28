package com.hyf.rxjava.test.second.errorhandler;

import io.reactivex.rxjava3.core.Observable;

/**
 * recover from an onError notification by continuing the sequence without error
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Catch {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.onErrorReturn(e -> 2);
        just.onErrorResumeWith(Observable.just(2));
    }
}
