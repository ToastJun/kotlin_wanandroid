package com.toast.wanandroid.ui.web

import com.toast.core.base.view.BaseActivity
import com.toast.wanandroid.R
import kotlinx.android.synthetic.main.activity_webview.*
import org.kodein.di.Kodein

/**
 * @author toast
 * @date 2020/4/30 15:47
 * @description
 */
class WebviewActivity : BaseActivity() {
    override val layoutId = R.layout.activity_webview

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }

    override fun initView() {
        WebviewUtils.init(this)
        WebviewUtils.setDefaultWebSetting(webview)
        // 根据url加载
        val url = intent.getStringExtra("url")
        webview.loadUrl(url)
    }

}