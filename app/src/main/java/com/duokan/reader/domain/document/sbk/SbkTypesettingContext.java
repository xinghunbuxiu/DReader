package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.document.bc;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

abstract class SbkTypesettingContext extends bc {
    /* renamed from: m */
    static final /* synthetic */ boolean f4767m = (!SbkTypesettingContext.class.desiredAssertionStatus());
    /* renamed from: i */
    public long[][] f4768i = new long[0][];
    /* renamed from: j */
    public ChapterState[] f4769j = new ChapterState[0];
    /* renamed from: k */
    public long f4770k = 0;
    /* renamed from: l */
    public final LinkedList<ai> f4771l = new LinkedList();

    public enum ChapterState {
        NOT_TYPESETTED,
        TYPESETTING,
        TYPESETTED
    }

    /* renamed from: e */
    public abstract C0966c mo1453e();

    public SbkTypesettingContext(C0978s c0978s, C0977p c0977p, Semaphore semaphore) {
        super(c0978s, c0977p, semaphore);
    }

    /* renamed from: f */
    public C0978s m7106f() {
        return (C0978s) this.d;
    }

    /* renamed from: a */
    public void m7102a(C0978s c0978s) {
        this.d = c0978s;
    }

    /* renamed from: g */
    public C0977p m7107g() {
        return (C0977p) this.e;
    }

    /* renamed from: b */
    public long m7103b(long j) {
        if (j < 0 || this.f4768i.length < 1 || ((long) this.f4768i.length) < 1 + j || this.f4768i[(int) j] == null) {
            return -1;
        }
        return (long) this.f4768i[(int) j].length;
    }

    /* renamed from: a */
    public long m7100a(long j, long j2, long j3) {
        WebLog.init().w(m5839b() >= 0);
        if (j >= ((long) this.f4768i.length)) {
            return m5839b();
        }
        if (j < 0) {
            return -1;
        }
        long b = m7104b(j, j2, j3);
        int i = 0;
        while (((long) i) < j) {
            i++;
            b = ((long) this.f4768i[i].length) + b;
        }
        return b;
    }

    /* renamed from: b */
    public long m7104b(long j, long j2, long j3) {
        WebLog.init().w(m7103b(j) >= 0);
        if (j < 0 || j >= ((long) this.f4768i.length)) {
            return 0;
        }
        long j4 = 0;
        int i = 0;
        int length = this.f4768i[(int) j].length;
        while (i < length) {
            long j5;
            int i2 = (i + length) / 2;
            long j6 = this.f4768i[(int) j][i2];
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

    /* renamed from: a */
    public ag m7101a(C0982x c0982x, af afVar) {
        if (f4767m || this.a) {
            ai aiVar = new ai(c0982x, afVar);
            synchronized (this) {
                this.f4771l.addFirst(aiVar);
            }
            this.f.release();
            return aiVar.f4795c;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public ai m7108h() {
        synchronized (this) {
            Iterator it = this.f4771l.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (!f4767m && aiVar == null) {
                    throw new AssertionError();
                } else if (!f4767m && aiVar.f4795c == null) {
                    throw new AssertionError();
                } else if (!aiVar.f4795c.m7114a()) {
                    if (aiVar.f4795c.m7116c()) {
                        aiVar.f4795c.m7117d();
                    } else if (!f4767m && aiVar.f4795c.m7115b()) {
                        throw new AssertionError();
                    } else if (!aiVar.f4795c.m7115b()) {
                        return aiVar;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: i */
    public long[][] m7109i() {
        long[][] jArr = new long[this.f4768i.length][];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = this.f4768i[i] == null ? null : Arrays.copyOf(this.f4768i[i], this.f4768i[i].length);
        }
        return jArr;
    }
}
