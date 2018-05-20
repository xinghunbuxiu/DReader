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
    /* renamed from: a */
    private final C0393s f753a;
    /* renamed from: b */
    private int f754b;
    /* renamed from: c */
    private int f755c;
    /* renamed from: d */
    private int f756d;
    /* renamed from: e */
    private int f757e;

    public FrameScrollView(Context context) {
        this(context, null);
    }

    public FrameScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f754b = 0;
        this.f755c = 0;
        this.f756d = 0;
        this.f757e = 0;
        setWillNotDraw(false);
        this.f753a = m1062a();
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
    }

    public final int getContentWidth() {
        return this.f753a.getContentWidth();
    }

    public final int getContentHeight() {
        return this.f753a.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f753a.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f753a.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f753a.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f753a.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f753a.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f753a.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f753a.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f753a.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f753a.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f753a.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f753a.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f753a.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f753a.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f753a.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f753a.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f753a.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f753a.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f753a.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f753a.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f753a.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f753a.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f753a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f753a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f753a.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f753a.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f753a.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f753a.setScrollInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f753a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f753a.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f753a.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f753a.m1462N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f753a.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f753a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f753a.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f753a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f753a.MaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f753a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(OnContentBoundsChangedListener contentBoundsChangedListener) {
        this.f753a.setOnContentBoundsChangedListener(contentBoundsChangedListener);
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f753a.setOnScrollListener(onScrollListener);
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f753a.mo434a(i, i2, i3, runnable, runnable2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f753a.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f753a.onTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        this.f754b = i;
        this.f755c = i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.f756d = getMeasuredWidth();
        this.f757e = getMeasuredHeight();
        switch (mode) {
            case Integer.MIN_VALUE:
                size = Math.min(this.f756d, size);
                break;
            case 1073741824:
                break;
            default:
                size = this.f756d;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(this.f757e, size2);
                break;
            case 1073741824:
                break;
            default:
                size2 = this.f757e;
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f756d, 1073741824), MeasureSpec.makeMeasureSpec(this.f757e, 1073741824));
        setMeasuredDimension(size, size2);
        this.f753a.m1512b(this.f756d, this.f757e);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f753a.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f753a.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i + Math.max(this.f756d, i3 - i), i2 + Math.max(this.f757e, i4 - i2));
        this.f753a.m1504a(z, i, i2, i3, i4);
    }

    public void scrollBy(int i, int i2) {
        this.f753a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f753a.scrollTo(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f753a.mo529b(canvas);
        this.f753a.m1527c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f753a.shouldDelayChildPressedState();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f753a.m1520b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f753a.isHorizontalFadingEdgeEnabled();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f753a.isHorizontalScrollBarEnabled();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f753a.isVerticalFadingEdgeEnabled();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f753a.isVerticalScrollBarEnabled();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f753a.computeHorizontalScrollExtent();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f753a.computeHorizontalScrollOffset();
    }

    protected int computeHorizontalScrollRange() {
        return this.f753a.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return this.f753a.computeVerticalScrollExtent();
    }

    protected int computeVerticalScrollOffset() {
        return this.f753a.computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        return this.f753a.computeVerticalScrollRange();
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (view.getLayoutParams().width == -1) {
            i5 = this.f754b;
        } else {
            i5 = i;
        }
        if (view.getLayoutParams().height == -1) {
            i6 = this.f755c;
            i7 = 0;
        } else {
            i7 = i4;
            i6 = i3;
        }
        super.measureChildWithMargins(view, i5, 0, i6, i7);
    }

    /* renamed from: a */
    protected C0393s m1062a() {
        return new C0393s(this);
    }

    protected C0393s getScroller() {
        return this.f753a;
    }
}
