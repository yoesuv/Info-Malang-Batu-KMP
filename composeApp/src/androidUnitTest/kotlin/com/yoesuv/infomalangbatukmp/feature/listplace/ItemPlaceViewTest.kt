package com.yoesuv.infomalangbatukmp.feature.listplace

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.PlaceTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ItemPlaceViewTest {

    private val testPlace = PlaceTestData.createPlace()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysPlaceName() = runComposeUiTest {
        setContent {
            ItemPlaceView(place = testPlace, onClick = {})
        }

        onNodeWithText(PlaceTestData.PLACE_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysPlaceLocation() = runComposeUiTest {
        setContent {
            ItemPlaceView(place = testPlace, onClick = {})
        }

        onNodeWithText(PlaceTestData.PLACE_LOCATION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyStringsWhenNameIsNull() = runComposeUiTest {
        val nullNamePlace = PlaceTestData.createPlace(nama = null)

        setContent {
            ItemPlaceView(place = nullNamePlace, onClick = {})
        }

        onNodeWithText("").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyStringsWhenLocationIsNull() = runComposeUiTest {
        val nullLocationPlace = PlaceTestData.createPlace(lokasi = null)

        setContent {
            ItemPlaceView(place = nullLocationPlace, onClick = {})
        }

        onNodeWithText("").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun clickTriggersCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ItemPlaceView(place = testPlace, onClick = { clicked = true })
        }

        onNodeWithText(PlaceTestData.PLACE_NAME).performClick()

        assertTrue(clicked)
    }
}
