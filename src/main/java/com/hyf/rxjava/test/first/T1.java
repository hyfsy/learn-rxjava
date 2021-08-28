package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T1 {

    public static void main(String[] args) {

        args = new String[]{"1", "2"};
        Flowable<String> stringFlowable = Flowable.fromArray(args);
        Disposable subscribe = stringFlowable.subscribe();
        System.out.println(subscribe.isDisposed());
        Flowable.fromArray(args).subscribe(s -> System.out.println("Hello " + s + "!"));

        Observable<String> just = Observable.just("1", "2");
        ArrayList<Object> objects = new ArrayList<>();
        Observable<Object> objectObservable = Observable.fromIterable(objects);
        // Observable 的每次转换会调用 onNext ，完成操作会调用 onComplete

        Observable<Object> objectObservable1 = Observable.create(onSubscribe -> {
            // sync执行，async需要另开线程
            for (int i = 0; i < 10; i++) {
                if (!onSubscribe.isDisposed()) {
                    onSubscribe.onNext(i);
                }
            }
            if (!onSubscribe.isDisposed()) {
                onSubscribe.onComplete();
            }
        });
        Disposable subscribe1 = objectObservable1.subscribe(System.out::println);

        objectObservable1.skip(2).take(5).map(String::valueOf).subscribe(System.out::println);

        Observable<Object> error = Observable.error(() -> new RuntimeException());
        // objectObservable1.onErrorResumeNext(RuntimeException::new).onErrorReturn("xxx"); // 错误回退

        // Observable 数据源、生产者
        // Subscriber 执行操作、消费者
        objectObservable1.subscribe(
                System.out::println, // onNext
                e -> System.out.println(e), // onError
                () -> System.out.println("finish")); // onComplete

        Flowable.just("1");
        Maybe.just("1");
        Single.just("1");
        Completable.complete();

        Observable.fromArray(args);
        Observable.fromCallable(() -> 1);
        Action action = () -> System.out.println(1); // 和Runnable的区别是Action可以抛出异常
        Runnable runnable = () -> System.out.println(1);
        Callable callable = () -> {
            Thread.sleep(2000);
            return 1;
        };
        Consumer consumer = System.out::println;
        Observable<Object> objectObservable2 = Observable.fromAction(action);
        Completable completable = Completable.fromAction(action);
        Completable.fromRunnable(runnable);


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(callable);
        Observable<?> observable = Observable.fromFuture(submit, 1, TimeUnit.SECONDS);
        try {
            observable.onErrorComplete().subscribe(consumer);

        }
        catch (Exception e) {
            // e.printStackTrace();
            System.out.println("throw Timeout ex"); // 无效
        }
        executorService.shutdown();

        Publisher publisher = s -> System.out.println(s);
        Observable observable1 = Observable.fromPublisher(publisher);

        Flowable<Object> generate = Flowable.generate(() -> 1, (i, emit) -> {
            emit.onNext(1 + i);
            return 2;
        }, i -> System.out.println(i));
        generate.subscribe((s) -> System.out.println("generate"));
    }
}
