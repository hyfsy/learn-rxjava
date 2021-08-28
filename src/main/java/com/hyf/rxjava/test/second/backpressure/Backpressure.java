package com.hyf.rxjava.test.second.backpressure;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;

/**
 * strategies for coping with Observables that produce items more rapidly
 * than their observers consume them
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Backpressure {

    public static void main(String[] args) {
        Flowable<Integer> just = Flowable.just(1);
        just.onBackpressureBuffer(10, () -> System.out.println("overflow"),
                BackpressureOverflowStrategy.DROP_OLDEST);
        just.onBackpressureDrop(i -> System.out.println("drop: " + i)); // 保留第一个，后续一段时间的全部丢弃
        just.onBackpressureLatest(); // 保留一段时间的最后一个
        just.onBackpressureReduce(() -> 1, (i, i2) -> i + i2);
    }
}
