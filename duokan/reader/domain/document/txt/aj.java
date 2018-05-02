package com.duokan.reader.domain.document.txt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktPage;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.af;
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

public class aj extends ag implements ba, bd, ar {
    static final /* synthetic */ boolean c = (!aj.class.desiredAssertionStatus());
    private final au d;
    private final ai e;
    private ah f = null;
    private final al g;
    private final at h;
    private as i = null;
    private boolean j = false;
    private boolean k = false;
    private int l = -1;
    private long m = -1;
    private String n = null;
    private String o = null;
    private ap p = null;
    private ap q = null;

    public /* synthetic */ bb a(Point point, Point point2) {
        return b(point, point2);
    }

    public /* synthetic */ bb b(Point point) {
        return h(point);
    }

    public /* synthetic */ d[] n() {
        return c();
    }

    public aj(au auVar, ai aiVar, ah ahVar, al alVar, at atVar) {
        if (!c && (auVar == null || ahVar == null)) {
            throw new AssertionError();
        } else if (c || (aiVar != null && aiVar.a())) {
            a.c().b(N());
            this.d = auVar;
            this.d.b((Object) TaskHandler.getThread());
            this.d.b((Object) this);
            this.e = new ai(this.d, aiVar, 0);
            this.f = ahVar;
            this.g = alVar;
            this.h = atVar;
            this.l = this.d.h().b;
            this.i = this.d.a(this.e, (ar) this);
        } else {
            throw new AssertionError();
        }
    }

    public boolean a() {
        a.c().b(N());
        return false;
    }

    public boolean b() {
        a.c().b(N());
        return false;
    }

    public long j() {
        a.c().b(N());
        return this.m;
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
        O();
        this.f = (ah) mVar;
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
            return new at(this.e.n(), this.e.o());
        }
        return new at();
    }

    public b[] c() {
        int i = 0;
        a.c().b(N());
        if (!E()) {
            return new b[0];
        }
        long[] charPositions = Q().getCharPositions();
        b[] bVarArr = new b[charPositions.length];
        while (i < bVarArr.length) {
            bVarArr[i] = ab.a(charPositions[i]);
            i++;
        }
        R();
        return bVarArr;
    }

    public CharSequence o() {
        a.c().b(N());
        if (!E()) {
            return "";
        }
        CharSequence chars = Q().getChars();
        R();
        return chars;
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
        while (!this.j && !this.i.d() && this.d.a && !this.d.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return G();
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.c().b(N());
        ah.submitFuture(new ak(this, runnable, runnable2));
    }

    public boolean F() {
        a.c().b(N());
        return this.i.d();
    }

    public boolean G() {
        a.c().b(N());
        return !this.i.d() && this.j;
    }

    public void H() {
        a.c().b(N());
        if (!this.i.d()) {
            this.i.a();
            if (this.k) {
                d();
                this.j = false;
            }
            O();
            this.d.b((bd) this);
            this.d.c(TaskHandler.getThread());
        }
    }

    public void a(boolean z) {
        a.c().b(N());
        if (this.p != null) {
            if (z) {
                this.g.a(this.p, true);
            } else {
                this.g.a(this.p);
            }
            this.p = null;
        }
    }

    public ae a(Point point) {
        a.c().b(N());
        return null;
    }

    public at b(Point point, Point point2) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!G() || this.e.f()) {
            return new at();
        } else {
            DktPage Q = Q();
            if (c || Q != null) {
                DkPos dkPos = new DkPos();
                dkPos.mX = (float) point.x;
                dkPos.mY = (float) point.y;
                DkPos dkPos2 = new DkPos();
                dkPos2.mX = (float) point2.x;
                dkPos2.mY = (float) point2.y;
                long[] selectionRange = Q.getSelectionRange(dkPos, dkPos2);
                if (selectionRange.length < 2) {
                    return new at();
                }
                at a = ab.a(ab.a(selectionRange[0]), ab.a(selectionRange[1]));
                R();
                return a;
            }
            throw new AssertionError();
        }
    }

    public at h(Point point) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!G() || this.e.f()) {
            return new at();
        } else {
            DktPage Q = Q();
            if (c || Q != null) {
                DkPos dkPos = new DkPos();
                dkPos.mX = (float) point.x;
                dkPos.mY = (float) point.y;
                long[] hitTestTextRangeByMode = Q.hitTestTextRangeByMode(dkPos, 2);
                if (hitTestTextRangeByMode.length < 2) {
                    return new at();
                }
                at a = ab.a(ab.a(hitTestTextRangeByMode[0]), ab.a(hitTestTextRangeByMode[1]));
                R();
                return (at) a.b(m());
            }
            throw new AssertionError();
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
        return new Rect();
    }

    public String I() {
        return this.n == null ? "" : this.n;
    }

    public String J() {
        a.c().b(N());
        if (!E() || this.e.f()) {
            return "";
        }
        String textContent = Q().getTextContent();
        R();
        return textContent;
    }

    public String b(bb bbVar) {
        a.c().b(N());
        if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!E() || this.e.f()) {
            return "";
        } else {
            String str = "";
            at atVar = (at) bbVar.b(m());
            str = Q().getTextContentOfRange(ab.a(atVar.j()), ab.a(atVar.k()));
            R();
            return str;
        }
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
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!G() || this.e.f()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect();
            }
            DkBox[] textRects = Q().getTextRects(((b) bbVar.g()).g(), ((b) bbVar.h()).g());
            Rect rect = new Rect();
            for (int i = 0; i < textRects.length; i++) {
                rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
            }
            R();
            return rect;
        }
    }

    public Rect[] e(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!G() || this.e.f()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect[0];
            }
            bb b = bbVar.b(m());
            if (b == null || b.f()) {
                return new Rect[0];
            }
            DkBox[] textRects = Q().getTextRects(((b) b.g()).g(), ((b) b.h()).g());
            Rect[] rectArr = new Rect[textRects.length];
            for (int i = 0; i < rectArr.length; i++) {
                rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
            }
            Arrays.sort(rectArr, new am(this));
            R();
            return rectArr;
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

    public com.duokan.reader.domain.document.aj n(int i) {
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
        if (this.p != null) {
            this.g.b(this.p);
            this.p = null;
        }
        if (this.q != null) {
            this.g.b(this.q);
            this.q = null;
        }
    }

    protected int b(Canvas canvas, long j) {
        if (!c && this.e == null) {
            throw new AssertionError();
        } else if (!this.k) {
            a(canvas);
            return 2;
        } else if (this.e.f()) {
            this.f.a.setBounds(0, 0, getBounds().width(), getBounds().height());
            this.f.a.draw(canvas);
            return 1;
        } else {
            int i;
            Rect e = e();
            if (M()) {
                O();
            }
            if (this.p != null && (this.p.b() != this.f || this.p.d() != L() || this.p.f() || this.p.a(e, 1.0f) == 0)) {
                this.g.b(this.p);
                this.p = null;
            }
            if (this.q != null && (this.q.b() != this.f || this.q.d() != L() || this.q.f() || this.q.a(e, 1.0f) == 0)) {
                this.g.b(this.q);
                this.q = null;
            }
            if (this.p == null) {
                this.p = this.g.a(this.d, this.e, e, this.f, 1.0f, L());
            } else {
                int a = this.p.a(e, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.g.a(this.d, this.e, e, this.f, 1.0f, L(), a + 1);
                    if (a2 != null) {
                        if (!a2.e()) {
                            this.g.a(a2);
                        } else if (c || !a2.f()) {
                            this.g.b(this.p);
                            this.p = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.p != null) {
                obj = this.p.a(e, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.p.a(canvas, 0.0f, 0.0f, 1.0f)) {
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
            if (this.q == this.p) {
                this.q = null;
            }
            if (this.q != null && this.q.e()) {
                this.q = null;
            }
            if (this.q == null && r0 == null) {
                this.q = P();
            }
            if (k() || this.d.d()) {
                return i;
            }
            this.a.setTextSize((float) this.f.f);
            h d = this.d.e().d();
            if (this.d.h().c.top >= this.f.f) {
                float length;
                float f;
                if (this.f.m && this.n == null) {
                    this.n = d.a();
                    g b = d.b(this.e);
                    if (!(b == null || b.f().equals(this.e.n()))) {
                        this.n = b.e();
                    }
                    if (this.f.k) {
                        this.n = DkUtils.chs2chtText(this.n);
                    }
                }
                if (this.f.l) {
                    length = (float) d.a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f.m || TextUtils.isEmpty(this.n) || (this.f.l && this.n == d.a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.n.length();
                }
                int width = getBounds().width() - (p().c.left + p().c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    a(canvas, d.a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) > 0) {
                    String str = this.n;
                    int i2 = (!this.f.n || this.f.l) ? 5 : 3;
                    a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.d.h().c.bottom < this.f.f) {
                return i;
            }
            if (this.o == null && this.m >= 0) {
                this.o = String.format("%getTriangleEdge / %getTriangleEdge", new Object[]{Long.valueOf(this.m + 1), Long.valueOf(this.d.b())});
            }
            if (TextUtils.isEmpty(this.o)) {
                return i;
            }
            int i3;
            String str2 = this.o;
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
            this.m = c(this.i);
        }
        a(new an(this));
    }

    public void a(as asVar) {
        if (!c && (this.d == null || !this.d.a)) {
            throw new AssertionError();
        } else if (c || (this.e != null && this.e.b())) {
            this.i = asVar;
            DktPage Q = Q();
            if (this.d.b() >= 0) {
                this.m = c(this.i);
            } else {
                this.d.a((bd) this);
            }
            if (this.i.d() || this.e.f()) {
                this.n = "";
            } else {
                if (this.d.h().e) {
                    this.l = Math.max(this.l, (int) Q.getPageHeight());
                }
                if (!this.e.f()) {
                    if (!c && this.q != null) {
                        throw new AssertionError();
                    } else if (this.q == null) {
                        this.q = P();
                    }
                }
            }
            this.j = true;
            a(new ao(this));
            this.d.c(this);
        } else {
            throw new AssertionError();
        }
    }

    public void b(as asVar) {
        if (c || this.i.d()) {
            this.j = false;
            a(new ap(this));
            this.d.c(this);
            return;
        }
        throw new AssertionError();
    }

    public int getIntrinsicHeight() {
        return this.l;
    }

    private void d() {
        if (this.j) {
            R();
        }
    }

    private Rect e() {
        Rect rect = new Rect(0, 0, this.d.h().a, this.l);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    private long c(as asVar) {
        if (c || (asVar != null && this.d.b() >= 0)) {
            return this.d.b(asVar.a);
        }
        throw new AssertionError();
    }

    private ap P() {
        Rect e = e();
        ap a = this.g.a(this.d, this.e, e, this.f, 1.0f, L());
        if (a != null) {
            this.g.a(a);
            if (a.a(e, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        Q();
        a = this.g.a(this.d, this.e, e, this.f, 1.0f, L(), new aq(this));
        this.g.a(a);
        return a;
    }

    private void a(Bitmap bitmap, Bitmap bitmap2) {
        if (!c && bitmap == null) {
            throw new AssertionError();
        } else if (!c && this.f == null) {
            throw new AssertionError();
        } else if (c || this.d.a) {
            if (bitmap2 != null) {
                synchronized (bitmap2) {
                    if (!bitmap2.isRecycled()) {
                        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                    }
                }
            } else {
                bitmap.eraseColor(0);
            }
            aa.c().a().setChsToCht(this.f.k);
            this.d.e().h().setTextColor(new DkArgbColor(this.f.c));
            DktPage Q = Q();
            DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
            dkFlowRenderOption.mWidth = bitmap.getWidth();
            dkFlowRenderOption.mHeight = bitmap.getHeight();
            dkFlowRenderOption.mBitmap = bitmap;
            dkFlowRenderOption.mNightColor = new DkArgbColor(this.f.d);
            dkFlowRenderOption.mOptimizeForNight = this.f.i;
            dkFlowRenderOption.mOptimizeForDarkBackground = this.f.j;
            Q.render(dkFlowRenderOption);
            if (!(Q.checkRenderStatus() == 0 || this.h == null)) {
                this.h.b(null, this);
            }
            R();
        } else {
            throw new AssertionError();
        }
    }

    private DktPage Q() {
        return this.d.e().h().acquirePage(this.e.n().g(), ab.a(this.d.h()));
    }

    private void R() {
        this.d.e().h().releasePage(this.e.n().g(), ab.a(this.d.h()));
    }
}
