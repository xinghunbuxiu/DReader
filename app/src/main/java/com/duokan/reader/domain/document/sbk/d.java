package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.g;

public class d extends g {
    private final f a;
    private final int b;
    private final int c;
    private final d[] d;
    private final int e;
    private final String f;
    private final av g;
    private ak h = null;

    protected d(f fVar, int i, int i2, int i3, a aVar) {
        a.c().b(aVar != null);
        this.a = fVar;
        this.e = i;
        this.b = i2;
        this.c = i3;
        this.d = new d[0];
        this.f = aVar.d();
        this.g = new b((long) i2, 0, 0);
    }

    public int d() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String e() {
        return this.f;
    }

    public av f() {
        return this.g;
    }

    public ak g() {
        if (this.h == null || !this.h.a()) {
            this.h = this.a.c(this.g);
        }
        return this.h;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.d.length;
    }

    public g[] j() {
        return this.d;
    }

    public boolean k() {
        return true;
    }
}
