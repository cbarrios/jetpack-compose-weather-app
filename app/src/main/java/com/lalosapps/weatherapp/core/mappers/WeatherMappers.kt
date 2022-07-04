package com.lalosapps.weatherapp.core.mappers

import com.lalosapps.weatherapp.data.remote.WeatherDataDto
import com.lalosapps.weatherapp.data.remote.WeatherDto
import com.lalosapps.weatherapp.domain.weather.WeatherData
import com.lalosapps.weatherapp.domain.weather.WeatherInfo
import com.lalosapps.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)


fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { entry ->
        entry.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    var currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) {
            now.hour
        } else {
            if (now.hour == 23) {
                return@find false
            } else {
                now.hour + 1
            }
        }
        it.time.hour == hour
    }
    if (currentWeatherData == null) {
        currentWeatherData = weatherDataMap[1]?.find { it.time.hour == 0 }
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}