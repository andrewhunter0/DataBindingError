package com.bruce.modulea.hilt

import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @Description: 如果用@Inject直接修饰实例对象，不用写@Binds，可以直接被注入
 * @CreateDate:  2021/1/24 11:50 PM
 */
class CommonClass @Inject constructor() {
    // 使用@JvmField或者lateinit来解决错误
//    @Inject
//    lateinit var analyticsService: AnalyticsService

    // 实例对象，不用写@Binds，可以直接被注入
    @field:Inject
    lateinit var analyticsService: AnalyticsServiceImp

    fun testInit(param: String) {
        println("test----in CommonClass!  $param analyticsService：$analyticsService")

        println("test----in CommonClass testInit object:$param    " + (analyticsService?.analytics()))
//        println("test----in CommonClass analyticsService method:" + analyticsService?.analytics())
    }
}