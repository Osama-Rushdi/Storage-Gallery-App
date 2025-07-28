package com.example.photogalleryapp.data.data_base

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.photogalleryapp.data.data_base.dao.photos_dao.PhotosDao
import com.example.photogalleryapp.data.data_base.entities.PhotoEntity


@Database(entities = [PhotoEntity::class], version =1 , exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun PhotosDao(): PhotosDao


//    companion object {
//        private var database: MyDatabase? = null
//
//        fun initData(context: Context) {
//            if (database == null) {
//                database = Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabase")
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//        }
//
//        fun getInstance(): MyDatabase {
//            return database!!
//        }
//    }
}