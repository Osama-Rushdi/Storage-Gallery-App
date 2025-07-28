package com.example.photogalleryapp.data.data_base.dao.photos_dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photogalleryapp.data.data_base.entities.PhotoEntity
import com.example.photogalleryapp.data.model.PhotoResponse
import com.example.photogalleryapp.domain.model.PhotoDomain

@Dao
interface PhotosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhotos(photosApi: List<PhotoEntity>)


    @Query("SELECT * FROM PhotoEntity")
    suspend fun getPhotos(): List<PhotoEntity>


}