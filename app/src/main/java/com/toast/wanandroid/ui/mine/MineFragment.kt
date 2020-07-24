package com.toast.wanandroid.ui.mine

import android.os.Bundle
import android.view.View
import com.toast.core.base.view.BaseFragment
import com.toast.core.ext.observe
import com.toast.core.ext.toastSafe
import com.toast.wanandroid.R
import com.toast.wanandroid.entity.user.UserInfo
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.include_mine_layout.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author toast
 * @date 2020/4/29 17:38
 * @description
 */
class MineFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_mine

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(kodeinMineModule)
    }

    private val mViewModel: MineViewModel by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        binds()
        initData()
    }

    private fun initView() {
        refreshLayout.setOnRefreshListener {
            initData()
        }
    }

    private fun initData() {
        mViewModel.getUserInfo()
        mViewModel.fetchUserCoin()
    }

    private fun binds() {
        observe(mViewModel.stateLiveData, ::onNewState)
    }

    private fun onNewState(state: MineViewState) {
        refreshLayout.finishRefresh()
        if (state.error != null) {
            context?.toastSafe(state.error.message ?: "error")
        }
        if (state.userInfo != null) {
            fillUserInfo(state.userInfo)
        }
        if (state.userCoin != null) {
            tvCoinTitle.text = "你的积分为 ${state.userCoin.coinCount}"
            tvCoinDesc.text = "你目前排名第 ${state.userCoin.rank} 位"
        }
    }

    private fun fillUserInfo(userInfo: UserInfo) {
        tvUserName.text = userInfo.username

    }
}