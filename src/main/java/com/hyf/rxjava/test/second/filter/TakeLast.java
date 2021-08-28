package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * emit only the final n items emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class TakeLast {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.takeLast(2, TimeUnit.SECONDS, Schedulers.computation(), true, 1); // 只拿1个
    }
}
