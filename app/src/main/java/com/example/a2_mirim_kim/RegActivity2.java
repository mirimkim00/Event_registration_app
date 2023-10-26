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

public class RegActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private EditText leaderName;
    private EditText numOfMembers;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg2);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.register);

        leaderName = findViewById(R.id.leaderName);
        numOfMembers = findViewById(R.id.numOfMembers);
        btnSubmit = findViewById(R.id.btnSubmit);

        Bundle b = getIntent().getExtras();
        String teamName = b.getString("teamName_key");
        String teamDesc = b.getString("teamDesc_key");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String leaderNameInput = leaderName.getText().toString();
                String numOfMembersInput = numOfMembers.getText().toString();

                Intent intent = new Intent(RegActivity2.this, RegActivity3.class);
                intent.putExtra("teamName_key", teamName);
                intent.putExtra("teamDesc_key", teamDesc);
                intent.putExtra("leaderName_key", leaderNameInput);
                intent.putExtra("numOfMembers_key", numOfMembersInput);

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

    public void goToReg3(View view) {
        Intent intent = new Intent(this, RegActivity3.class);
        startActivity(intent);
        finish();
    }
}