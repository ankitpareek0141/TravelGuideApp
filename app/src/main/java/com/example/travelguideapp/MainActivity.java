package com.example.travelguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button seeAllCountries, wantToVisit, alreadyVisit, about;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        seeAllCountries.setOnClickListener(new View.OnClickListener() {                               // seeAllCountries button
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, AllCountries.class);
                startActivity(intent);
            }
        });

        wantToVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, WantToVisit.class);
                startActivity(intent);
            }
        });

        alreadyVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, AlreadyVisited.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("This is just an Travel App where you can\nmanage your country visitig plans\nWant to check out COVID-19 cases in India ?");
                builder.setTitle("About this App");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, CovidCases.class);
                        intent.putExtra("url", "https://www.mygov.in/covid-19");
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });
    }

    private void initWidget() {
        seeAllCountries = findViewById(R.id.seeAllCountries);
        wantToVisit = findViewById(R.id.wantToVisit);
        alreadyVisit = findViewById(R.id.alreadyVisit);
        about = findViewById(R.id.about);
    }
}