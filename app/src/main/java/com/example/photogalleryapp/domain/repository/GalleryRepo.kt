package com.example.photogalleryapp.domain.repository

import com.example.photogalleryapp.data.repository_impl.view_model.PhotoResult


interface GalleryRepo {

    suspend fun getPhotos(
      page: Int = 1,
       perPage: Int = 20
    ): PhotoResult

}