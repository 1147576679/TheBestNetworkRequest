package com.example.ktrxvm

import android.content.Context
import android.support.annotation.Nullable

/**
 * Created by Niklaus on 2017/9/5.
 */
abstract class DataCallback<T> : ICallBack<T> {

    constructor(context: Context): this(context, true)

    constructor(context: Context, enableReLogin: Boolean) {
        mContext = context
        mEnableReLogin = enableReLogin
    }


    private var mContext: Context
    private var mEnableReLogin: Boolean

    fun getContext(): Context = mContext

    /**
     * 返回数据集
     */
    abstract override fun onNext(result: T)  //这里为什么需要继承

    /**
     * 发生异常
     */
    override fun onError(msg: String, @Nullable e: Throwable){

    }

    /**
     * 完成
     */
    override fun onComplete() {

    }

    /**
     * 事件完成时回调（无论成功还是失败）
     */
    override fun onTerminate() {

    }

    fun onReLogin() {
        if(mEnableReLogin) {
            //执行重登策略
        }
    }

}