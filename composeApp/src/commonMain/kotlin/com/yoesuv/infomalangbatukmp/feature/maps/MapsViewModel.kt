package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.infomalangbatukmp.core.models.PinModel
import com.yoesuv.infomalangbatukmp.core.network.PinsApiService
import com.yoesuv.infomalangbatukmp.core.network.PinsApiServiceImpl
import kotlinx.coroutines.launch

class MapsViewModel(
    private val pinsApiService: PinsApiService = PinsApiServiceImpl()
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

    fun loadPins() {
        viewModelScope.launch {
            try {
                val pinsData = pinsApiService.getPins()
                updatePins(pinsData)
            } catch (e: Exception) {
                showSnackbar("Failed to load pins: ${e.message ?: "Unknown error"}")
            }
        }
    }

}
