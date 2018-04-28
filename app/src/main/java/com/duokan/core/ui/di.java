package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.util.HashMap;

public class di extends ViewGroup implements OnPreDrawListener, fk {
    /* renamed from: a */
    static final /* synthetic */ boolean f1143a = (!di.class.desiredAssertionStatus());
    /* renamed from: b */
    private final HashMap<View, ds> f1144b;
    /* renamed from: c */
    private OnHierarchyChangeListener f1145c;
    /* renamed from: d */
    private View f1146d;
    /* renamed from: e */
    private boolean f1147e;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1827a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1828a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1829a(layoutParams);
    }

    public di(Context context) {
        this(context, null);
    }

    public di(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1144b = new HashMap();
        this.f1145c = null;
        this.f1146d = null;
        this.f1147e = false;
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
        super.setOnHierarchyChangeListener(new dj(this));
    }

    /* renamed from: a */
    public dl m1826a(View view) {
        ds dsVar = (ds) this.f1144b.get(view);
        if (dsVar == null) {
            return null;
        }
        return dsVar.f1177f;
    }

    /* renamed from: a */
    public void m1830a(View view, dl dlVar) {
        if (!f1143a && dlVar == null) {
            throw new AssertionError();
        } else if (dlVar != null) {
            ds dsVar = (ds) this.f1144b.get(view);
            if (!f1143a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.f1179h != null) {
                    dsVar.f1179h.m1846f();
                    dsVar.f1179h = null;
                }
                dsVar.f1177f.m1871a(dlVar);
                dsVar.f1172a |= 5;
                view.invalidate();
                invalidate();
            }
        }
    }

    /* renamed from: b */
    public C0380do m1836b(View view) {
        ds dsVar = (ds) this.f1144b.get(view);
        if (dsVar == null) {
            return null;
        }
        return dsVar.f1178g;
    }

    /* renamed from: a */
    public void m1835a(View view, C0380do c0380do) {
        if (!f1143a && c0380do == null) {
            throw new AssertionError();
        } else if (c0380do != null) {
            ds dsVar = (ds) this.f1144b.get(view);
            if (!f1143a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.f1180i != null) {
                    dsVar.f1180i.m1846f();
                    dsVar.f1180i = null;
                }
                dsVar.f1178g.m1854a(c0380do);
                dsVar.f1172a |= 7;
                view.requestLayout();
                requestLayout();
                invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m1831a(View view, dl dlVar, int i) {
        m1832a(view, dlVar, i, null, null);
    }

    /* renamed from: a */
    public void m1832a(View view, dl dlVar, int i, Runnable runnable, Runnable runnable2) {
        dl dlVar2 = new dl(m1826a(view));
        dlVar2.m1858d((float) dv.m1927b((double) dlVar2.m1865l(), (double) (dlVar.m1865l() - 180.0f), (double) (dlVar.m1865l() + 180.0f)));
        m1834a(view, dlVar2, dlVar, i, runnable, runnable2);
    }

    /* renamed from: a */
    public void m1833a(View view, dl dlVar, dl dlVar2, int i) {
        m1834a(view, dlVar, dlVar2, i, null, null);
    }

    /* renamed from: a */
    public void m1834a(View view, dl dlVar, dl dlVar2, int i, Runnable runnable, Runnable runnable2) {
        if (!f1143a && (dlVar == null || dlVar2 == null)) {
            throw new AssertionError();
        } else if (dlVar != null && dlVar2 != null) {
            ds dsVar = (ds) this.f1144b.get(view);
            if (!f1143a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.f1179h != null) {
                    dsVar.f1179h.m1846f();
                    dsVar.f1179h = null;
                }
                dsVar.f1177f.m1871a(dlVar);
                dsVar.f1179h = new dk(this, dlVar, dlVar2, (long) i, runnable, runnable2);
                view.invalidate();
            }
        }
    }

    /* renamed from: c */
    public Matrix mo475c(View view) {
        ds dsVar = (ds) this.f1144b.get(view);
        if (dsVar == null) {
            return new Matrix();
        }
        return dsVar.f1175d;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            ds d = m1838d(childAt);
            m1824b(childAt, d, currentAnimationTimeMillis);
            m1820a(childAt, d, currentAnimationTimeMillis);
            m1819a(childAt, d);
        }
        return true;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        ds d = m1838d(view);
        if (d == null) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.translate((float) view.getLeft(), (float) view.getTop());
        canvas.concat(d.f1175d);
        canvas.translate((float) (-view.getLeft()), (float) (-view.getTop()));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        if (d.f1180i != null) {
            view.requestLayout();
            requestLayout();
            invalidate();
        }
        if (d.f1179h == null) {
            return drawChild;
        }
        view.invalidate();
        invalidate();
        return drawChild;
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        ds dsVar = (ds) this.f1144b.get(view);
        if (dsVar == null) {
            return false;
        }
        transformation.clear();
        transformation.setAlpha(dsVar.f1177f.m1868a());
        transformation.setTransformationType(1);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f1147e = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @TargetApi(12)
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean a;
        if (motionEvent.getActionMasked() == 0) {
            this.f1147e = false;
        }
        if ((motionEvent.getActionMasked() == 0 || this.f1146d != null) && !this.f1147e && onInterceptTouchEvent(motionEvent) && this.f1146d != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            if (VERSION.SDK_INT >= 12) {
                obtain.setSource(4098);
            }
            this.f1146d.dispatchTouchEvent(obtain);
            this.f1146d = null;
        }
        if (motionEvent.getActionMasked() == 0) {
            PointF pointF = (PointF) dv.f1197f.addAnimation();
            RectF rectF = (RectF) dv.f1199h.addAnimation();
            this.f1146d = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                pointF.set(((float) getScrollX()) + motionEvent.getX(), ((float) getScrollY()) + motionEvent.getY());
                rectF.set((float) childAt.getScrollX(), (float) childAt.getScrollY(), (float) (childAt.getScrollX() + childAt.getWidth()), (float) (childAt.getScrollY() + childAt.getHeight()));
                dv.m1900a(pointF, (View) this, childAt);
                if (rectF.contains(pointF.x, pointF.y) && m1821a(childAt, motionEvent)) {
                    this.f1146d = childAt;
                    break;
                }
            }
            dv.f1197f.clearAnimation(pointF);
            dv.f1199h.clearAnimation(rectF);
            if (this.f1146d != null) {
                return true;
            }
        }
        if (this.f1146d != null) {
            a = m1821a(this.f1146d, motionEvent);
        } else {
            a = onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() != 3) {
            return a;
        }
        this.f1146d = null;
        return a;
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1145c = onHierarchyChangeListener;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        rect.offset(view.getScrollX(), view.getScrollY());
        point.offset(view.getScrollX(), view.getScrollY());
        dv.m1937b(rect, view, (View) this);
        if (point != null) {
            dv.m1897a(point, view, (View) this);
        }
        rect.offset(-getScrollX(), -getScrollY());
        point.offset(-getScrollX(), -getScrollY());
        if (!rect.intersect(0, 0, getWidth(), getHeight())) {
            return false;
        }
        if (getParent() == null) {
            return true;
        }
        return getParent().getChildVisibleRect(this, rect, point);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Rect rect = (Rect) dv.f1198g.addAnimation();
        rect.set(0, 0, i3 - i, i4 - i2);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            ds d = m1838d(childAt);
            dn dnVar = (dn) childAt.getLayoutParams();
            Gravity.apply(dnVar.f1167a, d.f1181j, d.f1182k, rect, d.f1184m);
            d.f1184m.offset(dnVar.f1168b, dnVar.f1169c);
            childAt.layout(d.f1184m.left + ((d.f1184m.width() - childAt.getMeasuredWidth()) / 2), d.f1184m.top + ((d.f1184m.height() - childAt.getMeasuredHeight()) / 2), (d.f1184m.left + ((d.f1184m.width() - childAt.getMeasuredWidth()) / 2)) + childAt.getMeasuredWidth(), (((d.f1184m.height() - childAt.getMeasuredHeight()) / 2) + d.f1184m.top) + childAt.getMeasuredHeight());
        }
        dv.f1198g.clearAnimation(rect);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < getChildCount()) {
            View childAt = getChildAt(i3);
            ds d = m1838d(childAt);
            if ((d.f1172a & 2) == 2) {
                d.f1173b.reset();
                d.f1173b.preScale(d.f1178g.m1866m(), d.f1178g.m1867n());
                Matrix matrix = (Matrix) dv.f1195d.addAnimation();
                d.f1173b.preConcat(m1816a(matrix, d.f1178g.m1863j(), d.f1178g.m1864k(), d.f1178g.m1865l()));
                dv.f1195d.clearAnimation(matrix);
                d.f1172a &= -3;
            }
            m1818a(d.f1184m, size, size2, d.f1173b);
            measureChildWithMargins(childAt, MeasureSpec.makeMeasureSpec(d.f1184m.width(), mode), 0, MeasureSpec.makeMeasureSpec(d.f1184m.height(), mode2), 0);
            if (d.f1173b.isIdentity()) {
                d.f1181j = childAt.getMeasuredWidth();
                d.f1182k = childAt.getMeasuredHeight();
            } else {
                d.f1183l.set(0.0f, 0.0f, (float) childAt.getMeasuredWidth(), (float) childAt.getMeasuredHeight());
                d.f1173b.mapRect(d.f1183l);
                d.f1181j = (int) d.f1183l.width();
                d.f1182k = (int) d.f1183l.height();
            }
            int max = Math.max(i5, d.f1181j);
            i3++;
            i4 = Math.max(i4, d.f1182k);
            i5 = max;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                i5 = Math.min(i5, size);
                break;
            case 0:
                break;
            default:
                i5 = size;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                i4 = Math.min(i4, size);
                break;
            case 0:
                break;
            default:
                i4 = size2;
                break;
        }
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            int makeMeasureSpec;
            View childAt2 = getChildAt(i6);
            ds d2 = m1838d(childAt2);
            dn dnVar = (dn) childAt2.getLayoutParams();
            m1818a(d2.f1184m, size, size2, d2.f1173b);
            max = d2.f1184m.width();
            int height = d2.f1184m.height();
            if (dnVar.width == -1) {
                max = MeasureSpec.makeMeasureSpec(max, 1073741824);
            } else if (dnVar.width == -2) {
                max = MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
            } else {
                max = MeasureSpec.makeMeasureSpec(dnVar.width, 1073741824);
            }
            if (dnVar.height == -1) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(height, 1073741824);
            } else if (dnVar.height == -2) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(dnVar.height, 1073741824);
            }
            childAt2.measure(max, makeMeasureSpec);
            if (d2.f1173b.isIdentity()) {
                d2.f1181j = childAt2.getMeasuredWidth();
                d2.f1182k = childAt2.getMeasuredHeight();
            } else {
                d2.f1183l.set(0.0f, 0.0f, (float) childAt2.getMeasuredWidth(), (float) childAt2.getMeasuredHeight());
                d2.f1173b.mapRect(d2.f1183l);
                d2.f1181j = (int) d2.f1183l.width();
                d2.f1182k = (int) d2.f1183l.height();
            }
        }
        setMeasuredDimension(i5, i4);
    }

    /* renamed from: a */
    public dn m1828a(AttributeSet attributeSet) {
        return new dn(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected dn m1827a() {
        return new dn(-1, -1, 17);
    }

    /* renamed from: a */
    protected dn m1829a(LayoutParams layoutParams) {
        return new dn(layoutParams);
    }

    /* renamed from: a */
    private boolean m1821a(View view, MotionEvent motionEvent) {
        MotionEvent a = dv.m1908a(motionEvent, (View) this, view);
        boolean dispatchTouchEvent = view.dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }

    /* renamed from: a */
    private void m1819a(View view, ds dsVar) {
        m1823b(view, dsVar);
        m1825c(view, dsVar);
        if ((dsVar.f1172a & 1) == 1) {
            float width = ((float) view.getWidth()) / 2.0f;
            float height = ((float) view.getHeight()) / 2.0f;
            dsVar.f1175d.reset();
            dsVar.f1175d.preTranslate(width, height);
            dsVar.f1175d.preConcat(dsVar.f1173b);
            dsVar.f1175d.preTranslate(-width, -height);
            dsVar.f1175d.preConcat(dsVar.f1174c);
            dsVar.f1175d.invert(dsVar.f1176e);
            dsVar.f1172a &= -2;
        }
    }

    /* renamed from: b */
    private void m1823b(View view, ds dsVar) {
        if ((dsVar.f1172a & 4) == 4) {
            float f = dsVar.f1177f.m1859f() * ((float) view.getWidth());
            float g = dsVar.f1177f.m1860g() * ((float) view.getHeight());
            dsVar.f1174c.reset();
            dsVar.f1174c.preTranslate((float) dsVar.f1177f.m1861h(), (float) dsVar.f1177f.m1862i());
            dsVar.f1174c.preTranslate(f, g);
            dsVar.f1174c.preScale(dsVar.f1177f.m1866m(), dsVar.f1177f.m1867n());
            Matrix matrix = (Matrix) dv.f1195d.addAnimation();
            dsVar.f1174c.preConcat(m1816a(matrix, dsVar.f1177f.m1863j(), dsVar.f1177f.m1864k(), dsVar.f1177f.m1865l()));
            dv.f1195d.clearAnimation(matrix);
            dsVar.f1174c.preTranslate(-f, -g);
            dsVar.f1172a &= -5;
        }
    }

    /* renamed from: c */
    private void m1825c(View view, ds dsVar) {
        if ((dsVar.f1172a & 2) == 2) {
            dsVar.f1173b.reset();
            dsVar.f1173b.preScale(dsVar.f1178g.m1866m(), dsVar.f1178g.m1867n());
            Matrix matrix = (Matrix) dv.f1195d.addAnimation();
            dsVar.f1173b.preConcat(m1816a(matrix, dsVar.f1178g.m1863j(), dsVar.f1178g.m1864k(), dsVar.f1178g.m1865l()));
            dv.f1195d.clearAnimation(matrix);
            dsVar.f1172a &= -3;
        }
    }

    /* renamed from: a */
    private void m1820a(View view, ds dsVar, long j) {
        if (dsVar.f1179h != null) {
            if (!dsVar.f1179h.mo512a(dsVar.f1177f, j)) {
                dsVar.f1179h = null;
            }
            dsVar.f1172a |= 5;
        }
    }

    /* renamed from: b */
    private void m1824b(View view, ds dsVar, long j) {
        if (dsVar.f1180i != null) {
            if (!dsVar.f1180i.mo512a(dsVar.f1178g, j)) {
                dsVar.f1180i = null;
            }
            dsVar.f1172a |= 7;
        }
    }

    /* renamed from: a */
    private void m1818a(Rect rect, int i, int i2, Matrix matrix) {
        if (matrix.isIdentity()) {
            rect.set(0, 0, i, i2);
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
        } else {
            float abs;
            float[] fArr = (float[]) dv.f1202k.addAnimation();
            matrix.getValues(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[3];
            float f4 = fArr[4];
            float abs2;
            if (Float.compare(f2, 0.0f) == 0 || Float.compare(f3, 0.0f) == 0) {
                abs2 = Math.abs(((float) i2) / f4);
                abs = Math.abs(((float) i) / f);
                if (Float.compare(f2, 0.0f) != 0) {
                    abs = Math.min(Math.abs(((float) i2) / f2) * 0.5f, abs);
                    abs2 -= (f2 * abs) / f4;
                } else if (Float.compare(f3, 0.0f) != 0) {
                    abs2 = Math.min(Math.abs(((float) i) / f3) * 0.5f, abs2);
                    abs -= (f3 * abs2) / f;
                }
                f = abs;
                abs = abs2;
            } else if (Float.compare(f, 0.0f) == 0 || Float.compare(f4, 0.0f) == 0) {
                abs = Math.abs(((float) i2) / f2);
                abs2 = Math.abs(((float) i) / f3);
                if (Float.compare(f, 0.0f) != 0) {
                    abs = Math.min(Math.abs(((float) i) / f) * 0.5f, abs);
                    abs2 -= (f * abs) / f3;
                } else if (Float.compare(f4, 0.0f) != 0) {
                    abs2 = Math.min(Math.abs(((float) i2) / f4) * 0.5f, abs2);
                    abs -= (f4 * abs2) / f2;
                }
                f = abs;
                abs = abs2;
            } else {
                abs2 = Math.abs(((float) i) / f);
                f3 = Math.abs(((float) i) / f3);
                f2 = Math.abs(((float) i2) / f2);
                f4 = Math.abs(((float) i2) / f4);
                f = Math.min(f2, abs2) * 0.5f;
                abs = Math.min(f3, f4) * 0.5f;
                if ((Float.compare(abs2, f2) >= 0 && Float.compare(f3, f4) <= 0) || (Float.compare(abs2, f2) <= 0 && Float.compare(f3, f4) >= 0)) {
                    RectF rectF = (RectF) dv.f1199h.addAnimation();
                    rectF.set(0.0f, 0.0f, f, abs);
                    matrix.mapRect(rectF);
                    f2 = Math.min(((float) i) / rectF.width(), ((float) i2) / rectF.height());
                    if (!(Float.isNaN(f2) || Float.isInfinite(f2))) {
                        f *= f2;
                        abs *= f2;
                    }
                    dv.f1199h.clearAnimation(rectF);
                }
            }
            rect.set(0, 0, (int) f, (int) abs);
            dv.f1202k.clearAnimation(fArr);
        }
    }

    /* renamed from: a */
    private Matrix m1816a(Matrix matrix, float f, float f2, float f3) {
        Camera camera = (Camera) dv.f1192a.addAnimation();
        camera.rotateX(f);
        camera.rotateY(f2);
        camera.rotateZ(f3);
        camera.getMatrix(matrix);
        dv.f1192a.clearAnimation(camera);
        return matrix;
    }

    /* renamed from: d */
    protected ds m1838d(View view) {
        return (ds) this.f1144b.get(view);
    }
}
