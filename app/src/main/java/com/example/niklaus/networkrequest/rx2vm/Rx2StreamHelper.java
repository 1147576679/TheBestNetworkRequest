package com.example.niklaus.networkrequest.rx2vm;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Niklaus on 2017/8/8.
 */

public class Rx2StreamHelper {

    public static <T extends Mapping<R>, R> ObservableTransformer<T, R> composeServerStreamIo(){
        return new ObservableTransformer<T, R>() {
            @Override
            public ObservableSource<R> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .flatMap(new Function<T, ObservableSource<R>>() {
                            @Override
                            public ObservableSource<R> apply(@NonNull T t) throws Exception {
                                return Observable.just(t.transform());
                            }
                        });
            }
        };
    }

    /**
     * 被观察者在io线程，观察者在mainThread
     */
    public static <T> ObservableTransformer<T, T> ob_io_main(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 被观察者在Job线程，观察者在mainThread
     */
    public static <T> ObservableTransformer<T,T> ob_job_main(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.observeOn(Schedulers.from(JobExecutor.eventExecutor))
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     *               Observable⬆︎
     * =========================================================
     *               Flowable⬇︎
     */


    /**
     * 被观察者在io线程，观察者在mainThread
     */
    public static <T> FlowableTransformer<T, T> flow_io_main(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 被观察者在Job线程，观察者在mainThread
     */
    public static <T> FlowableTransformer<T,T> flow_job_main(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.observeOn(Schedulers.from(JobExecutor.eventExecutor))
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
