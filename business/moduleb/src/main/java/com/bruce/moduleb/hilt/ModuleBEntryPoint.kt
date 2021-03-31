package com.bruce.moduleb.hilt

import com.andrew.architecture.services.service.*
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
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
interface ModuleBEntryPoint {
    // 官方写法是fun analyticsServiceImpl(): AnalyticsServiceImpl_b
    var analyticsServiceImpl: AnalyticsServiceImpl_b?

    var analyticsService2: AnalyticsService2?

    var analyticsService: AnalyticsService?

    /**
     * e: D:\Git\github\DataBindingError\app\build\generated\source\kapt\debug\com\andrew\architecture\AppApplication_HiltComponents.java:154: ����: [Dagger/MissingBinding] com.andrew.architecture.services.service.AnalyticsService3 cannot be provided without an @Provides-annotated method.
    public abstract static class ApplicationC implements AppApplication_GeneratedInjector,
    ^
    A binding with matching key exists in component: com.andrew.architecture.AppApplication_HiltComponents.ApplicationC
    com.andrew.architecture.services.service.AnalyticsService3 is requested at
    com.bruce.moduleb.hilt.ModuleBEntryPoint.getAnalyticsService3()
     */
    @get:AnalyticsService3One
    var analyticsService3: AnalyticsService3?
    @get:AnalyticsService3Two
    var analyticsService3_2: AnalyticsService3?

    // 没有提供provides或者binds的，运行会直接报错
//    fun getAnalyticsServiceTest(): AnalyticsService4
//    var getAnalyticsService4: AnalyticsService4?
}