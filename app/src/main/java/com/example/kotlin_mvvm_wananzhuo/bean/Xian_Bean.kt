package com.example.kotlin_mvvm_wananzhuo.bean

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class Xian_Bean(
    val `data`: Data4,
    val errorCode: Int,
    val errorMsg: String
):BaseObservable()

data class Data4(
    val curPage: Int,
    val datas: List<DataX1>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
):BaseObservable()

data class DataX1(
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Tag1>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
):BaseObservable()

data class Tag1(
    val name: String,
    val url: String
):BaseObservable()
        @BindingAdapter(value = ["img"])
        fun ImaUrl(iv: ImageView, imgUrl: String){
            Glide.with(iv.context).load(imgUrl).into(iv)
        }


