package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

/**
 * suppress duplicate items emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Distinct {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.distinct();
        just.distinct(i -> i.hashCode(), ArrayList::new);
        just.distinctUntilChanged();
    }
}
