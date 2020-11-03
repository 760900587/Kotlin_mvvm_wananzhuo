package com.example.kotlin_mvvm_wananzhuo.fragment.fragmentTab


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.adapter.Tab_Adapter
import com.example.kotlin_mvvm_wananzhuo.mvvm.ProjectFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_tab.*
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class TabFragment(id:Int) : Fragment() {
    var id1 =294
    init {
        this.id1=id
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
//        Tab_rcy.layoutManager
        initData()
        return view


    }
    fun initData(){
        val factory = ViewModelProvider(this).get(ProjectFactory::class.java)
        factory.setData(id1)?.observe(this, Observer {
            val datas = it.data.datas
            Log.e("DATA",datas.toString())
            //适配器
            val adapter = activity?.let { it1 -> Tab_Adapter(datas, it1) }
            //管理器
            Tab_rcy.layoutManager=LinearLayoutManager(activity)
            //绑定
            Tab_rcy.adapter=adapter
            Tab_rcy.addItemDecoration(DividerItemDecoration(activity,LinearLayout.VERTICAL))
            //刷新
            adapter?.notifyDataSetChanged()
        })
    }


}
