package com.example.ktrxvm

import io.reactivex.observers.DisposableObserver
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Niklaus on 2017/9/5.
 */
class RxObserver<T>(callback: DataCallback<T>) : DisposableObserver<T>() {

    private var mCallback: DataCallback<T> = callback

    override fun onNext(t: T) {
        _onNext(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        var msg: String = when(e) {
            is UnknownHostException -> "无法连接,请检查网络"
            is SocketTimeoutException -> "网络请求超时，请稍后重试"
            else -> "sorry"
        }

        _onError(msg, e)
    }

    override fun onComplete() {
        _onComplete()
        mCallback.onComplete()
        mCallback.onTerminate()
    }

    fun _onNext(t: T) {
        mCallback.onNext(t)
    }

    fun _onError(msg: String, e: Throwable) {
        mCallback.onError(msg, e)
    }

    fun _onComplete() {

    }
}