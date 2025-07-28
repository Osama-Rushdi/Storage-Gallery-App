package com.example.photogalleryapp.domain.di

import android.content.Context
import com.example.photogalleryapp.data.api.ApiManager.BASE_URL
import com.example.photogalleryapp.data.api.WebServices
import com.example.photogalleryapp.data.utils.connectively.Connectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGetWebServices(retrofit: Retrofit): WebServices =
        retrofit.create(WebServices::class.java)

    @Provides
    fun provideGetRetrofit(
        getOkHttpResponse: OkHttpClient, gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpResponse)
            .addConverterFactory(gsonConverterFactory).build()
    }

    @Provides
    fun gsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideGetConnectivity(@ApplicationContext context: Context): Connectivity =
        Connectivity(context)

    @Provides
    fun provideGetOkHttpResponse(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        // Interceptor لإضافة الـ API Key
        val apiKeyInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "DNCCiG0JxltlPPr34GtAN1Bi5e7KMqycvbIbUekLpqDq4PRKYlTUO2kz") // غيّر المفتاح هنا
                .build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)        // الأول: API Key
            .addInterceptor(loggingInterceptor)       // الثاني: اللوج
            .build()
    }

}