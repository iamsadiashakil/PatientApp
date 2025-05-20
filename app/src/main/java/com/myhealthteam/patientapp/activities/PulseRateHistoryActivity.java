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

public class PulseRateHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<VitalsRecord> pulseRateRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse_rate_history);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press

        // Setup RecyclerView
        recyclerView = findViewById(R.id.pulse_rate_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        pulseRateRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new VitalsHistoryAdapter(pulseRateRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        pulseRateRecords.add(new VitalsRecord("76 bpm", "2025-05-05 11:00 AM", "Normal"));
        pulseRateRecords.add(new VitalsRecord("92 bpm", "2025-05-04 02:30 PM", "High"));
        pulseRateRecords.add(new VitalsRecord("68 bpm", "2025-05-03 08:45 PM", "Normal"));
        pulseRateRecords.add(new VitalsRecord("100 bpm", "2025-05-02 07:15 AM", "High"));
    }
}