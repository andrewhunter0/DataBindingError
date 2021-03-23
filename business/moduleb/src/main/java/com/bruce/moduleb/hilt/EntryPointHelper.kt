package com.bruce.moduleb.hilt

import android.content.Context
import dagger.hilt.android.EntryPointAccessors

/**
 *
 * @Description: Java类作用描述
 * @CreateDate:  2021/1/28 10:38 AM
 */
object EntryPointHelper {
    fun getEntryPoint(context: Context): ModuleBEntryPoint {
        return EntryPointAccessors.fromApplication(context.applicationContext, ModuleBEntryPoint::class.java)
    }
}