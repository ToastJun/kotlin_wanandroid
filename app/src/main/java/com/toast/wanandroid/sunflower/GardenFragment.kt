package com.toast.wanandroid.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.FragmentGardenBinding
import com.toast.wanandroid.sunflower.adapter.GardenPlantingAdapter
import com.toast.wanandroid.sunflower.adapter.PLANT_LIST_PAGE_INDEX
import kotlinx.android.synthetic.main.fragment_garden.*

/**
 * @author toast
 * @date 2020/4/7 11:21
 * @description
 */
class GardenFragment: Fragment() {

    private lateinit var binding: FragmentGardenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGardenBinding.inflate(inflater, container, false)
        // adapter
        val adapter = GardenPlantingAdapter()
        binding.gardenList.adapter = adapter

        binding.addPlant.setOnClickListener {
            navigateToPlantListPage()
        }

        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {

    }

    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.viewpager).currentItem =
            PLANT_LIST_PAGE_INDEX
    }
}