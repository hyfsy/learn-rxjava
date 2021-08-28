package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * shift the emissions from an Observable forward in time by a particular amount
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Delay {

    public static void main(String[] args) {
        Observable.just(1).delay(i -> Observable.just(1), i -> Observable.timer(1, TimeUnit.SECONDS));
    }
}
