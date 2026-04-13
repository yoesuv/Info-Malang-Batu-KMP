package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepository

class ChangelogViewModel(
    private val changelogRepository: ChangelogRepository
) : ViewModel() {

    var uiState by mutableStateOf<ChangelogUiState>(ChangelogUiState.Loading)
        private set

    init {
        loadChangelogs()
    }

    @Suppress("TooGenericExceptionCaught")
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
