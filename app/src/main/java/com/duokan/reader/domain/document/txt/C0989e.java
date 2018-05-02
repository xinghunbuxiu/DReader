package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.txt.e */
public class C0989e extends af implements C0939a {
    /* renamed from: a */
    static final /* synthetic */ boolean f4943a = (!C0989e.class.desiredAssertionStatus());
    /* renamed from: b */
    private final au f4944b;
    /* renamed from: c */
    private final ai f4945c;
    /* renamed from: d */
    private final long f4946d;
    /* renamed from: e */
    private final ai f4947e;
    /* renamed from: f */
    private ai f4948f = null;
    /* renamed from: g */
    private ai f4949g = null;
    /* renamed from: h */
    private boolean f4950h = false;
    /* renamed from: i */
    private CountDownLatch f4951i = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return mo1460n();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return mo1461o();
    }

    /* renamed from: p */
    public /* synthetic */ ak mo1433p() {
        return m7562l();
    }

    protected C0989e(au auVar, ai aiVar, long j) {
        this.f4944b = auVar;
        this.f4945c = aiVar;
        this.f4946d = j;
        this.f4947e = new ai(this.f4944b, this.f4945c, this.f4946d);
    }

    protected C0989e(au auVar, C0989e c0989e, long j) {
        this.f4944b = auVar;
        if (c0989e.m5777b()) {
            this.f4945c = c0989e.m7561k();
            this.f4946d = j * 2;
        } else {
            this.f4945c = c0989e.f4945c;
            this.f4946d = c0989e.f4946d + (2 * j);
        }
        this.f4947e = new ai(this.f4944b, this.f4945c, this.f4946d);
    }

    /* renamed from: j */
    protected ai m7560j() {
        return this.f4947e;
    }

    /* renamed from: k */
    public ai m7561k() {
        if (m7551q()) {
            return this.f4948f;
        }
        return null;
    }

    /* renamed from: l */
    public ai m7562l() {
        if (m7551q()) {
            return this.f4949g;
        }
        return null;
    }

    /* renamed from: m */
    protected boolean m7563m() {
        return this.f4950h;
    }

    /* renamed from: a */
    protected void m7552a(ai aiVar) {
        if (f4943a || aiVar.m5777b()) {
            if (this.f4944b.m5839b() < 0) {
                this.f4948f = aiVar;
                this.f4949g = new ai(this.f4944b, aiVar, 1);
            } else {
                long b = this.f4944b.m7519b(aiVar.mo1460n().m7539g());
                if (b < 0 || b % 2 == 0) {
                    this.f4948f = aiVar;
                    this.f4949g = new ai(this.f4944b, aiVar, 1);
                } else {
                    this.f4948f = new ai(this.f4944b, aiVar, -1);
                    this.f4949g = aiVar;
                }
            }
            this.f4950h = true;
            synchronized (this) {
                if (this.f4951i != null) {
                    this.f4951i.countDown();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public C0986b mo1460n() {
        if (m7551q()) {
            return this.f4948f.mo1460n();
        }
        return null;
    }

    /* renamed from: o */
    public C0986b mo1461o() {
        if (m7551q()) {
            return this.f4949g.mo1461o();
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return mo1189c() ? this.f4944b.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        if (!this.f4950h || this.f4948f.mo1189c() || this.f4949g.mo1189c()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public boolean mo1191d() {
        return m5777b() && this.f4948f.mo1191d() && this.f4949g.mo1191d();
    }

    /* renamed from: e */
    public boolean mo1192e() {
        if (m7551q() && this.f4948f.mo1192e() && this.f4949g.mo1192e()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!m7550b(j)) {
            return false;
        }
        if (!this.f4948f.mo1187a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return false;
        }
        if (this.f4949g.mo1187a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: q */
    private boolean m7551q() {
        /*
        r4 = this;
        r0 = 1;
        r1 = r4.f4950h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r4);
        r1 = r4.f4950h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r4.f4951i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r4.f4951i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r4.f4950h;
        if (r0 != 0) goto L_0x003b;
    L_0x0021:
        r0 = r4.f4944b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x003b;
    L_0x0027:
        r0 = r4.f4944b;
        r0 = r0.mo1272c();
        if (r0 != 0) goto L_0x003b;
    L_0x002f:
        r0 = r4.f4951i;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r0 = r4.f4950h;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.e.q():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private boolean m7550b(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4950h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4950h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r3.f4951i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r3.f4951i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r3.f4951i;	 Catch:{ InterruptedException -> 0x0039 }
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r4, r1);	 Catch:{ InterruptedException -> 0x0039 }
    L_0x0024:
        r0 = r3.f4950h;
        if (r0 != 0) goto L_0x0036;
    L_0x0028:
        r0 = r3.f4944b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0 = r3.f4944b;
        r0 = r0.mo1272c();
        if (r0 == 0) goto L_0x001d;
    L_0x0036:
        r0 = r3.f4950h;
        goto L_0x0005;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.e.b(long):boolean");
    }
}
