package com.bruce.moduleb.hilt;

import android.content.Context;

import com.andrew.architecture.services.service.AnalyticsService3;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ActivityScoped;

/**
 * @Description: Java类作用描述
 * @CreateDate: 2021/3/4 10:18 AM
 */
@Singleton
public class AnalyticsServiceImpl_b3 {

    // 没有接口，直接使用实体类的情况，是可以直接使用构造函数进行注入，不需要写@Binds或@Provider的
    @Inject
    public AnalyticsServiceImpl_b3(@ApplicationContext Context context) {
        System.out.println("test----- in AnalyticsServiceImpl_b3 constructor ApplicationContext:" + context);
    }

    public void analytics() {
        System.out.println("test----- int AnalyticsServiceImpl_b3 cal analytics name:");
    }
}

