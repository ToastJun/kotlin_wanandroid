package com.toast.wanandroid.http.service

import com.toast.wanandroid.entity.BaseListBean
import com.toast.wanandroid.entity.coin.CoinBean
import com.toast.wanandroid.entity.coin.CoinLogBean
import com.toast.wanandroid.entity.coin.CoinRankBean
import com.toast.wanandroid.http.bean.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author toast
 * @date 2020/4/22 18:30
 * @description
 */
interface UserService {

    /**
     * 获取用户积分信息
     */
    @GET("/lg/coin/userinfo/json")
    suspend fun fetchUserCoin(): Response<BaseResponse<CoinBean>>

    /**
     * 用户积分获取记录列表
     * @param page 从1开始
     */
    @GET("/lg/coin/list/{page}/json")
    suspend fun fetchUserCoinLogList(@Path("page") page: Int): Response<BaseResponse<BaseListBean<CoinLogBean>>>

    /**
     * 积分排行榜
     */
    @GET("/coin/rank/{page}/json")
    suspend fun fetchCoinRankList(@Path("page") page: Int): Response<BaseResponse<BaseListBean<CoinRankBean>>>
}