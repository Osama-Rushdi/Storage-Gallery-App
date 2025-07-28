package com.example.photogalleryapp.data.data_base.entities

import android.icu.text.ListFormatter.Width
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(

    val photographerUrl: String? = null,
@PrimaryKey
    val id: Int,

    val url: String="",

    val photographerId: Long=0,

    val liked: Boolean = false,

    val height: Int = 0,

    val width: Int = 0

)




