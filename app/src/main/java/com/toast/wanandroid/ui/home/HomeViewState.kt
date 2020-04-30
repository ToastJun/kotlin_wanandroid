package com.toast.wanandroid.ui.home

import com.toast.wanandroid.entity.ArticleInfoList

/**
 * @author toast
 * @date 2020/4/30 9:49
 * @description
 */
data class HomeViewState(
    var isLoading: Boolean,
    var error: Throwable?,
    var page: Int,
    var articleInfoList: ArticleInfoList?
) {

    companion object {
        fun initial(): HomeViewState {
            return HomeViewState(
                isLoading = false,
                error = null,
                page = 1,
                articleInfoList = null
            )
        }
    }
}