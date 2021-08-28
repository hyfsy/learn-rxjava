package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

/**
 * convert an Observable that emits Observables into a single Observable that
 * emits the items emitted by the most-recently-emitted of those Observables
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Switch {

    public static void main(String[] args) {
        // 下此发射时，之前还处于发射中的会取消
        Observable.switchOnNext(Observable.just(Observable.just(1)));
    }
}
