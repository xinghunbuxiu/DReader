package com.duokan.reader.domain.document.p045a;

import android.net.Uri;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0919l;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.duokan.reader.domain.document.a.i */
class C0910i extends C0900b {
    /* renamed from: a */
    final /* synthetic */ C0904d f4300a;
    /* renamed from: b */
    private final AtomicInteger f4301b = new AtomicInteger(1);
    /* renamed from: c */
    private final C0920r f4302c;
    /* renamed from: d */
    private final File f4303d;
    /* renamed from: e */
    private final long f4304e;
    /* renamed from: f */
    private final DkpBook f4305f;
    /* renamed from: g */
    private final DkpBook f4306g;
    /* renamed from: h */
    private final C0912j f4307h;
    /* renamed from: i */
    private final C0909h f4308i = new C0909h(this.f4300a);

    /* renamed from: d */
    public /* synthetic */ C0911h mo1258d() {
        return m6045k();
    }

    public C0910i(C0904d c0904d, C0920r c0920r, DkpBook dkpBook, DkpBook dkpBook2) {
        this.f4300a = c0904d;
        this.f4302c = c0920r;
        this.f4303d = new File(Uri.parse(this.f4302c.a).getPath());
        this.f4304e = this.f4303d.length();
        this.f4305f = dkpBook;
        this.f4306g = dkpBook2;
        this.f4307h = new C0912j(c0904d);
        this.f4307h.m6059a(this.f4305f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f4305f != ((C0910i) obj).f4305f) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public File mo1255a() {
        return this.f4303d;
    }

    /* renamed from: b */
    public long mo1256b() {
        return this.f4304e;
    }

    /* renamed from: h */
    public DkpBook mo1262h() {
        return this.f4305f;
    }

    /* renamed from: i */
    public DkpBook mo1263i() {
        return this.f4306g;
    }

    /* renamed from: c */
    public C0919l mo1257c() {
        return this.f4302c;
    }

    /* renamed from: k */
    public C0912j m6045k() {
        return this.f4307h;
    }

    /* renamed from: e */
    public C0908f mo1259e() {
        return this.f4308i;
    }

    /* renamed from: f */
    public void mo1260f() {
        WebLog.init().w(this.f4301b.get() > 0);
        this.f4301b.incrementAndGet();
    }

    /* renamed from: g */
    public void mo1261g() {
        WebLog.init().w(this.f4301b.get() > 0);
        if (this.f4301b.decrementAndGet() == 0) {
            this.f4305f.close();
            this.f4306g.close();
        }
    }
}
