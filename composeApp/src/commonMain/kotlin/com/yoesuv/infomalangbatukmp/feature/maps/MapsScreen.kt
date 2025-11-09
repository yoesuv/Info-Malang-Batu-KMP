package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.swmansion.kmpmaps.CameraPosition
import com.swmansion.kmpmaps.Coordinates
import com.swmansion.kmpmaps.Map
import com.swmansion.kmpmaps.Marker

@Composable
fun MapsScreen() {
    val viewModel = remember { MapsViewModel() }

    Map(
        modifier = Modifier.fillMaxSize(),
        cameraPosition = CameraPosition(
            coordinates = Coordinates(-7.982914, 112.630875),
            zoom = 9f,
        ),
        markers = viewModel.pins.map { pin ->
            Marker(
                coordinates = Coordinates(latitude = pin.latitude ?: 0.0, longitude = pin.longitude ?: 0.0),
                title = pin.name ?: "Unknown",
                androidSnippet = "Location ID: ${pin.lokasi}"
            )
        }
    ) { }
}
