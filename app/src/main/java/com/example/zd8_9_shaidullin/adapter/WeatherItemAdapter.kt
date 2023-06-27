package com.example.zd8_9_shaidullin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zd8_9_shaidullin.R
import com.example.zd8_9_shaidullin.types.WeatherItem

class WeatherItemAdapter(private val weatherList: ArrayList<WeatherItem>)
    : RecyclerView.Adapter<WeatherItemAdapter.WeatherViewHolder>() {

        class WeatherViewHolder(item: View): RecyclerView.ViewHolder(item)
        {
            val imageView = item.findViewById<ImageView>(R.id.weatherImage)
            val titleView = item.findViewById<TextView>(R.id.weatherTitle)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]
//        holder.imageView.setImageResource(weather.image)
        holder.titleView.text = weather.city
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}