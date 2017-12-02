package com.duokan.reader.domain.document.txt;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

import com.duokan.core.diagnostic.a;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktBook;
import com.duokan.kernel.txtlib.DktPage;
import com.duokan.kernel.txtlib.DktParserOption;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.y;

import java.lang.Thread.State;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import miuipub.date.Calendar;

public class p extends n implements at {
    static final /* synthetic */ boolean i = (!p.class.desiredAssertionStatus());
    private final y j;
    private c k = null;
    private final LinkedList l = new LinkedList();
    private final Semaphore m = new Semaphore(0);
    private final Semaphore n = new Semaphore(0);
    private final ad o;
    private boolean p = false;
    private long q = 0;
    private final Thread r;
    private final Thread s;
    private ah t;
    private final ExecutorService u = Executors.newSingleThreadExecutor();

    public /* synthetic */ ak a(long j) {
        return d(j);
    }

    public /* synthetic */ bb a(d dVar, d dVar2) {
        return b(dVar, dVar2);
    }

    public /* synthetic */ ak c(av avVar) {
        return d(avVar);
    }

    public /* synthetic */ ak e(ak akVar) {
        return j(akVar);
    }

    public /* synthetic */ ak f(ak akVar) {
        return k(akVar);
    }

    public /* synthetic */ ak g(ak akVar) {
        return l(akVar);
    }

    public /* synthetic */ h h() {
        return C();
    }

    public /* synthetic */ m l() {
        return D();
    }

    public /* synthetic */ av q() {
        return E();
    }

    public p(String str, y yVar) {
        a.c().b(A());
        if (i || str != null) {
            DkUtils.initWordSeg(aa.c().b());
            this.j = yVar;
            this.o = new ad();
            this.t = new ah();
            this.r = new Thread(new q(this));
            this.s = new Thread(new r(this));
            return;
        }
        throw new AssertionError();
    }

    public static b b(long j) {
        return new b(j);
    }

    public at a(b bVar, b bVar2) {
        return new at(bVar, bVar2);
    }

    public bb s() {
        return new at();
    }

    public af c(long j) {
        a.c().b(A());
        return new ai(H(), j, true, 0);
    }

    public long B() {
        a.c().b(A());
        if (p()) {
            return this.k.b();
        }
        return 0;
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
            au auVar = (au) this.l.getLast();
            if (i || auVar != null) {
                b = auVar.b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    public int f() {
        a.c().b(A());
        return 0;
    }

    public float g() {
        a.c().b(A());
        if (!p()) {
            return 0.0f;
        }
        float b = (((float) H().j) / ((float) this.k.b())) * 100.0f;
        if (b >= 0.0f) {
            return b;
        }
        return 100.0f;
    }

    public w C() {
        a.c().b(A());
        if (p()) {
            return (w) this.k.d();
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
        return H().c();
    }

    public k k() {
        k h;
        a.c().b(A());
        synchronized (this) {
            au auVar = (au) this.l.getLast();
            if (i || auVar != null) {
                h = auVar.h();
            } else {
                throw new AssertionError();
            }
        }
        return h;
    }

    public void a(k kVar) {
        a.c().b(A());
        if (i || kVar != null) {
            synchronized (this) {
                au H = H();
                if (!H.h().equals(kVar)) {
                    this.l.addLast(new x(this, H.g(), new ad((ad) kVar), this.m));
                }
            }
            this.m.release();
            return;
        }
        throw new AssertionError();
    }

    public ah D() {
        a.c().b(A());
        return this.t;
    }

    public void a(m mVar) {
        a.c().b(A());
        if (i || mVar != null) {
            this.t = (ah) mVar;
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
        a.c().a(this.a);
        a.c().b(lVar != null);
        if (!this.a && lVar != null && this.r.getState() == State.NEW) {
            this.l.addLast(new x(this, (ae) lVar, this.o, this.m));
            this.r.start();
        }
    }

    public long b(ak akVar) {
        a.c().b(A());
        if (!d((com.duokan.reader.domain.document.a) akVar) || !akVar.e()) {
            return -1;
        }
        b bVar = (b) akVar.g();
        au H = H();
        if (i || H != null) {
            return H.b(bVar.g());
        }
        throw new AssertionError();
    }

    public long a(av avVar) {
        b bVar = (b) avVar;
        au H = H();
        if (i || H != null) {
            return H.b(bVar.g());
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

    public b E() {
        return b(0);
    }

    public ak d(ak akVar) {
        a.c().b(A());
        au H = H();
        if (akVar instanceof e) {
            return (e) a((e) akVar, 0);
        }
        if (!(akVar instanceof ai)) {
            return null;
        }
        ai aiVar = (ai) akVar;
        au j = aiVar.j();
        if (aiVar.b() || j == H || d((com.duokan.reader.domain.document.a) aiVar)) {
            return new e(H, aiVar, 0);
        }
        return null;
    }

    public ak r() {
        if (i) {
            return null;
        }
        throw new AssertionError();
    }

    public com.duokan.reader.domain.document.a c(com.duokan.reader.domain.document.a aVar) {
        a.c().b(A());
        return aVar;
    }

    public at b(d dVar, d dVar2) {
        a.c().b(A());
        return a((b) dVar, (b) dVar2);
    }

    public af j(ak akVar) {
        a.c().b(A());
        if (!i && (akVar == null || !akVar.a())) {
            throw new AssertionError();
        } else if (akVar instanceof e) {
            return (af) a(((e) akVar).j(), 0);
        } else {
            if (akVar instanceof ai) {
                return (af) a((ai) akVar, 0);
            }
            return null;
        }
    }

    public ai d(long j) {
        a.c().b(A());
        return new ai(H(), 0, true, j);
    }

    public af d(av avVar) {
        a.c().b(A());
        return c(((b) avVar).g());
    }

    public af k(ak akVar) {
        a.c().b(A());
        return (af) a(akVar, 1);
    }

    public af l(ak akVar) {
        a.c().b(A());
        return (af) a(akVar, -1);
    }

    public ak a(ak akVar, int i) {
        a.c().b(A());
        if (i || (akVar != null && akVar.a())) {
            au H = H();
            au j;
            if (akVar instanceof e) {
                e eVar = (e) akVar;
                j = eVar.j().j();
                if (eVar.b() || j == H || d((com.duokan.reader.domain.document.a) eVar)) {
                    return new e(H, eVar, (long) i);
                }
                return null;
            } else if (!(akVar instanceof ai)) {
                return null;
            } else {
                com.duokan.reader.domain.document.a aVar = (ai) akVar;
                j = aVar.j();
                if (aVar.b() || j == H || d(aVar)) {
                    return new ai(H, aVar, (long) i);
                }
                return null;
            }
        }
        throw new AssertionError();
    }

    public boolean h(ak akVar) {
        boolean z = true;
        a.c().b(A());
        if (akVar instanceof e) {
            e eVar = (e) akVar;
            if (h(eVar.k()) || h(eVar.l())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ai)) {
            return false;
        } else {
            akVar = (ai) akVar;
            if (akVar.b()) {
                if (akVar.n().g() != 0) {
                    z = false;
                }
                return z;
            }
            if (!(d((com.duokan.reader.domain.document.a) akVar) && akVar.e() && h(akVar))) {
                z = false;
            }
            return z;
        }
    }

    public boolean i(ak akVar) {
        boolean z = true;
        a.c().b(A());
        if (akVar instanceof e) {
            e eVar = (e) akVar;
            if (i(eVar.l()) || i(eVar.k())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ai)) {
            return false;
        } else {
            com.duokan.reader.domain.document.a aVar = (ai) akVar;
            c cVar = this.k;
            if (aVar.b()) {
                if (aVar.o().g() != cVar.b()) {
                    z = false;
                }
                return z;
            }
            if (!(d(aVar) && aVar.e() && i(aVar))) {
                z = false;
            }
            return z;
        }
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
            if (aVar instanceof e) {
                e eVar = (e) aVar;
                au j = eVar.j().j();
                synchronized (this) {
                    if (j.a) {
                        j.a(eVar, null);
                    } else {
                        return false;
                    }
                }
            }
            if (aVar instanceof ai) {
                ai aiVar = (ai) aVar;
                au j2 = aiVar.j();
                synchronized (this) {
                    if (j2.a) {
                        j2.a(aiVar, null);
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
            ah D = mVar == null ? D() : (ah) mVar;
            d((com.duokan.reader.domain.document.a) akVar);
            au H = H();
            if (akVar instanceof e) {
                return new f(H, (e) akVar, D, this.g, this);
            }
            if (akVar instanceof ai) {
                return new aj(H, (ai) akVar, D, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    public Bitmap a(String str, Rect rect, int i, int i2) {
        return null;
    }

    public aa a(av avVar, String str, int i) {
        a.c().b(A());
        if (!p()) {
            return new aa(str);
        }
        if (avVar == null) {
            avVar = b(0);
        }
        c cVar = this.k;
        cVar.f();
        return a(cVar, avVar, str, i);
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
            c cVar = this.k;
            cVar.f();
            return a(cVar, aaVar.b[aaVar.b.length - 1].a.h(), aaVar.a, i);
        }
    }

    public y a(String str) {
        return null;
    }

    protected void t() {
        synchronized (this) {
            au xVar = new x(this, H().g(), new ad(), this.m);
            xVar.c = true;
            this.l.add(xVar);
        }
        this.m.release();
    }

    public void a(n nVar, as asVar) {
        a(asVar);
    }

    public void b(n nVar, as asVar) {
        b(asVar);
    }

    private ac a(c cVar, av avVar, String str, int i) {
        if (i || avVar != null) {
            Object sVar = new s(this, str, i, avVar, cVar, str);
            this.u.execute(sVar);
            return sVar;
        }
        throw new AssertionError();
    }

    private void F() {
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
                x xVar = (x) this.l.getFirst();
                if (this.l.size() > 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (xVar.b) {
                c e2 = xVar.e();
                ax axVar = null;
                synchronized (xVar) {
                    Iterator it = xVar.l.iterator();
                    while (it.hasNext()) {
                        ax axVar2 = (ax) it.next();
                        if (!i && axVar2 == null) {
                            throw new AssertionError();
                        } else if (!i && axVar2.c == null) {
                            throw new AssertionError();
                        } else if (!axVar2.c.b()) {
                            break;
                        } else if (axVar2.c.d()) {
                            it.remove();
                            if (axVar2.b != null) {
                                axVar2.b.b(axVar2.c);
                            }
                            if (axVar2.c.c()) {
                                e2.h().releasePage(axVar2.c.a, ab.a(xVar.h()));
                            }
                        } else if (axVar2.c.c()) {
                            it.remove();
                            axVar = axVar2;
                            break;
                        }
                    }
                    Object obj2;
                    if (xVar.l.size() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                }
                if (axVar != null) {
                    if (axVar.a.c()) {
                        axVar.a.a(b(axVar.c.a), b(axVar.c.a + axVar.c.b));
                    }
                    if (axVar.b != null) {
                        axVar.b.a(axVar.c);
                    }
                    e2.h().releasePage(axVar.c.a, ab.a(xVar.h()));
                }
                if (obj == 1 && r1 == null && axVar == null && xVar.a()) {
                    synchronized (this) {
                        if (xVar.i() == null) {
                            xVar.a = false;
                            this.l.removeFirst();
                            this.n.drainPermits();
                            this.m.release();
                            if (((au) this.l.getFirst()).c) {
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
    private void G() {
        /*
        r16 = this;
        r15 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r6 = 1;
        r7 = 0;
        r3 = 0;
    L_0x0005:
        monitor-enter(r16);
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003c }
        r2 = r2.size();	 Catch:{ all -> 0x003c }
        if (r2 <= r6) goto L_0x0029;
    L_0x0010:
        r5 = r6;
    L_0x0011:
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003c }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003c }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.txt.x) r0;	 Catch:{ all -> 0x003c }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003c }
        if (r2 == 0) goto L_0x002b;
    L_0x0021:
        monitor-exit(r16);	 Catch:{ all -> 0x003c }
        r16.I();
        r16.x();
    L_0x0028:
        return;
    L_0x0029:
        r5 = r7;
        goto L_0x0011;
    L_0x002b:
        monitor-exit(r16);	 Catch:{ all -> 0x003c }
        if (r3 == r4) goto L_0x027d;
    L_0x002e:
        r2 = i;
        if (r2 != 0) goto L_0x003f;
    L_0x0032:
        r2 = r4.b;
        if (r2 == 0) goto L_0x003f;
    L_0x0036:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x003c:
        r2 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x003c }
        throw r2;
    L_0x003f:
        if (r3 == 0) goto L_0x0043;
    L_0x0041:
        r3.b = r7;
    L_0x0043:
        if (r3 != 0) goto L_0x00a8;
    L_0x0045:
        r2 = r4.g();
        r0 = r16;
        r2 = r0.a(r2);
        r0 = r16;
        r0.k = r2;
        r0 = r16;
        r2 = r0.k;
        if (r2 == 0) goto L_0x00a4;
    L_0x0059:
        r0 = r16;
        r2 = r0.k;
        r4.n = r2;
        r16.u();
        r0 = r16;
        r2 = r0.s;
        r2.start();
    L_0x006a:
        r0 = r16;
        r2 = r0.k;
        r8 = r4.n;
        r0 = r16;
        r0.k = r8;
        r0 = r16;
        r3 = r0.k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x008a;
    L_0x0080:
        r3 = new com.duokan.reader.domain.document.txt.t;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.t.a(r3);
    L_0x008a:
        r2 = r4.h();
        r9 = r2.j;
        r2 = com.duokan.reader.domain.document.txt.aa.c();
        r10 = r2.a();
        r2 = i;
        if (r2 != 0) goto L_0x00b0;
    L_0x009c:
        if (r10 != 0) goto L_0x00b0;
    L_0x009e:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00a4:
        r16.v();
        goto L_0x0028;
    L_0x00a8:
        r2 = r3.n;
        r4.n = r2;
        goto L_0x006a;
    L_0x00b0:
        r2 = i;
        if (r2 != 0) goto L_0x00bc;
    L_0x00b4:
        if (r9 != 0) goto L_0x00bc;
    L_0x00b6:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00bc:
        r2 = r9.entrySet();
        r11 = r2.iterator();
    L_0x00c4:
        r2 = r11.hasNext();
        if (r2 == 0) goto L_0x00fd;
    L_0x00ca:
        r2 = r11.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r12 = android.text.TextUtils.isEmpty(r3);
        if (r12 != 0) goto L_0x00c4;
    L_0x00dc:
        r12 = new java.io.File;
        r2 = r2.getValue();
        r2 = (java.lang.String) r2;
        r2 = android.net.Uri.parse(r2);
        r2 = r2.getPath();
        r12.<init>(r2);
        r2 = r12.exists();
        if (r2 == 0) goto L_0x00c4;
    L_0x00f5:
        r2 = r12.getAbsolutePath();
        r10.registerFont(r3, r2);
        goto L_0x00c4;
    L_0x00fd:
        r2 = "CUSTOM_FONT_EN";
        r2 = com.duokan.reader.domain.document.n.a(r9, r2);
        r3 = "DEFAULT_FONT_EN";
        r3 = com.duokan.reader.domain.document.n.a(r9, r3);
        r11 = "CUSTOM_FONT_ZH";
        r11 = com.duokan.reader.domain.document.n.b(r9, r11);
        r12 = "DEFAULT_FONT_ZH";
        r12 = com.duokan.reader.domain.document.n.b(r9, r12);
        r13 = "FALLBACK_FONT";
        r9 = com.duokan.reader.domain.document.n.c(r9, r13);
        r13 = android.text.TextUtils.isEmpty(r2);
        if (r13 != 0) goto L_0x0210;
    L_0x0121:
        r10.registerFont(r2, r2);
        r13 = r8.h();
        r13.setFontFamily(r2, r7);
    L_0x012b:
        r13 = android.text.TextUtils.isEmpty(r11);
        if (r13 != 0) goto L_0x021b;
    L_0x0131:
        r10.registerFont(r11, r11);
        r13 = r8.h();
        r13.setFontFamily(r11, r15);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0148;
    L_0x0141:
        r2 = r8.h();
        r2.setFontFamily(r11, r7);
    L_0x0148:
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x0226;
    L_0x014e:
        r10.registerFont(r3, r3);
        r10.setDefaultFont(r3, r7);
    L_0x0154:
        r2 = android.text.TextUtils.isEmpty(r12);
        if (r2 != 0) goto L_0x022d;
    L_0x015a:
        r10.registerFont(r12, r12);
        r10.setDefaultFont(r12, r15);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 == 0) goto L_0x0169;
    L_0x0166:
        r10.setDefaultFont(r12, r7);
    L_0x0169:
        r2 = android.text.TextUtils.isEmpty(r9);
        if (r2 != 0) goto L_0x0234;
    L_0x016f:
        r10.registerFont(r9, r9);
        r10.setBackupFont(r9);
    L_0x0175:
        r2 = r4.h();
        r2 = r2.f;
        r3 = 2;
        r2 = java.lang.Math.max(r2, r3);
        r3 = r8.h();
        r10 = (double) r2;
        r3.setFontSize(r10);
        r2 = r4.h();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x023b;
    L_0x0194:
        r2 = com.duokan.reader.domain.document.txt.aa.c();
        r2 = r2.a();
        r2.setUseBookStyle(r6);
    L_0x019f:
        r0 = r16;
        r0.a(r4);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.q = r2;
        r16.z();
        r4.b = r6;
    L_0x01b1:
        r2 = r4.i();
        if (r2 == 0) goto L_0x01da;
    L_0x01b7:
        r0 = r16;
        r0.p = r6;
        r0 = r16;
        r3 = r0.n;
        r3.release();
        r0 = r16;
        r0.a(r2, r4);
        r0 = r16;
        r0.p = r7;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.q = r8;
        r0 = r16;
        r3 = r0.n;
        r3.release();
    L_0x01da:
        if (r2 != 0) goto L_0x020d;
    L_0x01dc:
        r0 = r16;
        r2 = r0.n;
        r2.release();
        r2 = r4.h();
        r0 = r16;
        r3 = r0.o;
        if (r2 == r3) goto L_0x026f;
    L_0x01ed:
        if (r5 != 0) goto L_0x026f;
    L_0x01ef:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r8 = r0.q;
        r2 = r2 - r8;
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x026f;
    L_0x01fe:
        r0 = r16;
        r2 = r0.a(r4, r6);
        if (r2 != 0) goto L_0x020d;
    L_0x0206:
        r0 = r16;
        r2 = r0.m;
        r2.acquireUninterruptibly();
    L_0x020d:
        r3 = r4;
        goto L_0x0005;
    L_0x0210:
        r13 = r8.h();
        r14 = "";
        r13.setFontFamily(r14, r7);
        goto L_0x012b;
    L_0x021b:
        r2 = r8.h();
        r11 = "";
        r2.setFontFamily(r11, r15);
        goto L_0x0148;
    L_0x0226:
        r2 = "";
        r10.setDefaultFont(r2, r7);
        goto L_0x0154;
    L_0x022d:
        r2 = "";
        r10.setDefaultFont(r2, r15);
        goto L_0x0169;
    L_0x0234:
        r2 = "";
        r10.setBackupFont(r2);
        goto L_0x0175;
    L_0x023b:
        r2 = com.duokan.reader.domain.document.txt.aa.c();
        r2 = r2.a();
        r2.setUseBookStyle(r7);
        r2 = r8.h();
        r3 = r4.h();
        r10 = r3.g;
        r2.setLineGap(r10);
        r2 = r8.h();
        r3 = r4.h();
        r10 = r3.h;
        r2.setParaSpacing(r10);
        r2 = r8.h();
        r3 = r4.h();
        r8 = r3.i;
        r2.setFirstLineIndent(r8);
        goto L_0x019f;
    L_0x026f:
        r0 = r16;
        r2 = r0.m;	 Catch:{ Exception -> 0x027b }
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x027b }
        r2.tryAcquire(r8, r3);	 Catch:{ Exception -> 0x027b }
        goto L_0x020d;
    L_0x027b:
        r2 = move-exception;
        goto L_0x020d;
    L_0x027d:
        r4 = r3;
        goto L_0x01b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.p.G():void");
    }

    private void a(au auVar) {
        if (this.j != null) {
            int[][] a = this.j.a(this, auVar.h());
            if (a != null) {
                int i = 0;
                int i2 = 0;
                while (i < a.length && a[i] != null) {
                    i2 = i;
                    i++;
                }
                i = 0;
                int i3 = 0;
                while (i < a[i2].length && a[i2][i] >= 0) {
                    i3 = i;
                    i++;
                }
                auVar.j = (long) a[i2][i3];
                auVar.k = (i2 * Calendar.MILLISECOND_OF_SECOND) + i3;
                auVar.i = a;
                a(auVar, false);
            }
        }
    }

    private boolean a(au auVar, boolean z) {
        if (i || auVar != null) {
            c e = auVar.e();
            if (auVar.j < 0) {
                return false;
            }
            DktParserOption a = ab.a(auVar.h());
            int i = auVar.k / Calendar.MILLISECOND_OF_SECOND;
            int i2 = auVar.k % Calendar.MILLISECOND_OF_SECOND;
            if (auVar.i[i] == null) {
                auVar.i[i] = new int[Calendar.MILLISECOND_OF_SECOND];
                Arrays.fill(auVar.i[i], -1);
            }
            auVar.i[i][i2] = (int) auVar.j;
            auVar.j = e.h().calcNextPageOffset(a, auVar.j);
            auVar.k++;
            if (auVar.j >= e.b() || auVar.j < 0) {
                auVar.j = -1;
                auVar.a((long) auVar.k);
                if (this.j != null && z) {
                    this.j.a(this, auVar.h(), auVar.i);
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

    private void a(ax axVar, au auVar) {
        boolean z = true;
        if (!i && axVar == null) {
            throw new AssertionError();
        } else if (i || auVar != null) {
            c e = auVar.e();
            if (!axVar.c.c() && !axVar.c.d()) {
                DktPage c;
                long j = axVar.a.b;
                boolean z2 = axVar.a.c;
                long j2 = axVar.a.d;
                if (axVar.a.a != null && axVar.a.a.b()) {
                    j = axVar.a.a.n().g();
                    j2 -= axVar.a.a.d;
                } else if (i || axVar.a.a == null || axVar.a.a.j() == axVar.a.j()) {
                    z = z2;
                } else {
                    throw new AssertionError();
                }
                ad h = auVar.h();
                if (axVar.a.b()) {
                    c = c(auVar, axVar.a.n().g(), h);
                } else if (auVar.b() >= 0) {
                    if (z) {
                        r2 = c(auVar, j, h);
                    } else {
                        r2 = b(auVar, j, h);
                    }
                    j2 = auVar.c(j2 + auVar.b(r2.getOffsetInByte()));
                    e.h().releasePage(r2);
                    c = c(auVar, j2, h);
                } else {
                    if (z) {
                        r2 = c(auVar, j, h);
                    } else {
                        r2 = b(auVar, j, h);
                    }
                    DktPage dktPage = r2;
                    for (int i = 0; ((long) i) < Math.abs(j2); i++) {
                        if (j2 <= 0) {
                            c = a(auVar, dktPage.getOffsetInByte(), h);
                            e.h().releasePage(dktPage);
                            if (c.isBeforeFirstPage()) {
                                break;
                            }
                            dktPage = c;
                        } else {
                            c = c(auVar, dktPage.getOffsetInByte() + dktPage.getSizeInByte(), h);
                            e.h().releasePage(dktPage);
                            if (c.isAfterLastPage()) {
                                break;
                            }
                            dktPage = c;
                        }
                    }
                    c = dktPage;
                }
                if (i || c != null) {
                    axVar.c.a = c.getOffsetInByte();
                    axVar.c.b = c.getSizeInByte();
                    axVar.c.f();
                    return;
                }
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private DktPage a(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        c e = auVar.e();
        DktParserOption a = ab.a(adVar);
        if (j <= 0) {
            acquirePage = e.h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.b()) {
            acquirePage = e.h().acquirePage(e.b(), a, 0);
        } else {
            acquirePage = e.h().acquirePage(j, a, 0);
        }
        if (acquirePage == null) {
            return e.h().acquirePage(Long.MIN_VALUE, a, 2);
        }
        return acquirePage;
    }

    private DktPage b(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        c e = auVar.e();
        DktParserOption a = ab.a(adVar);
        if (j < 0) {
            acquirePage = e.h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.b()) {
            acquirePage = e.h().acquirePage(Long.MAX_VALUE, a, 2);
        } else {
            acquirePage = e.h().acquirePage(j, a, 1);
        }
        if (acquirePage == null) {
            return e.h().acquirePage(Long.MAX_VALUE, a, 2);
        }
        return acquirePage;
    }

    private DktPage c(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        c e = auVar.e();
        DktParserOption a = ab.a(adVar);
        if (j < 0) {
            acquirePage = e.h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.b()) {
            acquirePage = e.h().acquirePage(Long.MAX_VALUE, a, 2);
        } else {
            acquirePage = e.h().acquirePage(j, a, 2);
        }
        if (acquirePage == null) {
            return e.h().acquirePage(Long.MAX_VALUE, a, 2);
        }
        return acquirePage;
    }

    private au H() {
        au auVar;
        synchronized (this) {
            auVar = (au) this.l.getLast();
            if (i || auVar != null) {
            } else {
                throw new AssertionError();
            }
        }
        return auVar;
    }

    private c a(ae aeVar) {
        if (aeVar == null) {
            d(4);
            return null;
        }
        try {
            long openDocument = aa.c().a().openDocument(Uri.parse(aeVar.a).getPath(), ReaderEnv.get().getTempDirectory().getPath());
            if (openDocument == 0) {
                d(1);
                return null;
            }
            DktBook dktBook = new DktBook(openDocument);
            if (dktBook.prepareParseContent(64) == 0) {
                return new v(this, aeVar, dktBook);
            }
            d(1);
            dktBook.close();
            return null;
        } catch (Throwable th) {
            d(1);
            return null;
        }
    }

    private void I() {
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
