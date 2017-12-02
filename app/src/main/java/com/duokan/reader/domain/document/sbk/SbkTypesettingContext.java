package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.document.bc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

abstract class SbkTypesettingContext extends bc {
    static final /* synthetic */ boolean m = (!SbkTypesettingContext.class.desiredAssertionStatus());
    public long[][] i = new long[0][];
    public ChapterState[] j = new ChapterState[0];
    public long k = 0;
    public final LinkedList l = new LinkedList();

    public enum ChapterState {
        NOT_TYPESETTED,
        TYPESETTING,
        TYPESETTED
    }

    public abstract c e();

    public SbkTypesettingContext(s sVar, p pVar, Semaphore semaphore) {
        super(sVar, pVar, semaphore);
    }

    public s f() {
        return (s) this.d;
    }

    public void a(s sVar) {
        this.d = sVar;
    }

    public p g() {
        return (p) this.e;
    }

    public long b(long j) {
        if (j < 0 || this.i.length < 1 || ((long) this.i.length) < 1 + j || this.i[(int) j] == null) {
            return -1;
        }
        return (long) this.i[(int) j].length;
    }

    public long a(long j, long j2, long j3) {
        a.c().b(b() >= 0);
        if (j >= ((long) this.i.length)) {
            return b();
        }
        if (j < 0) {
            return -1;
        }
        long b = b(j, j2, j3);
        int i = 0;
        while (((long) i) < j) {
            i++;
            b = ((long) this.i[i].length) + b;
        }
        return b;
    }

    public long b(long j, long j2, long j3) {
        a.c().b(b(j) >= 0);
        if (j < 0 || j >= ((long) this.i.length)) {
            return 0;
        }
        long j4 = 0;
        int i = 0;
        int length = this.i[(int) j].length;
        while (i < length) {
            long j5;
            int i2 = (i + length) / 2;
            long j6 = this.i[(int) j][i2];
            long j7 = (long) ((int) (j6 >> 32));
            j6 = (long) ((int) j6);
            if (j7 > j2 || (j7 == j2 && j6 > j3)) {
                length = i2;
                i2 = i;
                j5 = j4;
            } else {
                j5 = (long) i2;
                i2++;
            }
            j4 = j5;
            i = i2;
        }
        return j4;
    }

    public ag a(x xVar, af afVar) {
        if (m || this.a) {
            ai aiVar = new ai(xVar, afVar);
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

    public long[][] i() {
        long[][] jArr = new long[this.i.length][];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = this.i[i] == null ? null : Arrays.copyOf(this.i[i], this.i[i].length);
        }
        return jArr;
    }
}
