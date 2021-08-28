package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;

/**
 * emit only those items from an Observable that pass a predicate test
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Filter {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.filter(i -> false);
        just.ofType(Integer.class); // 过滤类型
    }
}
