package com.example.kotlin_mvvm_wananzhuo.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.adapter.Vp_Adapter
import com.example.kotlin_mvvm_wananzhuo.fragment.fragmentsqul.DaoHanFragment
import com.example.kotlin_mvvm_wananzhuo.fragment.fragmentsqul.TIXiFragment
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_squarek.*

/**
 * A simple [Fragment] subclass.
 */
class SquarekFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_squarek, container, false)
        //创建集合
        val fragments = ArrayList<Fragment>()
        //创建Fragmne
        val tiXiFragment = TIXiFragment()
        val daoHanFragment = DaoHanFragment()
        fragments.add(tiXiFragment)
        fragments.add(daoHanFragment)
        //创建适配器
        val adapter = Vp_Adapter(childFragmentManager, fragments)
        squ_vp.adapter=adapter
        squ_tab.setupWithViewPager(squ_vp)
        squ_tab.getTabAt(0)?.setText("体系")
        squ_tab.getTabAt(1)?.setText("导航")
        return view;
    }


}
