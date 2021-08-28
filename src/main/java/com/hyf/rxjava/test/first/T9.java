package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T9 {

    public static void main(String[] args) {
        Observable<Integer> just1 = Observable.just(1);
        Observable<Integer> cache = just1.cache();
        Observable<Notification<Integer>> materialize = just1.materialize();
        Observable<Integer> serialize = just1.serialize();
        just1.doFinally(() -> System.out.println("finally"));
        Observable<Integer> repeat = just1.repeat(1); // 重复执行Observable的方法

        Flowable.bufferSize(); // prefetch
        ParallelFlowable<Integer> parallel = Flowable.range(1, 10).parallel(8, 10); // 8并行度 每次取10个
        parallel.runOn(Schedulers.io()); // 多种场景的调度支持，如IO/CPU计算等
        parallel.sequential();

        Observable.using(() -> 1, i -> Observable.just(i), i -> i = null, false);
    }
}
