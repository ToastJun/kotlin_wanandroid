package com.toast.wanandroid.sunflower.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author toast
 * @date 2020/4/7 14:01
 * @description
 */
data class PlantAndGardenPlantings(
    @Embedded
    val plant: Plant,

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantings: List<GardenPlanting> = emptyList()
)