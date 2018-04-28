package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.av;
import java.util.concurrent.CountDownLatch;

public class ai extends af {
    /* renamed from: e */
    static final /* synthetic */ boolean f4878e = (!ai.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final ai f4879a;
    /* renamed from: b */
    protected final long f4880b;
    /* renamed from: c */
    protected final boolean f4881c;
    /* renamed from: d */
    protected final long f4882d;
    /* renamed from: f */
    private final au f4883f;
    /* renamed from: g */
    private boolean f4884g = true;
    /* renamed from: h */
    private C0986b f4885h = null;
    /* renamed from: i */
    private C0986b f4886i = null;
    /* renamed from: j */
    private CountDownLatch f4887j = null;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return mo1460n();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return mo1461o();
    }

    protected ai(au auVar, ai aiVar, long j) {
        if (!f4878e && auVar == null) {
            throw new AssertionError();
        } else if (f4878e || aiVar != null) {
            this.f4883f = auVar;
            if (aiVar.m5777b()) {
                this.f4879a = null;
                this.f4880b = aiVar.mo1460n().m7539g();
                this.f4881c = true;
                this.f4882d = j;
                return;
            }
            this.f4879a = aiVar;
            this.f4880b = this.f4879a.f4880b;
            this.f4881c = this.f4879a.f4881c;
            this.f4882d = this.f4879a.f4882d + j;
        } else {
            throw new AssertionError();
        }
    }

    protected ai(au auVar, long j, boolean z, long j2) {
        if (f4878e || auVar != null) {
            this.f4883f = auVar;
            this.f4879a = null;
            this.f4880b = j;
            this.f4881c = z;
            this.f4882d = j2;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public au m7396j() {
        return this.f4883f;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return this.f4884g ? this.f4883f.a : true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return this.f4884g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public boolean mo1192e() {
        /*
        r5 = this;
        r0 = 1;
        r1 = r5.f4884g;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r5);
        r1 = r5.f4884g;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r5.f4887j;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r5.f4887j = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r5);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r5.f4884g;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r5.f4883f;
        r1 = r1.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0027:
        r1 = r5.f4883f;
        r1 = r1.mo1272c();
        if (r1 != 0) goto L_0x003b;
    L_0x002f:
        r1 = r5.f4887j;	 Catch:{ InterruptedException -> 0x0039 }
        r2 = 1;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0039 }
        r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0039 }
        goto L_0x001d;
    L_0x0039:
        r1 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = r5.f4884g;
        if (r1 == 0) goto L_0x0005;
    L_0x003f:
        r0 = 0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.ai.e():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo1187a(long r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.f4884g;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        monitor-enter(r3);
        r1 = r3.f4884g;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
        throw r0;
    L_0x0010:
        r1 = r3.f4887j;	 Catch:{ all -> 0x000d }
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x000d }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ all -> 0x000d }
        r3.f4887j = r1;	 Catch:{ all -> 0x000d }
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x000d }
    L_0x001d:
        r1 = r3.f4887j;	 Catch:{ InterruptedException -> 0x003c }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x003c }
        r1.await(r4, r2);	 Catch:{ InterruptedException -> 0x003c }
    L_0x0024:
        r1 = r3.f4884g;
        if (r1 == 0) goto L_0x0036;
    L_0x0028:
        r1 = r3.f4883f;
        r1 = r1.a;
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1 = r3.f4883f;
        r1 = r1.mo1272c();
        if (r1 == 0) goto L_0x001d;
    L_0x0036:
        r1 = r3.f4884g;
        if (r1 == 0) goto L_0x0005;
    L_0x003a:
        r0 = 0;
        goto L_0x0005;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.ai.a(long):boolean");
    }

    /* renamed from: n */
    public C0986b mo1460n() {
        if (mo1192e()) {
            return this.f4885h;
        }
        return null;
    }

    /* renamed from: o */
    public C0986b mo1461o() {
        if (mo1192e()) {
            return this.f4886i;
        }
        return null;
    }

    /* renamed from: a */
    protected void m7389a(C0986b c0986b, C0986b c0986b2) {
        if (!f4878e && c0986b == null) {
            throw new AssertionError();
        } else if (!f4878e && c0986b2 == null) {
            throw new AssertionError();
        } else if (f4878e || this.f4884g) {
            this.f4885h = c0986b;
            this.f4886i = c0986b2;
            this.f4884g = false;
            synchronized (this) {
                if (this.f4887j != null) {
                    this.f4887j.countDown();
                }
            }
        } else {
            throw new AssertionError();
        }
    }
}
