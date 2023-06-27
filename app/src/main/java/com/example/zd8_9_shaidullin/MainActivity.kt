package com.example.zd8_9_shaidullin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zd8_9_shaidullin.adapter.WeatherItemAdapter
import com.example.zd8_9_shaidullin.types.WeatherItem

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView: RecyclerView
    private lateinit var weatherList: ArrayList<WeatherItem>
    private lateinit var weatherAdapter: WeatherItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView = findViewById(R.id.weatherRecycleView)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)

        weatherList = ArrayList()
        weatherList.add(WeatherItem("city", "https://test.png", "13.5", "hard", "summer", "20.3"))

        weatherAdapter = WeatherItemAdapter(weatherList)
        recycleView.adapter = weatherAdapter


        val navToProfile = findViewById<TextView>(R.id.navToProfile);

        navToProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java);
            startActivity(intent)
        }
    }
}