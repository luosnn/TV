package com.luosnn.tv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 罗什什 on 2017/11/28.
 */

public class TV extends Activity {
    WebView webView;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tv);
        webView = findViewById(R.id.wv);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setPluginState(WebSettings.PluginState.ON);
        ws.setDomStorageEnabled(true);
        ws.setSupportMultipleWindows(true);// 新加
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.loadUrl(url);
    }
}
