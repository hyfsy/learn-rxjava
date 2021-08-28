package com.hyf.rxjava.test.second.filter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * emit only the last item (or the last item that meets some condition) emitted by an Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Last {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1);
        Single<Integer> last = just.last(1); // 过滤操作可使用 takeLast
    }
}
