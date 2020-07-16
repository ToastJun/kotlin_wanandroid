package com.toast.wanandroid.ui.login

import com.toast.wanandroid.entity.user.UserInfo

/**
 * @author toast
 * @date 2020/4/24 16:35
 * @description
 */
data class LoginViewState(
    val isLoading: Boolean,
    val userInfo: UserInfo?,
    val throwable: Throwable?
) {
    companion object {
        fun initial(): LoginViewState {
            return LoginViewState(
                isLoading = false,
                userInfo = null,
                throwable = null
            )
        }
    }
}