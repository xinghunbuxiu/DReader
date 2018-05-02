package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.txt.C0939a;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.epub.h */
public class C0940h extends ar implements C0939a {
    /* renamed from: a */
    static final /* synthetic */ boolean f4682a = (!C0940h.class.desiredAssertionStatus());
    /* renamed from: b */
    private final EpubTypesettingContext f4683b;
    /* renamed from: c */
    private final ay f4684c;
    /* renamed from: d */
    private final long f4685d;
    /* renamed from: e */
    private final ay f4686e;
    /* renamed from: f */
    private ay f4687f = null;
    /* renamed from: g */
    private ay f4688g = null;
    /* renamed from: h */
    private boolean f4689h = false;
    /* renamed from: i */
    private CountDownLatch f4690i = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m6850n();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m6851o();
    }

    /* renamed from: p */
    public /* synthetic */ ak mo1433p() {
        return m6848l();
    }

    protected C0940h(EpubTypesettingContext epubTypesettingContext, ay ayVar, long j) {
        this.f4683b = epubTypesettingContext;
        this.f4684c = ayVar;
        this.f4685d = j;
        this.f4686e = new ay(this.f4683b, this.f4684c, this.f4685d);
    }

    protected C0940h(EpubTypesettingContext epubTypesettingContext, C0940h c0940h, long j) {
        this.f4683b = epubTypesettingContext;
        if (c0940h.m5777b()) {
            this.f4684c = c0940h.m6847k();
            this.f4685d = j * 2;
        } else {
            this.f4684c = c0940h.f4684c;
            this.f4685d = c0940h.f4685d + (2 * j);
        }
        this.f4686e = new ay(this.f4683b, this.f4684c, this.f4685d);
    }

    /* renamed from: j */
    protected ay m6846j() {
        return this.f4686e;
    }

    /* renamed from: k */
    public ay m6847k() {
        if (m6837q()) {
            return this.f4687f;
        }
        return null;
    }

    /* renamed from: l */
    public ay m6848l() {
        if (m6837q()) {
            return this.f4688g;
        }
        return null;
    }

    /* renamed from: m */
    protected boolean m6849m() {
        return this.f4689h;
    }

    /* renamed from: a */
    protected void m6838a(ay ayVar) {
        if (f4682a || ayVar.m5777b()) {
            if (this.f4683b.m5839b() < 0) {
                this.f4687f = ayVar;
                this.f4688g = new ay(this.f4683b, ayVar, 1);
            } else {
                C0936c k = ayVar.m6533k();
                long a = this.f4683b.m6441a(k.m6780g(), k.m6781h(), k.m6782i());
                if (a < 0 || a % 2 == 0) {
                    this.f4687f = ayVar;
                    this.f4688g = new ay(this.f4683b, ayVar, 1);
                } else {
                    this.f4687f = new ay(this.f4683b, ayVar, -1);
                    this.f4688g = ayVar;
                }
            }
            this.f4689h = true;
            synchronized (this) {
                if (this.f4690i != null) {
                    this.f4690i.countDown();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public C0936c m6850n() {
        if (m6837q()) {
            return this.f4687f.m6533k();
        }
        return null;
    }

    /* renamed from: o */
    public C0936c m6851o() {
        if (m6837q()) {
            return this.f4688g.m6534l();
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return mo1189c() ? this.f4683b.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        if (!this.f4689h || this.f4687f.mo1189c() || this.f4688g.mo1189c()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public boolean mo1191d() {
        return m5777b() && this.f4687f.mo1191d() && this.f4688g.mo1191d();
    }

    /* renamed from: e */
    public boolean mo1192e() {
        if (m6837q() && this.f4687f.mo1192e() && this.f4688g.mo1192e()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!m6836b(j)) {
            return false;
        }
        if (!this.f4687f.mo1187a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return false;
        }
        if (this.f4688g.mo1187a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: q */
    private boolean m6837q() {
        /*
        r4 = this;
        r0 = 1;
        r1 = r4.f4689h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r4);
        r1 = r4.f4689h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r4.f4690i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r4.f4690i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r4.f4689h;
        if (r0 != 0) goto L_0x003b;
    L_0x0021:
        r0 = r4.f4683b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x003b;
    L_0x0027:
        r0 = r4.f4683b;
        r0 = r0.mo1272c();
        if (r0 != 0) goto L_0x003b;
    L_0x002f:
        r0 = r4.f4690i;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r0 = r4.f4689h;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.h.q():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private boolean m6836b(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4689h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4689h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r3.f4690i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r3.f4690i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r3.f4690i;	 Catch:{ InterruptedException -> 0x0039 }
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r4, r1);	 Catch:{ InterruptedException -> 0x0039 }
    L_0x0024:
        r0 = r3.f4689h;
        if (r0 != 0) goto L_0x0036;
    L_0x0028:
        r0 = r3.f4683b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0 = r3.f4683b;
        r0 = r0.mo1272c();
        if (r0 == 0) goto L_0x001d;
    L_0x0036:
        r0 = r3.f4689h;
        goto L_0x0005;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.h.b(long):boolean");
    }
}
