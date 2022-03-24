package com.gs.VeterinaryCare.Activities;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.databinding.WebViewActivityBinding;


public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebViewActivityBinding binding = WebViewActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar materialToolbar = binding.topAppToolBar;
        setSupportActionBar(materialToolbar);
        materialToolbar.setTitle(getIntent().getStringExtra("AnimalName"));

        webView = binding.webView;
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getStringExtra("PageURL");
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+url);

        materialToolbar.setNavigationOnClickListener(view -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();
        webView.reload();
    }
}