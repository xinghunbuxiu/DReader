package com.duokan.reader.domain.document.sbk;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState;
import com.duokan.reader.domain.document.y;

import java.lang.Thread.State;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class f extends n implements at {
    static final /* synthetic */ boolean i = (!f.class.desiredAssertionStatus());
    private final n j;
    private c k = null;
    private final LinkedList l = new LinkedList();
    private final Semaphore m = new Semaphore(0);
    private final Semaphore n = new Semaphore(0);
    private final p o;
    private boolean p = false;
    private long q = 0;
    private final Thread r;
    private final Thread s;
    private w t;
    private final ExecutorService u = Executors.newSingleThreadExecutor();

    public /* synthetic */ ak a(long j) {
        return e(j);
    }

    public /* synthetic */ ak f(ak akVar) {
        return k(akVar);
    }

    public /* synthetic */ ak g(ak akVar) {
        return l(akVar);
    }

    public /* synthetic */ h h() {
        return D();
    }

    public /* synthetic */ m l() {
        return E();
    }

    public /* synthetic */ av q() {
        return F();
    }

    public f(n nVar) {
        a.c().b(A());
        this.j = nVar;
        this.o = new p();
        this.t = new w();
        this.r = new Thread(new g(this));
        this.s = new Thread(new h(this));
    }

    public q B() {
        a.c().b(A());
        if (!p()) {
            return null;
        }
        l c = this.k.c();
        return c instanceof s ? ((s) c).b : null;
    }

    public int C() {
        a.c().b(A());
        if (p()) {
            return this.k.h();
        }
        return 0;
    }

    public String b(long j) {
        a.c().b(A());
        if (!p()) {
            return "";
        }
        a a = this.k.a(j);
        return a != null ? a.c() : "";
    }

    public long c(long j) {
        a.c().b(A());
        if (C() <= 0) {
            return 0;
        }
        long b = b(I(), j);
        if (b < 0) {
            return 0;
        }
        return b;
    }

    public boolean d(long j) {
        a.c().b(A());
        if (!p()) {
            return true;
        }
        a a = this.k.a(j);
        if (a == null) {
            return false;
        }
        return a.a();
    }

    public static b a(long j, long j2, long j3) {
        return new b(j, j2, j3);
    }

    public void a(n nVar, as asVar) {
        a(asVar);
    }

    public void b(n nVar, as asVar) {
        b(asVar);
    }

    public WritingDirection c() {
        a.c().b(A());
        return WritingDirection.TOP_TO_BOTTOM;
    }

    public FootnoteStyle d() {
        a.c().b(A());
        return FootnoteStyle.NONE;
    }

    public long e() {
        long b;
        a.c().b(A());
        synchronized (this) {
            SbkTypesettingContext sbkTypesettingContext = (SbkTypesettingContext) this.l.getLast();
            if (i || sbkTypesettingContext != null) {
                b = sbkTypesettingContext.b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    public int f() {
        a.c().b(A());
        if (p()) {
            return -1;
        }
        return 0;
    }

    public float g() {
        a.c().b(A());
        if (!p()) {
            return 0.0f;
        }
        SbkTypesettingContext I = I();
        c e = I.e();
        if (e != null) {
            return (((float) I.k) / ((float) e.h())) * 100.0f;
        }
        return 0.0f;
    }

    public boolean b() {
        a.c().b(A());
        return this.a;
    }

    public e D() {
        a.c().b(A());
        if (p()) {
            return (e) this.k.d();
        }
        return null;
    }

    public boolean i() {
        boolean z = true;
        a.c().b(A());
        synchronized (this) {
            if (this.l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean j() {
        a.c().b(A());
        return I().c();
    }

    public k k() {
        k g;
        a.c().b(A());
        synchronized (this) {
            SbkTypesettingContext sbkTypesettingContext = (SbkTypesettingContext) this.l.getLast();
            if (i || sbkTypesettingContext != null) {
                g = sbkTypesettingContext.g();
            } else {
                throw new AssertionError();
            }
        }
        return g;
    }

    public void a(k kVar) {
        a.c().b(A());
        if (i || kVar != null) {
            synchronized (this) {
                SbkTypesettingContext I = I();
                if (!I.g().equals(kVar)) {
                    this.l.addLast(new m(this, I.f(), new p((p) kVar), this.m));
                }
            }
            this.m.release();
            return;
        }
        throw new AssertionError();
    }

    public w E() {
        a.c().b(A());
        return this.t;
    }

    public void a(m mVar) {
        a.c().b(A());
        if (i || mVar != null) {
            this.t = (w) mVar;
            return;
        }
        throw new AssertionError();
    }

    public com.duokan.reader.domain.document.f m() {
        a.c().b(A());
        if (p()) {
            return this.k.e();
        }
        return null;
    }

    public void a(l lVar) {
        a.c().a(this.a);
        if (!this.a) {
            if (this.r.getState() == State.NEW) {
                this.l.addLast(new m(this, (s) lVar, this.o, this.m));
                this.r.start();
                return;
            }
            synchronized (this) {
                this.l.addLast(new m(this, (s) lVar, I().g(), this.m));
            }
            this.m.release();
        }
    }

    public float j(ak akVar) {
        a.c().b(A());
        if (!d((Document_a) akVar) || !akVar.e()) {
            return 0.0f;
        }
        c cVar = this.k;
        b bVar = (b) akVar.g();
        long g = bVar.g();
        long h = (long) cVar.h();
        float f = 1.0f / ((float) h);
        float max = ((float) Math.max(0, g - 1)) / ((float) h);
        a a = cVar.a(g);
        g = (a == null || a.a()) ? 1 : (long) a.b();
        return (Math.max(0.0f, Math.min(g == 0 ? 1.0f : ((float) (bVar.h() + 1)) / ((float) g), 1.0f)) * f) + max;
    }

    public long b(ak akVar) {
        a.c().b(A());
        if (!d((Document_a) akVar) || !akVar.e()) {
            return -1;
        }
        b bVar = (b) akVar.g();
        SbkTypesettingContext I = I();
        if (i || I != null) {
            return I.a(bVar.g(), bVar.h(), bVar.i());
        }
        throw new AssertionError();
    }

    public long a(av avVar) {
        b bVar = (b) avVar;
        SbkTypesettingContext I = I();
        if (i || I != null) {
            return I.a(bVar.g(), bVar.h(), bVar.i());
        }
        throw new AssertionError();
    }

    public long c(ak akVar) {
        a.c().b(A());
        return -1;
    }

    public long b(av avVar) {
        a.c().b(A());
        return -1;
    }

    public int b(int i) {
        a.c().b(A());
        return -1;
    }

    public int c(int i) {
        a.c().b(A());
        return -1;
    }

    public b F() {
        a.c().b(A());
        return a(0, 0, 0);
    }

    public ak d(ak akVar) {
        a.c().b(A());
        return null;
    }

    public ak r() {
        a.c().b(A());
        return c(a((long) (f() - 1), 0, 0));
    }

    public Document_a c(Document_a aVar) {
        a.c().b(A());
        return aVar;
    }

    public bb a(d dVar, d dVar2) {
        a.c().b(A());
        return new ah((b) dVar, (b) dVar2);
    }

    public bb s() {
        a.c().b(A());
        return new ah();
    }

    public x e(long j) {
        a.c().b(A());
        return new x(I(), 0, 0, 0, j);
    }

    public ak c(av avVar) {
        a.c().b(A());
        SbkTypesettingContext I = I();
        b bVar = (b) avVar;
        if (i || bVar != null) {
            return new x(I, bVar.g(), bVar.h(), bVar.i(), 0);
        }
        throw new AssertionError();
    }

    public ak e(ak akVar) {
        a.c().b(A());
        if (!i && (akVar == null || !akVar.a())) {
            throw new AssertionError();
        } else if (akVar instanceof x) {
            return a((x) akVar, 0);
        } else {
            return null;
        }
    }

    public t k(ak akVar) {
        a.c().b(A());
        return (t) a(akVar, 1);
    }

    public t l(ak akVar) {
        a.c().b(A());
        return (t) a(akVar, -1);
    }

    public ak a(ak akVar, int i) {
        a.c().b(A());
        if (i || (akVar != null && akVar.a())) {
            SbkTypesettingContext I = I();
            if (!(akVar instanceof x)) {
                return null;
            }
            Document_a aVar = (x) akVar;
            SbkTypesettingContext l = aVar.l();
            if (aVar.b() || l == I || d(aVar)) {
                return new x(I, aVar, (long) i);
            }
            return null;
        }
        throw new AssertionError();
    }

    public boolean h(ak akVar) {
        a.c().b(A());
        if (!(akVar instanceof x)) {
            return false;
        }
        Document_a aVar = (x) akVar;
        if (aVar.b()) {
            if (aVar.j().g() == 0 && a((x) aVar) == 0) {
                return true;
            }
            return false;
        } else if (d(aVar) && aVar.e() && h(aVar)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean i(ak akVar) {
        a.c().b(A());
        if (!(akVar instanceof x)) {
            return false;
        }
        Document_a aVar = (x) akVar;
        if (aVar.b()) {
            long g = aVar.j().g();
            if (g == ((long) (C() - 1)) && a((x) aVar) == aVar.l().b(g) - 1) {
                return true;
            }
            return false;
        } else if (d(aVar) && aVar.e() && i(aVar)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean d(Document_a aVar) {
        a.c().b(A());
        if (!i && aVar == null) {
            throw new AssertionError();
        } else if (!i && !aVar.a()) {
            throw new AssertionError();
        } else if (!aVar.a()) {
            return false;
        } else {
            if (aVar.b()) {
                return true;
            }
            if (aVar instanceof x) {
                x xVar = (x) aVar;
                SbkTypesettingContext l = xVar.l();
                synchronized (this) {
                    if (l.a) {
                        l.a(xVar, null);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public as a(ak akVar, m mVar) {
        a.c().b(A());
        if (i || akVar != null) {
            w E = mVar == null ? E() : (w) mVar;
            d((Document_a) akVar);
            SbkTypesettingContext I = I();
            if (akVar instanceof x) {
                return new y(I, (x) akVar, E, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    public Bitmap a(String str, Rect rect, int i, int i2) {
        a.c().b(A());
        return null;
    }

    public aa a(av avVar, String str, int i) {
        a.c().b(A());
        return new aa(str);
    }

    public aa a(aa aaVar, int i) {
        a.c().b(A());
        return new aa(aaVar.a);
    }

    public y a(String str) {
        return null;
    }

    protected void t() {
        synchronized (this) {
            SbkTypesettingContext mVar = new m(this, I().f(), new p(), this.m);
            mVar.c = true;
            this.l.add(mVar);
        }
        this.m.release();
    }

    private String a(SbkTypesettingContext sbkTypesettingContext) {
        q qVar = sbkTypesettingContext.f().b;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < qVar.a(); i++) {
            a a = qVar.a(i);
            stringBuilder.append(a.a() ? "" : a.e()).append(';');
        }
        return o.b(stringBuilder.toString(), "md5");
    }

    private void G() {
        while (true) {
            Object obj;
            try {
                if (this.p) {
                    this.n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                m mVar = (m) this.l.getFirst();
                if (this.l.size() > 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (mVar.b) {
                ai aiVar;
                mVar.e();
                synchronized (mVar) {
                    Iterator it = mVar.l.iterator();
                    while (it.hasNext()) {
                        ai aiVar2 = (ai) it.next();
                        if (!i && aiVar2 == null) {
                            throw new AssertionError();
                        } else if (!i && aiVar2.c == null) {
                            throw new AssertionError();
                        } else if (!aiVar2.c.a()) {
                            aiVar = null;
                            break;
                        } else if (aiVar2.c.c()) {
                            it.remove();
                            if (aiVar2.b != null) {
                                aiVar2.b.b(aiVar2.c);
                            }
                        } else if (aiVar2.c.b()) {
                            it.remove();
                            aiVar = aiVar2;
                            break;
                        }
                    }
                    aiVar = null;
                    Object obj2;
                    if (mVar.l.size() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                }
                if (aiVar != null) {
                    if (aiVar.a.c()) {
                        aiVar.a.a(a(aiVar.c.a, aiVar.c.b, aiVar.c.c), a(aiVar.c.d, aiVar.c.e, aiVar.c.f));
                    }
                    if (aiVar.b != null) {
                        aiVar.b.a(aiVar.c);
                    }
                }
                if (obj == 1 && r9 == null && aiVar == null && mVar.a()) {
                    synchronized (this) {
                        if (mVar.h() == null) {
                            mVar.a = false;
                            this.l.removeFirst();
                            this.n.drainPermits();
                            this.m.release();
                            if (((SbkTypesettingContext) this.l.getFirst()).c) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void H() {
        /*
        r14 = this;
        r8 = 0;
        r3 = 0;
        r7 = 1;
        r5 = r3;
    L_0x0004:
        monitor-enter(r14);
        r2 = r14.OnDismissListener;	 Catch:{ all -> 0x0037 }
        r2 = r2.size();	 Catch:{ all -> 0x0037 }
        if (r2 <= r7) goto L_0x0024;
    L_0x000d:
        r6 = r7;
    L_0x000e:
        r2 = r14.OnDismissListener;	 Catch:{ all -> 0x0037 }
        r2 = r2.getFirst();	 Catch:{ all -> 0x0037 }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.sbk.BaseActivity) r0;	 Catch:{ all -> 0x0037 }
        r4 = r0;
        r2 = r4.showAnimation;	 Catch:{ all -> 0x0037 }
        if (r2 == 0) goto L_0x0026;
    L_0x001c:
        monitor-exit(r14);	 Catch:{ all -> 0x0037 }
        r14.J();
        r14.MyContextWrapper();
    L_0x0023:
        return;
    L_0x0024:
        r6 = r8;
        goto L_0x000e;
    L_0x0026:
        monitor-exit(r14);	 Catch:{ all -> 0x0037 }
        if (r5 == r4) goto L_0x0181;
    L_0x0029:
        r2 = getPhysicalYPixels;
        if (r2 != 0) goto L_0x003a;
    L_0x002d:
        r2 = r4.getVisible;
        if (r2 == 0) goto L_0x003a;
    L_0x0031:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0037:
        r2 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0037 }
        throw r2;
    L_0x003a:
        if (r5 == 0) goto L_0x003e;
    L_0x003c:
        r5.getVisible = r8;
    L_0x003e:
        r2 = r4.HttpLogger();
        if (r2 != 0) goto L_0x0050;
    L_0x0044:
        r9 = r14.getWidthPixels;
        if (r5 != 0) goto L_0x00f8;
    L_0x0048:
        r2 = r3;
    L_0x0049:
        r2 = r9.setDrawable(r14, r2);
        r4.setDrawable(r2);
    L_0x0050:
        if (r5 != 0) goto L_0x0103;
    L_0x0052:
        r2 = r4.HttpLogger();
        r2 = r14.setDrawable(r2);
        r14.getHeightPixels = r2;
        r2 = r14.getHeightPixels;
        if (r2 == 0) goto L_0x00fe;
    L_0x0060:
        r2 = r14.getHeightPixels;
        r4.n = r2;
        r14.u();
        r2 = r3;
        r2 = (long[][]) r2;
        r9 = r14.s;
        r9.start();
    L_0x0070:
        r9 = r14.getHeightPixels;
        r10 = r4.n;
        r14.getHeightPixels = r10;
        r11 = r14.getHeightPixels;
        r11 = r9.equals(r11);
        if (r11 != 0) goto L_0x0088;
    L_0x0080:
        r11 = new com.duokan.reader.domain.document.sbk.getPhysicalYPixels;
        r11.<init>(r14, r9);
        com.duokan.core.sys.TaskHandler.setDrawable(r11);
    L_0x0088:
        r9 = r10.getPhysicalXPixels();
        r9 = new long[r9][];
        r4.getPhysicalYPixels = r9;
        r9 = r10.getPhysicalXPixels();
        r9 = new com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState[r9];
        r4.getWidthPixels = r9;
        r9 = r4.getWidthPixels;
        r10 = com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState.NOT_TYPESETTED;
        java.util.Arrays.fill(r9, r10);
        if (r2 != 0) goto L_0x016f;
    L_0x00a1:
        r14.setDrawable(r4, r5);
        r10 = java.lang.System.currentTimeMillis();
        r14.q = r10;
    L_0x00aa:
        r14.QueryFeatureWrapper();
        r4.getVisible = r7;
    L_0x00af:
        r2 = r4.getPhysicalXPixels();
        if (r2 == 0) goto L_0x00cc;
    L_0x00b5:
        r14.p = r7;
        r5 = r14.n;
        r5.release();
        r14.setDrawable(r2, r4);
        r14.p = r8;
        r10 = java.lang.System.currentTimeMillis();
        r14.q = r10;
        r5 = r14.n;
        r5.release();
    L_0x00cc:
        if (r2 != 0) goto L_0x00f5;
    L_0x00ce:
        r2 = r14.n;
        r2.release();
        r2 = r4.SessionTask();
        r5 = r14.o;
        if (r2 == r5) goto L_0x0173;
    L_0x00db:
        if (r6 != 0) goto L_0x0173;
    L_0x00dd:
        r10 = java.lang.System.currentTimeMillis();
        r12 = r14.q;
        r10 = r10 - r12;
        r12 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 <= 0) goto L_0x0173;
    L_0x00ea:
        r2 = r14.setDrawable(r4, r7);
        if (r2 != 0) goto L_0x00f5;
    L_0x00f0:
        r2 = r14.BaseActivity;
        r2.acquireUninterruptibly();
    L_0x00f5:
        r5 = r4;
        goto L_0x0004;
    L_0x00f8:
        r2 = r5.HttpLogger();
        goto L_0x0049;
    L_0x00fe:
        r14.v();
        goto L_0x0023;
    L_0x0103:
        r2 = r4.SessionTask();
        r9 = r5.SessionTask();
        if (r2 != r9) goto L_0x0163;
    L_0x010d:
        r2 = r5.n;
        r2 = (com.duokan.reader.domain.document.sbk.getHeightPixels) r2;
        r2 = r2.getScaledTouchSlop;
        r9 = r4.HttpLogger();
        r9 = r9.getVisible;
        r2 = r9.setDrawable(r2);
        r9 = 2;
        if (r2 != r9) goto L_0x0143;
    L_0x0124:
        r2 = r4.HttpLogger();
        r2 = r14.setDrawable(r2);
        if (r2 == 0) goto L_0x0136;
    L_0x012e:
        r4.n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x0136:
        r2 = r5.n;
        r4.n = r2;
        r2 = r5.getPhysicalYPixels();
        goto L_0x0070;
    L_0x0143:
        if (r2 != r7) goto L_0x0157;
    L_0x0145:
        r2 = new com.duokan.reader.domain.document.sbk.getHeightPixels;
        r9 = r4.HttpLogger();
        r2.<init>(r14, r9);
        r4.n = r2;
        r2 = r5.getPhysicalYPixels();
        goto L_0x0070;
    L_0x0157:
        r2 = r5.n;
        r4.n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x0163:
        r2 = r5.n;
        r4.n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x016f:
        r4.getPhysicalYPixels = r2;
        goto L_0x00aa;
    L_0x0173:
        r2 = r14.BaseActivity;	 Catch:{ Exception -> 0x017e }
        r10 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r5 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x017e }
        r2.tryAcquire(r10, r5);	 Catch:{ Exception -> 0x017e }
        goto L_0x00f5;
    L_0x017e:
        r2 = move-exception;
        goto L_0x00f5;
    L_0x0181:
        r4 = r5;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.sbk.HttpLogger.H():void");
    }

    private void a(SbkTypesettingContext sbkTypesettingContext, SbkTypesettingContext sbkTypesettingContext2) {
        long[][] jArr = (long[][]) null;
        if (this.j != null) {
            jArr = this.j.a(this, a(sbkTypesettingContext), sbkTypesettingContext.g());
        }
        if (jArr != null) {
            sbkTypesettingContext.i = jArr;
            a(sbkTypesettingContext, false);
        }
    }

    private boolean a(SbkTypesettingContext sbkTypesettingContext, boolean z) {
        if (i || sbkTypesettingContext != null) {
            c e = sbkTypesettingContext.e();
            if (!i && e.h() < 0) {
                throw new AssertionError();
            } else if (sbkTypesettingContext.k == ((long) e.h())) {
                return false;
            } else {
                long h = (long) (e.h() - 1);
                while (h >= 0) {
                    if (b(sbkTypesettingContext, h) < 0 && (h == 0 || b(sbkTypesettingContext, h - 1) >= 0)) {
                        a(sbkTypesettingContext, h);
                        break;
                    }
                    h--;
                }
                long j = 0;
                for (h = 0; h < ((long) e.h()); h++) {
                    if (b(sbkTypesettingContext, h) >= 0) {
                        j++;
                    }
                }
                sbkTypesettingContext.k = j;
                if (sbkTypesettingContext.k == ((long) e.h())) {
                    b(sbkTypesettingContext);
                    if (this.j != null && z) {
                        this.j.a(this, a(sbkTypesettingContext), sbkTypesettingContext.g(), sbkTypesettingContext.i);
                    }
                    y();
                    return false;
                }
                y();
                return true;
            }
        }
        throw new AssertionError();
    }

    private void a(ai aiVar, SbkTypesettingContext sbkTypesettingContext) {
        if (!i && aiVar == null) {
            throw new AssertionError();
        } else if (i || sbkTypesettingContext != null) {
            k kVar = (k) sbkTypesettingContext.e();
            if (!aiVar.c.b() && !aiVar.c.c()) {
                long j = aiVar.a.b;
                long j2 = aiVar.a.c;
                long j3 = aiVar.a.d;
                long j4 = aiVar.a.e;
                if (aiVar.a.a == null || !aiVar.a.a.b()) {
                    a c = a.c();
                    boolean z = aiVar.a.a == null || aiVar.a.a.l() == aiVar.a.l();
                    c.b(z);
                } else {
                    b j5 = aiVar.a.a.j();
                    j = j5.g();
                    j2 = j5.h();
                    j4 -= aiVar.a.a.e;
                }
                long[] a = a(sbkTypesettingContext, j, j2, j3, j4);
                a(sbkTypesettingContext, a[0]);
                aiVar.c.a = a[0];
                aiVar.c.b = a[1];
                aiVar.c.c = a[2];
                aiVar.c.d = aiVar.c.a;
                if (aiVar.c.a < 0 || aiVar.c.a >= ((long) kVar.h())) {
                    aiVar.c.e = 0;
                    aiVar.c.f = 0;
                } else {
                    aiVar.c.e = aiVar.c.b + 1;
                    aiVar.c.f = 0;
                }
                v a2 = kVar.a(aiVar.c.a, aiVar.c.b);
                if (!sbkTypesettingContext.d()) {
                    aiVar.c.i = sbkTypesettingContext.g().a;
                    aiVar.c.j = sbkTypesettingContext.g().b;
                } else if (a2 != null) {
                    int i = sbkTypesettingContext.g().a;
                    int f = (int) (((float) a2.f()) * (((float) i) / ((float) a2.b())));
                    aiVar.c.i = i;
                    aiVar.c.j = f;
                } else {
                    aiVar.c.i = sbkTypesettingContext.g().a;
                    aiVar.c.j = sbkTypesettingContext.g().b;
                }
                aiVar.c.e();
            }
        } else {
            throw new AssertionError();
        }
    }

    private void a(SbkTypesettingContext sbkTypesettingContext, long j) {
        c e = sbkTypesettingContext.e();
        if (j >= 0 && j < ((long) e.h()) && sbkTypesettingContext.j[(int) j] != ChapterState.TYPESETTED) {
            sbkTypesettingContext.j[(int) j] = ChapterState.TYPESETTING;
            a a = e.a(j);
            LinkedList linkedList = new LinkedList();
            while (true) {
                if (linkedList.isEmpty()) {
                    linkedList.push(new long[]{j, 0, 0});
                }
                if (!a.a()) {
                    long[] jArr = (long[]) linkedList.getLast();
                    Object a2 = a(sbkTypesettingContext, jArr[0], jArr[1], jArr[2], 1);
                    if (a2[0] != jArr[0]) {
                        break;
                    }
                    linkedList.add(a2);
                } else {
                    break;
                }
            }
            long[] jArr2 = new long[linkedList.size()];
            Iterator it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                long[] jArr3 = (long[]) it.next();
                int i2 = i + 1;
                jArr2[i] = (((long) ((int) jArr3[1])) << 32) | ((long) ((int) jArr3[2]));
                i = i2;
            }
            sbkTypesettingContext.i[(int) j] = jArr2;
            sbkTypesettingContext.j[(int) j] = ChapterState.TYPESETTED;
            b(sbkTypesettingContext);
        }
    }

    private boolean b(SbkTypesettingContext sbkTypesettingContext) {
        c e = sbkTypesettingContext.e();
        long b = sbkTypesettingContext.b();
        int i = 0;
        for (long j = 0; j < ((long) e.h()); j++) {
            long b2 = b(sbkTypesettingContext, j);
            if (b2 < 0) {
                return false;
            }
            i = (int) (b2 + ((long) i));
        }
        if (b == ((long) i)) {
            return false;
        }
        sbkTypesettingContext.a((long) i);
        z();
        return true;
    }

    private long b(SbkTypesettingContext sbkTypesettingContext, long j) {
        return sbkTypesettingContext.b(j);
    }

    private long[] a(SbkTypesettingContext sbkTypesettingContext, long j, long j2, long j3, long j4) {
        c e = sbkTypesettingContext.e();
        for (int i = 0; ((long) i) < Math.abs(j4); i++) {
            long j5;
            if (j < 0 || j >= ((long) e.h())) {
                j5 = 1;
            } else {
                j5 = (long) Math.max(e.a(j).b(), 1);
            }
            long j6 = j - 1;
            if (j6 < 0 || j6 >= ((long) e.h())) {
                j6 = 1;
            } else {
                j6 = (long) Math.max(e.a(j6).b(), 1);
            }
            if (j4 > 0) {
                j2++;
            } else if (j4 < 0) {
                j2--;
            }
            if (j2 < 0) {
                j--;
                j2 += j6;
            } else if (j2 >= j5) {
                j++;
                j2 -= j5;
            }
        }
        if (j < 0) {
            j = -1;
            j2 = 0;
        } else if (j >= ((long) e.h())) {
            j = (long) e.h();
            j2 = 0;
        }
        return new long[]{j, j2, 0};
    }

    private SbkTypesettingContext I() {
        SbkTypesettingContext sbkTypesettingContext;
        synchronized (this) {
            sbkTypesettingContext = (SbkTypesettingContext) this.l.getLast();
            if (i || sbkTypesettingContext != null) {
            } else {
                throw new AssertionError();
            }
        }
        return sbkTypesettingContext;
    }

    private c a(s sVar) {
        if (sVar != null) {
            return new k(this, sVar);
        }
        d(4);
        return null;
    }

    private void J() {
        this.u.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!i) {
                    throw new AssertionError();
                }
            }
        } while (!this.u.awaitTermination(60, TimeUnit.SECONDS));
        this.g.a();
        this.k.g();
    }

    private long a(x xVar) {
        a.c().b(xVar.b());
        b j = xVar.j();
        return xVar.l().b(j.g(), j.h(), j.i());
    }
}
