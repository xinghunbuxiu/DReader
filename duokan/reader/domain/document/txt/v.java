package com.duokan.reader.domain.document.txt;

import android.net.Uri;

import com.duokan.kernel.txtlib.DktBook;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.l;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class v extends c {
    final /* synthetic */ p a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final ae c;
    private final File d;
    private final long e;
    private final DktBook f;
    private final w g;
    private final u h = new u(this.a);

    public /* synthetic */ h d() {
        return i();
    }

    public v(p pVar, ae aeVar, DktBook dktBook) {
        this.a = pVar;
        this.c = aeVar;
        this.d = new File(Uri.parse(this.c.a).getPath());
        this.e = this.d.length();
        this.f = dktBook;
        this.g = new w(pVar);
        this.g.a(this.f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f != ((v) obj).f) {
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

    public DktBook h() {
        return this.f;
    }

    public l c() {
        return this.c;
    }

    public w i() {
        return this.g;
    }

    public f e() {
        return this.h;
    }

    public void f() {
        a.c().b(this.b.get() > 0);
        this.b.incrementAndGet();
    }

    public void g() {
        a.c().b(this.b.get() > 0);
        if (this.b.decrementAndGet() == 0) {
            this.f.close();
        }
    }
}
