package com.andrew.architecture.utils

import android.content.Context

/**
 * @author      andrew
 * @date        2020/9/1 20:20 PM
 * @description 屏幕相关的工具
 */
object ScreenUtils {
    @Volatile
    private var sScreenWidth = 0
    @Volatile
    private var sScreenHeight = 0

    /**
     * 四舍五入
     */
    private const val DOT_FIVE = 0.5f

    fun getScreenWidth(context: Context): Int {
        if (sScreenWidth == 0) {
            val dm = context.resources.displayMetrics
            sScreenWidth = dm.widthPixels
        }
        return sScreenWidth
    }

    fun getScreenHeight(context: Context): Int {
        if (sScreenHeight == 0) {
            val dm = context.resources.displayMetrics
            sScreenHeight = dm.heightPixels
        }
        return sScreenHeight
    }

    /**
     * dip转换成px
     *
     * @param context Context
     * @param dip     dip Value
     *
     * @return 换算后的px值
     */
    fun dip2px(context: Context, dip: Float): Int {
        val density = getDensity(context)
        return (dip * density + DOT_FIVE).toInt()
    }

    /**
     * px转换成dip
     *
     * @param context Context
     * @param px      px Value
     *
     * @return 换算后的dip值
     */
    fun px2dip(context: Context, px: Float): Int {
        val density = getDensity(context)
        return (px / density + DOT_FIVE).toInt()
    }

    /**
     * 得到显示密度
     *
     * @param context Context
     *
     * @return 密度
     */
    fun getDensity(context: Context): Float {
        val dm = context.resources.displayMetrics
        return dm.density
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    fun getStatusBarHeight(context: Context): Int {
        val res = context.resources
        var result = 0
        val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId)
        }
        return result
    }
}