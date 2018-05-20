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
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.WebPageChromeClient;
import com.duokan.core.ui.WebPageClient;
import com.duokan.core.ui.fr;
import com.duokan.core.ui.fv;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.WebView;
import com.duokan.reader.ui.general.jg;

public class DkWebView extends WebView {
    
    public static final String TAG = DkWebView.class.getName();
    
    private final WebSettings webSettings;
    
    private final C0563j f7560d = new C1360h(this);
    
    private final LinearLayout f7561e;
    
    private final PullDownRefreshView pullDownRefreshView;
    
    private OnScrollListener onScrollListener = null;
    
    private C1365o f7564h = null;
    
    private boolean f7565i = false;

    
    protected  fv mo1744a(DkWebView webView) {
        return mo1816b(webView);
    }

    @SuppressLint({"NewApi"})
    public DkWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (DkApp.get().forCommunity()) {
            setLoadingTimout(0);
        }
        this.webSettings = getSettings();
        lr.m11294a(this.webSettings);
        super.setDownloadListener(new C1361i(this));
        if (VERSION.SDK_INT >= 11) {
            setLayerType(0, null);
        }
        if (VERSION.SDK_INT >= 19 && (DkApp.get().forCommunity() || !C0641o.m2934i().m2984k())) {
            fr.setWebContentsDebuggingEnabled(true);
        }
        this.f7561e = new LinearLayout(getContext());
        this.f7561e.setOrientation(1);
        this.pullDownRefreshView = new PullDownRefreshView(getContext());
        this.pullDownRefreshView.setPadding(0, ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop(), 0, 0);
        this.f7561e.addView(this.pullDownRefreshView, new LayoutParams(-1, -2));
        setPullDownHeaderView(this.f7561e);
        super.setOnScrollListener(new C1363j(this));
    }

    
    public boolean mo1822k() {
        return this.f7565i;
    }

    public void setPullDownRefreshEnabled(boolean z) {
        this.pullDownRefreshView.setVisibility(z ? 0 : 4);
    }

    public void setOnPullDownRefreshListener(C1365o c1365o) {
        this.f7564h = c1365o;
    }

    
    protected jg mo1816b(DkWebView webView) {
        return new C1369n(this, webView);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public OnScrollListener getOnScrollerListener() {
        return this.onScrollListener;
    }

    
    public boolean m10989c(String str) {
        if (this.f7565i) {
            return false;
        }
        loadUrl(str);
        return true;
    }

    
    public void loadUrl(String str) {
        C1163a.m8627k().m8641a(str);
        if (!this.f7565i) {
            super.loadUrl(str);
        }
    }

    
    public void reload() {
        if (!this.f7565i) {
            super.reload();
        }
    }

    
    public boolean canGoBack() {
        if (this.f7565i) {
            return false;
        }
        return super.canGoBack();
    }

    
    public void goBackOrForward(int i) {
        if (!this.f7565i) {
            super.goBackOrForward(i);
        }
    }

    
    public WebBackForwardList copyBackForwardList() {
        if (this.f7565i) {
            return null;
        }
        return super.copyBackForwardList();
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

    
    public void addJavascriptInterface(Object obj, String str) {
        if (!this.f7565i) {
            super.addJavascriptInterface(obj, str);
        }
    }

    public void setWebpageClient(WebPageClient webPageClient) {
        if (!this.f7565i) {
            super.setWebpageClient(webPageClient);
        }
    }

    public void setWebpageChromeClient(WebPageChromeClient webPageChromeClient) {
        if (!this.f7565i) {
            super.setWebpageChromeClient(webPageChromeClient);
        }
    }

    public final boolean performLongClick() {
        return true;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
    }

    
    public void destroy() {
        this.f7565i = true;
        super.destroy();
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

    
    protected void mo1817b(String str) {
        super.mo1817b(str);
        if (this.pullDownRefreshView.getRefreshState() == RefreshState.REFRESHING) {
            this.pullDownRefreshView.setOnRefreshDone(new C1368m(this));
            this.pullDownRefreshView.setRefreshState(RefreshState.REFRESH_DONE);
        }
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.pullDownRefreshView.setRefreshStyle(refreshStyle);
    }

    
    private void m10980l() {
        reload();
    }

    
    private boolean m10981m() {
        return this.pullDownRefreshView.getVisibility() == GONE;
    }
}
