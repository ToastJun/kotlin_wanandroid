package com.toast.wanandroid.entity.user

/**
 * @author toast
 * @date 2020/4/23 15:24
 * @description
 */
data class UserInfo(
    val id: Long,
    val nickname: String,
    val username: String,
    val icon: String,
    val token: String,
    val type: Int,
    val publicName: String,
    val email: String,
    val admin: Boolean,
    val chapterTops: List<Int>,
    val collectIds: List<Int>
)