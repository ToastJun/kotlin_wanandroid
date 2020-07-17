package com.toast.wanandroid.repository

import android.content.SharedPreferences
import com.toast.core.ext.prefs.long
import com.toast.core.ext.prefs.string
import com.toast.core.utils.SingletonHolderSingleArgs

/**
 * @author toast
 * @date 2020/7/15 14:33
 * @description
 */
class UserInfoRepository(private val prefs: SharedPreferences) {
    var userId: Long by prefs.long("userId", 0L)

    var username: String by prefs.string("username", "")

    var password: String by prefs.string("password", "")

    /**
     * 如果本地存放的不是0，则认为已经登录
     */
    fun hasLogin():Boolean {
        return userId != 0L
    }

    /**
     * 清空用户本地数据
     */
    fun clearUserInfo() {
        userId = 0
        username = ""
        password = ""
    }

    companion object :
            SingletonHolderSingleArgs<UserInfoRepository, SharedPreferences>(::UserInfoRepository)
}
