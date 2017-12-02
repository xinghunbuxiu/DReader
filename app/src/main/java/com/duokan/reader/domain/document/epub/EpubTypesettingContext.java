package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.bc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

abstract class EpubTypesettingContext extends bc {
    static final /* synthetic */ boolean o = (!EpubTypesettingContext.class.desiredAssertionStatus());
    public long[][] i = new long[0][];
    public ChapterState[] j = new ChapterState[0];
    public long k = 0;
    public final ArrayList l = new ArrayList();
    public final ArrayList m = new ArrayList();
    public final LinkedList n = new LinkedList();

    public enum ChapterState {
        NOT_TYPESETTED,
        TYPESETTING,
        TYPESETTED
    }

    public abstract av a(String str, boolean z);

    public abstract e e();

    public abstract void f();

    public abstract List g();

    public abstract List h();

    public EpubTypesettingContext(ap apVar, am amVar, Semaphore semaphore) {
        super(apVar, amVar, semaphore);
    }

    public ap i() {
        return (ap) this.d;
    }

    public void a(ap apVar) {
        this.d = apVar;
    }

    public am j() {
        return (am) this.e;
    }

    public List b(long j) {
        HashSet hashSet = (HashSet) this.l.get((int) j);
        if (hashSet == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(hashSet.toArray(new av[0]));
    }

    public List c(long j) {
        HashSet hashSet = (HashSet) this.m.get((int) j);
        if (hashSet == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(hashSet.toArray(new av[0]));
    }

    public long d(long j) {
        if (this.i.length >= 1 && this.i[(int) j] != null) {
            return (long) this.i[(int) j].length;
        }
        return -1;
    }

    public long a(long j, long j2, long j3) {
        if (!o && b() < 0) {
            throw new AssertionError();
        } else if (j >= ((long) this.i.length) || j2 == Long.MAX_VALUE) {
            return b();
        } else {
            if (j < 0 || j2 == Long.MIN_VALUE) {
                return -1;
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
            i = 0;
            long j8 = j4;
            while (((long) i) < j) {
                j4 = ((long) this.i[i].length) + j8;
                i++;
                j8 = j4;
            }
            return j8;
        }
    }

    public cd a(ay ayVar, cc ccVar) {
        if (o || this.a) {
            ch chVar = new ch(ayVar, ccVar);
            synchronized (this) {
                this.n.addFirst(chVar);
            }
            this.f.release();
            return chVar.c;
        }
        throw new AssertionError();
    }

    public r a(h hVar, q qVar) {
        if (o || this.a) {
            ay j = hVar.j();
            r rVar = new r();
            ch chVar = new ch(j, new cf(this, hVar, j, qVar, rVar));
            rVar.a = chVar;
            synchronized (this) {
                this.n.addFirst(chVar);
            }
            this.f.release();
            return rVar;
        }
        throw new AssertionError();
    }

    public ch k() {
        synchronized (this) {
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ch chVar = (ch) it.next();
                if (!o && chVar == null) {
                    throw new AssertionError();
                } else if (!o && chVar.c == null) {
                    throw new AssertionError();
                } else if (!chVar.c.b()) {
                    if (chVar.c.d()) {
                        chVar.c.e();
                    } else if (!o && chVar.c.c()) {
                        throw new AssertionError();
                    } else if (!chVar.c.c()) {
                        return chVar;
                    }
                }
            }
            return null;
        }
    }

    public long[][] a(am amVar) {
        if (j() != amVar) {
            return (long[][]) null;
        }
        long[][] jArr = new long[this.i.length][];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = this.i[i] == null ? null : Arrays.copyOf(this.i[i], this.i[i].length);
        }
        return jArr;
    }
}
