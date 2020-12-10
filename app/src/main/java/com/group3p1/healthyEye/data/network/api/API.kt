package com.group3p1.healthyEye.data.network.api

import com.group3p1.healthyEye.data.network.NetworkConstants
import com.group3p1.healthyEye.data.network.response.WeatherResponse
import com.squareup.moshi.Moshi
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("?units=metric")
    fun getWeather(
            @Query("id") id: Int,
            @Query("lang") lang: String
    ): Call<WeatherResponse>

    companion object {
        fun weatherApi(): API {
            val client = OkHttpClient.Builder()
                    .addInterceptor { chain ->

                        var request: Request = chain.request()
                        val url: HttpUrl =
                                request.url.newBuilder()
                                        .addQueryParameter(NetworkConstants.WEATHER_APPID_NAME, NetworkConstants.WEATHER_APPID)
                                        .build()
                        request = request.newBuilder().url(url).build()
                        chain.proceed(request)
                    }
                    .build()
//            val client = OkHttpClient.Builder()
//            client.addInterceptor(interceptorFactory.getEmployerAuthErrorInterceptor())
//
//            client.addInterceptor {
//                val original = it.request()
//                val requestBuilder = original.newBuilder()
//                val request = requestBuilder.method(original.method, original.body).build()
//                return@addInterceptor it.proceed(request)
//            }.build()


            val retrofit = Retrofit.Builder()
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .client(client)
                    .baseUrl(NetworkConstants.WEATHER_BASE_URL)
                    .build()

            return retrofit.create(API::class.java);
        }
    }


}