package com.example.kotlinbaselibrary.http

import android.util.Log

class LogUtils private constructor(){
    private var allowD=false
    private var allowE=false
    private var allowI=false
    private var allowV=false
    private var allowW=false
    private val TAG = "http"
    companion object {
        val instance: LogUtils by lazy { LogUtils() }
    }
    fun d(tag: String) {
        if (!allowD) {
            return
        } else {
            Log.d(TAG, tag)
        }
    }

    fun e(tag: String) {
        if (!allowE) {
            return
        } else {
            Log.d(TAG, tag)
        }
    }
    init {
        allowD = GlobalSetting.instance.isShow()
        allowE = GlobalSetting.instance.isShow()
        allowI = GlobalSetting.instance.isShow()
        allowV = GlobalSetting.instance.isShow()
        allowW = GlobalSetting.instance.isShow()
    }

}