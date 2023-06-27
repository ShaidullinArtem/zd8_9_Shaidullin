package com.example.zd8_9_shaidullin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zd8_9_shaidullin.adapter.WeatherItemAdapter
import com.example.zd8_9_shaidullin.db.weather.AppDatabase
import com.example.zd8_9_shaidullin.db.weather.WeatherViewModel
import com.example.zd8_9_shaidullin.types.WeatherItem

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView: RecyclerView
    private lateinit var weatherList: ArrayList<WeatherItem>
    private lateinit var weatherAdapter: WeatherItemAdapter

    private lateinit var mWeatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        val adapter = WeatherItemAdapter()
        recycleView = findViewById(R.id.weatherRecycleView)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)

        mWeatherViewModel.readAllData.observe(this, Observer { weather ->
            if (weather.size > 3)
            {
                adapter.setData(weather.subList(0, 3))
            } else {
                adapter.setData(weather)
            }
        })

        adapter.onItemClick = {
            val intent = Intent(this, Info::class.java)
            startActivity(intent)
        }

//        recycleView = findViewById(R.id.weatherRecycleView)
//        recycleView.setHasFixedSize(true)
//        recycleView.layoutManager = LinearLayoutManager(this)
//
//        weatherAdapter = WeatherItemAdapter()
//        recycleView.adapter = weatherAdapter


        val navToProfile = findViewById<TextView>(R.id.navToProfile);

        navToProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java);
            startActivity(intent)
        }
    }
}