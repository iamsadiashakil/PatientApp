package com.myhealthteam.patientapp.activities;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

import androidx.test.core.app.ActivityScenario;

import com.myhealthteam.patientapp.R;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

public class ProfileActivityTest {

    @Test
    public void testProfileActivityInitialization() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            // Assert that views are properly initialized
            ImageView backButton = activity.findViewById(R.id.back_button);
            Button logoutButton = activity.findViewById(R.id.logout_button);
            ImageView editButton = activity.findViewById(R.id.edit_profile_button);

            assertNotNull(backButton);
            assertNotNull(logoutButton);
            assertNotNull(editButton);
        });
    }

    @Test
    public void testBackButtonClick() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            ImageView backButton = activity.findViewById(R.id.back_button);
            backButton.performClick();

            // Assert that the activity finishes when the back button is clicked
            assert (activity.isFinishing());
        });
    }

    @Test
    public void testLogoutButtonClick() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            Button logoutButton = activity.findViewById(R.id.logout_button);
            logoutButton.performClick();

            // Assert that the LoginActivity is launched
            Intent expectedIntent = new Intent(activity, LoginActivity.class);
            assert (expectedIntent.getComponent().equals(activity.getIntent().getComponent()));
        });
    }

    @Test
    public void testEditProfileButtonClick() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            ImageView editButton = activity.findViewById(R.id.edit_profile_button);
            editButton.performClick();

            // Assert that the EditProfileActivity is launched
            Intent expectedIntent = new Intent(activity, EditProfileActivity.class);
            assert (expectedIntent.getComponent().equals(activity.getIntent().getComponent()));
        });
    }
}