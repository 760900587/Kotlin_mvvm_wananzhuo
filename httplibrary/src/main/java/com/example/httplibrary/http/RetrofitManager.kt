package com.example.kotlinbaselibrary.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager private constructor() {
    //单例
    companion object {
        val instance: RetrofitManager by lazy { RetrofitManager() }
    }

    fun getRrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.baseUrl)
                .client(getOkhttpClient())
                
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    private fun getOkhttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                LogUtils.instance.e(message)
            }

        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okbuider = OkHttpClient.Builder()
        okbuider.connectTimeout(Constants.time, TimeUnit.SECONDS)
        okbuider.readTimeout(Constants.time, TimeUnit.SECONDS)
        okbuider.writeTimeout(Constants.time, TimeUnit.SECONDS)
        okbuider.addInterceptor(httpLoggingInterceptor)
        if(GlobalSetting.instance.getInterCeptorList().isNotEmpty()){
            GlobalSetting.instance.getInterCeptorList().forEach {
                okbuider.addInterceptor(it)
            }

        }
        return okbuider.build();

    }


    fun <T> getServer(mClass:Class<T>):T{
        return getRrofit().create(mClass)
    }

}