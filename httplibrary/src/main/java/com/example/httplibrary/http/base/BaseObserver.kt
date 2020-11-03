package com.example.kotlinbaselibrary.http

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseObserver<T> :Observer<T>{

    var compositeDisposable=CompositeDisposable()
    override fun onComplete() {
        compositeDisposable.clear()
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }


    override fun onError(e: Throwable) {
        compositeDisposable.clear()
        onFailer(e.message)
    }

    abstract fun onFailer(error:String?)
}