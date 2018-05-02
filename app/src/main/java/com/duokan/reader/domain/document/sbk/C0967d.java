package com.duokan.reader.domain.document.sbk;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.document.sbk.d */
public class C0967d extends C0901g {
    /* renamed from: a */
    private final C0969f f4800a;
    /* renamed from: b */
    private final int f4801b;
    /* renamed from: c */
    private final int f4802c;
    /* renamed from: d */
    private final C0967d[] f4803d;
    /* renamed from: e */
    private final int f4804e;
    /* renamed from: f */
    private final String f4805f;
    /* renamed from: g */
    private final av f4806g;
    /* renamed from: h */
    private ak f4807h = null;

    protected C0967d(C0969f c0969f, int i, int i2, int i3, C0822a c0822a) {
        WebLog.init().w(c0822a != null);
        this.f4800a = c0969f;
        this.f4804e = i;
        this.f4801b = i2;
        this.f4802c = i3;
        this.f4803d = new C0967d[0];
        this.f4805f = c0822a.mo1125d();
        this.f4806g = new C0965b((long) i2, 0, 0);
    }

    /* renamed from: d */
    public int mo1201d() {
        return this.f4801b;
    }

    /* renamed from: c */
    public int mo1200c() {
        return this.f4802c;
    }

    /* renamed from: e */
    public String mo1202e() {
        return this.f4805f;
    }

    /* renamed from: f */
    public av mo1203f() {
        return this.f4806g;
    }

    /* renamed from: g */
    public ak mo1204g() {
        if (this.f4807h == null || !this.f4807h.mo1186a()) {
            this.f4807h = this.f4800a.mo1230c(this.f4806g);
        }
        return this.f4807h;
    }

    /* renamed from: h */
    public int mo1205h() {
        return this.f4804e;
    }

    /* renamed from: i */
    public int mo1206i() {
        return this.f4803d.length;
    }

    /* renamed from: j */
    public C0901g[] mo1207j() {
        return this.f4803d;
    }

    /* renamed from: k */
    public boolean mo1208k() {
        return true;
    }
}
