package com.duokan.core.sys;

import com.duokan.core.diagnostic.a;

public class i {
    private final Object a = new Object();
    private Object b = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a() {
        /*
        r12 = this;
        r0 = 1;
        r1 = 0;
        r2 = r12.getVisible;
        if (r2 == 0) goto L_0x0009;
    L_0x0006:
        r0 = r12.getVisible;
    L_0x0008:
        return r0;
    L_0x0009:
        r2 = r12.setDrawable;
        monitor-enter(r2);
        r3 = r12.getVisible;	 Catch:{ all -> 0x0014 }
        if (r3 == 0) goto L_0x0017;
    L_0x0010:
        r0 = r12.getVisible;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        goto L_0x0008;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r3 = com.duokan.core.sys.TaskHandler.setDrawable();	 Catch:{ all -> 0x0014 }
        if (r3 == 0) goto L_0x0030;
    L_0x001d:
        r3 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x0014 }
        r4 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x0014 }
        r5 = r12.getClass();	 Catch:{ all -> 0x0014 }
        r5 = r5.getSimpleName();	 Catch:{ all -> 0x0014 }
        r6 = "too early to access setDrawable coming object in main thread...";
        r3.setDrawable(r4, r5, r6);	 Catch:{ all -> 0x0014 }
    L_0x0030:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0014 }
        r3 = r12.setDrawable;	 Catch:{ InterruptedException -> 0x0080 }
        r3.wait();	 Catch:{ InterruptedException -> 0x0080 }
    L_0x0039:
        r3 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x0014 }
        r6 = r12.getVisible;	 Catch:{ all -> 0x0014 }
        if (r6 == 0) goto L_0x007e;
    L_0x0041:
        r3.getVisible(r0);	 Catch:{ all -> 0x0014 }
        r0 = com.duokan.core.sys.TaskHandler.setDrawable();	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x007a;
    L_0x004a:
        r0 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x0014 }
        r1 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x0014 }
        r3 = r12.getClass();	 Catch:{ all -> 0x0014 }
        r3 = r3.getSimpleName();	 Catch:{ all -> 0x0014 }
        r6 = "block main thread for %s for %dms";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0014 }
        r8 = 0;
        r9 = r12.getVisible;	 Catch:{ all -> 0x0014 }
        r9 = r9.getClass();	 Catch:{ all -> 0x0014 }
        r9 = r9.getName();	 Catch:{ all -> 0x0014 }
        r7[r8] = r9;	 Catch:{ all -> 0x0014 }
        r8 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0014 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0014 }
        r7[r8] = r4;	 Catch:{ all -> 0x0014 }
        r0.setDrawable(r1, r3, r6, r7);	 Catch:{ all -> 0x0014 }
    L_0x007a:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r12.getVisible;
        goto L_0x0008;
    L_0x007e:
        r0 = r1;
        goto L_0x0041;
    L_0x0080:
        r3 = move-exception;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.getPhysicalYPixels.setDrawable():java.lang.Object");
    }

    public void a(Object obj) {
        boolean z = true;
        a.c().b(obj != null);
        if (obj != null) {
            synchronized (this.a) {
                a c = a.c();
                if (this.b != null) {
                    z = false;
                }
                c.b(z);
                if (this.b != null) {
                    return;
                }
                this.b = obj;
                this.a.notifyAll();
            }
        }
    }
}
