package com.example.niklaus.networkrequest.rx2vm;

import android.support.annotation.Nullable;

/**
 * Created by Niklaus on 2017/8/8.
 */

public interface ICallBack<T> {

    void onNext(T t);

    void onError(String msg, @Nullable Throwable e);

    void onComplete();



}
