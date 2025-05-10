package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.DoctorDirectoryAdapter;
import java.com.myhealthteam.patientapp.models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class NewChatActivity extends Activity {
    private ImageView backButton;
    private EditText searchDoctor;
    private RecyclerView doctorList;
    private DoctorDirectoryAdapter doctorDirectoryAdapter;
    private List<Doctor> doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat);

        // Initialize UI components
        backButton = findViewById(R.id.back_button);
        searchDoctor = findViewById(R.id.search_doctor);
        doctorList = findViewById(R.id.new_doctor_list);

        backButton.setOnClickListener(v -> finish());

        // Mock doctor data (replace with actual data from your database or API)
        doctors = new ArrayList<>();
        doctors.add(new Doctor("1", "K. Johnson") );
        doctors.add(new Doctor("2", "Jane Smith") );
        doctors.add(new Doctor("3", "Alice") );
        doctors.add(new Doctor("4", "Bob") );

        // Set up RecyclerView
        doctorDirectoryAdapter = new DoctorDirectoryAdapter(doctors, this::startChatWithDoctor);
        doctorList.setLayoutManager(new LinearLayoutManager(this));
        doctorList.setAdapter(doctorDirectoryAdapter);

        // Search functionality
        searchDoctor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterDoctors(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterDoctors(String query) {
        List<Doctor> filteredDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorName().toLowerCase().contains(query.toLowerCase())) {
                filteredDoctors.add(doctor);
            }
        }
        doctorDirectoryAdapter.updateList(filteredDoctors);
    }

    private void startChatWithDoctor(Doctor doctor) {
        // Handle starting a new chat with the selected doctor
        Toast.makeText(this, "Starting chat with " + doctor, Toast.LENGTH_SHORT).show();

        // Example: Navigate to ChatDetailActivity
        Intent intent = new Intent(NewChatActivity.this, ChatDetailActivity.class);
        intent.putExtra("doctor_id", doctor.getDoctorId());
        intent.putExtra("doctor_name", doctor.getDoctorName());
        startActivity(intent);
    }
}
