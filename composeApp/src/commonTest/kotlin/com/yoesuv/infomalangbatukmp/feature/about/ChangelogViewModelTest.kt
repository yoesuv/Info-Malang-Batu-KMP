package com.yoesuv.infomalangbatukmp.feature.about

import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepositoryMock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ChangelogViewModelTest {

    private companion object {
        private const val TEST_ERROR_MESSAGE = "Test error"
    }

    private lateinit var mockRepository: ChangelogRepositoryMock
    private lateinit var viewModel: ChangelogViewModel

    @BeforeTest
    fun setup() {
        mockRepository = ChangelogRepositoryMock()
        viewModel = ChangelogViewModel(mockRepository)
    }

    @Test
    fun init_loadsChangelogsSuccessfully() {
        assertIs<ChangelogUiState.Success>(viewModel.uiState)
        assertEquals(3, (viewModel.uiState as ChangelogUiState.Success).changelogs.size)
    }

    @Test
    fun loadChangelogs_error_setsErrorState() {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = TEST_ERROR_MESSAGE

        val viewModelWithError = ChangelogViewModel(mockRepository)
        
        assertIs<ChangelogUiState.Error>(viewModelWithError.uiState)
        assertEquals(TEST_ERROR_MESSAGE, (viewModelWithError.uiState as ChangelogUiState.Error).message)
    }

    @Test
    fun retryLoad_reloadsAfterError() {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = TEST_ERROR_MESSAGE

        val viewModelWithError = ChangelogViewModel(mockRepository)
        assertIs<ChangelogUiState.Error>(viewModelWithError.uiState)

        mockRepository.throwException = false
        viewModelWithError.retryLoad()

        assertIs<ChangelogUiState.Success>(viewModelWithError.uiState)
        assertEquals(3, (viewModelWithError.uiState as ChangelogUiState.Success).changelogs.size)
    }
}