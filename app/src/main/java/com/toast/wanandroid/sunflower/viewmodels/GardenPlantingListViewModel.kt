package com.toast.wanandroid.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.toast.wanandroid.sunflower.data.GardenPlantingRepository
import com.toast.wanandroid.sunflower.data.PlantAndGardenPlantings

/**
 * @author toast
 * @date 2020/4/7 16:27
 * @description
 */
class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
): ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}