package com.example.photogalleryapp.data.mappers

import com.example.photogalleryapp.data.model.PhotoResponse
import com.example.photogalleryapp.domain.model.PhotoDomain

fun PhotoResponse.toDomain(): PhotoDomain {
    return PhotoDomain(
        id = id ?: 0,
        photographerUrl = photographerUrl,
        liked = liked ?: false,
        photographerId = photographerId ?: 0L,
        height = height ?: 0,
        url =  this.src!!.medium ?: "",
    )
}