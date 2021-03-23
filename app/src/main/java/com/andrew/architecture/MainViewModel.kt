/*
 * Copyright (C) 2020 Andrew Liu, Inc. All Rights Reserved.
 */
package com.andrew.architecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author      andrew
 * @date        2020/8/9 5:44 PM
 * @description 主界面的ViewModel
 */
class MainViewModel: ViewModel() {
    // Data list for RecyclerView
    var dataList: ArrayList<MainListItem> = ArrayList()
    // MutableLiveData对象，在XML中可能通过databinding设置给@BindingAdapter注解（Java类）的List参数
    var dataList2: MutableLiveData<ArrayList<MainListItem>> = MutableLiveData()

    init {
        for (i in 0..100) {
            var listItem = MainListItem()
            listItem.title = "测试列表，当前位置：$i"
            changeImgUrl(i, listItem, true)
            dataList.add(listItem)
        }
        dataList2.value = dataList
    }

   private var mFlag: Boolean = false
    fun updateDataList() {
//        for (i in 100 downTo  1) {
//            var listItem = MainListItem()
//            listItem.title = "新的数据进来了：$i"
//            dataList.add(0, listItem)
//        }

        var list: ArrayList<MainListItem>? = dataList2.value
        for (i in 0 until 100) {
            var listItem = list?.get(i)

            listItem?.let { changeImgUrl(i, it, mFlag) }
        }

        dataList2.value = list

        mFlag = !mFlag
    }

    private fun changeImgUrl(index: Int, listItem: MainListItem, init: Boolean) {
        if (init) {
            when (index%5) {
                0 -> listItem.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968156&di=16d77d2b74a6e14808470125b018bb97&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170122%2F20170122145324_c074bd4d20c537b795f6cc97f90d9e50_2.jpeg"
                1 -> listItem.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968156&di=854fb4079b2b2764c080f35e0415e391&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170420%2F20170420105628_ea6da92abc46098d8e03ad2ee55abeb7_9.jpeg"
                2 -> listItem.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968157&di=11da97f9ee59bcb0dddfdf75c0e403f5&imgtype=0&src=http%3A%2F%2Fztd00.photos.bdimg.com%2Fztd%2Fw%3D700%3Bq%3D50%2Fsign%3Df7daf6ef9952982205333bc3e7f10af6%2F314e251f95cad1c8167f360f763e6709c83d51d6.jpg"
                3 -> listItem.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968153&di=363de3d5877612c23763d93b08e3292d&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170303%2F20170303094555_7851ce3d965701f3201d4df2dde56592_8.jpeg"
                4 -> listItem.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968152&di=5ccd9c1243edcd73a7e26c1b7dceeec0&imgtype=0&src=http%3A%2F%2F01.minipic.eastday.com%2F20170421%2F20170421141708_405cb6c3f8850e8d7e1d392eb835e377_3.jpeg"
            }
        } else {
            when (index%5) {
                0 -> listItem!!.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968148&di=394ec91cc11e2348388ca5324161ba37&imgtype=0&src=http%3A%2F%2F01.minipic.eastday.com%2F20161114%2F20161114175121_13d7fb4816c76683c577ee586b090304_1.jpeg"
                1 -> listItem!!.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598456968140&di=f28fdb2600457f2697d6a7961be03459&imgtype=0&src=http%3A%2F%2Fimg.18183.com%2Fuploads%2Fallimg%2F160301%2F27-160301155232.jpg"
                2 -> listItem!!.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598457129982&di=51c0d5a791ee92c5f44282becc82e265&imgtype=0&src=http%3A%2F%2F01.minipic.eastday.com%2F20170104%2F20170104151754_edeffcf48cbe18f87d4f4c1c6c381c7b_1.jpeg"
                3 -> listItem!!.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598457129979&di=fa6c6172e834cce5f9782295a0f47524&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170504%2F20170504151712_e0c8bd4e0919dba5f9772757c2b34304_1.jpeg"
                4 -> listItem!!.imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598457129979&di=1eb9b3bf141a52ace78aedcaeacc53c0&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20161210%2F20161210155221_1f4f63a045c74f735c46cb1e6d6a66bc_6.jpeg"
            }
        }
    }
}