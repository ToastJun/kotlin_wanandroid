package com.toast.wanandroid.ui.mine.coin

import com.toast.wanandroid.entity.coin.CoinLogBean

/**
 * @author toast
 * @date 2020/7/24 15:40
 * @description
 */
data class CoinLogViewState(
    val isLoading: Boolean,
    val coinLog: MutableList<CoinLogBean>?,
    val error: Throwable?
) {

    companion object {
        fun initial(): CoinLogViewState {
            return CoinLogViewState(
                isLoading = false,
                coinLog = null,
                error = null
            )
        }
    }
}