package com.example.ktrxvm.model

/**
 * Created by Niklaus on 2017/9/5.
 */
interface Mapping<T> {
    fun transform(): T
}