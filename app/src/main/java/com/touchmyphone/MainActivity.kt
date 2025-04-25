package com.touchmyphone

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val webView : WebView by lazy { findViewById(R.id.webview) }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // Go back in WebView history if possible
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        webView.getSettings().domStorageEnabled = true;

        val webSettings: WebSettings = webView.getSettings()
        webSettings.setJavaScriptEnabled(true)

        webView.loadUrl("https://preview--touch-phone-market-hub.lovable.app/")
//        webView.loadUrl("https://www.google.com")
    }
}