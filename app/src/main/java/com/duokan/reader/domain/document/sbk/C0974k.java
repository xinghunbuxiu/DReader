package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0919l;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.duokan.reader.domain.document.sbk.k */
class C0974k extends C0966c {
    /* renamed from: a */
    final /* synthetic */ C0969f f4827a;
    /* renamed from: b */
    private final AtomicInteger f4828b = new AtomicInteger(1);
    /* renamed from: c */
    private final C0978s f4829c;
    /* renamed from: d */
    private final C0823q f4830d;
    /* renamed from: e */
    private final long f4831e;
    /* renamed from: f */
    private final C0975l f4832f;
    /* renamed from: g */
    private final C0973j f4833g = new C0973j(this.f4827a);

    /* renamed from: d */
    public /* synthetic */ C0911h mo1258d() {
        return m7250i();
    }

    public C0974k(C0969f c0969f, C0978s c0978s) {
        this.f4827a = c0969f;
        this.f4829c = c0978s;
        this.f4830d = this.f4829c.f4841b;
        this.f4831e = 0;
        this.f4832f = new C0975l(c0969f);
        this.f4832f.m7253a(this.f4830d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f4830d != ((C0974k) obj).f4830d) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public File mo1255a() {
        return null;
    }

    /* renamed from: b */
    public long mo1256b() {
        return this.f4831e;
    }

    /* renamed from: c */
    public C0919l mo1257c() {
        return this.f4829c;
    }

    /* renamed from: i */
    public C0968e m7250i() {
        return this.f4832f;
    }

    /* renamed from: e */
    public C0908f mo1259e() {
        return this.f4833g;
    }

    /* renamed from: f */
    public void mo1260f() {
        WebLog.init().w(this.f4828b.get() > 0);
        this.f4828b.incrementAndGet();
    }

    /* renamed from: g */
    public void mo1261g() {
        WebLog.init().w(this.f4828b.get() > 0);
        if (this.f4828b.decrementAndGet() != 0) {
        }
    }

    /* renamed from: h */
    public int mo1451h() {
        return this.f4830d.mo1127a();
    }

    /* renamed from: a */
    public C0822a mo1449a(long j) {
        return this.f4830d.mo1129a((int) j);
    }

    /* renamed from: a */
    public C0824v mo1450a(C0982x c0982x) {
        WebLog.init().w(c0982x.m5777b());
        return m7240a(c0982x.mo1454j().m7141g(), c0982x.mo1454j().m7142h());
    }

    /* renamed from: a */
    public C0824v m7240a(long j, long j2) {
        if (j < 0 || j >= ((long) this.f4830d.mo1127a())) {
            return null;
        }
        C0822a a = this.f4830d.mo1129a((int) j);
        if (a != null) {
            return a.mo1121a((int) j2);
        }
        return null;
    }
}
