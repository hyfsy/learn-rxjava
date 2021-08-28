package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * create an Observable from scratch by means of a function
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Create {

    public static void main(String[] args) {
        Observable.create(emitter -> {
            try {
                if (!emitter.isDisposed()) { // unSubscribed
                    for (int i = 0; i < 10; i++) {
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                }
            } catch (Exception e) {
                emitter.onError(e);
            }
            // try {
            //     ObservableEmitter<Object> serialize = emitter.serialize();
            // } catch (Exception e) {
            //     emitter.tryOnError(e);
            //     emitter.onError(e);
            //     emitter.onComplete();
            // }
            // emitter.setCancellable(() -> System.out.println("canceled"));
            // emitter.setDisposable(new Disposable() {
            //     @Override
            //     public void dispose() {
            //         System.out.println("disposed");
            //     }
            //
            //     @Override
            //     public boolean isDisposed() {
            //         return true;
            //     }
            // });
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // default empty
            }

            @Override
            public void onNext(@NonNull Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });


    }
}
