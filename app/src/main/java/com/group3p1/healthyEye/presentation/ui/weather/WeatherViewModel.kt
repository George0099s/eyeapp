package com.group3p1.healthyEye.presentation.ui.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.group3p1.healthyEye.data.network.response.WeatherResponse
import com.group3p1.healthyEye.data.repository.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {

    val weatherLiveData = MutableLiveData<WeatherResponse>()
    val repository = RepositoryImpl()


    fun getWeather() {
        repository.getWeather(498817, "ru").enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                Log.d(TAG, "onResponse: ${response.message()}")
                weatherLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d(Companion.TAG, "onFailure: $t")
            }
        })
    }

    companion object {
        private const val TAG = "WeatherViewModel"
    }
}