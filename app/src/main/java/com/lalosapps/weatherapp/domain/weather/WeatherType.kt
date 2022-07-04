package com.lalosapps.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.lalosapps.weatherapp.R

sealed class WeatherType(
    @StringRes val weatherDescRes: Int,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDescRes = R.string.clear_sky_weather,
        iconRes = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherType(
        weatherDescRes = R.string.mainly_clear_weather,
        iconRes = R.drawable.ic_cloudy
    )

    object PartlyCloudy : WeatherType(
        weatherDescRes = R.string.partly_cloudy_weather,
        iconRes = R.drawable.ic_cloudy
    )

    object Overcast : WeatherType(
        weatherDescRes = R.string.overcast_weather,
        iconRes = R.drawable.ic_cloudy
    )

    object Foggy : WeatherType(
        weatherDescRes = R.string.foggy_weather,
        iconRes = R.drawable.ic_very_cloudy
    )

    object DepositingRimeFog : WeatherType(
        weatherDescRes = R.string.depositing_rime_fog_weather,
        iconRes = R.drawable.ic_very_cloudy
    )

    object LightDrizzle : WeatherType(
        weatherDescRes = R.string.light_drizzle_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateDrizzle : WeatherType(
        weatherDescRes = R.string.moderate_drizzle_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object DenseDrizzle : WeatherType(
        weatherDescRes = R.string.dense_drizzle_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.slight_freezing_drizzle_weather,
        iconRes = R.drawable.ic_snowyrainy
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDescRes = R.string.dense_freezing_drizzle_weather,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightRain : WeatherType(
        weatherDescRes = R.string.slight_rain_weather,
        iconRes = R.drawable.ic_rainy
    )

    object ModerateRain : WeatherType(
        weatherDescRes = R.string.rainy_weather,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyRain : WeatherType(
        weatherDescRes = R.string.heavy_rain_weather,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyFreezingRain : WeatherType(
        weatherDescRes = R.string.heavy_freezing_rain_weather,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightSnowFall : WeatherType(
        weatherDescRes = R.string.slight_snow_fall,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateSnowFall : WeatherType(
        weatherDescRes = R.string.moderate_snow_fall_weather,
        iconRes = R.drawable.ic_heavysnow
    )

    object HeavySnowFall : WeatherType(
        weatherDescRes = R.string.heavy_snow_fall_weather,
        iconRes = R.drawable.ic_heavysnow
    )

    object SnowGrains : WeatherType(
        weatherDescRes = R.string.snow_grains_weather,
        iconRes = R.drawable.ic_heavysnow
    )

    object SlightRainShowers : WeatherType(
        weatherDescRes = R.string.slight_rain_showers_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateRainShowers : WeatherType(
        weatherDescRes = R.string.moderate_rain_showers_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object ViolentRainShowers : WeatherType(
        weatherDescRes = R.string.violent_rain_showers_weather,
        iconRes = R.drawable.ic_rainshower
    )

    object SlightSnowShowers : WeatherType(
        weatherDescRes = R.string.light_snow_showers_weather,
        iconRes = R.drawable.ic_snowy
    )

    object HeavySnowShowers : WeatherType(
        weatherDescRes = R.string.heavy_snow_showers_weather,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateThunderstorm : WeatherType(
        weatherDescRes = R.string.moderate_thunderstorm_weather,
        iconRes = R.drawable.ic_thunder
    )

    object SlightHailThunderstorm : WeatherType(
        weatherDescRes = R.string.thunderstorm_with_slight_hail_weather,
        iconRes = R.drawable.ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDescRes = R.string.thunderstorm_with_heavy_hail_weather,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}