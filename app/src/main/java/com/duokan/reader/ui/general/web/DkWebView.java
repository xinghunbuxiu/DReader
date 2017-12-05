package com.duokan.reader.ui.general.web;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.widget.LinearLayout;

import com.duokan.core.sys.AIdleOperation;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.PullDownRefreshView;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.fl;
import com.duokan.core.ui.fq;
import com.duokan.core.ui.fr;
import com.duokan.core.ui.ft;
import com.duokan.core.ui.fx;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.WebView;
import com.duokan.reader.ui.general.jw;

public class DkWebView extends WebView {
    public static final String b = DkWebView.class.getName();
    private final WebSettings c;
    private final classc.IConnectChanged d = new h(this);
    private final LinearLayout e;
    private final PullDownRefreshView f;
    private cg g = null;
    private o h = null;
    private boolean i = false;

    protected /* synthetic */ ft a(fx fxVar) {
        return b(fxVar);
    }

    @SuppressLint({"NewApi"})
    public DkWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (DkApp.get().forCommunity()) {
            setLoadingTimout(0);
        }
        this.c = getSettings();
        km.a(this.c);
        super.setDownloadListener(new i(this));
        if (VERSION.SDK_INT >= 11) {
            setLayerType(0, null);
        }
        if (VERSION.SDK_INT >= 19 && (DkApp.get().forCommunity() || !p.i().k())) {
            fr.setWebContentsDebuggingEnabled(true);
        }
        this.e = new LinearLayout(getContext());
        this.e.setOrientation(1);
        this.f = new PullDownRefreshView(getContext());
        this.e.addView(this.f, new LayoutParams(-1, -2));
        setPullDownHeaderView(this.e);
        super.setOnScrollListener(new AIdleOperation(this));
    }

    public boolean k() {
        return this.i;
    }

    public void setPullDownRefreshEnabled(boolean z) {
        this.f.setVisibility(z ? 0 : 4);
    }

    public void setOnPullDownRefreshListener(o oVar) {
        this.h = oVar;
    }

    protected jw b(fx fxVar) {
        return new n(this, fxVar);
    }

    public void setOnScrollListener(cg cgVar) {
        this.g = cgVar;
    }

    public cg getOnScrollerListener() {
        return this.g;
    }

    public boolean c(String str) {
        if (this.i) {
            return false;
        }
        a(str);
        return true;
    }

    public void a(String str) {
        a.k().a(str);
        if (!this.i) {
            super.a(str);
        }
    }

    public void c() {
        if (!this.i) {
            super.c();
        }
    }

    public boolean d() {
        if (this.i) {
            return false;
        }
        return super.d();
    }

    public void a(int i) {
        if (!this.i) {
            super.a(i);
        }
    }

    public WebBackForwardList e() {
        if (this.i) {
            return null;
        }
        return super.e();
    }

    public void setOverScrollMode(int i) {
        if (!this.i) {
            super.setOverScrollMode(i);
        }
    }

    public void setScrollBarStyle(int i) {
        if (!this.i) {
            super.setScrollBarStyle(i);
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.i) {
            return 0;
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeHorizontalScrollOffset() {
        if (this.i) {
            return 0;
        }
        return super.computeHorizontalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        if (this.i) {
            return 0;
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollOffset() {
        if (this.i) {
            return 0;
        }
        return super.computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollExtent() {
        if (this.i) {
            return 0;
        }
        return super.computeVerticalScrollExtent();
    }

    public void computeScroll() {
        if (!this.i) {
            super.computeScroll();
        }
    }

    @TargetApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.i) {
            return null;
        }
        return super.getAccessibilityNodeProvider();
    }

    public boolean shouldDelayChildPressedState() {
        if (this.i) {
            return false;
        }
        return super.shouldDelayChildPressedState();
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.i) {
            return false;
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.i) {
            return false;
        }
        return super.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.i) {
            return false;
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    public void setLayerType(int i, Paint paint) {
        if (!this.i) {
            super.setLayerType(i, paint);
        }
    }

    public void a(Object obj, String str) {
        if (!this.i) {
            super.a(obj, str);
        }
    }

    public void setWebpageClient(fq fqVar) {
        if (!this.i) {
            super.setWebpageClient(fqVar);
        }
    }

    public void setWebpageChromeClient(fl flVar) {
        if (!this.i) {
            super.setWebpageChromeClient(flVar);
        }
    }

    public final boolean performLongClick() {
        return true;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
    }

    public void f() {
        this.i = true;
        super.f();
    }

    protected void onAttachedToWindow() {
        f.b().a(this.d);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        f.b().b(this.d);
        super.onDetachedFromWindow();
        AIdleOperation.addIdleStatus(new l(this));
    }

    protected void b(String str) {
        super.b(str);
        if (this.f.getRefreshState() == RefreshState.REFRESHING) {
            this.f.setOnRefreshDone(new m(this));
            this.f.setRefreshState(RefreshState.REFRESH_DONE);
        }
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.f.setRefreshStyle(refreshStyle);
    }

    private void l() {
        c();
    }

    private boolean m() {
        return this.f.getVisibility() == 0;
    }
}
