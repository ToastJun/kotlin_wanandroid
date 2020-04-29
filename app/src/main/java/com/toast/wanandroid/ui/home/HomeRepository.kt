package com.toast.wanandroid.ui.home

import com.toast.core.base.repository.BaseRepositoryBoth
import com.toast.core.base.repository.ILocalDataSource
import com.toast.core.base.repository.IRemoteDataSource
import com.toast.wanandroid.entity.ArticleInfoList
import com.toast.wanandroid.http.Results
import com.toast.wanandroid.http.processApiResponse
import com.toast.wanandroid.http.service.ServiceManager

/**
 * @author toast
 * @date 2020/4/29 11:20
 * @description 首页数据repo
 */
class HomeRepository(
    remoteDataSource: HomeRemoteDataSource,
    localDataSource: HomeLocalDataSource
) : BaseRepositoryBoth<HomeRemoteDataSource, HomeLocalDataSource>(
    remoteDataSource,
    localDataSource
) {
    // 获取首页文章列表数据
    suspend fun fetchRemoteArticleList(page: Int = 1): Results<ArticleInfoList> {
        return remoteDataSource.fetchArticleList(page)
    }
}

class HomeRemoteDataSource(
    private val serviceManager: ServiceManager
) : IRemoteDataSource {

    // 获取首页文章列表数据
    suspend fun fetchArticleList(page: Int = 1): Results<ArticleInfoList> {
        // 此接口page从0开始，这里默认作减1处理
        val page = if (page < 0) 0 else page - 1
        val response = serviceManager.articleService.fetchArticleList(page.toString())
        return processApiResponse(response)
    }
}

class HomeLocalDataSource : ILocalDataSource {

}