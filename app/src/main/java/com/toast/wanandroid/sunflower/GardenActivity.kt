package com.toast.wanandroid.sunflower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.ActivityGardenBinding


/**
 * @author toast
 * @date 2020/4/2 15:54
 * @description
 */
class GardenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)
    }
}