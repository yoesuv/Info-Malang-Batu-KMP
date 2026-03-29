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
    var pins by mutableStateOf<List<PinModel>>(emptyList())
        private set
    
    var snackbarMessage by mutableStateOf<String?>(null)
        private set

    init {
        loadPins()
    }

    fun updatePins(data: List<PinModel>) {
        pins = data
    }
    
    private fun showSnackbar(message: String) {
        snackbarMessage = message
    }
    
    fun clearSnackbar() {
        snackbarMessage = null
    }

    @Suppress("TooGenericExceptionCaught")
    fun loadPins() {
        viewModelScope.launch {
            try {
                val pinsData = pinsRepository.getPins()
                updatePins(pinsData)
            } catch (e: Exception) {
                showSnackbar("Failed to load pins: ${e.message ?: "Unknown error"}")
            }
        }
    }

}
