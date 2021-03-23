package com.andrew.architecture.core.base

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author      andrew
 * @date        2020/8/9 11:46 PM
 * @description 基础Activity类
 */
open class BaseActivity: FragmentActivity() {
    private var viewModelProvider: ViewModelProvider? = null

    /**
     * 子类调用初使化ViewModel
     */
    fun <T : ViewModel> initViewModel(modelClass: Class<T>): T {
        if (viewModelProvider == null) {
            viewModelProvider = ViewModelProvider(this)
        }
        return viewModelProvider!!.get(modelClass)
    }
}