package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.repository.LibrariesRepository

class LibrariesViewModel(
    private val librariesRepository: LibrariesRepository
) : ViewModel() {

    var uiState by mutableStateOf<LibrariesUiState>(LibrariesUiState.Loading)
        private set

    init {
        loadLibraries()
    }

    @Suppress("TooGenericExceptionCaught")
    fun loadLibraries() {
        try {
            uiState = LibrariesUiState.Loading
            val libraries = librariesRepository.getLibraries()
            uiState = LibrariesUiState.Success(libraries)
        } catch (e: Exception) {
            uiState = LibrariesUiState.Error(e.message ?: "Unknown error occurred")
        }
    }

    fun retryLoad() {
        loadLibraries()
    }
}
