package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceMock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlaceRepositoryImplTest {
    
    private val mockApiService = PlaceApiServiceMock()
    private val repository= PlaceRepositoryImpl(mockApiService)
    
    @Test
    fun getPlaces_returnsThreePlaces() = runTest {
        val result = repository.getPlaces()
        assertEquals(3, result.size)
    }
    
    @Test
    fun getPlaces_firstPlaceIsAlunAlunMalang() = runTest {
        val result = repository.getPlaces()
        assertEquals("Alun Alun Malang", result[0].nama)
        assertEquals("Kota Malang", result[0].lokasi)
    }
    
    @Test
    fun getPlaces_placeHasValidUrls() = runTest {
        val result = repository.getPlaces()
        result.forEach { place ->
            assertTrue(place.thumbnail!!.startsWith("https://"))
            assertTrue(place.gambar!!.startsWith("https://"))
        }
    }
}