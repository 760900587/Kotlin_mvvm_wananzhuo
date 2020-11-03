package com.example.kotlinbaselibrary.http

import android.app.Application
import android.content.Context
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class GlobalApp:Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalSetting.instance.setkeyValue(Constants.baseUrl,"http://api.ergedd.com/").setShowLog(true)
    }

}