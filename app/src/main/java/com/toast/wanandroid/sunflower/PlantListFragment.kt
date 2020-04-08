package com.toast.wanandroid.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.toast.wanandroid.databinding.FragmentPlantListBinding
import com.toast.wanandroid.sunflower.adapter.PlantListAdapter
import com.toast.wanandroid.sunflower.utilities.InjectorUtils
import com.toast.wanandroid.sunflower.viewmodels.PlantListViewModel

/**
 * @author toast
 * @date 2020/4/8 14:41
 * @description
 */
class PlantListFragment: Fragment() {

    private lateinit var binding: FragmentPlantListBinding

    private lateinit var plantListAdapter: PlantListAdapter

    private val viewModel: PlantListViewModel by viewModels{
        InjectorUtils.providerPlantListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding
        binding = FragmentPlantListBinding.inflate(inflater, container, false)
        plantListAdapter = PlantListAdapter()
        binding.plantList.adapter = plantListAdapter

        setHasOptionsMenu(true)

        subscribeUi()

        return binding.root
    }

    private fun subscribeUi() {
        viewModel.plants.observe(viewLifecycleOwner, Observer {
            plantListAdapter.submitList(it)
        })
    }
}