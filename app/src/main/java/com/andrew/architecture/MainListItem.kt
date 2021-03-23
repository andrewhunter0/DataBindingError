package com.andrew.architecture

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import com.andrew.architecture.core.base.BaseItem

/**
 * @author      andrew
 * @date        2020/8/12 7:44 PM
 * @description 列表的每一个卡片对象
 */
class MainListItem: BaseItem() {
    lateinit var title: String
    lateinit var imgUrl: String

    // TODO Test
    val background: ObservableField<Drawable> = ObservableField()
}