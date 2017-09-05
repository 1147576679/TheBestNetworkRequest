package com.example.ktrxvm

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Niklaus on 2017/9/5.
 */
class RxStreamHelper {

    companion object {

        @JvmStatic
        fun <T> io_main(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
            upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        @JvmStatic
        fun <T> job_main(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
            upstream
                    .subscribeOn(Schedulers.from(JobExecutor.eventExecutor))
                    .observeOn(AndroidSchedulers.mainThread())
        }

        @JvmStatic
        fun unSubscibe(disposable: Disposable) {
            if (disposable != null && !disposable.isDisposed) {
                disposable.dispose()
            }
        }

    }
}