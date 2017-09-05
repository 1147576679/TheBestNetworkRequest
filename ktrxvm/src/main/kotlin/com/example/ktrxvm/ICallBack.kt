package com.example.ktrxvm

import android.support.annotation.Nullable

/**
 * Created by Niklaus on 2017/9/5.
 */
interface ICallBack<T> {

    /**
     * 返回数据集
     */
    fun onNext(result: T)

    /**
     * 发生异常
     */
    fun onError(msg: String, @Nullable e: Throwable)

    /**
     * 完成
     */
    fun onComplete()

    /**
     * 事件完成时回调（无论成功还是失败）
     */
    fun onTerminate()
}