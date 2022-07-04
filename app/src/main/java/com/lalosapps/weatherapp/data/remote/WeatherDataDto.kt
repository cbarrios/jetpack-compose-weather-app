package com.lalosapps.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @Json(name = "temperature_2m") val temperatures: List<Double>,
    @Json(name = "weathercode") val weatherCodes: List<Int>,
    @Json(name = "pressure_msl") val pressures: List<Double>,
    @Json(name = "windspeed_10m") val windSpeeds: List<Double>,
    @Json(name = "relativehumidity_2m") val humidities: List<Double>
)

