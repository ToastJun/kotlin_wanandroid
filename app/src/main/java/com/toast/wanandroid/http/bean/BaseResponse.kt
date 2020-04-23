package com.toast.wanandroid.http.bean

/**
 * @author toast
 * @date 2020/4/23 15:14
 * @description
 */
data class BaseResponse<T>(
    var data: T,
    val errorCode: Int,
    val errorMsg: String
)