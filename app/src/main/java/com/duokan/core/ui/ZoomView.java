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
    /* renamed from: a */
    static final /* synthetic */ boolean f869a = (!ZoomView.class.desiredAssertionStatus());
    /* renamed from: b */
    private final gf f870b;
    /* renamed from: c */
    private final Matrix f871c;
    /* renamed from: d */
    private int f872d;
    /* renamed from: e */
    private int f873e;
    /* renamed from: f */
    private ZoomState f874f;
    /* renamed from: g */
    private float f875g;
    /* renamed from: h */
    private float f876h;
    /* renamed from: i */
    private float f877i;
    /* renamed from: j */
    private float f878j;
    /* renamed from: k */
    private boolean f879k;
    /* renamed from: l */
    private gg f880l;
    /* renamed from: m */
    private View f881m;
    /* renamed from: n */
    private boolean f882n;
    /* renamed from: o */
    private ge f883o;
    /* renamed from: p */
    private OverScrollMode f884p;
    /* renamed from: q */
    private OverScrollMode f885q;

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
        this.f871c = new Matrix();
        this.f872d = 0;
        this.f873e = 0;
        this.f874f = ZoomState.IDLE;
        this.f875g = 1.0f;
        this.f876h = 1.0f;
        this.f877i = 10.0f;
        this.f878j = 0.0f;
        this.f879k = true;
        this.f880l = null;
        this.f881m = null;
        this.f882n = false;
        this.f883o = null;
        setWillNotDraw(false);
        this.f870b = m1362c();
        this.f870b.m1457I().m2041a(new gh());
        setThumbEnabled(true);
        setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        setVerticalOverScrollMode(OverScrollMode.STRETCH);
        setMaxOverScrollWidth(AnimUtils.m1959f(context));
        setMaxOverScrollHeight(AnimUtils.m1962g(context));
    }

    public final ZoomState getZoomState() {
        return this.f874f;
    }

    public final float getZoomFactor() {
        return this.f875g;
    }

    public final float getMinZoomFactor() {
        return this.f876h;
    }

    public final void setMinZoomFactor(float f) {
        this.f876h = f;
        m_();
    }

    public final float getMaxZoomFactor() {
        return this.f877i;
    }

    public final void setMaxZoomFactor(float f) {
        this.f877i = f;
        m_();
    }

    public final float getZoomAngle() {
        return this.f878j;
    }

    public final boolean getRotateEnabled() {
        return this.f879k;
    }

    public final void setRotateEnabled(boolean z) {
        this.f879k = z;
    }

    public ge getOnZoomListener() {
        return this.f883o;
    }

    public void setOnZoomListener(ge geVar) {
        this.f883o = geVar;
    }

    /* renamed from: a */
    public final void m1353a(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        m1352a(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }

    /* renamed from: a */
    public final void m1352a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (mo2335e() != null) {
            m1342b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }

    /* renamed from: a */
    public final void m1350a(float f, float f2, float f3) {
        m1351a(f, f2, f3, getZoomAngle());
    }

    /* renamed from: a */
    public final void m1351a(float f, float f2, float f3, float f4) {
        m1341b(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
    }

    /* renamed from: b */
    public final void m1357b(float f, float f2, float f3) {
        m1358b(f, f2, f3, getZoomAngle());
    }

    /* renamed from: b */
    public final void m1358b(float f, float f2, float f3, float f4) {
        if (mo2335e() != null) {
            m1327a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4);
        }
    }

    /* renamed from: b */
    public final void m1360b(float f, float f2, float f3, Runnable runnable, Runnable runnable2) {
        m1359b(f, f2, f3, getZoomAngle(), runnable, runnable2);
    }

    /* renamed from: b */
    public final void m1359b(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (mo2335e() != null) {
            m1328a(f, f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f3, f4, runnable, runnable2);
        }
    }

    /* renamed from: c */
    public Matrix mo475c(View view) {
        return this.f871c;
    }

    public final int getContentWidth() {
        return this.f870b.m1561s();
    }

    public final int getContentHeight() {
        return this.f870b.m1562t();
    }

    public boolean getThumbEnabled() {
        return this.f870b.m1563u();
    }

    public void setThumbEnabled(boolean z) {
        this.f870b.m1530c(z);
    }

    public boolean getSeekEnabled() {
        return this.f870b.m1564v();
    }

    public void setSeekEnabled(boolean z) {
        this.f870b.m1538d(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f870b.m1565w();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f870b.m1566x();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f870b.m1567y();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f870b.m1568z();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f870b.m1449A();
    }

    public int getVerticalThumbMarginTop() {
        return this.f870b.m1450B();
    }

    public int getVerticalThumbMarginRight() {
        return this.f870b.m1451C();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f870b.m1452D();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f870b.m1453E();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f870b.m1493a(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f870b.m1454F();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f870b.m1517b(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f870b.m1455G();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f870b.m1529c(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f870b.m1456H();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f870b.m1537d(drawable);
    }

    public et getScrollDetector() {
        return this.f870b.m1457I();
    }

    public final ScrollState getScrollState() {
        return this.f870b.getScrollState();
    }

    public final int getIdleTime() {
        return this.f870b.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f870b.m1458J();
    }

    public int getScrollFinalX() {
        return this.f870b.m1459K();
    }

    public int getScrollFinalY() {
        return this.f870b.m1460L();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f870b.m1496a(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f870b.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f884p;
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f884p = overScrollMode;
        this.f870b.m1497a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f885q;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f885q = overScrollMode;
        this.f870b.m1518b(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f870b.m1463O();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f870b.m1525c(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f870b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f870b.m1534d(i);
    }

    public final Rect getViewportBounds() {
        return this.f870b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f870b.m1501a(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.f870b.m1502a(cgVar);
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f870b.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: a */
    public void m1354a(int i, int i2) {
        this.f870b.m1541e(i, i2);
    }

    public void m_() {
        View e = mo2335e();
        if (e != null) {
            PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
            pointF.set(((float) getScrollX()) + (((float) getWidth()) / 2.0f), ((float) getScrollY()) + (((float) getHeight()) / 2.0f));
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
        View e = mo2335e();
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
        return this.f870b.mo2419b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f870b.mo2420c(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        View e = mo2335e();
        if (e != null) {
            LayoutParams layoutParams = e.getLayoutParams();
            int childMeasureSpec = getChildMeasureSpec(layoutParams.width == -1 ? i : 0, paddingRight, layoutParams.width);
            if (layoutParams.height == -1) {
                i3 = i2;
            }
            e.measure(childMeasureSpec, getChildMeasureSpec(i3, paddingBottom, layoutParams.height));
            this.f872d = e.getMeasuredWidth();
            this.f873e = e.getMeasuredHeight();
        } else {
            this.f872d = 0;
            this.f873e = 0;
        }
        setMeasuredDimension(resolveSize(this.f872d + paddingRight, i), resolveSize(this.f873e + paddingBottom, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i4 - i2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max = Math.max(i3 - i, this.f872d + paddingLeft);
        i5 = Math.max(i5, this.f873e + paddingTop);
        View e = mo2335e();
        if (e != null) {
            max = (((max - paddingLeft) - this.f872d) / 2) + getPaddingLeft();
            i5 = (((i5 - paddingTop) - this.f873e) / 2) + getPaddingTop();
            e.layout(max, i5, e.getMeasuredWidth() + max, e.getMeasuredHeight() + i5);
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        Point point = (Point) AnimUtils.f1196e.addAnimation();
        m1330a(rect, point, 0.0f, 0.0f, 0.0f, 0.0f, this.f875g, this.f878j);
        this.f870b.m1491a(rect);
        AnimUtils.f1198g.clearAnimation(rect);
        AnimUtils.f1196e.clearAnimation(point);
        this.f870b.m1504a(z, i, i2, i3, i4);
        m_();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f870b.m1523c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f870b.m1532d();
    }

    public void scrollBy(int i, int i2) {
        this.f870b.m1526c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f870b.m1535d(i, i2);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f870b.mo529b(canvas);
        this.f870b.m1527c(canvas);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f870b.m1554l();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f882n = z;
        super.requestDisallowInterceptTouchEvent(z);
        this.f870b.m1520b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f870b.m1548g();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f870b.m1550h();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f870b.m1551i();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f870b.m1552j();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f870b.m1555m();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f870b.m1556n();
    }

    protected int computeHorizontalScrollRange() {
        return this.f870b.m1557o();
    }

    protected int computeVerticalScrollExtent() {
        return this.f870b.m1558p();
    }

    protected int computeVerticalScrollOffset() {
        return this.f870b.m1559q();
    }

    protected int computeVerticalScrollRange() {
        return this.f870b.m1560r();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.translate((float) view.getLeft(), (float) view.getTop());
        canvas.concat(this.f871c);
        canvas.translate((float) (-view.getLeft()), (float) (-view.getTop()));
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
                pointF.set(((float) getScrollX()) + motionEvent.getX(), ((float) getScrollY()) + motionEvent.getY());
                rectF.set((float) childAt.getScrollX(), (float) childAt.getScrollY(), (float) (childAt.getScrollX() + childAt.getWidth()), (float) (childAt.getScrollY() + childAt.getHeight()));
                AnimUtils.m1900a(pointF, (View) this, childAt);
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

    /* renamed from: a */
    private boolean m1339a(View view, MotionEvent motionEvent) {
        MotionEvent a = AnimUtils.m1908a(motionEvent, (View) this, view);
        boolean dispatchTouchEvent = view.dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }

    /* renamed from: a */
    private void m1327a(float f, float f2, float f3, float f4, float f5, float f6) {
        float[] d = m1347d(f, f2, f3, f4, f5, f6);
        m1341b(d[0], d[1], d[2], d[3], d[4], d[5]);
    }

    /* renamed from: a */
    private void m1328a(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        float[] d = m1347d(f, f2, f3, f4, f5, f6);
        m1342b(d[0], d[1], d[2], d[3], d[4], d[5], runnable, runnable2);
    }

    /* renamed from: b */
    private void m1341b(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = mo2335e();
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

    /* renamed from: b */
    private void m1342b(float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        if (mo2335e() != null) {
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

    /* renamed from: c */
    private void m1344c(float f, float f2, float f3, float f4, float f5, float f6) {
        View e = mo2335e();
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

    /* renamed from: a */
    private void m1331a(View view, float f, float f2, float f3, float f4, float f5, float f6) {
        this.f875g = f5;
        this.f878j = f6;
        this.f871c.reset();
        this.f871c.preTranslate((float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
        this.f871c.preScale(this.f875g, this.f875g);
        this.f871c.preRotate(-this.f878j);
        this.f871c.preTranslate((float) ((-view.getWidth()) / 2), (float) ((-view.getHeight()) / 2));
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

    /* renamed from: d */
    private float[] m1347d(float f, float f2, float f3, float f4, float f5, float f6) {
        if (mo2335e() == null) {
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

    /* renamed from: a */
    private void m1330a(Rect rect, Point point, float f, float f2, float f3, float f4, float f5, float f6) {
        View e = mo2335e();
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
    /* renamed from: a */
    private void m1329a(Matrix matrix, float f, float f2) {
        View e = mo2335e();
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

    /* renamed from: a */
    private void m1332a(ZoomState zoomState) {
        if (this.f874f != zoomState) {
            ZoomState zoomState2 = this.f874f;
            this.f874f = zoomState;
            m1333a(zoomState2, this.f874f);
        }
    }

    /* renamed from: a */
    private void m1333a(ZoomState zoomState, ZoomState zoomState2) {
        if (this.f883o != null) {
            this.f883o.mo2424a(this, zoomState, zoomState2);
        }
    }

    /* renamed from: d */
    private void mo2334d() {
        if (this.f883o != null) {
            this.f883o.mo2423a(this);
        }
    }

    /* renamed from: e */
    private View mo2335e() {
        return getChildCount() < 1 ? null : getChildAt(0);
    }

    /* renamed from: c */
    protected gf m1362c() {
        return new gf(this);
    }
}
