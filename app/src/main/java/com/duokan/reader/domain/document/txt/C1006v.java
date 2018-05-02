package com.duokan.reader.domain.document.txt;

import android.net.Uri;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.txtlib.DktBook;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0919l;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.duokan.reader.domain.document.txt.v */
class C1006v extends C0987c {
    /* renamed from: a */
    final /* synthetic */ C1000p f5003a;
    /* renamed from: b */
    private final AtomicInteger f5004b = new AtomicInteger(1);
    /* renamed from: c */
    private final ae f5005c;
    /* renamed from: d */
    private final File f5006d;
    /* renamed from: e */
    private final long f5007e;
    /* renamed from: f */
    private final DktBook f5008f;
    /* renamed from: g */
    private final C1007w f5009g;
    /* renamed from: h */
    private final C1005u f5010h = new C1005u(this.f5003a);

    /* renamed from: d */
    public /* synthetic */ C0911h mo1258d() {
        return m7764i();
    }

    public C1006v(C1000p c1000p, ae aeVar, DktBook dktBook) {
        this.f5003a = c1000p;
        this.f5005c = aeVar;
        this.f5006d = new File(Uri.parse(this.f5005c.a).getPath());
        this.f5007e = this.f5006d.length();
        this.f5008f = dktBook;
        this.f5009g = new C1007w(c1000p);
        this.f5009g.m7765a(this.f5008f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f5008f != ((C1006v) obj).f5008f) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public File mo1255a() {
        return this.f5006d;
    }

    /* renamed from: b */
    public long mo1256b() {
        return this.f5007e;
    }

    /* renamed from: h */
    public DktBook mo1468h() {
        return this.f5008f;
    }

    /* renamed from: c */
    public C0919l mo1257c() {
        return this.f5005c;
    }

    /* renamed from: i */
    public C1007w m7764i() {
        return this.f5009g;
    }

    /* renamed from: e */
    public C0908f mo1259e() {
        return this.f5010h;
    }

    /* renamed from: f */
    public void mo1260f() {
        WebLog.init().w(this.f5004b.get() > 0);
        this.f5004b.incrementAndGet();
    }

    /* renamed from: g */
    public void mo1261g() {
        WebLog.init().w(this.f5004b.get() > 0);
        if (this.f5004b.decrementAndGet() == 0) {
            this.f5008f.close();
        }
    }
}
