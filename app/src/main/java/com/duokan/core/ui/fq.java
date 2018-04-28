package com.duokan.core.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;

public class fq {
    private final WebViewClient mDefault = new WebViewClient();

    public boolean shouldOverrideUrlLoading(fr frVar, String str) {
        return false;
    }

    public void onPageStarted(fr frVar, String str, Bitmap bitmap) {
    }

    public void onPageFinished(fr frVar, String str) {
    }

    public void onLoadResource(fr frVar, String str) {
    }

    public WebResourceResponse shouldInterceptRequest(fr frVar, String str) {
        return null;
    }

    public void onReceivedError(fr frVar, int i, String str, String str2) {
    }

    public void onFormResubmission(fr frVar, Message message, Message message2) {
        this.mDefault.onFormResubmission(frVar.f1261a, message, message2);
    }

    public void doUpdateVisitedHistory(fr frVar, String str, boolean z) {
    }

    public void onReceivedSslError(fr frVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.mDefault.onReceivedSslError(frVar.f1261a, sslErrorHandler, sslError);
    }

    public void onReceivedHttpAuthRequest(fr frVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mDefault.onReceivedHttpAuthRequest(frVar.f1261a, httpAuthHandler, str, str2);
    }

    public boolean shouldOverrideKeyEvent(fr frVar, KeyEvent keyEvent) {
        return false;
    }

    public void onScaleChanged(fr frVar, float f, float f2) {
    }

    public void onReceivedLoginRequest(fr frVar, String str, String str2, String str3) {
    }
}
