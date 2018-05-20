package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;

import java.util.concurrent.TimeUnit;

public class fr extends ViewGroup implements Scrollable {
    
    protected final DkWebView dkWebView = getWebView();
    
    private final fv f1262b = mo1744a(this.dkWebView);
    
    private WebPageClient webPageClient = null;
    
    private WebPageChromeClient webPageChromeClient = null;
    
    private String currentUrl = "";
    
    private boolean f1266f = false;
    
    private int f1267g = 0;
    
    private long loadingTimeout = TimeUnit.SECONDS.toMillis(30);
    
    private Runnable f1269i = null;
    
    private Runnable f1270j = null;
    
    private boolean f1271k = false;
    
    private boolean f1272l = false;

    public fr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(this.dkWebView, new LayoutParams(-1, -1));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f1262b.setThumbEnabled(true);
        this.f1262b.MaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(getContext()));
    }

    public final int getContentWidth() {
        return this.f1262b.getContentWidth();
    }

    public final int getContentHeight() {
        return this.f1262b.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f1262b.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f1262b.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f1262b.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f1262b.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f1262b.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f1262b.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f1262b.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f1262b.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f1262b.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f1262b.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f1262b.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f1262b.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f1262b.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f1262b.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f1262b.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f1262b.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f1262b.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f1262b.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f1262b.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f1262b.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f1262b.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f1262b.getScrollState();
    }

    public final int getIdleTime() {
        return this.f1262b.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f1262b.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f1262b.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f1262b.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f1262b.setScrollInterpolator(interpolator);
    }

    
    public void mo435a(View view, boolean z) {
        this.f1262b.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f1262b.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f1262b.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f1262b.m1462N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f1262b.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f1262b.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f1262b.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f1262b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f1262b.MaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f1262b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(OnContentBoundsChangedListener contentBoundsChangedListener) {
        this.f1262b.setOnContentBoundsChangedListener(contentBoundsChangedListener);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f1262b.setOnScrollListener(onScrollListener);
    }

    public void scrollTo(int i, int i2) {
        this.f1262b.scrollTo(i, i2);
    }

    
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f1262b.mo434a(i, i2, i3, runnable, runnable2);
    }

    
    public void m2110a() {
        this.f1262b.m1474Z();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1262b.m1520b(z);
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.dkWebView.setBackgroundColor(i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate((float) (-this.dkWebView.getScrollX()), (float) (-this.dkWebView.getScrollY()));
        this.f1262b.m1527c(canvas);
        canvas.translate((float) this.dkWebView.getScrollX(), (float) this.dkWebView.getScrollY());
        if (this.dkWebView.isDirty()) {
            invalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.dkWebView.measure(i, i2);
        setMeasuredDimension(this.dkWebView.getMeasuredWidth(), this.dkWebView.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.dkWebView.layout(0, 0, i3 - i, i4 - i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.dkWebView);
        boolean c = this.f1262b.onTouchEvent(a);
        a.recycle();
        return c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.dkWebView);
        boolean b = this.f1262b.onInterceptTouchEvent(a);
        a.recycle();
        return b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1262b.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1262b.onDetachedFromWindow();
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    
    public boolean m2118b() {
        return this.f1266f;
    }

    public int getLoadingError() {
        return this.f1267g;
    }

    public long getLoadingTimeout() {
        return this.loadingTimeout;
    }

    public void setLoadingTimout(long j) {
        this.loadingTimeout = j;
    }

    
    public void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dkWebView.loadUrl(str);
        }
    }

    public WebPageClient getWebpageClient() {
        return this.webPageClient;
    }

    public void setWebpageClient(WebPageClient webPageClient) {
        this.webPageClient = webPageClient;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.dkWebView.setDownloadListener(downloadListener);
    }

    public void setWebpageChromeClient(WebPageChromeClient webPageChromeClient) {
        this.webPageChromeClient = webPageChromeClient;
    }

    
    public void addJavascriptInterface(Object obj, String str) {
        this.dkWebView.addJavascriptInterface(obj, str);
    }

    public WebSettings getSettings() {
        return this.dkWebView.getSettings();
    }

    
    public void reload() {
        this.dkWebView.reload();
    }

    
    public boolean canGoBack() {
        return this.dkWebView.canGoBack();
    }

    
    public void goBackOrForward(int i) {
        this.dkWebView.goBackOrForward(i);
    }

    
    public WebBackForwardList copyBackForwardList() {
        return this.dkWebView.copyBackForwardList();
    }

    
    public void destroy() {
        this.dkWebView.destroy();
        this.f1269i = null;
    }

    
    public void clearHistory() {
        this.dkWebView.clearHistory();
    }

    @TargetApi(19)
    public static void setWebContentsDebuggingEnabled(boolean z) {
        DkWebView.setWebContentsDebuggingEnabled(z);
    }

    
    protected void m2116a(String str, Bitmap bitmap) {
    }

    
    protected void mo1817b(String str) {
    }

    
    protected fv mo1744a(DkWebView webView) {
        return new fv(this, webView);
    }

    
    protected DkWebView getWebView() {
        return new DkWebView(this, getContext());
    }
}
