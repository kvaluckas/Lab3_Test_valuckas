package com.example.tablelayoutsample;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void performBasicCalculation_displaysCorrectResult() {
        Espresso.onView(ViewMatchers.withText("2"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("+"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("3"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("="))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.calculatorScreen))
                .check(ViewAssertions.matches(ViewMatchers.withText("5")));
    }
    @Test
    public void performClearOperations_resetsCalculatorScreen() {
        // Assuming some input is entered, and then "CE" is clicked
        Espresso.onView(ViewMatchers.withText("123"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.clearEverything))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.calculatorScreen))
                .check(ViewAssertions.matches(ViewMatchers.withText("")));
    }
    @Test
    public void performComplexOperations_displaysCorrectResult() {
        Espresso.onView(ViewMatchers.withText("8"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("+"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("2"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("*"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("3"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("="))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.calculatorScreen))
                .check(ViewAssertions.matches(ViewMatchers.withText("24")));
    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.tablelayoutsample", appContext.getPackageName());
    }
}