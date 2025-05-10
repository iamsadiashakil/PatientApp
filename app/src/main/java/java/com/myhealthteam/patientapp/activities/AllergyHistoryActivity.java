package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.AllergyHistoryAdapter;
import java.com.myhealthteam.patientapp.models.AllergyRecord;

import java.util.ArrayList;
import java.util.List;

public class AllergyHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private AllergyHistoryAdapter adapter;
    private List<AllergyRecord> allergyRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_history);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press

        // Setup RecyclerView
        recyclerView = findViewById(R.id.allergy_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        allergyRecords = new ArrayList<>();
        populateDummyData(); // Replace with actual data from a database or API

        // Set up adapter
        adapter = new AllergyHistoryAdapter(allergyRecords);
        recyclerView.setAdapter(adapter);
    }

    private void populateDummyData() {
        allergyRecords.add(new AllergyRecord("Penicillin", "Drug", "Severe", "Anaphylaxis", "Mar 12, 2022"));
        allergyRecords.add(new AllergyRecord("Pollen (Seasonal)", "Environmental", "Moderate", "Sneezing, Watery Eyes", "Apr 02, 2023"));
        allergyRecords.add(new AllergyRecord("Peanuts", "Food", "Severe", "Swelling, Hives", "Jun 20, 2021"));
    }
}