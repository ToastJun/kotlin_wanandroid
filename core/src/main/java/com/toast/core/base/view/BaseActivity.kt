package com.toast.core.base.view

import android.os.Bundle

/**
 * @author toast
 * @date 2020/4/22 16:45
 * @description
 */
abstract class BaseActivity: InjectionActivity() {
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}