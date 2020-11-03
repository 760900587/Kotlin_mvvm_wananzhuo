package com.example.kotlin_mvvm_wananzhuo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_mvvm_wananzhuo.activity.MyActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        val timer = Timer()
        val timerTask = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@MainActivity, MyActivity::class.java)
                startActivity(intent)
            }
        }
        timer.schedule(timerTask, 2000)
    }
}
