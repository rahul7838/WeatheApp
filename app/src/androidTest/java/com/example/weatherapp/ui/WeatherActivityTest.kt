package com.example.weatherapp.ui
//
//import android.content.Context
//import androidx.test.espresso.Espresso
//import androidx.test.espresso.assertion.ViewAssertions
//import androidx.test.espresso.matcher.ViewMatchers
//import androidx.test.internal.runner.listener.InstrumentationResultPrinter
//import androidx.test.platform.app.InstrumentationRegistry
//import androidx.test.rule.ActivityTestRule
//import androidx.test.runner.AndroidJUnit4
//import androidx.test.uiautomator.UiDevice
//import androidx.test.uiautomator.UiSelector
//import com.example.weatherapp.R
//import org.junit.Before
//
//import org.junit.Assert.*
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class WeatherActivityTest {
//
//    lateinit var instrumentationContext: Context
//
//    @Rule
//    @JvmField
//    val activityRule = ActivityTestRule(WeatherActivity::class.java)
//
//    private var device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//
//    @Before
//    fun setup() {
////        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
////        val intent = Intent(instrumentationContext, WeatherActivity::class.java)
////        activityRule.launchActivity(intent)
//    }
//
//    @Test
//    fun successTest() {
////        Thread.sleep(5000)
//        device.findObject(UiSelector().text("ALLOW")).click()
//        Espresso.onView(ViewMatchers.withId(R.id.id_temp))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.id_location))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.unit))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }
//}