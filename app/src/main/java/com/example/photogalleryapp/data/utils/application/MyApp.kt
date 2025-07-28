package com.example.photogalleryapp.data.utils.application

import dagger.hilt.android.HiltAndroidApp

import android.app.Application

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}