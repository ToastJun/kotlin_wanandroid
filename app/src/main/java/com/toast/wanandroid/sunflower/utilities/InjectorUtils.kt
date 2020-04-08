package com.toast.wanandroid.sunflower.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.toast.wanandroid.sunflower.data.AppDatabase
import com.toast.wanandroid.sunflower.data.GardenPlantingRepository
import com.toast.wanandroid.sunflower.data.PlantRepository
import com.toast.wanandroid.sunflower.viewmodels.GardenPlantingListViewModelFactory
import com.toast.wanandroid.sunflower.viewmodels.PlantListViewModelFactory

/**
 * @author toast
 * @date 2020/4/7 16:16
 * @description static methods used to inject classes needed for various Activities and Fragments
 */
object InjectorUtils {

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context).gardenPlantingDao())
    }

    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao())
    }

    fun providerGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }

    fun providerPlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory {
        return PlantListViewModelFactory(getPlantRepository(fragment.requireContext()), fragment)
    }
}