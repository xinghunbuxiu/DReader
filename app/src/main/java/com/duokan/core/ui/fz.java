package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable.ScrollState;
import java.util.concurrent.TimeUnit;

public class fz extends WebView implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ fr f1281a;

    @SuppressLint({"SetJavaScriptEnabled"})
    public fz(fr frVar, Context context) {
        this.f1281a = frVar;
        super(context);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        setWebViewClient(new ga(frVar, null));
        setWebChromeClient(new fw(frVar));
    }

    public int getHorizontalScrollRange() {
        return computeHorizontalScrollRange();
    }

    public int getVerticalScrollRange() {
        return computeVerticalScrollRange();
    }

    /* renamed from: a */
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
        if (!(this.f1281a.f1262b.m1561s() == getHorizontalScrollRange() && this.f1281a.f1262b.m1562t() == getVerticalScrollRange())) {
            this.f1281a.f1262b.m1512b(getHorizontalScrollRange(), getVerticalScrollRange());
        }
        if (this.f1281a.f1262b.getScrollState() != ScrollState.IDLE) {
            this.f1281a.f1262b.mo491a(this.f1281a.f1262b.getViewportBounds().left, this.f1281a.f1262b.getViewportBounds().top);
        } else {
            this.f1281a.f1262b.m1535d(getScrollX() + super.getScrollX(), getScrollY() + super.getScrollY());
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

    /* renamed from: b */
    private void m2136b() {
        if (this.f1281a.f1270j == null) {
            this.f1281a.f1270j = new ft(this);
            UThread.postDelayed(this.f1281a.f1270j, TimeUnit.SECONDS.toMillis(10));
        }
    }

    /* renamed from: a */
    public void m2138a() {
        this.f1281a.f1270j = null;
        m2137c();
    }

    /* renamed from: c */
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
                    RectF rectF = (RectF) dv.f1199h.addAnimation();
                    boolean a = dv.m1925a(rectF, (View) this);
                    dv.f1199h.clearAnimation(rectF);
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
