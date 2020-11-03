package com.example.kotlin_mvvm_wananzhuo.app

import android.app.Application
import androidx.multidex.MultiDex

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
    }
}