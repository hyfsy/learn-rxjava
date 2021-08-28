package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Buffer {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5);
        just.buffer(2, 3); // 12 45
        just.buffer(o -> o.onComplete());
        just.buffer(1, 2, TimeUnit.SECONDS);
    }
}
