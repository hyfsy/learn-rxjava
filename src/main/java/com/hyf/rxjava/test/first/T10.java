package com.hyf.rxjava.test.first;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.*;

/**
 * @author baB_hyf
 * @date 2021/05/31
 */
public class T10 {

    public static void main(String[] args) {
        Observable<Long> longObservable = Observable.rangeLong(1, 10);
        Observable.just(10).count();
        Observable.range(1, 5).reduce((savedValue, i) -> i * savedValue).subscribe(System.out::println);


        Observable<Integer> just1 = Observable.just(1);

        just1.reduceWith(TreeSet::new, (set, i) -> {
            set.add(i);
            return set;
        }).subscribe(System.out::println);

        Single<ArrayList<Object>> collect = just1
                .collect(ArrayList::new, ArrayList::add); // 也可以使用 Collectors

        // 内部调用了 collect
        Single<ArrayList> arrayListSingle = just1
                .collectInto(new ArrayList(), ArrayList::add);

        Single<@NonNull List<Integer>> listSingle = just1.toList();
        Single<@NonNull List<Integer>> listSingle1 = just1.toSortedList();
        Single<Map<Integer, Integer>> mapSingle = just1.toMap(k -> k);
        Single<@NonNull Map<String, Collection<Integer>>> mapSingle1 =
                just1.toMultimap(
                        String::valueOf,
                        k -> k,
                        () -> new TreeMap<>(),
                        k -> new ArrayList<>()); // TODO ?
        mapSingle1.subscribe(System.out::println);

    }
}
