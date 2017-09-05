package com.example.ktrxvm

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject


/**
 * Created by Niklaus on 2017/9/5.
 */
class ObservableModel<T> {
    private var mSubject: Subject<T> = PublishSubject.create()
}