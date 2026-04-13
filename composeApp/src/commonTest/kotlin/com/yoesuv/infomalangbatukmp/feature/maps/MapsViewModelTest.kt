package com.yoesuv.infomalangbatukmp.feature.maps

import com.yoesuv.infomalangbatukmp.core.repository.PinsRepositoryMock
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
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class MapsViewModelTest {

    private companion object {
        private const val NETWORK_ERROR_MESSAGE = "Network error"
    }

    private lateinit var mockRepository: PinsRepositoryMock
    private lateinit var viewModel: MapsViewModel
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        mockRepository = PinsRepositoryMock()
        viewModel = MapsViewModel(mockRepository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initialState_isLoading() {
        assertTrue(viewModel.uiState is MapsUiState.Loading)
    }

    @Test
    fun loadPins_success_updatesToSuccessState() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.uiState
        assertTrue(state is MapsUiState.Success)
        assertEquals(3, state.pins.size)
        assertEquals("Alun Alun Malang", state.pins[0].name)
    }

    @Test
    fun loadPins_error_updatesToErrorState() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = MapsViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModelWithError.uiState
        assertTrue(state is MapsUiState.Error)
        assertEquals("Failed to load pins: $NETWORK_ERROR_MESSAGE", (state as MapsUiState.Error).message)
    }

    @Test
    fun updatePins_updatesToSuccessState() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        val newPins = (viewModel.uiState as MapsUiState.Success).pins.take(1)
        viewModel.updatePins(newPins)

        val state = viewModel.uiState
        assertTrue(state is MapsUiState.Success)
        assertEquals(1, state.pins.size)
        assertEquals("Alun Alun Malang", state.pins[0].name)
    }

    @Test
    fun retryLoad_retriesLoading() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = MapsViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModelWithError.uiState is MapsUiState.Error)

        // Reset exception and retry
        mockRepository.throwException = false
        viewModelWithError.retryLoad()
        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModelWithError.uiState is MapsUiState.Success)
    }
}
