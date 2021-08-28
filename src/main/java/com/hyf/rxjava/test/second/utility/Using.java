package com.hyf.rxjava.test.second.utility;

import io.reactivex.rxjava3.core.Observable;

/**
 * create a disposable resource that has the same lifespan as the Observable
 *
 * @author baB_hyf
 * @date 2021/06/02
 */
public class Using {

    public static void main(String[] args) {
        Observable.using(() -> "resource",
                Observable::just,
                s -> System.out.println("clean up resource"),
                true /* eager */);
    }
}
