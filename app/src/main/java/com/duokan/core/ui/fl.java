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

public class fl {
    /* renamed from: a */
    private final WebChromeClient f1256a = new WebChromeClient();

    /* renamed from: a */
    public void m2062a(fr frVar, int i) {
        this.f1256a.onProgressChanged(frVar.f1261a, i);
    }

    /* renamed from: a */
    public void mo1835a(fr frVar, String str) {
        this.f1256a.onReceivedTitle(frVar.f1261a, str);
    }

    /* renamed from: a */
    public void m2063a(fr frVar, Bitmap bitmap) {
        this.f1256a.onReceivedIcon(frVar.f1261a, bitmap);
    }

    /* renamed from: a */
    public void m2065a(fr frVar, String str, boolean z) {
        this.f1256a.onReceivedTouchIconUrl(frVar.f1261a, str, z);
    }

    /* renamed from: a */
    public void m2058a(View view, fo foVar) {
        this.f1256a.onShowCustomView(view, new fm(this, foVar));
    }

    /* renamed from: a */
    public void m2057a() {
        this.f1256a.onHideCustomView();
    }

    /* renamed from: a */
    public boolean m2071a(fr frVar, boolean z, boolean z2, Message message) {
        return this.f1256a.onCreateWindow(frVar.f1261a, z, z2, message);
    }

    /* renamed from: a */
    public void m2061a(fr frVar) {
        this.f1256a.onRequestFocus(frVar.f1261a);
    }

    /* renamed from: b */
    public void m2074b(fr frVar) {
        this.f1256a.onCloseWindow(frVar.f1261a);
    }

    /* renamed from: a */
    public boolean mo1837a(fr frVar, String str, String str2, JsResult jsResult) {
        return this.f1256a.onJsAlert(frVar.f1261a, str, str2, jsResult);
    }

    /* renamed from: b */
    public boolean mo1838b(fr frVar, String str, String str2, JsResult jsResult) {
        return this.f1256a.onJsConfirm(frVar.f1261a, str, str2, jsResult);
    }

    /* renamed from: a */
    public boolean m2070a(fr frVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.f1256a.onJsPrompt(frVar.f1261a, str, str2, str3, jsPromptResult);
    }

    /* renamed from: c */
    public boolean m2077c(fr frVar, String str, String str2, JsResult jsResult) {
        return this.f1256a.onJsBeforeUnload(frVar.f1261a, str, str2, jsResult);
    }

    /* renamed from: a */
    public void m2066a(String str, Callback callback) {
        this.f1256a.onGeolocationPermissionsShowPrompt(str, callback);
    }

    /* renamed from: b */
    public void m2072b() {
        this.f1256a.onGeolocationPermissionsHidePrompt();
    }

    /* renamed from: a */
    public void m2059a(PermissionRequest permissionRequest) {
        this.f1256a.onPermissionRequest(permissionRequest);
    }

    /* renamed from: b */
    public void m2073b(PermissionRequest permissionRequest) {
        this.f1256a.onPermissionRequestCanceled(permissionRequest);
    }

    /* renamed from: a */
    public boolean mo1836a(ConsoleMessage consoleMessage) {
        return this.f1256a.onConsoleMessage(consoleMessage);
    }

    /* renamed from: c */
    public Bitmap m2076c() {
        return this.f1256a.getDefaultVideoPoster();
    }

    /* renamed from: d */
    public View m2078d() {
        return this.f1256a.getVideoLoadingProgressView();
    }

    /* renamed from: a */
    public void m2060a(ValueCallback<String[]> valueCallback) {
        this.f1256a.getVisitedHistory(valueCallback);
    }

    @TargetApi(21)
    /* renamed from: a */
    public boolean m2068a(fr frVar, ValueCallback<Uri[]> valueCallback, fp fpVar) {
        return this.f1256a.onShowFileChooser(frVar.f1261a, valueCallback, new fn(this, fpVar));
    }
}
