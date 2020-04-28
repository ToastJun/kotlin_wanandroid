package com.toast.wanandroid.ui.home

import com.toast.core.base.view.BaseActivity
import com.toast.wanandroid.R
import org.kodein.di.Kodein

/**
 * @author toast
 * @date 2020/4/28 15:43
 * @description
 */

class HomeActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_home

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)

    }



}