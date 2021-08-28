package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * determine whether an Observable emits a particular item or not
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Contains {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        Single<Boolean> contains = just.contains(2);
        Single<Boolean> empty = just.isEmpty();
    }
}
