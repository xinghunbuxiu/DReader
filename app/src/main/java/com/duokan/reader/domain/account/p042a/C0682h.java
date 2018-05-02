package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.MiAccount;

/* renamed from: com.duokan.reader.domain.account.a.h */
public class C0682h implements C0676k {
    /* renamed from: a */
    private final C0683i f2291a;
    /* renamed from: b */
    private final C0680e f2292b;
    /* renamed from: c */
    private final C0694v f2293c;
    /* renamed from: d */
    private final C0681f f2294d;
    /* renamed from: e */
    private final C0690r f2295e;
    /* renamed from: f */
    private final C0697y f2296f;
    /* renamed from: g */
    private final C0695w f2297g;
    /* renamed from: h */
    private final C0674a f2298h;
    /* renamed from: i */
    private final C0679d f2299i;
    /* renamed from: j */
    private C0673p f2300j;
    /* renamed from: k */
    private String f2301k = "";
    /* renamed from: l */
    private final C0698z f2302l;

    public C0682h(MiAccount miAccount, C0420b c0420b, C0698z c0698z) {
        this.f2292b = new C0680e(miAccount, this);
        this.f2291a = new C0683i(miAccount, this);
        this.f2293c = new C0694v(miAccount, this);
        this.f2296f = new C0697y(this);
        this.f2295e = new C0690r(miAccount, c0420b);
        this.f2297g = new C0695w(miAccount, this);
        this.f2294d = new C0681f(miAccount, c0420b);
        this.f2298h = new C0674a(this);
        this.f2299i = new C0679d(this);
        this.f2302l = c0698z;
    }

    /* renamed from: a */
    public void m3305a() {
        this.f2302l.m3355a();
        mo855a(this.f2292b);
    }

    /* renamed from: a */
    public void mo855a(C0673p c0673p) {
        this.f2300j = c0673p;
        this.f2300j.mo854a();
        if (this.f2300j == this.f2295e || this.f2300j == this.f2294d) {
            this.f2302l.m3356b();
        }
    }

    /* renamed from: b */
    public C0673p mo857b() {
        return this.f2291a;
    }

    /* renamed from: c */
    public C0673p mo858c() {
        return this.f2293c;
    }

    /* renamed from: d */
    public C0690r mo859d() {
        return this.f2295e;
    }

    /* renamed from: e */
    public C0673p mo860e() {
        return this.f2296f;
    }

    /* renamed from: f */
    public C0681f mo861f() {
        return this.f2294d;
    }

    /* renamed from: a */
    public void mo856a(String str) {
        this.f2301k = str;
    }

    /* renamed from: g */
    public String mo862g() {
        return this.f2301k;
    }

    /* renamed from: h */
    public C0673p mo863h() {
        return this.f2297g;
    }

    /* renamed from: i */
    public C0673p mo864i() {
        return this.f2298h;
    }

    /* renamed from: j */
    public C0673p mo865j() {
        return this.f2299i;
    }
}
