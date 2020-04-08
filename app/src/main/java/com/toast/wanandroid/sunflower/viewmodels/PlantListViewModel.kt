package com.toast.wanandroid.sunflower.viewmodels

import androidx.lifecycle.*
import com.toast.wanandroid.sunflower.data.Plant
import com.toast.wanandroid.sunflower.data.PlantRepository

/**
 * @author toast
 * @date 2020/4/8 10:07
 * @description
 */
class PlantListViewModel internal constructor(
    plantRepository: PlantRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val plants: LiveData<List<Plant>> = getSavedGrowZoneNumber().switchMap {
        when (it) {
            NO_GROW_ZONE -> plantRepository.getPlants()
            else -> plantRepository.getPlantsWithGrowZoneNumber(it)
        }
    }

    fun setGrowZoneNumber(num: Int) {
        savedStateHandle.set(GROW_ZONE_SAVED_STATE_KEY, num)
    }

    fun clearGrowZoneNumber() {
        savedStateHandle.set(GROW_ZONE_SAVED_STATE_KEY, NO_GROW_ZONE)
    }

    fun isFiltered() = getSavedGrowZoneNumber().value != NO_GROW_ZONE

    private fun getSavedGrowZoneNumber(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(GROW_ZONE_SAVED_STATE_KEY, NO_GROW_ZONE)
    }

    companion object {
        private const val NO_GROW_ZONE = -1
        private const val GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY"
    }
}