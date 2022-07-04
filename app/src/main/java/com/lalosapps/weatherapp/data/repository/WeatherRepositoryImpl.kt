package com.lalosapps.weatherapp.data.repository

import com.lalosapps.weatherapp.core.mappers.toWeatherInfo
import com.lalosapps.weatherapp.core.util.Result
import com.lalosapps.weatherapp.data.remote.WeatherApi
import com.lalosapps.weatherapp.domain.repository.WeatherRepository
import com.lalosapps.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo> {
        return try {
            Result.Success(
                api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "An unknown error occurred.")
        }
    }
}