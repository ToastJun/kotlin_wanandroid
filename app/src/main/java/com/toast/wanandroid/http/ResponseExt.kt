package com.toast.wanandroid.http

import com.toast.wanandroid.http.bean.BaseResponse
import retrofit2.Response
import java.io.IOException


/**
 * @author toast
 * @date 2020/4/23 14:26
 * @description 处理服务请求返回的response
 */

fun <T> processApiResponse(response: Response<BaseResponse<T>>): Results<T> {
    return try {
        val responseCode = response.code()
        val responseMessage = response.message()
        if (response.isSuccessful) {
            // 根据业务code，判断是否成功
            val body = response.body()!!
            if (body.errorCode != 0) {
                // errorCode = -1001 未登录
                if (body.errorCode == -1001) {

                }
                Results.failure(Errors.NetworkError(body.errorCode, body.errorMsg))
            } else {
                Results.success(body.data)
            }
        } else {
            Results.failure(Errors.NetworkError(responseCode, responseMessage))
        }
    } catch (e: IOException) {
        Results.failure(Errors.NetworkError())
    }

}