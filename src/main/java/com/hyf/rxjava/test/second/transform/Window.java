package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * periodically subdivide items from an Observable into Observable windows and emit
 * these windows rather than emitting the items one at a time
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Window {

    // Window类似于 Buffer，但它不是从源 Observable 发射项目包，而是发射 Observables
    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.window(1, 2);
        just.window(o -> Observable.timer(1, TimeUnit.SECONDS),
                o -> Observable.timer(2, TimeUnit.SECONDS), 2);
    }
}
