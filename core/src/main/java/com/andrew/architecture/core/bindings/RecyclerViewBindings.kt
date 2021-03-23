///*
// * Copyright (C) 2020 Andrew Liu, Inc. All Rights Reserved.
// */
//package com.andrew.architecture.bindings
//
//import androidx.databinding.BindingAdapter
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.StaggeredGridLayoutManager
////import com.andrew.architecture.MainListItem
//import com.andrew.architecture.core.base.BaseAdapter
//import com.andrew.architecture.core.base.BaseItem
//
///**
// * @author      andrew
// * @date        2020/8/9 4:33 PM
// * @description For binding RecyclerView's attributes
// */
//object RecyclerViewBindings {
//
//    /**
//     * The method will be auto called
//     * The first param is the view which the attribute will be set to
//     * Then the params that set by annotation with BindingAdapter
//     * @see (https://blog.csdn.net/guiying712/article/details/80411597)
//     *
//     * 这个注解的问题，困扰了我好久，真的很费劲
//     * 并不是要用object，方法要加@JvmStatic，也不是apply plugin: 'kotlin-kapt'的问题
//     * 而是因为我把RecyclerViewBindings放在了其它的module（core）里面，造成无法生成相应的ActivityMainBindingImp类
//     * 只能放在跟自己使用的xml一样的module里面才行，原来少了dataBinding.enabled = true的配置
//     *
//     * 然后，被BindingAdapter注解的方法参数，也必须完全匹配，比如方法里是List类型的，但是你传进来的是ArrayList，不行，也得用ArrayList
//     */
//    @JvmStatic
//    @BindingAdapter(value = ["android:mainListAdapter", "android:dataList"])
//    fun bindAdapterAndList(recyclerview: RecyclerView,
//                           adapter: BaseAdapter<BaseItem, RecyclerView.ViewHolder>,
//                           list: ArrayList<BaseItem>) {
//        if (recyclerview == null || adapter == null || list.isNullOrEmpty())
//            return
//
//        // Attention,this way has no effect for assignment to recyclerview.adapter,it just like ternary expression
//        // recyclerview.adapter ?: adapter
//
//        // If not set,just set the new adapter
//        if (recyclerview.adapter == null) {
//            recyclerview.adapter = adapter
//        }
//
//        // 布局
//        recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//
//        println("test----adapter:${adapter} size:${list?.size} recyclerview.adapter:${recyclerview.adapter == null}")
//
//        // Set data list for adapter
//        adapter.updateListData(list)
//        adapter.notifyDataSetChanged()
//    }
//}