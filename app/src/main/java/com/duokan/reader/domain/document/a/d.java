package com.duokan.reader.domain.document.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

import com.duokan.core.diagnostic.a;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpFlowParserOption;
import com.duokan.kernel.pdflib.DkpPageEx;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.y;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class d extends n implements at {
    static final /* synthetic */ boolean i = (!d.class.desiredAssertionStatus());
    private final m j;
    private b k = null;
    private final LinkedList l = new LinkedList();
    private final Semaphore m = new Semaphore(0);
    private final Semaphore n = new Semaphore(0);
    private final q o;
    private boolean p = false;
    private long q = 0;
    private final Thread r;
    private final Thread s;
    private u t;
    private final ExecutorService u = Executors.newSingleThreadExecutor();

    public /* synthetic */ ak a(long j) {
        return b(j);
    }

    public /* synthetic */ ak f(ak akVar) {
        return j(akVar);
    }

    public /* synthetic */ ak g(ak akVar) {
        return k(akVar);
    }

    public /* synthetic */ m l() {
        return B();
    }

    public /* synthetic */ av q() {
        return C();
    }

    public d(m mVar) {
        a.c().b(A());
        DkUtils.initWordSeg(o.c().b());
        this.j = mVar;
        this.o = new q();
        this.t = new u();
        this.r = new Thread(new e(this));
        this.s = new Thread(new f(this));
    }

    public void a(r rVar) {
        a.c().a(this.a);
        a.c().b(rVar != null);
        if (!this.a && rVar != null && this.r.getState() == State.NEW) {
            this.l.addLast(new l(this, rVar, this.o, this.m));
            this.r.start();
        }
    }

    public static a a(long j, long j2, long j3) {
        return new a(j, j2, j3);
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
        a.c().b(A());
        if (!p()) {
            return 0;
        }
        ah F = F();
        if (F.g().c()) {
            return (long) this.k.h().getPageCount();
        }
        return F.b();
    }

    public int f() {
        a.c().b(A());
        if (p()) {
            return this.k.h().getPageCount();
        }
        return 0;
    }

    public float g() {
        a.c().b(A());
        if (p()) {
            return Math.max(0.0f, Math.min(((((float) F().j.mChapterIndex) - 1.0f) / ((float) f())) * 100.0f, 100.0f));
        }
        return 0.0f;
    }

    public h h() {
        a.c().b(A());
        if (p()) {
            return this.k.d();
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
        return F().c();
    }

    public k k() {
        k g;
        a.c().b(A());
        synchronized (this) {
            ah ahVar = (ah) this.l.getLast();
            if (i || ahVar != null) {
                g = ahVar.g();
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
                ah F = F();
                if (!F.g().equals(kVar)) {
                    this.l.addLast(new l(this, F.f(), new q((q) kVar), this.m));
                }
            }
            this.m.release();
            return;
        }
        throw new AssertionError();
    }

    public u B() {
        a.c().b(A());
        return this.t;
    }

    public void a(m mVar) {
        a.c().b(A());
        if (i || mVar != null) {
            this.t = (u) mVar;
            return;
        }
        throw new AssertionError();
    }

    public f m() {
        a.c().b(A());
        if (p()) {
            return this.k.e();
        }
        return null;
    }

    public void a(l lVar) {
        a.c().b(A());
    }

    public long b(ak akVar) {
        a.c().b(A());
        if (!p()) {
            return -1;
        }
        ah F = F();
        s sVar = (v) akVar;
        if (F.g().c()) {
            return p.a(this.k.h(), sVar) - 1;
        }
        if (!d((com.duokan.reader.domain.document.a) akVar) || !akVar.e()) {
            return -1;
        }
        a aVar = (a) akVar.g();
        return F.a(aVar.g(), aVar.h(), aVar.i());
    }

    public long a(av avVar) {
        a.c().b(A());
        if (!p()) {
            return -1;
        }
        ah F = F();
        a aVar = (a) avVar;
        if (F.g().c()) {
            return p.a(this.k.h(), aVar) - 1;
        }
        return F.a(aVar.g(), aVar.h(), aVar.i());
    }

    public long c(ak akVar) {
        a.c().b(A());
        if (!p()) {
            return -1;
        }
        return p.a(this.k.h(), (v) akVar) - 1;
    }

    public long b(av avVar) {
        a.c().b(A());
        if (!p()) {
            return -1;
        }
        return p.a(this.k.h(), (a) avVar) - 1;
    }

    public int b(int i) {
        a.c().b(A());
        if (p()) {
            return this.k.h().getPageWidth((long) (i + 1));
        }
        return -1;
    }

    public int c(int i) {
        a.c().b(A());
        if (p()) {
            return this.k.h().getPageHeight((long) (i + 1));
        }
        return -1;
    }

    public a C() {
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

    public com.duokan.reader.domain.document.a c(com.duokan.reader.domain.document.a aVar) {
        a.c().b(A());
        return aVar;
    }

    public bb a(com.duokan.reader.domain.document.d dVar, com.duokan.reader.domain.document.d dVar2) {
        a.c().b(A());
        return new ag((a) dVar, (a) dVar2);
    }

    public bb s() {
        a.c().b(A());
        return new ag();
    }

    public v b(long j) {
        a.c().b(A());
        ah F = F();
        if (F.g().c()) {
            return new v(F, j, 0, 0, false, 0);
        }
        return new v(F, 0, 0, 0, true, j);
    }

    public ak c(av avVar) {
        a.c().b(A());
        ah F = F();
        a aVar = (a) avVar;
        if (i || aVar != null) {
            return new v(F, aVar.g(), aVar.h(), aVar.i(), true, 0);
        }
        throw new AssertionError();
    }

    public ak e(ak akVar) {
        a.c().b(A());
        if (!i && (akVar == null || !akVar.a())) {
            throw new AssertionError();
        } else if (akVar instanceof v) {
            return a((v) akVar, 0);
        } else {
            return null;
        }
    }

    public s j(ak akVar) {
        a.c().b(A());
        return (s) a(akVar, 1);
    }

    public s k(ak akVar) {
        a.c().b(A());
        return (s) a(akVar, -1);
    }

    public ak a(ak akVar, int i) {
        a.c().b(A());
        if (i || (akVar != null && akVar.a())) {
            ah F = F();
            if (!(akVar instanceof v)) {
                return null;
            }
            com.duokan.reader.domain.document.a aVar = (v) akVar;
            ah l = aVar.l();
            if (aVar.b() || l == F || d(aVar)) {
                return new v(F, aVar, (long) i);
            }
            return null;
        }
        throw new AssertionError();
    }

    public boolean h(ak akVar) {
        a.c().b(A());
        return false;
    }

    public boolean i(ak akVar) {
        a.c().b(A());
        return false;
    }

    public boolean d(com.duokan.reader.domain.document.a aVar) {
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
            if (aVar instanceof v) {
                v vVar = (v) aVar;
                ah l = vVar.l();
                synchronized (this) {
                    if (l.a) {
                        l.a(vVar, null);
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
            u B = mVar == null ? B() : (u) mVar;
            d((com.duokan.reader.domain.document.a) akVar);
            ah F = F();
            if (akVar instanceof v) {
                return new w(F, (v) akVar, B, this.g, this);
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
        if (!p()) {
            return new aa(str);
        }
        a a;
        if (avVar == null) {
            a = a(0, 0, 0);
        } else {
            av avVar2 = avVar;
        }
        return a(a, str, i);
    }

    public aa a(aa aaVar, int i) {
        a.c().b(A());
        if (!i && aaVar == null) {
            throw new AssertionError();
        } else if (!p()) {
            return new aa(aaVar.a);
        } else {
            if (aaVar.b.length < 1) {
                return new aa(aaVar.a);
            }
            return a((k) aaVar, i);
        }
    }

    public y a(String str) {
        return null;
    }

    protected void t() {
        synchronized (this) {
            ah lVar = new l(this, F().f(), new q(), this.m);
            lVar.c = true;
            this.l.add(lVar);
        }
        this.m.release();
    }

    private k a(a aVar, String str, int i) {
        if (i || aVar != null) {
            Object kVar = new k(this, str, aVar, i);
            this.u.execute(kVar);
            return kVar;
        }
        throw new AssertionError();
    }

    private k a(k kVar, int i) {
        Object kVar2 = new k(this, kVar, i);
        this.u.execute(kVar2);
        return kVar2;
    }

    private void D() {
        while (true) {
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
                l lVar = (l) this.l.getFirst();
                int i = this.l.size() > 1 ? 1 : 0;
            }
            if (lVar.b) {
                ai aiVar;
                b e2 = lVar.e();
                synchronized (lVar) {
                    Iterator it = lVar.l.iterator();
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
                            if (aiVar2.c.b()) {
                                if (lVar.g().c()) {
                                    e2.h().releaseFixedPage(aiVar2.c.a + 1);
                                } else {
                                    e2.i().releaseFlowPage(new DkFlowPosition(aiVar2.c.a + 1, aiVar2.c.b, aiVar2.c.c), p.a(lVar.g()));
                                }
                            }
                        } else if (aiVar2.c.b()) {
                            it.remove();
                            aiVar = aiVar2;
                            break;
                        }
                    }
                    aiVar = null;
                    Object obj;
                    if (lVar.l.size() > 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (aiVar != null) {
                    if (aiVar.a.c()) {
                        aiVar.a.a(a(aiVar.c.a, aiVar.c.b, aiVar.c.c), a(aiVar.c.d, aiVar.c.e, aiVar.c.f));
                    }
                    if (aiVar.b != null) {
                        aiVar.b.a(aiVar.c);
                    }
                    if (lVar.g().c()) {
                        e2.h().releaseFixedPage(aiVar.c.a + 1);
                    } else {
                        e2.i().releaseFlowPage(new DkFlowPosition(aiVar.c.a + 1, aiVar.c.b, aiVar.c.c), p.a(lVar.g()));
                    }
                }
                if (i == 1 && r11 == null && aiVar == null && lVar.a()) {
                    synchronized (this) {
                        if (lVar.h() == null) {
                            if (this.j != null && lVar.b() < 0) {
                                this.j.a(this, lVar.g(), lVar.i);
                            }
                            lVar.a = false;
                            this.l.removeFirst();
                            this.n.drainPermits();
                            this.m.release();
                            if (((ah) this.l.getFirst()).c) {
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
    private void E() {
        /*
        r16 = this;
        r15 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r14 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r8 = 1;
        r9 = 0;
        r3 = 0;
    L_0x0007:
        monitor-enter(r16);
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003e }
        r2 = r2.size();	 Catch:{ all -> 0x003e }
        if (r2 <= r8) goto L_0x002b;
    L_0x0012:
        r7 = r8;
    L_0x0013:
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003e }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003e }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.a.l) r0;	 Catch:{ all -> 0x003e }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003e }
        if (r2 == 0) goto L_0x002d;
    L_0x0023:
        monitor-exit(r16);	 Catch:{ all -> 0x003e }
        r16.G();
        r16.x();
    L_0x002a:
        return;
    L_0x002b:
        r7 = r9;
        goto L_0x0013;
    L_0x002d:
        monitor-exit(r16);	 Catch:{ all -> 0x003e }
        if (r3 == r4) goto L_0x026a;
    L_0x0030:
        r2 = i;
        if (r2 != 0) goto L_0x0041;
    L_0x0034:
        r2 = r4.b;
        if (r2 == 0) goto L_0x0041;
    L_0x0038:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x003e:
        r2 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x003e }
        throw r2;
    L_0x0041:
        if (r3 == 0) goto L_0x0045;
    L_0x0043:
        r3.b = r9;
    L_0x0045:
        if (r3 != 0) goto L_0x00aa;
    L_0x0047:
        r2 = r4.f();
        r0 = r16;
        r2 = r0.b(r2);
        r0 = r16;
        r0.k = r2;
        r0 = r16;
        r2 = r0.k;
        if (r2 == 0) goto L_0x00a6;
    L_0x005b:
        r0 = r16;
        r2 = r0.k;
        r4.n = r2;
        r16.u();
        r0 = r16;
        r2 = r0.s;
        r2.start();
    L_0x006c:
        r0 = r16;
        r2 = r0.k;
        r10 = r4.n;
        r0 = r16;
        r0.k = r10;
        r0 = r16;
        r3 = r0.k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x008c;
    L_0x0082:
        r3 = new com.duokan.reader.domain.document.a.g;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.t.a(r3);
    L_0x008c:
        r2 = r4.g();
        r11 = r2.j;
        r2 = com.duokan.reader.domain.document.a.o.c();
        r12 = r2.a();
        r2 = i;
        if (r2 != 0) goto L_0x00b2;
    L_0x009e:
        if (r12 != 0) goto L_0x00b2;
    L_0x00a0:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00a6:
        r16.v();
        goto L_0x002a;
    L_0x00aa:
        r2 = r3.n;
        r4.n = r2;
        goto L_0x006c;
    L_0x00b2:
        r2 = i;
        if (r2 != 0) goto L_0x00be;
    L_0x00b6:
        if (r11 != 0) goto L_0x00be;
    L_0x00b8:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00be:
        r2 = r11.entrySet();
        r5 = r2.iterator();
    L_0x00c6:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x00ff;
    L_0x00cc:
        r2 = r5.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r6 = android.text.TextUtils.isEmpty(r3);
        if (r6 != 0) goto L_0x00c6;
    L_0x00de:
        r6 = new java.io.File;
        r2 = r2.getValue();
        r2 = (java.lang.String) r2;
        r2 = android.net.Uri.parse(r2);
        r2 = r2.getPath();
        r6.<init>(r2);
        r2 = r6.exists();
        if (r2 == 0) goto L_0x00c6;
    L_0x00f7:
        r2 = r6.getAbsolutePath();
        r12.registerFont(r3, r2);
        goto L_0x00c6;
    L_0x00ff:
        r2 = "CUSTOM_FONT_EN";
        r2 = com.duokan.reader.domain.document.n.a(r11, r2);
        r3 = "DEFAULT_FONT_EN";
        r5 = com.duokan.reader.domain.document.n.a(r11, r3);
        r3 = "CUSTOM_FONT_ZH";
        r3 = com.duokan.reader.domain.document.n.b(r11, r3);
        r6 = "DEFAULT_FONT_ZH";
        r6 = com.duokan.reader.domain.document.n.b(r11, r6);
        r13 = "FALLBACK_FONT";
        com.duokan.reader.domain.document.n.c(r11, r13);
        r11 = android.text.TextUtils.isEmpty(r2);
        if (r11 != 0) goto L_0x0206;
    L_0x0122:
        r5 = android.text.TextUtils.isEmpty(r2);
        if (r5 != 0) goto L_0x0212;
    L_0x0128:
        r12.registerFont(r2, r2);
        r5 = r10.h();
        r5.setDefaultFont(r2, r9);
        r5 = r10.i();
        r5.setDefaultFont(r2, r9);
    L_0x0139:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x0226;
    L_0x013f:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x0229;
    L_0x0145:
        r12.registerFont(r3, r3);
        r5 = r10.h();
        r5.setDefaultFont(r3, r15);
        r5 = r10.i();
        r5.setDefaultFont(r3, r15);
        r5 = r10.h();
        r5.setDefaultFont(r3, r14);
        r5 = r10.i();
        r5.setDefaultFont(r3, r14);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0178;
    L_0x016a:
        r2 = r10.h();
        r2.setDefaultFont(r3, r9);
        r2 = r10.i();
        r2.setDefaultFont(r3, r9);
    L_0x0178:
        r2 = r10.j();
        r2 = (int) r2;
        r2 = new long[r2][];
        r4.i = r2;
        r2 = r4.g();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x024f;
    L_0x018d:
        r2 = com.duokan.reader.domain.document.a.o.c();
        r2 = r2.a();
        r2.setUseBookStyle(r8);
    L_0x0198:
        r0 = r16;
        r0.a(r4);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.q = r2;
        r4.b = r8;
    L_0x01a7:
        r2 = r4.h();
        if (r2 == 0) goto L_0x01d0;
    L_0x01ad:
        r0 = r16;
        r0.p = r8;
        r0 = r16;
        r3 = r0.n;
        r3.release();
        r0 = r16;
        r0.a(r2, r4);
        r0 = r16;
        r0.p = r9;
        r10 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.q = r10;
        r0 = r16;
        r3 = r0.n;
        r3.release();
    L_0x01d0:
        if (r2 != 0) goto L_0x0203;
    L_0x01d2:
        r0 = r16;
        r2 = r0.n;
        r2.release();
        r2 = r4.g();
        r0 = r16;
        r3 = r0.o;
        if (r2 == r3) goto L_0x025c;
    L_0x01e3:
        if (r7 != 0) goto L_0x025c;
    L_0x01e5:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r6 = r0.q;
        r2 = r2 - r6;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x025c;
    L_0x01f4:
        r0 = r16;
        r2 = r0.a(r4, r8);
        if (r2 != 0) goto L_0x0203;
    L_0x01fc:
        r0 = r16;
        r2 = r0.m;
        r2.acquireUninterruptibly();
    L_0x0203:
        r3 = r4;
        goto L_0x0007;
    L_0x0206:
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x020f;
    L_0x020c:
        r2 = r3;
        goto L_0x0122;
    L_0x020f:
        r2 = r5;
        goto L_0x0122;
    L_0x0212:
        r5 = r10.h();
        r11 = "";
        r5.setDefaultFont(r11, r9);
        r5 = r10.i();
        r11 = "";
        r5.setDefaultFont(r11, r9);
        goto L_0x0139;
    L_0x0226:
        r3 = r6;
        goto L_0x013f;
    L_0x0229:
        r2 = r10.h();
        r3 = "";
        r2.setDefaultFont(r3, r15);
        r2 = r10.i();
        r3 = "";
        r2.setDefaultFont(r3, r15);
        r2 = r10.h();
        r3 = "";
        r2.setDefaultFont(r3, r14);
        r2 = r10.i();
        r3 = "";
        r2.setDefaultFont(r3, r14);
        goto L_0x0178;
    L_0x024f:
        r2 = com.duokan.reader.domain.document.a.o.c();
        r2 = r2.a();
        r2.setUseBookStyle(r9);
        goto L_0x0198;
    L_0x025c:
        r0 = r16;
        r2 = r0.m;	 Catch:{ Exception -> 0x0268 }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x0268 }
        r2.tryAcquire(r6, r3);	 Catch:{ Exception -> 0x0268 }
        goto L_0x0203;
    L_0x0268:
        r2 = move-exception;
        goto L_0x0203;
    L_0x026a:
        r4 = r3;
        goto L_0x01a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.a.d.E():void");
    }

    private void a(ah ahVar) {
        b e = ahVar.e();
        if (!ahVar.g().c() && this.j != null) {
            long[][] a = this.j.a(this, ahVar.g());
            if (a != null) {
                Object obj = 1;
                int i = 0;
                int i2 = 0;
                long j = 0;
                long j2 = 0;
                while (i < a.length) {
                    long j3;
                    int i3;
                    if (a[i] != null) {
                        int length = a[i].length;
                        if (length > 0) {
                            j2 = (long) i;
                            j = a[i][length - 1];
                            i2 += length;
                        }
                        j3 = j2;
                        j2 = j;
                        i3 = i2;
                    } else {
                        obj = null;
                        j3 = j2;
                        j2 = j;
                        i3 = i2;
                    }
                    i++;
                    i2 = i3;
                    j = j2;
                    j2 = j3;
                }
                if (obj == null) {
                    DkpPageEx c = c(ahVar, new DkFlowPosition(j2 + 1, j >> 32, (long) ((int) j)), ahVar.g());
                    if (!i && c == null) {
                        throw new AssertionError();
                    } else if (c != null) {
                        ahVar.j = c.getPageEndPos();
                        ahVar.k = i2;
                        ahVar.i = a;
                        e.i().releaseFlowPage(c);
                        y();
                        return;
                    } else {
                        return;
                    }
                }
                ahVar.j = new DkFlowPosition(e.j() + 1, 0, 0);
                ahVar.k = i2;
                ahVar.i = a;
                ahVar.a((long) i2);
                z();
            }
        }
    }

    private boolean a(ah ahVar, boolean z) {
        if (i || ahVar != null) {
            b e = ahVar.e();
            if (ahVar.g().c()) {
                return false;
            }
            if (ahVar.j.mChapterIndex > e.j()) {
                return false;
            }
            int i;
            ArrayList arrayList = new ArrayList(12);
            DkpFlowParserOption a = p.a(ahVar.g());
            DkFlowPosition pageStartPos;
            DkFlowPosition dkFlowPosition;
            do {
                DkpBook i2 = e.i();
                dkFlowPosition = ahVar.j;
                i = (ahVar.j.mChapterIndex == 1 && ahVar.j.mParaIndex == 0 && ahVar.j.mAtomIndex == 0) ? 1 : 2;
                DkpPageEx acquireFlowPage = i2.acquireFlowPage(dkFlowPosition, a, i);
                if (acquireFlowPage == null) {
                    ahVar.j = new DkFlowPosition(e.j() + 1, 0, 0);
                    break;
                }
                pageStartPos = acquireFlowPage.getPageStartPos();
                dkFlowPosition = acquireFlowPage.getPageEndPos();
                arrayList.add(pageStartPos);
                e.i().releaseFlowPage(acquireFlowPage);
                ahVar.j = dkFlowPosition;
                ahVar.k++;
            } while (pageStartPos.mChapterIndex == dkFlowPosition.mChapterIndex);
            if (arrayList.size() > 0) {
                long[] jArr = new long[arrayList.size()];
                for (int i3 = 0; i3 < jArr.length; i3++) {
                    DkFlowPosition dkFlowPosition2 = (DkFlowPosition) arrayList.get(i3);
                    jArr[i3] = (dkFlowPosition2.mParaIndex << 32) | dkFlowPosition2.mAtomIndex;
                }
                ahVar.i[((int) ((DkFlowPosition) arrayList.get(0)).mChapterIndex) - 1] = jArr;
            }
            if (ahVar.j.mChapterIndex > e.j()) {
                for (i = 0; i < ahVar.i.length; i++) {
                    if (ahVar.i[i] == null) {
                        ahVar.i[i] = new long[0];
                    }
                }
                ahVar.a((long) ahVar.k);
                if (this.j != null && z) {
                    this.j.a(this, ahVar.g(), ahVar.i);
                }
                z();
                y();
                return false;
            }
            y();
            return true;
        }
        throw new AssertionError();
    }

    private void a(ai aiVar, ah ahVar) {
        if (!i && aiVar == null) {
            throw new AssertionError();
        } else if (i || ahVar != null) {
            b e = ahVar.e();
            if (!aiVar.c.b() && !aiVar.c.c()) {
                boolean z;
                long j;
                long j2 = aiVar.a.b;
                long j3 = aiVar.a.c;
                long j4 = aiVar.a.d;
                boolean z2 = aiVar.a.e;
                long j5 = aiVar.a.f;
                long j6;
                if (aiVar.a.a != null && aiVar.a.a.b()) {
                    a j7 = aiVar.a.a.j();
                    j2 = j7.g();
                    j3 = j7.h();
                    j4 = j7.i();
                    j6 = j5 - aiVar.a.a.f;
                    z = true;
                    j = j2;
                    j2 = j6;
                } else if (i || aiVar.a.a == null || aiVar.a.a.l() == aiVar.a.l()) {
                    j6 = j5;
                    z = z2;
                    j = j2;
                    j2 = j6;
                } else {
                    throw new AssertionError();
                }
                q g = ahVar.g();
                if (g.c()) {
                    j5 = Math.max(0, Math.min(j + j2, (long) (e.h().getPageCount() - 1)));
                    e.h().acquireFixedPage(1 + j5);
                    DkFlowPosition[] parseFixedPage = e.h().parseFixedPage(1 + j5);
                    DkFlowPosition dkFlowPosition = parseFixedPage[0];
                    DkFlowPosition dkFlowPosition2 = parseFixedPage[1];
                    if (dkFlowPosition.mChapterIndex < 1) {
                        dkFlowPosition.mChapterIndex = j5 + 1;
                        dkFlowPosition.mParaIndex = 0;
                        dkFlowPosition.mAtomIndex = 0;
                        dkFlowPosition2.mChapterIndex = dkFlowPosition.mChapterIndex;
                        dkFlowPosition2.mParaIndex = 2147483647L;
                        dkFlowPosition2.mAtomIndex = 2147483647L;
                    }
                    if (dkFlowPosition2.mChapterIndex < 1) {
                        dkFlowPosition2.mChapterIndex = dkFlowPosition.mChapterIndex;
                        dkFlowPosition2.mParaIndex = 2147483647L;
                        dkFlowPosition2.mAtomIndex = 2147483647L;
                    }
                    aiVar.c.a = dkFlowPosition.mChapterIndex - 1;
                    aiVar.c.b = dkFlowPosition.mParaIndex;
                    aiVar.c.c = dkFlowPosition.mAtomIndex;
                    aiVar.c.d = dkFlowPosition2.mChapterIndex - 1;
                    aiVar.c.e = dkFlowPosition2.mParaIndex;
                    aiVar.c.f = dkFlowPosition2.mAtomIndex;
                    aiVar.c.e();
                    return;
                }
                DkpPageEx c;
                DkFlowPosition pageStartPos;
                if (aiVar.a.b()) {
                    c = c(ahVar, aiVar.a.j().a(e.i()), g);
                } else if (ahVar.b() >= 0) {
                    if (z) {
                        r2 = c(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    } else {
                        r2 = b(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    }
                    pageStartPos = r2.getPageStartPos();
                    j = ahVar.a(pageStartPos.mChapterIndex - 1, pageStartPos.mParaIndex, pageStartPos.mAtomIndex) + j2;
                    e.i().releaseFlowPage(r2);
                    c = c(ahVar, ahVar.b(j), g);
                } else {
                    if (z) {
                        r2 = c(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    } else {
                        r2 = b(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    }
                    c = r2;
                    for (int i = 0; ((long) i) < Math.abs(j2); i++) {
                        DkpPageEx a;
                        if (j2 <= 0) {
                            a = a(ahVar, c.getPageStartPos(), g);
                            if (a == null) {
                                break;
                            }
                            e.i().releaseFlowPage(c);
                            c = a;
                        } else {
                            a = c(ahVar, c.getPageEndPos(), g);
                            if (a == null) {
                                break;
                            }
                            e.i().releaseFlowPage(c);
                            c = a;
                        }
                    }
                }
                if (i || c != null) {
                    DkFlowPosition pageStartPos2 = c.getPageStartPos();
                    pageStartPos = c.getPageEndPos();
                    aiVar.c.a = pageStartPos2.mChapterIndex - 1;
                    aiVar.c.b = pageStartPos2.mParaIndex;
                    aiVar.c.c = pageStartPos2.mAtomIndex;
                    aiVar.c.d = pageStartPos.mChapterIndex - 1;
                    aiVar.c.e = pageStartPos.mParaIndex;
                    aiVar.c.f = pageStartPos.mAtomIndex;
                    aiVar.c.e();
                    return;
                }
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private DkpPageEx a(ah ahVar, DkFlowPosition dkFlowPosition, q qVar) {
        b e = ahVar.e();
        return e.i().acquireFlowPage(dkFlowPosition, p.a(qVar), 0);
    }

    private DkpPageEx b(ah ahVar, DkFlowPosition dkFlowPosition, q qVar) {
        b e = ahVar.e();
        return e.i().acquireFlowPage(dkFlowPosition, p.a(qVar), 1);
    }

    private DkpPageEx c(ah ahVar, DkFlowPosition dkFlowPosition, q qVar) {
        b e = ahVar.e();
        return e.i().acquireFlowPage(dkFlowPosition, p.a(qVar), 2);
    }

    private ah F() {
        ah ahVar;
        synchronized (this) {
            ahVar = (ah) this.l.getLast();
            if (i || ahVar != null) {
            } else {
                throw new AssertionError();
            }
        }
        return ahVar;
    }

    private b b(r rVar) {
        if (rVar == null) {
            d(4);
            return null;
        }
        DkpBook openBook = o.c().a().openBook(Uri.parse(rVar.a).getPath());
        if (openBook == null) {
            d(1);
            return null;
        }
        DkpBook openBook2 = o.c().a().openBook(Uri.parse(rVar.a).getPath());
        if (openBook2 != null) {
            return new i(this, rVar, openBook, openBook2);
        }
        d(1);
        openBook.close();
        return null;
    }

    private void G() {
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
}
