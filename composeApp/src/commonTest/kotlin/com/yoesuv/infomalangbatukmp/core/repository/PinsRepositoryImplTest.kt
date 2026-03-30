package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.PinsApiServiceMock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PinsRepositoryImplTest {
    
    private val mockApiService = PinsApiServiceMock()
    private val repository = PinsRepositoryImpl(mockApiService)
    
    @Test
    fun getPins_returnsThreePins() = runTest {
        val result = repository.getPins()
        assertEquals(3, result.size)
    }
    
    @Test
    fun getPins_firstPinIsAlunAlunMalang() = runTest {
        val result = repository.getPins()
        assertEquals("Alun Alun Malang", result[0].name)
    }
    
    @Test
    fun getPins_pinHasValidCoordinates() = runTest {
        val result = repository.getPins()
        result.forEach { pin ->
            assertEquals(1, pin.lokasi)
            assertTrue { pin.latitude != null && pin.latitude < 0 }
            assertTrue { pin.longitude != null && pin.longitude > 0 }
        }
    }
    
    private fun assertTrue(block: () -> Boolean) {
        if (!block()) throw AssertionError("Assertion failed")
    }
}