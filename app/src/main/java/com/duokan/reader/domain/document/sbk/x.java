package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.av;

import java.util.concurrent.CountDownLatch;

public class x extends t {
    static final /* synthetic */ boolean f = (!x.class.desiredAssertionStatus());
    protected final x a;
    protected final long b;
    protected final long c;
    protected final long d;
    protected final long e;
    private final SbkTypesettingContext g;
    private boolean h = true;
    private b i = null;
    private b j = null;
    private CountDownLatch k = null;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected x(SbkTypesettingContext sbkTypesettingContext, x xVar, long j) {
        if (!f && sbkTypesettingContext == null) {
            throw new AssertionError();
        } else if (f || xVar != null) {
            this.g = sbkTypesettingContext;
            if (xVar.b()) {
                this.a = null;
                this.b = xVar.j().g();
                this.c = xVar.j().h();
                this.d = xVar.j().i();
                this.e = j;
                return;
            }
            this.a = xVar;
            this.b = this.a.b;
            this.c = this.a.c;
            this.d = this.a.d;
            this.e = this.a.e + j;
        } else {
            throw new AssertionError();
        }
    }

    protected x(SbkTypesettingContext sbkTypesettingContext, long j, long j2, long j3, long j4) {
        this.g = sbkTypesettingContext;
        this.a = null;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
    }

    public SbkTypesettingContext l() {
        return this.g;
    }

    public b j() {
        if (e()) {
            return this.i;
        }
        return null;
    }

    public b k() {
        if (e()) {
            return this.j;
        }
        return null;
    }

    public boolean a() {
        return this.h ? this.g.a : true;
    }

    public boolean c() {
        return this.h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.h;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.h;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.k;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.k = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.h;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.g;
        r1 = r1.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.g;
        r1 = r1.c();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.k;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.h;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.sbk.x.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.h;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.h;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.k;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.k = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.k;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.h;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.g;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.g;
        r1 = r1.c();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.h;
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

    protected void a(b bVar, b bVar2) {
        if (!f && bVar == null) {
            throw new AssertionError();
        } else if (!f && bVar2 == null) {
            throw new AssertionError();
        } else if (f || this.h) {
            this.i = bVar;
            this.j = bVar2;
            this.h = false;
            synchronized (this) {
                if (this.k != null) {
                    this.k.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
