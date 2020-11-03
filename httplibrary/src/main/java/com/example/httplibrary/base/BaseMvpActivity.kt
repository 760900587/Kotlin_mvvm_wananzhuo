package com.example.kotlinbaselibrary.base


//协变
 abstract class BaseMvpActivity<P:BasePresenter<*,*>> :BaseActivity(),BaseView{

    lateinit var mPresenter:P

     override fun initData() {
         mPresenter=createPresenter()
         mPresenter.attach(this)
     }

     abstract fun createPresenter(): P
 }