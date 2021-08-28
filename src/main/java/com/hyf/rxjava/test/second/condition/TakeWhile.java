package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * mirror items emitted by an Observable until a specified condition becomes false
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class TakeWhile {

    public static void main(String[] args) {
        Observable.just(1).takeWhile(i -> i > 10);
    }
}
