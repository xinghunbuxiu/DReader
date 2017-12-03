package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Semaphore;

class hg implements Runnable {
    final /* synthetic */ hf a;
    final /* synthetic */ int b;
    final /* synthetic */ Semaphore c;
    final /* synthetic */ hd d;

    hg(hd hdVar, hf hfVar, int i, Semaphore semaphore) {
        this.d = hdVar;
        this.a = hfVar;
        this.b = i;
        this.c = semaphore;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r0 = 1;
        r1 = 0;
        r2 = r10.setDrawable;
        r2 = r2.setDrawable;
        r3 = r2.getScaledTouchSlop();
        r2 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.showAnimation;	 Catch:{ Throwable -> 0x00af }
        r4 = new com.duokan.core.getVisible.setDrawable.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r4.<init>();	 Catch:{ Throwable -> 0x00af }
        r5 = r10.getVisible;	 Catch:{ Throwable -> 0x00af }
        r4 = r4.setDrawable(r5);	 Catch:{ Throwable -> 0x00af }
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r4 = r4.getVisible(r5);	 Catch:{ Throwable -> 0x00af }
        com.duokan.core.getVisible.setDrawable.getVisible.setDrawable(r3, r2, r4);	 Catch:{ Throwable -> 0x00af }
        r2 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.showAnimation;	 Catch:{ Throwable -> 0x00af }
        r4 = r2.getVisible();	 Catch:{ Throwable -> 0x00af }
        r2 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.getScaledTouchSlop;	 Catch:{ Throwable -> 0x00af }
        r6 = "md5";
        r6 = com.duokan.core.sys.o.setDrawable(r2, r6);	 Catch:{ Throwable -> 0x00af }
        r2 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r2 = r2.getScaledPagingTouchSlop();	 Catch:{ Throwable -> 0x00af }
        r8 = (long) r2;	 Catch:{ Throwable -> 0x00af }
        r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0087;
    L_0x0041:
        r2 = r0;
    L_0x0042:
        if (r2 == 0) goto L_0x0089;
    L_0x0044:
        r7 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.HttpLogger();	 Catch:{ Throwable -> 0x00af }
        r7 = r6.startsWith(r7);	 Catch:{ Throwable -> 0x00af }
        if (r7 == 0) goto L_0x0089;
    L_0x0052:
        r1 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r1.getScaledPagingTouchSlop = r0;	 Catch:{ Throwable -> 0x00af }
        if (r2 != 0) goto L_0x008b;
    L_0x0058:
        r0 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ Throwable -> 0x00af }
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
        r5 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r5 = r5.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r5 = r5.getScaledPagingTouchSlop();	 Catch:{ Throwable -> 0x00af }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00af }
        r7[r4] = r5;	 Catch:{ Throwable -> 0x00af }
        r0.setDrawable(r1, r2, r6, r7);	 Catch:{ Throwable -> 0x00af }
    L_0x0081:
        r0 = r10.showAnimation;
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
        r0 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ Throwable -> 0x00af }
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
        r7 = r10.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.setDrawable;	 Catch:{ Throwable -> 0x00af }
        r7 = r7.HttpLogger();	 Catch:{ Throwable -> 0x00af }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00af }
        r0.setDrawable(r1, r2, r4, r5);	 Catch:{ Throwable -> 0x00af }
        goto L_0x0081;
    L_0x00af:
        r0 = move-exception;
        r1 = r10.setDrawable;	 Catch:{ all -> 0x00d9 }
        r2 = 0;
        r1.getScaledPagingTouchSlop = r2;	 Catch:{ all -> 0x00d9 }
        r1 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x00d9 }
        r2 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x00d9 }
        r4 = "epub-l";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d9 }
        r5.<init>();	 Catch:{ all -> 0x00d9 }
        r6 = "fail to download the resource ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00d9 }
        r3 = r5.append(r3);	 Catch:{ all -> 0x00d9 }
        r3 = r3.toString();	 Catch:{ all -> 0x00d9 }
        r1.setDrawable(r2, r4, r3, r0);	 Catch:{ all -> 0x00d9 }
        r0 = r10.showAnimation;
        r0.release();
        goto L_0x0086;
    L_0x00d9:
        r0 = move-exception;
        r1 = r10.showAnimation;
        r1.release();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.hg.run():void");
    }
}
