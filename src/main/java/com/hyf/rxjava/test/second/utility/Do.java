package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

/**
 * register an action to take upon a variety of Observable lifecycle events
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Do {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.doOnEach(i -> System.out.println(i.getValue()));
        just.doOnSubscribe(System.out::println); // 每当观察者预订所得可观察时将被调用
        just.doOnError(Throwable::printStackTrace);
        just.doOnNext(System.out::println);
        just.doOnComplete(() -> System.out.println("complete"));
        just.doOnTerminate(() -> System.out.println("real complete"));
        just.doOnDispose(() -> System.out.println("dispose"));
        just.doOnLifecycle(d -> System.out.println("onSubscribe"), () -> System.out.println("dispose"));
    }
}
