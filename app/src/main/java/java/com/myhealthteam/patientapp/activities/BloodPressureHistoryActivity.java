package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.BloodPressureHistoryAdapter;
import java.com.myhealthteam.patientapp.models.BloodPressureRecord;

import java.util.ArrayList;
import java.util.List;

public class BloodPressureHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private BloodPressureHistoryAdapter adapter;
    private List<BloodPressureRecord> bloodPressureRecords;

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
        adapter = new BloodPressureHistoryAdapter(bloodPressureRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        bloodPressureRecords.add(new BloodPressureRecord("120/80 mmHg", "2025-04-29 10:30 AM", "Normal"));
        bloodPressureRecords.add(new BloodPressureRecord("140/90 mmHg", "2025-04-28 08:15 AM", "High"));
        bloodPressureRecords.add(new BloodPressureRecord("110/70 mmHg", "2025-04-27 09:45 PM", "Normal"));
        bloodPressureRecords.add(new BloodPressureRecord("150/95 mmHg", "2025-04-26 07:20 AM", "High"));
    }
}
