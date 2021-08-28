package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Timed;

import java.util.concurrent.TimeUnit;

/**
 * attach a timestamp to each item emitted by an Observable indicating when it was emitted
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Timestamp {

    public static void main(String[] args) {
        // 记录发射项的时间
        Observable<Timed<Integer>> timestamp = Observable.just(1).timestamp(TimeUnit.SECONDS);
    }
}
