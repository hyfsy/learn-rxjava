package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

/**
 * divide an Observable into a set of Observables that each emit a different
 * subset of items from the original Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class GroupBy {

    public static void main(String[] args) {
        Observable.just(1).groupBy(i -> String.valueOf(i), i -> i, true, 2);
    }
}
