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
    /* renamed from: a */
    protected final fz f1261a = m2124h();
    /* renamed from: b */
    private final fv f1262b = mo1744a(this.f1261a);
    /* renamed from: c */
    private fq f1263c = null;
    /* renamed from: d */
    private fl f1264d = null;
    /* renamed from: e */
    private String f1265e = "";
    /* renamed from: f */
    private boolean f1266f = false;
    /* renamed from: g */
    private int f1267g = 0;
    /* renamed from: h */
    private long f1268h = TimeUnit.SECONDS.toMillis(30);
    /* renamed from: i */
    private Runnable f1269i = null;
    /* renamed from: j */
    private Runnable f1270j = null;
    /* renamed from: k */
    private boolean f1271k = false;
    /* renamed from: l */
    private boolean f1272l = false;

    public fr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(this.f1261a, new LayoutParams(-1, -1));
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
        return this.f1262b.m1561s();
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
        return this.f1262b.m1458J();
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

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f1262b.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f1262b.m1461M();
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

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f1262b.setOnContentBoundsChangedListener(cfVar);
    }

    public void setOnScrollListener(cg cgVar) {
        this.f1262b.setOnScrollListener(cgVar);
    }

    public void scrollTo(int i, int i2) {
        this.f1262b.scrollTo(i, i2);
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f1262b.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: a */
    public void m2110a() {
        this.f1262b.m1474Z();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1262b.m1520b(z);
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.f1261a.setBackgroundColor(i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate((float) (-this.f1261a.getScrollX()), (float) (-this.f1261a.getScrollY()));
        this.f1262b.m1527c(canvas);
        canvas.translate((float) this.f1261a.getScrollX(), (float) this.f1261a.getScrollY());
        if (this.f1261a.isDirty()) {
            invalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.f1261a.measure(i, i2);
        setMeasuredDimension(this.f1261a.getMeasuredWidth(), this.f1261a.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1261a.layout(0, 0, i3 - i, i4 - i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f1261a);
        boolean c = this.f1262b.onTouchEvent(a);
        a.recycle();
        return c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, this.f1261a);
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
        return this.f1265e;
    }

    /* renamed from: b */
    public boolean m2118b() {
        return this.f1266f;
    }

    public int getLoadingError() {
        return this.f1267g;
    }

    public long getLoadingTimeout() {
        return this.f1268h;
    }

    public void setLoadingTimout(long j) {
        this.f1268h = j;
    }

    /* renamed from: a */
    public void mo1815a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1261a.loadUrl(str);
        }
    }

    public fq getWebpageClient() {
        return this.f1263c;
    }

    public void setWebpageClient(fq fqVar) {
        this.f1263c = fqVar;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.f1261a.setDownloadListener(downloadListener);
    }

    public void setWebpageChromeClient(fl flVar) {
        this.f1264d = flVar;
    }

    /* renamed from: a */
    public void mo1814a(Object obj, String str) {
        this.f1261a.addJavascriptInterface(obj, str);
    }

    public WebSettings getSettings() {
        return this.f1261a.getSettings();
    }

    /* renamed from: c */
    public void mo1818c() {
        this.f1261a.reload();
    }

    /* renamed from: d */
    public boolean mo1819d() {
        return this.f1261a.canGoBack();
    }

    /* renamed from: a */
    public void mo1813a(int i) {
        this.f1261a.goBackOrForward(i);
    }

    /* renamed from: e */
    public WebBackForwardList mo1820e() {
        return this.f1261a.copyBackForwardList();
    }

    /* renamed from: f */
    public void mo1821f() {
        this.f1261a.destroy();
        this.f1269i = null;
    }

    /* renamed from: g */
    public void m2123g() {
        this.f1261a.clearHistory();
    }

    @TargetApi(19)
    public static void setWebContentsDebuggingEnabled(boolean z) {
        fz.setWebContentsDebuggingEnabled(z);
    }

    /* renamed from: a */
    protected void m2116a(String str, Bitmap bitmap) {
    }

    /* renamed from: b */
    protected void mo1817b(String str) {
    }

    /* renamed from: a */
    protected fv mo1744a(fz fzVar) {
        return new fv(this, fzVar);
    }

    /* renamed from: h */
    protected fz m2124h() {
        return new fz(this, getContext());
    }
}
