package com.hyf.rxjava.test.second.create;

import io.reactivex.rxjava3.core.Observable;

/**
 * empty:
 * create Observables that have very precise and limited behavior
 * <p>
 * never:
 * create an Observable that emits no items and does not terminate
 * <p>
 * throw:
 * create an Observable that emits no items and terminates with an error
 *
 * @author baB_hyf
 * @date 2021/06/01
 */
public class Empty_Never_Throw {

    public static void main(String[] args) {
        Observable<Object> empty = Observable.empty(); // 立即终止，不发射任何项
        Observable<Object> never = Observable.never(); // 不会终止，也不发射项
        Observable.error(RuntimeException::new); // 立即终止，发出一个错误
        Observable.error(new RuntimeException());
    }
}
