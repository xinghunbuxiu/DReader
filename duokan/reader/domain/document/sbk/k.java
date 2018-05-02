package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.l;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class k extends c {
    final /* synthetic */ f a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final s c;
    private final q d;
    private final long e;
    private final l f;
    private final j g = new j(this.a);

    public /* synthetic */ h d() {
        return i();
    }

    public k(f fVar, s sVar) {
        this.a = fVar;
        this.c = sVar;
        this.d = this.c.b;
        this.e = 0;
        this.f = new l(fVar);
        this.f.a(this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.d != ((k) obj).d) {
            return false;
        }
        return true;
    }

    public File a() {
        return null;
    }

    public long b() {
        return this.e;
    }

    public l c() {
        return this.c;
    }

    public e i() {
        return this.f;
    }

    public f e() {
        return this.g;
    }

    public void f() {
        a.c().b(this.b.get() > 0);
        this.b.incrementAndGet();
    }

    public void g() {
        a.c().b(this.b.get() > 0);
        if (this.b.decrementAndGet() != 0) {
        }
    }

    public int h() {
        return this.d.a();
    }

    public WebLog a(long j) {
        return this.d.a((int) j);
    }

    public v a(x xVar) {
        a.c().b(xVar.b());
        return a(xVar.j().g(), xVar.j().h());
    }

    public v a(long j, long j2) {
        if (j < 0 || j >= ((long) this.d.a())) {
            return null;
        }
        WebLog a = this.d.a((int) j);
        if (a != null) {
            return a.a((int) j2);
        }
        return null;
    }
}
