package com.example.photogalleryapp.data.data_base.dao.photos_dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.photogalleryapp.data.data_base.entities.PhotoEntity

@Dao
interface PhotosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhotos(photosApi: List<PhotoEntity>)

}