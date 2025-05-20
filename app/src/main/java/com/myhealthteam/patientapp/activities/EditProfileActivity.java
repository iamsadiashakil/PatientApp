package com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myhealthteam.patientapp.R;

public class EditProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ImageView backButton = findViewById(R.id.back_button);
        ImageView profilePicture = findViewById(R.id.profile_picture);
        TextView changePicture = findViewById(R.id.change_picture);
        EditText fullName = findViewById(R.id.full_name);
        EditText email = findViewById(R.id.email);
        EditText phoneNumber = findViewById(R.id.phone_number);
        EditText dob = findViewById(R.id.dob);
        Button saveChangesButton = findViewById(R.id.save_changes_button);

        // Mock existing user data (replace with actual user data retrieval logic)
        fullName.setText("Emma Johnson");
        email.setText("emma.jm@example.com");
        phoneNumber.setText("+1234567890");
        dob.setText("12/01/1994");

        // Change profile picture action
        changePicture.setOnClickListener(v -> {
            // Add logic to change the profile picture
            Toast.makeText(this, "Change Profile Picture clicked!", Toast.LENGTH_SHORT).show();
        });

        Spinner relationshipSpinner = findViewById(R.id.relationship_spinner);

        // Define the relationship options
        String[] relationships = {"Parent", "Guardian", "Sibling", "Friend", "Other"};

        // Create an ArrayAdapter for the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, relationships);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the Spinner
        relationshipSpinner.setAdapter(adapter);

        // Set default selection to "Sibling"
        int siblingIndex = adapter.getPosition("Sibling");
        if (siblingIndex >= 0) {
            relationshipSpinner.setSelection(siblingIndex);
        }

        // Save changes action
        saveChangesButton.setOnClickListener(v -> {
            String updatedName = fullName.getText().toString().trim();
            String updatedEmail = email.getText().toString().trim();
            String updatedPhone = phoneNumber.getText().toString().trim();
            String updatedDob = dob.getText().toString().trim();
            String updatedRelationship = relationshipSpinner.getSelectedItem().toString().trim();

            // Validate the input fields
            if (updatedName.isEmpty() || updatedEmail.isEmpty() || updatedPhone.isEmpty() || updatedDob.isEmpty() || updatedRelationship.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Add logic to save updated profile data (e.g., update database or API call)
            Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
            // Navigate to ProfileDetailsActivity
            Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close EditProfileActivity
        });

        backButton.setOnClickListener(v -> {
            // Close the Edit Profile activity and go back
            finish();
        });
    }
}
