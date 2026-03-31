package com.yoesuv.infomalangbatukmp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.placeholder_image
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppNetworkImage(
    url: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        model = url,
        contentDescription = contentDescription,
        modifier = modifier,
        placeholder = painterResource(Res.drawable.placeholder_image),
        error = painterResource(Res.drawable.placeholder_image),
        contentScale = contentScale
    )
}