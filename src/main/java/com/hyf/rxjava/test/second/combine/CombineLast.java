package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

/**
 * when an item is emitted by either of two Observables,
 * combine the latest item emitted by each Observable via a specified
 * function and emit items based on the results of this function
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class CombineLast {

    public static void main(String[] args) {
        Observable.combineLatest(Observable.just(1), Observable.just(2), Observable::just);
    }
}
