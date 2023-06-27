package com.example.zd8_9_shaidullin.utils

class WeatherUtils {

    public fun checkValidData(city: String, image: String, temp: String, season: String, seasonTemp: String, wind: String): Boolean
    {
        return !(city.isNullOrEmpty() && image.isNullOrEmpty() && temp.isNullOrEmpty() && season.isNullOrEmpty() && seasonTemp.isNullOrEmpty() && wind.isNullOrEmpty())
    }
}