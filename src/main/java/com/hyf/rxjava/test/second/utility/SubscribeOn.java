package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * specify the Scheduler on which an Observable will operate
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class SubscribeOn {

    public static void main(String[] args) {
        Observable.just(1).subscribeOn(Schedulers.computation()); // 指定观察者开始运行的线程
    }
}
