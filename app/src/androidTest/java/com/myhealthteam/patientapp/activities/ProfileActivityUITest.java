package com.myhealthteam.patientapp.activities;

import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.myhealthteam.patientapp.R;

import org.junit.Rule;
import org.junit.Test;

public class ProfileActivityUITest {

    @Rule
    public ActivityScenarioRule<ProfileActivity> activityRule = new ActivityScenarioRule<>(ProfileActivity.class);

    @Test
    public void testProfileUIElementsDisplayed() {
        // Check that all views are displayed
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.logout_button))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edit_profile_button))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testBackButtonClick() {
        // Launch the activity
        ActivityScenario<ProfileActivity> scenario = ActivityScenario.launch(ProfileActivity.class);

        // Click the back button
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
                .perform(ViewActions.click());

        // Assert that the activity is closed
        scenario.onActivity(activity -> {
            assertTrue(activity.isFinishing());
        });
    }

    @Test
    public void testLogoutButtonClick() {
        // Perform click on the logout button
        Espresso.onView(ViewMatchers.withId(R.id.logout_button))
                .perform(ViewActions.click());

        // Verify that the LoginActivity is launched
        Espresso.onView(ViewMatchers.withText("Login"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testEditProfileButtonClick() {
        // Perform click on the edit profile button
        Espresso.onView(ViewMatchers.withId(R.id.edit_profile_button))
                .perform(ViewActions.click());

        // Verify that the EditProfileActivity is launched
        Espresso.onView(ViewMatchers.withText("Edit Profile"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}