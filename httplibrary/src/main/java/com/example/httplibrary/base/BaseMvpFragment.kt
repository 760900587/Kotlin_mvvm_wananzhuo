package com.liangxq.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinbaselibrary.base.BaseFragment
import com.example.kotlinbaselibrary.base.BasePresenter
import com.example.kotlinbaselibrary.base.BaseView

abstract class BaseMvpFragment<P : BasePresenter<*, *>> : BaseFragment(), BaseView {
    lateinit var mPresenter:P
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        mPresenter=createPresenter()
        mPresenter.attach(this)
        return rootView
    }

    abstract fun createPresenter(): P


    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.deatch()
    }
}