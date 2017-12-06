package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class FrameScrollView extends FrameLayout implements Scrollable {
    private final s a;
    private int b;
    private int c;
    private int d;
    private int e;

    public FrameScrollView(Context context) {
        this(context, null);
    }

    public FrameScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        setWillNotDraw(false);
        this.a = a();
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
    }

    public final int getContentWidth() {
        return this.a.s();
    }

    public final int getContentHeight() {
        return this.a.t();
    }

    public boolean getThumbEnabled() {
        return this.a.u();
    }

    public void setThumbEnabled(boolean z) {
        this.a.c(z);
    }

    public boolean getSeekEnabled() {
        return this.a.v();
    }

    public void setSeekEnabled(boolean z) {
        this.a.d(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.a.w();
    }

    public int getHorizontalThumbMarginTop() {
        return this.a.x();
    }

    public int getHorizontalThumbMarginRight() {
        return this.a.y();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.a.z();
    }

    public int getVerticalThumbMarginLeft() {
        return this.a.A();
    }

    public int getVerticalThumbMarginTop() {
        return this.a.B();
    }

    public int getVerticalThumbMarginRight() {
        return this.a.C();
    }

    public int getVerticalThumbMarginBottom() {
        return this.a.D();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.a.E();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.a.a(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.a.F();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.a.b(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.a.G();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.a.c(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.a.H();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.a.d(drawable);
    }

    public et getScrollDetector() {
        return this.a.I();
    }

    public final ScrollState getScrollState() {
        return this.a.getScrollState();
    }

    public final int getIdleTime() {
        return this.a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.a.J();
    }

    public int getScrollFinalX() {
        return this.a.K();
    }

    public int getScrollFinalY() {
        return this.a.L();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.a.a(interpolator);
    }

    public void a(View view, boolean z) {
        this.a.a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.a.M();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.a.a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.a.N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.a.b(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.a.O();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.a.c(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.a.d(i);
    }

    public final Rect getViewportBounds() {
        return this.a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.a.a(cfVar);
    }

    public final void setOnScrollListener(OnScrollListener cgVar) {
        this.a.a(cgVar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.c(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        this.b = i;
        this.c = i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.d = getMeasuredWidth();
        this.e = getMeasuredHeight();
        switch (mode) {
            case Integer.MIN_VALUE:
                size = Math.min(this.d, size);
                break;
            case 1073741824:
                break;
            default:
                size = this.d;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(this.e, size2);
                break;
            case 1073741824:
                break;
            default:
                size2 = this.e;
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.d, 1073741824), MeasureSpec.makeMeasureSpec(this.e, 1073741824));
        setMeasuredDimension(size, size2);
        this.a.b(this.d, this.e);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i + Math.max(this.d, i3 - i), i2 + Math.max(this.e, i4 - i2));
        this.a.a(z, i, i2, i3, i4);
    }

    public void scrollBy(int i, int i2) {
        this.a.c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.a.d(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.a.b(canvas);
        this.a.c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.a.l();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.a.b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.a.g();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.a.h();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.a.i();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.a.j();
    }

    protected int computeHorizontalScrollExtent() {
        return this.a.m();
    }

    protected int computeHorizontalScrollOffset() {
        return this.a.n();
    }

    protected int computeHorizontalScrollRange() {
        return this.a.o();
    }

    protected int computeVerticalScrollExtent() {
        return this.a.p();
    }

    protected int computeVerticalScrollOffset() {
        return this.a.q();
    }

    protected int computeVerticalScrollRange() {
        return this.a.r();
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (view.getLayoutParams().width == -1) {
            i5 = this.b;
        } else {
            i5 = i;
        }
        if (view.getLayoutParams().height == -1) {
            i6 = this.c;
            i7 = 0;
        } else {
            i7 = i4;
            i6 = i3;
        }
        super.measureChildWithMargins(view, i5, 0, i6, i7);
    }

    protected s a() {
        return new s(this);
    }

    protected s getScroller() {
        return this.a;
    }
}
