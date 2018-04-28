package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;

class fw extends WebChromeClient {
    /* renamed from: a */
    final /* synthetic */ fr f1276a;

    private fw(fr frVar) {
        this.f1276a = frVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2062a(this.f1276a, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.mo1835a(this.f1276a, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2063a(this.f1276a, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2065a(this.f1276a, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2058a(view, new fx(this, customViewCallback));
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public void onHideCustomView() {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2057a();
        } else {
            super.onHideCustomView();
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.m2071a(this.f1276a, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    public void onRequestFocus(WebView webView) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2061a(this.f1276a);
        } else {
            super.onRequestFocus(webView);
        }
    }

    public void onCloseWindow(WebView webView) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2074b(this.f1276a);
        } else {
            super.onCloseWindow(webView);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.mo1837a(this.f1276a, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.mo1838b(this.f1276a, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.m2070a(this.f1276a, str, str2, str3, jsPromptResult);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.m2077c(this.f1276a, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2066a(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2072b();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @TargetApi(21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2059a(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @TargetApi(21)
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2073b(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.mo1836a(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public Bitmap getDefaultVideoPoster() {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.m2076c();
        }
        return super.getDefaultVideoPoster();
    }

    public View getVideoLoadingProgressView() {
        if (this.f1276a.f1264d != null) {
            return this.f1276a.f1264d.m2078d();
        }
        return super.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.f1276a.f1264d != null) {
            this.f1276a.f1264d.m2060a((ValueCallback) valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return this.f1276a.f1264d != null ? this.f1276a.f1264d.m2068a(this.f1276a, (ValueCallback) valueCallback, new fy(this, fileChooserParams)) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
