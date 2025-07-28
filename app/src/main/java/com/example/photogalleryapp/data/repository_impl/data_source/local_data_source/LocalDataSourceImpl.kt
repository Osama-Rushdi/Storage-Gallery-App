package com.example.photogalleryapp.data.repository_impl.data_source.local_data_source

import com.example.photogalleryapp.data.data_base.MyDatabase
import com.example.photogalleryapp.data.data_base.dao.photos_dao.PhotosDao
import com.example.photogalleryapp.data.mappers.toDomain
import com.example.photogalleryapp.data.mappers.toEntity
import com.example.photogalleryapp.domain.model.PhotoDomain
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val myDatabase: MyDatabase) : LocalDataSource {

    override suspend fun savePhotos(photos: List<PhotoDomain>) {
        myDatabase.PhotosDao().savePhotos(photos.map { it.toEntity() })
    }


    override suspend fun getPhotos(): List<PhotoDomain> {
        return myDatabase.PhotosDao().getPhotos().map { it.toDomain() }
    }
}