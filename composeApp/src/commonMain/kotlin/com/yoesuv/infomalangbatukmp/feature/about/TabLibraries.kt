package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import com.yoesuv.infomalangbatukmp.core.theme.AppColors
import com.yoesuv.infomalangbatukmp.feature.about.LibrariesViewModel
import infomalangbatukmp.composeapp.generated.resources.Res
 

@Composable
fun TabLibraries() {
    val viewModel = remember { LibrariesViewModel() }

    LaunchedEffect(Unit) {
        viewModel.updateLibraries(
            listOf(
                LibraryModel(
                    name = "Compose Multiplatform",
                    url = "https://www.jetbrains.com/lp/compose-multiplatform/",
                    license = "Apache-2.0",
                    isLast = false
                ),
                LibraryModel(
                    name = "Kotlin",
                    url = "https://kotlinlang.org/",
                    license = "Apache-2.0",
                    isLast = false
                ),
                LibraryModel(
                    name = "Kotlinx Coroutines",
                    url = "https://github.com/Kotlin/kotlinx.coroutines",
                    license = "Apache-2.0",
                    isLast = true
                )
            )
        )
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.libraries) { lib ->
            ItemLibrary(library = lib)
        }
    }
}

@Composable
fun ItemLibrary(
    library: LibraryModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = library.name ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )

        Text(
            text = library.url ?: "",
            fontSize = 11.sp,
            color = AppColors.Link
        )

        Text(
            text = library.license ?: "",
            fontSize = 12.sp,
            fontFamily = FontFamily.Monospace
        )

        if (!(library.isLast ?: true)) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 4.dp),
                thickness = 1.dp,
            )
        }
    }
}
