package com.example.ex1_td1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<School> mSchoolList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private SchoolListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            mSchoolList.addLast(new School("enetcom" + i, "école d'ing" );     // Get a handle to the RecyclerView.
            mRecyclerView = findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
            mAdapter = new SchoolListAdapter(this, mSchoolList);
// Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        }


    }
}

