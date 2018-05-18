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

import com.duokan.p023b.C0243e;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.http.HttpStatus;

public abstract class ev implements Scrollable {
    
    static final  boolean f920c = (!ev.class.desiredAssertionStatus());
    
    private fe f921A = null;
    
    private long elapsedRealtime = SystemClock.elapsedRealtime();
    
    private long f923C = 0;
    
    private Runnable f924D = null;
    
    private cf f925E = null;
    
    private cg f926F = null;
    
    private boolean f927G = false;
    
    private boolean f928H = false;
    
    private final Rect f929I = new Rect();
    
    private final Rect f930J = new Rect();
    
    private final Drawable[] f931K = new Drawable[2];
    
    private final Rect f932L = new Rect();
    
    private final Rect f933M = new Rect();
    
    private final Drawable[] f934N = new Drawable[2];
    
    private final ViewGroup viewGroup;
    
    private final bx f936b;
    
    private final et f937d = new et();
    
    private final et f938e = new et();
    
    private final ct f939f = new ct();
    
    private final bu f940g = new bu();
    
    private final RectF f941h = new RectF();
    
    private final Rect f942i = new Rect();
    
    private final Rect f943j = new Rect();
    
    private final LinkedList<WeakReference<View>> f944k = new LinkedList();
    
    private final LinkedList<ch> f945l = new LinkedList();
    
    private final Rect f946m = new Rect();
    
    private final Rect f947n = new Rect();
    
    private OverScrollMode scrollMode = OverScrollMode.STRETCH;
    
    private OverScrollMode scrollMode1 = OverScrollMode.STRETCH;
    
    private int f950q = 0;
    
    private int f951r = 0;
    
    private ScrollState scrollState = ScrollState.IDLE;
    
    private boolean f953t = false;
    
    private boolean f954u = false;
    
    private boolean f955v = false;
    
    private boolean f956w = false;
    
    private boolean f957x = true;
    
    private boolean f958y = true;
    
    private boolean f959z = true;

    
    protected abstract void mo491a(int i, int i2);

    
    protected abstract void mo492a(Canvas canvas);

    protected ev(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        this.f936b = new bx(this.viewGroup.getContext());
        this.f937d.m2041a(new ff(this));
        DisplayMetrics displayMetrics = this.viewGroup.getResources().getDisplayMetrics();
        this.f941h.set(0.0f, 0.0f, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
        this.f941h.round(this.f942i);
        this.f943j.set(this.f942i);
        this.f930J.set(0, AnimUtils.m1932b(this.viewGroup.getContext(), 2.0f), AnimUtils.m1932b(this.viewGroup.getContext(), 2.0f), AnimUtils.m1932b(this.viewGroup.getContext(), 6.0f));
        this.f931K[0] = this.viewGroup.getResources().getDrawable(R.drawable.general__shared__thumb_default_vert);
        this.f931K[1] = this.viewGroup.getResources().getDrawable(R.drawable.general__shared__thumb_seek_vert);
        this.f933M.set(AnimUtils.m1932b(this.viewGroup.getContext(), 2.0f), 0, AnimUtils.m1932b(this.viewGroup.getContext(), 6.0f), AnimUtils.m1932b(this.viewGroup.getContext(), 2.0f));
        this.f934N[0] = this.viewGroup.getResources().getDrawable(R.drawable.general__shared__thumb_default_horz);
        this.f938e.m2041a(this.f939f);
        this.f938e.m2041a(this.f940g);
        this.f938e.m2042a(new fd());
    }

    
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.viewGroup.isEnabled()) {
            return false;
        }
        mo502a(motionEvent);
        return this.f937d.m2044a(this.viewGroup, motionEvent);
    }

    
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.viewGroup.isEnabled()) {
            return false;
        }
        mo502a(motionEvent);
        this.f937d.onTouch(this.viewGroup, motionEvent);
        if (this.scrollState == ScrollState.IDLE) {
            this.f938e.onTouch(this.viewGroup, motionEvent);
        } else {
            this.f938e.m2040a(this.viewGroup);
        }
        return true;
    }

    
    public void onAttachedToWindow() {
        for (ViewParent parent = this.viewGroup.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ch) {
                this.f945l.add((ch) parent);
            }
        }
    }

    
    public void onDetachedFromWindow() {
        ao();
        m1416a(ScrollState.IDLE);
        this.f945l.clear();
    }

    
    public void m1504a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            m1545f(0.0f, 0.0f);
        }
        if (this.f924D == null) {
            this.f924D = new ew(this);
            AnimUtils.m1921a(this.viewGroup, this.f924D);
        }
    }

    
    public void mo529b(Canvas canvas) {
        int ae = ae();
        int af = af();
        if (ae > 0 || af > 0) {
            float width = this.f941h.width() / ((float) this.f942i.width());
            float height = this.f941h.height() / ((float) this.f942i.height());
            canvas.save();
            if (canvas.isHardwareAccelerated()) {
                canvas.translate((float) this.f942i.left, (float) this.f942i.top);
                canvas.scale(width, height);
                canvas.translate((float) (-this.f942i.left), (float) (-this.f942i.top));
            } else {
                canvas.scale(width, height);
            }
            mo492a(canvas);
            canvas.restore();
            return;
        }
        mo492a(canvas);
    }

    
    public void m1527c(Canvas canvas) {
        if (this.f928H) {
            Drawable ay;
            int ap = ap();
            if (!this.f932L.isEmpty()) {
                ay = ay();
                canvas.save();
                canvas.translate((float) this.f942i.left, (float) this.f942i.top);
                canvas.clipRect(this.f932L);
                ay.setBounds(this.f932L);
                ay.setAlpha(ap);
                ay.draw(canvas);
                canvas.restore();
            }
            if (!this.f929I.isEmpty()) {
                ay = az();
                canvas.save();
                canvas.translate((float) this.f942i.left, (float) this.f942i.top);
                canvas.clipRect(this.f929I);
                ay.setBounds(this.f929I);
                ay.setAlpha(ap);
                ay.draw(canvas);
                canvas.restore();
            }
            if (ap > 0) {
                this.viewGroup.invalidate();
            }
        }
    }

    
    public void m1520b(boolean z) {
        if (z) {
            this.f937d.m2040a(this.viewGroup);
        }
    }

    
    public boolean m1505a(View view, Rect rect, boolean z) {
        boolean z2;
        Rect e = m1539e();
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
        AnimUtils.m1937b(rect2, view, this.viewGroup);
        if (rect2.intersect(this.f946m)) {
            b = m1420b(e, rect2);
            c = m1424c(e, rect2);
        } else {
            c = 0;
            b = 0;
        }
        if (!(b == 0 && c == 0)) {
            if (z) {
                scrollBy(b, c);
            } else {
                m1514b(b, c, HttpStatus.SC_OK, null, null);
            }
        }
        if (z2) {
            return false;
        }
        return true;
    }

    
    public boolean m1522b(View view, boolean z) {
        return m1505a(view, new Rect(0, 0, view.getWidth(), view.getHeight()), z);
    }

    
    public Rect m1539e() {
        Rect rect = new Rect();
        AnimUtils.m1904a(rect, this.viewGroup.getRootView(), this.viewGroup);
        rect.intersect(getViewportBounds());
        return rect;
    }

    
    public boolean m1546f() {
        return ap() > 0;
    }

    
    public boolean isHorizontalFadingEdgeEnabled() {
        return false;
    }

    
    public boolean isHorizontalScrollBarEnabled() {
        return false;
    }

    
    public boolean isVerticalFadingEdgeEnabled() {
        return false;
    }

    
    public boolean isVerticalScrollBarEnabled() {
        return false;
    }

    
    public void m1512b(int i, int i2) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.left + i, this.f946m.top + i2);
    }

    
    public void m1485a(int i) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.left + i, this.f946m.bottom);
    }

    
    public void m1511b(int i) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.right, this.f946m.top + i);
    }

    
    public Rect m1553k() {
        return this.f946m;
    }

    
    public void m1491a(Rect rect) {
        m1487a(rect.left, rect.top, rect.right, rect.bottom);
    }

    
    public void m1487a(int i, int i2, int i3, int i4) {
        if (this.f946m.left != i || this.f946m.top != i2 || this.f946m.right != i3 || this.f946m.bottom != i4) {
            this.f947n.set(this.f946m);
            this.f946m.set(i, i2, i3, i4);
            if (this.f925E != null) {
                this.f925E.m1761a(this, this.f947n, this.f946m);
            }
            if (this.scrollState == ScrollState.FLING) {
                this.f936b.m1709a(this.f942i.left, this.f942i.top, Math.round(Math.signum(this.f936b.m1717d())), Math.round(Math.signum(this.f936b.m1718e())), al(), am(), mo504b(), an(), ak(), mo500a());
            }
        }
    }

    
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    
    public int computeHorizontalScrollExtent() {
        return Math.max(0, Math.min(this.f942i.right, this.f946m.right) - Math.max(this.f946m.left, this.f942i.left));
    }

    
    public int computeHorizontalScrollOffset() {
        return Math.max(0, Math.min(this.f942i.left - this.f946m.left, this.f946m.width()));
    }

    
    public int computeHorizontalScrollRange() {
        return this.f946m.width();
    }

    
    public int computeVerticalScrollExtent() {
        return Math.max(0, Math.min(this.f942i.bottom, this.f946m.bottom) - Math.max(this.f946m.top, this.f942i.top));
    }

    
    public int computeVerticalScrollOffset() {
        return Math.max(0, Math.min(this.f942i.top - this.f946m.top, this.f946m.height()));
    }

    
    public int computeVerticalScrollRange() {
        return this.f946m.height();
    }

    
    public int m1561s() {
        return this.f946m.width();
    }

    
    public int getContentHeight() {
        return this.f946m.height();
    }

    
    public boolean getThumbEnabled() {
        return this.f928H;
    }

    
    public void setThumbEnabled(boolean z) {
        this.f928H = z;
        this.viewGroup.invalidate();
    }

    
    public boolean getSeekEnabled() {
        return this.f927G;
    }

    
    public void setSeekEnabled(boolean z) {
        this.f927G = z;
    }

    
    public void m1543e(boolean z) {
        this.f959z = z;
    }

    
    public int getHorizontalThumbMarginLeft() {
        return this.f933M.left;
    }

    
    public int getHorizontalThumbMarginTop() {
        return this.f933M.top;
    }

    
    public int getHorizontalThumbMarginRight() {
        return this.f933M.right;
    }

    
    public int getHorizontalThumbMarginBottom() {
        return this.f933M.bottom;
    }

    
    public int getVerticalThumbMarginLeft() {
        return this.f930J.left;
    }

    
    public int getVerticalThumbMarginTop() {
        return this.f930J.top;
    }

    
    public int getVerticalThumbMarginRight() {
        return this.f930J.right;
    }

    
    public int getVerticalThumbMarginBottom() {
        return this.f930J.bottom;
    }

    
    public void m1513b(int i, int i2, int i3, int i4) {
        this.f930J.set(i, i2, i3, i4);
    }

    
    public Drawable getHorizontalThumbDrawable() {
        return this.f934N[0];
    }

    
    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f934N[0] = drawable;
    }

    
    public Drawable getVerticalThumbDrawable() {
        return this.f931K[0];
    }

    
    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f931K[0] = drawable;
    }

    
    public Drawable getHorizontalSeekDrawable() {
        return this.f934N[1];
    }

    
    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f934N[1] = drawable;
    }

    
    public Drawable getVerticalSeekDrawable() {
        return this.f931K[1];
    }

    
    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f931K[1] = drawable;
    }

    
    public et getScrollDetector() {
        return this.f937d;
    }

    public ScrollState getScrollState() {
        return this.scrollState;
    }

    public int getIdleTime() {
        if (this.scrollState == ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.elapsedRealtime);
        }
        return 0;
    }

    
    public int m1458J() {
        if (this.scrollState != ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.f923C);
        }
        return 0;
    }

    
    public int getScrollFinalX() {
        return this.f936b.m1719f();
    }

    
    public int getScrollFinalY() {
        return this.f936b.m1720g();
    }

    
    public void setScrollInterpolator(Interpolator interpolator) {
        this.f936b.m1710a(interpolator);
    }

    
    public void mo435a(View view, boolean z) {
        ListIterator listIterator = this.f944k.listIterator();
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
            this.f944k.add(new WeakReference(view));
        }
    }

    
    public OverScrollMode m1461M() {
        return this.scrollMode;
    }

    
    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.scrollMode = overScrollMode;
    }

    
    public OverScrollMode m1462N() {
        return this.scrollMode1;
    }

    
    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.scrollMode1 = overScrollMode;
    }

    
    public int getMaxOverScrollWidth() {
        return this.f950q;
    }

    
    public void setMaxOverScrollWidth(int i) {
        this.f950q = i;
    }

    public int getMaxOverScrollHeight() {
        return this.f951r;
    }

    
    public void MaxOverScrollHeight(int i) {
        this.f951r = i;
    }

    public Rect getViewportBounds() {
        return this.f942i;
    }

    
    public Rect m1464P() {
        return new Rect(this.f942i);
    }

    
    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f925E = cfVar;
    }

    
    public void setOnScrollListener(cg cgVar) {
        this.f926F = cgVar;
    }

    
    public boolean m1465Q() {
        if (this.f946m.width() > ((int) this.f941h.width())) {
            return true;
        }
        switch (ey.f1235a[this.scrollMode.ordinal()]) {
            case 1:
                if (this.f950q <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    
    public boolean m1466R() {
        if (this.f946m.height() > ((int) this.f941h.height())) {
            return true;
        }
        switch (ey.f1235a[this.scrollMode1.ordinal()]) {
            case 1:
                if (this.f951r <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    
    public boolean m1467S() {
        return ak() > 0;
    }

    
    public boolean m1468T() {
        return mo500a() > 0;
    }

    
    public boolean m1469U() {
        return this.viewGroup.getScrollX() <= al();
    }

    
    public boolean m1470V() {
        return this.viewGroup.getScrollX() >= am();
    }

    
    public boolean m1471W() {
        return this.viewGroup.getScrollY() <= mo504b();
    }

    
    public boolean m1472X() {
        return this.viewGroup.getScrollY() >= an();
    }

    
    public boolean m1544e(int i) {
        if (i < 0 || i >= this.viewGroup.getChildCount()) {
            return false;
        }
        View childAt = this.viewGroup.getChildAt(i);
        if (childAt.getVisibility() != 8) {
            return this.f942i.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
        return false;
    }

    
    public void scrollBy(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1510b((float) i, (float) i2);
    }

    
    public void scrollTo(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1524c((float) i, (float) i2);
    }

    
    public void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.f936b.m1711a(true);
        m1416a(ScrollState.SMOOTH);
        mo1759a(((float) i) - this.f941h.left, ((float) i2) - this.f941h.top, i3, false, new ez(this, runnable), new fa(this, runnable2));
    }

    
    public void m1514b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.f936b.m1711a(true);
        m1416a(ScrollState.SMOOTH);
        mo1759a((float) i, (float) i2, i3, false, new fb(this, runnable), new fc(this, runnable2));
    }

    
    public void m1541e(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1547g((float) i, (float) i2);
    }

    
    public void m1473Y() {
        int al = al();
        int am = am();
        int b = mo504b();
        int an = an();
        al = Math.max(al, Math.min(this.f942i.left, am));
        am = Math.max(b, Math.min(this.f942i.top, an));
        if (this.f942i.left != al || this.f942i.top != am) {
            scrollTo(al, am);
        }
    }

    
    public void m1474Z() {
        int al = al();
        int am = am();
        int b = mo504b();
        int an = an();
        al = Math.max(al, Math.min(this.f942i.left, am));
        am = Math.max(b, Math.min(this.f942i.top, an));
        if (this.f942i.left != al || this.f942i.top != am) {
            ao();
            m1416a(ScrollState.SMOOTH);
            mo1694a(0.0f, 0.0f, new ex(this), null);
        }
    }

    
    public void m1492a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        Point a = m1478a(rect, rect2);
        m1514b(a.x, a.y, i, runnable, runnable2);
    }

    
    public Point m1477a(Point point) {
        point.x -= this.f942i.left;
        point.y -= this.f942i.top;
        return point;
    }

    
    public Point m1508b(Point point) {
        point.x += this.f942i.left;
        point.y += this.f942i.top;
        return point;
    }

    
    public Rect m1509b(Rect rect) {
        rect.offset(this.f942i.left, this.f942i.top);
        return rect;
    }

    
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
    }

    
    protected void mo495a(boolean z) {
    }

    
    protected void mo502a(MotionEvent motionEvent) {
    }

    
    protected void mo493a(PointF pointF) {
    }

    
    protected void mo496b(PointF pointF) {
    }

    
    protected void mo497c(PointF pointF) {
    }

    
    protected void mo498d(PointF pointF) {
        this.viewGroup.performClick();
    }

    
    protected void mo499e(PointF pointF) {
        this.viewGroup.performLongClick();
    }

    protected int aa() {
        return AnimUtils.getScaledTouchSlop(this.viewGroup.getContext());
    }

    protected int ab() {
        return 0;
    }

    
    protected final void m1510b(float f, float f2) {
        ao();
        m1533d(f, f2);
    }

    
    protected final void m1524c(float f, float f2) {
        ao();
        m1540e(f, f2);
    }

    
    protected final void m1533d(float f, float f2) {
        m1540e(this.f941h.left + f, this.f941h.top + f2);
    }

    
    protected final void m1540e(float f, float f2) {
        m1547g(Math.max((float) ag(), Math.min(f, (float) ah())), Math.max((float) ai(), Math.min(f2, (float) aj())));
    }

    
    protected final void m1545f(float f, float f2) {
        m1547g(this.f941h.left + f, this.f941h.top + f2);
    }

    
    protected final void m1547g(float f, float f2) {
        boolean z;
        this.f941h.set(f, f2, ((float) this.viewGroup.getWidth()) + f, ((float) this.viewGroup.getHeight()) + f2);
        this.f941h.round(this.f942i);
        mo503a(this.scrollState, this.f941h);
        this.f941h.round(this.f942i);
        if (this.scrollMode == OverScrollMode.STRETCH) {
            if (this.f942i.left < al() && this.f943j.left >= al()) {
                this.f942i.left = al();
            }
            if (this.f942i.left > am() && this.f943j.right <= am() + ((int) this.f941h.width())) {
                this.f942i.right = am() + ((int) this.f941h.width());
            }
        }
        if (this.scrollMode1 == OverScrollMode.STRETCH) {
            if (this.f942i.top < mo504b() && this.f943j.top >= mo504b()) {
                this.f942i.top = mo504b();
            }
            if (this.f942i.top > an() && this.f943j.bottom <= an() + ((int) this.f941h.height())) {
                this.f942i.bottom = an() + ((int) this.f941h.height());
            }
        }
        if (this.f942i.equals(this.f943j)) {
            z = false;
        } else {
            z = true;
        }
        this.f943j.set(this.f942i);
        mo491a(this.f942i.left, this.f942i.top);
        if (z) {
            this.viewGroup.invalidate();
        }
        av();
        as();
        Iterator it = this.f944k.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view != null) {
                view.invalidate();
            }
        }
        mo495a(z);
        m1436g(z);
    }

    
    protected void mo503a(ScrollState scrollState, RectF rectF) {
    }

    
    protected void mo1768a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        mo1694a((-f3) * mo1695a(-f3), (-f4) * m1506b(-f4), runnable, runnable2);
    }

    protected void ac() {
    }

    
    protected void m1549h(float f, float f2) {
        m1524c(((float) al()) + (((float) (am() - al())) * f), ((float) mo504b()) + (((float) (an() - mo504b())) * f2));
    }

    protected void ad() {
    }

    
    protected void mo1760a(ScrollState scrollState, float f, float f2) {
    }

    
    protected void mo501a(float f, float f2) {
        m1524c(((-f) * mo1695a(-f)) + this.f941h.left, ((-f2) * m1506b(-f2)) + this.f941h.top);
    }

    
    protected void mo1761b(ScrollState scrollState, float f, float f2) {
    }

    
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        m1481a(f, f2, al(), am(), mo504b(), an(), runnable, runnable2);
    }

    
    protected final void m1481a(float f, float f2, int i, int i2, int i3, int i4, Runnable runnable, Runnable runnable2) {
        this.f936b.m1709a(Math.round(this.f941h.left), Math.round(this.f941h.top), Math.round(f), Math.round(f2), i, i2, i3, i4, ak(), mo500a());
        this.f921A = new fe(this, false, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    
    protected void mo1759a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (!z) {
            f = Math.max((float) (ag() - this.f942i.left), Math.min(f, (float) (ah() - this.f942i.left)));
            f2 = Math.max((float) (ai() - this.f942i.top), Math.min(f2, (float) (aj() - this.f942i.top)));
        }
        this.f936b.m1708a(Math.round(this.f941h.left), Math.round(this.f941h.top), Math.round(f), Math.round(f2), i);
        this.f921A = new fe(this, z, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    
    protected final void m1482a(float f, float f2, int i, int i2, Runnable runnable, Runnable runnable2) {
        this.f936b.m1715b(Math.round(this.f941h.left), Math.round(this.f941h.top), i, i2, Math.round(f), Math.round(f2));
        this.f921A = new fe(this, false, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    protected final int ae() {
        return ((int) this.f941h.width()) - this.f942i.width();
    }

    protected final int af() {
        return ((int) this.f941h.height()) - this.f942i.height();
    }

    private final void ao() {
        this.f936b.m1711a(true);
        this.f921A = null;
    }

    
    private final void m1416a(ScrollState scrollState) {
        if (this.scrollState != scrollState) {
            ScrollState scrollState2 = this.scrollState;
            this.scrollState = scrollState;
            if (this.scrollState == ScrollState.IDLE) {
                this.elapsedRealtime = SystemClock.elapsedRealtime();
            } else {
                this.f923C = SystemClock.elapsedRealtime();
            }
            if (this.scrollState == ScrollState.IDLE || this.scrollState == ScrollState.SMOOTH) {
                this.f953t = false;
                this.f954u = false;
                this.f955v = false;
                this.f956w = false;
            }
            mo494a(scrollState2, this.scrollState);
            m1422b(scrollState2, this.scrollState);
        }
    }

    private final int ap() {
        float f = 1.0f;
        if (!this.f928H) {
            f = 0.0f;
        } else if (getScrollState() == ScrollState.IDLE) {
            int idleTime = getIdleTime();
            if (idleTime > 1000) {
                f = idleTime < ICallback.NOTIFY_SHARE_AIDL ? ((float) (1200 - idleTime)) / 200.0f : 0.0f;
            }
        }
        return (int) (f * 255.0f);
    }

    
    protected Point m1478a(Rect rect, Rect rect2) {
        int i;
        int i2 = 0;
        Rect b = m1509b(new Rect(rect2));
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

    
    protected float mo1695a(float f) {
        float ag = (float) ag();
        float ah = (float) ah();
        float al = (float) al();
        float am = (float) am();
        float f2 = this.f941h.left;
        if (Float.compare(f2, al) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, am) < 0 || Float.compare(f, 0.0f) <= 0) {
                ag = 1.0f;
            } else if (Float.compare(ah, (float) this.f946m.right) == 0) {
                ag = 0.0f;
            } else if (Float.compare(f2, ah) >= 0) {
                ag = 0.0f;
            } else {
                ag = Math.abs((f2 - ah) / (am - ah));
            }
        } else if (Float.compare(ag, (float) this.f946m.left) == 0) {
            ag = 0.0f;
        } else if (Float.compare(f2, ag) <= 0) {
            ag = 0.0f;
        } else {
            ag = Math.abs((f2 - ag) / (al - ag));
        }
        if (f920c || Float.compare(ag, 0.0f) >= 0) {
            return ag;
        }
        throw new AssertionError();
    }

    
    protected float m1506b(float f) {
        float ai = (float) ai();
        float aj = (float) aj();
        float b = (float) mo504b();
        float an = (float) an();
        float f2 = this.f941h.top;
        if (Float.compare(f2, b) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, an) < 0 || Float.compare(f, 0.0f) <= 0) {
                ai = 1.0f;
            } else if (Float.compare(aj, (float) this.f946m.bottom) == 0) {
                ai = 0.0f;
            } else if (Float.compare(f2, aj) >= 0) {
                ai = 0.0f;
            } else {
                ai = Math.abs((f2 - aj) / (an - aj));
            }
        } else if (Float.compare(ai, (float) this.f946m.top) == 0) {
            ai = 0.0f;
        } else if (Float.compare(f2, ai) <= 0) {
            ai = 0.0f;
        } else {
            ai = Math.abs((f2 - ai) / (b - ai));
        }
        if (f920c || Float.compare(ai, 0.0f) >= 0) {
            return ai;
        }
        throw new AssertionError();
    }

    private float aq() {
        if (am() - al() == 0) {
            return 0.0f;
        }
        return (this.f941h.left - ((float) al())) / ((float) (am() - al()));
    }

    private float ar() {
        if (an() - mo504b() == 0) {
            return 0.0f;
        }
        return (this.f941h.top - ((float) mo504b())) / ((float) (an() - mo504b()));
    }

    protected int ag() {
        return al() - ak();
    }

    protected int ah() {
        return am() + ak();
    }

    protected int ai() {
        return mo504b() - mo500a();
    }

    protected int aj() {
        return an() + mo500a();
    }

    protected int ak() {
        switch (ey.f1235a[this.scrollMode.ordinal()]) {
            case 1:
                return this.f950q;
            case 2:
            case 3:
                return this.f946m.width() > ((int) this.f941h.width()) ? this.f950q : 0;
            default:
                return 0;
        }
    }

    
    protected int mo500a() {
        switch (ey.f1235a[this.scrollMode1.ordinal()]) {
            case 1:
                return this.f951r;
            case 2:
            case 3:
                return this.f946m.height() > ((int) this.f941h.height()) ? this.f951r : 0;
            default:
                return 0;
        }
    }

    protected int al() {
        return Math.min(0, this.f946m.left);
    }

    
    protected int mo504b() {
        return Math.min(0, this.f946m.top);
    }

    protected int am() {
        return Math.max(al(), this.f946m.right - ((int) this.f941h.width()));
    }

    protected int an() {
        return Math.max(mo504b(), this.f946m.bottom - ((int) this.f941h.height()));
    }

    private final void as() {
        Drawable ay = ay();
        int n = computeHorizontalScrollOffset();
        int m = computeHorizontalScrollExtent();
        int o = computeHorizontalScrollRange();
        if (ay == null || o == 0 || o <= m) {
            this.f932L.setEmpty();
            return;
        }
        float f = ((float) n) / ((float) o);
        float f2 = ((float) m) / ((float) o);
        o = aw();
        int aC = aC();
        m = Math.max(o, Math.round(f2 * ((float) aC)));
        n = Math.round(f * ((float) aC)) + this.f933M.left;
        this.f932L.set(n, (((int) this.f941h.height()) - this.f933M.bottom) - (ay.getIntrinsicHeight() > 0 ? ay.getIntrinsicHeight() : AnimUtils.m1932b(this.viewGroup.getContext(), 5.0f)), m + n, ((int) this.f941h.height()) - this.f933M.bottom);
        if (this.f932L.right > ((int) this.f941h.width()) - this.f933M.right) {
            this.f932L.offset((((int) this.f941h.width()) - this.f933M.right) - this.f932L.right, 0);
        }
    }

    
    private final float m1431f(int i) {
        if (at() == 0) {
            return 0.0f;
        }
        return ((float) i) / ((float) at());
    }

    
    private final float m1434g(int i) {
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
        int q = computeVerticalScrollOffset();
        int p = computeVerticalScrollExtent();
        int r = computeVerticalScrollRange();
        if (az == null || r == 0 || r <= p) {
            this.f929I.setEmpty();
            return;
        }
        float f = ((float) q) / ((float) r);
        float f2 = ((float) p) / ((float) r);
        r = ax();
        int aD = aD();
        int intrinsicWidth = az.getIntrinsicWidth() > 0 ? az.getIntrinsicWidth() : AnimUtils.m1932b(this.viewGroup.getContext(), 5.0f);
        q = Math.round(f * ((float) aD)) + this.f930J.top;
        this.f929I.set((((int) this.f941h.width()) - intrinsicWidth) - this.f930J.right, q, ((int) this.f941h.width()) - this.f930J.right, Math.max(r, Math.round(f2 * ((float) aD))) + q);
        if (this.f929I.bottom > ((int) this.f941h.height()) - this.f930J.bottom) {
            this.f929I.offset(0, (((int) this.f941h.height()) - this.f930J.bottom) - this.f929I.bottom);
        }
    }

    private final int aw() {
        Drawable ay = ay();
        return ay.getIntrinsicWidth() > 0 ? ay.getIntrinsicWidth() : AnimUtils.m1932b(this.viewGroup.getContext(), 5.0f);
    }

    private final int ax() {
        Drawable az = az();
        return az.getIntrinsicHeight() > 0 ? az.getIntrinsicHeight() : AnimUtils.m1932b(this.viewGroup.getContext(), 5.0f);
    }

    private final Drawable ay() {
        return this.f934N[aA()];
    }

    private final Drawable az() {
        return this.f931K[aB()];
    }

    private final int aA() {
        if (!this.f927G || m1561s() == 0 || aC() == 0) {
            return 0;
        }
        Drawable drawable = this.f934N[1];
        if (drawable == null) {
            return 0;
        }
        if (this.f953t) {
            return 1;
        }
        if (Float.compare(((float) this.f942i.width()) / ((float) m1561s()), ((float) drawable.getIntrinsicWidth()) / ((float) aC())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aB() {
        if (!this.f927G || getContentHeight() == 0 || aD() == 0) {
            return 0;
        }
        Drawable drawable = this.f931K[1];
        if (drawable == null) {
            return 0;
        }
        if (this.f954u) {
            return 1;
        }
        if (Float.compare(((float) this.f942i.height()) / ((float) getContentHeight()), ((float) drawable.getIntrinsicHeight()) / ((float) aD())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aC() {
        return (((int) this.f941h.width()) - this.f933M.left) - this.f933M.right;
    }

    private final int aD() {
        return (((int) this.f941h.height()) - this.f930J.top) - this.f930J.bottom;
    }

    
    private final void m1432f(boolean z) {
        ViewParent parent = this.viewGroup.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    
    protected static int m1420b(Rect rect, Rect rect2) {
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

    
    protected static int m1424c(Rect rect, Rect rect2) {
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

    
    private final void m1422b(ScrollState scrollState, ScrollState scrollState2) {
        if (this.f926F != null) {
            this.f926F.mo478a(this, scrollState, scrollState2);
        }
        Iterator it = this.f945l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).mo478a(this, scrollState, scrollState2);
        }
    }

    
    private final void m1436g(boolean z) {
        if (this.f926F != null) {
            this.f926F.mo479a(this, z);
        }
        Iterator it = this.f945l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).mo479a(this, z);
        }
    }
}
