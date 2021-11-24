package com.gs.VeterinaryCare.WebViewActivity;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.databinding.WebViewActivityBinding;


public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.setDecorFitsSystemWindows(getWindow(),false);
        WebViewActivityBinding binding = WebViewActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar materialToolbar = binding.topAppToolBar;
        setSupportActionBar(materialToolbar);

        materialToolbar.setTitle(getIntent().getStringExtra("AnimalName"));

        webView = binding.webView;
        webView.loadUrl(getIntent().getStringExtra("PageURL"));

    }
}