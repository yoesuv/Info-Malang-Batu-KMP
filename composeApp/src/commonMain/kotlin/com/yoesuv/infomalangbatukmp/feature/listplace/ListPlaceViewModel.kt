package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiService
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceImpl
import kotlinx.coroutines.launch

sealed class ListPlaceUiState {
    object Loading : ListPlaceUiState()
    data class Success(val places: List<PlaceModel>) : ListPlaceUiState()
    data class Error(val message: String) : ListPlaceUiState()
}

class ListPlaceViewModel(
    private val placeApiService: PlaceApiService = PlaceApiServiceImpl()
) : ViewModel() {
    var uiState by mutableStateOf<ListPlaceUiState>(ListPlaceUiState.Loading)
        private set

    init {
        loadPlaces()
    }

    fun loadPlaces() {
        viewModelScope.launch {
            try {
                uiState = ListPlaceUiState.Loading
                val places = placeApiService.getPlaces()
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
