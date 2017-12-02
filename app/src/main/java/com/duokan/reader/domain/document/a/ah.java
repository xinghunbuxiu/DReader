package com.duokan.reader.domain.document.a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

abstract class ah extends bc {
    static final /* synthetic */ boolean m = (!ah.class.desiredAssertionStatus());
    public long[][] i = new long[0][];
    public DkFlowPosition j = new DkFlowPosition(1, 0, 0);
    public int k = 0;
    public final LinkedList l = new LinkedList();

    public abstract int a(v vVar);

    public abstract int b(v vVar);

    public abstract b e();

    public ah(r rVar, q qVar, Semaphore semaphore) {
        super(rVar, qVar, semaphore);
    }

    public r f() {
        return (r) this.d;
    }

    public q g() {
        return (q) this.e;
    }

    public DkFlowPosition b(long j) {
        int i;
        long j2;
        if (j < 0) {
            for (i = 0; i < this.i.length; i++) {
                if (this.i[i].length > 0) {
                    j2 = this.i[i][0];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                }
            }
            if (m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        } else if (j >= b()) {
            for (i = this.i.length - 1; i >= 0; i--) {
                if (this.i[i].length > 0) {
                    j2 = this.i[i][this.i[i].length - 1];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                }
            }
            if (m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        } else {
            i = 0;
            j2 = 0;
            while (i < this.i.length) {
                long length = ((long) this.i[i].length) + j2;
                if (j >= length) {
                    i++;
                    j2 = length;
                } else if (m || this.i[i].length > 0) {
                    j2 = this.i[i][(int) (j - j2)];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                } else {
                    throw new AssertionError();
                }
            }
            if (m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        }
    }

    public long a(long j, long j2, long j3) {
        if (m || b() >= 0) {
            long j4 = -1;
            for (int i = 0; i < this.i.length; i++) {
                long[] jArr = this.i[i];
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    long j5 = (long) ((int) (jArr[i2] >> 32));
                    long j6 = (long) ((int) jArr[i2]);
                    if (((long) i) > j) {
                        return Math.max(0, j4);
                    }
                    if (((long) i) == j && j5 > j2) {
                        return Math.max(0, j4);
                    }
                    if (((long) i) == j && j5 == j2 && j6 > j3) {
                        return Math.max(0, j4);
                    }
                    j4++;
                }
            }
            if (m) {
                return b() - 1;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public af a(v vVar, ae aeVar) {
        if (m || this.a) {
            ai aiVar = new ai(vVar, aeVar);
            synchronized (this) {
                this.l.addFirst(aiVar);
            }
            this.f.release();
            return aiVar.c;
        }
        throw new AssertionError();
    }

    public ai h() {
        synchronized (this) {
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (!m && aiVar == null) {
                    throw new AssertionError();
                } else if (!m && aiVar.c == null) {
                    throw new AssertionError();
                } else if (!aiVar.c.a()) {
                    if (aiVar.c.c()) {
                        aiVar.c.d();
                    } else if (!m && aiVar.c.b()) {
                        throw new AssertionError();
                    } else if (!aiVar.c.b()) {
                        return aiVar;
                    }
                }
            }
            return null;
        }
    }
}
