package com.example.photogalleryapp.domain.di.modules

import com.example.photogalleryapp.data.repository_impl.GalleryRepoImpl
import com.example.photogalleryapp.data.repository_impl.data_source.local_data_source.LocalDataSource
import com.example.photogalleryapp.data.repository_impl.data_source.local_data_source.LocalDataSourceImpl
import com.example.photogalleryapp.data.repository_impl.data_source.remote_data_source.RemoteDataSource
import com.example.photogalleryapp.data.repository_impl.data_source.remote_data_source.RemoteDataSourceImpl
import com.example.photogalleryapp.domain.repository.GalleryRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource

    @Binds
    abstract fun bindNewsRepository(
        newsRepositoryImpl: GalleryRepoImpl
    ): GalleryRepo


}