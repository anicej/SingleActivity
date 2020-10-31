package com.nicej.singleactivity.api

import com.nicej.singleactivity.model.Photo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("photos/{id}")
    suspend fun getPhoto(@Path("id") id: Int): Photo
}