package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;

import java.com.myhealthteam.patientapp.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private TextView logTextView; // Log TextView to display messages
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        logTextView = findViewById(R.id.logTextView);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input
                if (username.isEmpty() || password.isEmpty()) {
                    logTextView.setText("Error: Username or Password cannot be empty.");
                } else if (username.equals("admin") && password.equals("password")) { // Dummy credentials
                    logTextView.setText("Login Successful!");
                    Toast.makeText(LoginActivity.this, "Welcome " + username, Toast.LENGTH_SHORT).show();

                    // Navigate to DashboardActivity
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish(); // Close LoginActivity
                } else {
                    logTextView.setText("Error: Invalid Username or Password.");
                }
            }
        });
    }
}
