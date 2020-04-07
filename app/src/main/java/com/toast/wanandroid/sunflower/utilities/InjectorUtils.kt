package com.toast.wanandroid.sunflower.utilities

import android.content.Context
import com.toast.wanandroid.sunflower.data.AppDatabase
import com.toast.wanandroid.sunflower.data.GardenPlantingRepository
import com.toast.wanandroid.sunflower.viewmodels.GardenPlantingListViewModelFactory

/**
 * @author toast
 * @date 2020/4/7 16:16
 * @description static methods used to inject classes needed for various Activities and Fragments
 */
object InjectorUtils {

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context).gardenPlantingDao())
    }

    fun providerGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }
}