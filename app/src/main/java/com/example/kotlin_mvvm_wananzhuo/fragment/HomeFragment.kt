package com.example.kotlin_mvvm_wananzhuo.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlin_mvvm_wananzhuo.R
import com.example.kotlin_mvvm_wananzhuo.adapter.List_adapter
import com.example.kotlin_mvvm_wananzhuo.mvvm.Factory
import com.youth.banner.Banner
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    var page = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //定义String集合
        val list = ArrayList<String>()
        initData()
        val factory = ViewModelProvider(this).get(Factory::class.java)
        factory.setBanner()?.observe(this, Observer {
                val data = it.data
                var i = 0
                data.forEach {
                    val path = data.get(i).imagePath
                    list.add(path)
                    i++;
                }
                bann.setImages(list)
                    .setImageLoader(object : ImageLoader() {
                        override fun displayImage(
                            context: Context?,
                            path: Any?,
                            imageView: ImageView?
                        ) {
                            if (imageView != null) {
                                Glide.with(context!!).load(path)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView)
                            }
                        }
                    }).start()
        })

        return view
    }

    fun initData() {
        val factory = ViewModelProvider(this).get(Factory::class.java)
        factory.setList(page)?.observe(this, Observer {
            val datas = it.data.datas

            //布局管理器
            rcy.layoutManager = LinearLayoutManager(activity)
            //创建适配器
            val listAdapter = activity?.let { it1 -> List_adapter(datas, it1) }
            //绑定适配器
            rcy.adapter = listAdapter
            //分割线
            rcy.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
            //刷新
            listAdapter?.notifyDataSetChanged()
        })
    }


}
