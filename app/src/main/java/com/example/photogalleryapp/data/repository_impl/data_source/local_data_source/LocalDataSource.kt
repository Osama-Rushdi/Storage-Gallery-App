package com.example.photogalleryapp.data.repository_impl.data_source.local_data_source

import com.example.photogalleryapp.domain.model.PhotoDomain

interface LocalDataSource {

    suspend fun savePhotos(photos: List<PhotoDomain>)

    suspend fun getPhotos(): List<PhotoDomain>
}