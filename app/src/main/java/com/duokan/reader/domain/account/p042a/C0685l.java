package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.MiGuestAccount;

/* renamed from: com.duokan.reader.domain.account.a.l */
public class C0685l implements C0675g {
    /* renamed from: a */
    private final C0686m f2306a;
    /* renamed from: b */
    private final C0694v f2307b;
    /* renamed from: c */
    private final C0681f f2308c;
    /* renamed from: d */
    private final C0690r f2309d;
    /* renamed from: e */
    private C0673p f2310e;
    /* renamed from: f */
    private final C0698z f2311f;

    public C0685l(MiGuestAccount miGuestAccount, String str, C0420b c0420b, C0698z c0698z) {
        this.f2307b = new C0694v(miGuestAccount, this);
        this.f2306a = new C0688o().m3330a(miGuestAccount, str, this);
        this.f2309d = new C0690r(miGuestAccount, c0420b);
        this.f2308c = new C0681f(miGuestAccount, c0420b);
        this.f2311f = c0698z;
    }

    /* renamed from: a */
    public void m3320a() {
        this.f2311f.m3355a();
        mo855a(this.f2306a);
    }

    /* renamed from: a */
    public void mo855a(C0673p c0673p) {
        this.f2310e = c0673p;
        this.f2310e.mo854a();
        if (this.f2310e == this.f2309d || this.f2310e == this.f2308c) {
            this.f2311f.m3356b();
        }
    }

    /* renamed from: b */
    public C0673p mo857b() {
        return null;
    }

    /* renamed from: c */
    public C0673p mo858c() {
        return this.f2307b;
    }

    /* renamed from: d */
    public C0690r mo859d() {
        return this.f2309d;
    }

    /* renamed from: f */
    public C0681f mo861f() {
        return this.f2308c;
    }
}
