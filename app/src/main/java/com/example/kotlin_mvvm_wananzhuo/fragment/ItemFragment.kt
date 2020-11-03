package com.example.kotlin_mvvm_wananzhuo.fragment


import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.adapter.Vp_Adapter
import com.example.kotlin_mvvm_wananzhuo.fragment.fragmentTab.TabFragment
import com.example.kotlin_mvvm_wananzhuo.mvvm.ProjectFactory
import kotlinx.android.synthetic.main.fragment_item.*

/**
 * A simple [Fragment] subclass.
 */
class ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item, container, false)
        val factory = ViewModelProvider(this).get(ProjectFactory::class.java)
        factory.setTab()?.observe(this, Observer {
            val data = it.data
            //Fragment集合
            val fragmens = ArrayList<Fragment>()
            var  i =0
            data.forEach {
                fragmens.add(TabFragment(it.id))
                i++
            }
            //创建Fragment_ViewPage适配器
            val adapter = Vp_Adapter(childFragmentManager, fragmens)
            vp.adapter=adapter
            tab.setupWithViewPager(vp)
            var b=0
            data.forEach {
                tab.getTabAt(b)?.text = data.get(b).name
                b++
            }

        })
        return view
    }


}
