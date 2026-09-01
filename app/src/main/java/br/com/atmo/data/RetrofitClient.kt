package br.com.atmo.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: ClimatiqApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.climatiq.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClimatiqApiService::class.java)
    }
}