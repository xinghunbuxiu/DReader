package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.av;

import java.util.concurrent.CountDownLatch;

public class ay extends ar {
    static final /* synthetic */ boolean h = (!ay.class.desiredAssertionStatus());
    protected final ay a;
    protected final long b;
    protected final float c;
    protected final String d;
    protected final long e;
    protected final long f;
    protected final long g;
    private final EpubTypesettingContext i;
    private boolean j = true;
    private c k = null;
    private c l = null;
    private CountDownLatch m = null;

    public /* synthetic */ av g() {
        return k();
    }

    public /* synthetic */ av h() {
        return l();
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, ay ayVar, long j) {
        if (!h && epubTypesettingContext == null) {
            throw new AssertionError();
        } else if (h || ayVar != null) {
            this.i = epubTypesettingContext;
            if (ayVar.b()) {
                this.a = null;
                this.b = ayVar.k().g();
                this.c = Float.NaN;
                this.d = "";
                this.e = ayVar.k().h();
                this.f = ayVar.k().i();
                this.g = j;
                return;
            }
            this.a = ayVar;
            this.b = this.a.b;
            this.c = ayVar.c;
            this.d = this.a.d;
            this.e = this.a.e;
            this.f = this.a.f;
            this.g = this.a.g + j;
        } else {
            throw new AssertionError();
        }
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, long j, String str, long j2) {
        this.i = epubTypesettingContext;
        this.a = null;
        this.b = j;
        this.c = Float.NaN;
        this.d = str;
        this.e = 0;
        this.f = 0;
        this.g = j2;
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, long j, long j2, long j3, long j4) {
        this.i = epubTypesettingContext;
        this.a = null;
        this.b = j;
        this.c = Float.NaN;
        this.d = "";
        this.e = j2;
        this.f = j3;
        this.g = j4;
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, c cVar, c cVar2) {
        if (!h && cVar == null) {
            throw new AssertionError();
        } else if (!h && !cVar.b()) {
            throw new AssertionError();
        } else if (!h && cVar2 == null) {
            throw new AssertionError();
        } else if (h || cVar2.b()) {
            this.i = epubTypesettingContext;
            this.a = null;
            this.b = cVar.g();
            this.c = Float.NaN;
            this.d = "";
            this.e = cVar.h();
            this.f = cVar.i();
            this.g = 0;
            this.k = cVar;
            this.l = cVar2;
            this.j = false;
        } else {
            throw new AssertionError();
        }
    }

    public EpubTypesettingContext j() {
        return this.i;
    }

    public c k() {
        if (e()) {
            return this.k;
        }
        return null;
    }

    public c l() {
        if (e()) {
            return this.l;
        }
        return null;
    }

    public boolean a() {
        return this.j ? this.i.a : true;
    }

    public boolean c() {
        return this.j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.getWidthPixels;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.getWidthPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.BaseActivity;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.BaseActivity = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.getWidthPixels;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.getPhysicalYPixels;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.getPhysicalYPixels;
        r1 = r1.getScaledMaximumFlingVelocity();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.BaseActivity;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.getWidthPixels;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.ay.getScaledPagingTouchSlop():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.getWidthPixels;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.getWidthPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.BaseActivity;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.BaseActivity = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.BaseActivity;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.getWidthPixels;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.getPhysicalYPixels;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.getPhysicalYPixels;
        r1 = r1.getScaledMaximumFlingVelocity();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.getWidthPixels;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.ay.setDrawable(long):boolean");
    }

    protected void a(c cVar, c cVar2) {
        if (!h && cVar == null) {
            throw new AssertionError();
        } else if (!h && cVar2 == null) {
            throw new AssertionError();
        } else if (h || this.j) {
            this.k = cVar;
            this.l = cVar2;
            this.j = false;
            synchronized (this) {
                if (this.m != null) {
                    this.m.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
