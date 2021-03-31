package com.bruce.moduleb.hilt

import android.content.Context

/**
 *
 * @Description: Java类作用描述
 * @CreateDate:  2021/1/24 11:50 PM
 */
class CommonClass_b {
    fun testInit(param: String, context: Context) {
        println("test----in 【moduleb】.CommonClass_b!  $param")

        var point = EntryPointHelper.getEntryPoint(context)
        println("test----in 【moduleb】.CommonClass_b testInit point:$param    " + (point?.analyticsServiceImpl))
        var point2 = EntryPointHelper.getEntryPoint(context)
        println("test----in 【moduleb】.CommonClass_b testInit point2:$param    " + (point2?.analyticsServiceImpl))
        println("test----------------------------看是否同一个对象------------------------\n")
        println("test----in 【moduleb】.CommonClass_b testInit point2:$param    " + (point?.analyticsService2))
        println("test----###################看接口和实例两种方式，是否是同一个对象############################\n")

        println("test----in 【moduleb】.CommonClass_b.testInit call 【modulea】 service:" + (point?.analyticsService?.analytics()))
        println("test----########################################################################\n")
    }

//    @EntryPoint
//    @InstallIn(SingletonComponent::class)
//    interface CommonClass3EntryPoint {
//        var analyticsServiceImpl: AnalyticsServiceImpl_b
//
////        @Singleton
//        var analyticsService2: AnalyticsService2
//
////        @Singleton
//        var analyticsService: AnalyticsService
//    }
//
//    private fun getEntryPoint(context: Context): CommonClass3EntryPoint {
//        return EntryPointAccessors.fromApplication(context.applicationContext, CommonClass3EntryPoint::class.java)
//    }
}