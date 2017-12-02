package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.sbk.a;
import com.duokan.reader.domain.document.sbk.v;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class kj implements a {
    final /* synthetic */ jv a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final AtomicReference f = new AtomicReference();

    public kj(jv jvVar, String str, String str2, String str3) {
        this.a = jvVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = !jvVar.u(this.b);
    }

    public boolean a() {
        return this.e;
    }

    public int b() {
        if (f()) {
            return ((ArrayList) this.f.get()).size();
        }
        return 0;
    }

    public v a(int i) {
        if (f() && i >= 0 && i < b()) {
            return (v) ((ArrayList) this.f.get()).get(i);
        }
        return null;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    private boolean f() {
        if (this.e) {
            return false;
        }
        if (this.f.get() != null) {
            return true;
        }
        List<km> x = this.a.x(this.b);
        if (x.size() < 1) {
            return false;
        }
        ArrayList arrayList = new ArrayList(x.size());
        for (km klVar : x) {
            arrayList.add(new kl(this.a, klVar));
        }
        this.f.compareAndSet(null, arrayList);
        return this.f.get() != null;
    }
}
