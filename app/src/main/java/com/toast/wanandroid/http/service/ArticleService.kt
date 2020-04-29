package com.toast.wanandroid.http.service

import com.toast.wanandroid.entity.ArticleInfoList
import com.toast.wanandroid.http.bean.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author toast
 * @date 2020/4/29 11:27
 * @description 首页数据api
 */
interface ArticleService {

    /**
     * 获取文章列表
     * page从0起始
     */
    @GET("/article/list/{page}/json")
    suspend fun fetchArticleList(@Path("page") page: String): Response<BaseResponse<ArticleInfoList>>
}