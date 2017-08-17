package com.example.niklaus.networkrequest.rx2vm;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Niklaus on 2017/8/8.
 */

public class Rx2Observer<T> extends DisposableObserver<T> {

    private DataCallback<T> mCallback;

    public Rx2Observer(DataCallback<T> callback){
        mCallback = callback;
    }

    @Override
    public void onNext(@NonNull T t) {
        _onNext(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        String msg = "错误信息";
        _onError(msg, e);
    }

    @Override
    public void onComplete() {
        _onComplete();
    }

    public void _onComplete() {
        mCallback.onComplete();
    }

    public void _onNext(T t) {
        mCallback.onNext(t);
    }

    public void _onError(String msg, Throwable e) {
        mCallback.onError(msg, e);
    }


}
