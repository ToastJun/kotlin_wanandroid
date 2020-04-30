package com.toast.wanandroid.ui.web

import com.toast.core.base.view.BaseActivity
import com.toast.wanandroid.R
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

    }

}