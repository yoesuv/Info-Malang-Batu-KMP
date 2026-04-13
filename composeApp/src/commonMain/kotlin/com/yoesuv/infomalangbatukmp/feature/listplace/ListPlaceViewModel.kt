package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepository
import kotlinx.coroutines.launch

class ListPlaceViewModel(
    private val placeRepository: PlaceRepository
) : ViewModel() {
    var uiState by mutableStateOf<ListPlaceUiState>(ListPlaceUiState.Loading)
        private set

    init {
        loadPlaces()
    }

    @Suppress("TooGenericExceptionCaught")
    fun loadPlaces() {
        viewModelScope.launch {
            try {
                uiState = ListPlaceUiState.Loading
                val places = placeRepository.getPlaces()
                uiState = ListPlaceUiState.Success(places)
            } catch (e: Exception) {
                uiState = ListPlaceUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    fun retryLoad() {
        loadPlaces()
    }
}
