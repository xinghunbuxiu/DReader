package com.duokan.reader.domain.document.a;

import android.net.Uri;

import com.duokan.core.diagnostic.a;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.l;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class i extends b {
    final /* synthetic */ d a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final r c;
    private final File d;
    private final long e;
    private final DkpBook f;
    private final DkpBook g;
    private final j h;
    private final h i = new h(this.a);

    public /* synthetic */ h d() {
        return k();
    }

    public i(d dVar, r rVar, DkpBook dkpBook, DkpBook dkpBook2) {
        this.a = dVar;
        this.c = rVar;
        this.d = new File(Uri.parse(this.c.a).getPath());
        this.e = this.d.length();
        this.f = dkpBook;
        this.g = dkpBook2;
        this.h = new j(dVar);
        this.h.a(this.f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f != ((i) obj).f) {
            return false;
        }
        return true;
    }

    public File a() {
        return this.d;
    }

    public long b() {
        return this.e;
    }

    public DkpBook h() {
        return this.f;
    }

    public DkpBook i() {
        return this.g;
    }

    public l c() {
        return this.c;
    }

    public j k() {
        return this.h;
    }

    public f e() {
        return this.i;
    }

    public void f() {
        a.c().b(this.b.get() > 0);
        this.b.incrementAndGet();
    }

    public void g() {
        a.c().b(this.b.get() > 0);
        if (this.b.decrementAndGet() == 0) {
            this.f.close();
            this.g.close();
        }
    }
}
