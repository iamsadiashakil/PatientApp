package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.VitalsHistoryAdapter;
import java.com.myhealthteam.patientapp.models.VitalsRecord;
import java.util.ArrayList;
import java.util.List;

public class BodyTemperatureHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<VitalsRecord> bodyTemperatureRecords;

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
        bodyTemperatureRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new VitalsHistoryAdapter(bodyTemperatureRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        bodyTemperatureRecords.add(new VitalsRecord("98.6°F", "2025-05-08 08:22 AM", "Normal"));
        bodyTemperatureRecords.add(new VitalsRecord("101.5°F", "2025-05-07 10:00 PM", "Fever"));
        bodyTemperatureRecords.add(new VitalsRecord("97.8°F", "2025-05-06 07:45 AM", "Normal"));
        bodyTemperatureRecords.add(new VitalsRecord("102.3°F", "2025-05-05 05:30 PM", "Fever"));

    }
}
