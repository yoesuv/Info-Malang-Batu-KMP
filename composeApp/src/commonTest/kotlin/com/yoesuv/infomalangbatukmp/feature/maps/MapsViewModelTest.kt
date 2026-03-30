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
import kotlin.test.assertNull

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
    fun initialState_emptyPins() {
        assertEquals(0, viewModel.pins.size)
        assertNull(viewModel.snackbarMessage)
    }

    @Test
    fun loadPins_success_updatesPins() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(3, viewModel.pins.size)
        assertEquals("Alun Alun Malang", viewModel.pins[0].name)
        assertNull(viewModel.snackbarMessage)
    }

    @Test
    fun loadPins_error_showsSnackbar() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = MapsViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(0, viewModelWithError.pins.size)
        assertEquals("Failed to load pins: $NETWORK_ERROR_MESSAGE", viewModelWithError.snackbarMessage)
    }

    @Test
    fun clearSnackbar_clearsMessage() = runTest {
        mockRepository.throwException = true
        mockRepository.exceptionMessage = NETWORK_ERROR_MESSAGE

        val viewModelWithError = MapsViewModel(mockRepository)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Failed to load pins: $NETWORK_ERROR_MESSAGE", viewModelWithError.snackbarMessage)

        viewModelWithError.clearSnackbar()
        assertNull(viewModelWithError.snackbarMessage)
    }

    @Test
    fun updatePins_updatesPinsList() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()

        val newPins = viewModel.pins.take(1)
        viewModel.updatePins(newPins)

        assertEquals(1, viewModel.pins.size)
        assertEquals("Alun Alun Malang", viewModel.pins[0].name)
    }
}