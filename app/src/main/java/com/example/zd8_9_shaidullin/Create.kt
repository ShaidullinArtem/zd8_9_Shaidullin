package com.example.zd8_9_shaidullin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zd8_9_shaidullin.db.weather.Weather
import com.example.zd8_9_shaidullin.db.weather.WeatherViewModel
import com.example.zd8_9_shaidullin.utils.WeatherUtils

class Create : AppCompatActivity() {

    private var weatherUtils = WeatherUtils()
    private lateinit var mWeatherViewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        mWeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        val createBtn = findViewById<Button>(R.id.createCreateBtn);
        val backBtn = findViewById<Button>(R.id.createBackBtn);

        createBtn.setOnClickListener {
            insertDataToDatabase()
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }

    private fun insertDataToDatabase() {
        val city = findViewById<EditText>(R.id.createCityEdit).text.toString()
        val temp = findViewById<EditText>(R.id.createTempEdit).text.toString()
        val season = findViewById<EditText>(R.id.createSeasonEdit).text.toString()
        val seasonTemp = findViewById<EditText>(R.id.createSeasonTempEdit).text.toString()
        val wind = findViewById<EditText>(R.id.createWindEdit).text.toString()
        val imageUrl = findViewById<EditText>(R.id.createImageUrl).text.toString()

        if (weatherUtils.checkValidData(city, temp, season, seasonTemp, wind, imageUrl)) {
            val weather = Weather(0, imageUrl, city, temp, season, seasonTemp, wind)
            mWeatherViewModel.addWeather(weather)
            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()

        }
    }
}