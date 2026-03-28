package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepository
import kotlinx.coroutines.launch

sealed class GalleryUiState {
    object Loading : GalleryUiState()
    data class Success(val galleries: List<GalleryModel>) : GalleryUiState()
    data class Error(val message: String) : GalleryUiState()
}

class GalleryViewModel(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

    var uiState by mutableStateOf<GalleryUiState>(GalleryUiState.Loading)
        private set

    init {
        loadGallery()
    }

    fun loadGallery() {
        viewModelScope.launch {
            try {
                uiState = GalleryUiState.Loading
                val galleries = galleryRepository.getGallery()
                uiState = GalleryUiState.Success(galleries)
            } catch (e: Exception) {
                uiState = GalleryUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    fun retryLoad() {
        loadGallery()
    }
}
