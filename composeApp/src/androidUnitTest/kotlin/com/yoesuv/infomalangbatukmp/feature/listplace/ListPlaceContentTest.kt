package com.yoesuv.infomalangbatukmp.feature.listplace

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import com.yoesuv.infomalangbatukmp.testdata.PlaceTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ListPlaceContentTest {

    companion object {
        private const val RETRY_LABEL = "Retry"
    }

    private val testPlaces = listOf(PlaceTestData.createPlace())

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

        onNodeWithText(PlaceTestData.PLACE_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsPlaceLocation() = runComposeUiTest {
        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Success(testPlaces))
        }

        onNodeWithText(PlaceTestData.PLACE_LOCATION).assertIsDisplayed()
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

        onNodeWithText(RETRY_LABEL).assertIsDisplayed()
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

        onNodeWithText(RETRY_LABEL).performClick()

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

        onNodeWithText(PlaceTestData.PLACE_NAME).performClick()

        assertTrue(clicked)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsMultiplePlaces() = runComposeUiTest {
        val multiplePlaces = listOf(
            PlaceTestData.createPlace(),
            PlaceTestData.createPlace(
                nama = "Alun Alun Batu",
                lokasi = "Kota Batu",
                deskripsi = "Desc 2"
            )
        )

        setContent {
            ListPlaceContent(uiState = ListPlaceUiState.Success(multiplePlaces))
        }

        onNodeWithText(PlaceTestData.PLACE_NAME).assertIsDisplayed()
        onNodeWithText(PlaceTestData.PLACE_LOCATION).assertIsDisplayed()
    }
}
