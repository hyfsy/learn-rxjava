package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

/**
 * apply a function to each item emitted by an Observable,
 * sequentially, and emit each successive value
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Scan {

    public static void main(String[] args) {
        Observable.just(1).scan(222, (store, i) -> store + i);
    }
}
