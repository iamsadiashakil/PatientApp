package com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.myhealthteam.patientapp.R;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.myhealthteam.patientapp.models.AuthRequest;
import com.myhealthteam.patientapp.models.AuthResponse;
import com.myhealthteam.patientapp.network.ApiService;
import com.myhealthteam.patientapp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    private ApiService apiService;
    private SharedPreferences sharedPreferences;

    private TextView logTextView, forgotPassword, createAccount;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyHealthAppPrefs", Context.MODE_PRIVATE);

        // Initialize views
        logTextView = findViewById(R.id.logTextView);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password);
        createAccount = findViewById(R.id.create_account);

        // Get API instance from RetrofitClient
        apiService = RetrofitClient.getInstance();

        /*// Check if user is already logged in
        if (sharedPreferences.contains("auth_token")) {
            navigateToDashboard();
            return;
        }*/


        // Set click listener for login button
        loginButton.setOnClickListener(v -> loginUser());

        forgotPassword.setOnClickListener(v -> {
            // Navigate to Forgot Password Activity
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        createAccount.setOnClickListener(v -> {
            // Navigate to Create Account Activity
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Error: Username or Password cannot be empty.", android.R.color.holo_red_dark);
            return;
        }

        AuthRequest request = AuthRequest.builder()
                .email(username)
                .password(password)
                .build();
        apiService.login(request).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Save token & username
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("auth_token", response.body().getJwt());
                    editor.putString("username", username);
                    editor.apply();

                    showMessage("Login Successful!", android.R.color.holo_green_dark);
                    Toast.makeText(LoginActivity.this, "Welcome " + username, Toast.LENGTH_SHORT).show();

                    navigateToDashboard();
                } else {
                    showMessage("Error: Invalid Username or Password.", android.R.color.holo_red_dark);
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                showMessage("Network error. Please try again.", android.R.color.holo_red_dark);
            }
        });
    }

    private void navigateToDashboard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void showMessage(String message, int color) {
        logTextView.setText(message);
        logTextView.setTextColor(ContextCompat.getColor(this, color));
    }
}

