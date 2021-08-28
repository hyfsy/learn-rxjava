package com.hyf.rxjava.test.second.connect;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

/**
 * instruct a connectable Observable to begin emitting items to its subscribers
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Connect {

    public static void main(String[] args) {
        ConnectableObservable<Integer> publish = Observable.just(1).publish();
        publish.subscribe();
        publish.connect(d -> System.out.println("disposed")); // 开始发射项
        publish.reset();
    }
}
