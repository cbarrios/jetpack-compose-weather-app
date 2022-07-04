package com.lalosapps.weatherapp.ui.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lalosapps.weatherapp.R
import com.lalosapps.weatherapp.ui.theme.CulturedGray

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.today),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                backgroundColor = if (isSystemInDarkTheme()) MaterialTheme.colors.background else CulturedGray,
                shape = RoundedCornerShape(10.dp)
            ) {
                LazyRow(
                    content = {
                        items(data) { weatherData ->
                            HourlyWeatherDisplay(
                                weatherData = weatherData,
                                modifier = Modifier
                                    .height(100.dp)
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    },
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        }
    }
}