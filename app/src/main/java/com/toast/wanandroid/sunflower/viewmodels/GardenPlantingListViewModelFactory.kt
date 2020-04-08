package com.toast.wanandroid.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toast.wanandroid.sunflower.data.GardenPlantingRepository

/**
 * @author toast
 * @date 2020/4/7 16:18
 * @description
 */
class GardenPlantingListViewModelFactory(
    private val repository: GardenPlantingRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}