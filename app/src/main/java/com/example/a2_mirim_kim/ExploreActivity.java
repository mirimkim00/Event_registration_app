package com.example.a2_mirim_kim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ExploreActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private Switch eventSwitch;
    private LinearLayout eventsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.explore);

        eventSwitch = findViewById(R.id.eventSwitch);
        eventsLayout = findViewById(R.id.events);

        eventSwitch.setChecked(true);
        eventSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    eventsLayout.setVisibility(View.VISIBLE);
                } else {
                    eventsLayout.setVisibility(View.GONE);
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.explore) {
                    return true;
                } else if (id == R.id.home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return true;
                } else if (id == R.id.register) {
                    startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
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