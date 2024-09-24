package com.example.arcadezone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int progress;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBarId);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                navigateToNextPage();
            }
        });
        thread.start();

    }
    public void doWork() {
        for (progress = 20; progress <= 100; progress = progress + 20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void navigateToNextPage() {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(intent);
        finish();  // Optional: Call finish() to close the current activity
    }
}