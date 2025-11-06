package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

@Composable
fun ListPlaceScreen(
    onPlaceClick: (PlaceModel) -> Unit = {}
) {
    val viewModel = remember { ListPlaceViewModel() }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(viewModel.places) { place ->
            ItemPlaceView(
                place = place,
                onClick = { onPlaceClick(place) }
            )
        }
    }
}
