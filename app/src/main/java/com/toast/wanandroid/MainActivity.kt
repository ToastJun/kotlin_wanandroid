package com.toast.wanandroid

import android.os.Bundle
import com.toast.core.base.view.BaseActivity
import com.toast.wanandroid.ui.login.LoginViewModel
import com.toast.wanandroid.ui.login.kodeinLoginModule
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

class MainActivity : BaseActivity() {

    // 创建一个不受Activity重启影响的 kodein 对象
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)
        import(kodeinLoginModule)
    }

    override val layoutId: Int = R.layout.activity_main

    private val mViewModule: LoginViewModel by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    fun initData() {
        mViewModule.login()
    }
}

