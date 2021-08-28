package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * create an Observable that emits a particular range of sequential integers
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Range {

    public static void main(String[] args) {
        Observable<Integer> range = Observable.range(2, 8); // 负数报错
    }
}
