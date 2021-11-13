package com.gs.VeterinaryCare.WebViewActivity;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.gs.VeterinaryCare.R;


public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.web_view_activity);
        webView = findViewById(R.id.webView);
        webView.loadUrl(getIntent().getStringExtra("PageURL"));

    }
}