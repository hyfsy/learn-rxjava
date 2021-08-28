package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * discard items emitted by an Observable until a second Observable emits an item
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class SkipUntil {

    public static void main(String[] args) {
        // 丢弃直到Observable发射
        Observable.just(1).skipUntil(Observable.just(1).delay(1, TimeUnit.SECONDS));
    }
}
