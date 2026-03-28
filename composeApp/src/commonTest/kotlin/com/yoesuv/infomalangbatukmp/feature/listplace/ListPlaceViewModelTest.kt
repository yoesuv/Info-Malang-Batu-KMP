package com.yoesuv.infomalangbatukmp.feature.listplace

import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepositoryMock
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
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class ListPlaceViewModelTest {

    private companion object {
        private const val NETWORK_ERROR_MESSAGE = "Network error"
    }

    private lateinit var mockRepository: PlaceRepositoryMock
    private lateinit var viewModel: ListPlaceViewModel
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        mockRepository = PlaceRepositoryMock()
        viewModel = ListPlaceViewModel(mockRepository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initialState_isLoading() {
        assertIs<ListPlaceUiState.Loading>(viewModel.uiState)
    }

    @Test
    fun loadPlaces_success_setsSuccessState() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.uiState
        assertIs<ListPlaceUiState.Success>(state)
        assertEquals(3, state.places.size)
        assertEquals("Alun Alun Malang", state.places[0].nama)
    }

    @Test
    fun loadPlaces_error_setsErrorState() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = ListPlaceViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModelWithError.uiState
        assertIs<ListPlaceUiState.Error>(state)
        assertEquals(NETWORK_ERROR_MESSAGE, state.message)
    }

    @Test
    fun retryLoad_reloadsDataAfterError() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = ListPlaceViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        assertIs<ListPlaceUiState.Error>(viewModelWithError.uiState)

        mockRepository.throwException = false
        viewModelWithError.retryLoad()
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModelWithError.uiState
        assertIs<ListPlaceUiState.Success>(state)
        assertEquals(3, state.places.size)
    }
}