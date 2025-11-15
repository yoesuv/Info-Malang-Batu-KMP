package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.yoesuv.infomalangbatukmp.components.AppTopBar
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.detail_gallery
import org.jetbrains.compose.resources.stringResource

@Composable
fun DetailListPlaceScreen(
    imageUrl: String?,
    title: String?,
    description: String?,
    onNavigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        AppTopBar(
            title = stringResource(Res.string.detail_gallery),
            canBack = true,
            navigateUp = onNavigateUp
        )

        // Image
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        // Title Text
        Text(
            text = title.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.1.em
        )

        // Description Text
        Text(
            text = description.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 1.1.em
        )
    }
}