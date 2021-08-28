package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * only emit an item from an Observable if a particular timespan has
 * passed without it emitting another item
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Debounce {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.debounce(1, TimeUnit.SECONDS);
        just.throttleWithTimeout(1, TimeUnit.SECONDS); // 相同

    }
}
