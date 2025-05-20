package com.myhealthteam.patientapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myhealthteam.patientapp.R;
import com.myhealthteam.patientapp.adapters.ChatAdapter;
import com.myhealthteam.patientapp.models.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatScreenActivity extends Activity {

    private RecyclerView chatListRecyclerView;
    private FloatingActionButton fabNewChat;
    private ChatAdapter chatAdapter;
    private List<Chat> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        // Initialize views
        chatListRecyclerView = findViewById(R.id.chat_list);
        fabNewChat = findViewById(R.id.fab_new_chat);

        // Set up the top bar
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Close activity on back button press


        // Set up RecyclerView
        chatList = getChatList(); // Fetch chat list (mock or API call)
        chatAdapter = new ChatAdapter(chatList, this::openChat);
        chatListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatListRecyclerView.setAdapter(chatAdapter);

        // FAB click listener
        fabNewChat.setOnClickListener(v -> {
            // Open New Chat Screen
            Intent intent = new Intent(ChatScreenActivity.this, NewChatActivity.class);
            startActivity(intent);
        });
    }

    // Open chat with the selected doctor
    private void openChat(Chat chat) {
        Intent intent = new Intent(ChatScreenActivity.this, ChatDetailActivity.class);
        intent.putExtra("doctor_id", chat.getDoctorId());
        intent.putExtra("doctor_name", chat.getDoctorName());
        startActivity(intent);
    }

    // Mock data for chat list
    private List<Chat> getChatList() {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("1", "Dr. John Doe", "Hello, how can I help you?", "10:30 AM"));
        chats.add(new Chat("2", "Dr. Jane Smith", "Please take the prescribed medication.", "9:15 AM"));
        chats.add(new Chat("3", "Dr. Andrew Brown", "Your reports are ready.", "Yesterday"));
        return chats;
    }
}