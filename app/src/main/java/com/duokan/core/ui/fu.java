package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
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

class fu extends WebChromeClient {
    final /* synthetic */ fr a;

    private fu(fr frVar) {
        this.a = frVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.a.d != null) {
            this.a.d.a(this.a, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (this.a.d != null) {
            this.a.d.a(this.a, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.a.d != null) {
            this.a.d.a(this.a, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.a.d != null) {
            this.a.d.a(this.a, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (this.a.d != null) {
            this.a.d.a(view, new fv(this, customViewCallback));
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public void onHideCustomView() {
        if (this.a.d != null) {
            this.a.d.a();
        } else {
            super.onHideCustomView();
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (this.a.d != null) {
            return this.a.d.a(this.a, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    public void onRequestFocus(WebView webView) {
        if (this.a.d != null) {
            this.a.d.a(this.a);
        } else {
            super.onRequestFocus(webView);
        }
    }

    public void onCloseWindow(WebView webView) {
        if (this.a.d != null) {
            this.a.d.b(this.a);
        } else {
            super.onCloseWindow(webView);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a.d != null) {
            return this.a.d.a(this.a, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a.d != null) {
            return this.a.d.b(this.a, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.a.d != null) {
            return this.a.d.a(this.a, str, str2, str3, jsPromptResult);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a.d != null) {
            return this.a.d.c(this.a, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (this.a.d != null) {
            this.a.d.a(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        if (this.a.d != null) {
            this.a.d.b();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @TargetApi(21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (this.a.d != null) {
            this.a.d.a(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @TargetApi(21)
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        if (this.a.d != null) {
            this.a.d.b(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.a.d != null) {
            return this.a.d.a(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public Bitmap getDefaultVideoPoster() {
        if (this.a.d != null) {
            return this.a.d.c();
        }
        return super.getDefaultVideoPoster();
    }

    public View getVideoLoadingProgressView() {
        if (this.a.d != null) {
            return this.a.d.d();
        }
        return super.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback valueCallback) {
        if (this.a.d != null) {
            this.a.d.a(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, FileChooserParams fileChooserParams) {
        return this.a.d != null ? this.a.d.a(this.a, valueCallback, new fw(this, fileChooserParams)) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
