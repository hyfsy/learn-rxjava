package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

/**
 * combine multiple Observables into one by merging their emissions
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Merge {

    public static void main(String[] args) {
        Observable.merge(Observable.fromIterable(Arrays.asList()));
        Observable.just(1).mergeWith(Observable.just(2));
        Observable.mergeDelayError(Observable.just(1), Observable.error(RuntimeException::new));
    }
}
