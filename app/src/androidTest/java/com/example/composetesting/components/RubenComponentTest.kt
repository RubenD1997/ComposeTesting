package com.example.composetesting.components

import android.annotation.SuppressLint
import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import androidx.test.espresso.action.ViewActions.doubleClick
import com.example.composetesting.RubenComponent
import org.junit.Rule
import org.junit.Test

class RubenComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @SuppressLint("CheckResult")
    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            RubenComponent()
        }
        //Finder
        composeTestRule.onNodeWithText("Pepe", ignoreCase = true)
        composeTestRule.onNodeWithTag("PepeTag")
        composeTestRule.onNodeWithContentDescription("Person Icon")

        composeTestRule.onAllNodesWithText("a")
        composeTestRule.onAllNodesWithTag("PepeTag")
        composeTestRule.onAllNodesWithContentDescription("Person Icon")

        //Actions
        composeTestRule.onNodeWithText("Pepe", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("Pepe").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeRight()
            swipeLeft()
        }
        composeTestRule.onNodeWithText("Pepe").performScrollTo().performClick()
        composeTestRule.onNodeWithText("Pepe").performImeAction()
        composeTestRule.onNodeWithText("Pepe").performTextClearance()
        composeTestRule.onNodeWithText("Pepe").performTextInput("Cj Jonson")
        composeTestRule.onNodeWithText("Pepe").performTextReplacement("Carl")

        //Assertions
        composeTestRule.onNodeWithText("Ruben").assertExists()
        composeTestRule.onNodeWithText("Ruben").assertDoesNotExist()
        composeTestRule.onNodeWithText("Ruben").assertContentDescriptionEquals("Ruben")
        composeTestRule.onNodeWithText("Ruben").assertContentDescriptionContains("Ruben")
        composeTestRule.onNodeWithText("Ruben").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ruben").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("Ruben").assertIsNotEnabled()
        composeTestRule.onNodeWithText("Ruben").assertIsEnabled()
        composeTestRule.onNodeWithText("Ruben").assertIsSelected()
        composeTestRule.onNodeWithText("Ruben").assertIsNotSelected()
        composeTestRule.onNodeWithText("Ruben").assertIsNotFocused()
        composeTestRule.onNodeWithText("Ruben").assertIsFocused()
        composeTestRule.onNodeWithText("Ruben").assertIsOn()
        composeTestRule.onNodeWithText("Ruben").assertIsOff()
        composeTestRule.onNodeWithText("Ruben").assertTextEquals("")
        composeTestRule.onNodeWithText("Ruben").assertTextContains("Ruben")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsRuben() {
        composeTestRule.setContent {
            RubenComponent()
        }
        composeTestRule.onNodeWithText("Ruben", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("RubenTag").assertTextContains("Ruben")
        composeTestRule.onNodeWithText("Ruben", ignoreCase = true)
        composeTestRule.onNodeWithText("Ruben", ignoreCase = true)
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            RubenComponent()
        }
        composeTestRule.onNodeWithTag("RubenTag").performTextClearance()
        composeTestRule.onNodeWithTag("RubenTag").performTextInput("Ruben")
        composeTestRule.onNodeWithTag("RubenTag").performTextReplacement("Ruben")
        composeTestRule.onNodeWithTag("TextGreeting").assertTextEquals("Te llamas Ruben")
    }
}