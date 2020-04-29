package com.toast.wanandroid.ui.mine

import android.os.Bundle
import android.view.View
import com.toast.core.base.view.BaseFragment
import com.toast.wanandroid.R
import com.toast.wanandroid.ui.home.kodeinHomeModule
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.kodein.di.Kodein

/**
 * @author toast
 * @date 2020/4/29 17:38
 * @description
 */
class MineFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_home

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(kodeinHomeModule)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.tvSearch.text = "Mine"
    }
}