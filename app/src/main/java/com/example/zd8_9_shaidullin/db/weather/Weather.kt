package com.example.zd8_9_shaidullin.db.weather

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class Weather (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "temp") val temp: String?,
    @ColumnInfo(name = "season") val season: String?,
    @ColumnInfo(name = "seasonTemp") val seasonTemp: String?,
    @ColumnInfo(name = "wind") val wind: String?,
)