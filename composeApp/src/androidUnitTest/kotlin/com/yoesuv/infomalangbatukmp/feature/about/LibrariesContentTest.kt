package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.LibraryTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class LibrariesContentTest {

    companion object {
        private const val RETRY_LABEL = "Retry"
    }

    private val testLibraries = listOf(LibraryTestData.createLibrary())

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingState_showsLoadingView() = runComposeUiTest {
        setContent {
            LibrariesContent(uiState = LibrariesUiState.Loading)
        }

        onNodeWithText("Loading places...").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsLibraryName() = runComposeUiTest {
        setContent {
            LibrariesContent(uiState = LibrariesUiState.Success(testLibraries))
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsLibraryUrl() = runComposeUiTest {
        setContent {
            LibrariesContent(uiState = LibrariesUiState.Success(testLibraries))
        }

        onNodeWithText(LibraryTestData.LIBRARY_URL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorMessage() = runComposeUiTest {
        setContent {
            LibrariesContent(uiState = LibrariesUiState.Error("Network error"))
        }

        onNodeWithText("Error loading places").assertIsDisplayed()
        onNodeWithText("Network error").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsRetryButton() = runComposeUiTest {
        setContent {
            LibrariesContent(uiState = LibrariesUiState.Error("Error"))
        }

        onNodeWithText(RETRY_LABEL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_retryButtonCallsCallback() = runComposeUiTest {
        var retried = false

        setContent {
            LibrariesContent(
                uiState = LibrariesUiState.Error("Error"),
                onRetry = { retried = true }
            )
        }

        onNodeWithText(RETRY_LABEL).performClick()

        assertTrue(retried)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsMultipleLibraries() = runComposeUiTest {
        val multipleLibraries = LibraryTestData.createLibraries()

        setContent {
            LibrariesContent(uiState = LibrariesUiState.Success(multipleLibraries))
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }
}