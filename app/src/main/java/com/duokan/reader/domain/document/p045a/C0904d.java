package com.duokan.reader.domain.document.p045a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpFlowParserOption;
import com.duokan.kernel.pdflib.DkpPageEx;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C1012y;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.a.d */
public class C0904d extends C0903n implements at {
    /* renamed from: i */
    static final /* synthetic */ boolean f4281i = (!C0904d.class.desiredAssertionStatus());
    /* renamed from: j */
    private final C0817m f4282j;
    /* renamed from: k */
    private C0900b f4283k = null;
    /* renamed from: l */
    private final LinkedList<ah> f4284l = new LinkedList();
    /* renamed from: m */
    private final Semaphore f4285m = new Semaphore(0);
    /* renamed from: n */
    private final Semaphore f4286n = new Semaphore(0);
    /* renamed from: o */
    private final C0918q f4287o;
    /* renamed from: p */
    private boolean f4288p = false;
    /* renamed from: q */
    private long f4289q = 0;
    /* renamed from: r */
    private final Thread f4290r;
    /* renamed from: s */
    private final Thread f4291s;
    /* renamed from: t */
    private C0924u f4292t;
    /* renamed from: u */
    private final ExecutorService f4293u = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public /* synthetic */ ak mo1213a(long j) {
        return m6000b(j);
    }

    /* renamed from: f */
    public /* synthetic */ ak mo1237f(ak akVar) {
        return m6020j(akVar);
    }

    /* renamed from: g */
    public /* synthetic */ ak mo1239g(ak akVar) {
        return m6022k(akVar);
    }

    /* renamed from: l */
    public /* synthetic */ C0923m mo1246l() {
        return m5981B();
    }

    /* renamed from: q */
    public /* synthetic */ av mo1248q() {
        return m5982C();
    }

    public C0904d(C0817m c0817m) {
        WebLog.init().w(m5889A());
        DkUtils.initWordSeg(C0915o.m6074c().m6076b());
        this.f4282j = c0817m;
        this.f4287o = new C0918q();
        this.f4292t = new C0924u();
        this.f4290r = new Thread(new C0905e(this));
        this.f4291s = new Thread(new C0906f(this));
    }

    /* renamed from: a */
    public void m5992a(C0920r c0920r) {
        WebLog.init().m762a(this.a);
        WebLog.init().w(c0920r != null);
        if (!this.a && c0920r != null && this.f4290r.getState() == State.NEW) {
            this.f4284l.addLast(new C0914l(this, c0920r, this.f4287o, this.f4285m));
            this.f4290r.start();
        }
    }

    /* renamed from: a */
    public static C0898a m5963a(long j, long j2, long j3) {
        return new C0898a(j, j2, j3);
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        m5905a(asVar);
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        m5917b(asVar);
    }

    /* renamed from: c */
    public WritingDirection mo1228c() {
        WebLog.init().w(m5889A());
        return WritingDirection.TOP_TO_BOTTOM;
    }

    /* renamed from: d */
    public FootnoteStyle mo1231d() {
        WebLog.init().w(m5889A());
        return FootnoteStyle.NONE;
    }

    /* renamed from: e */
    public long mo1234e() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return 0;
        }
        ah F = m5960F();
        if (F.m5852g().mo1274c()) {
            return (long) this.f4283k.mo1262h().getPageCount();
        }
        return F.m5839b();
    }

    /* renamed from: f */
    public int mo1236f() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4283k.mo1262h().getPageCount();
        }
        return 0;
    }

    /* renamed from: g */
    public float mo1238g() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return Math.max(0.0f, Math.min(((((float) m5960F().f4254j.mChapterIndex) - 1.0f) / ((float) mo1236f())) * 100.0f, 100.0f));
        }
        return 0.0f;
    }

    /* renamed from: h */
    public C0911h mo1240h() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4283k.mo1258d();
        }
        return null;
    }

    /* renamed from: i */
    public boolean mo1242i() {
        boolean z = true;
        WebLog.init().w(m5889A());
        synchronized (this) {
            if (this.f4284l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: j */
    public boolean mo1244j() {
        WebLog.init().w(m5889A());
        return m5960F().mo1272c();
    }

    /* renamed from: k */
    public C0917k mo1245k() {
        C0917k g;
        WebLog.init().w(m5889A());
        synchronized (this) {
            ah ahVar = (ah) this.f4284l.getLast();
            if (f4281i || ahVar != null) {
                g = ahVar.m5852g();
            } else {
                throw new AssertionError();
            }
        }
        return g;
    }

    /* renamed from: a */
    public void mo1218a(C0917k c0917k) {
        WebLog.init().w(m5889A());
        if (f4281i || c0917k != null) {
            synchronized (this) {
                ah F = m5960F();
                if (!F.m5852g().equals(c0917k)) {
                    this.f4284l.addLast(new C0914l(this, F.m5851f(), new C0918q((C0918q) c0917k), this.f4285m));
                }
            }
            this.f4285m.release();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: B */
    public C0924u m5981B() {
        WebLog.init().w(m5889A());
        return this.f4292t;
    }

    /* renamed from: a */
    public void mo1220a(C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4281i || c0923m != null) {
            this.f4292t = (C0924u) c0923m;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public C0908f mo1247m() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4283k.mo1259e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo1219a(C0919l c0919l) {
        WebLog.init().w(m5889A());
    }

    /* renamed from: b */
    public long mo1223b(ak akVar) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return -1;
        }
        ah F = m5960F();
        C0921s c0921s = (C0925v) akVar;
        if (F.m5852g().mo1274c()) {
            return C0916p.m6078a(this.f4283k.mo1262h(), c0921s) - 1;
        }
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return -1;
        }
        C0898a c0898a = (C0898a) akVar.mo1198g();
        return F.m5846a(c0898a.m5795g(), c0898a.m5796h(), c0898a.m5797i());
    }

    /* renamed from: a */
    public long mo1209a(av avVar) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return -1;
        }
        ah F = m5960F();
        C0898a c0898a = (C0898a) avVar;
        if (F.m5852g().mo1274c()) {
            return C0916p.m6077a(this.f4283k.mo1262h(), c0898a) - 1;
        }
        return F.m5846a(c0898a.m5795g(), c0898a.m5796h(), c0898a.m5797i());
    }

    /* renamed from: c */
    public long mo1227c(ak akVar) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return -1;
        }
        return C0916p.m6078a(this.f4283k.mo1262h(), (C0925v) akVar) - 1;
    }

    /* renamed from: b */
    public long mo1224b(av avVar) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return -1;
        }
        return C0916p.m6077a(this.f4283k.mo1262h(), (C0898a) avVar) - 1;
    }

    /* renamed from: b */
    public int mo1222b(int i) {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4283k.mo1262h().getPageWidth((long) (i + 1));
        }
        return -1;
    }

    /* renamed from: c */
    public int mo1226c(int i) {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4283k.mo1262h().getPageHeight((long) (i + 1));
        }
        return -1;
    }

    /* renamed from: C */
    public C0898a m5982C() {
        WebLog.init().w(m5889A());
        return C0904d.m5963a(0, 0, 0);
    }

    /* renamed from: d */
    public ak mo1232d(ak akVar) {
        WebLog.init().w(m5889A());
        return null;
    }

    /* renamed from: r */
    public ak mo1249r() {
        WebLog.init().w(m5889A());
        return mo1230c(C0904d.m5963a((long) (mo1236f() - 1), 0, 0));
    }

    /* renamed from: c */
    public C0896a mo1229c(C0896a c0896a) {
        WebLog.init().w(m5889A());
        return c0896a;
    }

    /* renamed from: a */
    public bb mo1216a(C0897d c0897d, C0897d c0897d2) {
        WebLog.init().w(m5889A());
        return new ag((C0898a) c0897d, (C0898a) c0897d2);
    }

    /* renamed from: s */
    public bb mo1250s() {
        WebLog.init().w(m5889A());
        return new ag();
    }

    /* renamed from: b */
    public C0925v m6000b(long j) {
        WebLog.init().w(m5889A());
        ah F = m5960F();
        if (F.m5852g().mo1274c()) {
            return new C0925v(F, j, 0, 0, false, 0);
        }
        return new C0925v(F, 0, 0, 0, true, j);
    }

    /* renamed from: c */
    public ak mo1230c(av avVar) {
        WebLog.init().w(m5889A());
        ah F = m5960F();
        C0898a c0898a = (C0898a) avVar;
        if (f4281i || c0898a != null) {
            return new C0925v(F, c0898a.m5795g(), c0898a.m5796h(), c0898a.m5797i(), true, 0);
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    public ak mo1235e(ak akVar) {
        WebLog.init().w(m5889A());
        if (!f4281i && (akVar == null || !akVar.mo1186a())) {
            throw new AssertionError();
        } else if (akVar instanceof C0925v) {
            return mo1214a((C0925v) akVar, 0);
        } else {
            return null;
        }
    }

    /* renamed from: j */
    public C0921s m6020j(ak akVar) {
        WebLog.init().w(m5889A());
        return (C0921s) mo1214a(akVar, 1);
    }

    /* renamed from: k */
    public C0921s m6022k(ak akVar) {
        WebLog.init().w(m5889A());
        return (C0921s) mo1214a(akVar, -1);
    }

    /* renamed from: a */
    public ak mo1214a(ak akVar, int i) {
        WebLog.init().w(m5889A());
        if (f4281i || (akVar != null && akVar.mo1186a())) {
            ah F = m5960F();
            if (!(akVar instanceof C0925v)) {
                return null;
            }
            C0896a c0896a = (C0925v) akVar;
            ah l = c0896a.m6194l();
            if (c0896a.m5777b() || l == F || mo1233d(c0896a)) {
                return new C0925v(F, c0896a, (long) i);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public boolean mo1241h(ak akVar) {
        WebLog.init().w(m5889A());
        return false;
    }

    /* renamed from: i */
    public boolean mo1243i(ak akVar) {
        WebLog.init().w(m5889A());
        return false;
    }

    /* renamed from: d */
    public boolean mo1233d(C0896a c0896a) {
        WebLog.init().w(m5889A());
        if (!f4281i && c0896a == null) {
            throw new AssertionError();
        } else if (!f4281i && !c0896a.mo1186a()) {
            throw new AssertionError();
        } else if (!c0896a.mo1186a()) {
            return false;
        } else {
            if (c0896a.m5777b()) {
                return true;
            }
            if (c0896a instanceof C0925v) {
                C0925v c0925v = (C0925v) c0896a;
                ah l = c0925v.m6194l();
                synchronized (this) {
                    if (l.a) {
                        l.m5847a(c0925v, null);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public as mo1215a(ak akVar, C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4281i || akVar != null) {
            C0924u B = c0923m == null ? m5981B() : (C0924u) c0923m;
            mo1233d((C0896a) akVar);
            ah F = m5960F();
            if (akVar instanceof C0925v) {
                return new C0926w(F, (C0925v) akVar, B, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Bitmap mo1210a(String str, Rect rect, int i, int i2) {
        WebLog.init().w(m5889A());
        return null;
    }

    /* renamed from: a */
    public aa mo1212a(av avVar, String str, int i) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return new aa(str);
        }
        C0898a a;
        if (avVar == null) {
            a = C0904d.m5963a(0, 0, 0);
        } else {
            av a2 = avVar;
        }
        return m5964a(a2, str, i);
    }

    /* renamed from: a */
    public aa mo1211a(aa aaVar, int i) {
        WebLog.init().w(m5889A());
        if (!f4281i && aaVar == null) {
            throw new AssertionError();
        } else if (!m5945p()) {
            return new aa(aaVar.f4314a);
        } else {
            if (aaVar.f4315b.length < 1) {
                return new aa(aaVar.f4314a);
            }
            return m5965a((C0913k) aaVar, i);
        }
    }

    /* renamed from: a */
    public C1012y mo1217a(String str) {
        return null;
    }

    /* renamed from: t */
    protected void mo1251t() {
        synchronized (this) {
            ah c0914l = new C0914l(this, m5960F().m5851f(), new C0918q(), this.f4285m);
            c0914l.c = true;
            this.f4284l.add(c0914l);
        }
        this.f4285m.release();
    }

    /* renamed from: a */
    private C0913k m5964a(C0898a c0898a, String str, int i) {
        if (f4281i || c0898a != null) {
            Object c0913k = new C0913k(this, str, c0898a, i);
            this.f4293u.execute(c0913k);
            return c0913k;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private C0913k m5965a(C0913k c0913k, int i) {
        Object c0913k2 = new C0913k(this, c0913k, i);
        this.f4293u.execute(c0913k2);
        return c0913k2;
    }

    /* renamed from: D */
    private void m5958D() {
        while (true) {
            try {
                if (this.f4288p) {
                    this.f4286n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.f4286n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!f4281i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                C0914l c0914l = (C0914l) this.f4284l.getFirst();
                int i = this.f4284l.size() > 1 ? 1 : 0;
            }
            if (c0914l.b) {
                ai aiVar;
                C0900b e2 = c0914l.mo1273e();
                synchronized (c0914l) {
                    Iterator it = c0914l.l.iterator();
                    while (it.hasNext()) {
                        ai aiVar2 = (ai) it.next();
                        if (!f4281i && aiVar2 == null) {
                            throw new AssertionError();
                        } else if (!f4281i && aiVar2.f4260c == null) {
                            throw new AssertionError();
                        } else if (!aiVar2.f4260c.m5805a()) {
                            aiVar = null;
                            break;
                        } else if (aiVar2.f4260c.m5807c()) {
                            it.remove();
                            if (aiVar2.f4259b != null) {
                                aiVar2.f4259b.mo1304b(aiVar2.f4260c);
                            }
                            if (aiVar2.f4260c.m5806b()) {
                                if (c0914l.m5852g().mo1274c()) {
                                    e2.mo1262h().releaseFixedPage(aiVar2.f4260c.f4232a + 1);
                                } else {
                                    e2.mo1263i().releaseFlowPage(new DkFlowPosition(aiVar2.f4260c.f4232a + 1, aiVar2.f4260c.f4233b, aiVar2.f4260c.f4234c), C0916p.m6080a(c0914l.m5852g()));
                                }
                            }
                        } else if (aiVar2.f4260c.m5806b()) {
                            it.remove();
                            aiVar = aiVar2;
                            break;
                        }
                    }
                    aiVar = null;
                    Object obj;
                    if (c0914l.l.size() > 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (aiVar != null) {
                    if (aiVar.f4258a.mo1189c()) {
                        aiVar.f4258a.m6185a(C0904d.m5963a(aiVar.f4260c.f4232a, aiVar.f4260c.f4233b, aiVar.f4260c.f4234c), C0904d.m5963a(aiVar.f4260c.f4235d, aiVar.f4260c.f4236e, aiVar.f4260c.f4237f));
                    }
                    if (aiVar.f4259b != null) {
                        aiVar.f4259b.mo1294a(aiVar.f4260c);
                    }
                    if (c0914l.m5852g().mo1274c()) {
                        e2.mo1262h().releaseFixedPage(aiVar.f4260c.f4232a + 1);
                    } else {
                        e2.mo1263i().releaseFlowPage(new DkFlowPosition(aiVar.f4260c.f4232a + 1, aiVar.f4260c.f4233b, aiVar.f4260c.f4234c), C0916p.m6080a(c0914l.m5852g()));
                    }
                }
                if (i == 1 && obj == null && aiVar == null && c0914l.m5837a()) {
                    synchronized (this) {
                        if (c0914l.m5853h() == null) {
                            if (this.f4282j != null && c0914l.m5839b() < 0) {
                                this.f4282j.mo1116a(this, c0914l.m5852g(), c0914l.i);
                            }
                            c0914l.a = false;
                            this.f4284l.removeFirst();
                            this.f4286n.drainPermits();
                            this.f4285m.release();
                            if (((ah) this.f4284l.getFirst()).c) {
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
    /* renamed from: E */
    private void m5959E() {
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
        r2 = r0.f4284l;	 Catch:{ all -> 0x003e }
        r2 = r2.size();	 Catch:{ all -> 0x003e }
        if (r2 <= r8) goto L_0x002b;
    L_0x0012:
        r7 = r8;
    L_0x0013:
        r0 = r16;
        r2 = r0.f4284l;	 Catch:{ all -> 0x003e }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003e }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.p045a.C0914l) r0;	 Catch:{ all -> 0x003e }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003e }
        if (r2 == 0) goto L_0x002d;
    L_0x0023:
        monitor-exit(r16);	 Catch:{ all -> 0x003e }
        r16.m5961G();
        r16.m5953x();
    L_0x002a:
        return;
    L_0x002b:
        r7 = r9;
        goto L_0x0013;
    L_0x002d:
        monitor-exit(r16);	 Catch:{ all -> 0x003e }
        if (r3 == r4) goto L_0x026a;
    L_0x0030:
        r2 = f4281i;
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
        r2 = r4.m5851f();
        r0 = r16;
        r2 = r0.m5972b(r2);
        r0 = r16;
        r0.f4283k = r2;
        r0 = r16;
        r2 = r0.f4283k;
        if (r2 == 0) goto L_0x00a6;
    L_0x005b:
        r0 = r16;
        r2 = r0.f4283k;
        r4.f4324n = r2;
        r16.m5950u();
        r0 = r16;
        r2 = r0.f4291s;
        r2.start();
    L_0x006c:
        r0 = r16;
        r2 = r0.f4283k;
        r10 = r4.f4324n;
        r0 = r16;
        r0.f4283k = r10;
        r0 = r16;
        r3 = r0.f4283k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x008c;
    L_0x0082:
        r3 = new com.duokan.reader.domain.document.a.g;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.C0367t.m1038a(r3);
    L_0x008c:
        r2 = r4.m5852g();
        r11 = r2.j;
        r2 = com.duokan.reader.domain.document.p045a.C0915o.m6074c();
        r12 = r2.m6075a();
        r2 = f4281i;
        if (r2 != 0) goto L_0x00b2;
    L_0x009e:
        if (r12 != 0) goto L_0x00b2;
    L_0x00a0:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00a6:
        r16.m5951v();
        goto L_0x002a;
    L_0x00aa:
        r2 = r3.f4324n;
        r4.f4324n = r2;
        goto L_0x006c;
    L_0x00b2:
        r2 = f4281i;
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
        r2 = com.duokan.reader.domain.document.C0903n.m5886a(r11, r2);
        r3 = "DEFAULT_FONT_EN";
        r5 = com.duokan.reader.domain.document.C0903n.m5886a(r11, r3);
        r3 = "CUSTOM_FONT_ZH";
        r3 = com.duokan.reader.domain.document.C0903n.m5887b(r11, r3);
        r6 = "DEFAULT_FONT_ZH";
        r6 = com.duokan.reader.domain.document.C0903n.m5887b(r11, r6);
        r13 = "FALLBACK_FONT";
        com.duokan.reader.domain.document.C0903n.m5888c(r11, r13);
        r11 = android.text.TextUtils.isEmpty(r2);
        if (r11 != 0) goto L_0x0206;
    L_0x0122:
        r5 = android.text.TextUtils.isEmpty(r2);
        if (r5 != 0) goto L_0x0212;
    L_0x0128:
        r12.registerFont(r2, r2);
        r5 = r10.mo1262h();
        r5.setDefaultFont(r2, r9);
        r5 = r10.mo1263i();
        r5.setDefaultFont(r2, r9);
    L_0x0139:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x0226;
    L_0x013f:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x0229;
    L_0x0145:
        r12.registerFont(r3, r3);
        r5 = r10.mo1262h();
        r5.setDefaultFont(r3, r15);
        r5 = r10.mo1263i();
        r5.setDefaultFont(r3, r15);
        r5 = r10.mo1262h();
        r5.setDefaultFont(r3, r14);
        r5 = r10.mo1263i();
        r5.setDefaultFont(r3, r14);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0178;
    L_0x016a:
        r2 = r10.mo1262h();
        r2.setDefaultFont(r3, r9);
        r2 = r10.mo1263i();
        r2.setDefaultFont(r3, r9);
    L_0x0178:
        r2 = r10.m5863j();
        r2 = (int) r2;
        r2 = new long[r2][];
        r4.i = r2;
        r2 = r4.m5852g();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x024f;
    L_0x018d:
        r2 = com.duokan.reader.domain.document.p045a.C0915o.m6074c();
        r2 = r2.m6075a();
        r2.setUseBookStyle(r8);
    L_0x0198:
        r0 = r16;
        r0.m5966a(r4);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4289q = r2;
        r4.b = r8;
    L_0x01a7:
        r2 = r4.m5853h();
        if (r2 == 0) goto L_0x01d0;
    L_0x01ad:
        r0 = r16;
        r0.f4288p = r8;
        r0 = r16;
        r3 = r0.f4286n;
        r3.release();
        r0 = r16;
        r0.m5967a(r2, r4);
        r0 = r16;
        r0.f4288p = r9;
        r10 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4289q = r10;
        r0 = r16;
        r3 = r0.f4286n;
        r3.release();
    L_0x01d0:
        if (r2 != 0) goto L_0x0203;
    L_0x01d2:
        r0 = r16;
        r2 = r0.f4286n;
        r2.release();
        r2 = r4.m5852g();
        r0 = r16;
        r3 = r0.f4287o;
        if (r2 == r3) goto L_0x025c;
    L_0x01e3:
        if (r7 != 0) goto L_0x025c;
    L_0x01e5:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r6 = r0.f4289q;
        r2 = r2 - r6;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x025c;
    L_0x01f4:
        r0 = r16;
        r2 = r0.m5970a(r4, r8);
        if (r2 != 0) goto L_0x0203;
    L_0x01fc:
        r0 = r16;
        r2 = r0.f4285m;
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
        r5 = r10.mo1262h();
        r11 = "";
        r5.setDefaultFont(r11, r9);
        r5 = r10.mo1263i();
        r11 = "";
        r5.setDefaultFont(r11, r9);
        goto L_0x0139;
    L_0x0226:
        r3 = r6;
        goto L_0x013f;
    L_0x0229:
        r2 = r10.mo1262h();
        r3 = "";
        r2.setDefaultFont(r3, r15);
        r2 = r10.mo1263i();
        r3 = "";
        r2.setDefaultFont(r3, r15);
        r2 = r10.mo1262h();
        r3 = "";
        r2.setDefaultFont(r3, r14);
        r2 = r10.mo1263i();
        r3 = "";
        r2.setDefaultFont(r3, r14);
        goto L_0x0178;
    L_0x024f:
        r2 = com.duokan.reader.domain.document.p045a.C0915o.m6074c();
        r2 = r2.m6075a();
        r2.setUseBookStyle(r9);
        goto L_0x0198;
    L_0x025c:
        r0 = r16;
        r2 = r0.f4285m;	 Catch:{ Exception -> 0x0268 }
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

    /* renamed from: a */
    private void m5966a(ah ahVar) {
        C0900b e = ahVar.mo1273e();
        if (!ahVar.m5852g().mo1274c() && this.f4282j != null) {
            long[][] a = this.f4282j.mo1117a(this, ahVar.m5852g());
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
                    DkpPageEx c = m5974c(ahVar, new DkFlowPosition(j2 + 1, j >> 32, (long) ((int) j)), ahVar.m5852g());
                    if (!f4281i && c == null) {
                        throw new AssertionError();
                    } else if (c != null) {
                        ahVar.f4254j = c.getPageEndPos();
                        ahVar.f4255k = i2;
                        ahVar.f4253i = a;
                        e.mo1263i().releaseFlowPage(c);
                        m5954y();
                        return;
                    } else {
                        return;
                    }
                }
                ahVar.f4254j = new DkFlowPosition(e.m5863j() + 1, 0, 0);
                ahVar.f4255k = i2;
                ahVar.f4253i = a;
                ahVar.m5835a((long) i2);
                m5955z();
            }
        }
    }

    /* renamed from: a */
    private boolean m5970a(ah ahVar, boolean z) {
        if (f4281i || ahVar != null) {
            C0900b e = ahVar.mo1273e();
            if (ahVar.m5852g().mo1274c()) {
                return false;
            }
            if (ahVar.f4254j.mChapterIndex > e.m5863j()) {
                return false;
            }
            int i;
            ArrayList arrayList = new ArrayList(12);
            DkpFlowParserOption a = C0916p.m6080a(ahVar.m5852g());
            DkFlowPosition pageStartPos;
            DkFlowPosition dkFlowPosition;
            do {
                DkpBook i2 = e.mo1263i();
                dkFlowPosition = ahVar.f4254j;
                i = (ahVar.f4254j.mChapterIndex == 1 && ahVar.f4254j.mParaIndex == 0 && ahVar.f4254j.mAtomIndex == 0) ? 1 : 2;
                DkpPageEx acquireFlowPage = i2.acquireFlowPage(dkFlowPosition, a, i);
                if (acquireFlowPage == null) {
                    ahVar.f4254j = new DkFlowPosition(e.m5863j() + 1, 0, 0);
                    break;
                }
                pageStartPos = acquireFlowPage.getPageStartPos();
                dkFlowPosition = acquireFlowPage.getPageEndPos();
                arrayList.add(pageStartPos);
                e.mo1263i().releaseFlowPage(acquireFlowPage);
                ahVar.f4254j = dkFlowPosition;
                ahVar.f4255k++;
            } while (pageStartPos.mChapterIndex == dkFlowPosition.mChapterIndex);
            if (arrayList.size() > 0) {
                long[] jArr = new long[arrayList.size()];
                for (int i3 = 0; i3 < jArr.length; i3++) {
                    DkFlowPosition dkFlowPosition2 = (DkFlowPosition) arrayList.get(i3);
                    jArr[i3] = (dkFlowPosition2.mParaIndex << 32) | dkFlowPosition2.mAtomIndex;
                }
                ahVar.f4253i[((int) ((DkFlowPosition) arrayList.get(0)).mChapterIndex) - 1] = jArr;
            }
            if (ahVar.f4254j.mChapterIndex > e.m5863j()) {
                for (i = 0; i < ahVar.f4253i.length; i++) {
                    if (ahVar.f4253i[i] == null) {
                        ahVar.f4253i[i] = new long[0];
                    }
                }
                ahVar.m5835a((long) ahVar.f4255k);
                if (this.f4282j != null && z) {
                    this.f4282j.mo1116a(this, ahVar.m5852g(), ahVar.f4253i);
                }
                m5955z();
                m5954y();
                return false;
            }
            m5954y();
            return true;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m5967a(ai aiVar, ah ahVar) {
        if (!f4281i && aiVar == null) {
            throw new AssertionError();
        } else if (f4281i || ahVar != null) {
            C0900b e = ahVar.mo1273e();
            if (!aiVar.f4260c.m5806b() && !aiVar.f4260c.m5807c()) {
                boolean z;
                long j;
                long j2 = aiVar.f4258a.f4371b;
                long j3 = aiVar.f4258a.f4372c;
                long j4 = aiVar.f4258a.f4373d;
                boolean z2 = aiVar.f4258a.f4374e;
                long j5 = aiVar.f4258a.f4375f;
                long j6;
                if (aiVar.f4258a.f4370a != null && aiVar.f4258a.f4370a.m5777b()) {
                    C0898a j7 = aiVar.f4258a.f4370a.mo1278j();
                    j2 = j7.m5795g();
                    j3 = j7.m5796h();
                    j4 = j7.m5797i();
                    j6 = j5 - aiVar.f4258a.f4370a.f4375f;
                    z = true;
                    j = j2;
                    j2 = j6;
                } else if (f4281i || aiVar.f4258a.f4370a == null || aiVar.f4258a.f4370a.m6194l() == aiVar.f4258a.m6194l()) {
                    j6 = j5;
                    z = z2;
                    j = j2;
                    j2 = j6;
                } else {
                    throw new AssertionError();
                }
                C0918q g = ahVar.m5852g();
                if (g.mo1274c()) {
                    j5 = Math.max(0, Math.min(j + j2, (long) (e.mo1262h().getPageCount() - 1)));
                    e.mo1262h().acquireFixedPage(1 + j5);
                    DkFlowPosition[] parseFixedPage = e.mo1262h().parseFixedPage(1 + j5);
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
                    aiVar.f4260c.f4232a = dkFlowPosition.mChapterIndex - 1;
                    aiVar.f4260c.f4233b = dkFlowPosition.mParaIndex;
                    aiVar.f4260c.f4234c = dkFlowPosition.mAtomIndex;
                    aiVar.f4260c.f4235d = dkFlowPosition2.mChapterIndex - 1;
                    aiVar.f4260c.f4236e = dkFlowPosition2.mParaIndex;
                    aiVar.f4260c.f4237f = dkFlowPosition2.mAtomIndex;
                    aiVar.f4260c.m5809e();
                    return;
                }
                DkpPageEx c;
                DkFlowPosition pageStartPos;
                if (aiVar.f4258a.m5777b()) {
                    c = m5974c(ahVar, aiVar.f4258a.mo1278j().m5786a(e.mo1263i()), g);
                } else if (ahVar.m5839b() >= 0) {
                    if (z) {
                        r2 = m5974c(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    } else {
                        r2 = m5971b(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    }
                    pageStartPos = r2.getPageStartPos();
                    j = ahVar.m5846a(pageStartPos.mChapterIndex - 1, pageStartPos.mParaIndex, pageStartPos.mAtomIndex) + j2;
                    e.mo1263i().releaseFlowPage(r2);
                    c = m5974c(ahVar, ahVar.m5849b(j), g);
                } else {
                    if (z) {
                        r2 = m5974c(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    } else {
                        r2 = m5971b(ahVar, new DkFlowPosition(j + 1, j3, j4), g);
                    }
                    c = r2;
                    for (int i = 0; ((long) i) < Math.abs(j2); i++) {
                        DkpPageEx a;
                        if (j2 <= 0) {
                            a = m5962a(ahVar, c.getPageStartPos(), g);
                            if (a == null) {
                                break;
                            }
                            e.mo1263i().releaseFlowPage(c);
                            c = a;
                        } else {
                            a = m5974c(ahVar, c.getPageEndPos(), g);
                            if (a == null) {
                                break;
                            }
                            e.mo1263i().releaseFlowPage(c);
                            c = a;
                        }
                    }
                }
                if (f4281i || c != null) {
                    DkFlowPosition pageStartPos2 = c.getPageStartPos();
                    pageStartPos = c.getPageEndPos();
                    aiVar.f4260c.f4232a = pageStartPos2.mChapterIndex - 1;
                    aiVar.f4260c.f4233b = pageStartPos2.mParaIndex;
                    aiVar.f4260c.f4234c = pageStartPos2.mAtomIndex;
                    aiVar.f4260c.f4235d = pageStartPos.mChapterIndex - 1;
                    aiVar.f4260c.f4236e = pageStartPos.mParaIndex;
                    aiVar.f4260c.f4237f = pageStartPos.mAtomIndex;
                    aiVar.f4260c.m5809e();
                    return;
                }
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private DkpPageEx m5962a(ah ahVar, DkFlowPosition dkFlowPosition, C0918q c0918q) {
        C0900b e = ahVar.mo1273e();
        return e.mo1263i().acquireFlowPage(dkFlowPosition, C0916p.m6080a(c0918q), 0);
    }

    /* renamed from: b */
    private DkpPageEx m5971b(ah ahVar, DkFlowPosition dkFlowPosition, C0918q c0918q) {
        C0900b e = ahVar.mo1273e();
        return e.mo1263i().acquireFlowPage(dkFlowPosition, C0916p.m6080a(c0918q), 1);
    }

    /* renamed from: c */
    private DkpPageEx m5974c(ah ahVar, DkFlowPosition dkFlowPosition, C0918q c0918q) {
        C0900b e = ahVar.mo1273e();
        return e.mo1263i().acquireFlowPage(dkFlowPosition, C0916p.m6080a(c0918q), 2);
    }

    /* renamed from: F */
    private ah m5960F() {
        ah ahVar;
        synchronized (this) {
            ahVar = (ah) this.f4284l.getLast();
            if (f4281i || ahVar != null) {
            } else {
                throw new AssertionError();
            }
        }
        return ahVar;
    }

    /* renamed from: b */
    private C0900b m5972b(C0920r c0920r) {
        if (c0920r == null) {
            m5927d(4);
            return null;
        }
        DkpBook openBook = C0915o.m6074c().m6075a().openBook(Uri.parse(c0920r.a).getPath());
        if (openBook == null) {
            m5927d(1);
            return null;
        }
        DkpBook openBook2 = C0915o.m6074c().m6075a().openBook(Uri.parse(c0920r.a).getPath());
        if (openBook2 != null) {
            return new C0910i(this, c0920r, openBook, openBook2);
        }
        m5927d(1);
        openBook.close();
        return null;
    }

    /* renamed from: G */
    private void m5961G() {
        this.f4293u.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!f4281i) {
                    throw new AssertionError();
                }
            }
        } while (!this.f4293u.awaitTermination(60, TimeUnit.SECONDS));
        this.g.m6357a();
        this.f4283k.mo1261g();
    }
}
