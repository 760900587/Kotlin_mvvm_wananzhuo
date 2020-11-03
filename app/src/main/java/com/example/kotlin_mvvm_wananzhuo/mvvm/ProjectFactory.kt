package com.example.kotlin_mvvm_wananzhuo.mvvm

import ApiService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_mvvm_wananzhuo.Retrofit1
import com.example.kotlin_mvvm_wananzhuo.bean.Tab_bean
import com.example.kotlin_mvvm_wananzhuo.bean.Xian_Bean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProjectFactory : ViewModel() {
        var http=CoroutineScope(Dispatchers.Main)
    var mutableLiveData: MutableLiveData<Tab_bean>? = MutableLiveData()
    public fun setTab(): MutableLiveData<Tab_bean>? {
        http.launch {
            if (mutableLiveData==null){
                mutableLiveData=MutableLiveData()
            }
            val tabBean = initData()
           mutableLiveData?.postValue(tabBean)
        }
        return mutableLiveData
    }
    suspend  fun initData(): Tab_bean? {
        var  xianTab:Tab_bean?=null
        val create = Retrofit1.retroit().create(ApiService::class.java)
        withContext(Dispatchers.IO){
            xianTab = create.XianTab()
        }
        return xianTab
    }

    var mutableList:MutableLiveData<Xian_Bean>?= MutableLiveData()
    fun setData(id:Int):MutableLiveData<Xian_Bean>?{
        http.launch {
            if (mutableList==null){
                mutableList=MutableLiveData()
            }
            val initListData = initListData(id)
            mutableList?.postValue(initListData)
        }
        return mutableList
    }
    suspend fun initListData(id:Int): Xian_Bean? {
        var listBeamn:Xian_Bean?=null
        val create = Retrofit1.retroit()
            .create(ApiService::class.java)
        withContext(Dispatchers.IO){
            listBeamn = create.XianList(id)
        }

        return listBeamn
    }
}