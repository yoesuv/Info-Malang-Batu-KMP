package com.yoesuv.infomalangbatukmp.feature.gallery

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

sealed class GalleryUiState {
    data object Loading : GalleryUiState()
    data class Success(val galleries: List<GalleryModel>) : GalleryUiState()
    data class Error(val message: String) : GalleryUiState()
}
