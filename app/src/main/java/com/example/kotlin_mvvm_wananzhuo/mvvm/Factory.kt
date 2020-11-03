package com.example.kotlin_mvvm_wananzhuo.mvvm


import ApiService
import android.database.Observable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_mvvm_wananzhuo.Retrofit1
import com.example.kotlin_mvvm_wananzhuo.bean.Banner_Bean
import com.example.kotlin_mvvm_wananzhuo.bean.Show_Bean

import com.example.kotlinbaselibrary.http.LogUtils
import com.example.kotlinbaselibrary.http.RetrofitManager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log


class Factory : ViewModel() {
    var http = CoroutineScope(Dispatchers.Main)
    //banner
    var mutableLiveData: MutableLiveData<Banner_Bean>? = MutableLiveData()
    //list
    var mutableList: MutableLiveData<Show_Bean>  = MutableLiveData()

    fun setBanner(): MutableLiveData<Banner_Bean>? {


//        launch 函数的返回值是 Job，比如说当用户关闭页面时，
//        后台请求尚未返回，但此时结果已经无关紧要了，我们可以通过Job.cancel() 函数来取消掉当前执行的协程任务。
        http.launch {
            if (mutableLiveData == null) {
                mutableLiveData = MutableLiveData()
            }
            val initData = initData()
            mutableLiveData?.postValue(initData)
        }
        return mutableLiveData
    }

    //  挂起函数 切换线程
    suspend fun initData(): Banner_Bean? {


        var bannerBean: Banner_Bean? = null
        val create = Retrofit1.retroit()
            .create(ApiService::class.java)
        try {
            withContext(Dispatchers.IO) {
                bannerBean = create.Bann()
            }
        } catch (e: Exception) {
            Log.e("TAG", e.message)
        }
        return bannerBean
    }

    fun setList(page: Int): MutableLiveData<Show_Bean>? {
        http.launch {
            if (mutableList == null) {
                mutableList = MutableLiveData()
            }
            val showBean = initgetList(page)
            mutableList?.postValue(showBean)
        }
        return mutableList
    }
    suspend fun initgetList(page: Int): Show_Bean? {
        var showBean: Show_Bean? = null
        val shouList = Retrofit1.retroit().create(ApiService::class.java)

        withContext(Dispatchers.IO) {
            showBean = shouList.ShouList(page)
        }
        return showBean
    }
}