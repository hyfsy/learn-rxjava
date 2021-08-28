package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/**
 * @author baB_hyf
 * @date 2021/06/03
 */
public class T14 {

    public static void main(String[] args) {
        RxJavaPlugins.setOnObservableSubscribe((ob, ob2) -> ob2);
    }
}
