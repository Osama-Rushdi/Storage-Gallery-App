package com.example.photogalleryapp.data.api

import com.example.photogalleryapp.data.model.PhotoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("curated")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): PhotoListResponse

}