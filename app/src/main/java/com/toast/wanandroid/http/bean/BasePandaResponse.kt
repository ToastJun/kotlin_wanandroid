package com.toast.wanandroid.http.bean

/**
 * @author toast
 * @date 2020/7/29 16:17
 * @description
 */
data class BasePandaResponse<T>(
    val resultCode: String,
    val error: String,
    val nowTime: Long,
    val reason: String,
    val msg: String,
    val result: T
)