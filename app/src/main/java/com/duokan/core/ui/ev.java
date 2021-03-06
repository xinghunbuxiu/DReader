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

import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

import org.apache.http.HttpStatus;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class ev implements Scrollable {
    
    static final  boolean f920c = (!ev.class.desiredAssertionStatus());
    
    private fe f921A = null;
    
    private long elapsedRealtime = SystemClock.elapsedRealtime();
    
    private long f923C = 0;
    
    private Runnable f924D = null;
    
    private OnContentBoundsChangedListener contentBoundsChangedListener = null;
    
    private OnScrollListener onScrollListener = null;
    
    private boolean seekEnabled = false;
    
    private boolean thumbEnabled = false;
    
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

    private final RectF screenInfo = new RectF();
    
    private final Rect r_screen = new Rect();
    
    private final Rect f943j = new Rect();
    
    private final LinkedList<WeakReference<View>> f944k = new LinkedList();
    
    private final LinkedList<ch> f945l = new LinkedList();

    private final Rect rect = new Rect();

    private final Rect rect1 = new Rect();
    
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
        this.screenInfo.set(0.0f, 0.0f, displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.screenInfo.round(this.r_screen);
        this.f943j.set(this.r_screen);
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
            float width = this.screenInfo.width() / ((float) this.r_screen.width());
            float height = this.screenInfo.height() / ((float) this.r_screen.height());
            canvas.save();
            if (canvas.isHardwareAccelerated()) {
                canvas.translate((float) this.r_screen.left, (float) this.r_screen.top);
                canvas.scale(width, height);
                canvas.translate((float) (-this.r_screen.left), (float) (-this.r_screen.top));
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
        if (this.thumbEnabled) {
            Drawable ay;
            int ap = ap();
            if (!this.f932L.isEmpty()) {
                ay = ay();
                canvas.save();
                canvas.translate((float) this.r_screen.left, (float) this.r_screen.top);
                canvas.clipRect(this.f932L);
                ay.setBounds(this.f932L);
                ay.setAlpha(ap);
                ay.draw(canvas);
                canvas.restore();
            }
            if (!this.f929I.isEmpty()) {
                ay = az();
                canvas.save();
                canvas.translate((float) this.r_screen.left, (float) this.r_screen.top);
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
        if (rect2.intersect(this.rect)) {
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
        m1487a(this.rect.left, this.rect.top, this.rect.left + i, this.rect.top + i2);
    }

    
    public void m1485a(int i) {
        m1487a(this.rect.left, this.rect.top, this.rect.left + i, this.rect.bottom);
    }

    
    public void m1511b(int i) {
        m1487a(this.rect.left, this.rect.top, this.rect.right, this.rect.top + i);
    }

    
    public Rect m1553k() {
        return this.rect;
    }

    
    public void m1491a(Rect rect) {
        m1487a(rect.left, rect.top, rect.right, rect.bottom);
    }

    
    public void m1487a(int i, int i2, int i3, int i4) {
        if (this.rect.left != i || this.rect.top != i2 || this.rect.right != i3 || this.rect.bottom != i4) {
            this.rect1.set(this.rect);
            this.rect.set(i, i2, i3, i4);
            if (this.contentBoundsChangedListener != null) {
                this.contentBoundsChangedListener.m1761a(this, this.rect1, this.rect);
            }
            if (this.scrollState == ScrollState.FLING) {
                this.f936b.m1709a(this.r_screen.left, this.r_screen.top, Math.round(Math.signum(this.f936b.m1717d())), Math.round(Math.signum(this.f936b.m1718e())), al(), am(), mo504b(), an(), ak(), mo500a());
            }
        }
    }

    
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    
    public int computeHorizontalScrollExtent() {
        return Math.max(0, Math.min(this.r_screen.right, this.rect.right) - Math.max(this.rect.left, this.r_screen.left));
    }

    
    public int computeHorizontalScrollOffset() {
        return Math.max(0, Math.min(this.r_screen.left - this.rect.left, this.rect.width()));
    }

    
    public int computeHorizontalScrollRange() {
        return this.rect.width();
    }

    
    public int computeVerticalScrollExtent() {
        return Math.max(0, Math.min(this.r_screen.bottom, this.rect.bottom) - Math.max(this.rect.top, this.r_screen.top));
    }

    
    public int computeVerticalScrollOffset() {
        return Math.max(0, Math.min(this.r_screen.top - this.rect.top, this.rect.height()));
    }

    
    public int computeVerticalScrollRange() {
        return this.rect.height();
    }

    
    public int getContentWidth() {
        return this.rect.width();
    }

    
    public int getContentHeight() {
        return this.rect.height();
    }

    
    public boolean getThumbEnabled() {
        return this.thumbEnabled;
    }

    
    public void setThumbEnabled(boolean z) {
        this.thumbEnabled = z;
        this.viewGroup.invalidate();
    }

    
    public boolean getSeekEnabled() {
        return this.seekEnabled;
    }

    
    public void setSeekEnabled(boolean z) {
        this.seekEnabled = z;
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

    
    public int getScrollTime() {
        if (this.scrollState != ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.f923C);
        }
        return 0;
    }

    
    public int getScrollFinalX() {
        return this.f936b.getScrollFinalX();
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

    
    public OverScrollMode getHorizontalOverScrollMode() {
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
        return this.r_screen;
    }

    
    public Rect m1464P() {
        return new Rect(this.r_screen);
    }

    
    public void setOnContentBoundsChangedListener(OnContentBoundsChangedListener contentBoundsChangedListener) {
        this.contentBoundsChangedListener = contentBoundsChangedListener;
    }

    
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    
    public boolean m1465Q() {
        if (this.rect.width() > ((int) this.screenInfo.width())) {
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
        if (this.rect.height() > ((int) this.screenInfo.height())) {
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
            return this.r_screen.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
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
        mo1759a(((float) i) - this.screenInfo.left, ((float) i2) - this.screenInfo.top, i3, false, new ez(this, runnable), new fa(this, runnable2));
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
        al = Math.max(al, Math.min(this.r_screen.left, am));
        am = Math.max(b, Math.min(this.r_screen.top, an));
        if (this.r_screen.left != al || this.r_screen.top != am) {
            scrollTo(al, am);
        }
    }

    
    public void m1474Z() {
        int al = al();
        int am = am();
        int b = mo504b();
        int an = an();
        al = Math.max(al, Math.min(this.r_screen.left, am));
        am = Math.max(b, Math.min(this.r_screen.top, an));
        if (this.r_screen.left != al || this.r_screen.top != am) {
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
        point.x -= this.r_screen.left;
        point.y -= this.r_screen.top;
        return point;
    }

    
    public Point m1508b(Point point) {
        point.x += this.r_screen.left;
        point.y += this.r_screen.top;
        return point;
    }

    
    public Rect m1509b(Rect rect) {
        rect.offset(this.r_screen.left, this.r_screen.top);
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
        m1540e(this.screenInfo.left + f, this.screenInfo.top + f2);
    }

    
    protected final void m1540e(float f, float f2) {
        m1547g(Math.max((float) ag(), Math.min(f, (float) ah())), Math.max((float) ai(), Math.min(f2, (float) aj())));
    }

    
    protected final void m1545f(float f, float f2) {
        m1547g(this.screenInfo.left + f, this.screenInfo.top + f2);
    }

    
    protected final void m1547g(float f, float f2) {
        boolean z;
        this.screenInfo.set(f, f2, ((float) this.viewGroup.getWidth()) + f, ((float) this.viewGroup.getHeight()) + f2);
        this.screenInfo.round(this.r_screen);
        mo503a(this.scrollState, this.screenInfo);
        this.screenInfo.round(this.r_screen);
        if (this.scrollMode == OverScrollMode.STRETCH) {
            if (this.r_screen.left < al() && this.f943j.left >= al()) {
                this.r_screen.left = al();
            }
            if (this.r_screen.left > am() && this.f943j.right <= am() + ((int) this.screenInfo.width())) {
                this.r_screen.right = am() + ((int) this.screenInfo.width());
            }
        }
        if (this.scrollMode1 == OverScrollMode.STRETCH) {
            if (this.r_screen.top < mo504b() && this.f943j.top >= mo504b()) {
                this.r_screen.top = mo504b();
            }
            if (this.r_screen.top > an() && this.f943j.bottom <= an() + ((int) this.screenInfo.height())) {
                this.r_screen.bottom = an() + ((int) this.screenInfo.height());
            }
        }
        if (this.r_screen.equals(this.f943j)) {
            z = false;
        } else {
            z = true;
        }
        this.f943j.set(this.r_screen);
        mo491a(this.r_screen.left, this.r_screen.top);
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
        m1524c(((-f) * mo1695a(-f)) + this.screenInfo.left, ((-f2) * m1506b(-f2)) + this.screenInfo.top);
    }

    
    protected void mo1761b(ScrollState scrollState, float f, float f2) {
    }

    
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        m1481a(f, f2, al(), am(), mo504b(), an(), runnable, runnable2);
    }

    
    protected final void m1481a(float f, float f2, int i, int i2, int i3, int i4, Runnable runnable, Runnable runnable2) {
        this.f936b.m1709a(Math.round(this.screenInfo.left), Math.round(this.screenInfo.top), Math.round(f), Math.round(f2), i, i2, i3, i4, ak(), mo500a());
        this.f921A = new fe(this, false, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    
    protected void mo1759a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (!z) {
            f = Math.max((float) (ag() - this.r_screen.left), Math.min(f, (float) (ah() - this.r_screen.left)));
            f2 = Math.max((float) (ai() - this.r_screen.top), Math.min(f2, (float) (aj() - this.r_screen.top)));
        }
        this.f936b.m1708a(Math.round(this.screenInfo.left), Math.round(this.screenInfo.top), Math.round(f), Math.round(f2), i);
        this.f921A = new fe(this, z, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    
    protected final void m1482a(float f, float f2, int i, int i2, Runnable runnable, Runnable runnable2) {
        this.f936b.m1715b(Math.round(this.screenInfo.left), Math.round(this.screenInfo.top), i, i2, Math.round(f), Math.round(f2));
        this.f921A = new fe(this, false, runnable, runnable2);
        this.viewGroup.post(this.f921A);
    }

    protected final int ae() {
        return ((int) this.screenInfo.width()) - this.r_screen.width();
    }

    protected final int af() {
        return ((int) this.screenInfo.height()) - this.r_screen.height();
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
        if (!this.thumbEnabled) {
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
        float f2 = this.screenInfo.left;
        if (Float.compare(f2, al) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, am) < 0 || Float.compare(f, 0.0f) <= 0) {
                ag = 1.0f;
            } else if (Float.compare(ah, (float) this.rect.right) == 0) {
                ag = 0.0f;
            } else if (Float.compare(f2, ah) >= 0) {
                ag = 0.0f;
            } else {
                ag = Math.abs((f2 - ah) / (am - ah));
            }
        } else if (Float.compare(ag, (float) this.rect.left) == 0) {
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
        float f2 = this.screenInfo.top;
        if (Float.compare(f2, b) > 0 || Float.compare(f, 0.0f) >= 0) {
            if (Float.compare(f2, an) < 0 || Float.compare(f, 0.0f) <= 0) {
                ai = 1.0f;
            } else if (Float.compare(aj, (float) this.rect.bottom) == 0) {
                ai = 0.0f;
            } else if (Float.compare(f2, aj) >= 0) {
                ai = 0.0f;
            } else {
                ai = Math.abs((f2 - aj) / (an - aj));
            }
        } else if (Float.compare(ai, (float) this.rect.top) == 0) {
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
        return (this.screenInfo.left - ((float) al())) / ((float) (am() - al()));
    }

    private float ar() {
        if (an() - mo504b() == 0) {
            return 0.0f;
        }
        return (this.screenInfo.top - ((float) mo504b())) / ((float) (an() - mo504b()));
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
                return this.rect.width() > ((int) this.screenInfo.width()) ? this.f950q : 0;
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
                return this.rect.height() > ((int) this.screenInfo.height()) ? this.f951r : 0;
            default:
                return 0;
        }
    }

    protected int al() {
        return Math.min(0, this.rect.left);
    }

    
    protected int mo504b() {
        return Math.min(0, this.rect.top);
    }

    protected int am() {
        return Math.max(al(), this.rect.right - ((int) this.screenInfo.width()));
    }

    protected int an() {
        return Math.max(mo504b(), this.rect.bottom - ((int) this.screenInfo.height()));
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
        this.f932L.set(n, (((int) this.screenInfo.height()) - this.f933M.bottom) - (ay.getIntrinsicHeight() > 0 ? ay.getIntrinsicHeight() : AnimUtils.m1932b(this.viewGroup.getContext(), 5.0f)), m + n, ((int) this.screenInfo.height()) - this.f933M.bottom);
        if (this.f932L.right > ((int) this.screenInfo.width()) - this.f933M.right) {
            this.f932L.offset((((int) this.screenInfo.width()) - this.f933M.right) - this.f932L.right, 0);
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
        this.f929I.set((((int) this.screenInfo.width()) - intrinsicWidth) - this.f930J.right, q, ((int) this.screenInfo.width()) - this.f930J.right, Math.max(r, Math.round(f2 * ((float) aD))) + q);
        if (this.f929I.bottom > ((int) this.screenInfo.height()) - this.f930J.bottom) {
            this.f929I.offset(0, (((int) this.screenInfo.height()) - this.f930J.bottom) - this.f929I.bottom);
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
        if (!this.seekEnabled || getContentWidth() == 0 || aC() == 0) {
            return 0;
        }
        Drawable drawable = this.f934N[1];
        if (drawable == null) {
            return 0;
        }
        if (this.f953t) {
            return 1;
        }
        if (Float.compare(((float) this.r_screen.width()) / ((float) getContentWidth()), ((float) drawable.getIntrinsicWidth()) / ((float) aC())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aB() {
        if (!this.seekEnabled || getContentHeight() == 0 || aD() == 0) {
            return 0;
        }
        Drawable drawable = this.f931K[1];
        if (drawable == null) {
            return 0;
        }
        if (this.f954u) {
            return 1;
        }
        if (Float.compare(((float) this.r_screen.height()) / ((float) getContentHeight()), ((float) drawable.getIntrinsicHeight()) / ((float) aD())) <= 0) {
            return 1;
        }
        return 0;
    }

    private final int aC() {
        return (((int) this.screenInfo.width()) - this.f933M.left) - this.f933M.right;
    }

    private final int aD() {
        return (((int) this.screenInfo.height()) - this.f930J.top) - this.f930J.bottom;
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
        if (this.onScrollListener != null) {
            this.onScrollListener.mo478a(this, scrollState, scrollState2);
        }
        Iterator it = this.f945l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).mo478a(this, scrollState, scrollState2);
        }
    }

    
    private final void m1436g(boolean z) {
        if (this.onScrollListener != null) {
            this.onScrollListener.mo479a(this, z);
        }
        Iterator it = this.f945l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).mo479a(this, z);
        }
    }
}
