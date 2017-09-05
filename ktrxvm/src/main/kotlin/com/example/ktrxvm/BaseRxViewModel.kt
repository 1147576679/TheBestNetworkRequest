package com.example.ktrxvm

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Niklaus on 2017/9/5.
 */
open class BaseRxViewModel {
    protected var _mDisposable = CompositeDisposable()

    protected fun rxAdd(disposable: Disposable): Disposable {
        _mDisposable.add(disposable)
        return disposable
    }

    fun unbind() {
        if (_mDisposable.isDisposed) {
            _mDisposable.clear()
        }
    }
}