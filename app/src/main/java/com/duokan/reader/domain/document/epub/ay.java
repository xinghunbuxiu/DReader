package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.av;
import java.util.concurrent.CountDownLatch;

public class ay extends ar {
    /* renamed from: h */
    static final /* synthetic */ boolean f4501h = (!ay.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final ay f4502a;
    /* renamed from: b */
    protected final long f4503b;
    /* renamed from: c */
    protected final float f4504c;
    /* renamed from: d */
    protected final String f4505d;
    /* renamed from: e */
    protected final long f4506e;
    /* renamed from: f */
    protected final long f4507f;
    /* renamed from: g */
    protected final long f4508g;
    /* renamed from: i */
    private final EpubTypesettingContext f4509i;
    /* renamed from: j */
    private boolean f4510j = true;
    /* renamed from: k */
    private C0936c f4511k = null;
    /* renamed from: l */
    private C0936c f4512l = null;
    /* renamed from: m */
    private CountDownLatch f4513m = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m6533k();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m6534l();
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, ay ayVar, long j) {
        if (!f4501h && epubTypesettingContext == null) {
            throw new AssertionError();
        } else if (f4501h || ayVar != null) {
            this.f4509i = epubTypesettingContext;
            if (ayVar.m5777b()) {
                this.f4502a = null;
                this.f4503b = ayVar.m6533k().m6780g();
                this.f4504c = Float.NaN;
                this.f4505d = "";
                this.f4506e = ayVar.m6533k().m6781h();
                this.f4507f = ayVar.m6533k().m6782i();
                this.f4508g = j;
                return;
            }
            this.f4502a = ayVar;
            this.f4503b = this.f4502a.f4503b;
            this.f4504c = ayVar.f4504c;
            this.f4505d = this.f4502a.f4505d;
            this.f4506e = this.f4502a.f4506e;
            this.f4507f = this.f4502a.f4507f;
            this.f4508g = this.f4502a.f4508g + j;
        } else {
            throw new AssertionError();
        }
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, long j, String str, long j2) {
        this.f4509i = epubTypesettingContext;
        this.f4502a = null;
        this.f4503b = j;
        this.f4504c = Float.NaN;
        this.f4505d = str;
        this.f4506e = 0;
        this.f4507f = 0;
        this.f4508g = j2;
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, long j, long j2, long j3, long j4) {
        this.f4509i = epubTypesettingContext;
        this.f4502a = null;
        this.f4503b = j;
        this.f4504c = Float.NaN;
        this.f4505d = "";
        this.f4506e = j2;
        this.f4507f = j3;
        this.f4508g = j4;
    }

    protected ay(EpubTypesettingContext epubTypesettingContext, C0936c c0936c, C0936c c0936c2) {
        if (!f4501h && c0936c == null) {
            throw new AssertionError();
        } else if (!f4501h && !c0936c.m5777b()) {
            throw new AssertionError();
        } else if (!f4501h && c0936c2 == null) {
            throw new AssertionError();
        } else if (f4501h || c0936c2.m5777b()) {
            this.f4509i = epubTypesettingContext;
            this.f4502a = null;
            this.f4503b = c0936c.m6780g();
            this.f4504c = Float.NaN;
            this.f4505d = "";
            this.f4506e = c0936c.m6781h();
            this.f4507f = c0936c.m6782i();
            this.f4508g = 0;
            this.f4511k = c0936c;
            this.f4512l = c0936c2;
            this.f4510j = false;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: j */
    public EpubTypesettingContext m6532j() {
        return this.f4509i;
    }

    /* renamed from: k */
    public C0936c m6533k() {
        if (mo1192e()) {
            return this.f4511k;
        }
        return null;
    }

    /* renamed from: l */
    public C0936c m6534l() {
        if (mo1192e()) {
            return this.f4512l;
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return this.f4510j ? this.f4509i.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return this.f4510j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public boolean mo1192e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.f4510j;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.f4510j;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.f4513m;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.f4513m = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.f4510j;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.f4509i;
        r1 = r1.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.f4509i;
        r1 = r1.mo1272c();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.f4513m;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.f4510j;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.ay.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo1187a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4510j;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4510j;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.f4513m;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.f4513m = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.f4513m;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.f4510j;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.f4509i;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.f4509i;
        r1 = r1.mo1272c();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.f4510j;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.ay.a(long):boolean");
    }

    /* renamed from: a */
    protected void m6525a(C0936c c0936c, C0936c c0936c2) {
        if (!f4501h && c0936c == null) {
            throw new AssertionError();
        } else if (!f4501h && c0936c2 == null) {
            throw new AssertionError();
        } else if (f4501h || this.f4510j) {
            this.f4511k = c0936c;
            this.f4512l = c0936c2;
            this.f4510j = false;
            synchronized (this) {
                if (this.f4513m != null) {
                    this.f4513m.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
