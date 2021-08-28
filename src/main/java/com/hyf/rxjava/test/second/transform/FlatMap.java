package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

/**
 * transform the items emitted by an Observable into Observables,
 * then flatten the emissions from those into a single Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class FlatMap {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.flatMap(i -> Observable.just(String.valueOf(i)), 8); // 运行交错，最大并发订阅数
        just.flatMap(i -> Observable.just(1), Observable::error, () -> Observable.just(1), 8);
        just.flatMap(i -> Observable.just(1), (i, i2) -> Observable.just(i, i2, i, i2), true, 8, 2);
        just.flatMapIterable(i -> Arrays.asList(i, i));

        just.concatMap(i -> Observable.just(i)); // 运行不会交错

        // 当源 Observable 发出一个新项时，它会取消订阅并停止镜像从先前发出的项生成的 Observable，而只开始镜像当前项。
        just.switchMap(i -> Observable.just(i), 2);
    }
}
