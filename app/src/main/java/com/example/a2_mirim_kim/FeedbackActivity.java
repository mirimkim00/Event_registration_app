package com.example.a2_mirim_kim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FeedbackActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RadioGroup feedbackRadioGroup;
    private ProgressBar feedbackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.feedback);

        feedbackRadioGroup = findViewById(R.id.feedbackRadioGroup);
        feedbackBar = findViewById(R.id.feedbackBar);

        feedbackRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.bad) {
                    feedbackBar.setProgress(20);
                } else if (checkedId == R.id.notBad) {
                    feedbackBar.setProgress(40);
                } else if (checkedId == R.id.good) {
                    feedbackBar.setProgress(60);
                } else if (checkedId == R.id.satisfied) {
                    feedbackBar.setProgress(80);
                } else if (checkedId == R.id.perfect) {
                    feedbackBar.setProgress(100);
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.feedback) {
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
                } else if (id == R.id.register) {
                    startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return true;
                }

                return false;
            }
        });
    }
}