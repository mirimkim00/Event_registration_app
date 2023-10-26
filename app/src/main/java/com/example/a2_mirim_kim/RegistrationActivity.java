package com.example.a2_mirim_kim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RegistrationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private EditText teamName;
    private EditText teamDesc;
    private Button btnNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.register);

        teamName = findViewById(R.id.teamName);
        teamDesc = findViewById(R.id.teamDesc);
        btnNext1 = findViewById(R.id.btnNext1);

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teamNameInput = teamName.getText().toString();
                String teamDescInput = teamDesc.getText().toString();

                Intent intent = new Intent(RegistrationActivity.this, RegActivity2.class);
                intent.putExtra("teamName_key", teamNameInput);
                intent.putExtra("teamDesc_key", teamDescInput);
                startActivity(intent);

            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.register) {
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
    public void goToReg2(View view) {
        Intent intent = new Intent(this, RegActivity2.class);
        startActivity(intent);
    }
}