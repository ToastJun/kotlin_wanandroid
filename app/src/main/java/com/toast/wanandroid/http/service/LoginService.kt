package com.toast.wanandroid.http.service

import com.toast.wanandroid.entity.user.UserInfo
import com.toast.wanandroid.http.bean.BaseResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author toast
 * @date 2020/4/22 18:31
 * @description wanandroid 登录api
 */
interface LoginService {

    /**
     * 登录
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
        @Field(value="username") username: String,
        @Field(value="password") password: String
    ): Response<BaseResponse<UserInfo>>

    /**
     * 登出
     */
    @GET("/user/logout/json")
    fun logout(): Response<String>
}