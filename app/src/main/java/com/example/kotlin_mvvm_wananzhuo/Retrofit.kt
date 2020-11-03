package com.example.kotlin_mvvm_wananzhuo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit1 {
    companion object {
        fun retroit(): Retrofit {
            val build = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return build

        }

    }
}