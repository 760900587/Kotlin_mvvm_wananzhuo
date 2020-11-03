package com.example.kotlin_mvvm_wananzhuo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.*
import androidx.databinding.ViewDataBinding

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_wananzhuo.BR


import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.bean.DataX

class List_adapter(var List: List<DataX>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewData1 = inflate<ViewDataBinding>(
            LayoutInflater.from(context), R.layout.item_list, parent, false
        )
        var holder = ViewHolder(viewData1)
        return holder
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bean = List.get(position)
        var holder1 = holder as ViewHolder
        holder1.binding?.setVariable(BR.Band,bean)
    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }
    }
}