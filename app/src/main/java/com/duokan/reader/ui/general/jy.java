package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.duokan.core.app.x;
import com.duokan.core.sys.af;
import com.duokan.core.ui.f;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.ui.general.web.km;
import com.duokan.reader.ui.s;

public class jy extends f implements SystemUiConditioner {
    protected final View a;
    private final WebView b;
    private final ImageButton c;
    private final ImageButton d;
    private final View e;
    private ia f;
    private String g;
    private ki h = null;
    private WebViewClient i;
    private final DownloadListener j = new jz(this);

    public jy(Context context) {
        super(context);
        setContentView(g.general__web_window_view);
        this.c = (ImageButton) findViewById(com.duokan.b.f.general__web_window_view__back);
        this.c.setOnClickListener(new ka(this));
        this.d = (ImageButton) findViewById(com.duokan.b.f.general__web_window_view__foward);
        this.d.setOnClickListener(new kb(this));
        this.e = findViewById(com.duokan.b.f.general__web_window_view__refresh);
        this.e.setOnClickListener(new kc(this));
        int headerPaddingTop = ((s) x.a(getContext()).queryFeature(s.class)).getTheme().getHeaderPaddingTop();
        View findViewById = findViewById(com.duokan.b.f.general__web_window_view__title);
        findViewById.setPadding(findViewById.getPaddingLeft(), headerPaddingTop, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        this.a = findViewById(com.duokan.b.f.general__web_window_view__menu);
        this.a.setOnClickListener(new kd(this));
        this.b = (WebView) findViewById(com.duokan.b.f.general__network_view__web);
        WebSettings settings = this.b.getSettings();
        km.a(settings);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        this.b.setScrollBarStyle(0);
        this.i = a();
        this.b.setWebViewClient(this.i);
        this.b.setDownloadListener(this.j);
        findViewById(com.duokan.b.f.general__web_window_view__cancel).setOnClickListener(new kf(this));
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    public void onDismiss() {
        ReaderFeature readerFeature = (ReaderFeature) x.a(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            readerFeature.removeSystemUiConditioner(this);
        }
        this.b.destroy();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
                this.g = "http://" + str;
            } else {
                this.g = str;
            }
            this.b.loadUrl(this.g);
            h();
        }
    }

    public void a(boolean z) {
    }

    protected WebViewClient a() {
        return new kg(this);
    }

    public void chooseStatusBarStyle(af afVar) {
        if (isShowing()) {
            afVar.a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
    }

    private void c() {
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.e.startAnimation(rotateAnimation);
        this.e.setEnabled(false);
    }

    private void d() {
        this.e.setEnabled(true);
        this.e.clearAnimation();
    }

    private void e() {
        this.b.reload();
    }

    private void f() {
        this.b.goForward();
    }

    private void g() {
        this.b.goBack();
    }

    private void h() {
        this.c.setEnabled(this.b.canGoBack());
        if (this.c.isEnabled()) {
            this.c.getDrawable().setAlpha(255);
        } else {
            this.c.getDrawable().setAlpha(80);
        }
        this.d.setEnabled(this.b.canGoForward());
        if (this.d.isEnabled()) {
            this.d.getDrawable().setAlpha(255);
        } else {
            this.d.getDrawable().setAlpha(80);
        }
    }

    private void i() {
        String url = this.b.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = this.g;
        }
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    private void j() {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setText(this.b.getUrl());
    }

    public void b() {
        this.a.setVisibility(8);
    }

    public void show() {
        super.show();
    }

    protected void onShow() {
        super.onShow();
        ReaderFeature readerFeature = (ReaderFeature) x.a(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            readerFeature.addSystemUiConditioner(this);
            readerFeature.updateSystemUi(true);
        }
    }
}
