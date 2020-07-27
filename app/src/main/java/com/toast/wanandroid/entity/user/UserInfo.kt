package com.toast.wanandroid.entity.user

/**
 * @author toast
 * @date 2020/4/23 15:24
 * @description
 */
data class UserInfo(
    val id: Long = 0,
    val nickname: String = "",
    val username: String = "",
    val icon: String = "",
    val token: String = "",
    val type: Int = 0,
    val publicName: String = "",
    val email: String = "",
    val admin: Boolean = false,
    val chapterTops: List<Int> = emptyList(),
    val collectIds: List<Int> = emptyList()
)