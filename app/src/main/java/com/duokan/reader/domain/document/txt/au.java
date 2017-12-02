package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import miuipub.date.Calendar;

abstract class au extends bc {
    static final /* synthetic */ boolean m = (!au.class.desiredAssertionStatus());
    public int[][] i = new int[Calendar.MILLISECOND_OF_SECOND][];
    public long j = 0;
    public int k = 0;
    public final LinkedList l = new LinkedList();

    public abstract c e();

    public abstract long f();

    public au(ae aeVar, ad adVar, Semaphore semaphore) {
        super(aeVar, adVar, semaphore);
    }

    public ae g() {
        return (ae) this.d;
    }

    public ad h() {
        return (ad) this.e;
    }

    public long b(long j) {
        int i = 0;
        if (!m && b() < 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return -1;
        } else {
            if (j >= f()) {
                return b();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.i.length && this.i[i2] != null && this.i[i2].length >= 1 && ((long) this.i[i2][0]) <= j) {
                i3 = i2;
                i2++;
            }
            if (this.i[i3] == null) {
                return 0;
            }
            i2 = 0;
            while (i < this.i[i3].length && this.i[i3][i] >= 0 && ((long) this.i[i3][i]) <= j) {
                i2 = i;
                i++;
            }
            return Math.max(0, Math.min((long) (i2 + (i3 * Calendar.MILLISECOND_OF_SECOND)), b() - 1));
        }
    }

    public long c(long j) {
        if (!m && b() < 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return Long.MIN_VALUE;
        } else {
            if (j >= b()) {
                return Long.MAX_VALUE;
            }
            int i = ((int) j) % Calendar.MILLISECOND_OF_SECOND;
            long j2 = -1;
            for (int min = Math.min(this.i.length - 1, ((int) j) / Calendar.MILLISECOND_OF_SECOND); min >= 0; min--) {
                if (this.i[min] != null) {
                    i = Math.min(this.i[min].length - 1, i);
                    while (i >= 0) {
                        j2 = (long) this.i[min][i];
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

    public as a(ai aiVar, ar arVar) {
        if (m || this.a) {
            ax axVar = new ax(aiVar, arVar);
            synchronized (this) {
                this.l.addFirst(axVar);
            }
            this.f.release();
            return axVar.c;
        }
        throw new AssertionError();
    }

    public o a(e eVar, n nVar) {
        if (m || this.a) {
            ai j = eVar.j();
            o oVar = new o();
            ax axVar = new ax(j, new av(this, eVar, j, nVar, oVar));
            oVar.a = axVar;
            synchronized (this) {
                this.l.addFirst(axVar);
            }
            this.f.release();
            return oVar;
        }
        throw new AssertionError();
    }

    public ax i() {
        synchronized (this) {
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ax axVar = (ax) it.next();
                if (!m && axVar == null) {
                    throw new AssertionError();
                } else if (!m && axVar.c == null) {
                    throw new AssertionError();
                } else if (!axVar.c.b()) {
                    if (axVar.c.d()) {
                        axVar.c.e();
                    } else if (!m && axVar.c.c()) {
                        throw new AssertionError();
                    } else if (!axVar.c.c()) {
                        return axVar;
                    }
                }
            }
            return null;
        }
    }
}
