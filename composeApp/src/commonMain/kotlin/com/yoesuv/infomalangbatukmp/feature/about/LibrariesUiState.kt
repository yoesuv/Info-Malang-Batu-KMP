package com.yoesuv.infomalangbatukmp.feature.about

import com.yoesuv.infomalangbatukmp.core.models.LibraryModel

sealed class LibrariesUiState {
    data object Loading : LibrariesUiState()
    data class Success(val libraries: List<LibraryModel>) : LibrariesUiState()
    data class Error(val message: String) : LibrariesUiState()
}
