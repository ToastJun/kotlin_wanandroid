package com.toast.wanandroid.http.service

import com.toast.wanandroid.http.bean.BasePandaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author toast
 * @date 2020/7/29 15:35
 * @description 一些项目无关的三方api
 */
interface ThridApiService {

    /**
     * 获取panda配送端的验证码
     */
    @GET("/api/user/getCaptcha")
    suspend fun getCaptcha(@Query("telephone") telephone: String, @Query("macId") macId: String, @Query("areaCode") areaCode: String): Response<BasePandaResponse<Boolean>>
}