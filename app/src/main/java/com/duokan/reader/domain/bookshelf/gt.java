package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.aw;
import com.duokan.reader.domain.document.epub.ax;
import java.io.InputStream;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

class gt implements av {
    /* renamed from: a */
    static final /* synthetic */ boolean f3257a = (!fp.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ fp f3258b;
    /* renamed from: c */
    private final aw f3259c;
    /* renamed from: d */
    private final String f3260d;
    /* renamed from: e */
    private final boolean f3261e;
    /* renamed from: f */
    private final AtomicReference<FutureTask<Pair<Integer, Long>>> f3262f = new AtomicReference();
    /* renamed from: g */
    private boolean f3263g = false;

    public gt(fp fpVar, String str, aw awVar, boolean z) {
        this.f3258b = fpVar;
        this.f3260d = str;
        this.f3259c = awVar;
        this.f3261e = z;
        this.f3262f.set(m4575n());
    }

    /* renamed from: a */
    public String m4577a() {
        return this.f3260d;
    }

    /* renamed from: b */
    public int m4578b() {
        if (mo1073i()) {
            return 1;
        }
        FutureTask futureTask = (FutureTask) this.f3262f.get();
        if (futureTask.isDone()) {
            this.f3262f.compareAndSet(futureTask, m4575n());
            futureTask = (FutureTask) this.f3262f.get();
        }
        futureTask.run();
        Pair pair = (Pair) futureTask.get();
        int intValue = ((Integer) pair.first).intValue();
        long longValue = ((Long) pair.second).longValue();
        if (intValue != 0) {
            return intValue;
        }
        return UIdleHandler.getCurrentThread().getId() == longValue ? 0 : 1;
    }

    /* renamed from: c */
    public boolean m4579c() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (mo1073i()) {
            return true;
        } else {
            try {
                ((FutureTask) this.f3262f.get()).get();
                return mo1073i();
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable th) {
                return mo1073i();
            }
        }
    }

    /* renamed from: d */
    public String m4580d() {
        return this.f3261e ? this.f3259c.f4497f : this.f3259c.f4494c;
    }

    /* renamed from: e */
    public int mo1070e() {
        return (int) (this.f3261e ? this.f3259c.f4499h : this.f3259c.f4496e);
    }

    /* renamed from: f */
    public String m4582f() {
        return this.f3261e ? this.f3259c.f4498g : this.f3259c.f4495d;
    }

    /* renamed from: g */
    public aw mo1071g() {
        return this.f3259c;
    }

    /* renamed from: h */
    public boolean mo1072h() {
        return !TextUtils.isEmpty(this.f3259c.f4494c);
    }

    /* renamed from: i */
    public boolean mo1073i() {
        if (this.f3263g) {
            return this.f3263g;
        }
        if (m4576o()) {
            this.f3263g = true;
        }
        return this.f3263g;
    }

    /* renamed from: j */
    public boolean mo1074j() {
        return this.f3261e;
    }

    /* renamed from: k */
    public boolean mo1075k() {
        return this.f3259c.f4500i;
    }

    /* renamed from: l */
    public av mo1076l() {
        return this.f3258b.m4465a(this.f3259c, !this.f3261e);
    }

    /* renamed from: m */
    public ax mo1077m() {
        if (!mo1073i()) {
            return null;
        }
        try {
            C0352r e = this.f3258b.bv();
            if (f3257a || e != null) {
                return new gv(this.f3258b, e, this.f3260d, this.f3261e);
            }
            throw new AssertionError();
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: n */
    private FutureTask<Pair<Integer, Long>> m4575n() {
        return new FutureTask(new gu(this));
    }

    /* renamed from: o */
    private boolean m4576o() {
        C0352r e = this.f3258b.bv();
        if (!f3257a && e == null) {
            throw new AssertionError();
        } else if (e == null || TextUtils.isEmpty(this.f3259c.f4494c)) {
            return false;
        } else {
            if (e.mo418a(this.f3260d)) {
                return true;
            }
            String substring = this.f3260d.substring(0, this.f3260d.indexOf(35));
            if (!e.mo418a(substring)) {
                return false;
            }
            try {
                InputStream c = e.mo422c(substring);
                String a = C0366o.m1029a(c, "md5");
                c.close();
                e.mo419a(substring, substring + "#md5=" + a.substring(0, Math.min(4, a.length())));
                if (e.mo418a(this.f3260d)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
    }
}
