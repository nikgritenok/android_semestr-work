package com.example.semestrwork

import retrofit2.http.GET
import retrofit2.http.Query

interface DogApiService {
    @GET("v1/images/search")
    suspend fun getDogImages(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): List<Dog>
}