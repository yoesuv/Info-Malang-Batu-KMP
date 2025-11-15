package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.components.AppTopBar
import androidx.navigation.NavController

@Composable
fun DetailGalleryScreen(
    gallery: GalleryModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Gallery Detail",
                canBack = true,
                navigateUp = { navController.navigateUp() }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Image
            AsyncImage(
                model = gallery.image,
                contentDescription = gallery.caption,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Caption Text
            Text(
                text = gallery.caption.orEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp
                    ),
                fontSize = 14.sp
            )
        }
    }
}

