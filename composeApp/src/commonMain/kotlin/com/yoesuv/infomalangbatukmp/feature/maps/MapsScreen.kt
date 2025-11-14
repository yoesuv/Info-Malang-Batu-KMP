package com.yoesuv.infomalangbatukmp.feature.maps

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.swmansion.kmpmaps.CameraPosition
import com.swmansion.kmpmaps.Coordinates
import com.swmansion.kmpmaps.Map
import com.swmansion.kmpmaps.Marker
import kotlinx.coroutines.launch

@Composable
fun MapsScreen() {
    val viewModel = remember { MapsViewModel() }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(viewModel.snackbarMessage) {
        viewModel.snackbarMessage?.let { message ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.clearSnackbar()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        contentWindowInsets = WindowInsets(0,0,0,0)
    ) { paddingValues ->
        Map(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
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
}
