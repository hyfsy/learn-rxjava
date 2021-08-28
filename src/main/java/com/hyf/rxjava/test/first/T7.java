package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T7 {

    public static void main(String[] args) throws InterruptedException {
        Observable.error(RuntimeException::new)
                .doOnError(Throwable::printStackTrace) // just invoke // first
                .onErrorComplete(e -> { // just swallow
                    boolean shouldSwallow = e instanceof IOException;
                    System.out.println(shouldSwallow);
                    return shouldSwallow;
                })
                .onErrorReturn(e -> e instanceof IOException ? 0 : new IllegalStateException())
                .onErrorReturnItem(1)
                .subscribe(System.out::println,
                        e -> System.out.println(e), // second
                        () -> System.out.println("complete"));


        Observable<Integer> complete = Observable.generate(() -> 1, (i, emitter) -> {
            emitter.onNext(i);
            return i++;
        }, i -> System.out.println("complete"));
        complete.scan(Math::multiplyExact)
                .onErrorResumeNext(e -> Observable.empty());
                // .subscribe(System.out::println);


        Observable<Long> longObservable = Observable.intervalRange(1, 100, 1, 1, TimeUnit.SECONDS)
                .flatMap(i -> i % 5 == 0 ? Observable.error(RuntimeException::new)
                        : Observable.just(i));
        LongAdder errorCount = new LongAdder();
        longObservable
                .retry((retryCount, e) -> retryCount < 3)
                .doOnError(e -> errorCount.increment())
                .retryUntil(() -> errorCount.intValue() > 3)
                .retryWhen(err -> err.map(e -> 1)
                        .scan(Math::addExact)
                        .doOnNext(count -> System.out.println("error no: " + count))
                        .takeWhile(count -> count < 3)
                        .flatMapSingle(count -> Single.timer(1, TimeUnit.SECONDS)))
                .subscribe(System.out::println, e -> System.out.println(e.getMessage()));

        Thread.currentThread().join();

    }
}
