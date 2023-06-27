package com.example.zd8_9_shaidullin.db.weather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Weather>>
    private val repository: WeatherRepository

    init {
        val weatherDao = AppDatabase.getDatabase(application).weatherDao()
        repository = WeatherRepository(weatherDao)
        readAllData = repository.readAllData
    }

    fun addWeather(weather: Weather) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.addWeather(weather)
        }
    }
}