package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.com.myhealthteam.patientapp.R;

public class ProfileDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        // Back button functionality
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close current activity to go back

        // Logout button functionality
        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(v -> {
            // Handle logout logic here (e.g., clear session, navigate to login screen)
            Intent intent = new Intent(ProfileDetailsActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear activity stack
            startActivity(intent);
            finish();
        });

        ImageView editButton = findViewById(R.id.edit_profile_button);
        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileDetailsActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }
}
