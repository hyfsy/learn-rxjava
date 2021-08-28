package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

/**
 * emit only item n emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class ElementAt {

    public static void main(String[] args) {
        Observable.just(1).elementAt(1, 999);
    }
}
