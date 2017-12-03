package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.av;

import java.util.concurrent.CountDownLatch;

public class ai extends af {
    static final /* synthetic */ boolean e = (!ai.class.desiredAssertionStatus());
    protected final ai a;
    protected final long b;
    protected final boolean c;
    protected final long d;
    private final au f;
    private boolean g = true;
    private b h = null;
    private b i = null;
    private CountDownLatch j = null;

    public /* synthetic */ av g() {
        return n();
    }

    public /* synthetic */ av h() {
        return o();
    }

    protected ai(au auVar, ai aiVar, long j) {
        if (!e && auVar == null) {
            throw new AssertionError();
        } else if (e || aiVar != null) {
            this.f = auVar;
            if (aiVar.b()) {
                this.a = null;
                this.b = aiVar.n().g();
                this.c = true;
                this.d = j;
                return;
            }
            this.a = aiVar;
            this.b = this.a.b;
            this.c = this.a.c;
            this.d = this.a.d + j;
        } else {
            throw new AssertionError();
        }
    }

    protected ai(au auVar, long j, boolean z, long j2) {
        if (e || auVar != null) {
            this.f = auVar;
            this.a = null;
            this.b = j;
            this.c = z;
            this.d = j2;
            return;
        }
        throw new AssertionError();
    }

    public au j() {
        return this.f;
    }

    public boolean a() {
        return this.g ? this.f.a : true;
    }

    public boolean c() {
        return this.g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.SessionTask;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.SessionTask;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.getWidthPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.getWidthPixels = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.SessionTask;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.HttpLogger;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.HttpLogger;
        r1 = r1.showAnimation();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.getWidthPixels;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.SessionTask;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.ai.getScaledPagingTouchSlop():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.SessionTask;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.SessionTask;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.getWidthPixels;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.getWidthPixels = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.getWidthPixels;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.SessionTask;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.HttpLogger;
        r1 = r1.setDrawable;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.HttpLogger;
        r1 = r1.showAnimation();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.SessionTask;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.ai.setDrawable(long):boolean");
    }

    public b n() {
        if (e()) {
            return this.h;
        }
        return null;
    }

    public b o() {
        if (e()) {
            return this.i;
        }
        return null;
    }

    protected void a(b bVar, b bVar2) {
        if (!e && bVar == null) {
            throw new AssertionError();
        } else if (!e && bVar2 == null) {
            throw new AssertionError();
        } else if (e || this.g) {
            this.h = bVar;
            this.i = bVar2;
            this.g = false;
            synchronized (this) {
                if (this.j != null) {
                    this.j.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
