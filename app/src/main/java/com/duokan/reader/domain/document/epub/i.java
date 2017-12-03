package com.duokan.reader.domain.document.epub;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.core.sys.ah;
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
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class i extends as implements com.duokan.reader.domain.document.i {
    static final /* synthetic */ boolean c = (!i.class.desiredAssertionStatus());
    private final EpubTypesettingContext d;
    private final h e;
    private au f = null;
    private final al g;
    private final at h;
    private final Callback i = new j(this);
    private r j = null;
    private boolean k = false;
    private az l = null;
    private az m = null;
    private az n = null;
    private az o = null;
    private Rect p = new Rect();
    private Rect q = new Rect();
    private boolean r = false;
    private boolean s = false;
    private CountDownLatch t = null;

    public /* synthetic */ as b() {
        return S();
    }

    public /* synthetic */ as c() {
        return T();
    }

    public i(EpubTypesettingContext epubTypesettingContext, h hVar, au auVar, al alVar, at atVar) {
        if (!c && (epubTypesettingContext == null || auVar == null)) {
            throw new AssertionError();
        } else if (c || (hVar != null && hVar.a())) {
            a.c().b(N());
            this.d = epubTypesettingContext;
            this.d.b((Object) t.b());
            this.e = new h(this.d, hVar, 0);
            this.f = auVar;
            this.g = alVar;
            this.h = atVar;
            this.j = this.d.a(this.e, new k(this));
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
        r1 = com.duokan.core.diagnostic.setDrawable.showAnimation();
        r2 = r4.N();
        r1.getVisible(r2);
        r1 = r4.setDrawable();
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        monitor-enter(r4);
        r1 = r4.r;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        goto L_0x0012;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = r4.TaskHandler;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x001a }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x001a }
        r4.TaskHandler = r0;	 Catch:{ all -> 0x001a }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
    L_0x002a:
        r0 = r4.r;
        if (r0 != 0) goto L_0x0050;
    L_0x002e:
        r0 = r4.getWidthPixels;
        r0 = r0.getScaledTouchSlop();
        if (r0 != 0) goto L_0x0050;
    L_0x0036:
        r0 = r4.getScaledTouchSlop;
        r0 = r0.setDrawable;
        if (r0 == 0) goto L_0x0050;
    L_0x003c:
        r0 = r4.getScaledTouchSlop;
        r0 = r0.showAnimation();
        if (r0 != 0) goto L_0x0050;
    L_0x0044:
        r0 = r4.TaskHandler;	 Catch:{ InterruptedException -> 0x004e }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x004e }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0050:
        r0 = r4.setDrawable();
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.getPhysicalYPixels.P():boolean");
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
        if (!G()) {
            return false;
        }
        if (this.l.k() || this.m.k()) {
            return true;
        }
        return false;
    }

    public ak l() {
        a.c().b(N());
        return this.e;
    }

    public bb m() {
        a.c().b(N());
        if (E()) {
            return new ce(this.e.n(), this.e.o());
        }
        return new ce();
    }

    public d[] n() {
        a.c().b(N());
        if (!E()) {
            return new d[0];
        }
        Object e = this.l.e();
        Object e2 = this.m.e();
        d[] dVarArr = new c[(e.length + e2.length)];
        System.arraycopy(e, 0, dVarArr, 0, e.length);
        System.arraycopy(e2, 0, dVarArr, e.length, e2.length);
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
        return this.d.j();
    }

    public m q() {
        a.c().b(N());
        return this.f;
    }

    public void a(m mVar) {
        a.c().b(N());
        if (E()) {
            this.f = (au) mVar;
            m auVar = new au(this.f);
            auVar.l = this.l.q().l;
            auVar.m = this.l.q().m;
            auVar.r = ((au) this.l.q()).r;
            m auVar2 = new au(this.f);
            auVar2.l = this.m.q().l;
            auVar2.m = this.m.q().m;
            auVar2.r = ((au) this.m.q()).r;
            this.l.a(auVar);
            this.m.a(auVar2);
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
        if (!c && !G()) {
            throw new AssertionError();
        } else if (G()) {
            return this.l.s() + this.m.s();
        } else {
            return 0;
        }
    }

    public int t() {
        a.c().b(N());
        if (G()) {
            return this.l.t() + this.m.t();
        }
        return 0;
    }

    public int u() {
        a.c().b(N());
        if (G()) {
            return this.l.u() + this.m.u();
        }
        return 0;
    }

    public int x() {
        a.c().b(N());
        if (G()) {
            return this.l.x() + this.m.x();
        }
        return 0;
    }

    public int v() {
        a.c().b(N());
        if (G()) {
            return this.l.v() + this.m.v();
        }
        return 0;
    }

    public int w() {
        a.c().b(N());
        if (G()) {
            return this.l.w() + this.m.w();
        }
        return 0;
    }

    public int y() {
        a.c().b(N());
        if (G()) {
            return this.l.y() + this.m.y();
        }
        return 0;
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
        if (!G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (!this.l.A().isEmpty()) {
            return d();
        }
        if (this.m.A().isEmpty()) {
            return new Rect(0, 0, 0, 0);
        }
        return e();
    }

    public int B() {
        a.c().b(N());
        if (E()) {
            return this.l.B() + this.m.B();
        }
        return 0;
    }

    public Rect a(au auVar) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (this.l.b(auVar)) {
            return new Rect(d());
        }
        if (this.m.b(auVar)) {
            return new Rect(e());
        }
        return new Rect();
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
        ah.b(new n(this, runnable2, runnable));
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
        if (a()) {
            this.l.a(z);
            this.m.a(z);
        }
    }

    public ae a(Point point) {
        a.c().b(N());
        if (!G()) {
            return null;
        }
        if (h(point)) {
            return this.l.a(n(point));
        } else if (!i(point)) {
            return null;
        } else {
            return this.m.a(o(point));
        }
    }

    public bb a(Point point, Point point2) {
        a.c().b(N());
        if (!G()) {
            return new ce(new c(0, 0, 0), new c(0, 0, 0));
        }
        if (j(point) && !k(point2)) {
            return this.n.b(p(point), p(point2));
        } else if (k(point) && !j(point2)) {
            return this.o.b(q(point), q(point2));
        } else if (j(point) && k(point2)) {
            r0 = p(point);
            r1 = new Point(this.n.p().b().right, this.n.p().b().bottom);
            r2 = new Point(this.o.p().b().left, this.o.p().b().top);
            r3 = q(point2);
            r0 = this.n.b(r0, r1);
            r1 = this.o.b(r2, r3);
            if (c || (r0 != null && r1 != null)) {
                return ce.a(r0, r1);
            }
            throw new AssertionError();
        } else if (!k(point) || !j(point2)) {
            return new ce(new c(0, 0, 0), new c(0, 0, 0));
        } else {
            r0 = p(point2);
            r1 = new Point(this.n.p().b().right, this.n.p().b().bottom);
            r2 = new Point(this.o.p().b().left, this.o.p().b().top);
            r3 = q(point);
            r0 = this.n.b(r0, r1);
            r1 = this.o.b(r2, r3);
            if (c || (r0 != null && r1 != null)) {
                return ce.a(r0, r1);
            }
            throw new AssertionError();
        }
    }

    public bb b(Point point) {
        a.c().b(N());
        if (!G()) {
            return new ce(new c(0, 0, 0), new c(0, 0, 0));
        }
        if (h(point)) {
            return this.l.h(n(point));
        } else if (!i(point)) {
            return new ce(new c(0, 0, 0), new c(0, 0, 0));
        } else {
            return this.m.h(o(point));
        }
    }

    public int c(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.c(n(point));
        } else if (!i(point)) {
            return -1;
        } else {
            int c = this.m.c(o(point));
            if (c >= 0) {
                return this.l.r() + c;
            }
            return -1;
        }
    }

    public int f(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.f(n(point));
        } else if (!i(point)) {
            return -1;
        } else {
            int f = this.m.f(o(point));
            if (f >= 0) {
                return this.l.s() + f;
            }
            return -1;
        }
    }

    public int g(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.g(n(point));
        } else if (!i(point)) {
            return -1;
        } else {
            int g = this.m.g(o(point));
            if (g >= 0) {
                return this.l.B() + g;
            }
            return -1;
        }
    }

    public int a(Point point, int i) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.a(n(point), i);
        } else if (!i(point)) {
            return -1;
        } else {
            int a = this.m.a(o(point), i);
            if (a >= 0) {
                return this.l.t() + a;
            }
            return -1;
        }
    }

    public int d(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.d(n(point));
        } else if (!i(point)) {
            return -1;
        } else {
            int d = this.m.d(o(point));
            if (d >= 0) {
                return this.l.u() + d;
            }
            return -1;
        }
    }

    public int e(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        if (h(point)) {
            return this.l.e(n(point));
        } else if (!i(point)) {
            return -1;
        } else {
            int e = this.m.e(o(point));
            if (e >= 0) {
                return this.l.v() + e;
            }
            return -1;
        }
    }

    public int a(bb bbVar) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        int a = this.l.a(bbVar);
        if (a >= 0) {
            return a;
        }
        a = this.m.a(bbVar);
        if (a >= 0) {
            return this.l.v() + a;
        }
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
        if (!E()) {
            return null;
        }
        if (i < this.l.r()) {
            return this.l.c(i);
        }
        return this.m.c(i - this.l.r());
    }

    public aw d(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.s()) {
            return this.l.d(i);
        }
        return this.m.d(i - this.l.s());
    }

    public ab e(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.t()) {
            return this.l.e(i);
        }
        return this.m.e(i - this.l.t());
    }

    public com.duokan.reader.domain.document.ah f(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.u()) {
            return this.l.f(i);
        }
        return this.m.f(i - this.l.u());
    }

    public Rect g(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.r()) {
            a(new Rect(this.l.g(i)));
            return new Rect(this.l.g(i));
        }
        b(new Rect(this.m.g(i - this.l.r())));
        return new Rect(this.m.g(i - this.l.r()));
    }

    public Rect h(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.s()) {
            a(new Rect(this.l.h(i)));
            return new Rect(this.l.h(i));
        }
        b(new Rect(this.m.h(i - this.l.s())));
        return new Rect(this.m.h(i - this.l.s()));
    }

    public Rect i(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.t()) {
            a(new Rect(this.l.i(i)));
            return new Rect(this.l.i(i));
        }
        b(new Rect(this.m.i(i - this.l.t())));
        return new Rect(this.m.i(i - this.l.t()));
    }

    public Rect j(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.u()) {
            a(new Rect(this.l.j(i)));
            return new Rect(this.l.j(i));
        }
        b(new Rect(this.m.j(i - this.l.u())));
        return new Rect(this.m.j(i - this.l.u()));
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
        if (U().b(bbVar) && V().b(bbVar)) {
            bb b = ce.b((ce) bbVar, new ce(U().k(), V().l()));
            bb b2 = ce.b((ce) bbVar, new ce(V().k(), V().l()));
            String b3 = S().b(b);
            return b3 + T().b(b2);
        } else if (U().b(bbVar)) {
            return this.l.b(bbVar);
        } else {
            if (V().b(bbVar)) {
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
        if (U().b(bbVar) && V().b(bbVar)) {
            bb b = ce.b((ce) bbVar, new ce(U().k(), U().l()));
            bb b2 = ce.b((ce) bbVar, new ce(V().k(), V().l()));
            String c = this.l.c(b);
            return c + this.m.c(b2);
        } else if (U().b(bbVar)) {
            return this.l.b(bbVar);
        } else {
            if (V().b(bbVar)) {
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
            if (U().b(bbVar) && V().b(bbVar)) {
                bb b = ce.b((ce) bbVar, new ce(U().k(), U().l()));
                bb b2 = ce.b((ce) bbVar, new ce(V().k(), V().l()));
                Rect d = this.l.d(b);
                Rect d2 = this.m.d(b2);
                a(d);
                b(d2);
                Rect rect = new Rect(d);
                rect.union(d2);
                return rect;
            } else if (U().b(bbVar)) {
                a(this.l.d(bbVar));
                return this.l.d(bbVar);
            } else if (!V().b(bbVar)) {
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
            if (U().b(bbVar) && V().b(bbVar)) {
                bb b = ce.b((ce) bbVar, new ce(U().k(), U().l()));
                bb b2 = ce.b((ce) bbVar, new ce(V().k(), V().l()));
                Rect[] e = this.l.e(b);
                Rect[] e2 = this.m.e(b2);
                a(e);
                b(e2);
                rectArr = new Rect[(e.length + e2.length)];
                System.arraycopy(e, 0, rectArr, 0, e.length);
                System.arraycopy(e2, 0, rectArr, e.length, e2.length);
                return rectArr;
            } else if (U().b(bbVar)) {
                rectArr = this.l.e(bbVar);
                a(rectArr);
                return rectArr;
            } else if (!V().b(bbVar)) {
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
        if (!c && !G()) {
            throw new AssertionError();
        } else if (U().b(bbVar)) {
            return l(this.l.f(bbVar));
        } else {
            if (V().b(bbVar)) {
                return m(this.m.f(bbVar));
            }
            return new Point();
        }
    }

    public Point g(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (V().b(bbVar)) {
            return m(this.m.g(bbVar));
        } else {
            if (U().b(bbVar)) {
                return l(this.l.g(bbVar));
            }
            return new Point();
        }
    }

    public ac k(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.v()) {
            return this.l.k(i);
        }
        return this.m.k(i - this.l.v());
    }

    public Rect l(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.v()) {
            a(new Rect(this.l.l(i)));
            return new Rect(this.l.l(i));
        }
        b(new Rect(this.m.l(i - this.l.v())));
        return new Rect(this.m.l(i - this.l.v()));
    }

    public Rect m(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.v()) {
            a(new Rect(this.l.m(i)));
            return new Rect(this.l.m(i));
        }
        b(new Rect(this.m.m(i - this.l.v())));
        return new Rect(this.m.m(i - this.l.v()));
    }

    public aj n(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.w()) {
            return this.l.n(i);
        }
        return this.m.n(i - this.l.w());
    }

    public Rect p(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.w()) {
            a(new Rect(this.l.p(i)));
            return new Rect(this.l.p(i));
        }
        b(new Rect(this.m.p(i - this.l.w())));
        return new Rect(this.m.p(i - this.l.w()));
    }

    public Rect o(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.w()) {
            a(new Rect(this.l.o(i)));
            return new Rect(this.l.o(i));
        }
        b(new Rect(this.m.o(i - this.l.w())));
        return new Rect(this.m.o(i - this.l.w()));
    }

    public ad q(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.x()) {
            return this.l.w(i);
        }
        return this.m.w(i - this.l.x());
    }

    public Rect r(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.x()) {
            a(new Rect(this.l.r(i)));
            return new Rect(this.l.r(i));
        }
        b(new Rect(this.m.r(i - this.l.x())));
        return new Rect(this.m.r(i - this.l.x()));
    }

    public ax s(int i) {
        a.c().b(N());
        if (!E()) {
            return null;
        }
        if (i < this.l.y()) {
            return this.l.s(i);
        }
        return this.m.s(i - this.l.y());
    }

    public Rect t(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.y()) {
            a(new Rect(this.l.t(i)));
            return new Rect(this.l.t(i));
        }
        b(new Rect(this.m.t(i - this.l.y())));
        return new Rect(this.m.t(i - this.l.y()));
    }

    public Rect u(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        if (i < this.l.B()) {
            return this.l.u(i);
        }
        b(new Rect(this.m.u(i - this.l.B())));
        return new Rect(this.m.u(i - this.l.B()));
    }

    public int v(int i) {
        a.c().b(N());
        if (!E()) {
            return -1;
        }
        if (i < this.l.B()) {
            return this.l.v(i);
        }
        return this.m.v(i - this.l.B());
    }

    public List Q() {
        a.c().b(N());
        if (!E()) {
            return Collections.emptyList();
        }
        Collection Q = this.l.Q();
        Collection Q2 = this.m.Q();
        List arrayList = new ArrayList(Q.size() + Q2.size());
        arrayList.addAll(Q);
        arrayList.addAll(Q2);
        return arrayList;
    }

    public List R() {
        a.c().b(N());
        if (!E()) {
            return Collections.emptyList();
        }
        Collection R = this.l.R();
        Collection R2 = this.m.R();
        List arrayList = new ArrayList(R.size() + R2.size());
        arrayList.addAll(R);
        arrayList.addAll(R2);
        return arrayList;
    }

    public boolean a() {
        a.c().b(N());
        return this.r;
    }

    public az S() {
        a.c().b(N());
        if (c || a()) {
            return this.l;
        }
        throw new AssertionError();
    }

    public az T() {
        a.c().b(N());
        if (c || a()) {
            return this.m;
        }
        throw new AssertionError();
    }

    public Rect d() {
        if (a()) {
            return this.l == this.n ? this.p : this.q;
        } else {
            return this.p;
        }
    }

    public Rect e() {
        if (a()) {
            return this.l == this.n ? this.q : this.p;
        } else {
            return this.q;
        }
    }

    protected void O() {
        if (G()) {
            this.l.O();
            this.m.O();
        }
    }

    protected int b(Canvas canvas, long j) {
        int i;
        int i2 = 2;
        if (this.l == null || !this.l.G()) {
            this.f.a.setBounds(d());
            this.f.a.draw(canvas);
            i = 2;
        } else {
            this.l.setBounds(d());
            this.l.a(canvas, j);
            i = this.l.i();
        }
        if (this.m == null || !this.m.G()) {
            this.f.a.setBounds(e());
            this.f.a.draw(canvas);
        } else {
            this.m.setBounds(e());
            this.m.a(canvas, j);
            i2 = this.m.i();
        }
        return i | i2;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.p = new Rect(rect.left, rect.top, rect.centerX(), rect.bottom);
        this.q = new Rect(rect.centerX(), rect.top, rect.right, rect.bottom);
    }

    public int getIntrinsicWidth() {
        a.c().b(N());
        return super.getIntrinsicWidth() * 2;
    }

    public int getIntrinsicHeight() {
        a.c().b(N());
        if (G()) {
            return Math.max(this.l.getIntrinsicHeight(), this.m.getIntrinsicHeight());
        }
        return super.getIntrinsicHeight();
    }

    private boolean h(Point point) {
        return d().contains(point.x, point.y);
    }

    private boolean i(Point point) {
        return e().contains(point.x, point.y);
    }

    private boolean j(Point point) {
        return this.p.contains(point.x, point.y);
    }

    private boolean k(Point point) {
        return this.q.contains(point.x, point.y);
    }

    private void a(Rect... rectArr) {
        Rect d = d();
        for (Rect offset : rectArr) {
            offset.offset(d.left, d.top);
        }
    }

    private void b(Rect... rectArr) {
        Rect e = e();
        for (Rect offset : rectArr) {
            offset.offset(e.left, e.top);
        }
    }

    private Point l(Point point) {
        Rect d = d();
        return new Point(point.x + d.left, d.top + point.y);
    }

    private Point m(Point point) {
        Rect e = e();
        return new Point(point.x + e.left, e.top + point.y);
    }

    private Point n(Point point) {
        Rect d = d();
        return new Point(point.x - d.left, point.y - d.top);
    }

    private Point o(Point point) {
        Rect e = e();
        return new Point(point.x - e.left, point.y - e.top);
    }

    private Point p(Point point) {
        return new Point(point.x - this.p.left, point.y - this.p.top);
    }

    private Point q(Point point) {
        return new Point(point.x - this.q.left, point.y - this.q.top);
    }

    private ay U() {
        return (ay) this.l.l();
    }

    private ay V() {
        return (ay) this.m.l();
    }
}
