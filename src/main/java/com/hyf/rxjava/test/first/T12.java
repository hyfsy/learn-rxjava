package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author baB_hyf
 * @date 2021/06/01
 */
public class T12 {

    public static void main(String[] args) {
        Schedulers.computation(); // CPU密集型任务
        Schedulers.io(); // IO密集型任务
        Schedulers.from(Executors.newSingleThreadExecutor()); // 通过Executor创建
        Schedulers.newThread(); // 每次一个新线程
        Schedulers.single(); // 单线程
        Schedulers.trampoline(); // 当前线程执行，但任务放入优先级队列中

        // 单独使用Scheduler

        // 延迟执行
        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(1); // 普通运行
                worker.schedule(this); // 递归运行
            }
        }, 1, TimeUnit.SECONDS);
        worker.dispose(); // 停止
        worker.isDisposed();

        // 延迟+定期执行
        worker.schedulePeriodically(() -> System.out.println(1), 1, 1, TimeUnit.SECONDS);

        // 测试使用
        TestScheduler testScheduler = new TestScheduler();
        // 将调度程序的时钟提前到特定时间点
        testScheduler.advanceTimeTo(1, TimeUnit.SECONDS);
        // 将调度程序的时钟向前推进特定的时间量
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        // 根据调度程序的时钟，启动已调度时间等于或早于当前时间的任何未启动的操作
        testScheduler.triggerActions(); // 获取内部的时间，触发队列中早于当前时间的任务
    }
}
