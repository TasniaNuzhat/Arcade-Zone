package com.example.arcadezone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button showButton,timeSet;
    private RadioButton personsButton;
    private TextView resultTextView;
    private Switch foodSwitch;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        radioGroup = findViewById(R.id.radioGroupId);
        showButton = findViewById(R.id.showbuttonId);
        resultTextView = findViewById(R.id.resultTextViewId);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        foodSwitch = findViewById(R.id.foodSwitch);
        timeSet = findViewById(R.id.timeSet);


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateSelections()) {
                    String players = getTotalPlayers();
                    String gameList = getTotalGames();
                    String switchMsg = foodSwitch.isChecked() ? "Includes food and beverages." : "No food and beverages selected.";
                    String result = "Players:" + players + "\nGames: " + gameList + "\n" + switchMsg;
                    resultTextView.setText(result);
                }
            }
        });
        timeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateSelections()) {
                    Intent intent = new Intent(DetailsActivity.this, TimeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


            private boolean validateSelections() {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(DetailsActivity.this, "Please select the number of players.", Toast.LENGTH_SHORT).show();
                    return false;
                }

                List<String> games = new ArrayList<>();
                if (checkBox1.isChecked()) {
                    games.add(checkBox1.getText().toString());
                }

                if (checkBox2.isChecked()) {
                    games.add(checkBox2.getText().toString());
                }
                if (checkBox3.isChecked()) {
                    games.add(checkBox3.getText().toString());
                }
                if (checkBox4.isChecked()) {
                    games.add(checkBox4.getText().toString());
                }
                if (games.isEmpty()) {
                    Toast.makeText(DetailsActivity.this, "Please select at least one game.", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
            private String getTotalPlayers() {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                personsButton = findViewById(selectedId);
                return personsButton.getText().toString();
            }

                private String getTotalGames(){
                    List<String> games = new ArrayList<>();
                    if (checkBox1.isChecked()) {
                        games.add(checkBox1.getText().toString());
                    }

                    if (checkBox2.isChecked()) {
                        games.add(checkBox2.getText().toString());
                    }
                    if (checkBox3.isChecked()) {
                        games.add(checkBox3.getText().toString());
                    }
                    if (checkBox4.isChecked()) {
                        games.add(checkBox4.getText().toString());
                    }
                    return String.join(",",games);
    }
}