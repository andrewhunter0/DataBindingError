package com.bruce.modulea.hilt;

import com.andrew.architecture.services.service.AnalyticsService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * @Description: Java类作用描述
 * @CreateDate: 2021/1/25 12:05 AM
 */
@Singleton
public class AnalyticsServiceImp implements AnalyticsService {
    @Inject
    public AnalyticsServiceImp() {
    }

    @Override
    public void analytics() {
        System.out.println("test----- in 【modulea】 AnalyticsServiceImp call analytics!");
    }

    @Module
    @InstallIn(ApplicationComponent.class)
    // 要是作为内部类，需要加上static，要么你上AnalyticsServiceImpl_b里的一样，作为一个单独的类
    public static abstract class AnalyticsModule {
        @Binds
        // 通过实现类，以及@Binds处加上@Singleton，实现单例
        @Singleton
        public abstract AnalyticsService bindAnalyticsService(AnalyticsServiceImp analyticsService);
    }
}
