package com.hyf.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/06/03
 */
public class RxJavaTest {

    public static void main(String[] args) throws InterruptedException {
        Observable.just(1, 2).
                subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("complete"));
        Observable.timer(1, TimeUnit.SECONDS, Schedulers.computation()).all(i -> i > 1)
        .subscribe(System.out::println);

        Thread.currentThread().join();
    }
}
