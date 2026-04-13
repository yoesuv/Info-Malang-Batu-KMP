package com.yoesuv.infomalangbatukmp.feature.maps

import com.yoesuv.infomalangbatukmp.core.models.PinModel

sealed class MapsUiState {
    data object Loading : MapsUiState()
    data class Success(val pins: List<PinModel>) : MapsUiState()
    data class Error(val message: String) : MapsUiState()
}
