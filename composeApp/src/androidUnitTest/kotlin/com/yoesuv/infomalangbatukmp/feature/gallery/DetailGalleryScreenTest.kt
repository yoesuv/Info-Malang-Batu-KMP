package com.yoesuv.infomalangbatukmp.feature.gallery

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.GalleryTestData
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class DetailGalleryScreenTest {

    companion object {
        private const val TOP_BAR_TITLE = "Detail Gallery"
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun topBar_showsDetailTitle() = runComposeUiTest {
        setContent {
            DetailGalleryScreen(
                image = GalleryTestData.GALLERY_IMAGE,
                caption = GalleryTestData.GALLERY_CAPTION
            )
        }

        onNodeWithText(TOP_BAR_TITLE).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysCaption() = runComposeUiTest {
        setContent {
            DetailGalleryScreen(
                image = GalleryTestData.GALLERY_IMAGE,
                caption = GalleryTestData.GALLERY_CAPTION
            )
        }

        onNodeWithText(GalleryTestData.GALLERY_CAPTION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyCaptionWhenNull() = runComposeUiTest {
        setContent {
            DetailGalleryScreen(
                image = GalleryTestData.GALLERY_IMAGE,
                caption = ""
            )
        }

        onNodeWithText("").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysImageWithEmptyCaption() = runComposeUiTest {
        setContent {
            DetailGalleryScreen(
                image = GalleryTestData.GALLERY_IMAGE,
                caption = ""
            )
        }

        onNodeWithText(TOP_BAR_TITLE).assertIsDisplayed()
    }
}
