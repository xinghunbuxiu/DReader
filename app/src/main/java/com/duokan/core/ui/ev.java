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
    /* renamed from: c */
    static final /* synthetic */ boolean f920c = (!ev.class.desiredAssertionStatus());
    /* renamed from: A */
    private fe f921A = null;
    /* renamed from: B */
    private long f922B = SystemClock.elapsedRealtime();
    /* renamed from: C */
    private long f923C = 0;
    /* renamed from: D */
    private Runnable f924D = null;
    /* renamed from: E */
    private cf f925E = null;
    /* renamed from: F */
    private cg f926F = null;
    /* renamed from: G */
    private boolean f927G = false;
    /* renamed from: H */
    private boolean f928H = false;
    /* renamed from: I */
    private final Rect f929I = new Rect();
    /* renamed from: J */
    private final Rect f930J = new Rect();
    /* renamed from: K */
    private final Drawable[] f931K = new Drawable[2];
    /* renamed from: L */
    private final Rect f932L = new Rect();
    /* renamed from: M */
    private final Rect f933M = new Rect();
    /* renamed from: N */
    private final Drawable[] f934N = new Drawable[2];
    /* renamed from: a */
    private final ViewGroup f935a;
    /* renamed from: b */
    private final bx f936b;
    /* renamed from: d */
    private final et f937d = new et();
    /* renamed from: e */
    private final et f938e = new et();
    /* renamed from: f */
    private final ct f939f = new ct();
    /* renamed from: g */
    private final bu f940g = new bu();
    /* renamed from: h */
    private final RectF f941h = new RectF();
    /* renamed from: i */
    private final Rect f942i = new Rect();
    /* renamed from: j */
    private final Rect f943j = new Rect();
    /* renamed from: k */
    private final LinkedList<WeakReference<View>> f944k = new LinkedList();
    /* renamed from: l */
    private final LinkedList<ch> f945l = new LinkedList();
    /* renamed from: m */
    private final Rect f946m = new Rect();
    /* renamed from: n */
    private final Rect f947n = new Rect();
    /* renamed from: o */
    private OverScrollMode f948o = OverScrollMode.STRETCH;
    /* renamed from: p */
    private OverScrollMode f949p = OverScrollMode.STRETCH;
    /* renamed from: q */
    private int f950q = 0;
    /* renamed from: r */
    private int f951r = 0;
    /* renamed from: s */
    private ScrollState f952s = ScrollState.IDLE;
    /* renamed from: t */
    private boolean f953t = false;
    /* renamed from: u */
    private boolean f954u = false;
    /* renamed from: v */
    private boolean f955v = false;
    /* renamed from: w */
    private boolean f956w = false;
    /* renamed from: x */
    private boolean f957x = true;
    /* renamed from: y */
    private boolean f958y = true;
    /* renamed from: z */
    private boolean f959z = true;

    /* renamed from: a */
    protected abstract void mo491a(int i, int i2);

    /* renamed from: a */
    protected abstract void mo492a(Canvas canvas);

    protected ev(ViewGroup viewGroup) {
        this.f935a = viewGroup;
        this.f936b = new bx(this.f935a.getContext());
        this.f937d.m2041a(new ff(this));
        DisplayMetrics displayMetrics = this.f935a.getResources().getDisplayMetrics();
        this.f941h.set(0.0f, 0.0f, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
        this.f941h.round(this.f942i);
        this.f943j.set(this.f942i);
        this.f930J.set(0, AnimUtils.m1932b(this.f935a.getContext(), 2.0f), AnimUtils.m1932b(this.f935a.getContext(), 2.0f), AnimUtils.m1932b(this.f935a.getContext(), 6.0f));
        this.f931K[0] = this.f935a.getResources().getDrawable(C0243e.general__shared__thumb_default_vert);
        this.f931K[1] = this.f935a.getResources().getDrawable(C0243e.general__shared__thumb_seek_vert);
        this.f933M.set(AnimUtils.m1932b(this.f935a.getContext(), 2.0f), 0, AnimUtils.m1932b(this.f935a.getContext(), 6.0f), AnimUtils.m1932b(this.f935a.getContext(), 2.0f));
        this.f934N[0] = this.f935a.getResources().getDrawable(C0243e.general__shared__thumb_default_horz);
        this.f938e.m2041a(this.f939f);
        this.f938e.m2041a(this.f940g);
        this.f938e.m2042a(new fd());
    }

    /* renamed from: b */
    public boolean mo2419b(MotionEvent motionEvent) {
        if (!this.f935a.isEnabled()) {
            return false;
        }
        mo502a(motionEvent);
        return this.f937d.m2044a(this.f935a, motionEvent);
    }

    /* renamed from: c */
    public boolean mo2420c(MotionEvent motionEvent) {
        if (!this.f935a.isEnabled()) {
            return false;
        }
        mo502a(motionEvent);
        this.f937d.onTouch(this.f935a, motionEvent);
        if (this.f952s == ScrollState.IDLE) {
            this.f938e.onTouch(this.f935a, motionEvent);
        } else {
            this.f938e.m2040a(this.f935a);
        }
        return true;
    }

    /* renamed from: c */
    public void m1523c() {
        for (ViewParent parent = this.f935a.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ch) {
                this.f945l.add((ch) parent);
            }
        }
    }

    /* renamed from: d */
    public void m1532d() {
        ao();
        m1416a(ScrollState.IDLE);
        this.f945l.clear();
    }

    /* renamed from: a */
    public void m1504a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            m1545f(0.0f, 0.0f);
        }
        if (this.f924D == null) {
            this.f924D = new ew(this);
            AnimUtils.m1921a(this.f935a, this.f924D);
        }
    }

    /* renamed from: b */
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

    /* renamed from: c */
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
                this.f935a.invalidate();
            }
        }
    }

    /* renamed from: b */
    public void m1520b(boolean z) {
        if (z) {
            this.f937d.m2040a(this.f935a);
        }
    }

    /* renamed from: a */
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
        AnimUtils.m1937b(rect2, view, this.f935a);
        if (rect2.intersect(this.f946m)) {
            b = m1420b(e, rect2);
            c = m1424c(e, rect2);
        } else {
            c = 0;
            b = 0;
        }
        if (!(b == 0 && c == 0)) {
            if (z) {
                m1526c(b, c);
            } else {
                m1514b(b, c, HttpStatus.SC_OK, null, null);
            }
        }
        if (z2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m1522b(View view, boolean z) {
        return m1505a(view, new Rect(0, 0, view.getWidth(), view.getHeight()), z);
    }

    /* renamed from: e */
    public Rect m1539e() {
        Rect rect = new Rect();
        AnimUtils.m1904a(rect, this.f935a.getRootView(), this.f935a);
        rect.intersect(getViewportBounds());
        return rect;
    }

    /* renamed from: f */
    public boolean m1546f() {
        return ap() > 0;
    }

    /* renamed from: g */
    public boolean m1548g() {
        return false;
    }

    /* renamed from: h */
    public boolean m1550h() {
        return false;
    }

    /* renamed from: i */
    public boolean m1551i() {
        return false;
    }

    /* renamed from: j */
    public boolean m1552j() {
        return false;
    }

    /* renamed from: b */
    public void m1512b(int i, int i2) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.left + i, this.f946m.top + i2);
    }

    /* renamed from: a */
    public void m1485a(int i) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.left + i, this.f946m.bottom);
    }

    /* renamed from: b */
    public void m1511b(int i) {
        m1487a(this.f946m.left, this.f946m.top, this.f946m.right, this.f946m.top + i);
    }

    /* renamed from: k */
    public Rect m1553k() {
        return this.f946m;
    }

    /* renamed from: a */
    public void m1491a(Rect rect) {
        m1487a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public void m1487a(int i, int i2, int i3, int i4) {
        if (this.f946m.left != i || this.f946m.top != i2 || this.f946m.right != i3 || this.f946m.bottom != i4) {
            this.f947n.set(this.f946m);
            this.f946m.set(i, i2, i3, i4);
            if (this.f925E != null) {
                this.f925E.m1761a(this, this.f947n, this.f946m);
            }
            if (this.f952s == ScrollState.FLING) {
                this.f936b.m1709a(this.f942i.left, this.f942i.top, Math.round(Math.signum(this.f936b.m1717d())), Math.round(Math.signum(this.f936b.m1718e())), al(), am(), mo504b(), an(), ak(), mo500a());
            }
        }
    }

    /* renamed from: l */
    public boolean m1554l() {
        return true;
    }

    /* renamed from: m */
    public int m1555m() {
        return Math.max(0, Math.min(this.f942i.right, this.f946m.right) - Math.max(this.f946m.left, this.f942i.left));
    }

    /* renamed from: n */
    public int m1556n() {
        return Math.max(0, Math.min(this.f942i.left - this.f946m.left, this.f946m.width()));
    }

    /* renamed from: o */
    public int m1557o() {
        return this.f946m.width();
    }

    /* renamed from: p */
    public int m1558p() {
        return Math.max(0, Math.min(this.f942i.bottom, this.f946m.bottom) - Math.max(this.f946m.top, this.f942i.top));
    }

    /* renamed from: q */
    public int m1559q() {
        return Math.max(0, Math.min(this.f942i.top - this.f946m.top, this.f946m.height()));
    }

    /* renamed from: r */
    public int m1560r() {
        return this.f946m.height();
    }

    /* renamed from: s */
    public int m1561s() {
        return this.f946m.width();
    }

    /* renamed from: t */
    public int m1562t() {
        return this.f946m.height();
    }

    /* renamed from: u */
    public boolean m1563u() {
        return this.f928H;
    }

    /* renamed from: c */
    public void m1530c(boolean z) {
        this.f928H = z;
        this.f935a.invalidate();
    }

    /* renamed from: v */
    public boolean m1564v() {
        return this.f927G;
    }

    /* renamed from: d */
    public void m1538d(boolean z) {
        this.f927G = z;
    }

    /* renamed from: e */
    public void m1543e(boolean z) {
        this.f959z = z;
    }

    /* renamed from: w */
    public int m1565w() {
        return this.f933M.left;
    }

    /* renamed from: x */
    public int m1566x() {
        return this.f933M.top;
    }

    /* renamed from: y */
    public int m1567y() {
        return this.f933M.right;
    }

    /* renamed from: z */
    public int m1568z() {
        return this.f933M.bottom;
    }

    /* renamed from: A */
    public int m1449A() {
        return this.f930J.left;
    }

    /* renamed from: B */
    public int m1450B() {
        return this.f930J.top;
    }

    /* renamed from: C */
    public int m1451C() {
        return this.f930J.right;
    }

    /* renamed from: D */
    public int m1452D() {
        return this.f930J.bottom;
    }

    /* renamed from: b */
    public void m1513b(int i, int i2, int i3, int i4) {
        this.f930J.set(i, i2, i3, i4);
    }

    /* renamed from: E */
    public Drawable m1453E() {
        return this.f934N[0];
    }

    /* renamed from: a */
    public void m1493a(Drawable drawable) {
        this.f934N[0] = drawable;
    }

    /* renamed from: F */
    public Drawable m1454F() {
        return this.f931K[0];
    }

    /* renamed from: b */
    public void m1517b(Drawable drawable) {
        this.f931K[0] = drawable;
    }

    /* renamed from: G */
    public Drawable m1455G() {
        return this.f934N[1];
    }

    /* renamed from: c */
    public void m1529c(Drawable drawable) {
        this.f934N[1] = drawable;
    }

    /* renamed from: H */
    public Drawable m1456H() {
        return this.f931K[1];
    }

    /* renamed from: d */
    public void m1537d(Drawable drawable) {
        this.f931K[1] = drawable;
    }

    /* renamed from: I */
    public et m1457I() {
        return this.f937d;
    }

    public ScrollState getScrollState() {
        return this.f952s;
    }

    public int getIdleTime() {
        if (this.f952s == ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.f922B);
        }
        return 0;
    }

    /* renamed from: J */
    public int m1458J() {
        if (this.f952s != ScrollState.IDLE) {
            return (int) (SystemClock.elapsedRealtime() - this.f923C);
        }
        return 0;
    }

    /* renamed from: K */
    public int m1459K() {
        return this.f936b.m1719f();
    }

    /* renamed from: L */
    public int m1460L() {
        return this.f936b.m1720g();
    }

    /* renamed from: a */
    public void m1496a(Interpolator interpolator) {
        this.f936b.m1710a(interpolator);
    }

    /* renamed from: a */
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

    /* renamed from: M */
    public OverScrollMode m1461M() {
        return this.f948o;
    }

    /* renamed from: a */
    public void m1497a(OverScrollMode overScrollMode) {
        this.f948o = overScrollMode;
    }

    /* renamed from: N */
    public OverScrollMode m1462N() {
        return this.f949p;
    }

    /* renamed from: b */
    public void m1518b(OverScrollMode overScrollMode) {
        this.f949p = overScrollMode;
    }

    /* renamed from: O */
    public int m1463O() {
        return this.f950q;
    }

    /* renamed from: c */
    public void m1525c(int i) {
        this.f950q = i;
    }

    public int getMaxOverScrollHeight() {
        return this.f951r;
    }

    /* renamed from: d */
    public void m1534d(int i) {
        this.f951r = i;
    }

    public Rect getViewportBounds() {
        return this.f942i;
    }

    /* renamed from: P */
    public Rect m1464P() {
        return new Rect(this.f942i);
    }

    /* renamed from: a */
    public void m1501a(cf cfVar) {
        this.f925E = cfVar;
    }

    /* renamed from: a */
    public void m1502a(cg cgVar) {
        this.f926F = cgVar;
    }

    /* renamed from: Q */
    public boolean m1465Q() {
        if (this.f946m.width() > ((int) this.f941h.width())) {
            return true;
        }
        switch (ey.f1235a[this.f948o.ordinal()]) {
            case 1:
                if (this.f950q <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    /* renamed from: R */
    public boolean m1466R() {
        if (this.f946m.height() > ((int) this.f941h.height())) {
            return true;
        }
        switch (ey.f1235a[this.f949p.ordinal()]) {
            case 1:
                if (this.f951r <= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    /* renamed from: S */
    public boolean m1467S() {
        return ak() > 0;
    }

    /* renamed from: T */
    public boolean m1468T() {
        return mo500a() > 0;
    }

    /* renamed from: U */
    public boolean m1469U() {
        return this.f935a.getScrollX() <= al();
    }

    /* renamed from: V */
    public boolean m1470V() {
        return this.f935a.getScrollX() >= am();
    }

    /* renamed from: W */
    public boolean m1471W() {
        return this.f935a.getScrollY() <= mo504b();
    }

    /* renamed from: X */
    public boolean m1472X() {
        return this.f935a.getScrollY() >= an();
    }

    /* renamed from: e */
    public boolean m1544e(int i) {
        if (i < 0 || i >= this.f935a.getChildCount()) {
            return false;
        }
        View childAt = this.f935a.getChildAt(i);
        if (childAt.getVisibility() != 8) {
            return this.f942i.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
        return false;
    }

    /* renamed from: c */
    public void m1526c(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1510b((float) i, (float) i2);
    }

    /* renamed from: d */
    public void m1535d(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1524c((float) i, (float) i2);
    }

    /* renamed from: a */
    public void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.f936b.m1711a(true);
        m1416a(ScrollState.SMOOTH);
        mo1759a(((float) i) - this.f941h.left, ((float) i2) - this.f941h.top, i3, false, new ez(this, runnable), new fa(this, runnable2));
    }

    /* renamed from: b */
    public void m1514b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        ao();
        this.f936b.m1711a(true);
        m1416a(ScrollState.SMOOTH);
        mo1759a((float) i, (float) i2, i3, false, new fb(this, runnable), new fc(this, runnable2));
    }

    /* renamed from: e */
    public void m1541e(int i, int i2) {
        ao();
        m1416a(ScrollState.IDLE);
        m1547g((float) i, (float) i2);
    }

    /* renamed from: Y */
    public void m1473Y() {
        int al = al();
        int am = am();
        int b = mo504b();
        int an = an();
        al = Math.max(al, Math.min(this.f942i.left, am));
        am = Math.max(b, Math.min(this.f942i.top, an));
        if (this.f942i.left != al || this.f942i.top != am) {
            m1535d(al, am);
        }
    }

    /* renamed from: Z */
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

    /* renamed from: a */
    public void m1492a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        Point a = m1478a(rect, rect2);
        m1514b(a.x, a.y, i, runnable, runnable2);
    }

    /* renamed from: a */
    public Point m1477a(Point point) {
        point.x -= this.f942i.left;
        point.y -= this.f942i.top;
        return point;
    }

    /* renamed from: b */
    public Point m1508b(Point point) {
        point.x += this.f942i.left;
        point.y += this.f942i.top;
        return point;
    }

    /* renamed from: b */
    public Rect m1509b(Rect rect) {
        rect.offset(this.f942i.left, this.f942i.top);
        return rect;
    }

    /* renamed from: a */
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
    }

    /* renamed from: a */
    protected void mo495a(boolean z) {
    }

    /* renamed from: a */
    protected void mo502a(MotionEvent motionEvent) {
    }

    /* renamed from: a */
    protected void mo493a(PointF pointF) {
    }

    /* renamed from: b */
    protected void mo496b(PointF pointF) {
    }

    /* renamed from: c */
    protected void mo497c(PointF pointF) {
    }

    /* renamed from: d */
    protected void mo498d(PointF pointF) {
        this.f935a.performClick();
    }

    /* renamed from: e */
    protected void mo499e(PointF pointF) {
        this.f935a.performLongClick();
    }

    protected int aa() {
        return AnimUtils.getScaledTouchSlop(this.f935a.getContext());
    }

    protected int ab() {
        return 0;
    }

    /* renamed from: b */
    protected final void m1510b(float f, float f2) {
        ao();
        m1533d(f, f2);
    }

    /* renamed from: c */
    protected final void m1524c(float f, float f2) {
        ao();
        m1540e(f, f2);
    }

    /* renamed from: d */
    protected final void m1533d(float f, float f2) {
        m1540e(this.f941h.left + f, this.f941h.top + f2);
    }

    /* renamed from: e */
    protected final void m1540e(float f, float f2) {
        m1547g(Math.max((float) ag(), Math.min(f, (float) ah())), Math.max((float) ai(), Math.min(f2, (float) aj())));
    }

    /* renamed from: f */
    protected final void m1545f(float f, float f2) {
        m1547g(this.f941h.left + f, this.f941h.top + f2);
    }

    /* renamed from: g */
    protected final void m1547g(float f, float f2) {
        boolean z;
        this.f941h.set(f, f2, ((float) this.f935a.getWidth()) + f, ((float) this.f935a.getHeight()) + f2);
        this.f941h.round(this.f942i);
        mo503a(this.f952s, this.f941h);
        this.f941h.round(this.f942i);
        if (this.f948o == OverScrollMode.STRETCH) {
            if (this.f942i.left < al() && this.f943j.left >= al()) {
                this.f942i.left = al();
            }
            if (this.f942i.left > am() && this.f943j.right <= am() + ((int) this.f941h.width())) {
                this.f942i.right = am() + ((int) this.f941h.width());
            }
        }
        if (this.f949p == OverScrollMode.STRETCH) {
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
            this.f935a.invalidate();
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

    /* renamed from: a */
    protected void mo503a(ScrollState scrollState, RectF rectF) {
    }

    /* renamed from: a */
    protected void mo1768a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        mo1694a((-f3) * mo1695a(-f3), (-f4) * m1506b(-f4), runnable, runnable2);
    }

    protected void ac() {
    }

    /* renamed from: h */
    protected void m1549h(float f, float f2) {
        m1524c(((float) al()) + (((float) (am() - al())) * f), ((float) mo504b()) + (((float) (an() - mo504b())) * f2));
    }

    protected void ad() {
    }

    /* renamed from: a */
    protected void mo1760a(ScrollState scrollState, float f, float f2) {
    }

    /* renamed from: a */
    protected void mo501a(float f, float f2) {
        m1524c(((-f) * mo1695a(-f)) + this.f941h.left, ((-f2) * m1506b(-f2)) + this.f941h.top);
    }

    /* renamed from: b */
    protected void mo1761b(ScrollState scrollState, float f, float f2) {
    }

    /* renamed from: a */
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        m1481a(f, f2, al(), am(), mo504b(), an(), runnable, runnable2);
    }

    /* renamed from: a */
    protected final void m1481a(float f, float f2, int i, int i2, int i3, int i4, Runnable runnable, Runnable runnable2) {
        this.f936b.m1709a(Math.round(this.f941h.left), Math.round(this.f941h.top), Math.round(f), Math.round(f2), i, i2, i3, i4, ak(), mo500a());
        this.f921A = new fe(this, false, runnable, runnable2);
        this.f935a.post(this.f921A);
    }

    /* renamed from: a */
    protected void mo1759a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (!z) {
            f = Math.max((float) (ag() - this.f942i.left), Math.min(f, (float) (ah() - this.f942i.left)));
            f2 = Math.max((float) (ai() - this.f942i.top), Math.min(f2, (float) (aj() - this.f942i.top)));
        }
        this.f936b.m1708a(Math.round(this.f941h.left), Math.round(this.f941h.top), Math.round(f), Math.round(f2), i);
        this.f921A = new fe(this, z, runnable, runnable2);
        this.f935a.post(this.f921A);
    }

    /* renamed from: a */
    protected final void m1482a(float f, float f2, int i, int i2, Runnable runnable, Runnable runnable2) {
        this.f936b.m1715b(Math.round(this.f941h.left), Math.round(this.f941h.top), i, i2, Math.round(f), Math.round(f2));
        this.f921A = new fe(this, false, runnable, runnable2);
        this.f935a.post(this.f921A);
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

    /* renamed from: a */
    private final void m1416a(ScrollState scrollState) {
        if (this.f952s != scrollState) {
            ScrollState scrollState2 = this.f952s;
            this.f952s = scrollState;
            if (this.f952s == ScrollState.IDLE) {
                this.f922B = SystemClock.elapsedRealtime();
            } else {
                this.f923C = SystemClock.elapsedRealtime();
            }
            if (this.f952s == ScrollState.IDLE || this.f952s == ScrollState.SMOOTH) {
                this.f953t = false;
                this.f954u = false;
                this.f955v = false;
                this.f956w = false;
            }
            mo494a(scrollState2, this.f952s);
            m1422b(scrollState2, this.f952s);
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

    /* renamed from: a */
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

    /* renamed from: a */
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

    /* renamed from: b */
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
        switch (ey.f1235a[this.f948o.ordinal()]) {
            case 1:
                return this.f950q;
            case 2:
            case 3:
                return this.f946m.width() > ((int) this.f941h.width()) ? this.f950q : 0;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    protected int mo500a() {
        switch (ey.f1235a[this.f949p.ordinal()]) {
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

    /* renamed from: b */
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
        int n = m1556n();
        int m = m1555m();
        int o = m1557o();
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
        this.f932L.set(n, (((int) this.f941h.height()) - this.f933M.bottom) - (ay.getIntrinsicHeight() > 0 ? ay.getIntrinsicHeight() : AnimUtils.m1932b(this.f935a.getContext(), 5.0f)), m + n, ((int) this.f941h.height()) - this.f933M.bottom);
        if (this.f932L.right > ((int) this.f941h.width()) - this.f933M.right) {
            this.f932L.offset((((int) this.f941h.width()) - this.f933M.right) - this.f932L.right, 0);
        }
    }

    /* renamed from: f */
    private final float m1431f(int i) {
        if (at() == 0) {
            return 0.0f;
        }
        return ((float) i) / ((float) at());
    }

    /* renamed from: g */
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
        int q = m1559q();
        int p = m1558p();
        int r = m1560r();
        if (az == null || r == 0 || r <= p) {
            this.f929I.setEmpty();
            return;
        }
        float f = ((float) q) / ((float) r);
        float f2 = ((float) p) / ((float) r);
        r = ax();
        int aD = aD();
        int intrinsicWidth = az.getIntrinsicWidth() > 0 ? az.getIntrinsicWidth() : AnimUtils.m1932b(this.f935a.getContext(), 5.0f);
        q = Math.round(f * ((float) aD)) + this.f930J.top;
        this.f929I.set((((int) this.f941h.width()) - intrinsicWidth) - this.f930J.right, q, ((int) this.f941h.width()) - this.f930J.right, Math.max(r, Math.round(f2 * ((float) aD))) + q);
        if (this.f929I.bottom > ((int) this.f941h.height()) - this.f930J.bottom) {
            this.f929I.offset(0, (((int) this.f941h.height()) - this.f930J.bottom) - this.f929I.bottom);
        }
    }

    private final int aw() {
        Drawable ay = ay();
        return ay.getIntrinsicWidth() > 0 ? ay.getIntrinsicWidth() : AnimUtils.m1932b(this.f935a.getContext(), 5.0f);
    }

    private final int ax() {
        Drawable az = az();
        return az.getIntrinsicHeight() > 0 ? az.getIntrinsicHeight() : AnimUtils.m1932b(this.f935a.getContext(), 5.0f);
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
        if (!this.f927G || m1562t() == 0 || aD() == 0) {
            return 0;
        }
        Drawable drawable = this.f931K[1];
        if (drawable == null) {
            return 0;
        }
        if (this.f954u) {
            return 1;
        }
        if (Float.compare(((float) this.f942i.height()) / ((float) m1562t()), ((float) drawable.getIntrinsicHeight()) / ((float) aD())) <= 0) {
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

    /* renamed from: f */
    private final void m1432f(boolean z) {
        ViewParent parent = this.f935a.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: b */
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

    /* renamed from: c */
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

    /* renamed from: b */
    private final void m1422b(ScrollState scrollState, ScrollState scrollState2) {
        if (this.f926F != null) {
            this.f926F.mo478a(this, scrollState, scrollState2);
        }
        Iterator it = this.f945l.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).mo478a(this, scrollState, scrollState2);
        }
    }

    /* renamed from: g */
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
