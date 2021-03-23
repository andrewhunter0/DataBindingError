package com.bruce.moduleb.hilt;

import android.content.Context;

import com.andrew.architecture.services.service.AnalyticsService2;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

/**
 * @Description: Java类作用描述
 * @CreateDate: 2021/1/25 12:05 AM
 */
@Singleton
public class AnalyticsServiceImpl_b implements AnalyticsService2 {
    @Inject
    public AnalyticsServiceImpl_b(@ApplicationContext Context context) {
        System.out.println("test----- in AnalyticsServiceImpl_b constructor ApplicationContext:" + context);
    }

    public void analytics() {
        System.out.println("test----- call analytics AnalyticsServiceImpl_b cal analytics!");
    }
}

@Module
@InstallIn(ApplicationComponent.class)
// 作为一个独立的类，不写public发现也没事，要么像AnalyticsServiceImp里的一样，作为静态内部类
abstract class AnalyticsModule_b {
    // 如果使用@Binds注解，需要给对象实例类的构造函数，添加@Inject注解
    @Binds
    @Singleton
    public abstract AnalyticsService2 bindAnalyticsService2(AnalyticsServiceImpl_b analyticsService2);
}

