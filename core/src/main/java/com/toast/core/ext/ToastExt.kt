package com.toast.core.ext

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * @author toast
 * @date 2020/4/22 10:29
 * @description Toast相关的扩展类
 */

val mainHandler: Handler = Handler(Looper.getMainLooper())

fun Context.toast(value: String, type: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, value, type).show()
}

fun Context.toastSafe(value: String) {
    mainHandler.post {
        toast(value)
    }
}