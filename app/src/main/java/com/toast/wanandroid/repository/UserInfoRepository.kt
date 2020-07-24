package com.toast.wanandroid.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.toast.core.ext.prefs.long
import com.toast.core.ext.prefs.string
import com.toast.core.utils.SingletonHolderSingleArgs
import com.toast.wanandroid.entity.user.UserInfo

/**
 * @author toast
 * @date 2020/7/15 14:33
 * @description
 */
class UserInfoRepository(private val prefs: SharedPreferences) {
    var userId: Long by prefs.long("userId", 0L)

    var username: String by prefs.string("username", "")

    var password: String by prefs.string("password", "")

    private var userInfoJson: String by prefs.string("userInfo", "")

    var userInfo: UserInfo
        get() {
            if (userInfoJson.isEmpty()) {
                return UserInfo()
            }
            return Gson().fromJson<UserInfo>(userInfoJson, UserInfo::class.java)
        }
        set(value) {
            userInfoJson = Gson().toJson(value)
        }

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
        userInfoJson = ""
    }

    companion object :
            SingletonHolderSingleArgs<UserInfoRepository, SharedPreferences>(::UserInfoRepository)
}
