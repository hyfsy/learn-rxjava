package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Timed;

/**
 * convert an Observable that emits items into one that emits indications of the
 * amount of time elapsed between those emissions
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class TimeInterval {

    public static void main(String[] args) {
        // 将发射的项转换为发射之间的间隔时间
        Observable<Timed<Integer>> timedObservable = Observable.just(1).timeInterval();
    }
}
