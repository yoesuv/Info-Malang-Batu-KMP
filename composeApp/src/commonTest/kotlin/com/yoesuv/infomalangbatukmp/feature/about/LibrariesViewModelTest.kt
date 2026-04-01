package com.yoesuv.infomalangbatukmp.feature.about

import com.yoesuv.infomalangbatukmp.core.repository.LibrariesRepositoryMock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class LibrariesViewModelTest {

    private companion object {
        private const val TEST_ERROR_MESSAGE = "Test error"
    }

    private lateinit var mockRepository: LibrariesRepositoryMock
    private lateinit var viewModel: LibrariesViewModel

    @BeforeTest
    fun setup() {
        mockRepository = LibrariesRepositoryMock()
        viewModel = LibrariesViewModel(mockRepository)
    }

    @Test
    fun init_loadsLibrariesSuccessfully() {
        assertIs<LibrariesUiState.Success>(viewModel.uiState)
        assertEquals(6, (viewModel.uiState as LibrariesUiState.Success).libraries.size)
    }

    @Test
    fun loadLibraries_error_setsErrorState() {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = TEST_ERROR_MESSAGE

        val viewModelWithError = LibrariesViewModel(mockRepository)
        
        assertIs<LibrariesUiState.Error>(viewModelWithError.uiState)
        assertEquals(TEST_ERROR_MESSAGE, (viewModelWithError.uiState as LibrariesUiState.Error).message)
    }

    @Test
    fun retryLoad_reloadsAfterError() {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = TEST_ERROR_MESSAGE

        val viewModelWithError = LibrariesViewModel(mockRepository)
        assertIs<LibrariesUiState.Error>(viewModelWithError.uiState)

        mockRepository.throwException = false
        viewModelWithError.retryLoad()

        assertIs<LibrariesUiState.Success>(viewModelWithError.uiState)
        assertEquals(6, (viewModelWithError.uiState as LibrariesUiState.Success).libraries.size)
    }
}