package com.example.travelguideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {


    private ImageView image;
    private Util util;
    private static final String TAG = "CountryActivity";
    private TextView name, capital, gdp, population;
    private ArrayList<Country> list, wantlist, alreadyVisitedlist;
    private Button btnwantVisit, btnalreadyVisited;
    private Country country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        Log.d(TAG, "onCreate: called");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidget();
        Intent intent = getIntent();
        util = new Util();
        list = Util.getAllCoutries();
        int id = intent.getIntExtra("countryID",0);
        for(Country cc : list){
             if(id == cc.getCountryId()){
                 country = cc;
                 name.setText(cc.getName());
                 capital.setText(cc.getCapital());
                 gdp.setText(cc.getGDP());
                 population.setText(""+cc.getPopulation());
                 Glide.with(this)
                         .asBitmap()
                         .load(cc.getImageurl())
                         .into(image);
             }
        }

        btnwantVisit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnwantVisit() called");
                btnwantVisitTapped();
            }
        });

        btnalreadyVisited.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnAlreadyVisited() called");
                btnalreadyVisitedTapped();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnalreadyVisitedTapped(){
        Log.d(TAG, "btnAlreadyVisitedTapped() called");
        alreadyVisitedlist = Util.getAlreadyVisited();
        if(!alreadyVisitedlist.contains(country)){
            alreadyVisitedlist.add(country);
            Toast.makeText(CountryActivity.this, "Country has been added to 'Already visited' list", Toast.LENGTH_SHORT).show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(CountryActivity.this);
            builder.setMessage("You have already added this country to the 'Already Visited' list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        Util.setAlreadyVisited(alreadyVisitedlist);
    }
    
    public void btnwantVisitTapped(){
        Log.d(TAG, "btnwantVisitTapped: called");
        wantlist = Util.getWantToVisit();
        if(!wantlist.contains(country)){
            alreadyVisitedlist = util.getAlreadyVisited();
            if(alreadyVisitedlist.contains(country)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CountryActivity.this);
                    builder.setMessage("You have already visited this country\nDo you want to visit again ?");
                    builder.setTitle("Warning!");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.removeAlredyVisited(country);
                            wantlist.add(country);
                            Toast.makeText(CountryActivity.this, "Country added successfully to the 'want to list'", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.create().show();
                }
            else {
                wantlist.add(country);
                Toast.makeText(this, "Country added successfully to the 'want to list'", Toast.LENGTH_SHORT).show();
            }
        }
        else{
                AlertDialog.Builder builder = new AlertDialog.Builder(CountryActivity.this);
                builder.setMessage("You have already added this country to the 'Want to visit' list");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
        }
        Util.setWantToVisit(wantlist);
    }

    public void initWidget(){
        Log.d(TAG, "initWidget: called");
        name = findViewById(R.id.countryName);
        capital = findViewById(R.id.capital);
        gdp = findViewById(R.id.gdp);
        population = findViewById(R.id.population);
        image = findViewById(R.id.countryImage);
        btnalreadyVisited = findViewById(R.id.alreadyVisited);
        btnwantVisit = findViewById(R.id.wantVisit);
    }
}