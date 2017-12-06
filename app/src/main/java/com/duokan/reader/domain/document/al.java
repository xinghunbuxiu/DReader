package com.duokan.reader.domain.document;

import android.graphics.Rect;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class al {
    static final /* synthetic */ boolean a = (!al.class.desiredAssertionStatus());
    private final LinkedList b = new LinkedList();
    private final Thread c = new Thread(new am(this));
    private final Semaphore d = new Semaphore(0);
    private boolean e = false;
    private int f = 0;
    private int g = 3145728;

    public al() {
        this.c.start();
    }

    public void a(int i) {
        this.g = i;
    }

    public final ap a(bc bcVar, ak akVar, Rect rect, m mVar, float f, Object obj, ar arVar) {
        ap b;
        synchronized (this) {
            bcVar.b((Object) this);
            b = b(bcVar, akVar, rect, mVar, f, obj, arVar);
            b.l = true;
        }
        return b;
    }

    public final ap a(bc bcVar, ak akVar, Rect rect, m mVar, float f, Object obj) {
        ap a;
        synchronized (this) {
            a = a(bcVar, akVar, rect, mVar, f, new an(this, obj));
            if (a != null) {
                c(a);
                a.l = true;
            }
        }
        return a;
    }

    public final ap a(bc bcVar, ak akVar, Rect rect, m mVar, float f, Object obj, int i) {
        ap a;
        synchronized (this) {
            a = a(bcVar, akVar, rect, mVar, f, new ao(this, obj, i));
            if (a != null) {
                c(a);
                a.l = true;
            }
        }
        return a;
    }

    public final void a(ap apVar) {
        synchronized (this) {
            apVar.l = false;
        }
    }

    public final void a(ap apVar, boolean z) {
        synchronized (this) {
            apVar.l = false;
            apVar.m = true;
            apVar.n = z;
        }
        this.d.release();
    }

    public final void b(ap apVar) {
        a(apVar, false);
    }

    public final void a() {
        this.e = true;
        try {
            this.d.release();
            this.c.join();
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
        r7 = this;
        r6 = 1;
        r2 = 0;
    L_0x0002:
        r0 = r7.getScaledPagingTouchSlop;
        if (r0 != 0) goto L_0x01d5;
    L_0x0006:
        r0 = r7.getTriangleEdge;
        r0.acquireUninterruptibly();
        monitor-enter(r7);
        r0 = r7.getVisible;	 Catch:{ all -> 0x0070 }
        r1 = r7.getVisible;	 Catch:{ all -> 0x0070 }
        r1 = r1.size();	 Catch:{ all -> 0x0070 }
        r3 = r0.listIterator(r1);	 Catch:{ all -> 0x0070 }
        r1 = r2;
    L_0x0019:
        r0 = r3.hasPrevious();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x007d;
    L_0x001f:
        r0 = r3.previous();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.BaseActivity;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0060;
    L_0x002b:
        r4 = r0.n;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0060;
    L_0x0031:
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x004f;
    L_0x0037:
        r4 = r7.HttpLogger;	 Catch:{ all -> 0x0070 }
        r5 = r0.o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.setDrawable.setDrawable(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.HttpLogger = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.o = r4;	 Catch:{ all -> 0x0070 }
    L_0x004f:
        r4 = r0.getWidthPixels;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0060;
    L_0x0055:
        r4 = r0.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x0070 }
        r4.getScaledMaximumFlingVelocity(r7);	 Catch:{ all -> 0x0070 }
        r4 = 1;
        r0.getWidthPixels = r4;	 Catch:{ all -> 0x0070 }
    L_0x0060:
        r4 = r0.getWidthPixels;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0073;
    L_0x0066:
        r0 = r0.o;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0019;
    L_0x006c:
        r3.remove();	 Catch:{ all -> 0x0070 }
        goto L_0x0019;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0070 }
        throw r0;
    L_0x0073:
        if (r1 != 0) goto L_0x0226;
    L_0x0075:
        r4 = r0.getWidthPixels;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0226;
    L_0x007b:
        r1 = r0;
        goto L_0x0019;
    L_0x007d:
        if (r1 == 0) goto L_0x014c;
    L_0x007f:
        r0 = r1.BaseActivity;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x014c;
    L_0x0085:
        r0 = r7.getVisible;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x008b:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x00dc;
    L_0x0091:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.BaseActivity;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x008b;
    L_0x009d:
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x008b;
    L_0x00a3:
        r4 = r0.getHeightPixels();	 Catch:{ all -> 0x0070 }
        r5 = r1.getHeightPixels();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00ad:
        r4 = r0.SessionTask();	 Catch:{ all -> 0x0070 }
        r5 = r1.SessionTask();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00b7:
        r4 = r0.getPhysicalXPixels();	 Catch:{ all -> 0x0070 }
        r5 = r1.getPhysicalXPixels();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00c1:
        r3 = setDrawable;	 Catch:{ all -> 0x0070 }
        if (r3 != 0) goto L_0x00d1;
    L_0x00c5:
        r3 = r0.OnDismissListener;	 Catch:{ all -> 0x0070 }
        if (r3 == 0) goto L_0x00d1;
    L_0x00cb:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0070 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x00d1:
        r3 = r0.o;	 Catch:{ all -> 0x0070 }
        r1.o = r3;	 Catch:{ all -> 0x0070 }
        r3 = 0;
        r0.o = r3;	 Catch:{ all -> 0x0070 }
    L_0x00dc:
        r0 = r1.o;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0129;
    L_0x00e2:
        r0 = r7.getVisible;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x00e8:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x0129;
    L_0x00ee:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.BaseActivity;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x00e8;
    L_0x00fa:
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x00e8;
    L_0x0100:
        r4 = setDrawable;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0110;
    L_0x0104:
        r4 = r0.OnDismissListener;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0110;
    L_0x010a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0070 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x0110:
        r4 = r7.HttpLogger;	 Catch:{ all -> 0x0070 }
        r5 = r0.o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.setDrawable.setDrawable(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.HttpLogger = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.o = r4;	 Catch:{ all -> 0x0070 }
        goto L_0x00e8;
    L_0x0129:
        r0 = r1.o;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x014c;
    L_0x012f:
        r0 = r7.getVisible;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x0135:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x014c;
    L_0x013b:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r7.HttpLogger;	 Catch:{ all -> 0x0070 }
        r5 = r1.getWidthPixels();	 Catch:{ all -> 0x0070 }
        r4 = r4 + r5;
        r5 = r7.SessionTask;	 Catch:{ all -> 0x0070 }
        if (r4 > r5) goto L_0x019f;
    L_0x014c:
        monitor-exit(r7);	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0002;
    L_0x014f:
        r0 = r1.BaseActivity;
        if (r0 != 0) goto L_0x01cd;
    L_0x0155:
        r0 = r1.o;
        if (r0 != 0) goto L_0x017b;
    L_0x015b:
        r0 = r1.SessionTask();	 Catch:{ Throwable -> 0x0223 }
        r3 = r1.getPhysicalXPixels();	 Catch:{ Throwable -> 0x0223 }
        r4 = r1.getHeightPixels();	 Catch:{ Throwable -> 0x0223 }
        r0 = com.duokan.reader.common.bitmap.setDrawable.getScaledMaximumFlingVelocity(r0, r3, r4);	 Catch:{ Throwable -> 0x0223 }
        r1.o = r0;	 Catch:{ Throwable -> 0x0223 }
        r0 = r7.HttpLogger;	 Catch:{ Throwable -> 0x0223 }
        r3 = r1.o;	 Catch:{ Throwable -> 0x0223 }
        r3 = com.duokan.reader.common.bitmap.setDrawable.setDrawable(r3);	 Catch:{ Throwable -> 0x0223 }
        r0 = r0 + r3;
        r7.HttpLogger = r0;	 Catch:{ Throwable -> 0x0223 }
    L_0x017b:
        r0 = r1.o;
        if (r0 == 0) goto L_0x01c5;
    L_0x0181:
        r0 = r1.getPhysicalXPixels;
        r3 = r1.o;
        r4 = r1.i;
        r0.setDrawable(r1, r3, r4);
        r1.getHeightPixels = r6;
    L_0x0193:
        r0 = r1.getScaledMaximumFlingVelocity;
        r0.getScaledMaximumFlingVelocity(r7);
        r1.getWidthPixels = r6;
        goto L_0x0002;
    L_0x019f:
        r4 = r0.OnDismissListener;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0135;
    L_0x01a5:
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0135;
    L_0x01ab:
        r4 = r7.HttpLogger;	 Catch:{ all -> 0x0070 }
        r5 = r0.o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.setDrawable.setDrawable(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.HttpLogger = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.o = r4;	 Catch:{ all -> 0x0070 }
        goto L_0x0135;
    L_0x01c5:
        r0 = r1.getPhysicalXPixels;
        r0.setDrawable(r1);
        goto L_0x0193;
    L_0x01cd:
        r0 = r1.getPhysicalXPixels;
        r0.setDrawable(r1);
        goto L_0x0193;
    L_0x01d5:
        monitor-enter(r7);
    L_0x01d6:
        r0 = r7.getVisible;	 Catch:{ all -> 0x01f6 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x01f6 }
        if (r0 != 0) goto L_0x0221;
    L_0x01de:
        r0 = r7.getVisible;	 Catch:{ all -> 0x01f6 }
        r0 = r0.getFirst();	 Catch:{ all -> 0x01f6 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x01f6 }
        r1 = setDrawable;	 Catch:{ all -> 0x01f6 }
        if (r1 != 0) goto L_0x01f9;
    L_0x01ea:
        r1 = r0.OnDismissListener;	 Catch:{ all -> 0x01f6 }
        if (r1 == 0) goto L_0x01f9;
    L_0x01f0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x01f6 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x01f6 }
        throw r0;	 Catch:{ all -> 0x01f6 }
    L_0x01f6:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x01f6 }
        throw r0;
    L_0x01f9:
        r1 = r0.getWidthPixels;	 Catch:{ all -> 0x01f6 }
        if (r1 != 0) goto L_0x0213;
    L_0x01ff:
        r1 = r0.getPhysicalXPixels;	 Catch:{ all -> 0x01f6 }
        r1.setDrawable(r0);	 Catch:{ all -> 0x01f6 }
        r1 = r0.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01f6 }
        r1.getScaledMaximumFlingVelocity(r7);	 Catch:{ all -> 0x01f6 }
    L_0x020d:
        r1 = r7.getVisible;	 Catch:{ all -> 0x01f6 }
        r1.remove(r0);	 Catch:{ all -> 0x01f6 }
        goto L_0x01d6;
    L_0x0213:
        r1 = r0.o;	 Catch:{ all -> 0x01f6 }
        if (r1 == 0) goto L_0x020d;
    L_0x0219:
        r1 = r0.o;	 Catch:{ all -> 0x01f6 }
        r1.recycle();	 Catch:{ all -> 0x01f6 }
        goto L_0x020d;
    L_0x0221:
        monitor-exit(r7);	 Catch:{ all -> 0x01f6 }
        return;
    L_0x0223:
        r0 = move-exception;
        goto L_0x017b;
    L_0x0226:
        r0 = r1;
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.al.getVisible():void");
    }

    private void c(ap apVar) {
        if (a || Thread.holdsLock(this)) {
            this.b.remove(apVar);
            this.b.addLast(apVar);
            return;
        }
        throw new AssertionError();
    }

    private ap b(bc bcVar, ak akVar, Rect rect, m mVar, float f, Object obj, ar arVar) {
        if (a || Thread.holdsLock(this)) {
            ap apVar = new ap(this, bcVar, akVar, rect, mVar, f, obj, arVar);
            this.b.addLast(apVar);
            this.d.release();
            return apVar;
        }
        throw new AssertionError();
    }

    private ap a(bc bcVar, ak akVar, Rect rect, m mVar, float f, aq aqVar) {
        if (a || Thread.holdsLock(this)) {
            ListIterator listIterator = this.b.listIterator(this.b.size());
            ap apVar = null;
            int i = 0;
            while (listIterator.hasPrevious()) {
                ap apVar2 = (ap) listIterator.previous();
                if (apVar2.c == bcVar && apVar2.f == mVar && apVar2.d.equals(akVar)) {
                    int a = apVar2.a(rect, f);
                    if (a != 0 && (aqVar == null || aqVar.a(apVar2, a))) {
                        ap apVar3;
                        int i2;
                        if (apVar == null || i < a) {
                            apVar3 = apVar2;
                            i2 = a;
                        } else {
                            i2 = i;
                            apVar3 = apVar;
                        }
                        if (i2 == Integer.MAX_VALUE) {
                            return apVar3;
                        }
                        apVar = apVar3;
                        i = i2;
                    }
                }
            }
            return apVar;
        }
        throw new AssertionError();
    }
}
