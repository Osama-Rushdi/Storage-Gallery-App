package com.example.photogalleryapp.domain.di

import android.content.Context
import androidx.room.Room
import com.example.photogalleryapp.data.data_base.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideMyDataBase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

}
