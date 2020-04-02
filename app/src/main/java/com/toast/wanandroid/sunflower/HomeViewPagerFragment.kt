package com.toast.wanandroid.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.FragmentHomeViewPagerBinding
import com.toast.wanandroid.sunflower.adapter.MY_GARDEN_PAGE_INDEX
import com.toast.wanandroid.sunflower.adapter.PLANT_LIST_PAGE_INDEX
import com.toast.wanandroid.sunflower.adapter.SunflowerPagerAdapter

/**
 * @author toast
 * @date 2020/4/2 16:37
 * @description
 */
class HomeViewPagerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewpager

        // set adapter
        viewPager.adapter = SunflowerPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                tab.setIcon(getIcon(position))
                tab.text = (getTitle(position))
            }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    /**
     * 根据position获取对应Icon
     */
    private fun getIcon(position: Int): Int {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTitle(position: Int): String {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> "我的花园"
            PLANT_LIST_PAGE_INDEX -> "计划列表"
            else -> throw IndexOutOfBoundsException()
        }
    }
}