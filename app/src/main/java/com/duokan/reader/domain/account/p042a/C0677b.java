package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.MiAccount;

/* renamed from: com.duokan.reader.domain.account.a.b */
public class C0677b implements C0676k {
    /* renamed from: a */
    private final C0692t f2271a;
    /* renamed from: b */
    private final C0680e f2272b;
    /* renamed from: c */
    private final C0678c f2273c;
    /* renamed from: d */
    private final C0690r f2274d;
    /* renamed from: e */
    private final C0681f f2275e;
    /* renamed from: f */
    private final C0697y f2276f = new C0697y(this);
    /* renamed from: g */
    private final C0695w f2277g;
    /* renamed from: h */
    private String f2278h;
    /* renamed from: i */
    private final C0674a f2279i;
    /* renamed from: j */
    private final C0679d f2280j;
    /* renamed from: k */
    private C0673p f2281k;

    public C0677b(MiAccount miAccount, C0420b c0420b) {
        this.f2272b = new C0680e(miAccount, this);
        this.f2271a = new C0692t(miAccount, this);
        this.f2273c = new C0678c(miAccount, this);
        this.f2277g = new C0695w(miAccount, this);
        this.f2274d = new C0690r(miAccount, c0420b);
        this.f2275e = new C0681f(miAccount, c0420b);
        this.f2279i = new C0674a(this);
        this.f2280j = new C0679d(this);
    }

    /* renamed from: a */
    public void m3288a() {
        mo855a(this.f2272b);
    }

    /* renamed from: a */
    public void mo855a(C0673p c0673p) {
        this.f2281k = c0673p;
        this.f2281k.mo854a();
    }

    /* renamed from: b */
    public C0673p mo857b() {
        return this.f2271a;
    }

    /* renamed from: c */
    public C0673p mo858c() {
        return this.f2273c;
    }

    /* renamed from: d */
    public C0690r mo859d() {
        return this.f2274d;
    }

    /* renamed from: e */
    public C0673p mo860e() {
        return this.f2276f;
    }

    /* renamed from: f */
    public C0681f mo861f() {
        return this.f2275e;
    }

    /* renamed from: a */
    public void mo856a(String str) {
        this.f2278h = str;
    }

    /* renamed from: g */
    public String mo862g() {
        return this.f2278h;
    }

    /* renamed from: h */
    public C0673p mo863h() {
        return this.f2277g;
    }

    /* renamed from: i */
    public C0673p mo864i() {
        return this.f2279i;
    }

    /* renamed from: j */
    public C0673p mo865j() {
        return this.f2280j;
    }
}
