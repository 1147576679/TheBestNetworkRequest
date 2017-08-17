package com.example.niklaus.networkrequest.rx2vm;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Niklaus on 2017/8/8.
 */

public class Rx2Subcriber<T> implements Subscriber<T> {

    private DataCallback<T> mCallback;

    public Rx2Subcriber(DataCallback<T> callback){
        mCallback = callback;
    }

    @Override
    public void onSubscribe(Subscription s) {
        _onSubscribe(s);
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable t) {
        String msg = "错误信息";
        _onError(msg, t);
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

    public void _onSubscribe(Subscription s){
        mCallback.onSubscribe(s);
    }

}
