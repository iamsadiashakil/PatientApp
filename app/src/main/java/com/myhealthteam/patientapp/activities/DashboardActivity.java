package com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myhealthteam.patientapp.R;
import com.myhealthteam.patientapp.models.AllergyDto;
import com.myhealthteam.patientapp.models.VitalDto;
import com.myhealthteam.patientapp.models.VitalsSummaryDto;
import com.myhealthteam.patientapp.network.ApiService;
import com.myhealthteam.patientapp.network.RetrofitClient;
import com.myhealthteam.patientapp.utils.MockDataGenerator;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends Activity {

    private ApiService apiService;
    private SharedPreferences prefs;
    private String authToken;
    private CardView cardBloodPressure, cardPulseRate, cardSugarLevel;
    private CardView cardBodyTemp, cardOxygenLevel, cardAllergies;
    private TextView bloodPressureReading, pulseRateReading, sugarLevelReading;
    private TextView bodyTempReading, oxygenLevelReading, allergiesReading;
    private ImageView profileIcon;
    FloatingActionButton fabChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        prefs = getSharedPreferences("MyHealthAppPrefs", Context.MODE_PRIVATE);
        authToken = "Bearer " + prefs.getString("auth_token", "");

        cardBloodPressure = findViewById(R.id.cardBloodPressure);
        cardPulseRate = findViewById(R.id.cardPulseRate);
        cardSugarLevel = findViewById(R.id.cardSugarLevel);
        cardBodyTemp = findViewById(R.id.cardBodyTemperature);
        cardOxygenLevel = findViewById(R.id.cardBloodOxygen);
        cardAllergies = findViewById(R.id.cardAllergies);

        bloodPressureReading = findViewById(R.id.bloodPressureReading);
        pulseRateReading = findViewById(R.id.pulseReading);
        sugarLevelReading = findViewById(R.id.sugarLevelReading);
        bodyTempReading = findViewById(R.id.bodyTemperatureReading);
        oxygenLevelReading = findViewById(R.id.bloodOxygenReading);
        allergiesReading = findViewById(R.id.allergyValue);

        profileIcon = findViewById(R.id.profile_icon);

        fabChat = findViewById(R.id.fab_chat);

        // Get API instance from RetrofitClient
        apiService = RetrofitClient.getInstance();

        loadVitalsSummary();
        loadAllergies();

        // Click listeners
        // Handle profile icon click
        profileIcon.setOnClickListener(v -> {
            // Navigate to ProfileDetailsActivity
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        cardBloodPressure.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, BloodPressureHistoryActivity.class)));

        cardPulseRate.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, PulseRateHistoryActivity.class)));

        cardAllergies.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, AllergyHistoryActivity.class)));

        cardOxygenLevel.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, BloodOxygenHistoryActivity.class)));

        cardBodyTemp.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, BodyTemperatureHistoryActivity.class)));

        cardSugarLevel.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, SugarLevelHistoryActivity.class)));

        fabChat.setOnClickListener(view -> {
            // Navigate to the ChatActivity
            Intent intent = new Intent(DashboardActivity.this, ChatScreenActivity.class);
            startActivity(intent);
        });
    }

    private void loadVitalsSummary() {
        apiService.getVitalsSummary(authToken).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<VitalsSummaryDto> call, Response<VitalsSummaryDto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    VitalsSummaryDto vitals = response.body();
                    updateVitalsUI(vitals);
                } else {
                    showMockVitals(Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<VitalsSummaryDto> call, Throwable t) {
                showMockVitals(Toast.LENGTH_SHORT);
            }
        });
    }

    private void showMockVitals(int lengthLong) {
        Toast.makeText(DashboardActivity.this, "Showing mock vitals - connection issue", lengthLong).show();
        VitalsSummaryDto vitalsMockData = MockDataGenerator.getVitalsMockData();
        updateVitalsUI(vitalsMockData);
    }

    private void updateVitalsUI(VitalsSummaryDto vitals) {
        VitalDto bloodPressure = vitals.getLatestReadings().get("Blood Pressure");
        bloodPressureReading.setText(bloodPressure.getReading());
        VitalDto pulseRate = vitals.getLatestReadings().get("Pulse Rate");
        pulseRateReading.setText(pulseRate.getReading());
        VitalDto sugarLevel = vitals.getLatestReadings().get("Sugar Level");
        sugarLevelReading.setText(sugarLevel.getReading());
        VitalDto bodyTemperature = vitals.getLatestReadings().get("Body Temperature");
        bodyTempReading.setText(bodyTemperature.getReading());
        VitalDto bloodOxygen = vitals.getLatestReadings().get("Blood Oxygen");
        oxygenLevelReading.setText(bloodOxygen.getReading());
    }

    private void loadAllergies() {
        apiService.getAllergies(authToken).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<AllergyDto>> call, Response<List<AllergyDto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AllergyDto> allergies = response.body();
                    AllergyDto allergy = allergies.stream().max(Comparator.comparing(AllergyDto::getNotedOn)).get();
                    allergiesReading.setText(allergy.getName());
                } else {
                    showMockAllergy(Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<List<AllergyDto>> call, Throwable t) {
                showMockAllergy(Toast.LENGTH_SHORT);
            }
        });
    }

    private void showMockAllergy(int lengthLong) {
        Toast.makeText(DashboardActivity.this, "Showing mock allergy - connection issue", lengthLong).show();
        List<AllergyDto> allergies = MockDataGenerator.getAllergyMockData();
        AllergyDto allergy = allergies.stream().max(Comparator.comparing(AllergyDto::getNotedOn)).get();
        allergiesReading.setText(allergy.getName());
    }

}
