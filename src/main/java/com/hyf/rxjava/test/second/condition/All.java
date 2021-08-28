package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * determine whether all items emitted by an Observable meet some criteria
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class All {

    public static void main(String[] args) {
        Single<Boolean> all = Observable.just(1).all(i -> i < 10);
    }
}
