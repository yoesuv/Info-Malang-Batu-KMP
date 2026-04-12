package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepositoryImpl
import com.yoesuv.infomalangbatukmp.testdata.ChangelogTestData
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ChangelogContentTest {

    companion object {
        private const val RETRY_LABEL = "Retry"
    }

    private val repository = ChangelogRepositoryImpl()
    private val testChangelogResources = repository.getChangelogResources()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingState_showsLoadingView() = runComposeUiTest {
        setContent {
            ChangelogContent(uiState = ChangelogUiState.Loading)
        }

        onNodeWithText("Loading places...").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun successState_showsChangelogItems() = runComposeUiTest {
        setContent {
            ChangelogContent(uiState = ChangelogUiState.Success(testChangelogResources))
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_VERSION).assertIsDisplayed()
        onNodeWithText(ChangelogTestData.CHANGELOG_DESCRIPTION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsErrorMessage() = runComposeUiTest {
        setContent {
            ChangelogContent(uiState = ChangelogUiState.Error("Network error"))
        }

        onNodeWithText("Error loading places").assertIsDisplayed()
        onNodeWithText("Network error").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_showsRetryButton() = runComposeUiTest {
        setContent {
            ChangelogContent(uiState = ChangelogUiState.Error("Error"))
        }

        onNodeWithText(RETRY_LABEL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun errorState_retryButtonCallsCallback() = runComposeUiTest {
        var retried = false

        setContent {
            ChangelogContent(
                uiState = ChangelogUiState.Error("Error"),
                onRetry = { retried = true }
            )
        }

        onNodeWithText(RETRY_LABEL).performClick()

        assertTrue(retried)
    }
}