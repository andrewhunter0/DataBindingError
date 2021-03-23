package com.andrew.architecture.core.base

import android.app.Application
import android.content.Context

/**
 * @author      andrew
 * @date        2020/8/12 3:51 PM
 * @description 做公用基础的配置与初使化工作
 */
open class BaseApplication : Application() {
    companion object {
        private lateinit var mContext: Context

        fun getAppContext() : Context {
            return mContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}