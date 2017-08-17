package com.example.niklaus.networkrequest.rx2vm;

import android.support.annotation.Nullable;

/**
 * Created by Niklaus on 2017/8/8.
 */

public abstract class DataCallback<T> implements ICallBack<T> {

    public DataCallback(){
    }

    public abstract void onNext(T t);

    public void onError(String msg, @Nullable Throwable e){

    }

    public void onComplete(){

    }

}
