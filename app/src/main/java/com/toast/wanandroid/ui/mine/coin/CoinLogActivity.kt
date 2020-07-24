package com.toast.wanandroid.ui.mine.coin

import com.toast.core.base.view.BaseActivity
import com.toast.core.ext.observe
import com.toast.core.ext.toastSafe
import com.toast.wanandroid.R
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

/**
 * @author toast
 * @date 2020/7/24 14:10
 * @description
 */
class CoinLogActivity : BaseActivity() {

    override val layoutId: Int = R.layout.activity_coin_log

    override val kodein: Kodein by retainedKodein{
        extend(parentKodein)
    }

    private val mViewModel: CoinLogViewModel by instance()

    override fun initView() {

        binds()
    }

    private fun binds() {
        observe(mViewModel.stateLiveData, ::onNewState)
    }

    private fun onNewState(state: CoinLogViewState) {
        if (state.error != null) {
            toastSafe(state.error.message ?: "error")
        }
    }
}