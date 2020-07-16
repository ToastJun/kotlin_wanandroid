package com.toast.wanandroid.di

import android.content.Context
import android.content.SharedPreferences
import com.toast.wanandroid.base.ToastApp
import com.toast.wanandroid.repository.UserInfoRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/7/16 14:06
 * @description 可供全局使用的 repository module
 */

private const val DEFAULT_SP_TAG = "PrefsDefault"

private const val GLOBAL_REPOSITORIES_MODULE = "global_repositories_module"

val kodeinGlobalRepositoriesModule = Kodein.Module(GLOBAL_REPOSITORIES_MODULE) {

    bind<SharedPreferences>(DEFAULT_SP_TAG) with singleton {
        ToastApp.INSTANCE.getSharedPreferences(DEFAULT_SP_TAG, Context.MODE_PRIVATE)
    }

    bind<UserInfoRepository>() with singleton {
        UserInfoRepository(instance(DEFAULT_SP_TAG))
    }
}