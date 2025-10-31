package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import com.yoesuv.infomalangbatukmp.core.theme.AppColors
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.about_libraries
import org.jetbrains.compose.resources.stringResource

@Composable
fun TabLibraries() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(Res.string.about_libraries))
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
            fontWeight = FontWeight.Bold
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
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
            )
        }
    }
}
