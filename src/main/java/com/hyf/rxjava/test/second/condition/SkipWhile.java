package com.hyf.rxjava.test.second.condition;

import io.reactivex.rxjava3.core.Observable;

/**
 * discard items emitted by an Observable until a specified condition becomes false
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class SkipWhile {

    public static void main(String[] args) {
        // 条件成立时停止skip
        Observable.just(1).skipWhile(i -> i > 1);
    }
}
