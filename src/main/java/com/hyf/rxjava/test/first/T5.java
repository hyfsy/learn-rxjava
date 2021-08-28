package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T5 {

    public static void main(String[] args) {
        Observable<Object> error = Observable.error(RuntimeException::new);
        Observable<Integer> range = Observable.range(0, 5);
        Observable<Integer> range1 = Observable.range(6, 5);
        Observable.amb(Arrays.asList(range, error, range1)).subscribe(System.out::println); // TODO ?

        Observable.empty().defaultIfEmpty(1).blockingSubscribe(System.out::println);


        Single<Boolean> all = Flowable.range(0, 10).doOnNext(i -> System.out.println(i))
                .all(i -> i < 10)
                .contains(6);
        all.blockingSubscribe(success -> System.out.println(success));

        Flowable<Integer> integerFlowable = Flowable.range(1, 5).doOnNext(i -> System.out.println("flow1: " + i));
        Flowable<Integer> integerFlowable1 = Flowable.range(1, 5).doOnNext(i -> System.out.println("flow2: " + i));
        // 序列相等
        Flowable.sequenceEqual(Flowable.fromPublisher(integerFlowable), Flowable.fromPublisher(integerFlowable1))
                .subscribe(success -> System.out.println(success));

        Observable.range(1, 10).doOnNext(next -> Thread.sleep(1000))
                .skipUntil(Observable.timer(3, TimeUnit.SECONDS))
                .skipWhile(i -> i % 3 == 0) // 指定的条件为false，就停止所有后续
                .takeUntil(i -> i > 8)
                .takeWhile(i -> i <= 8)
                .subscribe(System.out::println);

    }
}
