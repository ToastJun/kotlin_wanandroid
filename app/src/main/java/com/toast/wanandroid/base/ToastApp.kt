package com.toast.wanandroid.base

import android.content.Context
import com.toast.core.base.BaseApplication
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
    }

    override fun onCreate() {
        super.onCreate()

    }
}