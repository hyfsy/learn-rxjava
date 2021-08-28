package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class Hello {

    public static void main(String[] args) {
        int i = Observable.bufferSize();
        System.out.println(i);
    }
}
