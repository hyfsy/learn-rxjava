package com.hyf.rxjava.test.second.connect;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * make a Connectable Observable behave like an ordinary Observable
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class RefCount {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        ConnectableObservable<Integer> publish = just.publish();
        // 还原 Observable
        Observable<Integer> integerObservable = publish.refCount(9, 1, TimeUnit.SECONDS);

        Observable<Integer> share = Observable.just(1).share();// 两步操作结合
    }
}
