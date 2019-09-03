package com.example.weatherapp.ui

import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.weatherapp.R
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherActivityTest {

    lateinit var instrumentationContext: Context

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(WeatherActivity::class.java)

    @Before
    fun setup() {
//        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
//        val intent = Intent(instrumentationContext, WeatherActivity::class.java)
//        activityRule.launchActivity(intent)
    }

    @Test
    fun successTest() {
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.id_temp))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.id_location))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.unit))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}