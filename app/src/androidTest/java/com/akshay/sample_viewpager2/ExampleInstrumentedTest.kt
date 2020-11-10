package com.akshay.sample_viewpager2

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun viewPagerTest_fragment1Visible() {
        launch(MainActivity::class.java).use {
            Espresso.onView(
                CoreMatchers.allOf(
                    withId(R.id.name_naruto),
                    ViewMatchers.isCompletelyDisplayed()
                )
            ).check(ViewAssertions.matches(withText("Naruto Uzumaki")))
        }
    }

    @Test
    fun viewPagerTest_swipeLeft_fragment2Visible() {
        launch(MainActivity::class.java).use {
            Espresso.onView(withId(R.id.viewPager2))
                .perform(ViewActions.swipeLeft())
            Espresso.onView(
                CoreMatchers.allOf(
                    withId(R.id.name_naruto),
                    ViewMatchers.isCompletelyDisplayed()
                )
            ).check(ViewAssertions.matches(withText("Sasuke Uchiha")))
        }
    }

    @Test
    fun viewPagerTest_clickSkip_lastFragmentVisible() {
        launch(MainActivity::class.java).use {
            Espresso.onView(withId(R.id.skip_button)).perform(click())
            Espresso.onView(
                CoreMatchers.allOf(
                    withId(R.id.name_naruto),
                    ViewMatchers.isCompletelyDisplayed()
                )
            ).check(ViewAssertions.matches(withText("Kakashi Hatake")))
        }
    }
}