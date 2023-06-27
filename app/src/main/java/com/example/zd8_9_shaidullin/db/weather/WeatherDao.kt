package com.example.zd8_9_shaidullin.db.weather

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWeather(weather: Weather)

    @Query("SELECT * FROM weather_table")
    fun readAllData(): LiveData<List<Weather>>

    @Delete
    suspend fun delete(weather: Weather)


}