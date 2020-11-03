package com.example.kotlin_mvvm_wananzhuo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class Vp_Adapter(var fragmentManager: FragmentManager ,var list:List<Fragment>): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
       return list.get(position)
    }

    override fun getCount(): Int {
       return list.size
    }
}