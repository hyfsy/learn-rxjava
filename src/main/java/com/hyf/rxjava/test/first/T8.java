package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T8 {

    public static void main(String[] args) throws InterruptedException {
        Observable<Object> objectObservable = Observable.create(emitter -> {
            emitter.onNext("A");
            Thread.sleep(1_500);

            // ---

            emitter.onNext("B");
            Thread.sleep(500);

            emitter.onNext("C");
            Thread.sleep(250);

            emitter.onNext("D");

            // ---

            Thread.sleep(2000); // 中间的1秒不会输出D（和sample的区别）

            emitter.onNext("E");
        });
        objectObservable.subscribeOn(Schedulers.io())
                .debounce(1, TimeUnit.SECONDS) // 每次1秒的防抖动，多次到时只算1次
                .subscribe(System.out::println); // ADE


        Observable<Object> objectObservable2 = Observable.create(emitter -> {
            emitter.onNext("A");

            // ---

            Thread.sleep(500);
            emitter.onNext("B");

            Thread.sleep(200);
            emitter.onNext("C");

            // ---

            Thread.sleep(800);
            emitter.onNext("D");

            // ---

            Thread.sleep(600);
            emitter.onNext("E");
        });
        objectObservable.subscribeOn(Schedulers.io())
                .sample(1, TimeUnit.SECONDS) // 每秒抽样（最近的值）
                .subscribe(System.out::println); // CD


        Observable<Object> objectObservable3 = Observable.create(emitter -> {

            // ---

            emitter.onNext("A");

            Thread.sleep(500);
            emitter.onNext("B");

            Thread.sleep(200);
            emitter.onNext("C");

            // ---

            Thread.sleep(800);
            emitter.onNext("D");

            Thread.sleep(600);
            emitter.onNext("E");
        });
        objectObservable.subscribeOn(Schedulers.io())
                .throttleFirst(1, TimeUnit.SECONDS) // 节流
                .throttleLast(1, TimeUnit.SECONDS) // CD
                .throttleLatest(1, TimeUnit.SECONDS) // ACD
                .throttleWithTimeout(1, TimeUnit.SECONDS) // same as debounce
                .subscribe(System.out::println); // AD


        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("A");

            Thread.sleep(800);
            emitter.onNext("B");

            Thread.sleep(400);
            emitter.onNext("C");

            Thread.sleep(1200); // 超时，报错TimeoutException
            emitter.onNext("D");
            emitter.onComplete();
        });

        source.timeout(1, TimeUnit.SECONDS)
                .subscribe(item -> System.out.println("onNext: " + item), // ABC
                        error -> System.out.println("onError: " + error),
                        () -> System.out.println("onComplete will not be printed!"));


        Observable<Integer> just = Observable.just(1, 1, 2, 3, 2, 2);
        just.distinct()
                .distinctUntilChanged() // 对第一个值去重，知道后面的值不相同
                .subscribe(System.out::println);


        Observable<Integer> just1 = Observable.just(1);

        Maybe<Integer> integerMaybe = Observable.just(1, 2, 3).elementAt(1);
        integerMaybe.subscribe(System.out::println);
        just1.elementAt(1, 999);
        just1.elementAtOrError(1).onErrorComplete();
        just1.filter(i -> i < 99);

        Single<Integer> first = just1.first(999);
        Maybe<Integer> integerMaybe1 = just1.firstElement(); // 返回值区别
        just1.firstOrError().onErrorComplete();

        Single<Long> timer = Single.timer(1, TimeUnit.SECONDS);
        Completable completable = timer.ignoreElement();
        completable.doOnComplete(() -> System.out.println("complete")).blockingAwait(1, TimeUnit.SECONDS);

        Completable completable1 = just1.ignoreElements();

        just1.last(999);
        just1.lastElement();
        just1.lastOrError().onErrorComplete();

        Observable.just(1, "2", 3f, 4d).ofType(Integer.class).subscribe(System.out::println);

        Observable.just(3, 2, 1, 2, 3)
                .skip(2)
                .skipLast(1)
                .skip(1, TimeUnit.SECONDS)
                .skipWhile(i -> i < 6)
                .skipUntil(Observable.empty()) // until observable complete
                .take(5)
                .takeLast(5)
        .subscribe();

        Thread.currentThread().join();
    }
}
