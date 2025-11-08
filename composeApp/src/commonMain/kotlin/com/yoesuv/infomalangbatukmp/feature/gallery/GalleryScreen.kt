package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

@Composable
fun GalleryScreen(
    onGalleryClick: (GalleryModel) -> Unit = {}
) {
    val viewModel = remember { GalleryViewModel() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(viewModel.galleries) { gallery ->
            ItemGalleryView(
                gallery = gallery,
                onClick = { onGalleryClick(gallery) }
            )
        }
    }
}
