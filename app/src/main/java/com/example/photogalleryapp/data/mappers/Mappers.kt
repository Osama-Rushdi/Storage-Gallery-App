package com.example.photogalleryapp.data.mappers

import com.example.photogalleryapp.data.data_base.entities.PhotoEntity
import com.example.photogalleryapp.data.model.PhotoListResponse
import com.example.photogalleryapp.data.model.PhotoResponse
import com.example.photogalleryapp.domain.model.PhotoDomain
import com.example.photogalleryapp.domain.model.PhotoListDomain

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

fun PhotoListResponse.toDomain() : PhotoListDomain {
    return PhotoListDomain(
        page = page,
        per_page = per_page,
        photos = photos.map { it.toDomain() }

    )
}
fun PhotoDomain.toEntity():PhotoEntity{
    return PhotoEntity(
        id = id,
        photographerUrl = photographerUrl,
        liked = liked,
        photographerId = photographerId,
        height = height,
        width = width,
        url = url
    )
}

fun PhotoEntity.toDomain():PhotoDomain{
    return PhotoDomain(
        id = id,
        photographerUrl = photographerUrl,
        liked = liked,
        photographerId = photographerId,
        height = height,
        width = width,
        url = url
    )
}
fun List<PhotoDomain>.toPhotoList():PhotoListDomain{
    return PhotoListDomain(
        photos = this,
        page = 20,
        per_page = 1
    )
}