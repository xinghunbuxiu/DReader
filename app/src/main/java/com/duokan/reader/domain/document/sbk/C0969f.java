package com.duokan.reader.domain.document.sbk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.C0366o;
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
import com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState;
import java.lang.Thread.State;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.sbk.f */
public class C0969f extends C0903n implements at {
    /* renamed from: i */
    static final /* synthetic */ boolean f4808i = (!C0969f.class.desiredAssertionStatus());
    /* renamed from: j */
    private final C0819n f4809j;
    /* renamed from: k */
    private C0966c f4810k = null;
    /* renamed from: l */
    private final LinkedList<SbkTypesettingContext> f4811l = new LinkedList();
    /* renamed from: m */
    private final Semaphore f4812m = new Semaphore(0);
    /* renamed from: n */
    private final Semaphore f4813n = new Semaphore(0);
    /* renamed from: o */
    private final C0977p f4814o;
    /* renamed from: p */
    private boolean f4815p = false;
    /* renamed from: q */
    private long f4816q = 0;
    /* renamed from: r */
    private final Thread f4817r;
    /* renamed from: s */
    private final Thread f4818s;
    /* renamed from: t */
    private C0981w f4819t;
    /* renamed from: u */
    private final ExecutorService f4820u = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public /* synthetic */ ak mo1213a(long j) {
        return m7215e(j);
    }

    /* renamed from: f */
    public /* synthetic */ ak mo1237f(ak akVar) {
        return m7227k(akVar);
    }

    /* renamed from: g */
    public /* synthetic */ ak mo1239g(ak akVar) {
        return m7229l(akVar);
    }

    /* renamed from: h */
    public /* synthetic */ C0911h mo1240h() {
        return m7181D();
    }

    /* renamed from: l */
    public /* synthetic */ C0923m mo1246l() {
        return m7182E();
    }

    /* renamed from: q */
    public /* synthetic */ av mo1248q() {
        return m7183F();
    }

    public C0969f(C0819n c0819n) {
        WebLog.init().w(m5889A());
        this.f4809j = c0819n;
        this.f4814o = new C0977p();
        this.f4819t = new C0981w();
        this.f4817r = new Thread(new C0970g(this));
        this.f4818s = new Thread(new C0971h(this));
    }

    /* renamed from: B */
    public C0823q m7179B() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return null;
        }
        C0919l c = this.f4810k.mo1257c();
        return c instanceof C0978s ? ((C0978s) c).f4841b : null;
    }

    /* renamed from: C */
    public int m7180C() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4810k.mo1451h();
        }
        return 0;
    }

    /* renamed from: b */
    public String m7200b(long j) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return "";
        }
        C0822a a = this.f4810k.mo1449a(j);
        return a != null ? a.mo1124c() : "";
    }

    /* renamed from: c */
    public long m7204c(long j) {
        WebLog.init().w(m5889A());
        if (m7180C() <= 0) {
            return 0;
        }
        long b = m7171b(m7159I(), j);
        if (b < 0) {
            return 0;
        }
        return b;
    }

    /* renamed from: d */
    public boolean m7211d(long j) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return true;
        }
        C0822a a = this.f4810k.mo1449a(j);
        if (a == null) {
            return false;
        }
        return a.mo1122a();
    }

    /* renamed from: a */
    public static C0965b m7162a(long j, long j2, long j3) {
        return new C0965b(j, j2, j3);
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
        long b;
        WebLog.init().w(m5889A());
        synchronized (this) {
            SbkTypesettingContext sbkTypesettingContext = (SbkTypesettingContext) this.f4811l.getLast();
            if (f4808i || sbkTypesettingContext != null) {
                b = sbkTypesettingContext.m5839b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    /* renamed from: f */
    public int mo1236f() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return -1;
        }
        return 0;
    }

    /* renamed from: g */
    public float mo1238g() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return 0.0f;
        }
        SbkTypesettingContext I = m7159I();
        C0966c e = I.mo1453e();
        if (e != null) {
            return (((float) I.f4770k) / ((float) e.mo1451h())) * 100.0f;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public boolean mo1448b() {
        WebLog.init().w(m5889A());
        return this.a;
    }

    /* renamed from: D */
    public C0968e m7181D() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return (C0968e) this.f4810k.mo1258d();
        }
        return null;
    }

    /* renamed from: i */
    public boolean mo1242i() {
        boolean z = true;
        WebLog.init().w(m5889A());
        synchronized (this) {
            if (this.f4811l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: j */
    public boolean mo1244j() {
        WebLog.init().w(m5889A());
        return m7159I().mo1272c();
    }

    /* renamed from: k */
    public C0917k mo1245k() {
        C0917k g;
        WebLog.init().w(m5889A());
        synchronized (this) {
            SbkTypesettingContext sbkTypesettingContext = (SbkTypesettingContext) this.f4811l.getLast();
            if (f4808i || sbkTypesettingContext != null) {
                g = sbkTypesettingContext.m7107g();
            } else {
                throw new AssertionError();
            }
        }
        return g;
    }

    /* renamed from: a */
    public void mo1218a(C0917k c0917k) {
        WebLog.init().w(m5889A());
        if (f4808i || c0917k != null) {
            synchronized (this) {
                SbkTypesettingContext I = m7159I();
                if (!I.m7107g().equals(c0917k)) {
                    this.f4811l.addLast(new C0976m(this, I.m7106f(), new C0977p((C0977p) c0917k), this.f4812m));
                }
            }
            this.f4812m.release();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: E */
    public C0981w m7182E() {
        WebLog.init().w(m5889A());
        return this.f4819t;
    }

    /* renamed from: a */
    public void mo1220a(C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4808i || c0923m != null) {
            this.f4819t = (C0981w) c0923m;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public C0908f mo1247m() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4810k.mo1259e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo1219a(C0919l c0919l) {
        WebLog.init().m762a(this.a);
        if (!this.a) {
            if (this.f4817r.getState() == State.NEW) {
                this.f4811l.addLast(new C0976m(this, (C0978s) c0919l, this.f4814o, this.f4812m));
                this.f4817r.start();
                return;
            }
            synchronized (this) {
                this.f4811l.addLast(new C0976m(this, (C0978s) c0919l, m7159I().m7107g(), this.f4812m));
            }
            this.f4812m.release();
        }
    }

    /* renamed from: j */
    public float m7224j(ak akVar) {
        WebLog.init().w(m5889A());
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return 0.0f;
        }
        C0966c c0966c = this.f4810k;
        C0965b c0965b = (C0965b) akVar.mo1198g();
        long g = c0965b.m7141g();
        long h = (long) c0966c.mo1451h();
        float f = 1.0f / ((float) h);
        float max = ((float) Math.max(0, g - 1)) / ((float) h);
        C0822a a = c0966c.mo1449a(g);
        g = (a == null || a.mo1122a()) ? 1 : (long) a.mo1123b();
        return (Math.max(0.0f, Math.min(g == 0 ? 1.0f : ((float) (c0965b.m7142h() + 1)) / ((float) g), 1.0f)) * f) + max;
    }

    /* renamed from: b */
    public long mo1223b(ak akVar) {
        WebLog.init().w(m5889A());
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return -1;
        }
        C0965b c0965b = (C0965b) akVar.mo1198g();
        SbkTypesettingContext I = m7159I();
        if (f4808i || I != null) {
            return I.m7100a(c0965b.m7141g(), c0965b.m7142h(), c0965b.m7143i());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public long mo1209a(av avVar) {
        C0965b c0965b = (C0965b) avVar;
        SbkTypesettingContext I = m7159I();
        if (f4808i || I != null) {
            return I.m7100a(c0965b.m7141g(), c0965b.m7142h(), c0965b.m7143i());
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

    /* renamed from: F */
    public C0965b m7183F() {
        WebLog.init().w(m5889A());
        return C0969f.m7162a(0, 0, 0);
    }

    /* renamed from: d */
    public ak mo1232d(ak akVar) {
        WebLog.init().w(m5889A());
        return null;
    }

    /* renamed from: r */
    public ak mo1249r() {
        WebLog.init().w(m5889A());
        return mo1230c(C0969f.m7162a((long) (mo1236f() - 1), 0, 0));
    }

    /* renamed from: c */
    public C0896a mo1229c(C0896a c0896a) {
        WebLog.init().w(m5889A());
        return c0896a;
    }

    /* renamed from: a */
    public bb mo1216a(C0897d c0897d, C0897d c0897d2) {
        WebLog.init().w(m5889A());
        return new ah((C0965b) c0897d, (C0965b) c0897d2);
    }

    /* renamed from: s */
    public bb mo1250s() {
        WebLog.init().w(m5889A());
        return new ah();
    }

    /* renamed from: e */
    public C0982x m7215e(long j) {
        WebLog.init().w(m5889A());
        return new C0982x(m7159I(), 0, 0, 0, j);
    }

    /* renamed from: c */
    public ak mo1230c(av avVar) {
        WebLog.init().w(m5889A());
        SbkTypesettingContext I = m7159I();
        C0965b c0965b = (C0965b) avVar;
        if (f4808i || c0965b != null) {
            return new C0982x(I, c0965b.m7141g(), c0965b.m7142h(), c0965b.m7143i(), 0);
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    public ak mo1235e(ak akVar) {
        WebLog.init().w(m5889A());
        if (!f4808i && (akVar == null || !akVar.mo1186a())) {
            throw new AssertionError();
        } else if (akVar instanceof C0982x) {
            return mo1214a((C0982x) akVar, 0);
        } else {
            return null;
        }
    }

    /* renamed from: k */
    public C0979t m7227k(ak akVar) {
        WebLog.init().w(m5889A());
        return (C0979t) mo1214a(akVar, 1);
    }

    /* renamed from: l */
    public C0979t m7229l(ak akVar) {
        WebLog.init().w(m5889A());
        return (C0979t) mo1214a(akVar, -1);
    }

    /* renamed from: a */
    public ak mo1214a(ak akVar, int i) {
        WebLog.init().w(m5889A());
        if (f4808i || (akVar != null && akVar.mo1186a())) {
            SbkTypesettingContext I = m7159I();
            if (!(akVar instanceof C0982x)) {
                return null;
            }
            C0896a c0896a = (C0982x) akVar;
            SbkTypesettingContext l = c0896a.m7281l();
            if (c0896a.m5777b() || l == I || mo1233d(c0896a)) {
                return new C0982x(I, c0896a, (long) i);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public boolean mo1241h(ak akVar) {
        WebLog.init().w(m5889A());
        if (!(akVar instanceof C0982x)) {
            return false;
        }
        C0896a c0896a = (C0982x) akVar;
        if (c0896a.m5777b()) {
            if (c0896a.mo1454j().m7141g() == 0 && m7161a((C0982x) c0896a) == 0) {
                return true;
            }
            return false;
        } else if (mo1233d(c0896a) && c0896a.mo1192e() && mo1241h(c0896a)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: i */
    public boolean mo1243i(ak akVar) {
        WebLog.init().w(m5889A());
        if (!(akVar instanceof C0982x)) {
            return false;
        }
        C0896a c0896a = (C0982x) akVar;
        if (c0896a.m5777b()) {
            long g = c0896a.mo1454j().m7141g();
            if (g == ((long) (m7180C() - 1)) && m7161a((C0982x) c0896a) == c0896a.m7281l().m7103b(g) - 1) {
                return true;
            }
            return false;
        } else if (mo1233d(c0896a) && c0896a.mo1192e() && mo1243i(c0896a)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: d */
    public boolean mo1233d(C0896a c0896a) {
        WebLog.init().w(m5889A());
        if (!f4808i && c0896a == null) {
            throw new AssertionError();
        } else if (!f4808i && !c0896a.mo1186a()) {
            throw new AssertionError();
        } else if (!c0896a.mo1186a()) {
            return false;
        } else {
            if (c0896a.m5777b()) {
                return true;
            }
            if (c0896a instanceof C0982x) {
                C0982x c0982x = (C0982x) c0896a;
                SbkTypesettingContext l = c0982x.m7281l();
                synchronized (this) {
                    if (l.a) {
                        l.m7101a(c0982x, null);
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
        if (f4808i || akVar != null) {
            C0981w E = c0923m == null ? m7182E() : (C0981w) c0923m;
            mo1233d((C0896a) akVar);
            SbkTypesettingContext I = m7159I();
            if (akVar instanceof C0982x) {
                return new C0983y(I, (C0982x) akVar, E, this.g, this);
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
        return new aa(str);
    }

    /* renamed from: a */
    public aa mo1211a(aa aaVar, int i) {
        WebLog.init().w(m5889A());
        return new aa(aaVar.f4314a);
    }

    /* renamed from: a */
    public C1012y mo1217a(String str) {
        return null;
    }

    /* renamed from: t */
    protected void mo1251t() {
        synchronized (this) {
            SbkTypesettingContext c0976m = new C0976m(this, m7159I().m7106f(), new C0977p(), this.f4812m);
            c0976m.c = true;
            this.f4811l.add(c0976m);
        }
        this.f4812m.release();
    }

    /* renamed from: a */
    private String m7164a(SbkTypesettingContext sbkTypesettingContext) {
        C0823q c0823q = sbkTypesettingContext.m7106f().f4841b;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c0823q.mo1127a(); i++) {
            C0822a a = c0823q.mo1129a(i);
            stringBuilder.append(a.mo1122a() ? "" : a.mo1126e()).append(';');
        }
        return C0366o.m1034b(stringBuilder.toString(), "md5");
    }

    /* renamed from: G */
    private void m7157G() {
        while (true) {
            Object obj;
            try {
                if (this.f4815p) {
                    this.f4813n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.f4813n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!f4808i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                C0976m c0976m = (C0976m) this.f4811l.getFirst();
                if (this.f4811l.size() > 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (c0976m.b) {
                ai aiVar;
                c0976m.mo1453e();
                synchronized (c0976m) {
                    Iterator it = c0976m.l.iterator();
                    while (it.hasNext()) {
                        ai aiVar2 = (ai) it.next();
                        if (!f4808i && aiVar2 == null) {
                            throw new AssertionError();
                        } else if (!f4808i && aiVar2.f4795c == null) {
                            throw new AssertionError();
                        } else if (!aiVar2.f4795c.m7114a()) {
                            aiVar = null;
                            break;
                        } else if (aiVar2.f4795c.m7116c()) {
                            it.remove();
                            if (aiVar2.f4794b != null) {
                                aiVar2.f4794b.mo1458b(aiVar2.f4795c);
                            }
                        } else if (aiVar2.f4795c.m7115b()) {
                            it.remove();
                            aiVar = aiVar2;
                            break;
                        }
                    }
                    aiVar = null;
                    Object obj2;
                    if (c0976m.l.size() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                }
                if (aiVar != null) {
                    if (aiVar.f4793a.mo1189c()) {
                        aiVar.f4793a.m7272a(C0969f.m7162a(aiVar.f4795c.f4780a, aiVar.f4795c.f4781b, aiVar.f4795c.f4782c), C0969f.m7162a(aiVar.f4795c.f4783d, aiVar.f4795c.f4784e, aiVar.f4795c.f4785f));
                    }
                    if (aiVar.f4794b != null) {
                        aiVar.f4794b.mo1457a(aiVar.f4795c);
                    }
                }
                if (obj == 1 && obj2 == null && aiVar == null && c0976m.m5837a()) {
                    synchronized (this) {
                        if (c0976m.m7108h() == null) {
                            c0976m.a = false;
                            this.f4811l.removeFirst();
                            this.f4813n.drainPermits();
                            this.f4812m.release();
                            if (((SbkTypesettingContext) this.f4811l.getFirst()).c) {
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
    /* renamed from: H */
    private void m7158H() {
        /*
        r14 = this;
        r8 = 0;
        r3 = 0;
        r7 = 1;
        r5 = r3;
    L_0x0004:
        monitor-enter(r14);
        r2 = r14.f4811l;	 Catch:{ all -> 0x0037 }
        r2 = r2.size();	 Catch:{ all -> 0x0037 }
        if (r2 <= r7) goto L_0x0024;
    L_0x000d:
        r6 = r7;
    L_0x000e:
        r2 = r14.f4811l;	 Catch:{ all -> 0x0037 }
        r2 = r2.getFirst();	 Catch:{ all -> 0x0037 }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.sbk.C0976m) r0;	 Catch:{ all -> 0x0037 }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x0037 }
        if (r2 == 0) goto L_0x0026;
    L_0x001c:
        monitor-exit(r14);	 Catch:{ all -> 0x0037 }
        r14.m7160J();
        r14.m5953x();
    L_0x0023:
        return;
    L_0x0024:
        r6 = r8;
        goto L_0x000e;
    L_0x0026:
        monitor-exit(r14);	 Catch:{ all -> 0x0037 }
        if (r5 == r4) goto L_0x0181;
    L_0x0029:
        r2 = f4808i;
        if (r2 != 0) goto L_0x003a;
    L_0x002d:
        r2 = r4.b;
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
        r5.b = r8;
    L_0x003e:
        r2 = r4.m7106f();
        if (r2 != 0) goto L_0x0050;
    L_0x0044:
        r9 = r14.f4809j;
        if (r5 != 0) goto L_0x00f8;
    L_0x0048:
        r2 = r3;
    L_0x0049:
        r2 = r9.mo1118a(r14, r2);
        r4.m7102a(r2);
    L_0x0050:
        if (r5 != 0) goto L_0x0103;
    L_0x0052:
        r2 = r4.m7106f();
        r2 = r14.m7163a(r2);
        r14.f4810k = r2;
        r2 = r14.f4810k;
        if (r2 == 0) goto L_0x00fe;
    L_0x0060:
        r2 = r14.f4810k;
        r4.f4838n = r2;
        r14.m5950u();
        r2 = r3;
        r2 = (long[][]) r2;
        r9 = r14.f4818s;
        r9.start();
    L_0x0070:
        r9 = r14.f4810k;
        r10 = r4.f4838n;
        r14.f4810k = r10;
        r11 = r14.f4810k;
        r11 = r9.equals(r11);
        if (r11 != 0) goto L_0x0088;
    L_0x0080:
        r11 = new com.duokan.reader.domain.document.sbk.i;
        r11.<init>(r14, r9);
        com.duokan.core.sys.C0367t.m1038a(r11);
    L_0x0088:
        r9 = r10.mo1451h();
        r9 = new long[r9][];
        r4.i = r9;
        r9 = r10.mo1451h();
        r9 = new com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState[r9];
        r4.j = r9;
        r9 = r4.j;
        r10 = com.duokan.reader.domain.document.sbk.SbkTypesettingContext.ChapterState.NOT_TYPESETTED;
        java.util.Arrays.fill(r9, r10);
        if (r2 != 0) goto L_0x016f;
    L_0x00a1:
        r14.m7166a(r4, r5);
        r10 = java.lang.System.currentTimeMillis();
        r14.f4816q = r10;
    L_0x00aa:
        r14.m5955z();
        r4.b = r7;
    L_0x00af:
        r2 = r4.m7108h();
        if (r2 == 0) goto L_0x00cc;
    L_0x00b5:
        r14.f4815p = r7;
        r5 = r14.f4813n;
        r5.release();
        r14.m7167a(r2, r4);
        r14.f4815p = r8;
        r10 = java.lang.System.currentTimeMillis();
        r14.f4816q = r10;
        r5 = r14.f4813n;
        r5.release();
    L_0x00cc:
        if (r2 != 0) goto L_0x00f5;
    L_0x00ce:
        r2 = r14.f4813n;
        r2.release();
        r2 = r4.m7107g();
        r5 = r14.f4814o;
        if (r2 == r5) goto L_0x0173;
    L_0x00db:
        if (r6 != 0) goto L_0x0173;
    L_0x00dd:
        r10 = java.lang.System.currentTimeMillis();
        r12 = r14.f4816q;
        r10 = r10 - r12;
        r12 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 <= 0) goto L_0x0173;
    L_0x00ea:
        r2 = r14.m7169a(r4, r7);
        if (r2 != 0) goto L_0x00f5;
    L_0x00f0:
        r2 = r14.f4812m;
        r2.acquireUninterruptibly();
    L_0x00f5:
        r5 = r4;
        goto L_0x0004;
    L_0x00f8:
        r2 = r5.m7106f();
        goto L_0x0049;
    L_0x00fe:
        r14.m5951v();
        goto L_0x0023;
    L_0x0103:
        r2 = r4.m7107g();
        r9 = r5.m7107g();
        if (r2 != r9) goto L_0x0163;
    L_0x010d:
        r2 = r5.f4838n;
        r2 = (com.duokan.reader.domain.document.sbk.C0974k) r2;
        r2 = r2.f4830d;
        r9 = r4.m7106f();
        r9 = r9.f4841b;
        r2 = r9.mo1128a(r2);
        r9 = 2;
        if (r2 != r9) goto L_0x0143;
    L_0x0124:
        r2 = r4.m7106f();
        r2 = r14.m7163a(r2);
        if (r2 == 0) goto L_0x0136;
    L_0x012e:
        r4.f4838n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x0136:
        r2 = r5.f4838n;
        r4.f4838n = r2;
        r2 = r5.m7109i();
        goto L_0x0070;
    L_0x0143:
        if (r2 != r7) goto L_0x0157;
    L_0x0145:
        r2 = new com.duokan.reader.domain.document.sbk.k;
        r9 = r4.m7106f();
        r2.<init>(r14, r9);
        r4.f4838n = r2;
        r2 = r5.m7109i();
        goto L_0x0070;
    L_0x0157:
        r2 = r5.f4838n;
        r4.f4838n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x0163:
        r2 = r5.f4838n;
        r4.f4838n = r2;
        r2 = r3;
        r2 = (long[][]) r2;
        goto L_0x0070;
    L_0x016f:
        r4.i = r2;
        goto L_0x00aa;
    L_0x0173:
        r2 = r14.f4812m;	 Catch:{ Exception -> 0x017e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.sbk.f.H():void");
    }

    /* renamed from: a */
    private void m7166a(SbkTypesettingContext sbkTypesettingContext, SbkTypesettingContext sbkTypesettingContext2) {
        long[][] jArr = (long[][]) null;
        if (this.f4809j != null) {
            jArr = this.f4809j.mo1120a(this, m7164a(sbkTypesettingContext), sbkTypesettingContext.m7107g());
        }
        if (jArr != null) {
            sbkTypesettingContext.f4768i = jArr;
            m7169a(sbkTypesettingContext, false);
        }
    }

    /* renamed from: a */
    private boolean m7169a(SbkTypesettingContext sbkTypesettingContext, boolean z) {
        if (f4808i || sbkTypesettingContext != null) {
            C0966c e = sbkTypesettingContext.mo1453e();
            if (!f4808i && e.mo1451h() < 0) {
                throw new AssertionError();
            } else if (sbkTypesettingContext.f4770k == ((long) e.mo1451h())) {
                return false;
            } else {
                long h = (long) (e.mo1451h() - 1);
                while (h >= 0) {
                    if (m7171b(sbkTypesettingContext, h) < 0 && (h == 0 || m7171b(sbkTypesettingContext, h - 1) >= 0)) {
                        m7165a(sbkTypesettingContext, h);
                        break;
                    }
                    h--;
                }
                long j = 0;
                for (h = 0; h < ((long) e.mo1451h()); h++) {
                    if (m7171b(sbkTypesettingContext, h) >= 0) {
                        j++;
                    }
                }
                sbkTypesettingContext.f4770k = j;
                if (sbkTypesettingContext.f4770k == ((long) e.mo1451h())) {
                    m7173b(sbkTypesettingContext);
                    if (this.f4809j != null && z) {
                        this.f4809j.mo1119a(this, m7164a(sbkTypesettingContext), sbkTypesettingContext.m7107g(), sbkTypesettingContext.f4768i);
                    }
                    m5954y();
                    return false;
                }
                m5954y();
                return true;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m7167a(ai aiVar, SbkTypesettingContext sbkTypesettingContext) {
        if (!f4808i && aiVar == null) {
            throw new AssertionError();
        } else if (f4808i || sbkTypesettingContext != null) {
            C0974k c0974k = (C0974k) sbkTypesettingContext.mo1453e();
            if (!aiVar.f4795c.m7115b() && !aiVar.f4795c.m7116c()) {
                long j = aiVar.f4793a.f4844b;
                long j2 = aiVar.f4793a.f4845c;
                long j3 = aiVar.f4793a.f4846d;
                long j4 = aiVar.f4793a.f4847e;
                if (aiVar.f4793a.f4843a == null || !aiVar.f4793a.f4843a.m5777b()) {
                    WebLog c = WebLog.init();
                    boolean z = aiVar.f4793a.f4843a == null || aiVar.f4793a.f4843a.m7281l() == aiVar.f4793a.m7281l();
                    c.w(z);
                } else {
                    C0965b j5 = aiVar.f4793a.f4843a.mo1454j();
                    j = j5.m7141g();
                    j2 = j5.m7142h();
                    j4 -= aiVar.f4793a.f4843a.f4847e;
                }
                long[] a = m7170a(sbkTypesettingContext, j, j2, j3, j4);
                m7165a(sbkTypesettingContext, a[0]);
                aiVar.f4795c.f4780a = a[0];
                aiVar.f4795c.f4781b = a[1];
                aiVar.f4795c.f4782c = a[2];
                aiVar.f4795c.f4783d = aiVar.f4795c.f4780a;
                if (aiVar.f4795c.f4780a < 0 || aiVar.f4795c.f4780a >= ((long) c0974k.mo1451h())) {
                    aiVar.f4795c.f4784e = 0;
                    aiVar.f4795c.f4785f = 0;
                } else {
                    aiVar.f4795c.f4784e = aiVar.f4795c.f4781b + 1;
                    aiVar.f4795c.f4785f = 0;
                }
                C0824v a2 = c0974k.m7240a(aiVar.f4795c.f4780a, aiVar.f4795c.f4781b);
                if (!sbkTypesettingContext.m5844d()) {
                    aiVar.f4795c.f4788i = sbkTypesettingContext.m7107g().a;
                    aiVar.f4795c.f4789j = sbkTypesettingContext.m7107g().b;
                } else if (a2 != null) {
                    int i = sbkTypesettingContext.m7107g().a;
                    int f = (int) (((float) a2.mo1132f()) * (((float) i) / ((float) a2.mo1131b())));
                    aiVar.f4795c.f4788i = i;
                    aiVar.f4795c.f4789j = f;
                } else {
                    aiVar.f4795c.f4788i = sbkTypesettingContext.m7107g().a;
                    aiVar.f4795c.f4789j = sbkTypesettingContext.m7107g().b;
                }
                aiVar.f4795c.m7118e();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m7165a(SbkTypesettingContext sbkTypesettingContext, long j) {
        C0966c e = sbkTypesettingContext.mo1453e();
        if (j >= 0 && j < ((long) e.mo1451h()) && sbkTypesettingContext.f4769j[(int) j] != ChapterState.TYPESETTED) {
            sbkTypesettingContext.f4769j[(int) j] = ChapterState.TYPESETTING;
            C0822a a = e.mo1449a(j);
            LinkedList linkedList = new LinkedList();
            while (true) {
                if (linkedList.isEmpty()) {
                    linkedList.push(new long[]{j, 0, 0});
                }
                if (!a.mo1122a()) {
                    long[] jArr = (long[]) linkedList.getLast();
                    Object a2 = m7170a(sbkTypesettingContext, jArr[0], jArr[1], jArr[2], 1);
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
            sbkTypesettingContext.f4768i[(int) j] = jArr2;
            sbkTypesettingContext.f4769j[(int) j] = ChapterState.TYPESETTED;
            m7173b(sbkTypesettingContext);
        }
    }

    /* renamed from: b */
    private boolean m7173b(SbkTypesettingContext sbkTypesettingContext) {
        C0966c e = sbkTypesettingContext.mo1453e();
        long b = sbkTypesettingContext.m5839b();
        int i = 0;
        for (long j = 0; j < ((long) e.mo1451h()); j++) {
            long b2 = m7171b(sbkTypesettingContext, j);
            if (b2 < 0) {
                return false;
            }
            i = (int) (b2 + ((long) i));
        }
        if (b == ((long) i)) {
            return false;
        }
        sbkTypesettingContext.m5835a((long) i);
        m5955z();
        return true;
    }

    /* renamed from: b */
    private long m7171b(SbkTypesettingContext sbkTypesettingContext, long j) {
        return sbkTypesettingContext.m7103b(j);
    }

    /* renamed from: a */
    private long[] m7170a(SbkTypesettingContext sbkTypesettingContext, long j, long j2, long j3, long j4) {
        C0966c e = sbkTypesettingContext.mo1453e();
        for (int i = 0; ((long) i) < Math.abs(j4); i++) {
            long j5;
            if (j < 0 || j >= ((long) e.mo1451h())) {
                j5 = 1;
            } else {
                j5 = (long) Math.max(e.mo1449a(j).mo1123b(), 1);
            }
            long j6 = j - 1;
            if (j6 < 0 || j6 >= ((long) e.mo1451h())) {
                j6 = 1;
            } else {
                j6 = (long) Math.max(e.mo1449a(j6).mo1123b(), 1);
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
        } else if (j >= ((long) e.mo1451h())) {
            j = (long) e.mo1451h();
            j2 = 0;
        }
        return new long[]{j, j2, 0};
    }

    /* renamed from: I */
    private SbkTypesettingContext m7159I() {
        SbkTypesettingContext sbkTypesettingContext;
        synchronized (this) {
            sbkTypesettingContext = (SbkTypesettingContext) this.f4811l.getLast();
            if (f4808i || sbkTypesettingContext != null) {
            } else {
                throw new AssertionError();
            }
        }
        return sbkTypesettingContext;
    }

    /* renamed from: a */
    private C0966c m7163a(C0978s c0978s) {
        if (c0978s != null) {
            return new C0974k(this, c0978s);
        }
        m5927d(4);
        return null;
    }

    /* renamed from: J */
    private void m7160J() {
        this.f4820u.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!f4808i) {
                    throw new AssertionError();
                }
            }
        } while (!this.f4820u.awaitTermination(60, TimeUnit.SECONDS));
        this.g.m6357a();
        this.f4810k.mo1261g();
    }

    /* renamed from: a */
    private long m7161a(C0982x c0982x) {
        WebLog.init().w(c0982x.m5777b());
        C0965b j = c0982x.mo1454j();
        return c0982x.m7281l().m7104b(j.m7141g(), j.m7142h(), j.m7143i());
    }
}
