package com.toast.wanandroid.sunflower.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author toast
 * @date 2020/4/8 13:56
 * @description
 */
@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if(isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, url: String?) {
    // 使用 glide 加载图片
    if (!url.isNullOrEmpty()) {
        Log.e("T", "loadurl")
        Glide.with(view).load(url).into(view)
    }
}