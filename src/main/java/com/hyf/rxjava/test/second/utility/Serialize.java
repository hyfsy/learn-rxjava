package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

/**
 * force an Observable to make serialized calls and to be well-behaved
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Serialize {

    public static void main(String[] args) {
        // 多个线程的异步发射改为同步发射，防止违反Observable Contract（onComplete/onError）
        Observable<Integer> serialize = Observable.just(1).serialize();
    }
}
