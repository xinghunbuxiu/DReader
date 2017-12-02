package com.duokan.reader.domain.document.txt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.af;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.al;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.i;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;

import org.apache.http.HttpStatus;

import java.util.concurrent.CountDownLatch;

public class f extends ag implements i {
    static final /* synthetic */ boolean c = (!f.class.desiredAssertionStatus());
    private final au d;
    private final e e;
    private ah f = null;
    private final al g;
    private final at h;
    private final Callback i = new g(this);
    private o j = null;
    private boolean k = false;
    private aj l = null;
    private aj m = null;
    private Rect n = new Rect();
    private Rect o = new Rect();
    private boolean p = false;
    private CountDownLatch q = null;
    private Paint r = new Paint();

    public /* synthetic */ as b() {
        return Q();
    }

    public /* synthetic */ as c() {
        return R();
    }

    public f(au auVar, e eVar, ah ahVar, al alVar, at atVar) {
        if (!c && (auVar == null || ahVar == null)) {
            throw new AssertionError();
        } else if (c || (eVar != null && eVar.a())) {
            a.c().b(N());
            this.d = auVar;
            this.d.b((Object) t.b());
            this.e = new e(this.d, eVar, 0);
            this.f = ahVar;
            this.g = alVar;
            this.h = atVar;
            this.j = this.d.a(this.e, new h(this));
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean P() {
        /*
        r4 = this;
        r0 = 1;
        r1 = com.duokan.core.diagnostic.a.c();
        r2 = r4.N();
        r1.b(r2);
        r1 = r4.a();
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        monitor-enter(r4);
        r1 = r4.p;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        goto L_0x0012;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = r4.q;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x001a }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x001a }
        r4.q = r0;	 Catch:{ all -> 0x001a }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
    L_0x002a:
        r0 = r4.p;
        if (r0 != 0) goto L_0x0050;
    L_0x002e:
        r0 = r4.j;
        r0 = r0.d();
        if (r0 != 0) goto L_0x0050;
    L_0x0036:
        r0 = r4.d;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0050;
    L_0x003c:
        r0 = r4.d;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0050;
    L_0x0044:
        r0 = r4.q;	 Catch:{ InterruptedException -> 0x004e }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x004e }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0050:
        r0 = r4.a();
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.f.P():boolean");
    }

    public long j() {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (G()) {
            return this.l.j();
        } else {
            return -1;
        }
    }

    public boolean k() {
        a.c().b(N());
        return false;
    }

    public ak l() {
        a.c().b(N());
        return this.e;
    }

    public bb m() {
        if (E()) {
            return new at(this.e.n(), this.e.o());
        }
        return new at();
    }

    public d[] n() {
        a.c().b(N());
        if (!E()) {
            return new d[0];
        }
        Object c = this.l.c();
        Object c2 = this.m.c();
        d[] dVarArr = new b[(c.length + c2.length)];
        System.arraycopy(c, 0, dVarArr, 0, c.length);
        System.arraycopy(c2, 0, dVarArr, c.length, c2.length);
        return dVarArr;
    }

    public CharSequence o() {
        a.c().b(N());
        if (!E()) {
            return "";
        }
        CharSequence o = this.l.o();
        CharSequence o2 = this.m.o();
        return TextUtils.concat(new CharSequence[]{o, o2});
    }

    public k p() {
        a.c().b(N());
        return this.d.h();
    }

    public m q() {
        a.c().b(N());
        return this.f;
    }

    public void a(m mVar) {
        a.c().b(N());
        if (E()) {
            this.f = (ah) mVar;
            m ahVar = new ah(this.f);
            ahVar.l = this.l.q().l;
            ahVar.m = this.l.q().m;
            m ahVar2 = new ah(this.f);
            ahVar2.l = this.m.q().l;
            ahVar2.m = this.m.q().m;
            this.l.a(ahVar);
            this.m.a(ahVar2);
        }
    }

    public int r() {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (G()) {
            return this.l.r() + this.m.r();
        } else {
            return 0;
        }
    }

    public int s() {
        a.c().b(N());
        return 0;
    }

    public int t() {
        a.c().b(N());
        return 0;
    }

    public int u() {
        a.c().b(N());
        return 0;
    }

    public int v() {
        a.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public int w() {
        a.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public int x() {
        a.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public int y() {
        a.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public Rect z() {
        a.c().b(N());
        if (!G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (!this.m.z().isEmpty()) {
            b(this.m.z());
            return this.m.z();
        } else if (this.l.z().isEmpty()) {
            return new Rect(0, 0, 0, 0);
        } else {
            a(this.l.z());
            return this.l.z();
        }
    }

    public Rect A() {
        a.c().b(N());
        return new Rect();
    }

    public int B() {
        a.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public Rect a(au auVar) {
        a.c().b(N());
        if (c || G()) {
            return new Rect();
        }
        throw new AssertionError();
    }

    public boolean E() {
        a.c().b(N());
        if (G()) {
            return true;
        }
        if (P() && this.l.E() && this.m.E()) {
            return G();
        }
        return false;
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.c().b(N());
        ah.b(new k(this, runnable2, runnable));
    }

    public boolean F() {
        a.c().b(N());
        return this.j.d();
    }

    public boolean G() {
        a.c().b(N());
        if (!this.j.d() && a() && this.l.G() && this.m.G()) {
            return true;
        }
        return false;
    }

    public void H() {
        a.c().b(N());
        if (!this.j.d()) {
            this.j.a();
            if (a()) {
                this.l.H();
                this.m.H();
            }
            this.d.c(t.b());
        }
    }

    public void a(boolean z) {
        a.c().b(N());
        if (a()) {
            this.l.a(z);
            this.m.a(z);
        }
    }

    public ae a(Point point) {
        a.c().b(N());
        return null;
    }

    public bb a(Point point, Point point2) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!G()) {
            return new at(new b(0), new b(0));
        } else {
            if (h(point) && !i(point2)) {
                return this.l.b(j(point), j(point2));
            } else if (i(point) && !h(point2)) {
                return this.m.b(k(point), k(point2));
            } else if (h(point) && i(point2)) {
                r0 = j(point);
                r1 = new Point(this.l.p().b().right, this.l.p().b().bottom);
                r2 = new Point(this.m.p().b().left, this.m.p().b().top);
                r3 = k(point2);
                r0 = this.l.b(r0, r1);
                r1 = this.m.b(r2, r3);
                if (c || (r0 != null && r1 != null)) {
                    return at.a(r0, r1);
                }
                throw new AssertionError();
            } else if (!i(point) || !h(point2)) {
                return new at(new b(0), new b(0));
            } else {
                r0 = j(point2);
                r1 = new Point(this.l.p().b().right, this.l.p().b().bottom);
                r2 = new Point(this.m.p().b().left, this.m.p().b().top);
                r3 = k(point);
                r0 = this.l.b(r0, r1);
                r1 = this.m.b(r2, r3);
                if (c || (r0 != null && r1 != null)) {
                    return at.a(r0, r1);
                }
                throw new AssertionError();
            }
        }
    }

    public bb b(Point point) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!G()) {
            return new at(new b(0), new b(0));
        } else {
            if (h(point)) {
                return this.l.h(j(point));
            } else if (!i(point)) {
                return new at(new b(0), new b(0));
            } else {
                return this.m.h(k(point));
            }
        }
    }

    public int c(Point point) {
        a.c().b(N());
        return -1;
    }

    public int a(Point point, int i) {
        a.c().b(N());
        return -1;
    }

    public int d(Point point) {
        a.c().b(N());
        return -1;
    }

    public int e(Point point) {
        a.c().b(N());
        return -1;
    }

    public int a(bb bbVar) {
        a.c().b(N());
        return -1;
    }

    public int f(Point point) {
        a.c().b(N());
        return -1;
    }

    public int g(Point point) {
        return -1;
    }

    public Rect b(Rect rect) {
        a.c().b(N());
        return new Rect(rect);
    }

    public Rect c(Rect rect) {
        a.c().b(N());
        return new Rect(rect);
    }

    public af c(int i) {
        a.c().b(N());
        return null;
    }

    public aw d(int i) {
        a.c().b(N());
        return null;
    }

    public ab e(int i) {
        a.c().b(N());
        return null;
    }

    public com.duokan.reader.domain.document.ah f(int i) {
        a.c().b(N());
        return null;
    }

    public Rect g(int i) {
        a.c().b(N());
        return new Rect();
    }

    public Rect h(int i) {
        a.c().b(N());
        return null;
    }

    public Rect i(int i) {
        a.c().b(N());
        return new Rect();
    }

    public Rect j(int i) {
        a.c().b(N());
        return null;
    }

    public String I() {
        return this.l.I();
    }

    public String J() {
        a.c().b(N());
        if (E()) {
            return this.l.J() + this.m.J();
        }
        return "";
    }

    public String b(bb bbVar) {
        a.c().b(N());
        if (!E()) {
            return "";
        }
        if (bbVar == null || bbVar.f()) {
            return "";
        }
        if (S().b(bbVar) && T().b(bbVar)) {
            bb b = at.b((at) bbVar, new at(S().n(), S().o()));
            bb b2 = at.b((at) bbVar, new at(T().n(), T().o()));
            String b3 = this.l.b(b);
            return b3 + this.m.b(b2);
        } else if (S().b(bbVar)) {
            return this.l.b(bbVar);
        } else {
            if (T().b(bbVar)) {
                return this.m.b(bbVar);
            }
            return "";
        }
    }

    public String K() {
        a.c().b(N());
        if (E()) {
            return this.l.K() + this.m.K();
        }
        return "";
    }

    public String c(bb bbVar) {
        a.c().b(N());
        if (!E()) {
            return "";
        }
        if (bbVar == null || bbVar.f()) {
            return "";
        }
        if (S().b(bbVar) && T().b(bbVar)) {
            bb b = at.b((at) bbVar, new at(S().n(), S().o()));
            bb b2 = at.b((at) bbVar, new at(T().n(), T().o()));
            String c = this.l.c(b);
            return c + this.m.c(b2);
        } else if (S().b(bbVar)) {
            return this.l.b(bbVar);
        } else {
            if (T().b(bbVar)) {
                return this.m.b(bbVar);
            }
            return "";
        }
    }

    public Rect d(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!G()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect();
            }
            if (S().b(bbVar) && T().b(bbVar)) {
                bb b = at.b((at) bbVar, new at(S().n(), S().o()));
                bb b2 = at.b((at) bbVar, new at(T().n(), T().o()));
                Rect d = this.l.d(b);
                Rect d2 = this.m.d(b2);
                a(d);
                b(d2);
                Rect rect = new Rect(d);
                rect.union(d2);
                return rect;
            } else if (S().b(bbVar)) {
                a(this.l.d(bbVar));
                return this.l.d(bbVar);
            } else if (!T().b(bbVar)) {
                return new Rect();
            } else {
                b(this.m.d(bbVar));
                return this.m.d(bbVar);
            }
        }
    }

    public Rect[] e(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!G()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect[0];
            }
            Rect[] rectArr;
            if (S().b(bbVar) && T().b(bbVar)) {
                bb b = at.b((at) bbVar, new at(S().n(), S().o()));
                bb b2 = at.b((at) bbVar, new at(T().n(), T().o()));
                Rect[] e = this.l.e(b);
                Rect[] e2 = this.m.e(b2);
                a(e);
                b(e2);
                rectArr = new Rect[(e.length + e2.length)];
                System.arraycopy(e, 0, rectArr, 0, e.length);
                System.arraycopy(e2, 0, rectArr, e.length, e2.length);
                return rectArr;
            } else if (S().b(bbVar)) {
                rectArr = this.l.e(bbVar);
                a(rectArr);
                return rectArr;
            } else if (!T().b(bbVar)) {
                return new Rect[0];
            } else {
                rectArr = this.m.e(bbVar);
                b(rectArr);
                return rectArr;
            }
        }
    }

    public Point f(bb bbVar) {
        a.c().b(N());
        if (c || G()) {
            Point point = new Point();
            Rect[] e = e(bbVar);
            if (e.length >= 1) {
                point.x = e[0].left;
                point.y = e[0].top;
            }
            return point;
        }
        throw new AssertionError();
    }

    public Point g(bb bbVar) {
        a.c().b(N());
        if (c || G()) {
            Point point = new Point();
            Rect[] e = e(bbVar);
            if (e.length >= 1) {
                point.x = e[e.length - 1].right;
                point.y = e[e.length - 1].bottom;
            }
            return point;
        }
        throw new AssertionError();
    }

    public ac k(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect l(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect m(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public aj n(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect p(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect o(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public ad q(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect r(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public ax s(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect t(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect u(int i) {
        a.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public int v(int i) {
        a.c().b(N());
        if (c || G()) {
            return -1;
        }
        throw new AssertionError();
    }

    protected void O() {
        if (G()) {
            this.l.O();
            this.m.O();
        }
    }

    protected int b(Canvas canvas, long j) {
        int rgb;
        int i = 2;
        Paint paint = this.r;
        if (this.f.e == 0) {
            rgb = Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING);
        } else {
            rgb = this.f.e;
        }
        paint.setColor(rgb);
        this.r.setSubpixelText(true);
        this.r.setAntiAlias(true);
        if (this.l == null || !this.l.G()) {
            this.f.a.setBounds(this.n);
            this.f.a.draw(canvas);
            rgb = 2;
        } else {
            this.l.setBounds(this.n);
            this.l.a(canvas, j);
            rgb = this.l.i();
        }
        if (this.m == null || !this.m.G()) {
            this.f.a.setBounds(this.o);
            this.f.a.draw(canvas);
        } else {
            this.m.setBounds(this.o);
            this.m.a(canvas, j);
            i = this.m.i();
        }
        return rgb | i;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = new Rect(rect.left, rect.top, rect.centerX(), rect.bottom);
        this.o = new Rect(rect.centerX(), rect.top, rect.right, rect.bottom);
    }

    public int getIntrinsicWidth() {
        a.c().b(N());
        return super.getIntrinsicWidth() * 2;
    }

    public boolean a() {
        a.c().b(N());
        return this.p;
    }

    public aj Q() {
        a.c().b(N());
        if (c || a()) {
            return this.l;
        }
        throw new AssertionError();
    }

    public aj R() {
        a.c().b(N());
        if (c || a()) {
            return this.m;
        }
        throw new AssertionError();
    }

    public Rect d() {
        a.c().b(N());
        return this.n;
    }

    public Rect e() {
        a.c().b(N());
        return this.o;
    }

    private boolean h(Point point) {
        return this.n.contains(point.x, point.y);
    }

    private boolean i(Point point) {
        return this.o.contains(point.x, point.y);
    }

    private void a(Rect... rectArr) {
        for (Rect offset : rectArr) {
            offset.offset(this.n.left, this.n.top);
        }
    }

    private void b(Rect... rectArr) {
        for (Rect offset : rectArr) {
            offset.offset(this.o.left, this.o.top);
        }
    }

    private Point j(Point point) {
        return new Point(point.x - this.n.left, point.y - this.n.top);
    }

    private Point k(Point point) {
        return new Point(point.x - this.o.left, point.y - this.o.top);
    }

    private ai S() {
        return (ai) this.l.l();
    }

    private ai T() {
        return (ai) this.m.l();
    }
}
