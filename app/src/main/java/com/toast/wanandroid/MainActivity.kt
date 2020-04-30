package com.toast.wanandroid

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.toast.core.base.view.BaseActivity
import com.toast.core.ext.observe
import com.toast.wanandroid.entity.ArticleInfo
import com.toast.wanandroid.ui.login.LoginViewModel
import com.toast.wanandroid.ui.login.kodeinLoginModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_rv_article.view.*
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

    override fun initView() {
    }

    private fun initData() {
        mViewModule.login()
    }
}

