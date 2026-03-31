package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fleeksoft.ksoup.Ksoup
import com.yoesuv.infomalangbatukmp.components.ErrorView
import com.yoesuv.infomalangbatukmp.components.LoadingView
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import com.yoesuv.infomalangbatukmp.core.theme.AppColors
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TabLibraries() {
    val viewModel: LibrariesViewModel = koinViewModel()

    when (val state = viewModel.uiState) {
        is LibrariesUiState.Loading -> {
            LoadingView()
        }
        is LibrariesUiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(state.libraries) { lib ->
                    ItemLibrary(library = lib)
                }
            }
        }
        is LibrariesUiState.Error -> {
            ErrorView(
                message = state.message,
                onRetry = { viewModel.retryLoad() }
            )
        }
    }
}

@Composable
fun ItemLibrary(
    library: LibraryModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        val nameText = library.name?.let { stringResource(it) } ?: ""
        val urlText = library.url?.let { stringResource(it) } ?: ""
        val licenseText = library.license?.let { stringResource(it) } ?: ""
        Text(
            text = nameText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = urlText,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.Link
        )

        Text(
            text = Ksoup.parse(licenseText).body().wholeText(),
            fontSize = 10.sp,
            fontFamily = FontFamily.Monospace,
            style = TextStyle(
                lineHeight = 1.05.em,
            )
        )

        if (!(library.isLast ?: true)) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                thickness = 1.dp,
            )
        }
    }
}