package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.micloud.bi;

public class iy {
    private final bi a;
    private String b;
    private boolean c = false;

    public iy(bi biVar) {
        this.a = biVar;
    }

    public bi a() {
        return this.a;
    }

    public String b() {
        return this.a.e();
    }

    public long c() {
        return this.a.h();
    }

    public long d() {
        return this.a.j();
    }

    public String e() {
        return this.a.k();
    }

    public String f() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = ae.a(this.a);
        }
        return this.b;
    }

    public void g() {
        f();
    }

    public boolean h() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
