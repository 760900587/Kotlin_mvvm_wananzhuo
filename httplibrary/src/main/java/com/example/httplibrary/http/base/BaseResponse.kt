package com.example.kotlinbaselibrary.http


data class BaseResponse<T>(var success:Boolean,var message:String,var expiration: Long,var data: T)