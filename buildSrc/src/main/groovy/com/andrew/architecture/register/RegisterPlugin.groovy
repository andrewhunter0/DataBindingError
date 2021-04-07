package com.andrew.architecture.register

//import com.android.build.gradle.AppExtension
import com.android.build.gradle.api.AndroidBasePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *  插件注册入口
 */
class RegisterPlugin implements Plugin<Project> {
    private static final String TAG = "RegisterPlugin"

    @Override
    void apply(Project target) {
        println "test-----in RegisterPlugin apply!"
        target.plugins.withType(AndroidBasePlugin) {
            // Find BaseExtension (you probably want this so that the plugin is relevant for android.library too)
            // Note that this closure will only be invoked once the Android Plugin has been found and applied.
            def android = target.extensions.getByType(BaseExtension)
//            android.registerTransform(new RegisterTransform(target))
        }
//        def android = target.extensions.getByType(AppExtension)
//        android.registerTransform(new RegisterTransform(target))
    }
}