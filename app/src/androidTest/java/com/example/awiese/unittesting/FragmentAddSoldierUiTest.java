package com.example.awiese.unittesting;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)

@LargeTest
public class FragmentAddSoldierUiTest {

    private String mSoldierName;
    private String mSoldierAlias;
    private String mSoldierNationality;
    private String mSoldierUnitClass;


    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidSoldier() {
        mSoldierName = "John";
        mSoldierAlias = "MacGyver";
        mSoldierNationality = "American";
        mSoldierUnitClass = "Grenadier";
    }

    @Test
    public void AddSoldierButton_SoldierAddedSuccessfully() {

        onView(withId(R.id.add_soldier_name)).perform(typeText(mSoldierName));
        onView(withId(R.id.add_soldier_alias)).perform(typeText(mSoldierAlias));
        onView(withId(R.id.add_soldier_nationality)).perform(typeText(mSoldierNationality));
        onView(withId(R.id.add_soldier_unit_class)).perform(typeText(mSoldierUnitClass));
        closeSoftKeyboard();
        onView(withId(R.id.add_soldier_button)).perform(click());

        onView(withId(R.id.add_soldier_button)).perform(click()).check(matches(isDisplayed()));
    }
}
