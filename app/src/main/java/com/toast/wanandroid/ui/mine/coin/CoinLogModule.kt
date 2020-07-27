package com.toast.wanandroid.ui.mine.coin

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

/**
 * @author toast
 * @date 2020/7/24 15:14
 * @description
 */
private const val COIN_LOG_MODULE_TAG = "coin_log_module_tag"

val kodeinCoinLogModule = Kodein.Module(COIN_LOG_MODULE_TAG) {

    bind<CoinLogViewModel>() with scoped<AppCompatActivity>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, CoinLogViewModelFactory()).get(CoinLogViewModel::class.java)
    }
}