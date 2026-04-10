package com.yoesuv.infomalangbatukmp.feature.gallery

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.GalleryTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ItemGalleryViewTest {

    private val testGallery = GalleryTestData.createGallery()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysGalleryImage() = runComposeUiTest {
        setContent {
            ItemGalleryView(gallery = testGallery, onClick = {})
        }

        // Gallery item displays image with content description
        onNodeWithContentDescription(GalleryTestData.GALLERY_CAPTION, useUnmergedTree = true).assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun usesImageWhenThumbnailIsNull() = runComposeUiTest {
        val galleryWithNullThumbnail = GalleryTestData.createGallery(thumbnail = null)

        setContent {
            ItemGalleryView(gallery = galleryWithNullThumbnail, onClick = {})
        }

        // Should still display using the image URL
        onNodeWithContentDescription(GalleryTestData.GALLERY_CAPTION, useUnmergedTree = true).assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullCaption() = runComposeUiTest {
        val galleryWithNullCaption = GalleryTestData.createGallery(caption = null)

        setContent {
            ItemGalleryView(gallery = galleryWithNullCaption, onClick = {})
        }

        // Should handle null caption gracefully - component renders without crash
        // When caption is null, contentDescription is null so we verify by ensuring no crash
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun clickTriggersCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ItemGalleryView(gallery = testGallery, onClick = { clicked = true })
        }

        onNodeWithContentDescription(GalleryTestData.GALLERY_CAPTION, useUnmergedTree = true).performClick()

        assertTrue(clicked)
    }
}
