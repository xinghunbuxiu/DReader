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

public class fl {
    private final WebChromeClient a = new WebChromeClient();

    public void a(fr frVar, int i) {
        this.a.onProgressChanged(frVar.a, i);
    }

    public void a(fr frVar, String str) {
        this.a.onReceivedTitle(frVar.a, str);
    }

    public void a(fr frVar, Bitmap bitmap) {
        this.a.onReceivedIcon(frVar.a, bitmap);
    }

    public void a(fr frVar, String str, boolean z) {
        this.a.onReceivedTouchIconUrl(frVar.a, str, z);
    }

    public void a(View view, fo foVar) {
        this.a.onShowCustomView(view, new fm(this, foVar));
    }

    public void a() {
        this.a.onHideCustomView();
    }

    public boolean a(fr frVar, boolean z, boolean z2, Message message) {
        return this.a.onCreateWindow(frVar.a, z, z2, message);
    }

    public void a(fr frVar) {
        this.a.onRequestFocus(frVar.a);
    }

    public void b(fr frVar) {
        this.a.onCloseWindow(frVar.a);
    }

    public boolean a(fr frVar, String str, String str2, JsResult jsResult) {
        return this.a.onJsAlert(frVar.a, str, str2, jsResult);
    }

    public boolean b(fr frVar, String str, String str2, JsResult jsResult) {
        return this.a.onJsConfirm(frVar.a, str, str2, jsResult);
    }

    public boolean a(fr frVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.a.onJsPrompt(frVar.a, str, str2, str3, jsPromptResult);
    }

    public boolean c(fr frVar, String str, String str2, JsResult jsResult) {
        return this.a.onJsBeforeUnload(frVar.a, str, str2, jsResult);
    }

    public void a(String str, Callback callback) {
        this.a.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public void b() {
        this.a.onGeolocationPermissionsHidePrompt();
    }

    public void a(PermissionRequest permissionRequest) {
        this.a.onPermissionRequest(permissionRequest);
    }

    public void b(PermissionRequest permissionRequest) {
        this.a.onPermissionRequestCanceled(permissionRequest);
    }

    public boolean a(ConsoleMessage consoleMessage) {
        return this.a.onConsoleMessage(consoleMessage);
    }

    public Bitmap c() {
        return this.a.getDefaultVideoPoster();
    }

    public View d() {
        return this.a.getVideoLoadingProgressView();
    }

    public void a(ValueCallback valueCallback) {
        this.a.getVisitedHistory(valueCallback);
    }

    @TargetApi(21)
    public boolean a(fr frVar, ValueCallback valueCallback, fp fpVar) {
        return this.a.onShowFileChooser(frVar.a, valueCallback, new fn(this, fpVar));
    }
}
