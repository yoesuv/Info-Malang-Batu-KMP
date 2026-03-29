package com.yoesuv.infomalangbatukmp.feature.gallery

import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepositoryMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

@OptIn(ExperimentalCoroutinesApi::class)
class GalleryViewModelTest {

    private companion object {
        private const val NETWORK_ERROR_MESSAGE = "Network error"
    }

    private lateinit var mockRepository: GalleryRepositoryMock
    private lateinit var viewModel: GalleryViewModel
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        mockRepository = GalleryRepositoryMock()
        viewModel = GalleryViewModel(mockRepository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initialState_isLoading() {
        assertIs<GalleryUiState.Loading>(viewModel.uiState)
    }

    @Test
    fun loadGallery_success_setsSuccessState() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.uiState
        assertIs<GalleryUiState.Success>(state)
        assertEquals(3, state.galleries.size)
        assertEquals("Zona Infinite World di Jatim Park 3", state.galleries[0].caption)
    }

    @Test
    fun loadGallery_error_setsErrorState() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = GalleryViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModelWithError.uiState
        assertIs<GalleryUiState.Error>(state)
        assertEquals(NETWORK_ERROR_MESSAGE, state.message)
    }

    @Test
    fun retryLoad_reloadsDataAfterError() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = GalleryViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        assertIs<GalleryUiState.Error>(viewModelWithError.uiState)

        mockRepository.throwException = false
        viewModelWithError.retryLoad()
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModelWithError.uiState
        assertIs<GalleryUiState.Success>(state)
        assertEquals(3, state.galleries.size)
    }
}