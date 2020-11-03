package com.example.kotlin_mvvm_wananzhuo.bean


data class Tab_bean(
    val `data`: List<Data3>,
    val errorCode: Int,
    val errorMsg: String
)

data class Data3(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)