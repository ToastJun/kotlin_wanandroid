package com.toast.wanandroid.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toast.wanandroid.sunflower.data.GardenPlantingRepository
import com.toast.wanandroid.sunflower.data.PlantRepository
import kotlinx.coroutines.launch

/**
 * @author toast
 * @date 2020/4/8 17:05
 * @description
 */
class PlantDetailViewModel(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
): ViewModel() {

    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
    // 获取到对应plant
    val plant = plantRepository.getPlant(plantId)

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }
}