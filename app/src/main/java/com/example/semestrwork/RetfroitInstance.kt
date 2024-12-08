package com.example.semestrwork

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.thedogapi.com/"

    private const val API_KEY = "live_oZbh5QyXMjDFyLqUR0UpjY7FF1wun8zIipwJSFmR9eatZ6bhQJQAPImy5KaqKk4W"

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(Interceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("x-api-key", API_KEY)
                .build()
            chain.proceed(request)
        })
    }.build()

    val apiService: DogApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)
    }
}