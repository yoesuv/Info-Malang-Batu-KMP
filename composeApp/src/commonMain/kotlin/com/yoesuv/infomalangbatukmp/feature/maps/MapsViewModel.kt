package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.infomalangbatukmp.core.models.PinModel
import com.yoesuv.infomalangbatukmp.core.repository.PinsRepository
import kotlinx.coroutines.launch

class MapsViewModel(
    private val pinsRepository: PinsRepository
) : ViewModel() {

    var uiState: MapsUiState by mutableStateOf(MapsUiState.Loading)
        private set

    init {
        loadPins()
    }

    fun updatePins(data: List<PinModel>) {
        uiState = MapsUiState.Success(data)
    }

    @Suppress("TooGenericExceptionCaught")
    fun loadPins() {
        viewModelScope.launch {
            uiState = MapsUiState.Loading
            try {
                val pinsData = pinsRepository.getPins()
                uiState = MapsUiState.Success(pinsData)
            } catch (e: Exception) {
                uiState = MapsUiState.Error("Failed to load pins: ${e.message ?: "Unknown error"}")
            }
        }
    }

    fun retryLoad() {
        loadPins()
    }
}
