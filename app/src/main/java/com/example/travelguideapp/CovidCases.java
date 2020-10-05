package com.example.travelguideapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class CovidCases extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_cases);
        webView = (WebView) findViewById(R.id.webView);          // casting is not required in nowdays in android
        Intent intent = getIntent();
        try {
            String str = intent.getStringExtra("url");
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(str);
        }
        catch(NullPointerException exp){
            Toast.makeText(this, "Oops...something went wrong with this URL", Toast.LENGTH_LONG).show();
        }
    }
}