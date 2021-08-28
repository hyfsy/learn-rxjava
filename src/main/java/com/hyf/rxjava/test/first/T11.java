package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.functions.Function;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T11 {

    public static void main(String[] args) {
        Observable.range(1, 10).buffer(4)
                .subscribe(System.out::println); // 分三批输出

        // x的类型声明很有意思
        Observable.just(1, 1f, 1d, "1")
                .filter(x -> Integer.class.isInstance(x))
                .cast(Integer.class);

        // 01234
        Observable<Integer> integerObservable = Observable.range(0, 5).concatMap(i -> {
            long delay = Math.round(Math.random() * 2);
            return Observable.timer(delay, TimeUnit.SECONDS).map(n -> i);
        });
        integerObservable.subscribe(System.out::print);


        // 表示直接完成的操作
        Observable<Integer> just1 = Observable.just(1);
        Completable completable = just1
                .concatMapCompletable(i -> Completable.timer(1, TimeUnit.SECONDS)
                        .doOnComplete(() -> System.out.println("complete: " + i))); // 每个子项完成的操作
        completable.doOnComplete(() -> System.out.println("all complete")) // 所有子项完成的操作
                .blockingAwait(1, TimeUnit.SECONDS);

        Function f = i -> Observable.just(1);

        just1.concatMapDelayError(f); // 异常会在所有子项处理完毕后再抛出
        just1.concatMapEager(f); // concatMap类似，区别是传入的Function会提前计算完，而不是待订阅时再执行 // TODO ?
        just1.concatMapEagerDelayError(f, true); // 直到最后再抛异常，此处强制传入
        just1.concatMapIterable(i -> Arrays.asList(i, i, i));
        just1.concatMapMaybe(i -> Maybe.just(i));
        just1.concatMapMaybeDelayError(f);
        just1.concatMapSingle(f);
        just1.concatMapSingleDelayError(f);

        just1.flatMap(f);
        just1.flatMapCompletable(f);
        just1.flatMapIterable(i -> Arrays.asList(i, i));
        just1.flatMapMaybe(i -> Maybe.just(i));

        Maybe<Integer> just = Maybe.just(1);
        just.flatMapObservable(f);
        just.flatMapPublisher(i -> Flowable.just(1));

        // Maybe::flatMapSingle 如果Maybe为empty，则返回single会抛异常
        just1.flatMapSingle(i -> Single.timer(1, TimeUnit.SECONDS));
        // 转换 Maybe 和 Single
        just.flattenAsObservable(i -> Arrays.asList(i, i));
        just.flattenAsFlowable(i -> Arrays.asList(i, i));

        just1.groupBy(k -> String.valueOf(k).charAt(0), k -> k);

        just1.map(i -> i);
        just1.scan((sum, i) -> sum + i); // 扫描每一项，执行给定方法

        Observable.interval(0, 1, TimeUnit.SECONDS)
                .switchMap(i -> Observable.interval(0, 750, TimeUnit.MILLISECONDS).map(y -> i))
                .takeWhile(i -> i < 3)
                .blockingSubscribe(System.out::println); // TODO ? 001122

        // prints:
        // [1, 2]
        // [4, 5]
        // [7, 8]
        // [10]
        Observable.range(1, 5).window(2, 3) // 每个窗口总容量为三个，但内部只放两个对象
                .flatMapSingle(i -> i.map(String::valueOf)
                        .reduce(new StringJoiner(","), StringJoiner::add))
                .subscribe(System.out::println);
    }
}
