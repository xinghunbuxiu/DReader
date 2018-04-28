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
import com.duokan.core.app.AppContext;
import com.duokan.core.sys.af;
import com.duokan.core.ui.C0343f;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.web.lr;

public class ji extends C0343f implements SystemUiConditioner {
    /* renamed from: a */
    protected final View f7437a;
    /* renamed from: b */
    private final WebView f7438b;
    /* renamed from: c */
    private final ImageButton f7439c;
    /* renamed from: d */
    private final ImageButton f7440d;
    /* renamed from: e */
    private final View f7441e;
    /* renamed from: f */
    private hp f7442f;
    /* renamed from: g */
    private String f7443g;
    /* renamed from: h */
    private js f7444h = null;
    /* renamed from: i */
    private WebViewClient f7445i;
    /* renamed from: j */
    private final DownloadListener f7446j = new jj(this);

    public ji(Context context) {
        super(context);
        setContentView(C0245g.general__web_window_view);
        this.f7439c = (ImageButton) findViewById(C0244f.general__web_window_view__back);
        this.f7439c.setOnClickListener(new jk(this));
        this.f7440d = (ImageButton) findViewById(C0244f.general__web_window_view__foward);
        this.f7440d.setOnClickListener(new jl(this));
        this.f7441e = findViewById(C0244f.general__web_window_view__refresh);
        this.f7441e.setOnClickListener(new jm(this));
        int headerPaddingTop = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop();
        View findViewById = findViewById(C0244f.general__web_window_view__title);
        findViewById.setPadding(findViewById.getPaddingLeft(), headerPaddingTop, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        this.f7437a = findViewById(C0244f.general__web_window_view__menu);
        this.f7437a.setOnClickListener(new jn(this));
        this.f7438b = (WebView) findViewById(C0244f.general__network_view__web);
        WebSettings settings = this.f7438b.getSettings();
        lr.m11294a(settings);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        this.f7438b.setScrollBarStyle(0);
        this.f7445i = m10871a();
        this.f7438b.setWebViewClient(this.f7445i);
        this.f7438b.setDownloadListener(this.f7446j);
        findViewById(C0244f.general__web_window_view__cancel).setOnClickListener(new jp(this));
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    public void onDismiss() {
        ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            readerFeature.removeSystemUiConditioner(this);
        }
        this.f7438b.destroy();
    }

    /* renamed from: a */
    public void m10872a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
                this.f7443g = "http://" + str;
            } else {
                this.f7443g = str;
            }
            this.f7438b.loadUrl(this.f7443g);
            m10865h();
        }
    }

    /* renamed from: a */
    public void m10873a(boolean z) {
    }

    /* renamed from: a */
    protected WebViewClient m10871a() {
        return new jq(this);
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isShowing()) {
            afVar.mo975a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
    }

    /* renamed from: c */
    private void m10854c() {
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f7441e.startAnimation(rotateAnimation);
        this.f7441e.setEnabled(false);
    }

    /* renamed from: d */
    private void m10857d() {
        this.f7441e.setEnabled(true);
        this.f7441e.clearAnimation();
    }

    /* renamed from: e */
    private void m10858e() {
        this.f7438b.reload();
    }

    /* renamed from: f */
    private void m10860f() {
        this.f7438b.goForward();
    }

    /* renamed from: g */
    private void m10862g() {
        this.f7438b.goBack();
    }

    /* renamed from: h */
    private void m10865h() {
        this.f7439c.setEnabled(this.f7438b.canGoBack());
        if (this.f7439c.isEnabled()) {
            this.f7439c.getDrawable().setAlpha(255);
        } else {
            this.f7439c.getDrawable().setAlpha(80);
        }
        this.f7440d.setEnabled(this.f7438b.canGoForward());
        if (this.f7440d.isEnabled()) {
            this.f7440d.getDrawable().setAlpha(255);
        } else {
            this.f7440d.getDrawable().setAlpha(80);
        }
    }

    /* renamed from: i */
    private void m10866i() {
        String url = this.f7438b.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = this.f7443g;
        }
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    /* renamed from: j */
    private void m10868j() {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setText(this.f7438b.getUrl());
    }

    /* renamed from: b */
    public void m10874b() {
        this.f7437a.setVisibility(8);
    }

    public void show() {
        super.show();
    }

    protected void onShow() {
        super.onShow();
        ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            readerFeature.addSystemUiConditioner(this);
            readerFeature.updateSystemUi(true);
        }
    }
}
