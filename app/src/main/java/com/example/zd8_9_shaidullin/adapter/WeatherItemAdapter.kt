package com.example.zd8_9_shaidullin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.zd8_9_shaidullin.R
import com.example.zd8_9_shaidullin.db.weather.Weather
import com.example.zd8_9_shaidullin.types.WeatherItem

class WeatherItemAdapter: RecyclerView.Adapter<WeatherItemAdapter.WeatherViewHolder>() {

    private var weatherList = emptyList<Weather>()
    var onItemClick: ((Weather) -> Unit)? = null

    class WeatherViewHolder(item: View): RecyclerView.ViewHolder(item)
    {
        val imageView = item.findViewById<ImageView>(R.id.weatherImage)
        val cityView = item.findViewById<TextView>(R.id.weatherCity)
        val temp = item.findViewById<TextView>(R.id.weatherTemp)
        val season = item.findViewById<TextView>(R.id.weatherSeason)
        val seasonTemp = item.findViewById<TextView>(R.id.weatherSeasonTemp)
        val wind = item.findViewById<TextView>(R.id.weatherWind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false ))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = weatherList[position]
//        holder.imageView.setImageURI(currentItem.image)
//        holder.cityView.text = "Город: ${currentItem.city}"
//        holder.temp.text = "${currentItem.temp}°"
//        holder.season.text = "${currentItem.season}: "
//        holder.seasonTemp.text = "${currentItem.seasonTemp}°"
//        holder.wind.text = "Скорость вестра: ${currentItem.wind}"

        holder.cityView.text = "Город: ${currentItem.city}"
        holder.temp.text = currentItem.temp
        holder.season.text = currentItem.season
        holder.seasonTemp.text = currentItem.seasonTemp
        holder.wind.text = currentItem.wind


        holder.imageView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun setData(weather: List<Weather>)
    {
        this.weatherList = weather
        notifyDataSetChanged()
    }
}