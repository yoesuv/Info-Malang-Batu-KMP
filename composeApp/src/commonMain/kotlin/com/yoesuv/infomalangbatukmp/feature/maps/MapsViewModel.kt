package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.PinModel

class MapsViewModel : ViewModel() {
    var pins by mutableStateOf<List<PinModel>>(emptyList())
        private set

    init {
        loadDummyPins()
    }

    fun updatePins(data: List<PinModel>) {
        pins = data
    }

    fun loadDummyPins() {
        val allPins = listOf(
            PinModel(
                name = "Alun Alun Malang",
                lokasi = 1,
                latitude = -7.982914,
                longitude = 112.630875
            ),
            PinModel(
                name = "Mall Olympic Garden",
                lokasi = 1,
                latitude = -7.976829,
                longitude = 112.623571
            ),
            PinModel(
                name = "Malang Town Square",
                lokasi = 1,
                latitude = -7.957147,
                longitude = 112.618406
            ),
            PinModel(
                name = "Sarinah Malang",
                lokasi = 1,
                latitude = -7.981348,
                longitude = 112.630644
            ),
            PinModel(
                name = "Mall Alun alun",
                lokasi = 1,
                latitude = -7.981938,
                longitude = 112.631862
            ),
        )
        updatePins(allPins)
    }
}
