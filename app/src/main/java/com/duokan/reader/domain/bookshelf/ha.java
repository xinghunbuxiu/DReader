package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Semaphore;

class ha implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gz f3284a;
    /* renamed from: b */
    final /* synthetic */ int f3285b;
    /* renamed from: c */
    final /* synthetic */ Semaphore f3286c;
    /* renamed from: d */
    final /* synthetic */ gx f3287d;

    ha(gx gxVar, gz gzVar, int i, Semaphore semaphore) {
        this.f3287d = gxVar;
        this.f3284a = gzVar;
        this.f3285b = i;
        this.f3286c = semaphore;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r0 = 1;
        r1 = 0;
        r2 = r10.f3284a;
        r2 = r2.f3274a;
        r3 = r2.m4580d();
        r2 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.f3276c;	 Catch:{ Throwable -> 0x00af }
        r4 = new com.duokan.core.b.a.a;	 Catch:{ Throwable -> 0x00af }
        r4.<init>();	 Catch:{ Throwable -> 0x00af }
        r5 = r10.f3285b;	 Catch:{ Throwable -> 0x00af }
        r4 = r4.m721a(r5);	 Catch:{ Throwable -> 0x00af }
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r4 = r4.m724b(r5);	 Catch:{ Throwable -> 0x00af }
        com.duokan.core.p027b.p028a.C0321b.m726a(r3, r2, r4);	 Catch:{ Throwable -> 0x00af }
        r2 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.f3276c;	 Catch:{ Throwable -> 0x00af }
        r4 = r2.mo431b();	 Catch:{ Throwable -> 0x00af }
        r2 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.f3277d;	 Catch:{ Throwable -> 0x00af }
        r6 = "md5";
        r6 = com.duokan.core.sys.C0366o.m1029a(r2, r6);	 Catch:{ Throwable -> 0x00af }
        r2 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.f3274a;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.mo1070e();	 Catch:{ Throwable -> 0x00af }
        r8 = (long) r2;	 Catch:{ Throwable -> 0x00af }
        r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0087;
    L_0x0041:
        r2 = r0;
    L_0x0042:
        if (r2 == 0) goto L_0x0089;
    L_0x0044:
        r7 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.f3274a;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.m4582f();	 Catch:{ Throwable -> 0x00af }
        r7 = r6.startsWith(r7);	 Catch:{ Throwable -> 0x00af }
        if (r7 == 0) goto L_0x0089;
    L_0x0052:
        r1 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r1.f3278e = r0;	 Catch:{ Throwable -> 0x00af }
        if (r2 != 0) goto L_0x008b;
    L_0x0058:
        r0 = com.duokan.core.diagnostic.C0328a.init();	 Catch:{ Throwable -> 0x00af }
        r1 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ Throwable -> 0x00af }
        r2 = "epub-l";
        r6 = "fail to download the resource %s(size error: %s!=%s)";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x00af }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ Throwable -> 0x00af }
        r8 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00af }
        r7[r8] = r4;	 Catch:{ Throwable -> 0x00af }
        r4 = 2;
        r5 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r5 = r5.f3274a;	 Catch:{ Throwable -> 0x00af }
        r5 = r5.mo1070e();	 Catch:{ Throwable -> 0x00af }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00af }
        r7[r4] = r5;	 Catch:{ Throwable -> 0x00af }
        r0.a(r1, r2, r6, r7);	 Catch:{ Throwable -> 0x00af }
    L_0x0081:
        r0 = r10.f3286c;
        r0.release();
    L_0x0086:
        return;
    L_0x0087:
        r2 = r1;
        goto L_0x0042;
    L_0x0089:
        r0 = r1;
        goto L_0x0052;
    L_0x008b:
        if (r0 != 0) goto L_0x0081;
    L_0x008d:
        r0 = com.duokan.core.diagnostic.C0328a.init();	 Catch:{ Throwable -> 0x00af }
        r1 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ Throwable -> 0x00af }
        r2 = "epub-l";
        r4 = "fail to download the resource %s(md5 error: %s!=%s)";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00af }
        r7 = 0;
        r5[r7] = r3;	 Catch:{ Throwable -> 0x00af }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ Throwable -> 0x00af }
        r6 = 2;
        r7 = r10.f3284a;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.f3274a;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.m4582f();	 Catch:{ Throwable -> 0x00af }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00af }
        r0.a(r1, r2, r4, r5);	 Catch:{ Throwable -> 0x00af }
        goto L_0x0081;
    L_0x00af:
        r0 = move-exception;
        r1 = r10.f3284a;	 Catch:{ all -> 0x00d9 }
        r2 = 0;
        r1.f3278e = r2;	 Catch:{ all -> 0x00d9 }
        r1 = com.duokan.core.diagnostic.C0328a.init();	 Catch:{ all -> 0x00d9 }
        r2 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x00d9 }
        r4 = "epub-l";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d9 }
        r5.<init>();	 Catch:{ all -> 0x00d9 }
        r6 = "fail to download the resource ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00d9 }
        r3 = r5.append(r3);	 Catch:{ all -> 0x00d9 }
        r3 = r3.toString();	 Catch:{ all -> 0x00d9 }
        r1.m748a(r2, r4, r3, r0);	 Catch:{ all -> 0x00d9 }
        r0 = r10.f3286c;
        r0.release();
        goto L_0x0086;
    L_0x00d9:
        r0 = move-exception;
        r1 = r10.f3286c;
        r1.release();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.ha.run():void");
    }
}
