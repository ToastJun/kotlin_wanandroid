package com.toast.wanandroid.utils

import android.app.Notification.EXTRA_TEXT
import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class SmsCodeNotifyService: NotificationListenerService() {
    /**
     * 默认为空字符串
     */
    private var data: String? = ""

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("SmsCodeNotifyService", "onStartCommand")
        data = intent?.getStringExtra("data")
        Log.i("SmsCodeNotifyService", "data=$data")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        // 非空安全判断
        if (sbn?.notification?.tickerText.isNullOrEmpty()) {
            return
        }
        val message = sbn?.notification?.tickerText.toString()
        val extraText = sbn?.notification?.extras?.get(EXTRA_TEXT)
        Log.i("SmsCodeNotifyService", "message=$message")
        Log.i("SmsCodeNotifyService", "extraText=$extraText")
        super.onNotificationPosted(sbn)
    }
}