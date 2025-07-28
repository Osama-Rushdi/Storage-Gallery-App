package com.example.photogalleryapp.data.repository_impl.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photogalleryapp.domain.model.PhotoDomain
import com.example.photogalleryapp.domain.model.PhotoListDomain
import com.example.photogalleryapp.domain.repository.GalleryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepo
) : ViewModel() {

    private var currentPage = 1
    private var perPage = 20
    private val photosList = mutableListOf<PhotoDomain>()
    val stateShow = MutableLiveData<StateShow>()


    fun loadPhotos() {

        stateShow.value = StateShow.Loading

        viewModelScope.launch {
            when (val response = repository.getPhotos(page = currentPage, perPage = perPage)) {
                is PhotoResult.Error -> {
                    stateShow.value = StateShow.Error(response.message)
                }

                is PhotoResult.Local -> {
                    photosList.addAll(response.data.photos)
                    stateShow.value = StateShow.Offline(photosList)
                }

                is PhotoResult.Remote -> {
                    photosList.addAll(response.data.photos)
                    currentPage++
//                    perPage+=10
                    stateShow.value = StateShow.Success(photosList)
                }
            }
        }
    }
}


sealed class PhotoResult {
    data class Remote(val data: PhotoListDomain) : PhotoResult()
    data class Local(val data: PhotoListDomain) : PhotoResult()
    data class Error(val message: String) : PhotoResult()
}

sealed class StateShow {
    data object Loading : StateShow()
    data class Success(val photos: List<PhotoDomain>) : StateShow()
    data class Offline(val photos: List<PhotoDomain>) : StateShow()
    data class Error(val message: String) : StateShow()
}

