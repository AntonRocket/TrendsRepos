package com.example.trendrepositories.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.trendrepositories.R

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val arguments = intent.extras
        webView = findViewById(R.id.webView)
        if (arguments != null) {
            webView.loadUrl(arguments.getString("url").toString())
        }
    }
}