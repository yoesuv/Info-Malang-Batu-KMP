package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import kotlin.test.Test
import kotlin.test.assertTrue

class ItemPlaceViewTest {

    companion object {
        private const val PLACE_NAME = "Alun Alun Malang"
        private const val PLACE_LOCATION = "Malang"
    }

    private val testPlace = PlaceModel(
        nama = PLACE_NAME,
        lokasi = PLACE_LOCATION,
        deskripsi = "Deskripsi tempat wisata",
        thumbnail = "https://example.com/thumb.jpg",
        gambar = "https://example.com/image.jpg"
    )

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysPlaceName() = runComposeUiTest {
        setContent {
            ItemPlaceView(place = testPlace, onClick = {})
        }

        onNodeWithText(PLACE_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysPlaceLocation() = runComposeUiTest {
        setContent {
            ItemPlaceView(place = testPlace, onClick = {})
        }

        onNodeWithText(PLACE_LOCATION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyStringsWhenNameIsNull() = runComposeUiTest {
        val nullNamePlace = testPlace.copy(nama = null)

        setContent {
            ItemPlaceView(place = nullNamePlace, onClick = {})
        }

        onNodeWithText("").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysEmptyStringsWhenLocationIsNull() = runComposeUiTest {
        val nullLocationPlace = testPlace.copy(lokasi = null)

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

        onNodeWithText(PLACE_NAME).performClick()

        assertTrue(clicked)
    }
}