package com.example.photogalleryapp.domain.model

data class PhotoListDomain(
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoDomain>
)
