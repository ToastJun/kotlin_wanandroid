package com.toast.wanandroid.ui.main

/**
 * @author toast
 * @date 2020/7/16 11:03
 * @description
 */
data class MainViewState(
    val isFinishInit: Boolean,
    val autoLoginEvent: AutoLoginEvent?
) {
    companion object {
        fun initial(): MainViewState {
            return MainViewState(
                isFinishInit = true,
                autoLoginEvent = null
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MainViewState

        if (isFinishInit != other.isFinishInit) return false
        if (autoLoginEvent != other.autoLoginEvent) return false
        return true
    }
}