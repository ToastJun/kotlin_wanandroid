package com.toast.wanandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/7/16 11:21
 * @description
 */
private const val MAIN_MODULE_TAG = "main_module_tag"

val kodeinMainModule = Kodein.Module(MAIN_MODULE_TAG) {
    // MainViewModel
    bind<MainViewModel>() with scoped<AppCompatActivity>(AndroidLifecycleScope).singleton {
        // 使用 ViewModelFactory 提供实例
        ViewModelProvider(this.context, MainViewModelFactory(instance(), instance())).get(MainViewModel::class.java)
    }


}