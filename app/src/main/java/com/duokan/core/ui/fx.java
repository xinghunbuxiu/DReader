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

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.core.ui.Scrollable.ScrollState;

import java.util.concurrent.TimeUnit;

public class fx extends WebView implements OnPreDrawListener {
    final /* synthetic */ fr a;

    @SuppressLint({"SetJavaScriptEnabled"})
    public fx(fr frVar, Context context) {
        this.a = frVar;
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
        setWebChromeClient(new fu(frVar));
    }

    public int getHorizontalScrollRange() {
        return computeHorizontalScrollRange();
    }

    public int getVerticalScrollRange() {
        return computeVerticalScrollRange();
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public void destroy() {
        this.a.k = true;
        super.destroy();
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        onResume();
        this.a.b.b(canvas);
        a();
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
        if (!(this.a.b.s() == getHorizontalScrollRange() && this.a.b.t() == getVerticalScrollRange())) {
            this.a.b.b(getHorizontalScrollRange(), getVerticalScrollRange());
        }
        if (this.a.b.getScrollState() != ScrollState.IDLE) {
            this.a.b.a(this.a.b.getViewportBounds().left, this.a.b.getViewportBounds().top);
        } else {
            this.a.b.d(getScrollX() + super.getScrollX(), getScrollY() + super.getScrollY());
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
        if (!this.a.l) {
            this.a.l = true;
            super.onPause();
            a.c().a(LogLevel.INFO, "webpage", "paused(url=%s)", this.a.e);
        }
    }

    public void onResume() {
        if (this.a.l) {
            this.a.l = false;
            super.onResume();
            a.c().a(LogLevel.INFO, "webpage", "resumed(url=%s)", this.a.e);
        }
    }

    private void a() {
        if (this.a.j == null) {
            this.a.j = new fy(this);
            t.a(this.a.j, TimeUnit.SECONDS.toMillis(10));
        }
    }

    private void b() {
        Object obj = 1;
        if (!this.a.l && !this.a.k) {
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
                    RectF rectF = (RectF) dv.h.a();
                    boolean a = dv.a(rectF, (View) this);
                    dv.h.a(rectF);
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
