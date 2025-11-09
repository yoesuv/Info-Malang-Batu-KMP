package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.swmansion.kmpmaps.CameraPosition
import com.swmansion.kmpmaps.Coordinates
import com.swmansion.kmpmaps.Map

@Composable
fun MapsScreen() {
    Map(
        modifier = Modifier.fillMaxSize(),
        cameraPosition = CameraPosition(
            coordinates = Coordinates(-7.982914, 112.630875),
            zoom = 9f,
        )
    ) { }
}
