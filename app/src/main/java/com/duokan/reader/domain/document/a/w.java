package com.duokan.reader.domain.document.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.DkRenderInfo;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.pdflib.DkpPage;
import com.duokan.kernel.pdflib.DkpPageEx;
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

public class w extends TaskHandler implements ae, ba, bd {
    static final /* synthetic */ boolean c = (!w.class.desiredAssertionStatus());
    private final ah d;
    private final v e;
    private u f = null;
    private final al g;
    private final at h;
    private af i = null;
    private boolean j = false;
    private boolean k = false;
    private long l = -1;
    private String m = null;
    private String n = null;
    private ap o = null;
    private ap p = null;

    public /* synthetic */ bb a(Point point, Point point2) {
        return b(point, point2);
    }

    public /* synthetic */ bb b(Point point) {
        return h(point);
    }

    public /* synthetic */ d[] n() {
        return c();
    }

    public w(ah ahVar, v vVar, u uVar, al alVar, at atVar) {
        if (!c && (ahVar == null || uVar == null)) {
            throw new AssertionError();
        } else if (c || (vVar != null && vVar.a())) {
            mHandler.c().b(N());
            this.d = ahVar;
            this.d.submitFuture((Object) TaskHandler.getThread());
            this.d.submitFuture((Object) this);
            this.e = new v(this.d, vVar, 0);
            this.f = uVar;
            this.g = alVar;
            this.h = atVar;
            this.i = this.d.submitScheduledFuture(this.e, this);
        } else {
            throw new AssertionError();
        }
    }

    public boolean a() {
        mHandler.c().b(N());
        return false;
    }

    public boolean b() {
        mHandler.c().b(N());
        return false;
    }

    public int getIntrinsicWidth() {
        if (U()) {
            return this.d.future(this.e);
        }
        return this.d.g().a;
    }

    public int getIntrinsicHeight() {
        if (U()) {
            return this.d.submitFuture(this.e);
        }
        return this.d.g().b;
    }

    public long j() {
        mHandler.c().b(N());
        return this.l;
    }

    public k p() {
        mHandler.c().b(N());
        return this.d.g();
    }

    public m q() {
        mHandler.c().b(N());
        return this.f;
    }

    public void a(m mVar) {
        mHandler.c().b(N());
        O();
        this.f = (u) mVar;
        invalidateSelf();
    }

    public boolean k() {
        mHandler.c().b(N());
        return false;
    }

    public ak l() {
        mHandler.c().b(N());
        return this.e;
    }

    public bb m() {
        if (E()) {
            return new ag(this.e.j(), this.e.k());
        }
        return new ag();
    }

    public WebLog[] c() {
        int i = 0;
        mHandler.c().b(N());
        if (!E()) {
            return new WebLog[0];
        }
        DkFlowPosition[] charPositions;
        if (this.d.g().c()) {
            charPositions = Q().getCharPositions();
            R();
        } else {
            charPositions = S().getCharPositions();
            T();
        }
        WebLog[] aVarArr = new WebLog[charPositions.length];
        while (i < aVarArr.length) {
            aVarArr[i] = p.a(charPositions[i]);
            i++;
        }
        return aVarArr;
    }

    public CharSequence o() {
        mHandler.c().b(N());
        if (!E()) {
            return "";
        }
        if (this.d.g().c()) {
            CharSequence chars = Q().getChars();
            R();
            return chars;
        }
        chars = S().getChars();
        T();
        return chars;
    }

    public int r() {
        mHandler.c().b(N());
        return 0;
    }

    public int s() {
        mHandler.c().b(N());
        return 0;
    }

    public int t() {
        mHandler.c().b(N());
        return 0;
    }

    public int u() {
        mHandler.c().b(N());
        return 0;
    }

    public int v() {
        mHandler.c().b(N());
        return 0;
    }

    public int w() {
        mHandler.c().b(N());
        return 0;
    }

    public int x() {
        mHandler.c().b(N());
        return 0;
    }

    public int y() {
        mHandler.c().b(N());
        return 0;
    }

    public Rect z() {
        mHandler.c().b(N());
        return new Rect();
    }

    public Rect A() {
        mHandler.c().b(N());
        return new Rect();
    }

    public int B() {
        mHandler.c().b(N());
        if (c || G()) {
            return 0;
        }
        throw new AssertionError();
    }

    public Rect a(au auVar) {
        mHandler.c().b(N());
        if (c || G()) {
            return new Rect();
        }
        throw new AssertionError();
    }

    public boolean E() {
        mHandler.c().b(N());
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
        mHandler.c().b(N());
        ah.submitFuture(new x(this, runnable, runnable2));
    }

    public boolean F() {
        mHandler.c().b(N());
        return this.i.c();
    }

    public boolean G() {
        mHandler.c().b(N());
        return !this.i.c() && this.j;
    }

    public void H() {
        mHandler.c().b(N());
        if (!this.i.c()) {
            this.i.f();
            if (this.k) {
                d();
                this.j = false;
            }
            O();
            this.d.submitFuture((bd) this);
            this.d.c(TaskHandler.getThread());
        }
    }

    public void a(boolean z) {
        mHandler.c().b(N());
        if (this.o != null) {
            if (z) {
                this.g.a(this.o, true);
            } else {
                this.g.a(this.o);
            }
            this.o = null;
        }
    }

    public ae a(Point point) {
        mHandler.c().b(N());
        return null;
    }

    public ag b(Point point, Point point2) {
        mHandler.c().b(N());
        if (!G() || this.e.f()) {
            return new ag();
        }
        DkPos i = i(point);
        DkPos i2 = i(point2);
        if (this.d.g().c()) {
            DkFlowPosition[] selectionRange = Q().getSelectionRange(i, i2);
            ag a = p.a(selectionRange[0], selectionRange[1]);
            R();
            return a;
        }
        selectionRange = S().getSelectionRange(i, i2);
        mHandler = p.a(selectionRange[0], selectionRange[1]);
        T();
        return mHandler;
    }

    public ag h(Point point) {
        mHandler.c().b(N());
        if (!G() || this.e.f()) {
            return new ag();
        }
        ag a;
        DkPos i = i(point);
        DkFlowPosition[] hitTestTextRange;
        if (this.d.g().c()) {
            hitTestTextRange = Q().hitTestTextRange(i);
            a = p.a(hitTestTextRange[0], hitTestTextRange[1]);
            R();
        } else {
            hitTestTextRange = S().hitTestTextRange(i);
            a = p.a(hitTestTextRange[0], hitTestTextRange[1]);
            T();
        }
        return (ag) a.b(m());
    }

    public int c(Point point) {
        mHandler.c().b(N());
        return -1;
    }

    public int a(Point point, int i) {
        mHandler.c().b(N());
        return -1;
    }

    public int d(Point point) {
        mHandler.c().b(N());
        return -1;
    }

    public int e(Point point) {
        mHandler.c().b(N());
        return -1;
    }

    public int a(bb bbVar) {
        mHandler.c().b(N());
        return -1;
    }

    public int f(Point point) {
        mHandler.c().b(N());
        return -1;
    }

    public int g(Point point) {
        return -1;
    }

    public Rect b(Rect rect) {
        mHandler.c().b(N());
        if (!E()) {
            return new Rect();
        }
        DkBox e = e(rect);
        rect.left = (int) e.mX0;
        rect.top = (int) e.mY0;
        rect.right = (int) e.mX1;
        rect.bottom = (int) e.mY1;
        return rect;
    }

    public Rect c(Rect rect) {
        mHandler.c().b(N());
        if (!E()) {
            return new Rect();
        }
        Rect a = a(new DkBox((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
        rect.left = a.left;
        rect.top = a.top;
        rect.right = a.right;
        rect.bottom = a.bottom;
        return rect;
    }

    public af c(int i) {
        mHandler.c().b(N());
        return null;
    }

    public aw d(int i) {
        mHandler.c().b(N());
        return null;
    }

    public ab e(int i) {
        mHandler.c().b(N());
        return null;
    }

    public com.duokan.reader.domain.document.ah f(int i) {
        mHandler.c().b(N());
        return null;
    }

    public Rect g(int i) {
        mHandler.c().b(N());
        return new Rect();
    }

    public Rect h(int i) {
        mHandler.c().b(N());
        return new Rect();
    }

    public Rect i(int i) {
        mHandler.c().b(N());
        return new Rect();
    }

    public Rect j(int i) {
        mHandler.c().b(N());
        return new Rect();
    }

    public String I() {
        return this.m == null ? "" : this.m;
    }

    public String J() {
        mHandler.c().b(N());
        return b(m());
    }

    public String b(bb bbVar) {
        mHandler.c().b(N());
        if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!E() || this.e.f()) {
            return "";
        } else {
            String str = "";
            ag agVar = (ag) bbVar.b(m());
            if (U()) {
                str = Q().getTextContentOfRange(agVar.j().a(this.d.e().h()), agVar.k().a(this.d.e().h()));
                R();
                return str;
            }
            str = S().getTextContentOfRange(agVar.j().a(this.d.e().i()), agVar.k().a(this.d.e().i()));
            T();
            return str;
        }
    }

    public String K() {
        mHandler.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.f.k) {
            return DkUtils.chs2chtText(J());
        } else {
            return J();
        }
    }

    public String c(bb bbVar) {
        mHandler.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.f.k) {
            return DkUtils.chs2chtText(b(bbVar));
        } else {
            return b(bbVar);
        }
    }

    public Rect d(bb bbVar) {
        mHandler.c().b(N());
        Rect rect = new Rect();
        for (Rect union : e(bbVar)) {
            rect.union(union);
        }
        return rect;
    }

    public Rect[] e(bb bbVar) {
        int i = 0;
        mHandler.c().b(N());
        if (!E()) {
            return new Rect[0];
        }
        ag agVar = (ag) bbVar.b(m());
        if (agVar.f()) {
            return new Rect[0];
        }
        DkBox[] textRects;
        if (U()) {
            textRects = Q().getTextRects(agVar.j().a(this.d.e().h()), agVar.k().a(this.d.e().h()));
            R();
        } else {
            textRects = S().getTextRects(agVar.j().a(this.d.e().i()), agVar.k().a(this.d.e().i()));
            T();
        }
        Rect[] rectArr = new Rect[textRects.length];
        while (i < rectArr.length) {
            rectArr[i] = a(textRects[i]);
            i++;
        }
        a(rectArr);
        return rectArr;
    }

    public Point f(bb bbVar) {
        mHandler.c().b(N());
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
        mHandler.c().b(N());
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
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect l(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect m(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public aj n(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect p(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect o(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public ad q(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect r(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public ax s(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect t(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public Rect u(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return null;
        }
        throw new AssertionError();
    }

    public int v(int i) {
        mHandler.c().b(N());
        if (c || G()) {
            return -1;
        }
        throw new AssertionError();
    }

    protected void O() {
        if (this.o != null) {
            this.g.b(this.o);
            this.o = null;
        }
        if (this.p != null) {
            this.g.b(this.p);
            this.p = null;
        }
    }

    protected int b(Canvas canvas, long j) {
        if (this.k) {
            int i;
            float e = e();
            Rect P = P();
            if (M()) {
                O();
            }
            if (this.o != null && (this.o.b() != this.f || this.o.d() != L() || this.o.f() || this.o.a(P, e) == 0)) {
                this.g.b(this.o);
                this.o = null;
            }
            if (this.p != null && (this.p.b() != this.f || this.p.d() != L() || this.p.f() || this.p.a(P, e) == 0)) {
                this.g.b(this.p);
                this.p = null;
            }
            if (this.o == null) {
                this.o = this.g.a(this.d, this.e, P, this.f, e, L());
            } else {
                int a = this.o.a(P, e);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.g.a(this.d, this.e, P, this.f, e, L(), a + 1);
                    if (a2 != null) {
                        if (!a2.e()) {
                            this.g.a(a2);
                        } else if (c || !a2.f()) {
                            this.g.b(this.o);
                            this.o = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.o != null) {
                int i2;
                float c = e / this.o.c();
                float f = ((float) this.o.a().left) * c;
                float f2 = ((float) this.o.a().top) * c;
                if (U()) {
                    canvas.drawColor(-1);
                }
                obj = this.o.a(P, e) == Integer.MAX_VALUE ? 1 : null;
                if (!this.o.a(canvas, f, f2, c)) {
                    a(canvas);
                    i2 = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                i = i2;
            } else {
                a(canvas);
                obj = null;
                i = 2;
            }
            if (this.p == this.o) {
                this.p = null;
            }
            if (this.p != null && this.p.e()) {
                this.p = null;
            }
            if (this.p == null && r0 == null) {
                this.p = a(P, e);
            }
            if (k() || this.d.d()) {
                return i;
            }
            this.mHandler.setTextSize((float) this.f.f);
            h d = this.d.e().d();
            if (!U() && this.d.g().c.top >= this.f.f) {
                float length;
                float f3;
                if (this.f.m && this.m == null) {
                    this.m = d.a();
                    g b = d.b(this.e);
                    if (!(b == null || b.f().equals(this.e.j()))) {
                        this.m = b.e();
                    }
                    if (this.f.k) {
                        this.m = DkUtils.chs2chtText(this.m);
                    }
                }
                if (this.f.l) {
                    length = (float) d.a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f.m || TextUtils.isEmpty(this.m) || (this.f.l && this.m == d.a())) {
                    f3 = 0.0f;
                } else {
                    f3 = (float) this.m.length();
                }
                int width = getBounds().width() - (p().c.left + p().c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    a(canvas, d.a(), 3, Math.round((((float) width) * length) / (length + f3)), this.mHandler);
                }
                if (Float.compare(f3, 1.0f) > 0) {
                    String str = this.m;
                    int i3 = (!this.f.n || this.f.l) ? 5 : 3;
                    a(canvas, str, i3, Math.round((((float) width) * f3) / (length + f3)), this.mHandler);
                }
            }
            if (U() || this.d.g().c.bottom < this.f.f) {
                return i;
            }
            if (this.n == null && this.l >= 0) {
                this.n = String.format("%getTriangleEdge / %getTriangleEdge", new Object[]{Long.valueOf(this.l + 1), Long.valueOf(this.d.submitFuture())});
            }
            if (TextUtils.isEmpty(this.n)) {
                return i;
            }
            int i4;
            String str2 = this.n;
            if (this.f.n) {
                i4 = 5;
            } else {
                i4 = 1;
            }
            a(canvas, str2, i4, this.mHandler);
            return i;
        }
        a(canvas);
        return 2;
    }

    protected void d(Rect rect) {
        if (!U()) {
            return;
        }
        if (rect.isEmpty()) {
            O();
        } else if (G() && this.o == null && this.p == null) {
            this.p = a(P(), e());
        }
    }

    public void a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.i != null) {
            this.l = c(this.i);
        }
        postTask(new z(this));
    }

    public void a(af afVar) {
        if (!c && (this.d == null || !this.d.a)) {
            throw new AssertionError();
        } else if (c || (this.e != null && this.e.b())) {
            this.i = afVar;
            if (U()) {
                Q();
            } else {
                S();
            }
            if (this.d.submitFuture() >= 0) {
                this.l = c(this.i);
            } else {
                this.d.future((bd) this);
            }
            if (this.i.c() || this.e.f()) {
                this.m = "";
            } else if (!this.e.f()) {
                if (!c && this.p != null) {
                    throw new AssertionError();
                } else if (!U() && this.p == null) {
                    this.p = a(P(), e());
                }
            }
            this.j = true;
            postTask(new aa(this));
            this.d.c(this);
        } else {
            throw new AssertionError();
        }
    }

    public void b(af afVar) {
        if (c || this.i.c()) {
            this.j = false;
            a(new ab(this));
            this.d.c(this);
            return;
        }
        throw new AssertionError();
    }

    private void d() {
        if (!this.j) {
            return;
        }
        if (U()) {
            R();
        } else {
            T();
        }
    }

    private long c(af afVar) {
        if (c || (afVar != null && this.d.submitFuture() >= 0)) {
            return this.d.scheduledFuture(afVar.a, afVar.b, afVar.c);
        }
        throw new AssertionError();
    }

    private void a(Rect[] rectArr) {
        Arrays.sort(rectArr, new ac(this));
    }

    private ap a(Rect rect, float f) {
        ap a = this.g.a(this.d, this.e, rect, this.f, f, L());
        if (a != null) {
            this.g.a(a);
            if (a.a(rect, f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        if (U()) {
            Q();
        } else {
            S();
        }
        a = this.g.a(this.d, this.e, rect, this.f, f, L(), new ad(this, rect, f));
        this.g.a(a);
        return a;
    }

    private void a(Bitmap bitmap, Bitmap bitmap2, Rect rect, float f) {
        if (bitmap2 != null) {
            synchronized (bitmap2) {
                if (!bitmap2.isRecycled()) {
                    new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                }
            }
        } else {
            bitmap.eraseColor(-1);
        }
        if (U()) {
            long Y = Y();
            DkRenderInfo dkRenderInfo = new DkRenderInfo();
            dkRenderInfo.mBitmap = bitmap;
            dkRenderInfo.mPageRect = e(rect);
            dkRenderInfo.mPageNum = Y;
            dkRenderInfo.mScale = f;
            this.d.e().h().renderFixedPage(dkRenderInfo);
            return;
        }
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        dkFlowRenderOption.mWidth = bitmap.getWidth();
        dkFlowRenderOption.mHeight = bitmap.getHeight();
        dkFlowRenderOption.mBitmap = bitmap;
        dkFlowRenderOption.mNightColor = new DkArgbColor(this.f.d);
        dkFlowRenderOption.mOptimizeForNight = this.f.i;
        dkFlowRenderOption.mOptimizeForDarkBackground = this.f.j;
        if (this.f.c == 0) {
            dkFlowRenderOption.mTextColor = null;
        } else {
            dkFlowRenderOption.mTextColor = new DkArgbColor(this.f.c);
        }
        this.d.e().i().renderFlowPage(dkFlowRenderOption, p.a(this.e.j()), p.a(this.d.g()));
    }

    private float e() {
        if (!U()) {
            return 1.0f;
        }
        long Y = Y() - 1;
        RectF[] rectFArr = this.d.g().m;
        if (rectFArr.length < 1) {
            return ((float) getBounds().width()) / ((float) this.d.future(this.e));
        }
        RectF rectF = rectFArr[((int) Y) % rectFArr.length];
        return ((float) getBounds().width()) / (((1.0f - rectF.left) - rectF.right) * ((float) this.d.future(this.e)));
    }

    private Rect P() {
        Rect rect;
        if (U()) {
            int width = getBounds().width();
            int height = getBounds().height();
            Rect h = h();
            if (h.isEmpty()) {
                return new Rect();
            }
            Rect rect2 = new Rect(0, 0, width, height);
            rect = new Rect(h);
            int f = (int) (((double) f()) * 1.25d);
            while (rect.width() < width && rect.width() < f) {
                int width2 = f - rect.width();
                if (rect.left == rect2.left) {
                    rect.right = width2 + rect.right;
                } else if (rect.right == rect2.right) {
                    rect.left -= width2;
                } else {
                    rect.inset((-(width2 + 1)) / 2, 0);
                }
                rect.intersect(rect2);
            }
            width = ((g() * f()) * 2) / rect.width();
            while (rect.height() < height && rect.height() < width) {
                f = width - rect.height();
                if (rect.top == rect2.top) {
                    rect.bottom = f + rect.bottom;
                } else if (rect.bottom == rect2.bottom) {
                    rect.top -= f;
                } else {
                    rect.inset(0, (-(f + 1)) / 2);
                }
                rect.intersect(rect2);
            }
        } else {
            rect = new Rect(0, 0, this.d.g().a, this.d.g().b);
        }
        if (rect.width() % 2 == 0) {
            return rect;
        }
        rect.right++;
        return rect;
    }

    private DkpPage Q() {
        return this.d.e().h().acquireFixedPage(Y());
    }

    private void R() {
        this.d.e().h().releaseFixedPage(Y());
    }

    private DkpPageEx S() {
        return this.d.e().i().acquireFlowPage(p.a(this.e.j()), p.a(this.d.g()));
    }

    private void T() {
        this.d.e().i().releaseFlowPage(p.a(this.e.j()), p.a(this.d.g()));
    }

    private boolean U() {
        return this.d.g().c();
    }

    private DkBox e(Rect rect) {
        float e = e();
        RectF X = X();
        return new DkBox((float) Math.round((((float) rect.left) / e) + (X.left * ((float) V()))), (float) Math.round((((float) rect.top) / e) + (X.top * ((float) W()))), (float) Math.round((((float) rect.right) / e) + (X.left * ((float) V()))), (float) Math.round((((float) rect.bottom) / e) + (X.top * ((float) W()))));
    }

    private DkPos i(Point point) {
        float e = e();
        RectF X = X();
        return new DkPos((float) Math.round((((float) point.x) / e) + (X.left * ((float) V()))), (float) Math.round((((float) point.y) / e) + (X.top * ((float) W()))));
    }

    private Rect a(DkBox dkBox) {
        float e = e();
        RectF X = X();
        RectF toRectF = dkBox.toRectF();
        toRectF.offset((-X.left) * ((float) V()), (-X.top) * ((float) W()));
        toRectF.left *= e;
        toRectF.top *= e;
        toRectF.right *= e;
        toRectF.bottom = e * toRectF.bottom;
        Rect rect = new Rect();
        toRectF.round(rect);
        return rect;
    }

    private int V() {
        return this.d.future(this.e);
    }

    private int W() {
        return this.d.submitFuture(this.e);
    }

    private RectF X() {
        if (!U()) {
            return new RectF();
        }
        long Y = Y() - 1;
        RectF[] rectFArr = this.d.g().m;
        return rectFArr.length < 1 ? new RectF() : rectFArr[((int) Y) % rectFArr.length];
    }

    private long Y() {
        return p.a(this.d.e().h(), this.e);
    }
}
