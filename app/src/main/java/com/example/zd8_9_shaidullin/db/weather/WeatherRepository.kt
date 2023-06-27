package com.example.zd8_9_shaidullin.db.weather

import androidx.lifecycle.LiveData

class WeatherRepository(private val weatherDao: WeatherDao) {

    val readAllData: LiveData<List<Weather>> = weatherDao.readAllData()

    suspend fun addWeather(weather: Weather) {
        weatherDao.addWeather(weather)
    }

    suspend fun deleteWeather(weather: Weather) {
        weatherDao.delete(weather)
    }
}