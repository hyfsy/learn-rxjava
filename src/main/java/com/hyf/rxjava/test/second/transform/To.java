package com.hyf.rxjava.test.second.transform;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableIterable;

import java.util.Iterator;

/**
 * convert an Observable into another object or data structure
 *
 * @author baB_hyf
 * @date 2021/06/03
 */
public class To {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        just.toMap(i -> i);
        just.toMultimap(i -> i);
        just.toSortedList();
        just.toFuture();
        just.toList();
        just.toFlowable(BackpressureStrategy.BUFFER);

        BlockingObservableIterable<Object> objects =
                new BlockingObservableIterable<>(Observable.just(1), 8);
        Iterator<Object> iterator = objects.iterator();

    }
}
