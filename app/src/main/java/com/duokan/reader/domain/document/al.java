package com.duokan.reader.domain.document;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class al {
    /* renamed from: a */
    static final /* synthetic */ boolean f4404a = (!al.class.desiredAssertionStatus());
    /* renamed from: b */
    private final LinkedList<ap> f4405b = new LinkedList();
    /* renamed from: c */
    private final Thread f4406c = new Thread(new am(this));
    /* renamed from: d */
    private final Semaphore f4407d = new Semaphore(0);
    /* renamed from: e */
    private boolean f4408e = false;
    /* renamed from: f */
    private int f4409f = 0;
    /* renamed from: g */
    private int f4410g = 3145728;

    public al() {
        this.f4406c.start();
    }

    /* renamed from: a */
    public void m6358a(int i) {
        this.f4410g = i;
    }

    /* renamed from: a */
    public final ap m6356a(bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, Object obj, ar arVar) {
        ap b;
        synchronized (this) {
            bcVar.m5841b((Object) this);
            b = m6351b(bcVar, akVar, rect, c0923m, f, obj, arVar);
            b.f4428l = true;
        }
        return b;
    }

    /* renamed from: a */
    public final ap m6354a(bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, Object obj) {
        ap a;
        synchronized (this) {
            a = m6349a(bcVar, akVar, rect, c0923m, f, new an(this, obj));
            if (a != null) {
                m6353c(a);
                a.f4428l = true;
            }
        }
        return a;
    }

    /* renamed from: a */
    public final ap m6355a(bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, Object obj, int i) {
        ap a;
        synchronized (this) {
            a = m6349a(bcVar, akVar, rect, c0923m, f, new ao(this, obj, i));
            if (a != null) {
                m6353c(a);
                a.f4428l = true;
            }
        }
        return a;
    }

    /* renamed from: a */
    public final void m6359a(ap apVar) {
        synchronized (this) {
            apVar.f4428l = false;
        }
    }

    /* renamed from: a */
    public final void m6360a(ap apVar, boolean z) {
        synchronized (this) {
            apVar.f4428l = false;
            apVar.f4429m = true;
            apVar.f4430n = z;
        }
        this.f4407d.release();
    }

    /* renamed from: b */
    public final void m6361b(ap apVar) {
        m6360a(apVar, false);
    }

    /* renamed from: a */
    public final void m6357a() {
        this.f4408e = true;
        try {
            this.f4407d.release();
            this.f4406c.join();
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m6352b() {
        /*
        r7 = this;
        r6 = 1;
        r2 = 0;
    L_0x0002:
        r0 = r7.f4408e;
        if (r0 != 0) goto L_0x01d5;
    L_0x0006:
        r0 = r7.f4407d;
        r0.acquireUninterruptibly();
        monitor-enter(r7);
        r0 = r7.f4405b;	 Catch:{ all -> 0x0070 }
        r1 = r7.f4405b;	 Catch:{ all -> 0x0070 }
        r1 = r1.size();	 Catch:{ all -> 0x0070 }
        r3 = r0.listIterator(r1);	 Catch:{ all -> 0x0070 }
        r1 = r2;
    L_0x0019:
        r0 = r3.hasPrevious();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x007d;
    L_0x001f:
        r0 = r3.previous();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4429m;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0060;
    L_0x002b:
        r4 = r0.f4430n;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0060;
    L_0x0031:
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x004f;
    L_0x0037:
        r4 = r7.f4409f;	 Catch:{ all -> 0x0070 }
        r5 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.C0544a.m2427a(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.f4409f = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.f4431o = r4;	 Catch:{ all -> 0x0070 }
    L_0x004f:
        r4 = r0.f4426j;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0060;
    L_0x0055:
        r4 = r0.f4419c;	 Catch:{ all -> 0x0070 }
        r4.m5842c(r7);	 Catch:{ all -> 0x0070 }
        r4 = 1;
        r0.f4426j = r4;	 Catch:{ all -> 0x0070 }
    L_0x0060:
        r4 = r0.f4426j;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0073;
    L_0x0066:
        r0 = r0.f4431o;	 Catch:{ all -> 0x0070 }
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
        r4 = r0.f4426j;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0226;
    L_0x007b:
        r1 = r0;
        goto L_0x0019;
    L_0x007d:
        if (r1 == 0) goto L_0x014c;
    L_0x007f:
        r0 = r1.f4429m;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x014c;
    L_0x0085:
        r0 = r7.f4405b;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x008b:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x00dc;
    L_0x0091:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4429m;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x008b;
    L_0x009d:
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x008b;
    L_0x00a3:
        r4 = r0.m6393k();	 Catch:{ all -> 0x0070 }
        r5 = r1.m6393k();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00ad:
        r4 = r0.m6389g();	 Catch:{ all -> 0x0070 }
        r5 = r1.m6389g();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00b7:
        r4 = r0.m6390h();	 Catch:{ all -> 0x0070 }
        r5 = r1.m6390h();	 Catch:{ all -> 0x0070 }
        if (r4 != r5) goto L_0x008b;
    L_0x00c1:
        r3 = f4404a;	 Catch:{ all -> 0x0070 }
        if (r3 != 0) goto L_0x00d1;
    L_0x00c5:
        r3 = r0.f4428l;	 Catch:{ all -> 0x0070 }
        if (r3 == 0) goto L_0x00d1;
    L_0x00cb:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x00d1:
        r3 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r1.f4431o = r3;	 Catch:{ all -> 0x0070 }
        r3 = 0;
        r0.f4431o = r3;	 Catch:{ all -> 0x0070 }
    L_0x00dc:
        r0 = r1.f4431o;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0129;
    L_0x00e2:
        r0 = r7.f4405b;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x00e8:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x0129;
    L_0x00ee:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4429m;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x00e8;
    L_0x00fa:
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x00e8;
    L_0x0100:
        r4 = f4404a;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0110;
    L_0x0104:
        r4 = r0.f4428l;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0110;
    L_0x010a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x0110:
        r4 = r7.f4409f;	 Catch:{ all -> 0x0070 }
        r5 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.C0544a.m2427a(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.f4409f = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.f4431o = r4;	 Catch:{ all -> 0x0070 }
        goto L_0x00e8;
    L_0x0129:
        r0 = r1.f4431o;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x014c;
    L_0x012f:
        r0 = r7.f4405b;	 Catch:{ all -> 0x0070 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0070 }
    L_0x0135:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x014c;
    L_0x013b:
        r0 = r3.next();	 Catch:{ all -> 0x0070 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x0070 }
        r4 = r7.f4409f;	 Catch:{ all -> 0x0070 }
        r5 = r1.m6392j();	 Catch:{ all -> 0x0070 }
        r4 = r4 + r5;
        r5 = r7.f4410g;	 Catch:{ all -> 0x0070 }
        if (r4 > r5) goto L_0x019f;
    L_0x014c:
        monitor-exit(r7);	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0002;
    L_0x014f:
        r0 = r1.f4429m;
        if (r0 != 0) goto L_0x01cd;
    L_0x0155:
        r0 = r1.f4431o;
        if (r0 != 0) goto L_0x017b;
    L_0x015b:
        r0 = r1.m6389g();	 Catch:{ Throwable -> 0x0223 }
        r3 = r1.m6390h();	 Catch:{ Throwable -> 0x0223 }
        r4 = r1.m6393k();	 Catch:{ Throwable -> 0x0223 }
        r0 = com.duokan.reader.common.bitmap.C0544a.m2447c(r0, r3, r4);	 Catch:{ Throwable -> 0x0223 }
        r1.f4431o = r0;	 Catch:{ Throwable -> 0x0223 }
        r0 = r7.f4409f;	 Catch:{ Throwable -> 0x0223 }
        r3 = r1.f4431o;	 Catch:{ Throwable -> 0x0223 }
        r3 = com.duokan.reader.common.bitmap.C0544a.m2427a(r3);	 Catch:{ Throwable -> 0x0223 }
        r0 = r0 + r3;
        r7.f4409f = r0;	 Catch:{ Throwable -> 0x0223 }
    L_0x017b:
        r0 = r1.f4431o;
        if (r0 == 0) goto L_0x01c5;
    L_0x0181:
        r0 = r1.f4424h;
        r3 = r1.f4431o;
        r4 = r1.f4425i;
        r0.mo1195a(r1, r3, r4);
        r1.f4427k = r6;
    L_0x0193:
        r0 = r1.f4419c;
        r0.m5842c(r7);
        r1.f4426j = r6;
        goto L_0x0002;
    L_0x019f:
        r4 = r0.f4428l;	 Catch:{ all -> 0x0070 }
        if (r4 != 0) goto L_0x0135;
    L_0x01a5:
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        if (r4 == 0) goto L_0x0135;
    L_0x01ab:
        r4 = r7.f4409f;	 Catch:{ all -> 0x0070 }
        r5 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r5 = com.duokan.reader.common.bitmap.C0544a.m2427a(r5);	 Catch:{ all -> 0x0070 }
        r4 = r4 - r5;
        r7.f4409f = r4;	 Catch:{ all -> 0x0070 }
        r4 = r0.f4431o;	 Catch:{ all -> 0x0070 }
        r4.recycle();	 Catch:{ all -> 0x0070 }
        r4 = 0;
        r0.f4431o = r4;	 Catch:{ all -> 0x0070 }
        goto L_0x0135;
    L_0x01c5:
        r0 = r1.f4424h;
        r0.mo1194a(r1);
        goto L_0x0193;
    L_0x01cd:
        r0 = r1.f4424h;
        r0.mo1194a(r1);
        goto L_0x0193;
    L_0x01d5:
        monitor-enter(r7);
    L_0x01d6:
        r0 = r7.f4405b;	 Catch:{ all -> 0x01f6 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x01f6 }
        if (r0 != 0) goto L_0x0221;
    L_0x01de:
        r0 = r7.f4405b;	 Catch:{ all -> 0x01f6 }
        r0 = r0.getFirst();	 Catch:{ all -> 0x01f6 }
        r0 = (com.duokan.reader.domain.document.ap) r0;	 Catch:{ all -> 0x01f6 }
        r1 = f4404a;	 Catch:{ all -> 0x01f6 }
        if (r1 != 0) goto L_0x01f9;
    L_0x01ea:
        r1 = r0.f4428l;	 Catch:{ all -> 0x01f6 }
        if (r1 == 0) goto L_0x01f9;
    L_0x01f0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x01f6 }
        r0.<init>();	 Catch:{ all -> 0x01f6 }
        throw r0;	 Catch:{ all -> 0x01f6 }
    L_0x01f6:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x01f6 }
        throw r0;
    L_0x01f9:
        r1 = r0.f4426j;	 Catch:{ all -> 0x01f6 }
        if (r1 != 0) goto L_0x0213;
    L_0x01ff:
        r1 = r0.f4424h;	 Catch:{ all -> 0x01f6 }
        r1.mo1194a(r0);	 Catch:{ all -> 0x01f6 }
        r1 = r0.f4419c;	 Catch:{ all -> 0x01f6 }
        r1.m5842c(r7);	 Catch:{ all -> 0x01f6 }
    L_0x020d:
        r1 = r7.f4405b;	 Catch:{ all -> 0x01f6 }
        r1.remove(r0);	 Catch:{ all -> 0x01f6 }
        goto L_0x01d6;
    L_0x0213:
        r1 = r0.f4431o;	 Catch:{ all -> 0x01f6 }
        if (r1 == 0) goto L_0x020d;
    L_0x0219:
        r1 = r0.f4431o;	 Catch:{ all -> 0x01f6 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.al.b():void");
    }

    /* renamed from: c */
    private void m6353c(ap apVar) {
        if (f4404a || Thread.holdsLock(this)) {
            this.f4405b.remove(apVar);
            this.f4405b.addLast(apVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private ap m6351b(bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, Object obj, ar arVar) {
        if (f4404a || Thread.holdsLock(this)) {
            ap apVar = new ap(this, bcVar, akVar, rect, c0923m, f, obj, arVar);
            this.f4405b.addLast(apVar);
            this.f4407d.release();
            return apVar;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private ap m6349a(bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, aq aqVar) {
        if (f4404a || Thread.holdsLock(this)) {
            ListIterator listIterator = this.f4405b.listIterator(this.f4405b.size());
            ap apVar = null;
            int i = 0;
            while (listIterator.hasPrevious()) {
                ap apVar2 = (ap) listIterator.previous();
                if (apVar2.f4419c == bcVar && apVar2.f4422f == c0923m && apVar2.f4420d.equals(akVar)) {
                    int a = apVar2.m6381a(rect, f);
                    if (a != 0 && (aqVar == null || aqVar.mo1357a(apVar2, a))) {
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
