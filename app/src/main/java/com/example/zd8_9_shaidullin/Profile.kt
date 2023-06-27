package com.example.zd8_9_shaidullin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zd8_9_shaidullin.adapter.WeatherItemAdapter
import com.example.zd8_9_shaidullin.db.weather.WeatherViewModel
import com.example.zd8_9_shaidullin.types.WeatherItem

class Profile : AppCompatActivity() {

    private lateinit var recycleView: RecyclerView
    private lateinit var weatherList: ArrayList<WeatherItem>
    private lateinit var weatherAdapter: WeatherItemAdapter

    private lateinit var mWeatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mWeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        val adapter = WeatherItemAdapter()
        recycleView = findViewById(R.id.weatherCardsRecycleView)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)

        mWeatherViewModel.readAllData.observe(this, Observer { weather ->
            adapter.setData(weather)
        })

        adapter.onItemClick = {
            val intent = Intent(this, Info::class.java)
            startActivity(intent)
        }


        val navToCreateBtn = findViewById<Button>(R.id.profileNavToCreateBtn);
        val backBtn = findViewById<Button>(R.id.profileBackBtn);

        navToCreateBtn.setOnClickListener {
            val intent = Intent(this, Create::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}