package com.hyf.rxjava.test.second.math;

import io.reactivex.rxjava3.core.Observable;

/**
 * emit the emissions from two or more Observables without interleaving them
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class Concat {

    public static void main(String[] args) {
        // 后一个必须等待前一个完成
        // merge 并行合并
        Observable.concat(Observable.just(1), Observable.just(2));
    }
}
