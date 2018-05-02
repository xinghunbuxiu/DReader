package com.duokan.reader.domain.document.p045a;

import com.duokan.reader.domain.document.av;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.a.v */
public class C0925v extends C0921s {
    /* renamed from: g */
    static final /* synthetic */ boolean f4369g = (!C0925v.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final C0925v f4370a;
    /* renamed from: b */
    protected final long f4371b;
    /* renamed from: c */
    protected final long f4372c;
    /* renamed from: d */
    protected final long f4373d;
    /* renamed from: e */
    protected final boolean f4374e;
    /* renamed from: f */
    protected final long f4375f;
    /* renamed from: h */
    private final ah f4376h;
    /* renamed from: i */
    private boolean f4377i = true;
    /* renamed from: j */
    private C0898a f4378j = null;
    /* renamed from: k */
    private C0898a f4379k = null;
    /* renamed from: l */
    private CountDownLatch f4380l = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return mo1278j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return mo1279k();
    }

    protected C0925v(ah ahVar, C0925v c0925v, long j) {
        if (!f4369g && ahVar == null) {
            throw new AssertionError();
        } else if (f4369g || c0925v != null) {
            this.f4376h = ahVar;
            if (c0925v.m5777b()) {
                this.f4370a = null;
                this.f4371b = c0925v.mo1278j().m5795g();
                this.f4372c = c0925v.mo1278j().m5796h();
                this.f4373d = c0925v.mo1278j().m5797i();
                this.f4374e = true;
                this.f4375f = j;
                return;
            }
            this.f4370a = c0925v;
            this.f4371b = this.f4370a.f4371b;
            this.f4372c = this.f4370a.f4372c;
            this.f4373d = this.f4370a.f4373d;
            this.f4374e = this.f4370a.f4374e;
            this.f4375f = this.f4370a.f4375f + j;
        } else {
            throw new AssertionError();
        }
    }

    protected C0925v(ah ahVar, long j, long j2, long j3, boolean z, long j4) {
        this.f4376h = ahVar;
        this.f4370a = null;
        this.f4371b = j;
        this.f4372c = j2;
        this.f4373d = j3;
        this.f4374e = z;
        this.f4375f = j4;
    }

    /* renamed from: l */
    public ah m6194l() {
        return this.f4376h;
    }

    /* renamed from: j */
    public C0898a mo1278j() {
        if (mo1192e()) {
            return this.f4378j;
        }
        return null;
    }

    /* renamed from: k */
    public C0898a mo1279k() {
        if (mo1192e()) {
            return this.f4379k;
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return this.f4377i ? this.f4376h.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return this.f4377i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public boolean mo1192e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.f4377i;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.f4377i;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.f4380l;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.f4380l = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.f4377i;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.f4376h;
        r1 = r1.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.f4376h;
        r1 = r1.mo1272c();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.f4380l;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.f4377i;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.a.v.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo1187a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4377i;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4377i;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.f4380l;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.f4380l = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.f4380l;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.f4377i;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.f4376h;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.f4376h;
        r1 = r1.mo1272c();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.f4377i;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.a.v.a(long):boolean");
    }

    /* renamed from: a */
    protected void m6185a(C0898a c0898a, C0898a c0898a2) {
        if (!f4369g && c0898a == null) {
            throw new AssertionError();
        } else if (!f4369g && c0898a2 == null) {
            throw new AssertionError();
        } else if (f4369g || this.f4377i) {
            this.f4378j = c0898a;
            this.f4379k = c0898a2;
            this.f4377i = false;
            synchronized (this) {
                if (this.f4380l != null) {
                    this.f4380l.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
