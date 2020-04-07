package com.toast.wanandroid.sunflower.works

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.toast.wanandroid.sunflower.data.AppDatabase
import com.toast.wanandroid.sunflower.data.Plant
import com.toast.wanandroid.sunflower.utilities.PLANT_DATA_FILENAME
import kotlinx.coroutines.coroutineScope
import java.io.InputStream
import java.lang.Exception

/**
 * @author toast
 * @date 2020/4/7 17:47
 * @description
 */
class SeedDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(PLANT_DATA_FILENAME).use { inputStream: InputStream ->
                JsonReader(inputStream.reader()).use { jsonReader: JsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.plantDao().insertAll(plantList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Result.failure()
        }
    }

}