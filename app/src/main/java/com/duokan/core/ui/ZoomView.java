package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

public class ZoomView extends ViewGroup implements Scrollable, fk {
    static final /* synthetic */ boolean a = (!ZoomView.class.desiredAssertionStatus());
    private final gf b;
    private final Matrix c;
    private int d;
    private int e;
    private ZoomState f;
    private float g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private gg l;
    private View m;
    private boolean n;
    private ge o;
    private OverScrollMode p;
    private OverScrollMode q;

    public enum ZoomState {
        IDLE,
        PINCH,
        SMOOTH
    }

    public ZoomView(Context context) {
        this(context, null);
    }

    public ZoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Matrix();
        this.d = 0;
        this.e = 0;
        this.f = ZoomState.IDLE;
        this.g = 1.0f;
        this.h = 1.0f;
        this.i = 10.0f;
        this.j = 0.0f;
        this.k = true;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = null;
        setWillNotDraw(false);
        this.b = c();
        this.b.I().a(new gh());
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
        setMaxOverScrollWidth(UTools.defaultClose(context));
        setMaxOverScrollHeight(UTools.g(context));
    }

    public final ZoomState getZoomState() {
        return this.f;
    }

    public final float getZoomFactor() {
        return this.g;
    }

    public final float getMinZoomFactor() {
        return this.h;
    }

    public final void setMinZoomFactor(float f) {
        this.h = f;
        l_();
    }

    public final float getMaxZoomFactor() {
        return this.i;
    }

    public final void setMaxZoomFactor(float f) {
        this.i = f;
        l_();
    }

    public final float getZoomAngle() {
        return this.j;
    }

    public final boolean getRotateEnabled() {
        return this.k;
    }

    public final void setRotateEnabled(boolean z) {
        this.k = z;
    }

    public ge getOnZoomListener() {
        return this.o;
    }

    public void setOnZoomListener(ge geVar) {
        this.o = geVar;
    }

    public final void a(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        a(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }

    public final void a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (e() != null) {
            b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }

    public final void a(float f, float f2, float f3) {
        a(f, f2, f3, getZoomAngle());
    }

    public final void a(float f, float f2, float f3, float f4) {
        b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
    }

    public final void b(float f, float f2, float f3) {
        b(f, f2, f3, getZoomAngle());
    }

    public final void b(float f, float f2, float f3, float f4) {
        if (e() != null) {
            a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
        }
    }

    public final void b(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        b(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }

    public final void b(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (e() != null) {
            a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }

    public Matrix c(View view) {
        return this.c;
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
        return this.p;
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.p = overScrollMode;
        this.b.a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.q;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.q = overScrollMode;
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

    public final void setOnScrollListener(cg cgVar) {
        this.b.a(cgVar);
    }

    public void a(int i, int i2) {
        this.b.e(i, i2);
    }

    public void l_() {
        View e = e();
        if (e != null) {
            PointF pointF = (PointF) UTools.f.getRect();
            pointF.set(((float) getScrollX()) + (((float) getWidth()) / 2.0f), ((float) getScrollY()) + (((float) getHeight()) / 2.0f));
            UTools.addAnimation(pointF, (View) this, e);
            PointF pointF2 = (PointF) UTools.f.getRect();
            pointF2.set(pointF);
            UTools.addAnimation(pointF2, e, (View) this);
            pointF2.offset((float) (-getScrollX()), (float) (-getScrollY()));
            float[] d = d(pointF.x, pointF.y, pointF2.x, pointF2.y, getZoomFactor(), getZoomAngle());
            b(d[0], d[1], d[2], d[3], d[4], d[5]);
            UTools.f.getRect(pointF);
            UTools.f.getRect(pointF2);
        }
    }

    public void m_() {
        View e = e();
        if (e != null) {
            PointF pointF = (PointF) UTools.f.getRect();
            pointF.set(((float) getScrollX()) + (((float) getWidth()) / 2.0f), ((float) getScrollY()) + (((float) getHeight()) / 2.0f));
            UTools.addAnimation(pointF, (View) this, e);
            PointF pointF2 = (PointF) UTools.f.getRect();
            pointF2.set(pointF);
            UTools.addAnimation(pointF2, e, (View) this);
            pointF2.offset((float) (-getScrollX()), (float) (-getScrollY()));
            float[] d = d(pointF.x, pointF.y, pointF2.x, pointF2.y, getZoomFactor(), getZoomAngle());
            b(d[0], d[1], d[2], d[3], d[4], d[5], null, null);
            UTools.f.getRect(pointF);
            UTools.f.getRect(pointF2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b.b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.b.c(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        View e = e();
        if (e != null) {
            LayoutParams layoutParams = e.getLayoutParams();
            int childMeasureSpec = getChildMeasureSpec(layoutParams.width == -1 ? i : 0, paddingRight, layoutParams.width);
            if (layoutParams.height == -1) {
                i3 = i2;
            }
            e.measure(childMeasureSpec, getChildMeasureSpec(i3, paddingBottom, layoutParams.height));
            this.d = e.getMeasuredWidth();
            this.e = e.getMeasuredHeight();
        } else {
            this.d = 0;
            this.e = 0;
        }
        setMeasuredDimension(resolveSize(this.d + paddingRight, i), resolveSize(this.e + paddingBottom, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i4 - i2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max = Math.max(i3 - i, this.d + paddingLeft);
        i5 = Math.max(i5, this.e + paddingTop);
        View e = e();
        if (e != null) {
            max = (((max - paddingLeft) - this.d) / 2) + getPaddingLeft();
            i5 = (((i5 - paddingTop) - this.e) / 2) + getPaddingTop();
            e.layout(max, i5, e.getMeasuredWidth() + max, e.getMeasuredHeight() + i5);
        }
        Rect rect = (Rect) UTools.g.getRect();
        Point point = (Point) UTools.e.getRect();
        a(rect, point, 0.0f, 0.0f, 0.0f, 0.0f, this.g, this.j);
        this.b.a(rect);
        UTools.g.getRect(rect);
        UTools.e.getRect(point);
        this.b.a(z, i, i2, i3, i4);
        l_();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.d();
    }

    public void scrollBy(int i, int i2) {
        this.b.c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.b.d(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.b.b(canvas);
        this.b.c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.b.l();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.n = z;
        super.requestDisallowInterceptTouchEvent(z);
        this.b.b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.b.g();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.b.h();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.b.i();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.b.j();
    }

    protected int computeHorizontalScrollExtent() {
        return this.b.m();
    }

    protected int computeHorizontalScrollOffset() {
        return this.b.n();
    }

    protected int computeHorizontalScrollRange() {
        return this.b.o();
    }

    protected int computeVerticalScrollExtent() {
        return this.b.p();
    }

    protected int computeVerticalScrollOffset() {
        return this.b.q();
    }

    protected int computeVerticalScrollRange() {
        return this.b.r();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.translate((float) view.getLeft(), (float) view.getTop());
        canvas.concat(this.c);
        canvas.translate((float) (-view.getLeft()), (float) (-view.getTop()));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    @TargetApi(12)
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean a;
        if (motionEvent.getActionMasked() == 0) {
            this.n = false;
        }
        if ((motionEvent.getActionMasked() == 0 || this.m != null) && !this.n && onInterceptTouchEvent(motionEvent) && this.m != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            if (VERSION.SDK_INT >= 12) {
                obtain.setSource(4098);
            }
            this.m.dispatchTouchEvent(obtain);
            this.m = null;
        }
        if (motionEvent.getActionMasked() == 0) {
            PointF pointF = (PointF) UTools.f.getRect();
            RectF rectF = (RectF) UTools.h.getRect();
            this.m = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                pointF.set(((float) getScrollX()) + motionEvent.getX(), ((float) getScrollY()) + motionEvent.getY());
                rectF.set((float) childAt.getScrollX(), (float) childAt.getScrollY(), (float) (childAt.getScrollX() + childAt.getWidth()), (float) (childAt.getScrollY() + childAt.getHeight()));
                UTools.addAnimation(pointF, (View) this, childAt);
                if (rectF.contains(pointF.x, pointF.y) && a(childAt, motionEvent)) {
                    this.m = childAt;
                    break;
                }
            }
            UTools.f.getRect(pointF);
            UTools.h.getRect(rectF);
            if (this.m != null) {
                return true;
            }
        }
        if (this.m != null) {
            a = a(this.m, motionEvent);
        } else {
            a = onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() != 3) {
            return a;
        }
        this.m = null;
        return a;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, view);
        boolean dispatchTouchEvent = view.dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }

    private void a(float f, float f2, float f3, float f4, float f5, float f6) {
        float[] d = d(f, f2, f3, f4, f5, f6);
        b(d[0], d[1], d[2], d[3], d[4], d[5]);
    }

    private void a(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        float[] d = d(f, f2, f3, f4, f5, f6);
        b(d[0], d[1], d[2], d[3], d[4], d[5], runnable, runnable2);
    }

    private void b(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = e();
        if (e != null) {
            if (this.l != null) {
                this.l.b();
            }
            if (a || this.l == null) {
                a(ZoomState.IDLE);
                a(e, f, f2, f3, f4, f5, f6);
                return;
            }
            throw new AssertionError();
        }
    }

    private void b(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        if (e() != null) {
            if (this.l != null) {
                this.l.b();
            }
            if (a || this.l == null) {
                a(ZoomState.SMOOTH);
                this.l = new gg(this, f, f2, f3, f4, f5, f6, new gc(this, runnable), new gd(this, runnable2));
                this.l.a();
                return;
            }
            throw new AssertionError();
        }
    }

    private void c(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = e();
        if (e != null) {
            if (this.l != null) {
                this.l.b();
            }
            if (a || this.l == null) {
                a(ZoomState.PINCH);
                a(e, f, f2, f3, f4, f5, f6);
                return;
            }
            throw new AssertionError();
        }
    }

    private void a(View view, float f, float f2, float f3, float f4, float f5, float f6) {
        this.g = f5;
        this.j = f6;
        this.c.reset();
        this.c.preTranslate((float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
        this.c.preScale(this.g, this.g);
        this.c.preRotate(-this.j);
        this.c.preTranslate((float) ((-view.getWidth()) / 2), (float) ((-view.getHeight()) / 2));
        Rect rect = (Rect) UTools.g.getRect();
        Point point = (Point) UTools.e.getRect();
        a(rect, point, f, f2, f3, f4, f5, f6);
        this.b.a(rect);
        this.b.e(point.x, point.y);
        UTools.g.getRect(rect);
        UTools.e.getRect(point);
        invalidate();
        d();
    }

    private float[] d(float f, float f2, float f3, float f4, float f5, float f6) {
        if (e() == null) {
            return new float[]{f, f2, f3, f4, f5, f6};
        }
        Rect rect = (Rect) UTools.g.getRect();
        Point point = (Point) UTools.e.getRect();
        a(rect, point, f, f2, f3, f4, Math.min(Math.max(getMinZoomFactor(), f5), getMaxZoomFactor()), 0.0f);
        Point point2 = (Point) UTools.e.getRect();
        point2.x = Math.min(Math.max(rect.left, point.x), rect.right - getWidth());
        point2.y = Math.min(Math.max(rect.top, point.y), rect.bottom - getHeight());
        float[] fArr = new float[]{f, f2, f3 - ((float) (point2.x - point.x)), f4 - ((float) (point2.y - point.y)), r7, 0.0f};
        UTools.e.getRect(point2);
        UTools.e.getRect(point);
        UTools.g.getRect(rect);
        return fArr;
    }

    private void a(Rect rect, Point point, float f, float f2, float f3, float f4, float f5, float f6) {
        View e = e();
        if (e == null) {
            rect.set(0, 0, getWidth(), getHeight());
            point.set(0, 0);
            return;
        }
        Matrix matrix = (Matrix) UTools.d.getRect();
        a(matrix, f5, f6);
        rect.set(e.getScrollX(), e.getScrollY(), e.getScrollX() + e.getWidth(), e.getScrollY() + e.getHeight());
        UTools.addAnimation(matrix, rect);
        rect.left -= getPaddingLeft();
        rect.top -= getPaddingTop();
        rect.right += getPaddingRight();
        rect.bottom += getPaddingBottom();
        int width = getWidth();
        int height = getHeight();
        if (rect.width() < width) {
            rect.left = ((e.getLeft() + e.getRight()) - width) / 2;
            rect.right = (width + (e.getLeft() + e.getRight())) / 2;
        }
        if (rect.height() < height) {
            rect.top = ((e.getTop() + e.getBottom()) - height) / 2;
            rect.bottom = ((e.getBottom() + e.getTop()) + height) / 2;
        }
        PointF pointF = (PointF) UTools.f.getRect();
        pointF.set(f, f2);
        UTools.addAnimation(matrix, pointF);
        pointF.offset(-f3, -f4);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        UTools.d.getRect(matrix);
        UTools.f.getRect(pointF);
    }

    @TargetApi(11)
    private void a(Matrix matrix, float f, float f2) {
        View e = e();
        if (e != null) {
            matrix.reset();
            matrix.preTranslate((float) e.getLeft(), (float) e.getTop());
            matrix.preTranslate((float) (e.getWidth() / 2), (float) (e.getHeight() / 2));
            matrix.preScale(f, f);
            matrix.preRotate(-f2);
            matrix.preTranslate((float) ((-e.getWidth()) / 2), (float) ((-e.getHeight()) / 2));
            if (VERSION.SDK_INT >= 11) {
                matrix.preConcat(e.getMatrix());
            }
            matrix.preTranslate((float) (-e.getScrollX()), (float) (-e.getScrollY()));
        }
    }

    private void a(ZoomState zoomState) {
        if (this.f != zoomState) {
            ZoomState zoomState2 = this.f;
            this.f = zoomState;
            a(zoomState2, this.f);
        }
    }

    private void a(ZoomState zoomState, ZoomState zoomState2) {
        if (this.o != null) {
            this.o.a(this, zoomState, zoomState2);
        }
    }

    private void d() {
        if (this.o != null) {
            this.o.a(this);
        }
    }

    private View e() {
        return getChildCount() < 1 ? null : getChildAt(0);
    }

    protected gf c() {
        return new gf(this);
    }
}
