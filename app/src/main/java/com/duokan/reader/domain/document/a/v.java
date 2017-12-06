package com.duokan.reader.domain.document.a;

import com.duokan.reader.domain.document.av;

import java.util.concurrent.CountDownLatch;

public class v extends s {
    static final /* synthetic */ boolean g = (!v.class.desiredAssertionStatus());
    protected final v a;
    protected final long b;
    protected final long c;
    protected final long d;
    protected final boolean e;
    protected final long f;
    private final ah h;
    private boolean i = true;
    private a j = null;
    private a k = null;
    private CountDownLatch l = null;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected v(ah ahVar, v vVar, long j) {
        if (!g && ahVar == null) {
            throw new AssertionError();
        } else if (g || vVar != null) {
            this.h = ahVar;
            if (vVar.b()) {
                this.a = null;
                this.b = vVar.j().g();
                this.c = vVar.j().h();
                this.d = vVar.j().i();
                this.e = true;
                this.f = j;
                return;
            }
            this.a = vVar;
            this.b = this.a.b;
            this.c = this.a.c;
            this.d = this.a.d;
            this.e = this.a.e;
            this.f = this.a.f + j;
        } else {
            throw new AssertionError();
        }
    }

    protected v(ah ahVar, long j, long j2, long j3, boolean z, long j4) {
        this.h = ahVar;
        this.a = null;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = z;
        this.f = j4;
    }

    public ah l() {
        return this.h;
    }

    public a j() {
        if (e()) {
            return this.j;
        }
        return null;
    }

    public a k() {
        if (e()) {
            return this.k;
        }
        return null;
    }

    public boolean a() {
        return this.i ? this.h.a : true;
    }

    public boolean c() {
        return this.i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.getPhysicalYPixels;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.getPhysicalYPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.OnDismissListener;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.OnDismissListener = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.getPhysicalYPixels;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.getPhysicalXPixels;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.getPhysicalXPixels;
        r1 = r1.getScaledMaximumFlingVelocity();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.OnDismissListener;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.getPhysicalYPixels;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.setDrawable.v.getScaledPagingTouchSlop():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.getPhysicalYPixels;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.getPhysicalYPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.OnDismissListener;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.OnDismissListener = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.OnDismissListener;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.getPhysicalYPixels;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.getPhysicalXPixels;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.getPhysicalXPixels;
        r1 = r1.getScaledMaximumFlingVelocity();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.getPhysicalYPixels;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.setDrawable.v.setDrawable(long):boolean");
    }

    protected void a(a aVar, a aVar2) {
        if (!g && aVar == null) {
            throw new AssertionError();
        } else if (!g && aVar2 == null) {
            throw new AssertionError();
        } else if (g || this.i) {
            this.j = aVar;
            this.k = aVar2;
            this.i = false;
            synchronized (this) {
                if (this.l != null) {
                    this.l.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
