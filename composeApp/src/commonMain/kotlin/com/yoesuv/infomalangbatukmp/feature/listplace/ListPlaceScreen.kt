package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import com.yoesuv.infomalangbatukmp.core.route.AppRoute
import com.yoesuv.infomalangbatukmp.components.LoadingView
import com.yoesuv.infomalangbatukmp.components.ErrorView

@Composable
fun ListPlaceScreen(
    onPlaceClick: (PlaceModel, AppRoute.DetailListPlace) -> Unit = { _, _ -> }
) {
    val viewModel = remember { ListPlaceViewModel() }
    
    when (val state = viewModel.uiState) {
        is ListPlaceUiState.Loading -> {
            LoadingView()
        }
        is ListPlaceUiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.places) { place ->
                    ItemPlaceView(
                        place = place,
                        onClick = { 
                            val detailRoute = AppRoute.DetailListPlace(
                                imageUrl = place.gambar.orEmpty(),
                                title = place.nama.orEmpty(),
                                description = place.deskripsi.orEmpty()
                            )
                            onPlaceClick(place, detailRoute)
                        }
                    )
                }
            }
        }
        is ListPlaceUiState.Error -> {
            ErrorView(
                message = state.message,
                onRetry = { viewModel.retryLoad() }
            )
        }
    }
}
