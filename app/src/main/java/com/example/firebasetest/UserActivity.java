package com.example.firebasetest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private ListView servicesListView;
    private Button bookServiceButton;
    private FirebaseFirestore db;
    private List<String> servicesList;
    private List<String> serviceIds;
    private ArrayAdapter<String> adapter;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        db = FirebaseFirestore.getInstance();
        servicesListView = findViewById(R.id.servicesListView);
        bookServiceButton = findViewById(R.id.bookServiceButton);
        servicesList = new ArrayList<>();
        serviceIds = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, servicesList);
        servicesListView.setAdapter(adapter);
    }
}
