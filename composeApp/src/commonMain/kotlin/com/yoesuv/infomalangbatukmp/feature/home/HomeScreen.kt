package com.yoesuv.infomalangbatukmp.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.saveable.rememberSaveable
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.about
import infomalangbatukmp.composeapp.generated.resources.gallery
import infomalangbatukmp.composeapp.generated.resources.list_place
import infomalangbatukmp.composeapp.generated.resources.maps
import org.jetbrains.compose.resources.stringResource
import com.yoesuv.infomalangbatukmp.feature.listplace.ListPlaceScreen
import com.yoesuv.infomalangbatukmp.feature.gallery.GalleryScreen
import com.yoesuv.infomalangbatukmp.feature.maps.MapsScreen
import com.yoesuv.infomalangbatukmp.feature.about.AboutScreen
import com.yoesuv.infomalangbatukmp.components.AppTopBar
import androidx.navigation.NavController
import com.yoesuv.infomalangbatukmp.core.route.AppRoute

@Composable
fun HomeScreen(navController: NavController? = null) {
    val items = listOf(
        BottomItem(labelRes = Res.string.list_place, icon = Icons.AutoMirrored.Filled.List),
        BottomItem(labelRes = Res.string.gallery, icon = Icons.Filled.Image),
        BottomItem(labelRes = Res.string.maps, icon = Icons.Filled.Map),
        BottomItem(labelRes = Res.string.about, icon = Icons.Filled.Info)
    )

    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(items[selectedIndex].labelRes),
                canBack = false
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = item.icon, contentDescription = stringResource(item.labelRes)) },
                        label = { Text(text = stringResource(item.labelRes)) },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedIndex) {
                0 -> ListPlaceScreen(
                    onPlaceClick = { _, detailRoute ->
                        navController?.navigate(detailRoute)
                    }
                )
                1 -> GalleryScreen(
                    onGalleryClick = { gallery ->
                        navController?.navigate(AppRoute.DetailGallery(
                            image = gallery.image.orEmpty(),
                            caption = gallery.caption.orEmpty()
                        ))
                    }
                )
                2 -> MapsScreen()
                else -> AboutScreen()
            }
        }
    }
}

private data class BottomItem(
    val labelRes: org.jetbrains.compose.resources.StringResource,
    val icon: ImageVector
)