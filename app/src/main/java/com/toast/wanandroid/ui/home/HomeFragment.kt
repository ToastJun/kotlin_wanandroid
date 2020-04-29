package com.toast.wanandroid.ui.home

import com.toast.core.base.view.BaseFragment
import com.toast.wanandroid.R
import org.kodein.di.Kodein

/**
 * @author toast
 * @date 2020/4/29 9:50
 * @description
 */
class HomeFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_home

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(kodeinHomeModule)
    }
}