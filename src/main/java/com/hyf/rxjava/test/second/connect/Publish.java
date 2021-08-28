package com.hyf.rxjava.test.second.connect;

import io.reactivex.rxjava3.core.Observable;

/**
 * convert an ordinary Observable into a connectable Observable
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Publish {

    public static void main(String[] args) {
        // publish主要用来转换 ConnectableObservable
        Observable.just(1).publish(i -> Observable.just(i, 2)); // 改变项
    }
}
