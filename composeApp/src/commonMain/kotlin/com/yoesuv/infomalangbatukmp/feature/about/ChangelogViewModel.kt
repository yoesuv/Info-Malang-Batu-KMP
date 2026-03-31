package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepository
import org.jetbrains.compose.resources.StringResource

data class ChangeLogResource(
    val versionRes: StringResource,
    val descriptionRes: StringResource
)

sealed class ChangelogUiState {
    object Loading : ChangelogUiState()
    data class Success(val changelogs: List<ChangeLogResource>) : ChangelogUiState()
    data class Error(val message: String) : ChangelogUiState()
}

class ChangelogViewModel(
    private val changelogRepository: ChangelogRepository
) : ViewModel() {

    var uiState by mutableStateOf<ChangelogUiState>(ChangelogUiState.Loading)
        private set

    init {
        loadChangelogs()
    }

    fun loadChangelogs() {
        try {
            uiState = ChangelogUiState.Loading
            val changelogs = changelogRepository.getChangelogResources()
            uiState = ChangelogUiState.Success(changelogs)
        } catch (e: Exception) {
            uiState = ChangelogUiState.Error(e.message ?: "Unknown error occurred")
        }
    }

    fun retryLoad() {
        loadChangelogs()
    }
}