package com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myhealthteam.patientapp.R;
import com.myhealthteam.patientapp.adapters.VitalsHistoryAdapter;
import com.myhealthteam.patientapp.models.VitalsRecord;

import java.util.ArrayList;
import java.util.List;

public class BloodPressureHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<VitalsRecord> bloodPressureRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_history);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press

        // Setup RecyclerView
        recyclerView = findViewById(R.id.blood_pressure_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        bloodPressureRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new VitalsHistoryAdapter(bloodPressureRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        bloodPressureRecords.add(new VitalsRecord("120/80 mmHg", "2025-04-29 10:30 AM", "Normal"));
        bloodPressureRecords.add(new VitalsRecord("140/90 mmHg", "2025-04-28 08:15 AM", "High"));
        bloodPressureRecords.add(new VitalsRecord("110/70 mmHg", "2025-04-27 09:45 PM", "Normal"));
        bloodPressureRecords.add(new VitalsRecord("150/95 mmHg", "2025-04-26 07:20 AM", "High"));
    }
}
