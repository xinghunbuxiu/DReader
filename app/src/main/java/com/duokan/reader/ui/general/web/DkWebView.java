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

import com.duokan.core.app.AppContext;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.PullDownRefreshView;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.fl;
import com.duokan.core.ui.fq;
import com.duokan.core.ui.fr;
import com.duokan.core.ui.fv;
import com.duokan.core.ui.fz;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.WebView;
import com.duokan.reader.ui.general.jg;

public class DkWebView extends WebView {
    /* renamed from: b */
    public static final String f7558b = DkWebView.class.getName();
    /* renamed from: c */
    private final WebSettings f7559c;
    /* renamed from: d */
    private final C0563j f7560d = new C1360h(this);
    /* renamed from: e */
    private final LinearLayout f7561e;
    /* renamed from: f */
    private final PullDownRefreshView f7562f;
    /* renamed from: g */
    private cg f7563g = null;
    /* renamed from: h */
    private C1365o f7564h = null;
    /* renamed from: i */
    private boolean f7565i = false;

    /* renamed from: a */
    protected /* synthetic */ fv mo1744a(fz fzVar) {
        return mo1816b(fzVar);
    }

    @SuppressLint({"NewApi"})
    public DkWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (DkApp.get().forCommunity()) {
            setLoadingTimout(0);
        }
        this.f7559c = getSettings();
        lr.m11294a(this.f7559c);
        super.setDownloadListener(new C1361i(this));
        if (VERSION.SDK_INT >= 11) {
            setLayerType(0, null);
        }
        if (VERSION.SDK_INT >= 19 && (DkApp.get().forCommunity() || !C0641o.m2934i().m2984k())) {
            fr.setWebContentsDebuggingEnabled(true);
        }
        this.f7561e = new LinearLayout(getContext());
        this.f7561e.setOrientation(1);
        this.f7562f = new PullDownRefreshView(getContext());
        this.f7562f.setPadding(0, ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop(), 0, 0);
        this.f7561e.addView(this.f7562f, new LayoutParams(-1, -2));
        setPullDownHeaderView(this.f7561e);
        super.setOnScrollListener(new C1363j(this));
    }

    /* renamed from: k */
    public boolean mo1822k() {
        return this.f7565i;
    }

    public void setPullDownRefreshEnabled(boolean z) {
        this.f7562f.setVisibility(z ? 0 : 4);
    }

    public void setOnPullDownRefreshListener(C1365o c1365o) {
        this.f7564h = c1365o;
    }

    /* renamed from: b */
    protected jg mo1816b(fz fzVar) {
        return new C1369n(this, fzVar);
    }

    public void setOnScrollListener(cg cgVar) {
        this.f7563g = cgVar;
    }

    public cg getOnScrollerListener() {
        return this.f7563g;
    }

    /* renamed from: c */
    public boolean m10989c(String str) {
        if (this.f7565i) {
            return false;
        }
        mo1815a(str);
        return true;
    }

    /* renamed from: a */
    public void mo1815a(String str) {
        C1163a.m8627k().m8641a(str);
        if (!this.f7565i) {
            super.mo1815a(str);
        }
    }

    /* renamed from: c */
    public void mo1818c() {
        if (!this.f7565i) {
            super.mo1818c();
        }
    }

    /* renamed from: d */
    public boolean mo1819d() {
        if (this.f7565i) {
            return false;
        }
        return super.mo1819d();
    }

    /* renamed from: a */
    public void mo1813a(int i) {
        if (!this.f7565i) {
            super.mo1813a(i);
        }
    }

    /* renamed from: e */
    public WebBackForwardList mo1820e() {
        if (this.f7565i) {
            return null;
        }
        return super.mo1820e();
    }

    public void setOverScrollMode(int i) {
        if (!this.f7565i) {
            super.setOverScrollMode(i);
        }
    }

    public void setScrollBarStyle(int i) {
        if (!this.f7565i) {
            super.setScrollBarStyle(i);
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.f7565i) {
            return 0;
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeHorizontalScrollOffset() {
        if (this.f7565i) {
            return 0;
        }
        return super.computeHorizontalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        if (this.f7565i) {
            return 0;
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollOffset() {
        if (this.f7565i) {
            return 0;
        }
        return super.computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollExtent() {
        if (this.f7565i) {
            return 0;
        }
        return super.computeVerticalScrollExtent();
    }

    public void computeScroll() {
        if (!this.f7565i) {
            super.computeScroll();
        }
    }

    @TargetApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.f7565i) {
            return null;
        }
        return super.getAccessibilityNodeProvider();
    }

    public boolean shouldDelayChildPressedState() {
        if (this.f7565i) {
            return false;
        }
        return super.shouldDelayChildPressedState();
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.f7565i) {
            return false;
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f7565i) {
            return false;
        }
        return super.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.f7565i) {
            return false;
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    public void setLayerType(int i, Paint paint) {
        if (!this.f7565i) {
            super.setLayerType(i, paint);
        }
    }

    /* renamed from: a */
    public void mo1814a(Object obj, String str) {
        if (!this.f7565i) {
            super.mo1814a(obj, str);
        }
    }

    public void setWebpageClient(fq fqVar) {
        if (!this.f7565i) {
            super.setWebpageClient(fqVar);
        }
    }

    public void setWebpageChromeClient(fl flVar) {
        if (!this.f7565i) {
            super.setWebpageChromeClient(flVar);
        }
    }

    public final boolean performLongClick() {
        return true;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
    }

    /* renamed from: f */
    public void mo1821f() {
        this.f7565i = true;
        super.mo1821f();
    }

    protected void onAttachedToWindow() {
        C0559f.m2476b().m2481a(this.f7560d);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        C0559f.m2476b().m2483b(this.f7560d);
        super.onDetachedFromWindow();
        UIdleHandler.addIdleHandler(new C1366l(this));
    }

    /* renamed from: b */
    protected void mo1817b(String str) {
        super.mo1817b(str);
        if (this.f7562f.getRefreshState() == RefreshState.REFRESHING) {
            this.f7562f.setOnRefreshDone(new C1368m(this));
            this.f7562f.setRefreshState(RefreshState.REFRESH_DONE);
        }
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.f7562f.setRefreshStyle(refreshStyle);
    }

    /* renamed from: l */
    private void m10980l() {
        mo1818c();
    }

    /* renamed from: m */
    private boolean m10981m() {
        return this.f7562f.getVisibility() == 0;
    }
}
