package com.example.kotlinbaselibrary.base

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater.inflate(createLayoutId(), container, false)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataAndEvent()
    }

    abstract fun initDataAndEvent()

    abstract fun createLayoutId(): Int


    override fun onDestroyView() {
        super.onDestroyView()
        ((rootView?.parent) as ViewGroup).removeView(rootView)
    }
}