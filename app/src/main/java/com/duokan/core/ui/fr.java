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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;

import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.Scrollable.ScrollState;

import java.util.concurrent.TimeUnit;

public class fr extends ViewGroup implements Scrollable {
    protected final fx a = h();
    private final ft b = a(this.a);
    private fq c = null;
    private fl d = null;
    private String e = "";
    private boolean f = false;
    private int g = 0;
    private long h = TimeUnit.SECONDS.toMillis(30);
    private Runnable i = null;
    private Runnable j = null;
    private boolean k = false;
    private boolean l = false;

    public fr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(this.a, new LayoutParams(-1, -1));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.b.c(true);
        this.b.d(dv.g(getContext()));
    }

    public final int getContentWidth() {
        return this.b.s();
    }

    public final int getContentHeight() {
        return this.b.t();
    }

    public boolean getThumbEnabled() {
        return this.b.u();
    }

    public void setThumbEnabled(boolean z) {
        this.b.c(z);
    }

    public boolean getSeekEnabled() {
        return this.b.v();
    }

    public void setSeekEnabled(boolean z) {
        this.b.d(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.b.w();
    }

    public int getHorizontalThumbMarginTop() {
        return this.b.x();
    }

    public int getHorizontalThumbMarginRight() {
        return this.b.y();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.b.z();
    }

    public int getVerticalThumbMarginLeft() {
        return this.b.A();
    }

    public int getVerticalThumbMarginTop() {
        return this.b.B();
    }

    public int getVerticalThumbMarginRight() {
        return this.b.C();
    }

    public int getVerticalThumbMarginBottom() {
        return this.b.D();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.b.E();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.b.a(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.b.F();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.b.b(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.b.G();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.b.c(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.b.H();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.b.d(drawable);
    }

    public et getScrollDetector() {
        return this.b.I();
    }

    public final ScrollState getScrollState() {
        return this.b.getScrollState();
    }

    public final int getIdleTime() {
        return this.b.getIdleTime();
    }

    public final int getScrollTime() {
        return this.b.J();
    }

    public int getScrollFinalX() {
        return this.b.K();
    }

    public int getScrollFinalY() {
        return this.b.L();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.b.a(interpolator);
    }

    public void a(View view, boolean z) {
        this.b.a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.b.M();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.b.a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.b.N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.b.b(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.b.O();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.b.c(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.b.d(i);
    }

    public final Rect getViewportBounds() {
        return this.b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.b.a(cfVar);
    }

    public void setOnScrollListener(cg cgVar) {
        this.b.a(cgVar);
    }

    public void scrollTo(int i, int i2) {
        this.b.d(i, i2);
    }

    public final void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.b.a(i, i2, i3, runnable, runnable2);
    }

    public void a() {
        this.b.Z();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.b.b(z);
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.a.setBackgroundColor(i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate((float) (-this.a.getScrollX()), (float) (-this.a.getScrollY()));
        this.b.c(canvas);
        canvas.translate((float) this.a.getScrollX(), (float) this.a.getScrollY());
        if (this.a.isDirty()) {
            invalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.a.measure(i, i2);
        setMeasuredDimension(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, i3 - i, i4 - i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.a(motionEvent, (View) this, this.a);
        boolean c = this.b.c(a);
        a.recycle();
        return c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent a = dv.a(motionEvent, (View) this, this.a);
        boolean b = this.b.b(a);
        a.recycle();
        return b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.d();
    }

    public String getCurrentUrl() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public int getLoadingError() {
        return this.g;
    }

    public long getLoadingTimeout() {
        return this.h;
    }

    public void setLoadingTimout(long j) {
        this.h = j;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.loadUrl(str);
        }
    }

    public fq getWebpageClient() {
        return this.c;
    }

    public void setWebpageClient(fq fqVar) {
        this.c = fqVar;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.a.setDownloadListener(downloadListener);
    }

    public void setWebpageChromeClient(fl flVar) {
        this.d = flVar;
    }

    public void a(Object obj, String str) {
        this.a.addJavascriptInterface(obj, str);
    }

    public WebSettings getSettings() {
        return this.a.getSettings();
    }

    public void c() {
        this.a.reload();
    }

    public boolean d() {
        return this.a.canGoBack();
    }

    public void a(int i) {
        this.a.goBackOrForward(i);
    }

    public WebBackForwardList e() {
        return this.a.copyBackForwardList();
    }

    public void f() {
        this.a.destroy();
        this.i = null;
    }

    public void g() {
        this.a.clearHistory();
    }

    @TargetApi(19)
    public static void setWebContentsDebuggingEnabled(boolean z) {
        fx.setWebContentsDebuggingEnabled(z);
    }

    protected void a(String str, Bitmap bitmap) {
    }

    protected void b(String str) {
    }

    protected ft a(fx fxVar) {
        return new ft(this, fxVar);
    }

    protected fx h() {
        return new fx(this, getContext());
    }
}
