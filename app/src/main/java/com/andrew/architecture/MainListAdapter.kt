package com.andrew.architecture

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.andrew.architecture.core.base.BaseAdapter
import com.andrew.architecture.databinding.ActivityMainItemBinding
import com.andrew.architecture.utils.ScreenUtils

/**
 * @author      andrew
 * @date        2020/8/12 4:14 PM
 * @description 首页列表Adapter
 */
class MainListAdapter : BaseAdapter<MainListItem, RecyclerView.ViewHolder> {

    constructor(context: Context) : super(context) {
    }

    override fun updateListData(list: List<MainListItem>) {
        dataList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var dataBinding: ActivityMainItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.activity_main_item, parent, false)

        return ListItemViewHolder(dataBinding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var dataBinding: ActivityMainItemBinding? = DataBindingUtil.getBinding(holder.itemView)

        val width = ScreenUtils.getScreenWidth(mContext) / 2
        val height = position % 2
        var layoutParams = dataBinding!!.idImageView!!.layoutParams
        when (height) {
            0 -> layoutParams.height = (width * 1.5).toInt()
            1 -> layoutParams.height = (width * 1.2).toInt()
        }
        dataBinding.idImageView.layoutParams = layoutParams

        dataBinding?.itemBean = dataList?.get(position)
        dataBinding?.executePendingBindings()
    }
}