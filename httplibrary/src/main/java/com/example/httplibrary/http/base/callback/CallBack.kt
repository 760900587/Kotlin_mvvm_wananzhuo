package com.example.kotlinbaselibrary.http

abstract class CallBack<T> : BaseObserver<BaseResponse<T>>() {

    override fun onFailer(error: String?) {
    }

    override fun onNext(t: BaseResponse<T>) {
    }
}