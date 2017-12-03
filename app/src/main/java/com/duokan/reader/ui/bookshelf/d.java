package com.duokan.reader.ui.bookshelf;

class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r6 = 1;
        r0 = new java.util.LinkedHashMap;
        r0.<init>();
        r1 = new java.io.File;
        r2 = com.duokan.reader.ReaderEnv.get();
        r2 = r2.getExternalFilesDirectory();
        r3 = "/Downloads";
        r1.<init>(r2, r3);
        r2 = new java.io.File;
        r3 = com.duokan.reader.ReaderEnv.get();
        r3 = r3.getPrivateCacheDirectory();
        r4 = "book.arch";
        r2.<init>(r3, r4);
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r1.mkdirs();	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r3 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r4 = r7.setDrawable;	 Catch:{ all -> 0x0078 }
        r4 = r4.getContext();	 Catch:{ all -> 0x0078 }
        r5 = r7.setDrawable;	 Catch:{ all -> 0x0078 }
        r5 = r5.getScaledTouchSlop();	 Catch:{ all -> 0x0078 }
        com.duokan.reader.DkPublic.extractRawResource(r4, r3, r5);	 Catch:{ all -> 0x0078 }
        r3.flush();	 Catch:{ Throwable -> 0x00b8, all -> 0x009b }
        r3.close();	 Catch:{ Throwable -> 0x00b8, all -> 0x009b }
    L_0x0044:
        r2 = r2.getAbsolutePath();	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r3 = r1.getAbsolutePath();	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        com.duokan.lib.archive.DkarchLib.extract(r2, r3);	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r2 = com.duokan.reader.DkPublic.getBookListFromStorage(r1, r0);	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        if (r2 == 0) goto L_0x005e;
    L_0x0055:
        r2 = com.duokan.reader.domain.bookshelf.ai.setDrawable();	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r3 = r7.setDrawable;	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
        r3.setDrawable(r1, r2, r0);	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
    L_0x005e:
        r0 = com.duokan.reader.domain.account.getPhysicalYPixels.HttpLogger();
        r0 = r0.getVisible();
        if (r0 == 0) goto L_0x006f;
    L_0x0068:
        r0 = com.duokan.reader.domain.bookshelf.ai.setDrawable();
        r0.setDrawable(r6, r6);
    L_0x006f:
        r0 = new com.duokan.reader.ui.bookshelf.getScaledPagingTouchSlop;
        r0.<init>(r7);
        com.duokan.core.sys.TaskHandler.setDrawable(r0);
    L_0x0077:
        return;
    L_0x0078:
        r0 = move-exception;
        r3.flush();	 Catch:{ Throwable -> 0x00b6, all -> 0x009b }
        r3.close();	 Catch:{ Throwable -> 0x00b6, all -> 0x009b }
    L_0x007f:
        throw r0;	 Catch:{ Throwable -> 0x0080, all -> 0x009b }
    L_0x0080:
        r0 = move-exception;
        r0 = com.duokan.reader.domain.account.getPhysicalYPixels.HttpLogger();
        r0 = r0.getVisible();
        if (r0 == 0) goto L_0x0092;
    L_0x008b:
        r0 = com.duokan.reader.domain.bookshelf.ai.setDrawable();
        r0.setDrawable(r6, r6);
    L_0x0092:
        r0 = new com.duokan.reader.ui.bookshelf.getScaledPagingTouchSlop;
        r0.<init>(r7);
        com.duokan.core.sys.TaskHandler.setDrawable(r0);
        goto L_0x0077;
    L_0x009b:
        r0 = move-exception;
        r1 = com.duokan.reader.domain.account.getPhysicalYPixels.HttpLogger();
        r1 = r1.getVisible();
        if (r1 == 0) goto L_0x00ad;
    L_0x00a6:
        r1 = com.duokan.reader.domain.bookshelf.ai.setDrawable();
        r1.setDrawable(r6, r6);
    L_0x00ad:
        r1 = new com.duokan.reader.ui.bookshelf.getScaledPagingTouchSlop;
        r1.<init>(r7);
        com.duokan.core.sys.TaskHandler.setDrawable(r1);
        throw r0;
    L_0x00b6:
        r1 = move-exception;
        goto L_0x007f;
    L_0x00b8:
        r3 = move-exception;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.bookshelf.getScaledTouchSlop.run():void");
    }
}
