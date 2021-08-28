package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * specify the Scheduler on which an observer will observe this Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class ObserveOn {

    // 默认情况下，一个 Observable 和Operator链将在调用Subscribe的方法的同一个线程上执行。
    public static void main(String[] args) {
        // 切换操作运行的线程
        // 切换观察者观察的线程
        Observable<Integer> just = Observable.just(1);
        just.observeOn(Schedulers.computation(), true, 2);
    }
}
