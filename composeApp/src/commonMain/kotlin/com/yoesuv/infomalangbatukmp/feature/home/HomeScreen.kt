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

@Composable
fun HomeScreen() {
    val items = listOf(
        BottomItem(labelRes = Res.string.list_place, icon = Icons.AutoMirrored.Filled.List),
        BottomItem(labelRes = Res.string.gallery, icon = Icons.Filled.Image),
        BottomItem(labelRes = Res.string.maps, icon = Icons.Filled.Map),
        BottomItem(labelRes = Res.string.about, icon = Icons.Filled.Info)
    )

    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
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
                0 -> TabListPlace()
                1 -> TabGallery()
                2 -> TabMaps()
                else -> TabAbout()
            }
        }
    }
}

private data class BottomItem(
    val labelRes: org.jetbrains.compose.resources.StringResource,
    val icon: ImageVector
)