package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.concurrent.CompletionStage;

/**emit only the first item (or the first item that meets some condition) emitted by an Observable
 * @author baB_hyf
 * @date 2021/06/02
 */
public class First {

    public static void main(String[] args) {
        Observable<Integer> just1 = Observable.just(1);
        Single<Integer> first = just1.first(1);
        // 条件singleOrDefault对于第一个不匹配的会抛异常
        Single<Integer> just = Single.just(1); // single找不到会抛异常，single会直到最后，first立马返回
        CompletionStage<Integer> integerCompletionStage = just1.firstStage(1);

        Integer integer = just.blockingGet();
    }
}
