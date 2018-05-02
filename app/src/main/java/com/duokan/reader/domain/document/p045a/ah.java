package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.reader.domain.document.bc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/* renamed from: com.duokan.reader.domain.document.a.ah */
abstract class ah extends bc {
    /* renamed from: m */
    static final /* synthetic */ boolean f4252m = (!ah.class.desiredAssertionStatus());
    /* renamed from: i */
    public long[][] f4253i = new long[0][];
    /* renamed from: j */
    public DkFlowPosition f4254j = new DkFlowPosition(1, 0, 0);
    /* renamed from: k */
    public int f4255k = 0;
    /* renamed from: l */
    public final LinkedList<ai> f4256l = new LinkedList();

    /* renamed from: a */
    public abstract int mo1270a(C0925v c0925v);

    /* renamed from: b */
    public abstract int mo1271b(C0925v c0925v);

    /* renamed from: e */
    public abstract C0900b mo1273e();

    public ah(C0920r c0920r, C0918q c0918q, Semaphore semaphore) {
        super(c0920r, c0918q, semaphore);
    }

    /* renamed from: f */
    public C0920r m5851f() {
        return (C0920r) this.d;
    }

    /* renamed from: g */
    public C0918q m5852g() {
        return (C0918q) this.e;
    }

    /* renamed from: b */
    public DkFlowPosition m5849b(long j) {
        int i;
        long j2;
        if (j < 0) {
            for (i = 0; i < this.f4253i.length; i++) {
                if (this.f4253i[i].length > 0) {
                    j2 = this.f4253i[i][0];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                }
            }
            if (f4252m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        } else if (j >= m5839b()) {
            for (i = this.f4253i.length - 1; i >= 0; i--) {
                if (this.f4253i[i].length > 0) {
                    j2 = this.f4253i[i][this.f4253i[i].length - 1];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                }
            }
            if (f4252m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        } else {
            i = 0;
            j2 = 0;
            while (i < this.f4253i.length) {
                long length = ((long) this.f4253i[i].length) + j2;
                if (j >= length) {
                    i++;
                    j2 = length;
                } else if (f4252m || this.f4253i[i].length > 0) {
                    j2 = this.f4253i[i][(int) (j - j2)];
                    return new DkFlowPosition((long) (i + 1), (long) ((int) (j2 >> 32)), (long) ((int) j2));
                } else {
                    throw new AssertionError();
                }
            }
            if (f4252m) {
                return new DkFlowPosition(1, 0, 0);
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public long m5846a(long j, long j2, long j3) {
        if (f4252m || m5839b() >= 0) {
            long j4 = -1;
            for (int i = 0; i < this.f4253i.length; i++) {
                long[] jArr = this.f4253i[i];
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
            if (f4252m) {
                return m5839b() - 1;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public af m5847a(C0925v c0925v, ae aeVar) {
        if (f4252m || this.a) {
            ai aiVar = new ai(c0925v, aeVar);
            synchronized (this) {
                this.f4256l.addFirst(aiVar);
            }
            this.f.release();
            return aiVar.f4260c;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public ai m5853h() {
        synchronized (this) {
            Iterator it = this.f4256l.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (!f4252m && aiVar == null) {
                    throw new AssertionError();
                } else if (!f4252m && aiVar.f4260c == null) {
                    throw new AssertionError();
                } else if (!aiVar.f4260c.m5805a()) {
                    if (aiVar.f4260c.m5807c()) {
                        aiVar.f4260c.m5808d();
                    } else if (!f4252m && aiVar.f4260c.m5806b()) {
                        throw new AssertionError();
                    } else if (!aiVar.f4260c.m5806b()) {
                        return aiVar;
                    }
                }
            }
            return null;
        }
    }
}
