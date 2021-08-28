package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;

/**
 * represent both the items emitted and the notifications sent as emitted items, or reverse this process
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Materialize {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        // 将onComplete具象化，用Notification包装，并作为一个Observable发射
        Observable<Notification<Integer>> materialize = just.materialize();
        materialize.dematerialize(ni -> Notification.createOnNext(ni.getValue()));

    }
}
