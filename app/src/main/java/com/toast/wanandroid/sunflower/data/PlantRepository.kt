package com.toast.wanandroid.sunflower.data

/**
 * @author toast
 * @date 2020/4/8 9:47
 * @description
 */
class PlantRepository private constructor(
    val plantDao: PlantDao
){

    fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    fun getPlants() = plantDao.getPlants()

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) = plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {
        @Volatile private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao): PlantRepository {
            return instance ?: synchronized(this) {
                instance ?: PlantRepository(plantDao).also { instance = it }
            }
        }
    }
}