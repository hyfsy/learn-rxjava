package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * discard any items emitted by an Observable after a second Observable emits an item or terminates
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class TakeUntil {

    public static void main(String[] args) {
        Observable.just(1).takeUntil(i -> i > 10);
    }
}
