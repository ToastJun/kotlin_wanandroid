package com.toast.wanandroid.sunflower.adapter

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.toast.wanandroid.R

/**
 * @author toast
 * @date 2020/4/9 15:00
 * @description
 */
@BindingAdapter("wateringText")
fun bindWateringText(textView: TextView, waitering: Int) {
    val resources = textView.context.resources
    val quantityString =
        resources.getQuantityString(R.plurals.watering_needs_suffix, waitering, waitering)
    textView.text = quantityString
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(textView: TextView, renderHtml: String?) {
    if (renderHtml != null) {
        textView.text = HtmlCompat.fromHtml(renderHtml, HtmlCompat.FROM_HTML_MODE_COMPACT)
        textView.movementMethod = LinkMovementMethod.getInstance()
    } else {
        textView.text = ""
    }
}