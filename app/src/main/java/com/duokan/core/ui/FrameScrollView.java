package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.Scrollable.ScrollState;

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
        return this.f753a.m1561s();
    }

    public final int getContentHeight() {
        return this.f753a.m1562t();
    }

    public boolean getThumbEnabled() {
        return this.f753a.m1563u();
    }

    public void setThumbEnabled(boolean z) {
        this.f753a.m1530c(z);
    }

    public boolean getSeekEnabled() {
        return this.f753a.m1564v();
    }

    public void setSeekEnabled(boolean z) {
        this.f753a.m1538d(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f753a.m1565w();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f753a.m1566x();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f753a.m1567y();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f753a.m1568z();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f753a.m1449A();
    }

    public int getVerticalThumbMarginTop() {
        return this.f753a.m1450B();
    }

    public int getVerticalThumbMarginRight() {
        return this.f753a.m1451C();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f753a.m1452D();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f753a.m1453E();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f753a.m1493a(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f753a.m1454F();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f753a.m1517b(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f753a.m1455G();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f753a.m1529c(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f753a.m1456H();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f753a.m1537d(drawable);
    }

    public et getScrollDetector() {
        return this.f753a.m1457I();
    }

    public final ScrollState getScrollState() {
        return this.f753a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f753a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f753a.m1458J();
    }

    public int getScrollFinalX() {
        return this.f753a.m1459K();
    }

    public int getScrollFinalY() {
        return this.f753a.m1460L();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f753a.m1496a(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f753a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f753a.m1461M();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f753a.m1497a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f753a.m1462N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f753a.m1518b(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f753a.m1463O();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f753a.m1525c(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f753a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f753a.m1534d(i);
    }

    public final Rect getViewportBounds() {
        return this.f753a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f753a.m1501a(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.f753a.m1502a(cgVar);
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f753a.mo434a(i, i2, i3, runnable, runnable2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f753a.mo2419b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f753a.mo2420c(motionEvent);
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
        this.f753a.m1523c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f753a.m1532d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i + Math.max(this.f756d, i3 - i), i2 + Math.max(this.f757e, i4 - i2));
        this.f753a.m1504a(z, i, i2, i3, i4);
    }

    public void scrollBy(int i, int i2) {
        this.f753a.m1526c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f753a.m1535d(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f753a.mo529b(canvas);
        this.f753a.m1527c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f753a.m1554l();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f753a.m1520b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f753a.m1548g();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f753a.m1550h();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f753a.m1551i();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f753a.m1552j();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f753a.m1555m();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f753a.m1556n();
    }

    protected int computeHorizontalScrollRange() {
        return this.f753a.m1557o();
    }

    protected int computeVerticalScrollExtent() {
        return this.f753a.m1558p();
    }

    protected int computeVerticalScrollOffset() {
        return this.f753a.m1559q();
    }

    protected int computeVerticalScrollRange() {
        return this.f753a.m1560r();
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
