package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;

import java.util.concurrent.CountDownLatch;

public class e extends af implements a {
    static final /* synthetic */ boolean a = (!e.class.desiredAssertionStatus());
    private final au b;
    private final ai c;
    private final long d;
    private final ai e;
    private ai f = null;
    private ai g = null;
    private boolean h = false;
    private CountDownLatch i = null;

    public /* synthetic */ av g() {
        return n();
    }

    public /* synthetic */ av h() {
        return o();
    }

    public /* synthetic */ ak p() {
        return l();
    }

    protected e(au auVar, ai aiVar, long j) {
        this.b = auVar;
        this.c = aiVar;
        this.d = j;
        this.e = new ai(this.b, this.c, this.d);
    }

    protected e(au auVar, e eVar, long j) {
        this.b = auVar;
        if (eVar.b()) {
            this.c = eVar.k();
            this.d = j * 2;
        } else {
            this.c = eVar.c;
            this.d = eVar.d + (2 * j);
        }
        this.e = new ai(this.b, this.c, this.d);
    }

    protected ai j() {
        return this.e;
    }

    public ai k() {
        if (q()) {
            return this.f;
        }
        return null;
    }

    public ai l() {
        if (q()) {
            return this.g;
        }
        return null;
    }

    protected boolean m() {
        return this.h;
    }

    protected void a(ai aiVar) {
        if (a || aiVar.b()) {
            if (this.b.b() < 0) {
                this.f = aiVar;
                this.g = new ai(this.b, aiVar, 1);
            } else {
                long b = this.b.b(aiVar.n().g());
                if (b < 0 || b % 2 == 0) {
                    this.f = aiVar;
                    this.g = new ai(this.b, aiVar, 1);
                } else {
                    this.f = new ai(this.b, aiVar, -1);
                    this.g = aiVar;
                }
            }
            this.h = true;
            synchronized (this) {
                if (this.i != null) {
                    this.i.countDown();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public b n() {
        if (q()) {
            return this.f.n();
        }
        return null;
    }

    public b o() {
        if (q()) {
            return this.g.o();
        }
        return null;
    }

    public boolean a() {
        return c() ? this.b.a : true;
    }

    public boolean c() {
        if (!this.h || this.f.c() || this.g.c()) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return b() && this.f.d() && this.g.d();
    }

    public boolean e() {
        if (q() && this.f.e() && this.g.e()) {
            return true;
        }
        return false;
    }

    public boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!b(j)) {
            return false;
        }
        if (!this.f.a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return false;
        }
        if (this.g.a(Math.max(0, j - (System.currentTimeMillis() - currentTimeMillis)))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean q() {
        /*
        r4 = this;
        r0 = 1;
        r1 = r4.h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r4);
        r1 = r4.h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r4.i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r4.i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r4);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r4.h;
        if (r0 != 0) goto L_0x003b;
    L_0x0021:
        r0 = r4.b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x003b;
    L_0x0027:
        r0 = r4.b;
        r0 = r0.c();
        if (r0 != 0) goto L_0x003b;
    L_0x002f:
        r0 = r4.i;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r0 = r4.h;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.e.q():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.h;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.h;	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r0 = r3.i;	 Catch:{ all -> 0x000d }
        if (r0 != 0) goto L_0x001c;
    L_0x0014:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x000d }
        r3.i = r0;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r0 = r3.i;	 Catch:{ InterruptedException -> 0x0039 }
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r0.await(r4, r1);	 Catch:{ InterruptedException -> 0x0039 }
    L_0x0024:
        r0 = r3.h;
        if (r0 != 0) goto L_0x0036;
    L_0x0028:
        r0 = r3.b;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0 = r3.b;
        r0 = r0.c();
        if (r0 == 0) goto L_0x001d;
    L_0x0036:
        r0 = r3.h;
        goto L_0x0005;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.e.b(long):boolean");
    }
}
