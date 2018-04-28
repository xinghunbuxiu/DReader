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
import com.duokan.core.sys.UThread;

class ga extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ fr f1288a;

    private ga(fr frVar) {
        this.f1288a = frVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading;
        if (this.f1288a.f1263c != null) {
            shouldOverrideUrlLoading = this.f1288a.f1263c.shouldOverrideUrlLoading(this.f1288a, str);
        } else {
            shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
        }
        if (!shouldOverrideUrlLoading) {
            this.f1288a.f1265e = str;
            this.f1288a.f1266f = true;
            this.f1288a.f1267g = 0;
        }
        return shouldOverrideUrlLoading;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f1288a.f1265e = str;
        this.f1288a.f1266f = true;
        this.f1288a.f1267g = 0;
        if (this.f1288a.f1268h > 0) {
            this.f1288a.f1269i = new gb(this);
            UThread.postDelayed(this.f1288a.f1269i, this.f1288a.f1268h);
        }
        this.f1288a.m2116a(str, bitmap);
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onPageStarted(this.f1288a, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* renamed from: a */
    void m2147a(gb gbVar) {
        if (this.f1288a.f1269i == gbVar) {
            this.f1288a.f1269i = null;
            if (this.f1288a.f1266f) {
                this.f1288a.f1261a.stopLoading();
                this.f1288a.f1267g = -8;
                if (this.f1288a.f1263c != null) {
                    this.f1288a.f1263c.onReceivedError(this.f1288a, this.f1288a.f1267g, "loading timeout", this.f1288a.f1265e);
                }
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        this.f1288a.f1265e = str;
        this.f1288a.f1266f = false;
        this.f1288a.f1269i = null;
        this.f1288a.mo1817b(str);
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onPageFinished(this.f1288a, str);
        } else {
            super.onPageFinished(webView, str);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onLoadResource(this.f1288a, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.f1288a.f1263c != null) {
            return this.f1288a.f1263c.shouldInterceptRequest(this.f1288a, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f1288a.f1267g = i;
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onReceivedError(this.f1288a, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onFormResubmission(this.f1288a, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.doUpdateVisitedHistory(this.f1288a, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onReceivedSslError(this.f1288a, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onReceivedHttpAuthRequest(this.f1288a, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.f1288a.f1263c != null) {
            return this.f1288a.f1263c.shouldOverrideKeyEvent(this.f1288a, keyEvent);
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onScaleChanged(this.f1288a, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (this.f1288a.f1263c != null) {
            this.f1288a.f1263c.onReceivedLoginRequest(this.f1288a, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
