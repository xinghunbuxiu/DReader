package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

abstract class au extends bc {
    /* renamed from: m */
    static final /* synthetic */ boolean f4919m = (!au.class.desiredAssertionStatus());
    /* renamed from: i */
    public int[][] f4920i = new int[1000][];
    /* renamed from: j */
    public long f4921j = 0;
    /* renamed from: k */
    public int f4922k = 0;
    /* renamed from: l */
    public final LinkedList<ax> f4923l = new LinkedList();

    /* renamed from: e */
    public abstract C0987c mo1469e();

    /* renamed from: f */
    public abstract long mo1470f();

    public au(ae aeVar, ad adVar, Semaphore semaphore) {
        super(aeVar, adVar, semaphore);
    }

    /* renamed from: g */
    public ae m7523g() {
        return (ae) this.d;
    }

    /* renamed from: h */
    public ad m7524h() {
        return (ad) this.e;
    }

    /* renamed from: b */
    public long m7519b(long j) {
        int i = 0;
        if (!f4919m && m5839b() < 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return -1;
        } else {
            if (j >= mo1470f()) {
                return m5839b();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f4920i.length && this.f4920i[i2] != null && this.f4920i[i2].length >= 1 && ((long) this.f4920i[i2][0]) <= j) {
                i3 = i2;
                i2++;
            }
            if (this.f4920i[i3] == null) {
                return 0;
            }
            i2 = 0;
            while (i < this.f4920i[i3].length && this.f4920i[i3][i] >= 0 && ((long) this.f4920i[i3][i]) <= j) {
                i2 = i;
                i++;
            }
            return Math.max(0, Math.min((long) (i2 + (i3 * 1000)), m5839b() - 1));
        }
    }

    /* renamed from: c */
    public long m7520c(long j) {
        if (!f4919m && m5839b() < 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return Long.MIN_VALUE;
        } else {
            if (j >= m5839b()) {
                return Long.MAX_VALUE;
            }
            int i = ((int) j) % 1000;
            long j2 = -1;
            for (int min = Math.min(this.f4920i.length - 1, ((int) j) / 1000); min >= 0; min--) {
                if (this.f4920i[min] != null) {
                    i = Math.min(this.f4920i[min].length - 1, i);
                    while (i >= 0) {
                        j2 = (long) this.f4920i[min][i];
                        if (j2 >= 0) {
                            break;
                        }
                        i--;
                    }
                    if (j2 >= 0) {
                        break;
                    }
                }
            }
            return Math.max(0, j2);
        }
    }

    /* renamed from: a */
    public as m7517a(ai aiVar, ar arVar) {
        if (f4919m || this.a) {
            ax axVar = new ax(aiVar, arVar);
            synchronized (this) {
                this.f4923l.addFirst(axVar);
            }
            this.f.release();
            return axVar.f4934c;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public C0999o m7518a(C0989e c0989e, C0992n c0992n) {
        if (f4919m || this.a) {
            ai j = c0989e.m7560j();
            C0999o c0999o = new C0999o();
            ax axVar = new ax(j, new av(this, c0989e, j, c0992n, c0999o));
            c0999o.f4977a = axVar;
            synchronized (this) {
                this.f4923l.addFirst(axVar);
            }
            this.f.release();
            return c0999o;
        }
        throw new AssertionError();
    }

    /* renamed from: i */
    public ax m7525i() {
        synchronized (this) {
            Iterator it = this.f4923l.iterator();
            while (it.hasNext()) {
                ax axVar = (ax) it.next();
                if (!f4919m && axVar == null) {
                    throw new AssertionError();
                } else if (!f4919m && axVar.f4934c == null) {
                    throw new AssertionError();
                } else if (!axVar.f4934c.m7498b()) {
                    if (axVar.f4934c.m7500d()) {
                        axVar.f4934c.m7501e();
                    } else if (!f4919m && axVar.f4934c.m7499c()) {
                        throw new AssertionError();
                    } else if (!axVar.f4934c.m7499c()) {
                        return axVar;
                    }
                }
            }
            return null;
        }
    }
}
