package com.toast.wanandroid.entity.coin

/**
 * @author toast
 * @date 2020/7/21 11:22
 * @description
 */
data class CoinRankBean(
    var coinCount: Int,
    var level: Int,
    var rank: String,
    var userId: Long,
    var username: String
)