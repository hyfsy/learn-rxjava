package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author baB_hyf
 * @date 2021/06/01
 */
public class T13 {

    public static void main(String[] args) {
        System.out.println();

        Observable.just(1).lift(new MyOperator<>()); // 连接自定义的操作符
    }

    // Observable如果不是可变换的或反应源的，推荐使用create()方法，而不是试图实现Observable
    static class MyOperator<T> implements ObservableOperator<T, T> {

        @Override
        public @NonNull Observer<? super T> apply(@NonNull Observer<? super T> observer) throws Throwable {
            Observer<T> observer1 = new Observer<T>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    if (!d.isDisposed()) {
                        observer.onSubscribe(d);
                    }
                }

                @Override
                public void onNext(@NonNull T t) {
                    observer.onNext(t);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    observer.onError(e);
                }

                @Override
                public void onComplete() {
                    observer.onComplete();
                }
            };
            return observer1;
        }
    }
}
