package com.toast.wanandroid.ui.mine

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
 * @date 2020/7/20 16:12
 * @description
 */
private const val MINE_MODULE_TAG = "mine_module_tag"

val kodeinMineModule = Kodein.Module(MINE_MODULE_TAG) {

    bind<MineViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, MineViewModelFactory(instance())).get(MineViewModel::class.java)
    }

    bind<MineRepository>() with singleton {
        MineRepository(instance(), instance())
    }

    bind<MineLocalRepository>() with singleton {
        MineLocalRepository(instance())
    }

    bind<MineRemoteRepository>() with singleton {
        MineRemoteRepository(instance())
    }
}