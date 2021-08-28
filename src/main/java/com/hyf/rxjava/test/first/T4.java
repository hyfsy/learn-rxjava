package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T4 {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> just = Observable.just("1", "2");
        just.startWithItem("0").forEach(System.out::println);

        Observable.just("1", "2").mergeWith(Observable.just("3"))
                .forEachWhile(s -> s.length() > 0,
                        e -> e.printStackTrace(),
                        () -> System.out.println("complete"));

        Observable<String> just1 = Observable.just("1", "2");
        Observable<Object> error = Observable.error(RuntimeException::new);
        Observable.mergeDelayError(just1, error)
                .subscribe(System.out::println,
                        e -> System.out.println(e.getMessage())); // 操作完毕才走onError


        just1.zipWith(just, (_1, _0) -> _1 + _0).subscribe(System.out::println);
        System.out.println("======");
        Observable<String> just2 = Observable.just("1");
        just1.zipWith(just2, (_1, _2) -> _1 + _2).subscribe(System.out::println);


        Observable<Observable<String>> map = Observable.interval(1, TimeUnit.SECONDS)
                .map(ticks ->
                        Observable.interval(100, TimeUnit.MILLISECONDS)
                                .map(innerTicks -> "Outer: " + ticks + ", Inner: " + innerTicks));
        map.subscribe(System.out::println);

        Observable.switchOnNext(map, 10).subscribe(System.out::println);

        Thread.currentThread().join();
    }
}
