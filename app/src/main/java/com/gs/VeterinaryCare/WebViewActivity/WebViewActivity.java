package com.gs.VeterinaryCare.WebViewActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.WindowCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.databinding.WebViewActivityBinding;


public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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