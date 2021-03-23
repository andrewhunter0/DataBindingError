package com.andrew.architecture.core.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @author      andrew
 * @date        2020/8/12 9:14 PM
 * @description 描述本类的作用
 */
abstract class BaseAdapter<B, T: ViewHolder> : Adapter<T> {
    protected var mContext: Context
    protected var dataList: List<B> = ArrayList()

    constructor(context: Context) {
        mContext = context
    }

    abstract fun updateListData(list: List<B>)

    override fun getItemCount(): Int {
        return if (dataList.isNullOrEmpty()) 0 else dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    /**
     * ViewHolder适配空实现
     */
    class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}