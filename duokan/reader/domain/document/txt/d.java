package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.g;

public class d extends g {
    private final p a;
    private final int b;
    private final int c;
    private final String d;
    private final av e;
    private ak f = null;

    protected d(p pVar, int i, int i2, String str, av avVar) {
        this.a = pVar;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = avVar;
    }

    public int d() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public av f() {
        return this.e;
    }

    public ak g() {
        if (this.f == null || !this.f.a()) {
            this.f = this.a.d(this.e);
        }
        return this.f;
    }

    public int h() {
        return 0;
    }

    public int i() {
        return 0;
    }

    public g[] j() {
        return new d[0];
    }

    public boolean k() {
        return true;
    }
}
