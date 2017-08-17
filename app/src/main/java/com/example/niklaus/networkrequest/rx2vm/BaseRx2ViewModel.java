package com.example.niklaus.networkrequest.rx2vm;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Niklaus on 2017/8/7.
 */

public abstract class BaseRx2ViewModel {
    CompositeDisposable _mDisposable = new CompositeDisposable();

    public BaseRx2ViewModel(){

    }

    protected Disposable rxAdd(Disposable disposable){
        _mDisposable.add(disposable);
        return disposable;
    }

    public void unBind(){
        if(!_mDisposable.isDisposed()){
            _mDisposable.clear();
        }
    }
}
