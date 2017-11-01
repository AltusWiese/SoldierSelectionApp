package com.example.awiese.unittesting;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)

@LargeTest
public class FragmentDisplaySoldiersUiTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displayAllSoldiersButton_DisplayRecyclerViewSuccessfully() {
        onView(withId(R.id.button_get_all_soldiers)).perform(click());
        onView(withId(R.id.recycler_view_list_soldiers)).check(matches(isDisplayed()));
    }

    @Test
    public void displayBestMarskmanButton_DisplayRecyclerViewSuccessfully() {
        onView(withId(R.id.button_get_best_marksman_soldiers)).perform(click());
        onView(withId(R.id.recycler_view_list_soldiers)).check(matches(isDisplayed()));
    }

    @Test
    public void displayFastestSoldiersButton_DisplayRecyclerViewSuccessfully() {
        onView(withId(R.id.button_get_fastest_soldiers)).perform(click());
        onView(withId(R.id.recycler_view_list_soldiers)).check(matches(isDisplayed()));
    }

    @Test
    public void displayMostStrongWilledSoldiersButton_DisplayRecyclerViewSuccessfully() {
        onView(withId(R.id.button_get_most_strong_willed_soldiers)).perform(click());
        onView(withId(R.id.recycler_view_list_soldiers)).check(matches(isDisplayed()));
    }

    @Test
    public void displayMostHardenedSoldiersButton_DisplayRecyclerViewSuccessfully() {
        onView(withId(R.id.button_get_most_durable_soldiers)).perform(click());
        onView(withId(R.id.recycler_view_list_soldiers)).check(matches(isDisplayed()));
    }
}