package com.group3p1.healthyEye.domain.repository

import com.group3p1.healthyEye.data.network.response.Weather
import com.group3p1.healthyEye.data.network.response.WeatherResponse
import retrofit2.Call

interface Repository {
    fun getWeather(id: Int, lang: String): Call<WeatherResponse>
}