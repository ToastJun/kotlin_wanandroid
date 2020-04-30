package com.toast.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/4/29 11:45
 * @description
 */

private const val HOME_MODULE_TAG = "home_module_tag"

val kodeinHomeModule = Kodein.Module(HOME_MODULE_TAG) {

    bind<HomeViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, HomeViewModuleFactory(instance())).get(HomeViewModel::class.java)
    }

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