package com.example.kotlin_mvvm_wananzhuo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.fragment.*
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        initView()
    }

    fun initView() {
        but.setMode(BottomNavigationBar.MODE_FIXED)
            .setActiveColor(R.color.colorAccent)
            .addItem(BottomNavigationItem(R.mipmap.home, "首页"))
            .addItem(BottomNavigationItem(R.mipmap.project, "项目"))
            .addItem(BottomNavigationItem(R.mipmap.square, "广场"))
            .addItem(BottomNavigationItem(R.mipmap.official_account, "公众号"))
            .addItem(BottomNavigationItem(R.mipmap.mine, "我的"))
            .initialise()
        val homeFragment = HomeFragment()
        val itemFragment = ItemFragment()
        val squarekFragment = SquarekFragment()
        val tencenFragment = TencenFragment()
        val myFragment = MyFragment()
        //获取Fragment管理器
        supportFragmentManager.beginTransaction()
            .add(R.id.fl, homeFragment)
            .add(R.id.fl, itemFragment)
            .add(R.id.fl, squarekFragment)
            .add(R.id.fl, tencenFragment)
            .add(R.id.fl, myFragment)
            .show(homeFragment)
            .hide(itemFragment)
            .hide(squarekFragment)
            .hide(tencenFragment)
            .hide(myFragment)
            .commit()
        but.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                if (position == 0) {
                    supportFragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(itemFragment)
                        .hide(squarekFragment)
                        .hide(tencenFragment)
                        .hide(myFragment)
                        .commit()
                } else if (position == 1) {
                    supportFragmentManager.beginTransaction()
                        .show(itemFragment)
                        .hide(homeFragment)
                        .hide(squarekFragment)
                        .hide(tencenFragment)
                        .hide(myFragment)
                        .commit()
                } else if (position == 2) {
                    supportFragmentManager.beginTransaction()
                        .show(squarekFragment)
                        .hide(homeFragment)
                        .hide(itemFragment)
                        .hide(tencenFragment)
                        .hide(myFragment)
                        .commit()
                } else if (position == 3) {
                    supportFragmentManager.beginTransaction()
                        .show(tencenFragment)
                        .hide(homeFragment)
                        .hide(itemFragment)
                        .hide(squarekFragment)
                        .hide(myFragment)
                        .commit()
                } else if (position == 4) {
                    supportFragmentManager.beginTransaction()
                        .show(myFragment)
                        .hide(homeFragment)
                        .hide(itemFragment)
                        .hide(squarekFragment)
                        .hide(tencenFragment)
                        .commit()
                }
            }
        })
    }
}
