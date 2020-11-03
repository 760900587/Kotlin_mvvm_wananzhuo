package com.example.kotlinbaselibrary.http

import okhttp3.Interceptor


class GlobalSetting private constructor() {

    private val map by lazy { mutableMapOf<String, Any>() }

    private val interceptorList by lazy { mutableListOf<Interceptor>() }


    var isShowLog:Boolean = false

    companion object {
        val instance: GlobalSetting by lazy { GlobalSetting() }
    }

    fun setkeyValue(key: String, value: Any): GlobalSetting {
        map[key] = value
        return this
    }

    fun getValue(key: String): Any? {
        return map[key]
    }

    fun setShowLog(isShow:Boolean): GlobalSetting {
        isShowLog=isShow
        return this
    }

    fun isShow():Boolean{
        return isShowLog
    }

    fun setInterCeptor(interceptor: Interceptor): GlobalSetting {
        interceptorList.add(interceptor)
        return this
    }

    fun getInterCeptorList():MutableList<Interceptor>{
        return interceptorList
    }
}