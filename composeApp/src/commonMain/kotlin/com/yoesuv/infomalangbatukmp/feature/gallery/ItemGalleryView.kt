package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.placeholder_image
import org.jetbrains.compose.resources.painterResource

@Composable
fun ItemGalleryView(
    gallery: GalleryModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    AsyncImage(
        model = gallery.thumbnail ?: gallery.image,
        contentDescription = gallery.caption,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(Res.drawable.placeholder_image),
        error = painterResource(Res.drawable.placeholder_image),
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = onClick)
    )
}
