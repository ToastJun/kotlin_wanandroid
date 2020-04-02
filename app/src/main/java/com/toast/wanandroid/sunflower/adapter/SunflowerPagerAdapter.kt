package com.toast.wanandroid.sunflower.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author toast
 * @date 2020/4/2 17:34
 * @description
 */

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class SunflowerPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    /**
     * 存储ViewPager对应的Fragment的Map
     */
    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        MY_GARDEN_PAGE_INDEX to {Fragment()},
        PLANT_LIST_PAGE_INDEX to {Fragment()}
    )

    override fun getItemCount() = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}