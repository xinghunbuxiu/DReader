package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

import com.duokan.core.sys.t;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.umeng.analytics.pro.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class ay extends ViewGroup implements OnPreDrawListener, Scrollable, ax {
    static final /* synthetic */ boolean c = (!ay.class.desiredAssertionStatus());
    private int A = -1;
    private int B = -1;
    private Runnable C = null;
    private Runnable D = null;
    private bf E = null;
    private bg F = null;
    private final bh a = b();
    private final ArrayList b = new ArrayList();
    private final LinkedList d = new LinkedList();
    private final HashSet e = new HashSet();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private Drawable i = null;
    private int j = 0;
    private boolean k = true;
    private boolean l = true;
    private boolean m = true;
    private boolean n = false;
    private int o = MeasureSpec.makeMeasureSpec(0, 0);
    private int p = MeasureSpec.makeMeasureSpec(0, 0);
    private View q = null;
    private boolean r = false;
    private int s = 0;
    private int t = 0;
    private int u = -1;
    private int v = -1;
    private int[] w = new int[0];
    private int[] x = new int[0];
    private ScrollState y = ScrollState.IDLE;
    private av z = null;

    protected abstract int a(int i, int i2);

    protected abstract int a(Point point);

    protected abstract void a();

    protected abstract int[] a(Rect rect);

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public ay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a.a(new AccelerateDecelerateInterpolator());
        setWillNotDraw(false);
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
    }

    public final void setOnItemClickListener(bf bfVar) {
        this.E = bfVar;
    }

    public final void setOnItemLongPressListener(bg bgVar) {
        this.F = bgVar;
    }

    public final av getAdapter() {
        return this.z;
    }

    public final void setAdapter(av avVar) {
        if (this.z != null) {
            this.z.b(this);
        }
        this.z = avVar;
        if (this.z != null) {
            this.z.a(this);
        }
        i();
    }

    public final Drawable getItemsBackground() {
        return this.i;
    }

    public final void setItemsBackground(int i) {
        setItemsBackground(getResources().getDrawable(i));
    }

    public final void setItemsBackground(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            int i = this.f.left;
            int i2 = this.f.top;
            int i3 = this.f.right;
            int i4 = this.f.bottom;
            if (this.i == null) {
                this.f.setEmpty();
            } else {
                this.i.getPadding(this.f);
            }
            if (this.f.left != i || this.f.top != i2 || this.f.right != i3 || this.f.bottom != i4) {
                i();
            }
        }
    }

    public final int getItemCount() {
        return this.j;
    }

    public final View g(int i) {
        l();
        return r(i).c;
    }

    public final View[] getItemViews() {
        l();
        View[] viewArr = new View[this.d.size()];
        for (int i = 0; i < viewArr.length; i++) {
            viewArr[i] = ((bc) this.d.get(i)).c;
        }
        return viewArr;
    }

    public final View[] getOrderedItemViews() {
        ArrayList arrayList = new ArrayList(this.d.size());
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((bc) it.next()).a));
        }
        Collections.sort(arrayList, new az(this));
        l();
        View[] viewArr = new View[arrayList.size()];
        for (int i = 0; i < viewArr.length; i++) {
            viewArr[i] = ((bc) this.b.get(((Integer) arrayList.get(i)).intValue())).c;
        }
        return viewArr;
    }

    public final View[] getVisibleItemViews() {
        int[] visibleItemIndices = getVisibleItemIndices();
        View[] viewArr = new View[visibleItemIndices.length];
        for (int i = 0; i < visibleItemIndices.length; i++) {
            viewArr[i] = g(visibleItemIndices[i]);
        }
        return viewArr;
    }

    public final int[] getVisibleItemIndices() {
        l();
        return this.w;
    }

    public final int getFirstVisibleItemIndex() {
        l();
        return this.w.length > 0 ? this.w[0] : -1;
    }

    public final int getLastVisibleItemIndex() {
        l();
        return this.w.length > 0 ? this.w[this.w.length - 1] : -1;
    }

    public final int getVisibleItemCount() {
        l();
        return this.w.length;
    }

    public final Rect getPreviewExtents() {
        return this.g;
    }

    public final Rect getPreviewBounds() {
        this.h.set(getViewportBounds());
        Rect rect = this.h;
        rect.left -= this.g.left;
        rect = this.h;
        rect.top -= this.g.top;
        rect = this.h;
        rect.right += this.g.right;
        rect = this.h;
        rect.bottom += this.g.bottom;
        return this.h;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        k();
    }

    public final Rect h(int i) {
        boolean a = a(i, true);
        l();
        bc r = r(i);
        View a2 = r.c;
        Rect rect = new Rect();
        if (a2 != null) {
            rect.set(a2.getLeft(), a2.getTop(), a2.getRight(), a2.getBottom());
            rect.offset(r.h, r.i);
            rect.offset(-r.b.getScrollX(), -r.b.getScrollY());
            a(i, a);
        }
        return rect;
    }

    public final int e(int i, int i2) {
        l();
        Point point = new Point(i, i2);
        c(point);
        return a(point);
    }

    public final int[] b(Rect rect) {
        l();
        Rect rect2 = new Rect(rect);
        c(rect2);
        return a(rect2);
    }

    public final boolean a(int i, boolean z) {
        bc r = r(i);
        boolean c = r.c();
        if (r.c() != z) {
            r.c(z);
            if (z) {
                b(i, true);
            } else if (r.p == null) {
                b(i, false);
            }
        }
        return c;
    }

    public final void b(int i, int i2, int i3) {
        bc r = r(i);
        r.a(i2, i3);
        if (r.p != null) {
            b(i, true);
        } else if (!r.c()) {
            b(i, false);
        }
        l();
    }

    public final void a(int i, float f) {
        bc r = r(i);
        r.a(f);
        if (r.p != null) {
            b(i, true);
        } else if (!r.c()) {
            b(i, false);
        }
        l();
    }

    public final void i(int i) {
        l();
        if (s(i) && !getViewportBounds().isEmpty() && getContentWidth() != 0 && getContentHeight() != 0 && !j(i)) {
            Rect h = h(i);
            if (!h.isEmpty()) {
                scrollTo(h.left, h.top);
                e();
            }
        }
    }

    public final void b(int i, Rect rect, int i2) {
        l();
        if (s(i) && !rect.isEmpty() && rect.width() != 0 && rect.height() != 0) {
            Rect h = h(i);
            if (!h.isEmpty()) {
                Rect rect2 = (Rect) dv.g.a();
                Gravity.apply(i2, h.width(), h.height(), c(rect), rect2);
                scrollBy(h.left - rect2.left, h.top - rect2.top);
                dv.g.a(rect2);
                e();
            }
        }
    }

    public final boolean j(int i) {
        l();
        if (s(i)) {
            return r(i).d();
        }
        return false;
    }

    public final int getContentWidth() {
        return this.a.s();
    }

    public final int getContentHeight() {
        return this.a.t();
    }

    public final boolean getThumbEnabled() {
        return this.a.u();
    }

    public final void setThumbEnabled(boolean z) {
        this.a.c(z);
    }

    public boolean getSeekEnabled() {
        return this.a.v();
    }

    public void setSeekEnabled(boolean z) {
        this.a.d(z);
    }

    public void a(boolean z) {
        this.a.e(z);
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

    public void b(int i, int i2, int i3, int i4) {
        this.a.b(i, i2, i3, i4);
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

    public final void a(View view, boolean z) {
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

    public final void setOnScrollListener(cg cgVar) {
        this.a.a(cgVar);
    }

    public final boolean c() {
        return this.a.W();
    }

    public final boolean d() {
        return this.a.X();
    }

    public final void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.a.a(i, i2, i3, runnable, runnable2);
    }

    public final void b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.a.b(i, i2, i3, runnable, runnable2);
    }

    public final void f(int i, int i2) {
        this.a.e(i, i2);
    }

    public final void e() {
        this.a.Y();
    }

    public final void f() {
        this.a.Z();
    }

    public void a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        this.a.a(rect, rect2, i, runnable, runnable2);
    }

    public final Point b(Point point) {
        return this.a.a(point);
    }

    public final Point c(Point point) {
        return this.a.b(point);
    }

    public final Rect c(Rect rect) {
        return this.a.b(rect);
    }

    public void a_(int i, int i2) {
        j(i, i2);
        l();
        e();
    }

    public void b_(int i, int i2) {
        k(i, i2);
        l();
        e();
    }

    public void a(int i, int i2, int i3) {
        c(i, i2, i3);
        l();
        e();
    }

    public void d(int i, int i2) {
        l(i, i2);
        l();
        e();
    }

    public void a_(int i) {
        b(i);
        l();
        e();
    }

    public boolean onPreDraw() {
        l();
        int i = this.u >= 0 ? this.u : this.s;
        int i2 = this.v >= 0 ? this.v : this.t;
        this.u = this.s;
        this.v = this.t;
        LayoutParams layoutParams = getLayoutParams();
        if ((layoutParams.width != -2 || this.s == i) && (layoutParams.height != -2 || this.t == i2)) {
            return true;
        }
        h();
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        this.a.c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.d();
        this.C = null;
        this.D = null;
        this.A = -1;
        this.B = -1;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.c(motionEvent);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.a.b(canvas);
        d(canvas);
    }

    protected void onMeasure(int i, int i2) {
        if (!(this.o == i && this.p == i2)) {
            this.o = i;
            this.p = i2;
            i();
        }
        int i3 = this.s;
        i3 = this.t;
        l();
        int mode = MeasureSpec.getMode(this.o);
        int size = MeasureSpec.getSize(this.o);
        int mode2 = MeasureSpec.getMode(this.p);
        i3 = MeasureSpec.getSize(this.p);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(this.s, size);
            } else {
                size = this.s;
            }
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(this.t, i3);
            } else {
                i3 = this.t;
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.a(z, i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i != getPaddingLeft() || i2 != getPaddingTop() || i3 != getPaddingRight() || i4 != getPaddingBottom()) {
            super.setPadding(i, i2, i3, i4);
            i();
        }
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        if (!(view instanceof bd)) {
            return false;
        }
        Transformation f = ((bd) view).b.p;
        if (f == null || (f.getTransformationType() & 1) != 1) {
            return false;
        }
        transformation.clear();
        transformation.setAlpha(f.getAlpha());
        transformation.setTransformationType(1);
        return true;
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

    public void scrollBy(int i, int i2) {
        this.a.c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.a.d(i, i2);
    }

    public boolean shouldDelayChildPressedState() {
        return this.a.l();
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

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!(view instanceof bd)) {
            return super.drawChild(canvas, view, j);
        }
        Transformation f = ((bd) view).b.p;
        if (f == null || (f.getTransformationType() & 2) != 2) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.concat(f.getMatrix());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public void forceLayout() {
        super.forceLayout();
        i();
    }

    public void requestLayout() {
        super.requestLayout();
        i();
    }

    public be a(AttributeSet attributeSet) {
        return new be(getContext(), attributeSet);
    }

    protected be g() {
        return new be(-1, -2);
    }

    protected be a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new be((MarginLayoutParams) layoutParams) : new be(layoutParams);
    }

    protected void a(Canvas canvas) {
        if (this.j > 0 && this.i != null) {
            Rect k = this.a.k();
            this.i.setBounds(k.left + getPaddingLeft(), k.top + getPaddingTop(), k.right - getPaddingRight(), k.bottom - getPaddingBottom());
            this.i.draw(canvas);
        }
    }

    protected void b(Canvas canvas) {
    }

    protected boolean d(Canvas canvas) {
        boolean f = this.a.f();
        this.a.c(canvas);
        return f;
    }

    protected bh b() {
        return new bh(this);
    }

    private final void o() {
        this.C = null;
        this.D = null;
        if (this.B >= 0) {
            bc r = r(this.B);
            if (r.b != null) {
                r.b.setPressed(false);
            }
            this.B = -1;
        }
    }

    private final boolean p() {
        return this.C != null || this.B >= 0;
    }

    private final void a(int i) {
        if (c || this.C == null) {
            this.C = new ba(this, i);
            t.a(this.C, (long) dv.c());
            return;
        }
        throw new AssertionError();
    }

    private final void a(Runnable runnable) {
        if (c || this.D == null) {
            if (this.C != null) {
                this.C.run();
                this.C = null;
            }
            if (!c && this.B < 0) {
                throw new AssertionError();
            } else if (this.B >= 0) {
                this.D = new bb(this, runnable);
                t.a(this.D, (long) dv.e());
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    private final void j(int i, int i2) {
        if (i2 > 0) {
            o();
            this.A = -1;
            this.j += i2;
            bc[] bcVarArr = new bc[i2];
            for (int i3 = 0; i3 < bcVarArr.length; i3++) {
                bcVarArr[i3] = new bc(i + i3);
            }
            this.b.addAll(i, Arrays.asList(bcVarArr));
            i();
        }
    }

    private final void k(int i, int i2) {
        if (i2 > 0) {
            o();
            this.A = -1;
            d(i, i2, this.b.size() - i2);
            j();
        }
    }

    private final void c(int i, int i2, int i3) {
        if (i2 > 0 && i != i3) {
            o();
            this.A = -1;
            d(i, i2, i3);
            i();
        }
    }

    private final void l(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            bc r = r(i3);
            r.a(true);
            r.f = -1;
            r.g = -1;
        }
        i();
    }

    private final void b(int i) {
        o();
        this.A = -1;
        this.j = i;
        this.b.ensureCapacity(this.j);
        for (int i2 = 0; i2 < this.j; i2++) {
            if (i2 < this.b.size()) {
                bc r = r(i2);
                r.a(true);
                r.f = -1;
                r.g = -1;
            } else {
                this.b.add(new bc(i2));
            }
        }
        i();
    }

    private final void d(int i, int i2, int i3) {
        int i4 = 0;
        if (i != i3) {
            bc[] bcVarArr = (bc[]) this.b.subList(i, i + i2).toArray(new bc[0]);
            int i5;
            int min;
            if (i < i3) {
                i5 = i + i2;
                min = Math.min(i3 + i2, this.b.size());
                while (i5 < min) {
                    this.b.set(i, this.b.get(i5));
                    i5++;
                    i++;
                }
                i5 = min - i2;
                while (i4 < bcVarArr.length) {
                    this.b.set(i5, bcVarArr[i4]);
                    i4++;
                    i5++;
                }
            } else {
                min = i - 1;
                i5 = (i + i2) - 1;
                while (min >= i3) {
                    this.b.set(i5, this.b.get(min));
                    min--;
                    i5--;
                }
                while (i4 < bcVarArr.length) {
                    this.b.set(i3, bcVarArr[i4]);
                    i4++;
                    i3++;
                }
            }
            q();
        }
    }

    private final void q() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((bc) this.b.get(i)).a = i;
        }
    }

    protected final void h() {
        super.requestLayout();
    }

    protected final void i() {
        if (this.m) {
            this.m = false;
            j();
        }
    }

    protected final void j() {
        if (this.l) {
            this.l = false;
            k();
        }
    }

    protected final void k() {
        if (this.k) {
            this.k = false;
            invalidate();
        }
    }

    protected final void l() {
        if (!this.n && !this.k) {
            Iterator it;
            this.n = true;
            while (true) {
                int intValue;
                s();
                r();
                it = this.e.iterator();
                while (it.hasNext()) {
                    intValue = ((Integer) it.next()).intValue();
                    if (intValue >= 0 && intValue < this.j) {
                        d(intValue);
                    }
                }
                for (int i : this.w) {
                    if (!this.e.contains(Integer.valueOf(i))) {
                        d(i);
                    }
                }
                for (int i2 : this.x) {
                    if (!this.e.contains(Integer.valueOf(i2))) {
                        d(i2);
                    }
                }
                this.k = true;
                if (this.m && this.l && this.k) {
                    break;
                }
            }
            it = this.d.iterator();
            while (it.hasNext()) {
                bc bcVar = (bc) it.next();
                if (!c && bcVar.b == null) {
                    throw new AssertionError();
                } else if (!(bcVar.d() || bcVar.e() || bcVar.b.getVisibility() != 0)) {
                    bcVar.b.setVisibility(4);
                }
            }
            this.n = false;
        }
    }

    protected final int[] m() {
        return this.w;
    }

    private final void r() {
        int i = 0;
        Rect viewportBounds = getViewportBounds();
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            bc r = r(i2);
            r.d(false);
            r.f(false);
        }
        if (viewportBounds.equals(getPreviewBounds())) {
            this.w = a(viewportBounds);
            for (int r2 : this.w) {
                int r22;
                r(r22).d(true);
            }
            if (this.x.length > 0) {
                this.x = new int[0];
                return;
            }
            return;
        }
        int[] a = a(getPreviewBounds());
        ArrayList arrayList = new ArrayList(a.length);
        ArrayList arrayList2 = new ArrayList(a.length);
        for (int i3 : a) {
            bc r3 = r(i3);
            if (viewportBounds.intersects(r3.h, r3.i, r3.k, r3.j)) {
                arrayList.add(Integer.valueOf(i3));
                r3.d(true);
            } else {
                arrayList2.add(Integer.valueOf(i3));
                r3.f(true);
            }
        }
        this.w = new int[arrayList.size()];
        for (r22 = 0; r22 < this.w.length; r22++) {
            this.w[r22] = ((Integer) arrayList.get(r22)).intValue();
        }
        this.x = new int[arrayList2.size()];
        while (i < this.x.length) {
            this.x[i] = ((Integer) arrayList2.get(i)).intValue();
            i++;
        }
    }

    private final void d(int i) {
        if (!c && !this.m) {
            throw new AssertionError();
        } else if (!c && !this.l) {
            throw new AssertionError();
        } else if (c || this.z != null) {
            bc r = r(i);
            int g = r.k - r.h;
            int h = r.j - r.i;
            boolean e = e(i);
            if (r.b.getVisibility() != 0) {
                r.b.setVisibility(0);
            }
            if (e) {
                if (c || !r.b()) {
                    k(i);
                    if (r.f != g) {
                        j();
                    }
                    if (r.g != h) {
                        j();
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (r.f != g || r.g != h) {
                return;
            }
            if (r.b()) {
                r.b.offsetLeftAndRight(r.h - r.b.getLeft());
                r.b.offsetTopAndBottom(r.i - r.b.getTop());
                return;
            }
            r.b.layout(r.h, r.i, r.k, r.j);
            r.b(true);
        } else {
            throw new AssertionError();
        }
    }

    protected final void k(int i) {
        bc r = r(i);
        e(i);
        r.b.a();
        r.b.measure(r.d, r.e);
        r.f = r.b.getMeasuredWidth();
        r.g = r.b.getMeasuredHeight();
    }

    private final boolean e(int i) {
        boolean z = true;
        if (c || this.m) {
            boolean z2;
            boolean z3;
            bc r = r(i);
            int g = r.k - r.h;
            int h = r.j - r.i;
            boolean z4 = r.b == null;
            if (r.a() || z4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && r.f == g && r.g == h) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (r.b == null) {
                if (c || !r.b()) {
                    ListIterator listIterator = this.d.listIterator();
                    while (listIterator.hasNext()) {
                        bc bcVar = (bc) listIterator.next();
                        if (c || bcVar.c != null) {
                            if (bcVar.c.getAnimation() == null && !bcVar.d() && !bcVar.f() && !bcVar.e()) {
                                r.b = bcVar.b;
                                r.b.b = r;
                                r.c = bcVar.c;
                                bcVar.b = null;
                                bcVar.c = null;
                                bcVar.b(false);
                                listIterator.remove();
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                throw new AssertionError();
            }
            if (r.b == null) {
                if (c || !r.b()) {
                    bd n = n();
                    r.b = n;
                    r.b.b = r;
                    addViewInLayout(n, -1, new LayoutParams(-2, -2), true);
                } else {
                    throw new AssertionError();
                }
            }
            if (c || r.b != null) {
                if (z2) {
                    if (c || !r.b()) {
                        View d = this.z.d(i, r.c, r.b);
                        if (!c && d == null) {
                            throw new AssertionError();
                        } else if (r.c == null) {
                            r.b.addView(d);
                            r.c = d;
                        } else if (r.c != d) {
                            if (r.c.getAnimation() == null) {
                                r.b.removeView(r.c);
                            }
                            r.b.addView(d);
                            r.c = d;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
                r.a(false);
                if (!r.b() || z3) {
                    z = false;
                }
                r.b(z);
                if (z4) {
                    this.d.add(r);
                }
                return z3;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final void b(int i, boolean z) {
        bc r = r(i);
        if (r.e() != z) {
            r.e(z);
            if (z) {
                this.e.add(Integer.valueOf(i));
            } else {
                this.e.remove(Integer.valueOf(i));
            }
            k();
        }
    }

    private final void s() {
        if (!this.l) {
            u();
            if (this.r) {
                t();
            } else {
                a();
            }
            this.l = true;
        }
    }

    private final void t() {
        if (this.q != null) {
            Rect rect = (Rect) dv.g.a();
            Rect rect2 = (Rect) dv.g.a();
            rect.set(this.a.k());
            rect.left += getPaddingLeft();
            rect.top += getPaddingTop();
            rect.right -= getPaddingRight();
            rect.bottom -= getPaddingBottom();
            be beVar = (be) this.q.getLayoutParams();
            Gravity.apply(beVar.a, this.q.getMeasuredWidth(), this.q.getMeasuredHeight(), rect, rect2);
            switch (beVar.a & 7) {
                case 3:
                    rect2.offset(beVar.leftMargin, 0);
                    break;
                case 5:
                    rect2.offset(-beVar.rightMargin, 0);
                    break;
                default:
                    rect2.offset(beVar.leftMargin - beVar.rightMargin, 0);
                    break;
            }
            switch (beVar.a & 112) {
                case j.a /*48*/:
                    rect2.offset(0, beVar.topMargin);
                    break;
                case 80:
                    rect2.offset(0, -beVar.bottomMargin);
                    break;
                default:
                    rect2.offset(0, beVar.topMargin - beVar.bottomMargin);
                    break;
            }
            this.q.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            dv.g.a(rect2);
            dv.g.a(rect);
        }
    }

    private final void u() {
        boolean z = false;
        if (!this.m) {
            int a = a(this.o, this.p);
            if (a != 0) {
                for (int i = 0; i < this.j; i++) {
                    bc r = r(i);
                    r.f = -1;
                    r.g = -1;
                    r.b(false);
                }
            }
            if ((a & -1) == -1) {
                z = true;
            }
            this.r = z;
            if (this.q != null) {
                removeViewInLayout(this.q);
            }
            if (this.r) {
                this.q = this.z != null ? this.z.a(this.q, this) : null;
                if (this.q != null) {
                    LayoutParams g;
                    if (this.q.getLayoutParams() == null) {
                        g = g();
                    } else if (this.q.getLayoutParams() instanceof be) {
                        be beVar = (be) this.q.getLayoutParams();
                    } else if (this.q.getLayoutParams() instanceof MarginLayoutParams) {
                        g = new be((MarginLayoutParams) this.q.getLayoutParams());
                    } else {
                        g = new be(this.q.getLayoutParams());
                    }
                    addViewInLayout(this.q, -1, g, true);
                }
                v();
            } else {
                this.q = null;
            }
            this.m = true;
        }
    }

    private final void v() {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.q == null) {
            g(resolveSize(paddingLeft, this.o), resolveSize(paddingTop, this.p));
            return;
        }
        be beVar = (be) this.q.getLayoutParams();
        if (c || beVar != null) {
            int i = beVar.leftMargin + beVar.rightMargin;
            int i2 = beVar.topMargin + beVar.bottomMargin;
            int childMeasureSpec = getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, beVar.width);
            int childMeasureSpec2 = getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, beVar.height);
            this.q.measure(childMeasureSpec, childMeasureSpec2);
            int max = Math.max((paddingLeft + i) + this.q.getMeasuredWidth(), getSuggestedMinimumWidth());
            int max2 = Math.max((paddingTop + i2) + this.q.getMeasuredHeight(), getSuggestedMinimumHeight());
            max = resolveSize(max, this.o);
            max2 = resolveSize(max2, this.p);
            if (beVar.width == -1 || beVar.height == -1) {
                if (beVar.width == -1) {
                    childMeasureSpec = MeasureSpec.makeMeasureSpec((max - paddingLeft) - i, 1073741824);
                }
                this.q.measure(childMeasureSpec, beVar.height == -1 ? MeasureSpec.makeMeasureSpec((max2 - paddingTop) - i2, 1073741824) : childMeasureSpec2);
            }
            g(Math.max(max, (paddingLeft + i) + this.q.getMeasuredWidth()), Math.max(max2, (paddingTop + i2) + this.q.getMeasuredHeight()));
            return;
        }
        throw new AssertionError();
    }

    protected bd n() {
        return new bd(this, getContext());
    }

    protected final void a(int i, int i2, int i3, int i4, int i5) {
        if (c || this.z != null) {
            bc r = r(i);
            r.h = i2;
            r.i = i3;
            r.k = i4;
            r.j = i5;
            return;
        }
        throw new AssertionError();
    }

    protected final void c(int i, int i2, int i3, int i4) {
        this.s = i3 - i;
        this.t = i4 - i2;
        this.a.a(i, i2, i3, i4);
    }

    protected final void g(int i, int i2) {
        this.s = i;
        this.t = i2;
        this.a.a(this.s);
        this.a.b(this.t);
    }

    protected final boolean a(int i, Point point) {
        bc r = r(i);
        return point.x >= r.h && point.y >= r.i && point.x < r.k && point.y < r.j;
    }

    protected final boolean c(int i, Rect rect) {
        bc r = r(i);
        return rect.intersects(r.h, r.i, r.k, r.j);
    }

    protected final int l(int i) {
        return r(i).h;
    }

    protected final int m(int i) {
        return r(i).i;
    }

    protected final int n(int i) {
        return r(i).k;
    }

    protected final int o(int i) {
        return r(i).j;
    }

    protected final void h(int i, int i2) {
        r(i).d = i2;
    }

    protected final void i(int i, int i2) {
        r(i).e = i2;
    }

    protected final int p(int i) {
        return r(i).f;
    }

    protected final int q(int i) {
        return r(i).g;
    }

    protected final bc r(int i) {
        if (!s(i)) {
            return null;
        }
        bc bcVar = (bc) this.b.get(i);
        if (c || bcVar != null) {
            return bcVar;
        }
        throw new AssertionError();
    }

    protected final boolean s(int i) {
        return i >= 0 && i < this.b.size();
    }

    protected final int getCellsMarginHorizontal() {
        return getCellsMarginLeft() + getCellsMarginRight();
    }

    protected final int getCellsMarginVertical() {
        return getCellsMarginTop() + getCellsMarginBottom();
    }

    protected final int getCellsMarginLeft() {
        return getPaddingLeft() + this.f.left;
    }

    protected final int getCellsMarginTop() {
        return getPaddingTop() + this.f.top;
    }

    protected final int getCellsMarginRight() {
        return getPaddingRight() + this.f.right;
    }

    protected final int getCellsMarginBottom() {
        return getPaddingBottom() + this.f.bottom;
    }
}
