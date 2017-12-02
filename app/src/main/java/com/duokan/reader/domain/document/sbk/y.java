package com.duokan.reader.domain.document.sbk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.af;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.al;
import com.duokan.reader.domain.document.ap;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.bc;
import com.duokan.reader.domain.document.bd;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class y extends u implements ba, bd, af {
    static final /* synthetic */ boolean c = (!y.class.desiredAssertionStatus());
    private final SbkTypesettingContext d;
    private final x e;
    private w f = null;
    private final al g;
    private final at h;
    private ag i = null;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m = -1;
    private long n = -1;
    private String o = null;
    private String p = null;
    private ap q = null;
    private ap r = null;
    private List s = Collections.emptyList();

    public /* synthetic */ bb a(Point point, Point point2) {
        return b(point, point2);
    }

    public /* synthetic */ bb b(Point point) {
        return h(point);
    }

    public /* synthetic */ d[] n() {
        return d();
    }

    public y(SbkTypesettingContext sbkTypesettingContext, x xVar, w wVar, al alVar, at atVar) {
        if (!c && (sbkTypesettingContext == null || wVar == null)) {
            throw new AssertionError();
        } else if (c || (xVar != null && xVar.a())) {
            a.c().b(N());
            this.d = sbkTypesettingContext;
            this.d.b((Object) t.b());
            this.d.b((Object) this);
            this.e = new x(this.d, xVar, 0);
            this.f = wVar;
            this.g = alVar;
            this.h = atVar;
            this.m = this.d.g().b;
            this.i = this.d.a(this.e, this);
        } else {
            throw new AssertionError();
        }
    }

    public long c() {
        a.c().b(N());
        return this.i.a;
    }

    public boolean a() {
        a.c().b(N());
        if (E()) {
            return this.l;
        }
        return false;
    }

    public boolean b() {
        a.c().b(N());
        return false;
    }

    public List D() {
        a.c().b(N());
        return this.s;
    }

    public long j() {
        a.c().b(N());
        return this.n;
    }

    public k p() {
        a.c().b(N());
        return this.d.g();
    }

    public m q() {
        a.c().b(N());
        return this.f;
    }

    public void a(m mVar) {
        O();
        this.f = (w) mVar;
        invalidateSelf();
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
            return new ah(this.e.j(), this.e.k());
        }
        return new ah();
    }

    public b[] d() {
        a.c().b(N());
        return new b[0];
    }

    public CharSequence o() {
        a.c().b(N());
        return "";
    }

    public int r() {
        a.c().b(N());
        return 0;
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

    public int x() {
        a.c().b(N());
        return 0;
    }

    public int v() {
        a.c().b(N());
        return 0;
    }

    public int w() {
        a.c().b(N());
        return 0;
    }

    public int y() {
        a.c().b(N());
        return 0;
    }

    public Rect z() {
        a.c().b(N());
        return new Rect();
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
        while (!this.j && !this.i.c() && this.d.a && !this.d.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return G();
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.c().b(N());
        ah.b(new z(this, runnable, runnable2));
    }

    public boolean F() {
        a.c().b(N());
        return this.i.c();
    }

    public boolean G() {
        a.c().b(N());
        return !this.i.c() && this.j;
    }

    public void H() {
        a.c().b(N());
        if (!this.i.c()) {
            this.i.f();
            if (this.k) {
                e();
                this.j = false;
            }
            O();
            this.d.b((bd) this);
            this.d.c(t.b());
        }
    }

    public void a(boolean z) {
        a.c().b(N());
        if (this.q != null) {
            if (z) {
                this.g.a(this.q, true);
            } else {
                this.g.a(this.q);
            }
            this.q = null;
        }
    }

    public ae a(Point point) {
        a.c().b(N());
        return null;
    }

    public ah b(Point point, Point point2) {
        a.c().b(N());
        if (c || G()) {
            return new ah();
        }
        throw new AssertionError();
    }

    public ah h(Point point) {
        a.c().b(N());
        if (c || G()) {
            return new ah();
        }
        throw new AssertionError();
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
        return new Rect();
    }

    public String I() {
        return this.o == null ? "" : this.o;
    }

    public String J() {
        a.c().b(N());
        return "";
    }

    public String b(bb bbVar) {
        a.c().b(N());
        if (c || bbVar != null) {
            return "";
        }
        throw new AssertionError();
    }

    public String K() {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.f.k) {
            return DkUtils.chs2chtText(J());
        } else {
            return J();
        }
    }

    public String c(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.f.k) {
            return DkUtils.chs2chtText(b(bbVar));
        } else {
            return b(bbVar);
        }
    }

    public Rect d(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (c || bbVar != null) {
            return new Rect();
        } else {
            throw new AssertionError();
        }
    }

    public Rect[] e(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (c || bbVar != null) {
            return new Rect[0];
        } else {
            throw new AssertionError();
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
        if (this.q != null) {
            this.g.b(this.q);
            this.q = null;
        }
        if (this.r != null) {
            this.g.b(this.r);
            this.r = null;
        }
    }

    protected int b(Canvas canvas, long j) {
        if (!c && this.e == null) {
            throw new AssertionError();
        } else if (!this.k) {
            a(canvas);
            return 2;
        } else if (this.e.f()) {
            return 1;
        } else {
            int i;
            Rect P = P();
            if (this.q != null && (this.q.b() != this.f || this.q.d() != L() || this.q.f() || this.q.a(P, 1.0f) == 0)) {
                this.g.b(this.q);
                this.q = null;
            }
            if (this.r != null && (this.r.b() != this.f || this.r.d() != L() || this.r.f() || this.r.a(P, 1.0f) == 0)) {
                this.g.b(this.r);
                this.r = null;
            }
            if (this.q == null) {
                this.q = this.g.a(this.d, this.e, P, this.f, 1.0f, L());
            } else {
                int a = this.q.a(P, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.g.a(this.d, this.e, P, this.f, 1.0f, L(), a + 1);
                    if (a2 != null) {
                        if (!a2.e()) {
                            this.g.a(a2);
                        } else if (c || !a2.f()) {
                            this.g.b(this.q);
                            this.q = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.q != null) {
                obj = this.q.a(P, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.q.a(canvas, 0.0f, 0.0f, 1.0f)) {
                    a(canvas);
                    i = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i = 3;
                } else {
                    i = 1;
                }
            } else {
                a(canvas);
                obj = null;
                i = 2;
            }
            if (this.r == this.q) {
                this.r = null;
            }
            if (this.r != null && this.r.e()) {
                this.r = null;
            }
            if (this.r == null && r0 == null) {
                this.r = Q();
            }
            if (k() || this.d.d()) {
                return i;
            }
            this.a.setTextSize((float) this.f.f);
            h d = this.d.e().d();
            if (this.d.g().c.top >= this.f.f) {
                float length;
                float f;
                if (this.f.m && this.o == null) {
                    this.o = d.a();
                    g b = d.b(this.e);
                    if (!(b == null || b.f().equals(this.e.j()))) {
                        this.o = b.e();
                    }
                    if (this.f.k) {
                        this.o = DkUtils.chs2chtText(this.o);
                    }
                }
                if (this.f.l) {
                    length = (float) d.a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f.m || TextUtils.isEmpty(this.o) || (this.f.l && this.o == d.a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.o.length();
                }
                int width = getBounds().width() - (p().c.left + p().c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    a(canvas, d.a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) > 0) {
                    String str = this.o;
                    int i2 = (!this.f.n || this.f.l) ? 5 : 3;
                    a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.d.g().c.bottom < this.f.f) {
                return i;
            }
            if (this.p == null && this.n >= 0) {
                this.p = String.format("%d / %d", new Object[]{Long.valueOf(this.n + 1), Long.valueOf(this.d.b())});
            }
            if (TextUtils.isEmpty(this.p)) {
                return i;
            }
            int i3;
            String str2 = this.p;
            if (this.f.n) {
                i3 = 5;
            } else {
                i3 = 1;
            }
            a(canvas, str2, i3, this.a);
            return i;
        }
    }

    public void a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.i != null) {
            this.n = c(this.i);
        }
        a(new ab(this));
    }

    public void a(ag agVar) {
        boolean z = true;
        if (!c && (this.d == null || !this.d.a)) {
            throw new AssertionError();
        } else if (c || (this.e != null && this.e.b())) {
            this.i = agVar;
            if (this.d.b() >= 0) {
                this.n = c(this.i);
            } else {
                this.d.a((bd) this);
            }
            if (this.i.c() || this.e.f()) {
                this.o = "";
            } else {
                this.m = this.i.j;
                if (!this.e.f()) {
                    if (!c && this.r != null) {
                        throw new AssertionError();
                    } else if (this.r == null) {
                        this.r = Q();
                    }
                }
            }
            this.j = true;
            if (R() != null) {
                z = false;
            }
            this.l = z;
            a(new ac(this));
            this.d.c(this);
        } else {
            throw new AssertionError();
        }
    }

    public void b(ag agVar) {
        if (c || this.i.c()) {
            this.j = false;
            a(new ad(this));
            this.d.c(this);
            return;
        }
        throw new AssertionError();
    }

    public int getIntrinsicHeight() {
        return this.m;
    }

    public void invalidateSelf() {
        if (!this.s.isEmpty()) {
            O();
        }
        super.invalidateSelf();
    }

    private void e() {
        if (!this.j) {
        }
    }

    private Rect P() {
        Rect rect = new Rect(0, 0, this.d.g().a, this.m);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    private long c(ag agVar) {
        if (c || (agVar != null && this.d.b() >= 0)) {
            return this.d.a(agVar.a, agVar.b, agVar.c);
        }
        throw new AssertionError();
    }

    private ap Q() {
        Rect P = P();
        ap a = this.g.a(this.d, this.e, P, this.f, 1.0f, L());
        if (a != null) {
            this.g.a(a);
            if (a.a(P, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        a = this.g.a(this.d, this.e, P, this.f, 1.0f, L(), new ae(this));
        this.g.a(a);
        return a;
    }

    private void a(Bitmap bitmap, Bitmap bitmap2) {
        if (!c && bitmap == null) {
            throw new AssertionError();
        } else if (!c && this.f == null) {
            throw new AssertionError();
        } else if (c || this.d.a) {
            boolean a;
            v R = R();
            Canvas canvas = new Canvas(bitmap);
            bitmap.eraseColor(0);
            if (R != null) {
                float b;
                if (this.d.d()) {
                    b = ((float) this.i.i) / ((float) R.b());
                    canvas.scale(b, b);
                } else {
                    b = Math.min(((float) this.i.i) / ((float) R.b()), ((float) this.i.j) / ((float) R.f()));
                    canvas.translate((((float) this.i.i) - (((float) R.b()) * b)) / 2.0f, (((float) this.i.j) - (((float) R.f()) * b)) / 2.0f);
                    canvas.scale(b, b);
                }
                a = R.a(canvas, new Rect(0, 0, R.b(), R.f()));
            } else {
                a = false;
            }
            if (a) {
                this.s = Collections.emptyList();
                return;
            }
            if (R != null) {
                this.s = Arrays.asList(new String[]{R.c()});
            }
            if (this.h != null) {
                this.h.b(null, this);
            }
        } else {
            throw new AssertionError();
        }
    }

    private v R() {
        if (this.e.b()) {
            return this.d.e().a(this.e);
        }
        return null;
    }
}
