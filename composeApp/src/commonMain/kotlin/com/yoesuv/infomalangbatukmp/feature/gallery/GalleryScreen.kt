package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.components.ErrorView
import com.yoesuv.infomalangbatukmp.components.LoadingView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GalleryScreen(
    onGalleryClick: (GalleryModel) -> Unit = {}
) {
    val viewModel: GalleryViewModel = koinViewModel()
    GalleryContent(
        uiState = viewModel.uiState,
        onGalleryClick = onGalleryClick,
        onRetry = { viewModel.retryLoad() }
    )
}

@Composable
fun GalleryContent(
    uiState: GalleryUiState,
    onGalleryClick: (GalleryModel) -> Unit = {},
    onRetry: () -> Unit = {}
) {
    when (uiState) {
        is GalleryUiState.Loading -> {
            LoadingView(message = "Loading gallery...")
        }
        is GalleryUiState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(uiState.galleries) { gallery ->
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
                message = uiState.message,
                onRetry = onRetry
            )
        }
    }
}
