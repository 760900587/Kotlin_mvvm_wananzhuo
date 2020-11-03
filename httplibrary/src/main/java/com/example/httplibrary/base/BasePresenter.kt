package com.example.kotlinbaselibrary.base

import java.lang.ref.WeakReference
import java.lang.reflect.ParameterizedType

open class BasePresenter<out V:BaseView,out M : BaseModle> {
    private var weakReference: WeakReference<V>? = null
    private var modle: M? = null

    fun attach(view:  @UnsafeVariance V) {
        weakReference = WeakReference<V>(view)
        initModle()
    }

    fun getView(): V? {
        return weakReference?.get()
    }

    fun deatch() {
        weakReference?.clear()
        weakReference = null
        modle=null
    }

    //获取泛型发class类对象 动态的创建modle
    fun initModle() {
        try {
            val type = this.javaClass.genericSuperclass
            val parameterizedType = type as ParameterizedType
            val mClass = parameterizedType.getActualTypeArguments()[1] as Class<M>
            modle = mClass.newInstance()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun getModle():M?{
        return modle
    }
}