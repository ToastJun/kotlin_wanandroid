package com.toast.wanandroid.ui.web

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @author toast
 * @date 2020/4/30 16:12
 * @description
 */
@SuppressLint("StaticFieldLeak")
object WebviewUtils {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    /**
     * 对webview进行一些默认的设置
     */
    fun setDefaultWebSetting(webview: WebView) {
        val settings = webview.settings
        // 5.0以上开启混合模式加载
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        // 允许js代码
        settings.javaScriptEnabled = true
        // 允许SessionStorage/LocalStorage存储
        settings.domStorageEnabled = true
        // 禁用缩放
        settings.displayZoomControls = false
        settings.builtInZoomControls = false
        // 禁用文字缩放
        settings.textZoom = 100
        // 允许缓存，设置缓存位置
        settings.setAppCacheEnabled(true)
        settings.setAppCachePath(context.getDir("appcache", 0).path)
        // 允许使用File协议
        settings.allowFileAccess = true
        // 设置UA
        settings.userAgentString = settings.userAgentString + " toastWanAndroid"
        // 自动加载图片
        settings.loadsImagesAutomatically = true
    }
}