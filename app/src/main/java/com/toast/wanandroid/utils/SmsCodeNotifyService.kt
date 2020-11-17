package com.toast.wanandroid.utils

import android.app.Notification.EXTRA_TEXT
import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.text.TextUtils
import android.util.Log
import com.toast.wanandroid.ui.main.MainActivity
import org.greenrobot.eventbus.EventBus
import java.util.regex.Pattern

class SmsCodeNotifyService: NotificationListenerService() {
    /**
     * 默认为空字符串
     */
    private var data: String? = ""

    private val keyText: String = "自定义"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("SmsCodeNotifyService", "onStartCommand")
        data = intent?.getStringExtra("data")
        Log.i("SmsCodeNotifyService", "data=$data")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        // 非空安全判断
        try {
            val extraText = sbn?.notification?.extras?.get(EXTRA_TEXT).toString()
            // 过滤一些不需要的短信内容
            if (extraText.isNotEmpty() && extraText.contains(keyText)) {
                // 进行验证码正则截取
                val code = matcherCode(extraText)
                EventBus.getDefault().post(CodeEvent(code))
                Log.i("code", code)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun matcherCode(tag: String): String {
        var result = ""
        val pattern = Pattern.compile("\\d+")
        val matcher = pattern.matcher(tag)
        while (matcher.find()) {
            result = matcher.group(0)
            break
        }
        return result
    }
}

data class CodeEvent(val code: String)