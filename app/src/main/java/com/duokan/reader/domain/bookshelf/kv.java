package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.sbk.C0822a;
import com.duokan.reader.domain.document.sbk.C0824v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class kv implements C0822a {
    /* renamed from: a */
    final /* synthetic */ kh f3484a;
    /* renamed from: b */
    private final String f3485b;
    /* renamed from: c */
    private final String f3486c;
    /* renamed from: d */
    private final String f3487d;
    /* renamed from: e */
    private final boolean f3488e;
    /* renamed from: f */
    private final AtomicReference<ArrayList<kx>> f3489f = new AtomicReference();

    public kv(kh khVar, String str, String str2, String str3) {
        this.f3484a = khVar;
        this.f3485b = str;
        this.f3486c = str2;
        this.f3487d = str3;
        this.f3488e = !khVar.mo1041v(this.f3485b);
    }

    /* renamed from: a */
    public boolean mo1122a() {
        return this.f3488e;
    }

    /* renamed from: b */
    public int mo1123b() {
        if (m4866f()) {
            return ((ArrayList) this.f3489f.get()).size();
        }
        return 0;
    }

    /* renamed from: a */
    public C0824v mo1121a(int i) {
        if (m4866f() && i >= 0 && i < mo1123b()) {
            return (C0824v) ((ArrayList) this.f3489f.get()).get(i);
        }
        return null;
    }

    /* renamed from: c */
    public String mo1124c() {
        return this.f3485b;
    }

    /* renamed from: d */
    public String mo1125d() {
        return this.f3486c;
    }

    /* renamed from: e */
    public String mo1126e() {
        return this.f3487d;
    }

    /* renamed from: f */
    private boolean m4866f() {
        if (this.f3488e) {
            return false;
        }
        if (this.f3489f.get() != null) {
            return true;
        }
        List<ky> y = this.f3484a.m4841y(this.f3485b);
        if (y.size() < 1) {
            return false;
        }
        ArrayList arrayList = new ArrayList(y.size());
        for (ky kxVar : y) {
            arrayList.add(new kx(this.f3484a, kxVar));
        }
        this.f3489f.compareAndSet(null, arrayList);
        return this.f3489f.get() != null;
    }
}
