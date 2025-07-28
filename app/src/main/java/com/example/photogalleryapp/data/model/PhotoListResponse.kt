package com.example.photogalleryapp.data.model

data class PhotoListResponse(
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoResponse>
)
