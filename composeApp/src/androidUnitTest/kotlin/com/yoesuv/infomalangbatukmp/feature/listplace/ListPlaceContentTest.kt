package com.yoesuv.infomalangbatukmp.feature.listplace

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ListPlaceContentTest {

    companion object {
        private const val PLACE_NAME = "Alun Alun Malang"
        private const val PLACE_LOCATION = "Kota Malang"
    }

    private val testPlaces = listOf(
        PlaceModel(
            nama = PLACE_NAME,
            lokasi = PLACE_LOCATION,
            deskripsi = "Deskripsi tempat wisata",
            thumbnail = "https://example.com/thumb.jpg",
            gambar = "https://example.com/image.jpg"
        )
    )

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingState_showsLoadingView() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Loading)
        }

        onNodeWithText("Loading places...").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsPlaceName() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Success(testPlaces))
        }

        onNodeWithText(PLACE_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsPlaceLocation() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Success(testPlaces))
        }

        onNodeWithText(PLACE_LOCATION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorMessage() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Error("Network error"))
        }

        onNodeWithText("Error loading places").assertIsDisplayed()
        onNodeWithText("Network error").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsRetryButton() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Error("Error"))
        }

        onNodeWithText("Retry").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_retryButtonCallsCallback() = runComposeUiTest {
        var retried = false

        setContent {
            ListPlaceContent(
                uiState = ListPlaceUiState.Error("Error"),
                onRetry = { retried = true }
            )
        }

        onNodeWithText("Retry").performClick()

        assertTrue(retried)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_placeClickCallsCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ListPlaceContent(
                uiState = ListPlaceUiState.Success(testPlaces),
                onPlaceClick = { _, _ -> clicked = true }
            )
        }

        onNodeWithText(PLACE_NAME).performClick()

        assertTrue(clicked)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsMultiplePlaces() = runComposeUiTest {
        val multiplePlaces = listOf(
            PlaceModel(nama = "Alun Alun Malang", lokasi = "Kota Malang",
                deskripsi = "Desc 1", thumbnail = "", gambar = ""),
            PlaceModel(nama = "Alun Alun Batu", lokasi = "Kota Batu",
                deskripsi = "Desc 2", thumbnail = "", gambar = "")
        )

        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Success(multiplePlaces))
        }

        onNodeWithText("Alun Alun Malang").assertIsDisplayed()
        onNodeWithText("Alun Alun Batu").assertIsDisplayed()
    }
}
