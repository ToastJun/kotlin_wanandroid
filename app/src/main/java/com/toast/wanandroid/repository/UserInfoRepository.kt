package com.toast.wanandroid.repository

import android.content.SharedPreferences
import com.toast.core.ext.prefs.string
import com.toast.core.utils.SingletonHolderSingleArgs

/**
 * @author toast
 * @date 2020/7/15 14:33
 * @description
 */
class UserInfoRepository(prefs: SharedPreferences) {
    var accessToken: String by prefs.string("access_token", "")

    var username: String by prefs.string("username", "")

    var password: String by prefs.string("password", "")

    companion object :
            SingletonHolderSingleArgs<UserInfoRepository, SharedPreferences>(::UserInfoRepository)
}
