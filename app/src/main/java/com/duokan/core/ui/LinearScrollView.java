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
import android.widget.LinearLayout;

public class LinearScrollView extends LinearLayout implements Scrollable {
    
    private final bj f841a;
    
    private int f842b;
    
    private int f843c;
    
    private int f844d;
    
    private int f845e;

    public LinearScrollView(Context context) {
        this(context, null);
    }

    public LinearScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f842b = 0;
        this.f843c = 0;
        this.f844d = 0;
        this.f845e = 0;
        setWillNotDraw(false);
        setClipToPadding(false);
        setScrollContainer(true);
        this.f841a = mo1597e();
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
    }

    
    public boolean m1281b(View view, boolean z) {
        return this.f841a.m1522b(view, z);
    }

    public final int getContentWidth() {
        return this.f841a.m1561s();
    }

    public final int getContentHeight() {
        return this.f841a.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f841a.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f841a.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f841a.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f841a.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f841a.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f841a.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f841a.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f841a.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f841a.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f841a.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f841a.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f841a.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f841a.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f841a.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f841a.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f841a.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f841a.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f841a.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f841a.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f841a.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f841a.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f841a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f841a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f841a.m1458J();
    }

    public int getScrollFinalX() {
        return this.f841a.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f841a.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f841a.setScrollInterpolator(interpolator);
    }

    
    public void mo435a(View view, boolean z) {
        this.f841a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f841a.m1461M();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f841a.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f841a.m1462N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f841a.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f841a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f841a.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f841a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f841a.MaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f841a.getViewportBounds();
    }

    
    public final Rect m1276a() {
        return this.f841a.m1464P();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f841a.setOnContentBoundsChangedListener(cfVar);
    }

    public void setOnScrollListener(cg cgVar) {
        this.f841a.setOnScrollListener(cgVar);
    }

    
    public final boolean m1280b() {
        return this.f841a.m1465Q();
    }

    
    public final boolean m1282c() {
        return this.f841a.m1469U();
    }

    
    public final boolean m1283d() {
        return this.f841a.m1470V();
    }

    
    public final boolean m1279a(int i) {
        return this.f841a.m1544e(i);
    }

    
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f841a.mo434a(i, i2, i3, runnable, runnable2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f841a.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f841a.onTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        this.f842b = i;
        this.f843c = i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i6 = getOrientation() == 0 ? 0 : mode;
        if (i6 == 0) {
            i3 = 0;
        } else {
            i3 = size;
        }
        if (getOrientation() == 1) {
            i4 = 0;
        } else {
            i4 = mode2;
        }
        if (i4 != 0) {
            i5 = size2;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i3, i6), MeasureSpec.makeMeasureSpec(i5, i4));
        this.f844d = getMeasuredWidth();
        this.f845e = getMeasuredHeight();
        switch (mode) {
            case Integer.MIN_VALUE:
                size = Math.min(this.f844d, size);
                break;
            case 1073741824:
                break;
            default:
                size = this.f844d;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(this.f845e, size2);
                break;
            case 1073741824:
                break;
            default:
                size2 = this.f845e;
                break;
        }
        if (getOrientation() == 0 && mode != 0) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.f844d, 1073741824), i2);
        } else if (getOrientation() == 1 && mode2 != 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.f845e, 1073741824));
        }
        setMeasuredDimension(size, size2);
        this.f841a.m1512b(this.f844d, this.f845e);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f841a.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f841a.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getOrientation() == 0) {
            super.onLayout(z, i, i2, i + this.f844d, i4);
        } else {
            super.onLayout(z, i, i2, i3, i2 + this.f845e);
        }
        if (z) {
            if (getOrientation() == 0) {
                setMaxOverScrollHeight(0);
                setMaxOverScrollWidth(AnimUtils.getMaxOverScrollWidth(getContext()));
            } else {
                setMaxOverScrollWidth(0);
                setMaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(getContext()));
            }
        }
        this.f841a.m1504a(z, i, i2, i3, i4);
    }

    public void scrollBy(int i, int i2) {
        this.f841a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f841a.scrollTo(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f841a.mo529b(canvas);
        this.f841a.m1527c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f841a.shouldDelayChildPressedState();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f841a.m1520b(z);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f841a.m1505a(view, rect, z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f841a.isHorizontalFadingEdgeEnabled();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f841a.isHorizontalScrollBarEnabled();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f841a.isVerticalFadingEdgeEnabled();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f841a.isVerticalScrollBarEnabled();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f841a.computeHorizontalScrollExtent();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f841a.computeHorizontalScrollOffset();
    }

    protected int computeHorizontalScrollRange() {
        return this.f841a.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return this.f841a.computeVerticalScrollExtent();
    }

    protected int computeVerticalScrollOffset() {
        return this.f841a.computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        return this.f841a.computeVerticalScrollRange();
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (getOrientation() == 0 && view.getLayoutParams().width == -1) {
            i5 = this.f842b;
        } else {
            i5 = i;
        }
        if (getOrientation() == 1 && view.getLayoutParams().height == -1) {
            i6 = 0;
            i7 = this.f843c;
        } else {
            i6 = i4;
            i7 = i3;
        }
        super.measureChildWithMargins(view, i5, 0, i7, i6);
    }

    
    protected bj mo1597e() {
        return new bj(this);
    }
}
