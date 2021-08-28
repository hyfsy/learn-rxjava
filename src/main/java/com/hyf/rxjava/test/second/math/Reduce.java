package com.hyf.rxjava.test.second.math;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

/**
 * apply a function to each item emitted by an Observable, sequentially, and emit the final value
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Reduce {

    public static void main(String[] args) {
        Observable.just(1, 2).reduce(0, (i, i2) -> i + i2);

        Observable.just(1).collect(() -> 0, (i, i2) -> Arrays.asList(i, i2));
    }
}
