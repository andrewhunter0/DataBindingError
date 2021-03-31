package com.bruce.modulea.hilt

import android.content.Context
import com.andrew.architecture.services.service.AnalyticsService
import com.andrew.architecture.services.service.AnalyticsService2
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

/**
 * @Description: 通过@EntryPoint定义注入点，这样在非Hilt支持的Android类里，也能通过
 * EntryPointAccessors.fromApplication(context.applicationContext, ModuleBEntryPoint::class.java).analyticsService
 * 获取接口实现
 *
 * 经测试，可以不给Activity添加@AndroidEntryPoint注解，可以直接使用EntryPointHelper.getEntryPoint这种来调用
 *
 * @CreateDate:  2021/1/28 10:36 AM
 */
@EntryPoint
@InstallIn(SingletonComponent::class)
interface ModuleAEntryPoint {
    // 官方写法是fun analyticsServiceImpl(): AnalyticsServiceImpl_b
    var analyticsService2: AnalyticsService2?

    var analyticsService: AnalyticsService?
}

object EntryPointHelper {
    fun getEntryPoint(context: Context): ModuleAEntryPoint {
        return EntryPointAccessors.fromApplication(context.applicationContext, ModuleAEntryPoint::class.java)
    }
}