package br.com.atmo.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ClimatiqApiService {

    @GET("data/v1/search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("query") query: String,
        @Query("data_version") dataVersion: String = "^0",
        @Query("unit_type") unitType: String = "Money",
        @Query("access_type") accessType: String = "public",
        @Query("results_per_page") resultsPerPage: Int = 1
    ): SearchResponse

    @POST("data/v1/estimate")
    suspend fun estimate(
        @Header("Authorization") token: String,
        @Body request: EstimateRequest
    ): EstimateResponse
}