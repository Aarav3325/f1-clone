package com.aarav.f1clone.ui.home;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.aarav.f1clone.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );

        String url = getIntent().getStringExtra("url");
        String topStoriesUrl = getIntent().getStringExtra("topStoriesUrl");

        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByTagName('header')[0].style.display='none';" +
                        "document.getElementsByTagName('footer')[0].style.display='none';" +
                        "document.getElementsByClassName('message type-modal')[0].style.display='none';" +
                        "})()");
            }
        });

        if (url != null) {
            webView.loadUrl(url);
        } else if (topStoriesUrl != null) {
            webView.loadUrl(topStoriesUrl);
        }


    }
}