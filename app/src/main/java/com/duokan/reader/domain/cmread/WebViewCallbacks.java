package com.duokan.reader.domain.cmread;

import android.graphics.Bitmap;
import android.webkit.WebView;

public interface WebViewCallbacks {
    void doUpdateVisitedHistory(WebView webView, String str, boolean z);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);
}
