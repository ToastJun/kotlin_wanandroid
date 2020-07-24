package com.toast.wanandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.toast.wanandroid.R
import kotlinx.android.synthetic.main.view_common_toolbar.view.*

/**
 * @author toast
 * @date 2020/7/24 14:13
 * @description
 */
class CommonToolBar(
    context: Context,
    attributes: AttributeSet?
) : FrameLayout(context, attributes) {

    private lateinit var commonToolBar: View

    init {
        initView(context)
    }

    private fun initView(context: Context) {
        commonToolBar = View.inflate(context, R.layout.view_common_toolbar, this)
    }

    /**
     * 标题栏标题
     */
    var title: String = ""
        get() {
            return commonToolBar.tvTitle.text.toString()
        }
        set(value) {
            commonToolBar.tvTitle.text = value
            field = value
        }

    /**
     * 标题栏左侧图片资源id
     */
    var leftImageResource : Int = 0
        set(value) {
            commonToolBar.ivLeftBack.setImageResource(value)
        }
}