package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

/**
 * transform the items emitted by an Observable by applying a function to each item
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Map {

    public static void main(String[] args) {
        Observable.just(1)
                .map(String::valueOf)
                .cast(String.class);
    }
}
