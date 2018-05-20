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

public class WebPageChromeClient {
    
    private final WebChromeClient webChromeClient = new WebChromeClient();

    
    public void onProgressChanged(fr frVar, int i) {
        this.webChromeClient.onProgressChanged(frVar.dkWebView, i);
    }

    
    public void onReceivedTitle(fr frVar, String str) {
        this.webChromeClient.onReceivedTitle(frVar.dkWebView, str);
    }

    
    public void onReceivedIcon(fr frVar, Bitmap bitmap) {
        this.webChromeClient.onReceivedIcon(frVar.dkWebView, bitmap);
    }

    
    public void onReceivedTouchIconUrl(fr frVar, String str, boolean z) {
        this.webChromeClient.onReceivedTouchIconUrl(frVar.dkWebView, str, z);
    }

    
    public void onShowCustomView(View view, fo foVar) {
        this.webChromeClient.onShowCustomView(view, new fm(this, foVar));
    }

    
    public void onHideCustomView() {
        this.webChromeClient.onHideCustomView();
    }

    
    public boolean onCreateWindow(fr frVar, boolean z, boolean z2, Message message) {
        return this.webChromeClient.onCreateWindow(frVar.dkWebView, z, z2, message);
    }

    
    public void onRequestFocus(fr frVar) {
        this.webChromeClient.onRequestFocus(frVar.dkWebView);
    }

    
    public void onCloseWindow(fr frVar) {
        this.webChromeClient.onCloseWindow(frVar.dkWebView);
    }

    
    public boolean onJsAlert(fr frVar, String str, String str2, JsResult jsResult) {
        return this.webChromeClient.onJsAlert(frVar.dkWebView, str, str2, jsResult);
    }

    
    public boolean onJsConfirm(fr frVar, String str, String str2, JsResult jsResult) {
        return this.webChromeClient.onJsConfirm(frVar.dkWebView, str, str2, jsResult);
    }

    
    public boolean onJsPrompt(fr frVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.webChromeClient.onJsPrompt(frVar.dkWebView, str, str2, str3, jsPromptResult);
    }

    
    public boolean onJsBeforeUnload(fr frVar, String str, String str2, JsResult jsResult) {
        return this.webChromeClient.onJsBeforeUnload(frVar.dkWebView, str, str2, jsResult);
    }

    
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        this.webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
    }

    
    public void onGeolocationPermissionsHidePrompt() {
        this.webChromeClient.onGeolocationPermissionsHidePrompt();
    }

    
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        this.webChromeClient.onPermissionRequest(permissionRequest);
    }

    
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        this.webChromeClient.onPermissionRequestCanceled(permissionRequest);
    }

    
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.webChromeClient.onConsoleMessage(consoleMessage);
    }

    
    public Bitmap getDefaultVideoPoster() {
        return this.webChromeClient.getDefaultVideoPoster();
    }

    
    public View getVideoLoadingProgressView() {
        return this.webChromeClient.getVideoLoadingProgressView();
    }

    
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.webChromeClient.getVisitedHistory(valueCallback);
    }

    @TargetApi(21)
    
    public boolean onShowFileChooser(fr frVar, ValueCallback<Uri[]> valueCallback, fp fpVar) {
        return this.webChromeClient.onShowFileChooser(frVar.dkWebView, valueCallback, new fn(this, fpVar));
    }
}
