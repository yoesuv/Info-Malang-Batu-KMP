package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.GalleryApiServiceMock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GalleryRepositoryImplTest {
    
    private val mockApiService = GalleryApiServiceMock()
    private val repository = GalleryRepositoryImpl(mockApiService)
    
    @Test
    fun getGallery_returnsThreeGalleries() = runTest {
        val result = repository.getGallery()
        assertEquals(3, result.size)
    }
    
    @Test
    fun getGallery_firstGalleryIsZonaInfiniteWorld() = runTest {
        val result = repository.getGallery()
        assertEquals("Zona Infinite World di Jatim Park 3", result[0].caption)
    }
    
    @Test
    fun getGallery_galleryHasValidUrls() = runTest {
        val result = repository.getGallery()
        result.forEach { gallery ->
            assertTrue(gallery.thumbnail!!.startsWith("https://"))
            assertTrue(gallery.image!!.startsWith("https://"))
        }
    }
}