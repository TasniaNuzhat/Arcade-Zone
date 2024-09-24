package com.example.arcadezone;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimeActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView tvSeekBar,tvRatingBar,rate;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        seekBar=findViewById(R.id.seekBar);
        tvSeekBar=findViewById(R.id.tv_seekbar);
        tvRatingBar=findViewById(R.id.ratingBarTitle);
        ratingBar=findViewById(R.id.ratingBar);
        rate=findViewById(R.id.tv_ratingBar);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekBar.setText("Selected: " + progress + " mins");
                Log.d("SeekBarProgress", "Progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               rate.setText("Rating: " + rating);
                Toast.makeText(TimeActivity.this, "You rated: " + rating, Toast.LENGTH_SHORT).show();
            }
        });


        }
    }
