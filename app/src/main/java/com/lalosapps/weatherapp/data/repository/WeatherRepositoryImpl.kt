package com.lalosapps.weatherapp.data.repository

import com.lalosapps.weatherapp.core.util.Result
import com.lalosapps.weatherapp.data.remote.WeatherApi
import com.lalosapps.weatherapp.domain.repository.WeatherRepository
import com.lalosapps.weatherapp.domain.weather.WeatherInfo

class WeatherRepositoryImpl(
    private val api: WeatherApi // use Hilt next...
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo> {
        TODO("Not yet implemented")
    }

}