package com.hyf.rxjava.test.second.math;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * count the number of items emitted by the source Observable and emit only this value
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Count {

    public static void main(String[] args) {
        Single<Long> count = Observable.just(1).count();
    }
}
