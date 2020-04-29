package com.toast.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.toast.core.base.view.BaseFragment

/**
 * @author toast
 * @date 2020/4/29 16:57
 * @description
 */
class HomeFragmentAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments: Map<Int, BaseFragment> = mapOf(
        0 to HomeFragment(),
        1 to HomeFragment()
    )

    override fun getItem(position: Int): BaseFragment {
        return fragments[position] ?: error("")
    }

    override fun getCount(): Int {
        return fragments.size
    }

}