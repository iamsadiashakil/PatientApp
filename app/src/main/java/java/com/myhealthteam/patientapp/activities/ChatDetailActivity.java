package java.com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.adapters.MessageAdapter;
import java.com.myhealthteam.patientapp.models.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends Activity {

    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;

    private TextView doctorNameTextView;
    private EditText inputMessageEditText;
    private ImageButton sendButton;

    private String doctorId;
    private String doctorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_view);
        doctorNameTextView = findViewById(R.id.doctor_name);
        inputMessageEditText = findViewById(R.id.input_message);
        sendButton = findViewById(R.id.send_button);

        // Get doctor details from intent
        doctorId = getIntent().getStringExtra("doctor_id");
        doctorName = getIntent().getStringExtra("doctor_name");

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press


        // Set doctor name in toolbar
        doctorNameTextView.setText(doctorName);

        // Initialize RecyclerView
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        // Load existing messages (mocked or fetched via API)
        loadMessages();

        // Handle send button click
        sendButton.setOnClickListener(v -> sendMessage());
    }

    private void loadMessages() {
        // Mock data: Replace with API call to fetch messages
        messageList.add(new Message("Hi, how can I help you?", "doctor", "10:30 AM"));
        messageList.add(new Message("I have a question about my prescription.", "user", "10:32 AM"));
        messageAdapter.notifyDataSetChanged();
    }

    private void sendMessage() {
        String messageText = inputMessageEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(messageText)) {
            // Add the user's message to the list
            messageList.add(new Message(messageText, "user", "Now"));
            messageAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(messageList.size() - 1);

            // Clear the input field
            inputMessageEditText.setText("");

            // Simulate a response from the doctor (for demo purposes)
            simulateDoctorResponse();
        }
    }

    private void simulateDoctorResponse() {
        recyclerView.postDelayed(() -> {
            messageList.add(new Message("Thank you for your question. Let me look into it.", "doctor", "Now"));
            messageAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(messageList.size() - 1);
        }, 2000); // 2-second delay for simulated response
    }
}
