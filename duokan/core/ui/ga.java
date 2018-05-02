package com.duokan.core.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.duokan.core.sys.TaskHandler;

class ga extends WebViewClient {
    final /* synthetic */ fr a;

    private ga(fr frVar) {
        this.a = frVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading;
        if (this.a.c != null) {
            shouldOverrideUrlLoading = this.a.c.shouldOverrideUrlLoading(this.a, str);
        } else {
            shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
        }
        if (!shouldOverrideUrlLoading) {
            this.a.e = str;
            this.a.f = true;
            this.a.g = 0;
        }
        return shouldOverrideUrlLoading;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.e = str;
        this.a.f = true;
        this.a.g = 0;
        if (this.a.h > 0) {
            this.a.i = new gb(this);
            TaskHandler.postDelayed(this.a.i, this.a.h);
        }
        this.a.a(str, bitmap);
        if (this.a.c != null) {
            this.a.c.onPageStarted(this.a, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.e = str;
        this.a.f = false;
        this.a.i = null;
        this.a.b(str);
        if (this.a.c != null) {
            this.a.c.onPageFinished(this.a, str);
        } else {
            super.onPageFinished(webView, str);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.a.c != null) {
            this.a.c.onLoadResource(this.a, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.a.c != null) {
            return this.a.c.shouldInterceptRequest(this.a, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.g = i;
        if (this.a.c != null) {
            this.a.c.onReceivedError(this.a, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.a.c != null) {
            this.a.c.onFormResubmission(this.a, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.a.c != null) {
            this.a.c.doUpdateVisitedHistory(this.a, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a.c != null) {
            this.a.c.onReceivedSslError(this.a, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.a.c != null) {
            this.a.c.onReceivedHttpAuthRequest(this.a, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.a.c != null) {
            return this.a.c.shouldOverrideKeyEvent(this.a, keyEvent);
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        if (this.a.c != null) {
            this.a.c.onScaleChanged(this.a, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (this.a.c != null) {
            this.a.c.onReceivedLoginRequest(this.a, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
