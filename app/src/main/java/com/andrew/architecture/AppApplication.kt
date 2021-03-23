package com.andrew.architecture

import com.andrew.architecture.core.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @author      andrew
 * @date        2020/8/12 3:51 PM
 * @description 应用层的一些处理，如注册等
 */
@HiltAndroidApp
class AppApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}