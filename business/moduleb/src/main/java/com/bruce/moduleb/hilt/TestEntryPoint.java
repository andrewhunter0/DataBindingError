package com.bruce.moduleb.hilt;

import com.andrew.architecture.services.service.AnalyticsService;
import com.andrew.architecture.services.service.AnalyticsService2;

/**
 * @Description: 测试用Java类来写EntryPoint
 * 必须定义为方法，且调用时是调用方法
 * 但Kotlin可以声明为变量，且调用时可直接引用变量
 * @CreateDate: 2021/1/28 2:20 PM
 */
public interface TestEntryPoint {
//    AnalyticsServiceImpl_b analyticsServiceImpl = null;
    AnalyticsServiceImpl_b analyticsServiceImpl();

//    AnalyticsService2 analyticsService2 = null;
    AnalyticsService2 analyticsService2();

//    AnalyticsService analyticsService = null;
    AnalyticsService analyticsService();
}
