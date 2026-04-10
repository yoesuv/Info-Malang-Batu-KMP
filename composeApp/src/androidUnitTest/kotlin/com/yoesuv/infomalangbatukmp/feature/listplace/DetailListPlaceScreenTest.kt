package com.yoesuv.infomalangbatukmp.feature.listplace

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.PlaceTestData
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class DetailListPlaceScreenTest {

    companion object {
        private const val TOP_BAR_TITLE = "Detail Place"
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun topBar_showsDetailTitle() = runComposeUiTest {
        setContent {
            DetailListPlaceScreen(
                imageUrl = PlaceTestData.PLACE_IMAGE,
                title = PlaceTestData.PLACE_NAME,
                description = PlaceTestData.PLACE_DESCRIPTION
            )
        }

        onNodeWithText(TOP_BAR_TITLE).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysTitle() = runComposeUiTest {
        setContent {
            DetailListPlaceScreen(
                imageUrl = PlaceTestData.PLACE_IMAGE,
                title = PlaceTestData.PLACE_NAME,
                description = PlaceTestData.PLACE_DESCRIPTION
            )
        }

        onNodeWithText(PlaceTestData.PLACE_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysDescription() = runComposeUiTest {
        setContent {
            DetailListPlaceScreen(
                imageUrl = PlaceTestData.PLACE_IMAGE,
                title = PlaceTestData.PLACE_NAME,
                description = PlaceTestData.PLACE_DESCRIPTION
            )
        }

        onNodeWithText(PlaceTestData.PLACE_DESCRIPTION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyTitleWhenNull() = runComposeUiTest {
        setContent {
            DetailListPlaceScreen(
                imageUrl = PlaceTestData.PLACE_IMAGE,
                title = null,
                description = PlaceTestData.PLACE_DESCRIPTION
            )
        }

        onNodeWithText("").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyDescriptionWhenNull() = runComposeUiTest {
        setContent {
            DetailListPlaceScreen(
                imageUrl = PlaceTestData.PLACE_IMAGE,
                title = PlaceTestData.PLACE_NAME,
                description = null
            )
        }

        onNodeWithText("").assertIsDisplayed()
    }
}
