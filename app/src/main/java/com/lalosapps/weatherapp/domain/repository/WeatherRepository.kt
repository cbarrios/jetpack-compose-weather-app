package com.lalosapps.weatherapp.domain.repository

import com.lalosapps.weatherapp.core.util.Result
import com.lalosapps.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo>
}