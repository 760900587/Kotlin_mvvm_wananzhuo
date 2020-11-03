package com.liangxq.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinbaselibrary.base.BasePresenter


abstract class BaseLazyFragment<P: BasePresenter<*, *>> :BaseMvpFragment<P>() {

    var mIsPrepare = false        //初始化视图
    var mIsVisible = false        //不可见
    var mIsFirstLoad = true    //第一次加载

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        mIsPrepare=true
        lazyData()
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            mIsVisible=true
            lazyData()
        }else{
            mIsVisible=false
        }
    }


    fun lazyData(){
        if(mIsPrepare && mIsVisible && mIsFirstLoad){
            loadData()
            mIsFirstLoad=false
        }
    }

    abstract fun loadData()

    override fun onDestroyView() {
        super.onDestroyView()
        mIsPrepare = false
        mIsVisible = false
        mIsFirstLoad = true
    }
}