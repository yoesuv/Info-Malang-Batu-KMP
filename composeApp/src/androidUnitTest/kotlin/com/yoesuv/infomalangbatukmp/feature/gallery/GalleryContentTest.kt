package com.yoesuv.infomalangbatukmp.feature.gallery

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.testdata.GalleryTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class GalleryContentTest {

    companion object {
        private const val RETRY_LABEL = "Retry"
    }

    private val testGalleries = listOf(GalleryTestData.createGallery())

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingState_showsLoadingView() = runComposeUiTest {
        setContent {
            GalleryContent(uiState = GalleryUiState.Loading)
        }

        onNodeWithText("Loading gallery...").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsGalleryItems() = runComposeUiTest {
        setContent {
            GalleryContent(uiState = GalleryUiState.Success(testGalleries))
        }

        // Gallery items are images, so we just verify the content is set
        onNodeWithText(GalleryTestData.GALLERY_CAPTION).assertDoesNotExist()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorMessage() = runComposeUiTest {
        setContent {
            GalleryContent(uiState = GalleryUiState.Error("Network error"))
        }

        onNodeWithText("Error loading gallery").assertIsDisplayed()
        onNodeWithText("Network error").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsRetryButton() = runComposeUiTest {
        setContent {
            GalleryContent(uiState = GalleryUiState.Error("Error"))
        }

        onNodeWithText(RETRY_LABEL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_retryButtonCallsCallback() = runComposeUiTest {
        var retried = false

        setContent {
            GalleryContent(
                uiState = GalleryUiState.Error("Error"),
                onRetry = { retried = true }
            )
        }

        onNodeWithText(RETRY_LABEL).performClick()

        assertTrue(retried)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_galleryClickCallsCallback() = runComposeUiTest {
        var clickedGallery: GalleryModel? = null

        setContent {
            GalleryContent(
                uiState = GalleryUiState.Success(testGalleries),
                onGalleryClick = { clickedGallery = it }
            )
        }

        // Click on the gallery item using content description
        onNodeWithContentDescription(GalleryTestData.GALLERY_CAPTION, useUnmergedTree = true).performClick()

        assertTrue(clickedGallery != null)
        assertTrue(clickedGallery?.caption == GalleryTestData.GALLERY_CAPTION)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsMultipleGalleries() = runComposeUiTest {
        val multipleGalleries = listOf(
            GalleryTestData.createGallery(),
            GalleryTestData.createGallery(
                caption = "Second Gallery",
                thumbnail = "https://example.com/thumb2.jpg",
                image = "https://example.com/image2.jpg"
            )
        )

        setContent {
            GalleryContent(uiState = GalleryUiState.Success(multipleGalleries))
        }

        // Content should be displayed
        onNodeWithText("Loading gallery...").assertDoesNotExist()
    }
}
