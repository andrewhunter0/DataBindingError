package com.bruce.moduleb.hilt;

import android.content.Context;

import com.andrew.architecture.services.service.AnalyticsService3;
import com.andrew.architecture.services.service.AnalyticsService3One;
import com.andrew.architecture.services.service.AnalyticsService3Two;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ActivityScoped;

/**
 * @Description: 测试一个接口的多实例
 * @CreateDate: 2021/1/25 12:05 AM
 */
@Singleton
public class AnalyticsServiceImpl_b22 implements AnalyticsService3 {
    String name;

//    @Inject
    // 使用@Provides来提供实例时，不需要给构建函添加@Inject注解，因为是自己实例化
    public AnalyticsServiceImpl_b22(Context context, String name) {
        this.name = name;
        System.out.println("test----- int AnalyticsServiceImpl_b22 constructor name:" + name);

        System.out.println("test----- int AnalyticsServiceImpl_b22 constructor AnalyticsService:"
                + EntryPointHelper.INSTANCE.getEntryPoint(context).getAnalyticsService());
    }

    public void analytics() {
        System.out.println("test----- int AnalyticsServiceImpl_b22 cal analytics name:" + name);
    }

//    @Module
////    @InstallIn(ActivityComponent.class)
//    // 当使用@InstallIn(ActivityComponent.class)时，对应的@Provides要修改为@ActivityScoped，而不能是
//    // ApplicationComponent与@Singleton对应
//    @InstallIn(SingletonComponent.class)
//    public static class AnalyticsModule_b22 {
//        @AnalyticsService3Two
//        @Provides
////        @ActivityScoped
//        // @Singleton
//        // 方法名字可以自己取的，建议用providerAnalyticsService，这里只是测试
//        public AnalyticsService3 proAnalytics22(@ApplicationContext Context context) {
//            return new AnalyticsServiceImpl_b22(context, "name is AnalyticsServiceImpl_b22 ActivityScoped!!!");
//        }
//    }
}

