package com.riceup.riceapp.network

import com.riceup.riceapp.models.Category
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>
}