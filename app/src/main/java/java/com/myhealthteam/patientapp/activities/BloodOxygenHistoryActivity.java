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

public class BloodOxygenHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<VitalsRecord> bloodOxygenRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_oxygen_history);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press

        // Setup RecyclerView
        recyclerView = findViewById(R.id.blood_oxygen_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        bloodOxygenRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new VitalsHistoryAdapter(bloodOxygenRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        bloodOxygenRecords.add(new VitalsRecord("97%", "2025-05-07 09:00 AM", "Normal"));
        bloodOxygenRecords.add(new VitalsRecord("92%", "2025-05-06 06:30 PM", "Low"));
        bloodOxygenRecords.add(new VitalsRecord("98%", "2025-05-05 03:15 PM", "Normal"));
        bloodOxygenRecords.add(new VitalsRecord("89%", "2025-05-04 10:45 AM", "Low"));
    }
}
