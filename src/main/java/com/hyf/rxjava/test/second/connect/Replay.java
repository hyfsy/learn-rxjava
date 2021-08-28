package com.hyf.rxjava.test.second.connect;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * ensure that all observers see the same sequence of emitted items,
 * even if they subscribe after the Observable has begun emitting items
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Replay {

    public static void main(String[] args) {
        Observable.just(1).replay(i -> Observable.just(1),
                1, TimeUnit.SECONDS, Schedulers.computation(),
                false); // 接收已经发射过的项，可配合 ConnectableObservable 使用
    }
}
