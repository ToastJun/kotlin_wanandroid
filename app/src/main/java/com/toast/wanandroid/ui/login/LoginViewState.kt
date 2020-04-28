package com.toast.wanandroid.ui.login

import com.toast.wanandroid.entity.ArticleInfoList

/**
 * @author toast
 * @date 2020/4/24 16:35
 * @description
 */
data class LoginViewState(
    var isLoading: Boolean,
    var articleInfoList: ArticleInfoList?
) {
    companion object {
        fun initial(): LoginViewState {
            return LoginViewState(
                isLoading = false,
                articleInfoList = null
            )
        }
    }
}