package com.example.covidtracker.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.*

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe()).build()
private const val BASE_URL = "https://api.apify.com/v2/"
private val builder = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface CovidApi{
    @GET("key-value-stores/moxA3Q0aZh5LosewB/records/LATEST")
    suspend fun getLatestData() : CovidData
}

object CovidApiProvider{
    val instance: CovidApi by lazy {
        builder.create(CovidApi::class.java)
    }
}