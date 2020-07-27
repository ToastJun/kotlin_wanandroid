package com.toast.wanandroid.ui.mine

import com.toast.wanandroid.entity.coin.CoinBean
import com.toast.wanandroid.entity.user.UserInfo

/**
 * @author toast
 * @date 2020/7/20 15:08
 * @description
 */
data class MineViewState(
    val isLoading: Boolean,
    val userInfo: UserInfo?,
    val userCoin: CoinBean?,
    val error: Throwable?
) {
    companion object {
        fun initial(): MineViewState {
            return MineViewState(
                isLoading = false,
                userInfo = null,
                userCoin = null,
                error = null
            )
        }
    }
}