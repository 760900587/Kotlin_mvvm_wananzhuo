package com.example.kotlin_mvvm_wananzhuo.fragment.fragmentsqul


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlin_mvvm_wananzhuo.R

/**
 * A simple [Fragment] subclass.
 */
class DaoHanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dao_han, container, false)
    }


}
