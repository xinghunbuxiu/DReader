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

    static final boolean f869a = (!ZoomView.class.desiredAssertionStatus());
    
    private final gf f870b;

    private final Matrix matrix;

    private int width;

    private int height;

    private ZoomState zoomState;

    private float zoomFactor;

    private float minZoomFactor;

    private float maxZoomFactor;

    private float zoomAngle;

    private boolean rotateEnabled;
    
    private gg f880l;

    private View f881m;

    private boolean f882n;

    private OnZoomListener onZoomListener;

    private OverScrollMode scrollMode;

    private OverScrollMode scrollMode1;

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
        this.matrix = new Matrix();
        this.width = 0;
        this.height = 0;
        this.zoomState = ZoomState.IDLE;
        this.zoomFactor = 1.0f;
        this.minZoomFactor = 1.0f;
        this.maxZoomFactor = 10.0f;
        this.zoomAngle = 0.0f;
        this.rotateEnabled = true;
        this.f880l = null;
        this.f881m = null;
        this.f882n = false;
        this.onZoomListener = null;
        setWillNotDraw(false);
        this.f870b = m1362c();
        this.f870b.getScrollDetector().m2041a(new gh());
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
        setMaxOverScrollWidth(AnimUtils.getMaxOverScrollWidth(context));
        setMaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(context));
    }

    public final ZoomState getZoomState() {
        return this.zoomState;
    }

    public final float getZoomFactor() {
        return this.zoomFactor;
    }

    public final float getMinZoomFactor() {
        return this.minZoomFactor;
    }

    public final void setMinZoomFactor(float minZoomFactor) {
        this.minZoomFactor = minZoomFactor;
        m_();
    }

    public final float getMaxZoomFactor() {
        return this.maxZoomFactor;
    }

    public final void setMaxZoomFactor(float f) {
        this.maxZoomFactor = f;
        m_();
    }

    public final float getZoomAngle() {
        return this.zoomAngle;
    }

    public final boolean getRotateEnabled() {
        return this.rotateEnabled;
    }

    public final void setRotateEnabled(boolean z) {
        this.rotateEnabled = z;
    }

    public OnZoomListener getOnZoomListener() {
        return this.onZoomListener;
    }

    public void setOnZoomListener(OnZoomListener onZoomListener) {
        this.onZoomListener = onZoomListener;
    }


    public final void m1353a(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        m1352a(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }


    public final void m1352a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (getCurrentView() != null) {
            m1342b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }


    public final void m1350a(float f, float f2, float f3) {
        m1351a(f, f2, f3, getZoomAngle());
    }


    public final void m1351a(float f, float f2, float f3, float f4) {
        m1341b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
    }


    public final void m1357b(float f, float f2, float f3) {
        m1358b(f, f2, f3, getZoomAngle());
    }


    public final void m1358b(float f, float f2, float f3, float f4) {
        if (getCurrentView() != null) {
            m1327a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
        }
    }


    public final void m1360b(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        m1359b(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }


    public final void m1359b(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (getCurrentView() != null) {
            m1328a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }


    public Matrix mo475c(View view) {
        return this.matrix;
    }

    public final int getContentWidth() {
        return this.f870b.getContentWidth();
    }

    public final int getContentHeight() {
        return this.f870b.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f870b.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f870b.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f870b.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f870b.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f870b.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f870b.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f870b.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f870b.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f870b.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f870b.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f870b.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f870b.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f870b.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f870b.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f870b.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f870b.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f870b.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f870b.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f870b.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f870b.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f870b.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f870b.getScrollState();
    }

    public final int getIdleTime() {
        return this.f870b.getIdleTime();
    }

    public final int c() {
        return this.f870b.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f870b.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f870b.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f870b.setScrollInterpolator(interpolator);
    }


    public void mo435a(View view, boolean z) {
        this.f870b.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.scrollMode;
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.scrollMode = overScrollMode;
        this.f870b.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.scrollMode1;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.scrollMode1 = overScrollMode;
        this.f870b.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f870b.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f870b.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f870b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f870b.MaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f870b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(OnContentBoundsChangedListener contentBoundsChangedListener) {
        this.f870b.setOnContentBoundsChangedListener(contentBoundsChangedListener);
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f870b.setOnScrollListener(onScrollListener);
    }


    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f870b.mo434a(i, i2, i3, runnable, runnable2);
    }


    public void m1354a(int i, int i2) {
        this.f870b.m1541e(i, i2);
    }

    public void m_() {
        View e = getCurrentView();
        if (e != null) {
            PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
            pointF.set(getScrollX() + getWidth() / 2.0f, getScrollY() + (getHeight()) / 2.0f);
            AnimUtils.m1900a(pointF, (View) this, e);
            PointF pointF2 = (PointF) AnimUtils.f1197f.addAnimation();
            pointF2.set(pointF);
            AnimUtils.m1900a(pointF2, e, (View) this);
            pointF2.offset((float) (-getScrollX()), (float) (-getScrollY()));
            float[] d = m1347d(pointF.x, pointF.y, pointF2.x, pointF2.y, getZoomFactor(), getZoomAngle());
            m1341b(d[0], d[1], d[2], d[3], d[4], d[5]);
            AnimUtils.f1197f.clearAnimation(pointF);
            AnimUtils.f1197f.clearAnimation(pointF2);
        }
    }

    public void n_() {
        View e = getCurrentView();
        if (e != null) {
            PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
            pointF.set(((float) getScrollX()) + (((float) getWidth()) / 2.0f), ((float) getScrollY()) + (((float) getHeight()) / 2.0f));
            AnimUtils.m1900a(pointF, (View) this, e);
            PointF pointF2 = (PointF) AnimUtils.f1197f.addAnimation();
            pointF2.set(pointF);
            AnimUtils.m1900a(pointF2, e, (View) this);
            pointF2.offset((float) (-getScrollX()), (float) (-getScrollY()));
            float[] d = m1347d(pointF.x, pointF.y, pointF2.x, pointF2.y, getZoomFactor(), getZoomAngle());
            m1342b(d[0], d[1], d[2], d[3], d[4], d[5], null, null);
            AnimUtils.f1197f.clearAnimation(pointF);
            AnimUtils.f1197f.clearAnimation(pointF2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f870b.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f870b.onTouchEvent(motionEvent);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3 = 0;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        View e = getCurrentView();
        if (e != null) {
            LayoutParams layoutParams = e.getLayoutParams();
            int childMeasureSpec = getChildMeasureSpec(layoutParams.width == -1 ? widthMeasureSpec : 0, paddingRight, layoutParams.width);
            if (layoutParams.height == -1) {
                i3 = heightMeasureSpec;
            }
            e.measure(childMeasureSpec, getChildMeasureSpec(i3, paddingBottom, layoutParams.height));
            this.width = e.getMeasuredWidth();
            this.height = e.getMeasuredHeight();
        } else {
            this.width = 0;
            this.height = 0;
        }
        setMeasuredDimension(resolveSize(this.width + paddingRight, widthMeasureSpec), resolveSize(this.height + paddingBottom, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int height = bottom - top;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max = Math.max(right - left, this.width + paddingLeft);
        height = Math.max(height, this.height + paddingTop);
        View e = getCurrentView();
        if (e != null) {
            max = (((max - paddingLeft) - this.width) / 2) + getPaddingLeft();
            height = (((height - paddingTop) - this.height) / 2) + getPaddingTop();
            e.layout(max, height, e.getMeasuredWidth() + max, e.getMeasuredHeight() + height);
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        Point point = (Point) AnimUtils.f1196e.addAnimation();
        m1330a(rect, point, 0.0f, 0.0f, 0.0f, 0.0f, this.zoomFactor, this.zoomAngle);
        this.f870b.m1491a(rect);
        AnimUtils.f1198g.clearAnimation(rect);
        AnimUtils.f1196e.clearAnimation(point);
        this.f870b.m1504a(changed, left, top, right, bottom);
        m_();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f870b.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f870b.onDetachedFromWindow();
    }

    public void scrollBy(int i, int i2) {
        this.f870b.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f870b.scrollTo(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f870b.mo529b(canvas);
        this.f870b.m1527c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f870b.shouldDelayChildPressedState();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f882n = z;
        super.requestDisallowInterceptTouchEvent(z);
        this.f870b.m1520b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f870b.isHorizontalFadingEdgeEnabled();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f870b.isHorizontalScrollBarEnabled();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f870b.isVerticalFadingEdgeEnabled();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f870b.isVerticalScrollBarEnabled();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f870b.computeHorizontalScrollExtent();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f870b.computeHorizontalScrollOffset();
    }

    protected int computeHorizontalScrollRange() {
        return this.f870b.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return this.f870b.computeVerticalScrollExtent();
    }

    protected int computeVerticalScrollOffset() {
        return this.f870b.computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        return this.f870b.computeVerticalScrollRange();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.translate(view.getLeft(), view.getTop());
        canvas.concat(this.matrix);
        canvas.translate(-view.getLeft(), -view.getTop());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    @TargetApi(12)
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean a;
        if (motionEvent.getActionMasked() == 0) {
            this.f882n = false;
        }
        if ((motionEvent.getActionMasked() == 0 || this.f881m != null) && !this.f882n && onInterceptTouchEvent(motionEvent) && this.f881m != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            if (VERSION.SDK_INT >= 12) {
                obtain.setSource(4098);
            }
            this.f881m.dispatchTouchEvent(obtain);
            this.f881m = null;
        }
        if (motionEvent.getActionMasked() == 0) {
            PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
            RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
            this.f881m = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                pointF.set((getScrollX()) + motionEvent.getX(), (getScrollY()) + motionEvent.getY());
                rectF.set(childAt.getScrollX(), childAt.getScrollY(),(childAt.getScrollX() + childAt.getWidth()), (childAt.getScrollY() + childAt.getHeight()));
                AnimUtils.m1900a(pointF, this, childAt);
                if (rectF.contains(pointF.x, pointF.y) && m1339a(childAt, motionEvent)) {
                    this.f881m = childAt;
                    break;
                }
            }
            AnimUtils.f1197f.clearAnimation(pointF);
            AnimUtils.f1199h.clearAnimation(rectF);
            if (this.f881m != null) {
                return true;
            }
        }
        if (this.f881m != null) {
            a = m1339a(this.f881m, motionEvent);
        } else {
            a = onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() != 3) {
            return a;
        }
        this.f881m = null;
        return a;
    }


    private boolean m1339a(View view, MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, this, view);
        boolean dispatchTouchEvent = view.dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }


    private void m1327a(float f, float f2, float f3, float f4, float f5, float f6) {
        float[] d = m1347d(f, f2, f3, f4, f5, f6);
        m1341b(d[0], d[1], d[2], d[3], d[4], d[5]);
    }


    private void m1328a(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        float[] d = m1347d(f, f2, f3, f4, f5, f6);
        m1342b(d[0], d[1], d[2], d[3], d[4], d[5], runnable, runnable2);
    }


    private void m1341b(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = getCurrentView();
        if (e != null) {
            if (this.f880l != null) {
                this.f880l.m2154b();
            }
            if (f869a || this.f880l == null) {
                m1332a(ZoomState.IDLE);
                m1331a(e, f, f2, f3, f4, f5, f6);
                return;
            }
            throw new AssertionError();
        }
    }


    private void m1342b(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        if (getCurrentView() != null) {
            if (this.f880l != null) {
                this.f880l.m2154b();
            }
            if (f869a || this.f880l == null) {
                m1332a(ZoomState.SMOOTH);
                this.f880l = new gg(this, f, f2, f3, f4, f5, f6, new gc(this, runnable), new gd(this, runnable2));
                this.f880l.m2153a();
                return;
            }
            throw new AssertionError();
        }
    }


    private void m1344c(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = getCurrentView();
        if (e != null) {
            if (this.f880l != null) {
                this.f880l.m2154b();
            }
            if (f869a || this.f880l == null) {
                m1332a(ZoomState.PINCH);
                m1331a(e, f, f2, f3, f4, f5, f6);
                return;
            }
            throw new AssertionError();
        }
    }


    private void m1331a(View view, float f, float f2, float f3, float f4, float f5, float f6) {
        this.zoomFactor = f5;
        this.zoomAngle = f6;
        this.matrix.reset();
        this.matrix.preTranslate((float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
        this.matrix.preScale(this.zoomFactor, this.zoomFactor);
        this.matrix.preRotate(-this.zoomAngle);
        this.matrix.preTranslate((float) ((-view.getWidth()) / 2), (float) ((-view.getHeight()) / 2));
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        Point point = (Point) AnimUtils.f1196e.addAnimation();
        m1330a(rect, point, f, f2, f3, f4, f5, f6);
        this.f870b.m1491a(rect);
        this.f870b.m1541e(point.x, point.y);
        AnimUtils.f1198g.clearAnimation(rect);
        AnimUtils.f1196e.clearAnimation(point);
        invalidate();
        mo2334d();
    }


    private float[] m1347d(float f, float f2, float f3, float f4, float f5, float f6) {
        if (getCurrentView() == null) {
            return new float[]{f, f2, f3, f4, f5, f6};
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        Point point = (Point) AnimUtils.f1196e.addAnimation();
        m1330a(rect, point, f, f2, f3, f4, Math.min(Math.max(getMinZoomFactor(), f5), getMaxZoomFactor()), 0.0f);
        Point point2 = (Point) AnimUtils.f1196e.addAnimation();
        point2.x = Math.min(Math.max(rect.left, point.x), rect.right - getWidth());
        point2.y = Math.min(Math.max(rect.top, point.y), rect.bottom - getHeight());
        float[] fArr = new float[]{f, f2, f3 - ((float) (point2.x - point.x)), f4 - ((float) (point2.y - point.y)), r7, 0.0f};
        AnimUtils.f1196e.clearAnimation(point2);
        AnimUtils.f1196e.clearAnimation(point);
        AnimUtils.f1198g.clearAnimation(rect);
        return fArr;
    }


    private void m1330a(Rect rect, Point point, float f, float f2, float f3, float f4, float f5, float f6) {
        View e = getCurrentView();
        if (e == null) {
            rect.set(0, 0, getWidth(), getHeight());
            point.set(0, 0);
            return;
        }
        Matrix matrix = (Matrix) AnimUtils.f1195d.addAnimation();
        m1329a(matrix, f5, f6);
        rect.set(e.getScrollX(), e.getScrollY(), e.getScrollX() + e.getWidth(), e.getScrollY() + e.getHeight());
        AnimUtils.m1901a(matrix, rect);
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
        PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
        pointF.set(f, f2);
        AnimUtils.m1898a(matrix, pointF);
        pointF.offset(-f3, -f4);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        AnimUtils.f1195d.clearAnimation(matrix);
        AnimUtils.f1197f.clearAnimation(pointF);
    }

    @TargetApi(11)

    private void m1329a(Matrix matrix, float f, float f2) {
        View e = getCurrentView();
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


    private void m1332a(ZoomState zoomState) {
        if (this.zoomState != zoomState) {
            ZoomState zoomState2 = this.zoomState;
            this.zoomState = zoomState;
            m1333a(zoomState2, this.zoomState);
        }
    }


    private void m1333a(ZoomState zoomState, ZoomState zoomState2) {
        if (this.onZoomListener != null) {
            this.onZoomListener.mo2424a(this, zoomState, zoomState2);
        }
    }


    private void mo2334d() {
        if (this.onZoomListener != null) {
            this.onZoomListener.onZoom(this);
        }
    }


    private View getCurrentView() {
        return getChildCount() < 1 ? null : getChildAt(0);
    }


    protected gf m1362c() {
        return new gf(this);
    }
}
