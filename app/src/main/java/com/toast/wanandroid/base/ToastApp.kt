package com.toast.wanandroid.base

import android.content.Context
import com.tencent.mmkv.MMKV
import com.toast.core.base.BaseApplication
import com.toast.wanandroid.di.httpClientModule
import com.toast.wanandroid.di.kodeinGlobalRepositoriesModule
import com.toast.wanandroid.di.serviceModule
import org.kodein.di.Kodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/4/22 18:11
 * @description
 */
class ToastApp: BaseApplication() {

    override val kodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@ToastApp }
        import(androidXModule(this@ToastApp))

        import(httpClientModule)
        import(serviceModule)
        import(kodeinGlobalRepositoriesModule)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initMMKV()
    }

    private fun initMMKV() {
        MMKV.initialize(this)
    }

    companion object {
        lateinit var INSTANCE: ToastApp
    }
}