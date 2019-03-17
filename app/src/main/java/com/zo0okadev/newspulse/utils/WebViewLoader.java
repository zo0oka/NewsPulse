package com.zo0okadev.newspulse.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewLoader {

    private WebView webView;

    public WebViewLoader(WebView webView) {
        this.webView = webView;
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void setSettings() {
        WebSettings settings = webView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultFontSize(18);
        settings.setSupportZoom(false);
        settings.setDomStorageEnabled(true);
        webView.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
    }

    public void loadHtmlData(String data) {
        webView.loadData("<style>img{display: block;margin-left: auto;margin-right: auto;height: auto;max-width: 100% }</style>"
                + data, "text/html", "UTF-8");
    }
}
