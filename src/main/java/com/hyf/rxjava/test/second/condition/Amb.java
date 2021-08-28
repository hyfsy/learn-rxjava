package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * given two or more source Observables, emit all of the items from only
 * the first of these Observables to emit an item or notification
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Amb {

    public static void main(String[] args) {
        // 选择第一个发射的Observable发射，剩下的丢弃
        Observable.just(1).ambWith(Observable.just(2));
    }
}
