package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.VitalsHistoryAdapter;
import java.com.myhealthteam.patientapp.models.VitalsRecord;
import java.util.ArrayList;
import java.util.List;

public class SugarLevelHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<VitalsRecord> sugarLevelRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_level_history);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press

        // Setup RecyclerView
        recyclerView = findViewById(R.id.sugar_level_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        sugarLevelRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new VitalsHistoryAdapter(sugarLevelRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        sugarLevelRecords.add(new VitalsRecord("95 mg/dl", "2025-05-06 02:30 PM", "Normal"));
        sugarLevelRecords.add(new VitalsRecord("140 mg/dl", "2025-05-05 08:45 AM", "High"));
        sugarLevelRecords.add(new VitalsRecord("85 mg/dl", "2025-05-04 09:15 AM", "Normal"));
        sugarLevelRecords.add(new VitalsRecord("150 mg/dl", "2025-05-03 07:45 PM", "High"));
    }
}