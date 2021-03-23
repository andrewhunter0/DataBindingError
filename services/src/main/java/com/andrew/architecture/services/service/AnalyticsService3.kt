package com.andrew.architecture.services.service

import javax.inject.Qualifier

/**
 *
 * @Description: Java类作用描述
 * @CreateDate:  2021/1/25 12:00 AM
 */
interface AnalyticsService3 {
    fun analytics()
}

/**
 * 测试一个接口的双实例
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AnalyticsService3One

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AnalyticsService3Two