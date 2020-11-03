package com.example.kotlinbaselibrary.base

interface BaseModle{
    interface CallBack<T>{
        fun onSucess(t:T)
        fun onError(string:String?)
    }
}