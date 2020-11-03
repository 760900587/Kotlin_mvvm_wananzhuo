package com.example.kotlin_mvvm_wananzhuo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_wananzhuo.BR
import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.bean.DataX1


class Tab_Adapter(var list: List<DataX1>, var context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(context),
            R.layout.item_tab,
            parent,
            false
        )
        //我的ads啊实打实
       var a:String ="adas"
        var holder =ViweHolder(viewDataBinding)
        return holder
    }

    override fun getItemCount(): Int {
      return  list.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bean = list.get(position)
        var holder1 =holder as ViweHolder
        holder1.binding?.setVariable(BR.tab,bean)

    }
    class ViweHolder(binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root){
            var binding:ViewDataBinding?=null
        init {
            this.binding=binding
        }
    }
}