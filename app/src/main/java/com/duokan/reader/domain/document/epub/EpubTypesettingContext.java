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
    /* renamed from: o */
    static final /* synthetic */ boolean f4450o = (!EpubTypesettingContext.class.desiredAssertionStatus());
    /* renamed from: i */
    public long[][] f4451i = new long[0][];
    /* renamed from: j */
    public ChapterState[] f4452j = new ChapterState[0];
    /* renamed from: k */
    public long f4453k = 0;
    /* renamed from: l */
    public final ArrayList<HashSet<av>> f4454l = new ArrayList();
    /* renamed from: m */
    public final ArrayList<HashSet<av>> f4455m = new ArrayList();
    /* renamed from: n */
    public final LinkedList<ch> f4456n = new LinkedList();

    public enum ChapterState {
        NOT_TYPESETTED,
        TYPESETTING,
        TYPESETTED
    }

    /* renamed from: a */
    public abstract av mo1368a(String str, boolean z);

    /* renamed from: e */
    public abstract C0934e mo1369e();

    /* renamed from: f */
    public abstract void mo1370f();

    /* renamed from: g */
    public abstract List<av> mo1371g();

    /* renamed from: h */
    public abstract List<av> mo1372h();

    public EpubTypesettingContext(ap apVar, am amVar, Semaphore semaphore) {
        super(apVar, amVar, semaphore);
    }

    /* renamed from: i */
    public ap m6454i() {
        return (ap) this.d;
    }

    /* renamed from: a */
    public void m6445a(ap apVar) {
        this.d = apVar;
    }

    /* renamed from: j */
    public am m6455j() {
        return (am) this.e;
    }

    /* renamed from: b */
    public List<av> m6447b(long j) {
        HashSet hashSet = (HashSet) this.f4454l.get((int) j);
        if (hashSet == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(hashSet.toArray(new av[0]));
    }

    /* renamed from: c */
    public List<av> m6448c(long j) {
        HashSet hashSet = (HashSet) this.f4455m.get((int) j);
        if (hashSet == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(hashSet.toArray(new av[0]));
    }

    /* renamed from: d */
    public long m6449d(long j) {
        if (this.f4451i.length >= 1 && this.f4451i[(int) j] != null) {
            return (long) this.f4451i[(int) j].length;
        }
        return -1;
    }

    /* renamed from: a */
    public long m6441a(long j, long j2, long j3) {
        if (!f4450o && m5839b() < 0) {
            throw new AssertionError();
        } else if (j >= ((long) this.f4451i.length) || j2 == Long.MAX_VALUE) {
            return m5839b();
        } else {
            if (j < 0 || j2 == Long.MIN_VALUE) {
                return -1;
            }
            long j4 = 0;
            int i = 0;
            int length = this.f4451i[(int) j].length;
            while (i < length) {
                long j5;
                int i2 = (i + length) / 2;
                long j6 = this.f4451i[(int) j][i2];
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
                j4 = ((long) this.f4451i[i].length) + j8;
                i++;
                j8 = j4;
            }
            return j8;
        }
    }

    /* renamed from: a */
    public cd m6443a(ay ayVar, cc ccVar) {
        if (f4450o || this.a) {
            ch chVar = new ch(ayVar, ccVar);
            synchronized (this) {
                this.f4456n.addFirst(chVar);
            }
            this.f.release();
            return chVar.f4664c;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public C0951r m6444a(C0940h c0940h, C0944q c0944q) {
        if (f4450o || this.a) {
            ay j = c0940h.m6846j();
            C0951r c0951r = new C0951r();
            ch chVar = new ch(j, new cf(this, c0940h, j, c0944q, c0951r));
            c0951r.f4721a = chVar;
            synchronized (this) {
                this.f4456n.addFirst(chVar);
            }
            this.f.release();
            return c0951r;
        }
        throw new AssertionError();
    }

    /* renamed from: k */
    public ch m6456k() {
        synchronized (this) {
            Iterator it = this.f4456n.iterator();
            while (it.hasNext()) {
                ch chVar = (ch) it.next();
                if (!f4450o && chVar == null) {
                    throw new AssertionError();
                } else if (!f4450o && chVar.f4664c == null) {
                    throw new AssertionError();
                } else if (!chVar.f4664c.m6795b()) {
                    if (chVar.f4664c.m6797d()) {
                        chVar.f4664c.m6798e();
                    } else if (!f4450o && chVar.f4664c.m6796c()) {
                        throw new AssertionError();
                    } else if (!chVar.f4664c.m6796c()) {
                        return chVar;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public long[][] m6446a(am amVar) {
        if (m6455j() != amVar) {
            return (long[][]) null;
        }
        long[][] jArr = new long[this.f4451i.length][];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = this.f4451i[i] == null ? null : Arrays.copyOf(this.f4451i[i], this.f4451i[i].length);
        }
        return jArr;
    }
}
