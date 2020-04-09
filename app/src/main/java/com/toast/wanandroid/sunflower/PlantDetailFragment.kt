package com.toast.wanandroid.sunflower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.FragmentPlantDetailBinding
import com.toast.wanandroid.sunflower.data.Plant
import com.toast.wanandroid.sunflower.utilities.InjectorUtils
import com.toast.wanandroid.sunflower.viewmodels.PlantDetailViewModel

/**
 * @author toast
 * @date 2020/4/8 17:01
 * @description
 */
class PlantDetailFragment: Fragment() {


    private val args: PlantDetailFragmentArgs by navArgs()

    private val plantDetailViewModel: PlantDetailViewModel by viewModels {
        InjectorUtils.providerPlantDetailViewModelFactory(requireContext(), args.plantId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater, R.layout.fragment_plant_detail, container, false
        )
            .apply {
                viewModel = plantDetailViewModel
                lifecycleOwner = viewLifecycleOwner
                callback = object: AddCallback {
                    override fun add(plant: Plant?) {
                        plant?.let {
                            hideAppBarFab(fb)
                            plantDetailViewModel.addPlantToGarden()
                            Snackbar.make(root, "Add plant to garden", Snackbar.LENGTH_LONG)
                                .show()
                        }
                    }

                }

                var isToolbarShown = false

                toolbar.setNavigationOnClickListener {
                    // 退回上一页
                    it.findNavController().navigateUp()
                }

                scrollView.setOnScrollChangeListener {
                        _: NestedScrollView?, _: Int, scrollY: Int, _: Int, _: Int ->

                    val shouldShowToolbar = scrollY >toolbar.height
                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar
                        appbar.isActivated = shouldShowToolbar
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }

                toolbar.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.action_share -> {
                            createShareIntent()
                            true
                        }
                        else -> false
                    }
                }
            }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun createShareIntent() {

    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    interface AddCallback {
        fun add(plant: Plant?)
    }
}