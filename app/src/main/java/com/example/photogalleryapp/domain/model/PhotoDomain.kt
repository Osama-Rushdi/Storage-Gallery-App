package com.example.photogalleryapp.domain.model



data class PhotoDomain(

    val photographerUrl: String? = null,

    val id: Int,

    val url: String="",

    val photographerId: Long=0,

    val liked: Boolean = false,

    val height: Int = 0,

    val width: Int = 0

)




