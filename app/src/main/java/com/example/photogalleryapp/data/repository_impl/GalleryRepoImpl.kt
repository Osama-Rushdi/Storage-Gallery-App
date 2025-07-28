package com.example.photogalleryapp.data.repository_impl

import android.util.Log
import com.example.photogalleryapp.data.mappers.toPhotoList
import com.example.photogalleryapp.data.repository_impl.data_source.local_data_source.LocalDataSource
import com.example.photogalleryapp.data.repository_impl.data_source.remote_data_source.RemoteDataSource
import com.example.photogalleryapp.data.repository_impl.view_model.PhotoResult
import com.example.photogalleryapp.data.utils.connectively.Connectivity
import com.example.photogalleryapp.domain.model.PhotoListDomain
import com.example.photogalleryapp.domain.repository.GalleryRepo
import javax.inject.Inject

class GalleryRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val connectivity: Connectivity
) : GalleryRepo {

    override suspend fun getPhotos(page: Int, perPage: Int): PhotoResult {
      return  try {
            if (connectivity.isOnline()) {
                val photosList = remoteDataSource.getPhotos(page, perPage)
                localDataSource.savePhotos(photosList.photos)

                PhotoResult.Remote(photosList)
            } else {

                Log.d("kkk", "getPhotos:${ localDataSource.getPhotos().toPhotoList()} ")
                PhotoResult.Local(localDataSource.getPhotos().toPhotoList())
            }
        } catch (e: Exception) {
            PhotoResult.Error(e.localizedMessage ?: "Error occurred")
        }
    }
}

