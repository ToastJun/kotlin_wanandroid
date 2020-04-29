package com.toast.wanandroid.ui.home

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/4/29 11:45
 * @description
 */

private const val HOME_MODULE_TAG = "home_module_tag"

val kodeinHomeModule = Kodein.Module(HOME_MODULE_TAG) {

    bind<HomeRepository>() with singleton {
        HomeRepository(instance(), instance())
    }

    bind<HomeRemoteDataSource>() with singleton {
        HomeRemoteDataSource(instance())
    }

    bind<HomeLocalDataSource>() with singleton {
        HomeLocalDataSource()
    }
}