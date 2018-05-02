package com.duokan.reader.domain.document.txt;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktBook;
import com.duokan.kernel.txtlib.DktPage;
import com.duokan.kernel.txtlib.DktParserOption;
import com.duokan.reader.ReaderEnv;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.txt.p */
public class C1000p extends C0903n implements at {
    /* renamed from: i */
    static final /* synthetic */ boolean f4978i = (!C1000p.class.desiredAssertionStatus());
    /* renamed from: j */
    private final C0826y f4979j;
    /* renamed from: k */
    private C0987c f4980k = null;
    /* renamed from: l */
    private final LinkedList<au> f4981l = new LinkedList();
    /* renamed from: m */
    private final Semaphore f4982m = new Semaphore(0);
    /* renamed from: n */
    private final Semaphore f4983n = new Semaphore(0);
    /* renamed from: o */
    private final ad f4984o;
    /* renamed from: p */
    private boolean f4985p = false;
    /* renamed from: q */
    private long f4986q = 0;
    /* renamed from: r */
    private final Thread f4987r;
    /* renamed from: s */
    private final Thread f4988s;
    /* renamed from: t */
    private ah f4989t;
    /* renamed from: u */
    private final ExecutorService f4990u = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public /* synthetic */ ak mo1213a(long j) {
        return m7730d(j);
    }

    /* renamed from: a */
    public /* synthetic */ bb mo1216a(C0897d c0897d, C0897d c0897d2) {
        return m7719b(c0897d, c0897d2);
    }

    /* renamed from: c */
    public /* synthetic */ ak mo1230c(av avVar) {
        return m7729d(avVar);
    }

    /* renamed from: e */
    public /* synthetic */ ak mo1235e(ak akVar) {
        return m7742j(akVar);
    }

    /* renamed from: f */
    public /* synthetic */ ak mo1237f(ak akVar) {
        return m7745k(akVar);
    }

    /* renamed from: g */
    public /* synthetic */ ak mo1239g(ak akVar) {
        return m7747l(akVar);
    }

    /* renamed from: h */
    public /* synthetic */ C0911h mo1240h() {
        return m7699C();
    }

    /* renamed from: l */
    public /* synthetic */ C0923m mo1246l() {
        return m7700D();
    }

    /* renamed from: q */
    public /* synthetic */ av mo1248q() {
        return m7701E();
    }

    public C1000p(String str, C0826y c0826y) {
        WebLog.init().w(m5889A());
        if (f4978i || str != null) {
            DkUtils.initWordSeg(aa.m7376c().m7378b());
            this.f4979j = c0826y;
            this.f4984o = new ad();
            this.f4989t = new ah();
            this.f4987r = new Thread(new C1001q(this));
            this.f4988s = new Thread(new C1002r(this));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static C0986b m7689b(long j) {
        return new C0986b(j);
    }

    /* renamed from: a */
    public at m7710a(C0986b c0986b, C0986b c0986b2) {
        return new at(c0986b, c0986b2);
    }

    /* renamed from: s */
    public bb mo1250s() {
        return new at();
    }

    /* renamed from: c */
    public af m7726c(long j) {
        WebLog.init().w(m5889A());
        return new ai(m7678H(), j, true, 0);
    }

    /* renamed from: B */
    public long m7698B() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4980k.mo1256b();
        }
        return 0;
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
        long b;
        WebLog.init().w(m5889A());
        synchronized (this) {
            au auVar = (au) this.f4981l.getLast();
            if (f4978i || auVar != null) {
                b = auVar.m5839b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    /* renamed from: f */
    public int mo1236f() {
        WebLog.init().w(m5889A());
        return 0;
    }

    /* renamed from: g */
    public float mo1238g() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return 0.0f;
        }
        float b = (((float) m7678H().f4921j) / ((float) this.f4980k.mo1256b())) * 100.0f;
        if (b >= 0.0f) {
            return b;
        }
        return 100.0f;
    }

    /* renamed from: C */
    public C1007w m7699C() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return (C1007w) this.f4980k.mo1258d();
        }
        return null;
    }

    /* renamed from: i */
    public boolean mo1242i() {
        boolean z = true;
        WebLog.init().w(m5889A());
        synchronized (this) {
            if (this.f4981l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: j */
    public boolean mo1244j() {
        WebLog.init().w(m5889A());
        return m7678H().mo1272c();
    }

    /* renamed from: k */
    public C0917k mo1245k() {
        C0917k h;
        WebLog.init().w(m5889A());
        synchronized (this) {
            au auVar = (au) this.f4981l.getLast();
            if (f4978i || auVar != null) {
                h = auVar.m7524h();
            } else {
                throw new AssertionError();
            }
        }
        return h;
    }

    /* renamed from: a */
    public void mo1218a(C0917k c0917k) {
        WebLog.init().w(m5889A());
        if (f4978i || c0917k != null) {
            synchronized (this) {
                au H = m7678H();
                if (!H.m7524h().equals(c0917k)) {
                    this.f4981l.addLast(new C1008x(this, H.m7523g(), new ad((ad) c0917k), this.f4982m));
                }
            }
            this.f4982m.release();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: D */
    public ah m7700D() {
        WebLog.init().w(m5889A());
        return this.f4989t;
    }

    /* renamed from: a */
    public void mo1220a(C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4978i || c0923m != null) {
            this.f4989t = (ah) c0923m;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public C0908f mo1247m() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4980k.mo1259e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo1219a(C0919l c0919l) {
        WebLog.init().m762a(this.a);
        WebLog.init().w(c0919l != null);
        if (!this.a && c0919l != null && this.f4987r.getState() == State.NEW) {
            this.f4981l.addLast(new C1008x(this, (ae) c0919l, this.f4984o, this.f4982m));
            this.f4987r.start();
        }
    }

    /* renamed from: b */
    public long mo1223b(ak akVar) {
        WebLog.init().w(m5889A());
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return -1;
        }
        C0986b c0986b = (C0986b) akVar.mo1198g();
        au H = m7678H();
        if (f4978i || H != null) {
            return H.m7519b(c0986b.m7539g());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public long mo1209a(av avVar) {
        C0986b c0986b = (C0986b) avVar;
        au H = m7678H();
        if (f4978i || H != null) {
            return H.m7519b(c0986b.m7539g());
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public long mo1227c(ak akVar) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: b */
    public long mo1224b(av avVar) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: b */
    public int mo1222b(int i) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: c */
    public int mo1226c(int i) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: E */
    public C0986b m7701E() {
        return C1000p.m7689b(0);
    }

    /* renamed from: d */
    public ak mo1232d(ak akVar) {
        WebLog.init().w(m5889A());
        au H = m7678H();
        if (akVar instanceof C0989e) {
            return (C0989e) mo1214a((C0989e) akVar, 0);
        }
        if (!(akVar instanceof ai)) {
            return null;
        }
        ai aiVar = (ai) akVar;
        au j = aiVar.m7396j();
        if (aiVar.m5777b() || j == H || mo1233d((C0896a) aiVar)) {
            return new C0989e(H, aiVar, 0);
        }
        return null;
    }

    /* renamed from: r */
    public ak mo1249r() {
        if (f4978i) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public C0896a mo1229c(C0896a c0896a) {
        WebLog.init().w(m5889A());
        return c0896a;
    }

    /* renamed from: b */
    public at m7719b(C0897d c0897d, C0897d c0897d2) {
        WebLog.init().w(m5889A());
        return m7710a((C0986b) c0897d, (C0986b) c0897d2);
    }

    /* renamed from: j */
    public af m7742j(ak akVar) {
        WebLog.init().w(m5889A());
        if (!f4978i && (akVar == null || !akVar.mo1186a())) {
            throw new AssertionError();
        } else if (akVar instanceof C0989e) {
            return (af) mo1214a(((C0989e) akVar).m7560j(), 0);
        } else {
            if (akVar instanceof ai) {
                return (af) mo1214a((ai) akVar, 0);
            }
            return null;
        }
    }

    /* renamed from: d */
    public ai m7730d(long j) {
        WebLog.init().w(m5889A());
        return new ai(m7678H(), 0, true, j);
    }

    /* renamed from: d */
    public af m7729d(av avVar) {
        WebLog.init().w(m5889A());
        return m7726c(((C0986b) avVar).m7539g());
    }

    /* renamed from: k */
    public af m7745k(ak akVar) {
        WebLog.init().w(m5889A());
        return (af) mo1214a(akVar, 1);
    }

    /* renamed from: l */
    public af m7747l(ak akVar) {
        WebLog.init().w(m5889A());
        return (af) mo1214a(akVar, -1);
    }

    /* renamed from: a */
    public ak mo1214a(ak akVar, int i) {
        WebLog.init().w(m5889A());
        if (f4978i || (akVar != null && akVar.mo1186a())) {
            au H = m7678H();
            au j;
            if (akVar instanceof C0989e) {
                C0989e c0989e = (C0989e) akVar;
                j = c0989e.m7560j().m7396j();
                if (c0989e.m5777b() || j == H || mo1233d((C0896a) c0989e)) {
                    return new C0989e(H, c0989e, (long) i);
                }
                return null;
            } else if (!(akVar instanceof ai)) {
                return null;
            } else {
                C0896a c0896a = (ai) akVar;
                j = c0896a.m7396j();
                if (c0896a.m5777b() || j == H || mo1233d(c0896a)) {
                    return new ai(H, c0896a, (long) i);
                }
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public boolean mo1241h(ak akVar) {
        boolean z = true;
        WebLog.init().w(m5889A());
        if (akVar instanceof C0989e) {
            C0989e c0989e = (C0989e) akVar;
            if (mo1241h(c0989e.m7561k()) || mo1241h(c0989e.m7562l())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ai)) {
            return false;
        } else {
            akVar = (ai) akVar;
            if (akVar.m5777b()) {
                if (akVar.mo1460n().m7539g() != 0) {
                    z = false;
                }
                return z;
            }
            if (!(mo1233d((C0896a) akVar) && akVar.mo1192e() && mo1241h(akVar))) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: i */
    public boolean mo1243i(ak akVar) {
        boolean z = true;
        WebLog.init().w(m5889A());
        if (akVar instanceof C0989e) {
            C0989e c0989e = (C0989e) akVar;
            if (mo1243i(c0989e.m7562l()) || mo1243i(c0989e.m7561k())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ai)) {
            return false;
        } else {
            C0896a c0896a = (ai) akVar;
            C0987c c0987c = this.f4980k;
            if (c0896a.m5777b()) {
                if (c0896a.mo1461o().m7539g() != c0987c.mo1256b()) {
                    z = false;
                }
                return z;
            }
            if (!(mo1233d(c0896a) && c0896a.mo1192e() && mo1243i(c0896a))) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: d */
    public boolean mo1233d(C0896a c0896a) {
        WebLog.init().w(m5889A());
        if (!f4978i && c0896a == null) {
            throw new AssertionError();
        } else if (!f4978i && !c0896a.mo1186a()) {
            throw new AssertionError();
        } else if (!c0896a.mo1186a()) {
            return false;
        } else {
            if (c0896a.m5777b()) {
                return true;
            }
            if (c0896a instanceof C0989e) {
                C0989e c0989e = (C0989e) c0896a;
                au j = c0989e.m7560j().m7396j();
                synchronized (this) {
                    if (j.a) {
                        j.m7518a(c0989e, null);
                    } else {
                        return false;
                    }
                }
            }
            if (c0896a instanceof ai) {
                ai aiVar = (ai) c0896a;
                au j2 = aiVar.m7396j();
                synchronized (this) {
                    if (j2.a) {
                        j2.m7517a(aiVar, null);
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
        if (f4978i || akVar != null) {
            ah D = c0923m == null ? m7700D() : (ah) c0923m;
            mo1233d((C0896a) akVar);
            au H = m7678H();
            if (akVar instanceof C0989e) {
                return new C0990f(H, (C0989e) akVar, D, this.g, this);
            }
            if (akVar instanceof ai) {
                return new aj(H, (ai) akVar, D, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Bitmap mo1210a(String str, Rect rect, int i, int i2) {
        return null;
    }

    /* renamed from: a */
    public aa mo1212a(av avVar, String str, int i) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return new aa(str);
        }
        if (avVar == null) {
            avVar = C1000p.m7689b(0);
        }
        C0987c c0987c = this.f4980k;
        c0987c.mo1260f();
        return m7681a(c0987c, avVar, str, i);
    }

    /* renamed from: a */
    public aa mo1211a(aa aaVar, int i) {
        WebLog.init().w(m5889A());
        if (!f4978i && aaVar == null) {
            throw new AssertionError();
        } else if (!m5945p()) {
            return new aa(aaVar.f4314a);
        } else {
            if (aaVar.f4315b.length < 1) {
                return new aa(aaVar.f4314a);
            }
            C0987c c0987c = this.f4980k;
            c0987c.mo1260f();
            return m7681a(c0987c, aaVar.f4315b[aaVar.f4315b.length - 1].f5024a.mo1199h(), aaVar.f4314a, i);
        }
    }

    /* renamed from: a */
    public C1012y mo1217a(String str) {
        return null;
    }

    /* renamed from: t */
    protected void mo1251t() {
        synchronized (this) {
            au c1008x = new C1008x(this, m7678H().m7523g(), new ad(), this.f4982m);
            c1008x.c = true;
            this.f4981l.add(c1008x);
        }
        this.f4982m.release();
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        m5905a(asVar);
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        m5917b(asVar);
    }

    /* renamed from: a */
    private ac m7681a(C0987c c0987c, av avVar, String str, int i) {
        if (f4978i || avVar != null) {
            Object c1003s = new C1003s(this, str, i, avVar, c0987c, str);
            this.f4990u.execute(c1003s);
            return c1003s;
        }
        throw new AssertionError();
    }

    /* renamed from: F */
    private void m7676F() {
        while (true) {
            Object obj;
            try {
                if (this.f4985p) {
                    this.f4983n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.f4983n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!f4978i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                C1008x c1008x = (C1008x) this.f4981l.getFirst();
                if (this.f4981l.size() > 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (c1008x.b) {
                C0987c e2 = c1008x.mo1469e();
                ax axVar = null;
                synchronized (c1008x) {
                    Iterator it = c1008x.l.iterator();
                    while (it.hasNext()) {
                        ax axVar2 = (ax) it.next();
                        if (!f4978i && axVar2 == null) {
                            throw new AssertionError();
                        } else if (!f4978i && axVar2.f4934c == null) {
                            throw new AssertionError();
                        } else if (!axVar2.f4934c.m7498b()) {
                            break;
                        } else if (axVar2.f4934c.m7500d()) {
                            it.remove();
                            if (axVar2.f4933b != null) {
                                axVar2.f4933b.mo1463b(axVar2.f4934c);
                            }
                            if (axVar2.f4934c.m7499c()) {
                                e2.mo1468h().releasePage(axVar2.f4934c.f4915a, ab.m7380a(c1008x.m7524h()));
                            }
                        } else if (axVar2.f4934c.m7499c()) {
                            it.remove();
                            axVar = axVar2;
                            break;
                        }
                    }
                    Object obj2;
                    if (c1008x.l.size() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                }
                if (axVar != null) {
                    if (axVar.f4932a.mo1189c()) {
                        axVar.f4932a.m7389a(C1000p.m7689b(axVar.f4934c.f4915a), C1000p.m7689b(axVar.f4934c.f4915a + axVar.f4934c.f4916b));
                    }
                    if (axVar.f4933b != null) {
                        axVar.f4933b.mo1462a(axVar.f4934c);
                    }
                    e2.mo1468h().releasePage(axVar.f4934c.f4915a, ab.m7380a(c1008x.m7524h()));
                }
                if (obj == 1 && obj2 == null && axVar == null && c1008x.m5837a()) {
                    synchronized (this) {
                        if (c1008x.m7525i() == null) {
                            c1008x.a = false;
                            this.f4981l.removeFirst();
                            this.f4983n.drainPermits();
                            this.f4982m.release();
                            if (((au) this.f4981l.getFirst()).c) {
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
    /* renamed from: G */
    private void m7677G() {
        /*
        r16 = this;
        r15 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r6 = 1;
        r7 = 0;
        r3 = 0;
    L_0x0005:
        monitor-enter(r16);
        r0 = r16;
        r2 = r0.f4981l;	 Catch:{ all -> 0x003c }
        r2 = r2.size();	 Catch:{ all -> 0x003c }
        if (r2 <= r6) goto L_0x0029;
    L_0x0010:
        r5 = r6;
    L_0x0011:
        r0 = r16;
        r2 = r0.f4981l;	 Catch:{ all -> 0x003c }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003c }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.txt.C1008x) r0;	 Catch:{ all -> 0x003c }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003c }
        if (r2 == 0) goto L_0x002b;
    L_0x0021:
        monitor-exit(r16);	 Catch:{ all -> 0x003c }
        r16.m7679I();
        r16.m5953x();
    L_0x0028:
        return;
    L_0x0029:
        r5 = r7;
        goto L_0x0011;
    L_0x002b:
        monitor-exit(r16);	 Catch:{ all -> 0x003c }
        if (r3 == r4) goto L_0x027d;
    L_0x002e:
        r2 = f4978i;
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
        r2 = r4.m7523g();
        r0 = r16;
        r2 = r0.m7682a(r2);
        r0 = r16;
        r0.f4980k = r2;
        r0 = r16;
        r2 = r0.f4980k;
        if (r2 == 0) goto L_0x00a4;
    L_0x0059:
        r0 = r16;
        r2 = r0.f4980k;
        r4.f5015n = r2;
        r16.m5950u();
        r0 = r16;
        r2 = r0.f4988s;
        r2.start();
    L_0x006a:
        r0 = r16;
        r2 = r0.f4980k;
        r8 = r4.f5015n;
        r0 = r16;
        r0.f4980k = r8;
        r0 = r16;
        r3 = r0.f4980k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x008a;
    L_0x0080:
        r3 = new com.duokan.reader.domain.document.txt.t;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.C0367t.m1038a(r3);
    L_0x008a:
        r2 = r4.m7524h();
        r9 = r2.j;
        r2 = com.duokan.reader.domain.document.txt.aa.m7376c();
        r10 = r2.m7377a();
        r2 = f4978i;
        if (r2 != 0) goto L_0x00b0;
    L_0x009c:
        if (r10 != 0) goto L_0x00b0;
    L_0x009e:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00a4:
        r16.m5951v();
        goto L_0x0028;
    L_0x00a8:
        r2 = r3.f5015n;
        r4.f5015n = r2;
        goto L_0x006a;
    L_0x00b0:
        r2 = f4978i;
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
        r2 = com.duokan.reader.domain.document.C0903n.m5886a(r9, r2);
        r3 = "DEFAULT_FONT_EN";
        r3 = com.duokan.reader.domain.document.C0903n.m5886a(r9, r3);
        r11 = "CUSTOM_FONT_ZH";
        r11 = com.duokan.reader.domain.document.C0903n.m5887b(r9, r11);
        r12 = "DEFAULT_FONT_ZH";
        r12 = com.duokan.reader.domain.document.C0903n.m5887b(r9, r12);
        r13 = "FALLBACK_FONT";
        r9 = com.duokan.reader.domain.document.C0903n.m5888c(r9, r13);
        r13 = android.text.TextUtils.isEmpty(r2);
        if (r13 != 0) goto L_0x0210;
    L_0x0121:
        r10.registerFont(r2, r2);
        r13 = r8.mo1468h();
        r13.setFontFamily(r2, r7);
    L_0x012b:
        r13 = android.text.TextUtils.isEmpty(r11);
        if (r13 != 0) goto L_0x021b;
    L_0x0131:
        r10.registerFont(r11, r11);
        r13 = r8.mo1468h();
        r13.setFontFamily(r11, r15);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0148;
    L_0x0141:
        r2 = r8.mo1468h();
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
        r2 = r4.m7524h();
        r2 = r2.f;
        r3 = 2;
        r2 = java.lang.Math.max(r2, r3);
        r3 = r8.mo1468h();
        r10 = (double) r2;
        r3.setFontSize(r10);
        r2 = r4.m7524h();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x023b;
    L_0x0194:
        r2 = com.duokan.reader.domain.document.txt.aa.m7376c();
        r2 = r2.m7377a();
        r2.setUseBookStyle(r6);
    L_0x019f:
        r0 = r16;
        r0.m7683a(r4);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4986q = r2;
        r16.m5955z();
        r4.b = r6;
    L_0x01b1:
        r2 = r4.m7525i();
        if (r2 == 0) goto L_0x01da;
    L_0x01b7:
        r0 = r16;
        r0.f4985p = r6;
        r0 = r16;
        r3 = r0.f4983n;
        r3.release();
        r0 = r16;
        r0.m7684a(r2, r4);
        r0 = r16;
        r0.f4985p = r7;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4986q = r8;
        r0 = r16;
        r3 = r0.f4983n;
        r3.release();
    L_0x01da:
        if (r2 != 0) goto L_0x020d;
    L_0x01dc:
        r0 = r16;
        r2 = r0.f4983n;
        r2.release();
        r2 = r4.m7524h();
        r0 = r16;
        r3 = r0.f4984o;
        if (r2 == r3) goto L_0x026f;
    L_0x01ed:
        if (r5 != 0) goto L_0x026f;
    L_0x01ef:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r8 = r0.f4986q;
        r2 = r2 - r8;
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x026f;
    L_0x01fe:
        r0 = r16;
        r2 = r0.m7687a(r4, r6);
        if (r2 != 0) goto L_0x020d;
    L_0x0206:
        r0 = r16;
        r2 = r0.f4982m;
        r2.acquireUninterruptibly();
    L_0x020d:
        r3 = r4;
        goto L_0x0005;
    L_0x0210:
        r13 = r8.mo1468h();
        r14 = "";
        r13.setFontFamily(r14, r7);
        goto L_0x012b;
    L_0x021b:
        r2 = r8.mo1468h();
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
        r2 = com.duokan.reader.domain.document.txt.aa.m7376c();
        r2 = r2.m7377a();
        r2.setUseBookStyle(r7);
        r2 = r8.mo1468h();
        r3 = r4.m7524h();
        r10 = r3.g;
        r2.setLineGap(r10);
        r2 = r8.mo1468h();
        r3 = r4.m7524h();
        r10 = r3.h;
        r2.setParaSpacing(r10);
        r2 = r8.mo1468h();
        r3 = r4.m7524h();
        r8 = r3.i;
        r2.setFirstLineIndent(r8);
        goto L_0x019f;
    L_0x026f:
        r0 = r16;
        r2 = r0.f4982m;	 Catch:{ Exception -> 0x027b }
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

    /* renamed from: a */
    private void m7683a(au auVar) {
        if (this.f4979j != null) {
            int[][] a = this.f4979j.mo1136a(this, auVar.m7524h());
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
                auVar.f4921j = (long) a[i2][i3];
                auVar.f4922k = (i2 * 1000) + i3;
                auVar.f4920i = a;
                m7687a(auVar, false);
            }
        }
    }

    /* renamed from: a */
    private boolean m7687a(au auVar, boolean z) {
        if (f4978i || auVar != null) {
            C0987c e = auVar.mo1469e();
            if (auVar.f4921j < 0) {
                return false;
            }
            DktParserOption a = ab.m7380a(auVar.m7524h());
            int i = auVar.f4922k / 1000;
            int i2 = auVar.f4922k % 1000;
            if (auVar.f4920i[i] == null) {
                auVar.f4920i[i] = new int[1000];
                Arrays.fill(auVar.f4920i[i], -1);
            }
            auVar.f4920i[i][i2] = (int) auVar.f4921j;
            auVar.f4921j = e.mo1468h().calcNextPageOffset(a, auVar.f4921j);
            auVar.f4922k++;
            if (auVar.f4921j >= e.mo1256b() || auVar.f4921j < 0) {
                auVar.f4921j = -1;
                auVar.m5835a((long) auVar.f4922k);
                if (this.f4979j != null && z) {
                    this.f4979j.mo1133a(this, auVar.m7524h(), auVar.f4920i);
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
    private void m7684a(ax axVar, au auVar) {
        boolean z = true;
        if (!f4978i && axVar == null) {
            throw new AssertionError();
        } else if (f4978i || auVar != null) {
            C0987c e = auVar.mo1469e();
            if (!axVar.f4934c.m7499c() && !axVar.f4934c.m7500d()) {
                DktPage c;
                long j = axVar.f4932a.f4880b;
                boolean z2 = axVar.f4932a.f4881c;
                long j2 = axVar.f4932a.f4882d;
                if (axVar.f4932a.f4879a != null && axVar.f4932a.f4879a.m5777b()) {
                    j = axVar.f4932a.f4879a.mo1460n().m7539g();
                    j2 -= axVar.f4932a.f4879a.f4882d;
                } else if (f4978i || axVar.f4932a.f4879a == null || axVar.f4932a.f4879a.m7396j() == axVar.f4932a.m7396j()) {
                    z = z2;
                } else {
                    throw new AssertionError();
                }
                ad h = auVar.m7524h();
                if (axVar.f4932a.m5777b()) {
                    c = m7691c(auVar, axVar.f4932a.mo1460n().m7539g(), h);
                } else if (auVar.m5839b() >= 0) {
                    if (z) {
                        r2 = m7691c(auVar, j, h);
                    } else {
                        r2 = m7688b(auVar, j, h);
                    }
                    j2 = auVar.m7520c(j2 + auVar.m7519b(r2.getOffsetInByte()));
                    e.mo1468h().releasePage(r2);
                    c = m7691c(auVar, j2, h);
                } else {
                    if (z) {
                        r2 = m7691c(auVar, j, h);
                    } else {
                        r2 = m7688b(auVar, j, h);
                    }
                    DktPage dktPage = r2;
                    for (int i = 0; ((long) i) < Math.abs(j2); i++) {
                        if (j2 <= 0) {
                            c = m7680a(auVar, dktPage.getOffsetInByte(), h);
                            e.mo1468h().releasePage(dktPage);
                            if (c.isBeforeFirstPage()) {
                                break;
                            }
                            dktPage = c;
                        } else {
                            c = m7691c(auVar, dktPage.getOffsetInByte() + dktPage.getSizeInByte(), h);
                            e.mo1468h().releasePage(dktPage);
                            if (c.isAfterLastPage()) {
                                break;
                            }
                            dktPage = c;
                        }
                    }
                    c = dktPage;
                }
                if (f4978i || c != null) {
                    axVar.f4934c.f4915a = c.getOffsetInByte();
                    axVar.f4934c.f4916b = c.getSizeInByte();
                    axVar.f4934c.m7502f();
                    return;
                }
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private DktPage m7680a(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        C0987c e = auVar.mo1469e();
        DktParserOption a = ab.m7380a(adVar);
        if (j <= 0) {
            acquirePage = e.mo1468h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.mo1256b()) {
            acquirePage = e.mo1468h().acquirePage(e.mo1256b(), a, 0);
        } else {
            acquirePage = e.mo1468h().acquirePage(j, a, 0);
        }
        if (acquirePage == null) {
            return e.mo1468h().acquirePage(Long.MIN_VALUE, a, 2);
        }
        return acquirePage;
    }

    /* renamed from: b */
    private DktPage m7688b(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        C0987c e = auVar.mo1469e();
        DktParserOption a = ab.m7380a(adVar);
        if (j < 0) {
            acquirePage = e.mo1468h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.mo1256b()) {
            acquirePage = e.mo1468h().acquirePage(Long.MAX_VALUE, a, 2);
        } else {
            acquirePage = e.mo1468h().acquirePage(j, a, 1);
        }
        if (acquirePage == null) {
            return e.mo1468h().acquirePage(Long.MAX_VALUE, a, 2);
        }
        return acquirePage;
    }

    /* renamed from: c */
    private DktPage m7691c(au auVar, long j, ad adVar) {
        DktPage acquirePage;
        C0987c e = auVar.mo1469e();
        DktParserOption a = ab.m7380a(adVar);
        if (j < 0) {
            acquirePage = e.mo1468h().acquirePage(Long.MIN_VALUE, a, 2);
        } else if (j >= e.mo1256b()) {
            acquirePage = e.mo1468h().acquirePage(Long.MAX_VALUE, a, 2);
        } else {
            acquirePage = e.mo1468h().acquirePage(j, a, 2);
        }
        if (acquirePage == null) {
            return e.mo1468h().acquirePage(Long.MAX_VALUE, a, 2);
        }
        return acquirePage;
    }

    /* renamed from: H */
    private au m7678H() {
        au auVar;
        synchronized (this) {
            auVar = (au) this.f4981l.getLast();
            if (f4978i || auVar != null) {
            } else {
                throw new AssertionError();
            }
        }
        return auVar;
    }

    /* renamed from: a */
    private C0987c m7682a(ae aeVar) {
        if (aeVar == null) {
            m5927d(4);
            return null;
        }
        try {
            long openDocument = aa.m7376c().m7377a().openDocument(Uri.parse(aeVar.a).getPath(), ReaderEnv.get().getTempDirectory().getPath());
            if (openDocument == 0) {
                m5927d(1);
                return null;
            }
            DktBook dktBook = new DktBook(openDocument);
            if (dktBook.prepareParseContent(64) == 0) {
                return new C1006v(this, aeVar, dktBook);
            }
            m5927d(1);
            dktBook.close();
            return null;
        } catch (Throwable th) {
            m5927d(1);
            return null;
        }
    }

    /* renamed from: I */
    private void m7679I() {
        this.f4990u.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!f4978i) {
                    throw new AssertionError();
                }
            }
        } while (!this.f4990u.awaitTermination(60, TimeUnit.SECONDS));
        this.g.m6357a();
        this.f4980k.mo1261g();
    }
}
