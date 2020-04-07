package com.toast.wanandroid.sunflower.data

/**
 * @author toast
 * @date 2020/4/7 14:01
 * @description
 */
data class PlantAndGardenPlantings(
    val plant: Plant,
    val gardenPlantings: List<GardenPlanting> = emptyList()
)