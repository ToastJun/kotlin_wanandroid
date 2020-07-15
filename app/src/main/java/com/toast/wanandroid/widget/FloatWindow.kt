package com.toast.wanandroid.widget

import android.view.View
import android.view.WindowManager

/**
 * @author toast
 * @date 2020/5/15 16:56
 * @description 全局悬浮窗
 */

object FloatWindow {

    // 和悬浮窗布局相关的参数
    class WindowInfo(var view: View?) {
        var layoutParams: WindowManager.LayoutParams? = null

        var width: Int = 0

        var height: Int = 0

        fun hasView() = view != null && layoutParams != null

        fun hasParent() = hasView() && view?.parent != null
    }
}