package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.sys.j;
import com.duokan.core.sys.o;
import com.duokan.core.sys.r;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.aw;
import com.duokan.reader.domain.document.epub.ax;

import java.io.InputStream;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

class gz implements av {
    static final /* synthetic */ boolean a = (!fv.class.desiredAssertionStatus());
    final /* synthetic */ fv b;
    private final aw c;
    private final String d;
    private final boolean e;
    private final AtomicReference f = new AtomicReference();
    private boolean g = false;

    public gz(fv fvVar, String str, aw awVar, boolean z) {
        this.b = fvVar;
        this.d = str;
        this.c = awVar;
        this.e = z;
        this.f.set(n());
    }

    public String a() {
        return this.d;
    }

    public int b() {
        if (i()) {
            return 1;
        }
        FutureTask futureTask = (FutureTask) this.f.get();
        if (futureTask.isDone()) {
            this.f.compareAndSet(futureTask, n());
            futureTask = (FutureTask) this.f.get();
        }
        futureTask.run();
        Pair pair = (Pair) futureTask.get();
        int intValue = ((Integer) pair.first).intValue();
        long longValue = ((Long) pair.second).longValue();
        if (intValue != 0) {
            return intValue;
        }
        return j.a().getId() == longValue ? 0 : 1;
    }

    public boolean c() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (i()) {
            return true;
        } else {
            try {
                ((FutureTask) this.f.get()).get();
                return i();
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable th) {
                return i();
            }
        }
    }

    public String d() {
        return this.e ? this.c.f : this.c.c;
    }

    public int e() {
        return (int) (this.e ? this.c.h : this.c.e);
    }

    public String f() {
        return this.e ? this.c.g : this.c.d;
    }

    public aw g() {
        return this.c;
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.c.c);
    }

    public boolean i() {
        if (this.g) {
            return this.g;
        }
        if (o()) {
            this.g = true;
        }
        return this.g;
    }

    public boolean j() {
        return this.e;
    }

    public boolean k() {
        return this.c.i;
    }

    public av l() {
        return this.b.a(this.c, !this.e);
    }

    public ax m() {
        if (!i()) {
            return null;
        }
        try {
            r e = this.b.bt();
            if (a || e != null) {
                return new hb(this.b, e, this.d, this.e);
            }
            throw new AssertionError();
        } catch (Throwable th) {
            return null;
        }
    }

    private FutureTask n() {
        return new FutureTask(new ha(this));
    }

    private boolean o() {
        r e = this.b.bt();
        if (!a && e == null) {
            throw new AssertionError();
        } else if (e == null || TextUtils.isEmpty(this.c.c)) {
            return false;
        } else {
            if (e.a(this.d)) {
                return true;
            }
            String substring = this.d.substring(0, this.d.indexOf(35));
            if (!e.a(substring)) {
                return false;
            }
            try {
                InputStream c = e.c(substring);
                String a = o.a(c, "md5");
                c.close();
                e.a(substring, substring + "#md5=" + a.substring(0, Math.min(4, a.length())));
                if (e.a(this.d)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
    }
}
