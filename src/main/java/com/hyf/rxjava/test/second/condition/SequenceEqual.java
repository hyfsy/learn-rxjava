package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * determine whether two Observables emit the same sequence of items
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class SequenceEqual {

    public static void main(String[] args) {
        // 比较两个发射的项是否一致
        // 相同的项，顺序相同，终止状态相同
        Observable.sequenceEqual(Observable.just(1), Observable.just(2), Integer::equals, 2);
    }
}
