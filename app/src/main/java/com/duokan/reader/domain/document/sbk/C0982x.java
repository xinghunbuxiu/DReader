package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.av;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.sbk.x */
public class C0982x extends C0979t {
    /* renamed from: f */
    static final /* synthetic */ boolean f4842f = (!C0982x.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final C0982x f4843a;
    /* renamed from: b */
    protected final long f4844b;
    /* renamed from: c */
    protected final long f4845c;
    /* renamed from: d */
    protected final long f4846d;
    /* renamed from: e */
    protected final long f4847e;
    /* renamed from: g */
    private final SbkTypesettingContext f4848g;
    /* renamed from: h */
    private boolean f4849h = true;
    /* renamed from: i */
    private C0965b f4850i = null;
    /* renamed from: j */
    private C0965b f4851j = null;
    /* renamed from: k */
    private CountDownLatch f4852k = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return mo1454j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return mo1455k();
    }

    protected C0982x(SbkTypesettingContext sbkTypesettingContext, C0982x c0982x, long j) {
        if (!f4842f && sbkTypesettingContext == null) {
            throw new AssertionError();
        } else if (f4842f || c0982x != null) {
            this.f4848g = sbkTypesettingContext;
            if (c0982x.m5777b()) {
                this.f4843a = null;
                this.f4844b = c0982x.mo1454j().m7141g();
                this.f4845c = c0982x.mo1454j().m7142h();
                this.f4846d = c0982x.mo1454j().m7143i();
                this.f4847e = j;
                return;
            }
            this.f4843a = c0982x;
            this.f4844b = this.f4843a.f4844b;
            this.f4845c = this.f4843a.f4845c;
            this.f4846d = this.f4843a.f4846d;
            this.f4847e = this.f4843a.f4847e + j;
        } else {
            throw new AssertionError();
        }
    }

    protected C0982x(SbkTypesettingContext sbkTypesettingContext, long j, long j2, long j3, long j4) {
        this.f4848g = sbkTypesettingContext;
        this.f4843a = null;
        this.f4844b = j;
        this.f4845c = j2;
        this.f4846d = j3;
        this.f4847e = j4;
    }

    /* renamed from: l */
    public SbkTypesettingContext m7281l() {
        return this.f4848g;
    }

    /* renamed from: j */
    public C0965b mo1454j() {
        if (mo1192e()) {
            return this.f4850i;
        }
        return null;
    }

    /* renamed from: k */
    public C0965b mo1455k() {
        if (mo1192e()) {
            return this.f4851j;
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return this.f4849h ? this.f4848g.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return this.f4849h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public boolean mo1192e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.f4849h;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.f4849h;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.f4852k;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.f4852k = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.f4849h;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.f4848g;
        r1 = r1.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.f4848g;
        r1 = r1.mo1272c();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.f4852k;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.f4849h;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.sbk.x.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo1187a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4849h;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4849h;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.f4852k;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.f4852k = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.f4852k;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.f4849h;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.f4848g;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.f4848g;
        r1 = r1.mo1272c();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.f4849h;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.sbk.x.a(long):boolean");
    }

    /* renamed from: a */
    protected void m7272a(C0965b c0965b, C0965b c0965b2) {
        if (!f4842f && c0965b == null) {
            throw new AssertionError();
        } else if (!f4842f && c0965b2 == null) {
            throw new AssertionError();
        } else if (f4842f || this.f4849h) {
            this.f4850i = c0965b;
            this.f4851j = c0965b2;
            this.f4849h = false;
            synchronized (this) {
                if (this.f4852k != null) {
                    this.f4852k.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
