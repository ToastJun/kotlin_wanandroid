package com.toast.wanandroid.sunflower.viewmodels

import com.toast.wanandroid.sunflower.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author toast
 * @date 2020/4/7 13:53
 * @description
 */
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlanting.lastWateringDate.time)
    val wateringInterval
        get() = plant.wateringInterval

    val imageUrl
        get() = plant.imageUrl
    val plantName
        get() = plant.name
    val plantDateString: String = dateFormat.format(gardenPlanting.plantDate.time)
    val plantId
        get() = plant.plantId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.CHINA)
    }
}