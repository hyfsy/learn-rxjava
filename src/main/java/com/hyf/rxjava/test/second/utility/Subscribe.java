package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

/**
 * operate upon the emissions and notifications from an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Subscribe {

    public static void main(String[] args) {
        Observable.just(1).subscribe(System.out::println,
                Throwable::printStackTrace, System.out::println);
    }
}
