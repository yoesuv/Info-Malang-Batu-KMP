package com.yoesuv.infomalangbatukmp.feature.maps

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.PinTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class MapsContentTest {

    companion object {
        private const val RETRY_LABEL = "Retry"
        private const val ERROR_MESSAGE = "Failed to load pins: Network error"
    }

    private val testPins = listOf(PinTestData.createPin())

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingState_showsLoadingView() = runComposeUiTest {
        setContent {
            MapsContent(uiState = MapsUiState.Loading)
        }

        onNodeWithText("Loading places...").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorTitle() = runComposeUiTest {
        setContent {
            MapsContent(uiState = MapsUiState.Error(ERROR_MESSAGE))
        }

        onNodeWithText("Error loading places").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorMessage() = runComposeUiTest {
        setContent {
            MapsContent(uiState = MapsUiState.Error(ERROR_MESSAGE))
        }

        onNodeWithText(ERROR_MESSAGE).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsRetryButton() = runComposeUiTest {
        setContent {
            MapsContent(uiState = MapsUiState.Error(ERROR_MESSAGE))
        }

        onNodeWithText(RETRY_LABEL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_retryButtonCallsCallback() = runComposeUiTest {
        var retried = false

        setContent {
            MapsContent(
                uiState = MapsUiState.Error(ERROR_MESSAGE),
                onRetry = { retried = true }
            )
        }

        onNodeWithText(RETRY_LABEL).performClick()

        assertTrue(retried)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_rendersWithoutCrash() = runComposeUiTest {
        setContent {
            MapsContent(uiState = MapsUiState.Success(testPins))
        }

        // The Map composable from KMP Maps won't render in unit tests,
        // but we verify the composable doesn't crash when in success state
        // In a real device, the map would show with markers
    }
}
