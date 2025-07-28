package com.example.photogalleryapp.data.repository_impl.data_source.remote_data_source

import com.example.photogalleryapp.domain.model.PhotoListDomain

interface RemoteDataSource {
    suspend fun getPhotos(
        page: Int = 1,
        perPage: Int = 20
    ): PhotoListDomain

}