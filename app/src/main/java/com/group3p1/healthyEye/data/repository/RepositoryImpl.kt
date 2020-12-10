package com.group3p1.healthyEye.data.repository

import com.group3p1.healthyEye.data.network.api.API
import com.group3p1.healthyEye.data.network.response.WeatherResponse
import com.group3p1.healthyEye.domain.repository.Repository
import retrofit2.Call

class RepositoryImpl: Repository {
    override fun getWeather(id: Int, lang: String): Call<WeatherResponse> {
        return API.weatherApi().getWeather(id, lang)
    }
}