package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

/**
 * combine the emissions of multiple Observables together via a specified
 * function and emit single items for each combination based on the results of this function
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Zip {

    public static void main(String[] args) {
        Observable.zip(Observable.just(1), Observable.just("2"), (i, s) -> s + i);
        Observable.just(1).zipWith(Observable.just("2"), (i, s) -> s + i);
    }
}
