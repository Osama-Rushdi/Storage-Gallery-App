package com.example.photogalleryapp.data.repository_impl.view_model
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photogalleryapp.data.api.WebServices
import com.example.photogalleryapp.data.model.PhotoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val webServices: WebServices
) : ViewModel() {

    private var currentPage = 1
    private val perPage = 20
    private var isLoading = false
    private val photosList = mutableListOf<PhotoResponse>()
    val stateShow = MutableLiveData<StateShow>()


    fun loadPhotos() {
        if (isLoading) return
        isLoading = true
        stateShow.value = StateShow.Loading

        viewModelScope.launch {
            try {
                val response = webServices.getPhotos(page = currentPage, perPage = perPage)
                photosList.addAll(response.photos)
                currentPage++
                stateShow.value = StateShow.Success(photosList)
            } catch (e: Exception) {
                stateShow.value = StateShow.Error(e.localizedMessage ?: "Error occurred")
                Log.e("GalleryViewModel", "Error: ${e.localizedMessage}", e)
            } finally {
                isLoading = false
            }
        }
    }


}
sealed class StateShow {
    data object Loading : StateShow()
    class Success(val photos: List<PhotoResponse>) : StateShow()
    class Error(val errorMessage: String) : StateShow()
}
