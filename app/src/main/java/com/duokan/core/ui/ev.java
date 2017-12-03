package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;

import org.apache.http.HttpStatus;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import miuipub.date.Calendar;

public abstract class ev implements Scrollable {
    static final /* synthetic */ boolean c = (!ev.class.desiredAssertionStatus());
    private fe A = null;
    private long B = SystemClock.elapsedRealtime();
    private long C = 0;
    private Runnable D = null;
    private cf E = null;
    private cg F = null;
    private boolean G = false;
    private boolean H = false;
    private final Rect I = new Rect();
    private final Rect J = new Rect();
    private final Drawable[] K = new Drawable[2];
    private final Rect L = new Rect();
    private final Rect M = new Rect();
    private final Drawable[] N = new Drawable[2];
    private final ViewGroup a;
    private final bx b;
    private final et d = new et();
    private final et e = new et();
    private final ct f = new ct();
    private final bu g = new bu();
    private final RectF h = new RectF();
    private final Rect i = new Rect();
    private final Rect j = new Rect();
    private final LinkedList k = new LinkedList();
    private final LinkedList l = new LinkedList();
    private final Rect m = new Rect();
    private final Rect n = new Rect();
    private OverScrollMode o = OverScrollMode.STRETCH;
    private OverScrollMode p = OverScrollMode.STRETCH;
    private int q = 0;
    private int r = 0;
    private ScrollState s = ScrollState.IDLE;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private boolean y = true;
    private boolean z = true;

    protected abstract void a(int i, int i2);

    protected abstract void a(Canvas canvas);

    protected ev(ViewGroup viewGroup) {
        this.a = viewGroup;
        this.b = new bx(this.a.getContext());
        this.d.a(new ff(this));
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.h.set(0.0f, 0.0f, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
        this.h.round(this.i);
        this.j.set(this.i);
        this.J.set(0, UTools.closeAnimation(this.a.getContext(), 2.0f), UTools.closeAnimation(this.a.getContext(), 2.0f), UTools.closeAnimation(this.a.getContext(), 6.0f));
        this.K[0] = this.a.getResources().getDrawable(e.general__shared__thumb_default_vert);
        this.K[1] = this.a.getResources().getDrawable(e.general__shared__thumb_seek_vert);
        this.M.set(UTools.closeAnimation(this.a.getContext(), 2.0f), 0, UTools.closeAnimation(this.a.getContext(), 6.0f), UTools.closeAnimation(this.a.getContext(), 2.0f));
        this.N[0] = this.a.getResources().getDrawable(e.general__shared__thumb_default_horz);
        this.e.a(this.f);
        this.e.a(this.g);
        this.e.a(new fd());
    }

    public boolean b(MotionEvent motionEvent) {
        if (!this.a.isEnabled()) {
            return false;
        }
        a(motionEvent);
        return this.d.a(this.a, motionEvent);
    }

    public boolean c(MotionEvent motionEvent) {
        if (!this.a.isEnabled()) {
            return false;
        }
        a(motionEvent);
        this.d.onTouch(this.a, motionEvent);
        if (this.s == ScrollState.IDLE) {
            this.e.onTouch(this.a, motionEvent);
        } else {
            this.e.a(this.a);
        }
        return true;
    }

    public void c() {
        for (ViewParent parent = this.a.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ch) {
                this.l.add((ch) parent);
            }
        }
    }

    public void d() {
        ao();
        a(ScrollState.IDLE);
        this.l.clear();
    }

    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            f(0.0f, 0.0f);
        }
        if (this.D == null) {
            this.D = new ew(this);
            UTools.addAnimation(this.a, this.D);
        }
    }

    public void b(Canvas canvas) {
        int ae = ae();
        int af = af();
        if (ae > 0 || af > 0) {
            float width = this.h.width() / ((float) this.i.width());
            float height = this.h.height() / ((float) this.i.height());
            canvas.save();
            if (canvas.isHardwareAccelerated()) {
                canvas.translate((float) this.i.left, (float) this.i.top);
                canvas.scale(width, height);
                canvas.translate((float) (-this.i.left), (float) (-this.i.top));
            } else {
                canvas.scale(width, height);
            }
            a(canvas);
            canvas.restore();
            return;
        }
        a(canvas);
    }

    public void c(Canvas canvas) {
        if (this.H) {
            Drawable ay;
            int ap = ap();
            if (!this.L.isEmpty()) {
                ay = ay();
                canvas.save();
                canvas.translate((float) this.i.left, (float) this.i.top);
                canvas.clipRect(this.L);
                ay.setBounds(this.L);
                ay.setAlpha(ap);
                ay.draw(canvas);
                canvas.restore();
            }
            if (!this.I.isEmpty()) {
                ay = az();
                canvas.save();
                canvas.translate((float) this.i.left, (float) this.i.top);
                canvas.clipRect(this.I);
                ay.setBounds(this.I);
                ay.setAlpha(ap);
                ay.draw(canvas);
                canvas.restore();
            }
            if (ap > 0) {
                this.a.invalidate();
            }
        }
    }

    public void b(boolean z) {
        if (z) {
            this.d.a(this.a);
        }
    }

    public boolean a(View view, Rect rect, boolean z) {
        boolean z2;
        Rect e = e();
        if (e.isEmpty()) {
            e.set(getViewportBounds());
            z2 = true;
        } else {
            z2 = false;
        }
        if (e.isEmpty()) {
            return true;
        }
        int b;
        int c;
        Rect rect2 = new Rect(rect);
        UTools.closeAnimation(rect2, view, this.a);
        if (rect2.intersect(this.m)) {
            b = b(e, rect2);
            c = c(e, rect2);
        } else {
            c = 0;
            b = 0;
        }
        if (!(b == 0 && c == 0)) {
            if (z) {
                c(b, c);
            } else {
                b(b, c, HttpStatus.SC_OK, null, null);
            }
        }
        if (z2) {
            return false;
        }
        return true;
    }

    public boolean b(View view, boolean z) {
        return a(view, new Rect(0, 0, view.getWidth(), view.getHeight()), z);
    }

    public Rect e() {
        Rect rect = new Rect();
        UTools.getRect(rect, this.a.getRootView(), this.a);
        rect.intersect(getViewportBounds());
        return rect;
    }

    public boolean f() {
        return ap() > 0;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public void b(int i, int i2) {
        a(this.m.left, this.m.top, this.m.left + i, this.m.top + i2);
    }

    public void a(int i) {
        a(this.m.left, this.m.top, this.m.left + i, this.m.bottom);
    }

    public void b(int i) {
        a(this.m.left, this.m.top, this.m.right, this.m.top + i);
    }

    public Rect k() {
        return this.m;
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.m.left != i || this.m.top != i2 || this.m.right != i3 || this.m.bottom != i4) {
            this.n.set(this.m);
            this.m.set(i, i2, i3, i4);
            if (this.E != null) {
                this.E.a(this, this.n, this.m);
            }
            if (this.s == ScrollState.FLING) {
                this.b.a(this.i.left, this.i.top, Math.round(Math.signum(this.b.d())), Math.round(Math.signum(this.b.e())), al(), am(), b(), an(), ak(), a());
            }
        }
    }

    public boolean l() {
        return true;
    }

    public int m() {
        return Math.max(0, Math.min(this.i.right, this.m.right) - Math.max(this.m.left, this.i.left));
    }

    public int n() {
        return Math.max(0, Math.min(this.i.left - this.m.left, this.m.width()));
    }

    public int o() {
        return this.m.width();
    }

    public int p() {
        return Math.max(0, Math.min(this.i.bottom, this.m.bottom) - Math.max(this.m.top, this.i.top));
    }

    public int q() {
        return Math.max(0, Math.min(this.i.top - this.m.top, this.m.height()));
    }

    public int r() {
        return this.m.height();
    }

    public int s() {
        return this.m.width();
    }

    public int t() {
        return this.m.height();
    }

    public boolean u() {
        return this.H;
    }

    public void c(boolean z) {
        this.H = z;
        this.a.invalidate();
    }

    public boolean v() {
        return this.G;
    }

    public void d(boolean z) {
        this.G = z;
    }

    public void e(boolean z) {
        this.z = z;
    }

    public int w() {
        return this.M.left;
    }

    public int x() {
        return this.M.top;
    }

    public int y() {
        return this.M.right;
    }

    public int z() {
        return this.M.bottom;
    }

    public int A() {
        return this.J.left;
    }

    public int B() {
        return this.J.top;
    }

    public int C() {
        return this.J.right;
    }

    public int D() {
        return this.J.bottom;
    }

    public void b(int i, int i2, int i3, int i4) {
        this.J.set(i, i2, i3, i4);
    }

    public Drawable E() {
        return this.N[0];
    }

    public void a(Drawable drawable) {
        this.N[0] = drawable;
    }

    public Drawable F() {
        return this.K[0];
    }

    public void b(Drawable drawable) {
        this.K[0] = drawable;
    }

    public Drawable G() {
        return this.N[1];
    }

    public void c(Drawable drawable) {
        this.N[1] = drawable;
    }

    public Drawable H() {
        return this.K[1];
    }

    public void d(Drawable drawable) {
        this.K[1] = drawable;
    }

    public et I() {
        return this.d;
    }

    public ScrollState getScrollState() {
        return this.s;
    }

    public int getIdleTime() {
        if (this.s == ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.B);
        }
        return 0;
    }

    public int J() {
        if (this.s != ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.C);
        }
        return 0;
    }

    public int K() {
        return this.b.f();
    }

    public int L() {
        return this.b.g();
    }

    public void a(Interpolator interpolator) {
        this.b.a(interpolator);
    }

    public void a(View view, boolean z) {
        ListIterator listIterator = this.k.listIterator();
        while (listIterator.hasNext()) {
            View view2 = (View) ((WeakReference) listIterator.next()).get();
            if (view2 == null) {
                listIterator.remove();
            } else if (view2 == view) {
                if (!z) {
                    listIterator.remove();
                    return;
                }
                return;
            }
        }
        if (z) {
            this.k.add(new WeakReference(view));
        }
    }

    public OverScrollMode M() {
        return this.o;
    }

    public void a(OverScrollMode overScrollMode) {
        this.o = overScrollMode;
    }

    public OverScrollMode N() {
        return this.p;
    }

    public void b(OverScrollMode overScrollMode) {
        this.p = overScrollMode;
    }

    public int O() {
        return this.q;
    }

    public void c(int i) {
        this.q = i;
    }

    public int getMaxOverScrollHeight() {
        return this.r;
    }

    public void d(int i) {
        this.r = i;
    }

    public Rect getViewportBounds() {
        return this.i;
    }

    public Rect P() {
        return new Rect(this.i);
    }

    public void a(cf cfVar) {
        this.E = cfVar;
    }

    public void a(cg cgVar) {
        this.F = cgVar;
    }

    public boolean Q() {
        if (this.m.width() > ((int) this.h.width())) {
            return true;
        }
        switch (ey.a[this.o.ordinal()]) {
            case 1:
                if (this.q <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public boolean R() {
        if (this.m.height() > ((int) this.h.height())) {
            return true;
        }
        switch (ey.a[this.p.ordinal()]) {
            case 1:
                if (this.r <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public boolean S() {
        return ak() > 0;
    }

    public boolean T() {
        return a() > 0;
    }

    public boolean U() {
        return this.a.getScrollX() <= al();
    }

    public boolean V() {
        return this.a.getScrollX() >= am();
    }

    public boolean W() {
        return this.a.getScrollY() <= b();
    }

    public boolean X() {
        return this.a.getScrollY() >= an();
    }

    public boolean e(int i) {
        if (i < 0 || i >= this.a.getChildCount()) {
            return false;
        }
        View childAt = this.a.getChildAt(i);
        if (childAt.getVisibility() != 8) {
            return this.i.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
        return false;
    }

    public void c(int i, int i2) {
        ao();
        a(ScrollState.IDLE);
        b((float) i, (float) i2);
    }

    public void d(int i, int i2) {
        ao();
        a(ScrollState.IDLE);
        c((float) i, (float) i2);
    }

    public void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.b.a(true);
        a(ScrollState.SMOOTH);
        a(((float) i) - this.h.left, ((float) i2) - this.h.top, i3, false, new ez(this, runnable), new fa(this, runnable2));
    }

    public void b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.b.a(true);
        a(ScrollState.SMOOTH);
        a((float) i, (float) i2, i3, false, new fb(this, runnable), new fc(this, runnable2));
    }

    public void e(int i, int i2) {
        ao();
        a(ScrollState.IDLE);
        g((float) i, (float) i2);
    }

    public void Y() {
        int al = al();
        int am = am();
        int b = b();
        int an = an();
        al = Math.max(al, Math.min(this.i.left, am));
        am = Math.max(b, Math.min(this.i.top, an));
        if (this.i.left != al || this.i.top != am) {
            d(al, am);
        }
    }

    public void Z() {
        int al = al();
        int am = am();
        int b = b();
        int an = an();
        al = Math.max(al, Math.min(this.i.left, am));
        am = Math.max(b, Math.min(this.i.top, an));
        if (this.i.left != al || this.i.top != am) {
            ao();
            a(ScrollState.SMOOTH);
            a(0.0f, 0.0f, new ex(this), null);
        }
    }

    public void a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        Point a = a(rect, rect2);
        b(a.x, a.y, i, runnable, runnable2);
    }

    public Point a(Point point) {
        point.x -= this.i.left;
        point.y -= this.i.top;
        return point;
    }

    public Point b(Point point) {
        point.x += this.i.left;
        point.y += this.i.top;
        return point;
    }

    public Rect b(Rect rect) {
        rect.offset(this.i.left, this.i.top);
        return rect;
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
    }

    protected void a(boolean z) {
    }

    protected void a(MotionEvent motionEvent) {
    }

    protected void a(PointF pointF) {
    }

    protected void b(PointF pointF) {
    }

    protected void c(PointF pointF) {
    }

    protected void d(PointF pointF) {
        this.a.performClick();
    }

    protected void e(PointF pointF) {
        this.a.performLongClick();
    }

    protected int aa() {
        return UTools.getScaledTouchSlop(this.a.getContext());
    }

    protected int ab() {
        return 0;
    }

    protected final void b(float f, float f2) {
        ao();
        d(f, f2);
    }

    protected final void c(float f, float f2) {
        ao();
        e(f, f2);
    }

    protected final void d(float f, float f2) {
        e(this.h.left + f, this.h.top + f2);
    }

    protected final void e(float f, float f2) {
        g(Math.max((float) ag(), Math.min(f, (float) ah())), Math.max((float) ai(), Math.min(f2, (float) aj())));
    }

    protected final void f(float f, float f2) {
        g(this.h.left + f, this.h.top + f2);
    }

    protected final void g(float f, float f2) {
        boolean z;
        this.h.set(f, f2, ((float) this.a.getWidth()) + f, ((float) this.a.getHeight()) + f2);
        this.h.round(this.i);
        a(this.s, this.h);
        this.h.round(this.i);
        if (this.o == OverScrollMode.STRETCH) {
            if (this.i.left < al() && this.j.left >= al()) {
                this.i.left = al();
            }
            if (this.i.left > am() && this.j.right <= am() + ((int) this.h.width())) {
                this.i.right = am() + ((int) this.h.width());
            }
        }
        if (this.p == OverScrollMode.STRETCH) {
            if (this.i.top < b() && this.j.top >= b()) {
                this.i.top = b();
            }
            if (this.i.top > an() && this.j.bottom <= an() + ((int) this.h.height())) {
                this.i.bottom = an() + ((int) this.h.height());
            }
        }
        if (this.i.equals(this.j)) {
            z = false;
        } else {
            z = true;
        }
        this.j.set(this.i);
        a(this.i.left, this.i.top);
        if (z) {
            this.a.invalidate();
        }
        av();
        as();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view != null) {
                view.invalidate();
            }
        }
        a(z);
        g(z);
    }

    protected void a(ScrollState scrollState, RectF rectF) {
    }

    protected void a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        a((-f3) * a(-f3), (-f4) * b(-f4), runnable, runnable2);
    }

    protected void ac() {
    }

    protected void h(float f, float f2) {
        c(((float) al()) + (((float) (am() - al())) * f), ((float) b()) + (((float) (an() - b())) * f2));
    }

    protected void ad() {
    }

    protected void a(ScrollState scrollState, float f, float f2) {
    }

    protected void a(float f, float f2) {
        c(((-f) * a(-f)) + this.h.left, ((-f2) * b(-f2)) + this.h.top);
    }

    protected void b(ScrollState scrollState, float f, float f2) {
    }

    protected void a(float f, float f2, Runnable runnable, Runnable runnable2) {
        a(f, f2, al(), am(), b(), an(), runnable, runnable2);
    }

    protected final void a(float f, float f2, int i, int i2, int i3, int i4, Runnable runnable, Runnable runnable2) {
        this.b.a(Math.round(this.h.left), Math.round(this.h.top), Math.round(f), Math.round(f2), i, i2, i3, i4, ak(), a());
        this.A = new fe(this, false, runnable, runnable2);
        this.a.post(this.A);
    }

    protected void a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (!z) {
            f = Math.max((float) (ag() - this.i.left), Math.min(f, (float) (ah() - this.i.left)));
            f2 = Math.max((float) (ai() - this.i.top), Math.min(f2, (float) (aj() - this.i.top)));
        }
        this.b.a(Math.round(this.h.left), Math.round(this.h.top), Math.round(f), Math.round(f2), i);
        this.A = new fe(this, z, runnable, runnable2);
        this.a.post(this.A);
    }

    protected final void a(float f, float f2, int i, int i2, Runnable runnable, Runnable runnable2) {
        this.b.b(Math.round(this.h.left), Math.round(this.h.top), i, i2, Math.round(f), Math.round(f2));
        this.A = new fe(this, false, runnable, runnable2);
        this.a.post(this.A);
    }

    protected final int ae() {
        return ((int) this.h.width()) - this.i.width();
    }

    protected final int af() {
        return ((int) this.h.height()) - this.i.height();
    }

    private final void ao() {
        this.b.a(true);
        this.A = null;
    }

    private final void a(ScrollState scrollState) {
        if (this.s != scrollState) {
            ScrollState scrollState2 = this.s;
            this.s = scrollState;
            if (this.s == ScrollState.IDLE) {
                this.B = SystemClock.elapsedRealtime();
            } else {
                this.C = SystemClock.elapsedRealtime();
            }
            if (this.s == ScrollState.IDLE || this.s == ScrollState.SMOOTH) {
                this.t = false;
                this.u = false;
                this.v = false;
                this.w = false;
            }
            a(scrollState2, this.s);
            b(scrollState2, this.s);
        }
    }

    private final int ap() {
        float f = 1.0f;
        if (!this.H) {
            f = 0.0f;
        } else if (getScrollState() == ScrollState.IDLE) {
            int idleTime = getIdleTime();
            if (idleTime > Calendar.MILLISECOND_OF_SECOND) {
                f = idleTime < 1200 ? ((float) (1200 - idleTime)) / 200.0f : 0.0f;
            }
        }
        return (int) (f * 255.0f);
    }

    protected Point a(Rect rect, Rect rect2) {
        int i;
        int i2 = 0;
        Rect b = b(new Rect(rect2));
        if (rect.left < b.left) {
            i = (rect.left - b.left) + 0;
        } else if (rect.right > b.right) {
            i = (rect.right - b.right) + 0;
        } else {
            i = 0;
        }
        if (rect.top < b.top) {
            i2 = 0 + (rect.top - b.top);
        } else if (rect.bottom > b.bottom) {
            i2 = 0 + (rect.bottom - b.bottom);
        }
        return new Point(i, i2);
    }

    protected float a(float f) {
        float ag = (float) ag();
        float ah = (float) ah();
        float al = (float) al();
        float am = (float) am();
        float f2 = this.h.left;
        if (Float.compare(f2, al) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, am) < 0 || Float.compare(f, 0.0f) <= 0) {
                ag = 1.0f;
            } else if (Float.compare(ah, (float) this.m.right) == 0) {
                ag = 0.0f;
            } else if (Float.compare(f2, ah) >= 0) {
                ag = 0.0f;
            } else {
                ag = Math.abs((f2 - ah) / (am - ah));
            }
        } else if (Float.compare(ag, (float) this.m.left) == 0) {
            ag = 0.0f;
        } else if (Float.compare(f2, ag) <= 0) {
            ag = 0.0f;
        } else {
            ag = Math.abs((f2 - ag) / (al - ag));
        }
        if (c || Float.compare(ag, 0.0f) >= 0) {
            return ag;
        }
        throw new AssertionError();
    }

    protected float b(float f) {
        float ai = (float) ai();
        float aj = (float) aj();
        float b = (float) b();
        float an = (float) an();
        float f2 = this.h.top;
        if (Float.compare(f2, b) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, an) < 0 || Float.compare(f, 0.0f) <= 0) {
                ai = 1.0f;
            } else if (Float.compare(aj, (float) this.m.bottom) == 0) {
                ai = 0.0f;
            } else if (Float.compare(f2, aj) >= 0) {
                ai = 0.0f;
            } else {
                ai = Math.abs((f2 - aj) / (an - aj));
            }
        } else if (Float.compare(ai, (float) this.m.top) == 0) {
            ai = 0.0f;
        } else if (Float.compare(f2, ai) <= 0) {
            ai = 0.0f;
        } else {
            ai = Math.abs((f2 - ai) / (b - ai));
        }
        if (c || Float.compare(ai, 0.0f) >= 0) {
            return ai;
        }
        throw new AssertionError();
    }

    private float aq() {
        if (am() - al() == 0) {
            return 0.0f;
        }
        return (this.h.left - ((float) al())) / ((float) (am() - al()));
    }

    private float ar() {
        if (an() - b() == 0) {
            return 0.0f;
        }
        return (this.h.top - ((float) b())) / ((float) (an() - b()));
    }

    protected int ag() {
        return al() - ak();
    }

    protected int ah() {
        return am() + ak();
    }

    protected int ai() {
        return b() - a();
    }

    protected int aj() {
        return an() + a();
    }

    protected int ak() {
        switch (ey.a[this.o.ordinal()]) {
            case 1:
                return this.q;
            case 2:
            case 3:
                return this.m.width() > ((int) this.h.width()) ? this.q : 0;
            default:
                return 0;
        }
    }

    protected int a() {
        switch (ey.a[this.p.ordinal()]) {
            case 1:
                return this.r;
            case 2:
            case 3:
                return this.m.height() > ((int) this.h.height()) ? this.r : 0;
            default:
                return 0;
        }
    }

    protected int al() {
        return Math.min(0, this.m.left);
    }

    protected int b() {
        return Math.min(0, this.m.top);
    }

    protected int am() {
        return Math.max(al(), this.m.right - ((int) this.h.width()));
    }

    protected int an() {
        return Math.max(b(), this.m.bottom - ((int) this.h.height()));
    }

    private final void as() {
        Drawable ay = ay();
        int n = n();
        int m = m();
        int o = o();
        if (ay == null || o == 0 || o <= m) {
            this.L.setEmpty();
            return;
        }
        float f = ((float) n) / ((float) o);
        float f2 = ((float) m) / ((float) o);
        o = aw();
        int aC = aC();
        m = Math.max(o, Math.round(f2 * ((float) aC)));
        n = Math.round(f * ((float) aC)) + this.M.left;
        this.L.set(n, (((int) this.h.height()) - this.M.bottom) - (ay.getIntrinsicHeight() > 0 ? ay.getIntrinsicHeight() : UTools.closeAnimation(this.a.getContext(), 5.0f)), m + n, ((int) this.h.height()) - this.M.bottom);
        if (this.L.right > ((int) this.h.width()) - this.M.right) {
            this.L.offset((((int) this.h.width()) - this.M.right) - this.L.right, 0);
        }
    }

    private final float f(int i) {
        if (at() == 0) {
            return 0.0f;
        }
        return ((float) i) / ((float) at());
    }

    private final float g(int i) {
        if (au() == 0) {
            return 0.0f;
        }
        return ((float) i) / ((float) au());
    }

    private final int at() {
        if (aA() != 1) {
            return 0;
        }
        return aC() - ay().getIntrinsicWidth();
    }

    private final int au() {
        if (aB() != 1) {
            return 0;
        }
        return aD() - az().getIntrinsicHeight();
    }

    private final void av() {
        Drawable az = az();
        int q = q();
        int p = p();
        int r = r();
        if (az == null || r == 0 || r <= p) {
            this.I.setEmpty();
            return;
        }
        float f = ((float) q) / ((float) r);
        float f2 = ((float) p) / ((float) r);
        r = ax();
        int aD = aD();
        int intrinsicWidth = az.getIntrinsicWidth() > 0 ? az.getIntrinsicWidth() : UTools.closeAnimation(this.a.getContext(), 5.0f);
        q = Math.round(f * ((float) aD)) + this.J.top;
        this.I.set((((int) this.h.width()) - intrinsicWidth) - this.J.right, q, ((int) this.h.width()) - this.J.right, Math.max(r, Math.round(f2 * ((float) aD))) + q);
        if (this.I.bottom > ((int) this.h.height()) - this.J.bottom) {
            this.I.offset(0, (((int) this.h.height()) - this.J.bottom) - this.I.bottom);
        }
    }

    private final int aw() {
        Drawable ay = ay();
        return ay.getIntrinsicWidth() > 0 ? ay.getIntrinsicWidth() : UTools.closeAnimation(this.a.getContext(), 5.0f);
    }

    private final int ax() {
        Drawable az = az();
        return az.getIntrinsicHeight() > 0 ? az.getIntrinsicHeight() : UTools.closeAnimation(this.a.getContext(), 5.0f);
    }

    private final Drawable ay() {
        return this.N[aA()];
    }

    private final Drawable az() {
        return this.K[aB()];
    }

    private final int aA() {
        if (!this.G || s() == 0 || aC() == 0) {
            return 0;
        }
        Drawable drawable = this.N[1];
        if (drawable == null) {
            return 0;
        }
        if (this.t) {
            return 1;
        }
        if (Float.compare(((float) this.i.width()) / ((float) s()), ((float) drawable.getIntrinsicWidth()) / ((float) aC())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aB() {
        if (!this.G || t() == 0 || aD() == 0) {
            return 0;
        }
        Drawable drawable = this.K[1];
        if (drawable == null) {
            return 0;
        }
        if (this.u) {
            return 1;
        }
        if (Float.compare(((float) this.i.height()) / ((float) t()), ((float) drawable.getIntrinsicHeight()) / ((float) aD())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aC() {
        return (((int) this.h.width()) - this.M.left) - this.M.right;
    }

    private final int aD() {
        return (((int) this.h.height()) - this.J.top) - this.J.bottom;
    }

    private final void f(boolean z) {
        ViewParent parent = this.a.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    protected static int b(Rect rect, Rect rect2) {
        if (rect.left <= rect2.left && rect.right >= rect2.right) {
            return 0;
        }
        if (rect.left > rect2.left && rect.right < rect2.right) {
            return 0;
        }
        if (rect.left < rect2.left) {
            return Math.min(rect2.left - rect.left, rect2.right - rect.right);
        }
        return -Math.min(rect.left - rect2.left, rect.right - rect2.right);
    }

    protected static int c(Rect rect, Rect rect2) {
        if (rect.top <= rect2.top && rect.bottom >= rect2.bottom) {
            return 0;
        }
        if (rect.top > rect2.top && rect.bottom < rect2.bottom) {
            return 0;
        }
        if (rect.top < rect2.top) {
            return Math.min(rect2.top - rect.top, rect2.bottom - rect.bottom);
        }
        return -Math.min(rect.top - rect2.top, rect.bottom - rect2.bottom);
    }

    private final void b(ScrollState scrollState, ScrollState scrollState2) {
        if (this.F != null) {
            this.F.a(this, scrollState, scrollState2);
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).a(this, scrollState, scrollState2);
        }
    }

    private final void g(boolean z) {
        if (this.F != null) {
            this.F.a(this, z);
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).a(this, z);
        }
    }
}
