package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T6 {

    public static void main(String[] args) throws InterruptedException {
        Observable firstMillion = Observable.range(1, 1000000)
                .sample(7, TimeUnit.MILLISECONDS); // TODO ?

        firstMillion.subscribe(next -> System.out.println("Subscriber #1: " + next), // onNext
                throwable -> System.out.println("Error: " + throwable), // onError
                () -> System.out.println("Sequence #1 complete") // onComplete
        );
        firstMillion.subscribe(next -> System.out.println("Subscriber #2: " + next), // onNext
                throwable -> System.out.println("Error: " + throwable), // onError
                () -> System.out.println("Sequence #2 complete") // onComplete
        );

        // Thread.currentThread().join();

        ConnectableObservable secondMillion = Observable.range(1, 1000000).sample(7, TimeUnit.MILLISECONDS).publish();
        secondMillion.subscribe(next -> System.out.println("Subscriber #1: " + next), // onNext
                throwable -> System.out.println("Error: " + throwable), // onError
                () -> System.out.println("Sequence #1 complete") // onComplete
        );
        secondMillion.subscribe(next -> System.out.println("Subscriber #2: " + next), // onNext
                throwable -> System.out.println("Error: " + throwable), // onError
                () -> System.out.println("Sequence #2 complete") // onComplete
        );
        secondMillion.connect(System.out::println);

    }
}
