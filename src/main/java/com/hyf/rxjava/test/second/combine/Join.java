package com.hyf.rxjava.test.second.combine;

import io.reactivex.rxjava3.core.Observable;

/**
 * combine items emitted by two Observables whenever an item from one Observable is emitted
 * during a time window defined according to an item emitted by the other Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Join {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just // 源源
                .join(Observable::just, // 接收源源，返回目标源
                        Observable::just, // 接收源源，控制与目标源组合的持续时间
                        Observable::just, // 接收目标源，控制与源源组合的持续时间
                        Observable::just); // 返回组合结果

        just.groupJoin(Observable.just("2"),
                i -> Observable.just(i),
                s -> Observable.just(s),
                (i, s) -> Observable.just(i, s));

    }
}
