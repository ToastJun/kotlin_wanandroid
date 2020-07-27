package com.toast.wanandroid.entity.coin

/**
 * @author toast
 * @date 2020/7/20 18:35
 * @description
 */
data class CoinLogBean(
    var id: Long,
    var coinCount: Int,
    var date: Long,
    var desc: String,
    var reason: String,
    var type: Int,
    var userId: Long,
    var userName: String
)