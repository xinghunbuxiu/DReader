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
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import java.util.HashMap;

public class di extends ViewGroup implements OnPreDrawListener, fk {
    static final /* synthetic */ boolean a = (!di.class.desiredAssertionStatus());
    private final HashMap b;
    private OnHierarchyChangeListener c;
    private View d;
    private boolean e;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public di(Context context) {
        this(context, null);
    }

    public di(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new HashMap();
        this.c = null;
        this.d = null;
        this.e = false;
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
        super.setOnHierarchyChangeListener(new dj(this));
    }

    public dl a(View view) {
        ds dsVar = (ds) this.b.get(view);
        if (dsVar == null) {
            return null;
        }
        return dsVar.f;
    }

    public void a(View view, dl dlVar) {
        if (!a && dlVar == null) {
            throw new AssertionError();
        } else if (dlVar != null) {
            ds dsVar = (ds) this.b.get(view);
            if (!a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.h != null) {
                    dsVar.h.f();
                    dsVar.h = null;
                }
                dsVar.f.a(dlVar);
                dsVar.a |= 5;
                view.invalidate();
                invalidate();
            }
        }
    }

    public do b(View view) {
        ds dsVar = (ds) this.b.get(view);
        if (dsVar == null) {
            return null;
        }
        return dsVar.g;
    }

    public void a(View view, do doVar) {
        if (!a && doVar == null) {
            throw new AssertionError();
        } else if (doVar != null) {
            ds dsVar = (ds) this.b.get(view);
            if (!a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.i != null) {
                    dsVar.i.f();
                    dsVar.i = null;
                }
                dsVar.g.a(doVar);
                dsVar.a |= 7;
                view.requestLayout();
                requestLayout();
                invalidate();
            }
        }
    }

    public void a(View view, dl dlVar, int i) {
        a(view, dlVar, i, null, null);
    }

    public void a(View view, dl dlVar, int i, Runnable runnable, Runnable runnable2) {
        dl dlVar2 = new dl(a(view));
        dlVar2.d((float) dv.b((double) dlVar2.l(), (double) (dlVar.l() - 180.0f), (double) (dlVar.l() + 180.0f)));
        a(view, dlVar2, dlVar, i, runnable, runnable2);
    }

    public void a(View view, dl dlVar, dl dlVar2, int i) {
        a(view, dlVar, dlVar2, i, null, null);
    }

    public void a(View view, dl dlVar, dl dlVar2, int i, Runnable runnable, Runnable runnable2) {
        if (!a && (dlVar == null || dlVar2 == null)) {
            throw new AssertionError();
        } else if (dlVar != null && dlVar2 != null) {
            ds dsVar = (ds) this.b.get(view);
            if (!a && dsVar == null) {
                throw new AssertionError();
            } else if (dsVar != null) {
                if (dsVar.h != null) {
                    dsVar.h.f();
                    dsVar.h = null;
                }
                dsVar.f.a(dlVar);
                dsVar.h = new dk(this, dlVar, dlVar2, (long) i, runnable, runnable2);
                view.invalidate();
            }
        }
    }

    public Matrix c(View view) {
        ds dsVar = (ds) this.b.get(view);
        if (dsVar == null) {
            return new Matrix();
        }
        return dsVar.d;
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
            ds d = d(childAt);
            b(childAt, d, currentAnimationTimeMillis);
            a(childAt, d, currentAnimationTimeMillis);
            a(childAt, d);
        }
        return true;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        ds d = d(view);
        if (d == null) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.translate((float) view.getLeft(), (float) view.getTop());
        canvas.concat(d.d);
        canvas.translate((float) (-view.getLeft()), (float) (-view.getTop()));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        if (d.i != null) {
            view.requestLayout();
            requestLayout();
            invalidate();
        }
        if (d.h == null) {
            return drawChild;
        }
        view.invalidate();
        invalidate();
        return drawChild;
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        ds dsVar = (ds) this.b.get(view);
        if (dsVar == null) {
            return false;
        }
        transformation.clear();
        transformation.setAlpha(dsVar.f.a());
        transformation.setTransformationType(1);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.e = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @TargetApi(12)
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean a;
        if (motionEvent.getActionMasked() == 0) {
            this.e = false;
        }
        if ((motionEvent.getActionMasked() == 0 || this.d != null) && !this.e && onInterceptTouchEvent(motionEvent) && this.d != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            if (VERSION.SDK_INT >= 12) {
                obtain.setSource(4098);
            }
            this.d.dispatchTouchEvent(obtain);
            this.d = null;
        }
        if (motionEvent.getActionMasked() == 0) {
            PointF pointF = (PointF) dv.f.a();
            RectF rectF = (RectF) dv.h.a();
            this.d = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                pointF.set(((float) getScrollX()) + motionEvent.getX(), ((float) getScrollY()) + motionEvent.getY());
                rectF.set((float) childAt.getScrollX(), (float) childAt.getScrollY(), (float) (childAt.getScrollX() + childAt.getWidth()), (float) (childAt.getScrollY() + childAt.getHeight()));
                dv.a(pointF, (View) this, childAt);
                if (rectF.contains(pointF.x, pointF.y) && a(childAt, motionEvent)) {
                    this.d = childAt;
                    break;
                }
            }
            dv.f.a(pointF);
            dv.h.a(rectF);
            if (this.d != null) {
                return true;
            }
        }
        if (this.d != null) {
            a = a(this.d, motionEvent);
        } else {
            a = onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() != 3) {
            return a;
        }
        this.d = null;
        return a;
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.c = onHierarchyChangeListener;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        rect.offset(view.getScrollX(), view.getScrollY());
        point.offset(view.getScrollX(), view.getScrollY());
        dv.b(rect, view, (View) this);
        if (point != null) {
            dv.a(point, view, (View) this);
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
        Rect rect = (Rect) dv.g.a();
        rect.set(0, 0, i3 - i, i4 - i2);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            ds d = d(childAt);
            dn dnVar = (dn) childAt.getLayoutParams();
            Gravity.apply(dnVar.a, d.j, d.k, rect, d.m);
            d.m.offset(dnVar.b, dnVar.c);
            childAt.layout(d.m.left + ((d.m.width() - childAt.getMeasuredWidth()) / 2), d.m.top + ((d.m.height() - childAt.getMeasuredHeight()) / 2), (d.m.left + ((d.m.width() - childAt.getMeasuredWidth()) / 2)) + childAt.getMeasuredWidth(), (((d.m.height() - childAt.getMeasuredHeight()) / 2) + d.m.top) + childAt.getMeasuredHeight());
        }
        dv.g.a(rect);
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
            ds d = d(childAt);
            if ((d.a & 2) == 2) {
                d.b.reset();
                d.b.preScale(d.g.m(), d.g.n());
                Matrix matrix = (Matrix) dv.d.a();
                d.b.preConcat(a(matrix, d.g.j(), d.g.k(), d.g.l()));
                dv.d.a(matrix);
                d.a &= -3;
            }
            a(d.m, size, size2, d.b);
            measureChildWithMargins(childAt, MeasureSpec.makeMeasureSpec(d.m.width(), mode), 0, MeasureSpec.makeMeasureSpec(d.m.height(), mode2), 0);
            if (d.b.isIdentity()) {
                d.j = childAt.getMeasuredWidth();
                d.k = childAt.getMeasuredHeight();
            } else {
                d.l.set(0.0f, 0.0f, (float) childAt.getMeasuredWidth(), (float) childAt.getMeasuredHeight());
                d.b.mapRect(d.l);
                d.j = (int) d.l.width();
                d.k = (int) d.l.height();
            }
            int max = Math.max(i5, d.j);
            i3++;
            i4 = Math.max(i4, d.k);
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
            ds d2 = d(childAt2);
            dn dnVar = (dn) childAt2.getLayoutParams();
            a(d2.m, size, size2, d2.b);
            max = d2.m.width();
            int height = d2.m.height();
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
            if (d2.b.isIdentity()) {
                d2.j = childAt2.getMeasuredWidth();
                d2.k = childAt2.getMeasuredHeight();
            } else {
                d2.l.set(0.0f, 0.0f, (float) childAt2.getMeasuredWidth(), (float) childAt2.getMeasuredHeight());
                d2.b.mapRect(d2.l);
                d2.j = (int) d2.l.width();
                d2.k = (int) d2.l.height();
            }
        }
        setMeasuredDimension(i5, i4);
    }

    public dn a(AttributeSet attributeSet) {
        return new dn(getContext(), attributeSet);
    }

    protected dn a() {
        return new dn(-1, -1, 17);
    }

    protected dn a(LayoutParams layoutParams) {
        return new dn(layoutParams);
    }

    private boolean a(View view, MotionEvent motionEvent) {
        MotionEvent a = dv.a(motionEvent, (View) this, view);
        boolean dispatchTouchEvent = view.dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }

    private void a(View view, ds dsVar) {
        b(view, dsVar);
        c(view, dsVar);
        if ((dsVar.a & 1) == 1) {
            float width = ((float) view.getWidth()) / 2.0f;
            float height = ((float) view.getHeight()) / 2.0f;
            dsVar.d.reset();
            dsVar.d.preTranslate(width, height);
            dsVar.d.preConcat(dsVar.b);
            dsVar.d.preTranslate(-width, -height);
            dsVar.d.preConcat(dsVar.c);
            dsVar.d.invert(dsVar.e);
            dsVar.a &= -2;
        }
    }

    private void b(View view, ds dsVar) {
        if ((dsVar.a & 4) == 4) {
            float f = dsVar.f.f() * ((float) view.getWidth());
            float g = dsVar.f.g() * ((float) view.getHeight());
            dsVar.c.reset();
            dsVar.c.preTranslate((float) dsVar.f.h(), (float) dsVar.f.i());
            dsVar.c.preTranslate(f, g);
            dsVar.c.preScale(dsVar.f.m(), dsVar.f.n());
            Matrix matrix = (Matrix) dv.d.a();
            dsVar.c.preConcat(a(matrix, dsVar.f.j(), dsVar.f.k(), dsVar.f.l()));
            dv.d.a(matrix);
            dsVar.c.preTranslate(-f, -g);
            dsVar.a &= -5;
        }
    }

    private void c(View view, ds dsVar) {
        if ((dsVar.a & 2) == 2) {
            dsVar.b.reset();
            dsVar.b.preScale(dsVar.g.m(), dsVar.g.n());
            Matrix matrix = (Matrix) dv.d.a();
            dsVar.b.preConcat(a(matrix, dsVar.g.j(), dsVar.g.k(), dsVar.g.l()));
            dv.d.a(matrix);
            dsVar.a &= -3;
        }
    }

    private void a(View view, ds dsVar, long j) {
        if (dsVar.h != null) {
            if (!dsVar.h.a(dsVar.f, j)) {
                dsVar.h = null;
            }
            dsVar.a |= 5;
        }
    }

    private void b(View view, ds dsVar, long j) {
        if (dsVar.i != null) {
            if (!dsVar.i.a(dsVar.g, j)) {
                dsVar.i = null;
            }
            dsVar.a |= 7;
        }
    }

    private void a(Rect rect, int i, int i2, Matrix matrix) {
        if (matrix.isIdentity()) {
            rect.set(0, 0, i, i2);
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
        } else {
            float abs;
            float[] fArr = (float[]) dv.k.a();
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
                    RectF rectF = (RectF) dv.h.a();
                    rectF.set(0.0f, 0.0f, f, abs);
                    matrix.mapRect(rectF);
                    f2 = Math.min(((float) i) / rectF.width(), ((float) i2) / rectF.height());
                    if (!(Float.isNaN(f2) || Float.isInfinite(f2))) {
                        f *= f2;
                        abs *= f2;
                    }
                    dv.h.a(rectF);
                }
            }
            rect.set(0, 0, (int) f, (int) abs);
            dv.k.a(fArr);
        }
    }

    private Matrix a(Matrix matrix, float f, float f2, float f3) {
        Camera camera = (Camera) dv.a.a();
        camera.rotateX(f);
        camera.rotateY(f2);
        camera.rotateZ(f3);
        camera.getMatrix(matrix);
        dv.a.a(camera);
        return matrix;
    }

    protected ds d(View view) {
        return (ds) this.b.get(view);
    }
}
