package com.example.a2_mirim_kim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RegActivity3 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg3);

        TextView teamName = findViewById(R.id.teamName);
        TextView teamDesc = findViewById(R.id.teamDesc);
        TextView leaderName = findViewById(R.id.leaderName);
        TextView numOfMembers = findViewById(R.id.numOfMembers);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.register);

        Intent intent = getIntent();
        if (intent != null) {
            String teamNameValue = intent.getStringExtra("teamName_key");
            String teamDescValue = intent.getStringExtra("teamDesc_key");
            String leaderNameValue = intent.getStringExtra("leaderName_key");
            String numOfMembersValue = intent.getStringExtra("numOfMembers_key");

            if (teamNameValue != null) {
                teamName.setText("Team Name is: " + teamNameValue);
            }
            if (teamDescValue != null) {
                teamDesc.setText("Team Description is: " + teamDescValue);
            }
            if (leaderNameValue != null) {
                leaderName.setText("Team Leader Name is: " + leaderNameValue);
            }
            if (numOfMembersValue != null) {
                numOfMembers.setText("The number of members is: " + numOfMembersValue);
            }
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override 
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.register) {
                    return true;
                } else if (id == R.id.home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return true;
                } else if (id == R.id.explore) {
                    startActivity(new Intent(getApplicationContext(), ExploreActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return true;
                } else if (id == R.id.feedback) {
                    startActivity(new Intent(getApplicationContext(), FeedbackActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return true;
                }

                return false;
            }
        });
    }
}