package com.yoesuv.infomalangbatukmp.feature.listplace

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

sealed class ListPlaceUiState {
    data object Loading : ListPlaceUiState()
    data class Success(val places: List<PlaceModel>) : ListPlaceUiState()
    data class Error(val message: String) : ListPlaceUiState()
}
