package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable.ScrollState;
import java.util.concurrent.TimeUnit;

public class DkWebView extends WebView implements OnPreDrawListener {
    
    final  fr f1281a;

    @SuppressLint({"SetJavaScriptEnabled"})
    public DkWebView(fr frVar, Context context) {
        super(context);
        this.f1281a = frVar;
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                boolean shouldOverrideUrlLoading;
                if (f1281a.f1263c != null) {
                    shouldOverrideUrlLoading = f1281a.f1263c.shouldOverrideUrlLoading(f1281a, str);
                } else {
                    shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
                }
                if (!shouldOverrideUrlLoading) {
                    f1281a.f1265e = str;
                    f1281a.f1266f = true;
                    f1281a.f1267g = 0;
                }
                return shouldOverrideUrlLoading;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                f1281a.f1265e = str;
                f1281a.f1266f = true;
                f1281a.f1267g = 0;
                if (f1281a.f1268h > 0) {
                    f1281a.f1269i = new gb(this);
                    UThread.postDelayed(f1281a.f1269i, f1281a.f1268h);
                }
                f1281a.m2116a(str, bitmap);
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onPageStarted(f1281a, str, bitmap);
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }

            
            void m2147a(gb gbVar) {
                if (f1281a.f1269i == gbVar) {
                    f1281a.f1269i = null;
                    if (f1281a.f1266f) {
                        f1281a.dkWebView.stopLoading();
                        f1281a.f1267g = -8;
                        if (f1281a.f1263c != null) {
                            f1281a.f1263c.onReceivedError(f1281a, f1281a.f1267g, "loading timeout", f1281a.f1265e);
                        }
                    }
                }
            }

            public void onPageFinished(WebView webView, String str) {
                f1281a.f1265e = str;
                f1281a.f1266f = false;
                f1281a.f1269i = null;
                f1281a.mo1817b(str);
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onPageFinished(f1281a, str);
                } else {
                    super.onPageFinished(webView, str);
                }
            }

            public void onLoadResource(WebView webView, String str) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onLoadResource(f1281a, str);
                } else {
                    super.onLoadResource(webView, str);
                }
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (f1281a.f1263c != null) {
                    return f1281a.f1263c.shouldInterceptRequest(f1281a, str);
                }
                return super.shouldInterceptRequest(webView, str);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                f1281a.f1267g = i;
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onReceivedError(f1281a, i, str, str2);
                } else {
                    super.onReceivedError(webView, i, str, str2);
                }
            }

            public void onFormResubmission(WebView webView, Message message, Message message2) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onFormResubmission(f1281a, message, message2);
                } else {
                    super.onFormResubmission(webView, message, message2);
                }
            }

            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.doUpdateVisitedHistory(f1281a, str, z);
                } else {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onReceivedSslError(f1281a, sslErrorHandler, sslError);
                } else {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            }

            public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onReceivedHttpAuthRequest(f1281a, httpAuthHandler, str, str2);
                } else {
                    super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                }
            }

            public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
                if (f1281a.f1263c != null) {
                    return f1281a.f1263c.shouldOverrideKeyEvent(f1281a, keyEvent);
                }
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }

            public void onScaleChanged(WebView webView, float f, float f2) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onScaleChanged(f1281a, f, f2);
                } else {
                    super.onScaleChanged(webView, f, f2);
                }
            }

            public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
                if (f1281a.f1263c != null) {
                    f1281a.f1263c.onReceivedLoginRequest(f1281a, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(webView, str, str2, str3);
                }
            }
        });
        setWebChromeClient(new WebChromeClient(){

            public void onProgressChanged(WebView webView, int i) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onProgressChanged(f1281a, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            public void onReceivedTitle(WebView webView, String str) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onReceivedTitle(f1281a, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onReceivedIcon(f1281a, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onReceivedTouchIconUrl(f1281a, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onShowCustomView(view, new fx(this, customViewCallback));
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            public void onHideCustomView() {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onCreateWindow(f1281a, z, z2, message);
                }
                return super.onCreateWindow(webView, z, z2, message);
            }

            public void onRequestFocus(WebView webView) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onRequestFocus(f1281a);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            public void onCloseWindow(WebView webView) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onCloseWindow(f1281a);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onJsAlert(f1281a, str, str2, jsResult);
                }
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onJsConfirm(f1281a, str, str2, jsResult);
                }
                return super.onJsConfirm(webView, str, str2, jsResult);
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onJsPrompt(f1281a, str, str2, str3, jsPromptResult);
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onJsBeforeUnload(f1281a, str, str2, jsResult);
                }
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            public void onGeolocationPermissionsHidePrompt() {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            public Bitmap getDefaultVideoPoster() {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.getDefaultVideoPoster();
                }
                return super.getDefaultVideoPoster();
            }

            public View getVideoLoadingProgressView() {
                if (f1281a.f1264d != null) {
                    return f1281a.f1264d.getVideoLoadingProgressView();
                }
                return super.getVideoLoadingProgressView();
            }

            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (f1281a.f1264d != null) {
                    f1281a.f1264d.getVisitedHistory((ValueCallback) valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                return f1281a.f1264d != null ? f1281a.f1264d.onShowFileChooser(f1281a, (ValueCallback) valueCallback, new fy(this, fileChooserParams)) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
        });
    }

    public int getHorizontalScrollRange() {
        return computeHorizontalScrollRange();
    }

    public int getVerticalScrollRange() {
        return computeVerticalScrollRange();
    }

    
    public void m2139a(Canvas canvas) {
        super.draw(canvas);
    }

    public void destroy() {
        this.f1281a.f1271k = true;
        super.destroy();
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        onResume();
        this.f1281a.f1262b.mo529b(canvas);
        m2136b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        onPause();
    }

    public boolean onPreDraw() {
        if (!(this.f1281a.f1262b.getContentWidth() == getHorizontalScrollRange() && this.f1281a.f1262b.getContentHeight() == getVerticalScrollRange())) {
            this.f1281a.f1262b.m1512b(getHorizontalScrollRange(), getVerticalScrollRange());
        }
        if (this.f1281a.f1262b.getScrollState() != ScrollState.IDLE) {
            this.f1281a.f1262b.mo491a(this.f1281a.f1262b.getViewportBounds().left, this.f1281a.f1262b.getViewportBounds().top);
        } else {
            this.f1281a.f1262b.scrollTo(getScrollX() + super.getScrollX(), getScrollY() + super.getScrollY());
        }
        return true;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            onPause();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            onPause();
        }
    }

    public void onPause() {
        if (!this.f1281a.f1272l) {
            this.f1281a.f1272l = true;
            super.onPause();
            WebLog.init().a(LogLevel.INFO, "webpage", "paused(url=%s)", this.f1281a.f1265e);
        }
    }

    public void onResume() {
        if (this.f1281a.f1272l) {
            this.f1281a.f1272l = false;
            super.onResume();
            WebLog.init().a(LogLevel.INFO, "webpage", "resumed(url=%s)", this.f1281a.f1265e);
        }
    }

    
    private void m2136b() {
        if (this.f1281a.f1270j == null) {
            this.f1281a.f1270j = new ft(this);
            UThread.postDelayed(this.f1281a.f1270j, TimeUnit.SECONDS.toMillis(10));
        }
    }

    
    public void m2138a() {
        this.f1281a.f1270j = null;
        m2137c();
    }

    
    private void m2137c() {
        Object obj = 1;
        if (!this.f1281a.f1272l && !this.f1281a.f1271k) {
            if (getWindowToken() != null && getWindowVisibility() == 0 && getVisibility() == 0) {
                boolean z;
                Object obj2;
                ViewParent parent = getParent();
                while (parent != null) {
                    if (!(parent instanceof View)) {
                        z = true;
                        break;
                    } else if (((View) parent).getVisibility() != 0) {
                        z = false;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                z = true;
                if (z) {
                    RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
                    boolean a = AnimUtils.m1925a(rectF, (View) this);
                    AnimUtils.f1199h.clearAnimation(rectF);
                    z = a;
                }
                if (z) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                obj = obj2;
            }
            if (obj != null) {
                onPause();
            }
        }
    }
}
