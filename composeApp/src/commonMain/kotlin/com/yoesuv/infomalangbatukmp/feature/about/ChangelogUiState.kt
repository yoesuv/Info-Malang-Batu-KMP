package com.yoesuv.infomalangbatukmp.feature.about

import org.jetbrains.compose.resources.StringResource

data class ChangeLogResource(
    val versionRes: StringResource,
    val descriptionRes: StringResource
)

sealed class ChangelogUiState {
    data object Loading : ChangelogUiState()
    data class Success(val changelogs: List<ChangeLogResource>) : ChangelogUiState()
    data class Error(val message: String) : ChangelogUiState()
}
