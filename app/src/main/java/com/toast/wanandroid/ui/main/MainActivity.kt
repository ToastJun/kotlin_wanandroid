package com.toast.wanandroid.ui.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import com.toast.core.base.view.BaseActivity
import com.toast.core.ext.observe
import com.toast.wanandroid.R
import com.toast.wanandroid.ui.home.HomeActivity
import com.toast.wanandroid.ui.login.LoginActivity
import com.toast.wanandroid.utils.SmsCodeNotifyService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.notify
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

class MainActivity : BaseActivity() {

    // 创建一个不受Activity重启影响的 kodein 对象
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        import(kodeinMainModule)
    }

    override val layoutId: Int = R.layout.activity_main

    private val mViewModel: MainViewModel by instance()

    override fun initView() {
        tvGoNotifySetting.setOnClickListener {
            getNotificationListenerPer()
        }
        tvNotify.setOnClickListener {
            openNotification()
        }
        initData()
    }

    private fun initData() {
        binds()
        val intent = Intent(this, SmsCodeNotifyService::class.java)
        startService(intent)
//        mViewModel.checkIsLogin()
    }

    private fun binds() {
        observe(mViewModel.stateLiveData, this::onNewState)
    }

    private fun onNewState(state: MainViewState) {
        if (state.autoLoginEvent != null) {
            // 已登录跳转到首页，未登录跳转到登录界面
            when (state.autoLoginEvent.hasLogin && state.isFinishInit) {
                true -> startActivity(Intent(this, HomeActivity::class.java))
                false -> startActivity(Intent(this, LoginActivity::class.java))
            }.also { finish() }
        }
    }

    private fun getNotificationListenerPer() {
        val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
        startActivity(intent)
    }

    var num:Int = 1

    private fun openNotification() {
        val notification = NotificationCompat.Builder(this, "myChannelId")
            .setTicker("我是Ticker")
            .setContentText("我是ContentText")
            .setContentTitle("我是ContentTitle")
            .setSmallIcon(R.mipmap.ic_launcher)
//            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setWhen(System.currentTimeMillis())
            .setDefaults(Notification.DEFAULT_ALL)
            .setAutoCancel(true)
            .build()
        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("myChannelId", "channel name", NotificationManager.IMPORTANCE_HIGH)
            channel.description = "channel description"
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(num++, notification)
    }
}

