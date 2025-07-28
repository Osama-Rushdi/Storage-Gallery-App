package com.example.photogalleryapp.data.repository_impl.data_source.remote_data_source

import com.example.photogalleryapp.data.api.WebServices
import com.example.photogalleryapp.data.mappers.toDomain
import com.example.photogalleryapp.domain.model.PhotoListDomain
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    RemoteDataSource {


    override suspend fun getPhotos(page: Int, perPage: Int): PhotoListDomain {
        val photoList =
            webServices.getPhotos(page, perPage).toDomain()
        return photoList
    }
}