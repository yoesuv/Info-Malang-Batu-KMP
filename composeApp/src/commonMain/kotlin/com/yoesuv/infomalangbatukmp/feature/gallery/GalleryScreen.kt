package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.components.ErrorView
import com.yoesuv.infomalangbatukmp.components.LoadingView

@Composable
fun GalleryScreen(
    onGalleryClick: (GalleryModel) -> Unit = {}
) {
    val viewModel = remember { GalleryViewModel() }

    when (val state = viewModel.uiState) {
        is GalleryUiState.Loading -> {
            LoadingView(message = "Loading gallery...")
        }
        is GalleryUiState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.galleries) { gallery ->
                    ItemGalleryView(
                        gallery = gallery,
                        onClick = { onGalleryClick(gallery) }
                    )
                }
            }
        }
        is GalleryUiState.Error -> {
            ErrorView(
                title = "Error loading gallery",
                message = state.message,
                onRetry = { viewModel.retryLoad() }
            )
        }
    }
}
