package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.com.myhealthteam.patientapp.R;

public class DashboardActivity extends Activity {

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

        // Sample Data: You can fetch real data later from API or database
        bloodPressureReading.setText("118/79 mmHg");
        pulseRateReading.setText("72 bpm");
        sugarLevelReading.setText("95 mg/dL");
        bodyTempReading.setText("98.4 °F");
        oxygenLevelReading.setText("97 %");
        allergiesReading.setText("Peanut");

        // Click listeners
        // Handle profile icon click
        profileIcon.setOnClickListener(v -> {
            // Navigate to ProfileDetailsActivity
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        cardBloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, BloodPressureHistoryActivity.class));
            }
        });

        cardPulseRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, PulseRateHistoryActivity.class));
            }
        });

        cardAllergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, AllergyHistoryActivity.class));
            }
        });

        cardOxygenLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, BloodOxygenHistoryActivity.class));
            }
        });

        cardBodyTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, BodyTemperatureHistoryActivity.class));
            }
        });

        cardSugarLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SugarLevelHistoryActivity.class));
            }
        });

        fabChat.setOnClickListener(view -> {
            // Navigate to the ChatActivity
            Intent intent = new Intent(DashboardActivity.this, ChatScreenActivity.class);
            startActivity(intent);
        });
    }
}
