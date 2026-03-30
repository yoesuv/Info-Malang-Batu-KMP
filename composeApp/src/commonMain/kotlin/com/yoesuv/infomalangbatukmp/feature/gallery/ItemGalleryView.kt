package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yoesuv.infomalangbatukmp.components.AppNetworkImage
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

@Composable
fun ItemGalleryView(
    gallery: GalleryModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    AppNetworkImage(
        url = gallery.thumbnail ?: gallery.image,
        contentDescription = gallery.caption,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = onClick)
    )
}
