package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.MiAccount;

/* renamed from: com.duokan.reader.domain.account.a.s */
public class C0691s implements C0676k {
    /* renamed from: a */
    private final C0692t f2321a;
    /* renamed from: b */
    private final C0680e f2322b;
    /* renamed from: c */
    private final C0697y f2323c = new C0697y(this);
    /* renamed from: d */
    private final C0695w f2324d;
    /* renamed from: e */
    private final C0694v f2325e;
    /* renamed from: f */
    private final C0690r f2326f;
    /* renamed from: g */
    private final C0681f f2327g;
    /* renamed from: h */
    private final C0674a f2328h;
    /* renamed from: i */
    private final C0679d f2329i;
    /* renamed from: j */
    private final C0698z f2330j;
    /* renamed from: k */
    private volatile String f2331k;
    /* renamed from: l */
    private C0673p f2332l;

    public C0691s(MiAccount miAccount, C0420b c0420b, C0698z c0698z) {
        this.f2322b = new C0680e(miAccount, this);
        this.f2321a = new C0692t(miAccount, this);
        this.f2324d = new C0695w(miAccount, this);
        this.f2325e = new C0694v(miAccount, this);
        this.f2328h = new C0674a(this);
        this.f2329i = new C0679d(this);
        this.f2326f = new C0690r(miAccount, c0420b);
        this.f2327g = new C0681f(miAccount, c0420b);
        this.f2330j = c0698z;
    }

    /* renamed from: a */
    public void m3332a() {
        this.f2330j.m3355a();
        mo855a(this.f2322b);
    }

    /* renamed from: a */
    public void mo855a(C0673p c0673p) {
        this.f2332l = c0673p;
        this.f2332l.mo854a();
        if (this.f2332l == this.f2326f || this.f2332l == this.f2327g) {
            this.f2330j.m3356b();
        }
    }

    /* renamed from: b */
    public C0673p mo857b() {
        return this.f2321a;
    }

    /* renamed from: c */
    public C0673p mo858c() {
        return this.f2325e;
    }

    /* renamed from: d */
    public C0690r mo859d() {
        return this.f2326f;
    }

    /* renamed from: e */
    public C0673p mo860e() {
        return this.f2323c;
    }

    /* renamed from: f */
    public C0681f mo861f() {
        return this.f2327g;
    }

    /* renamed from: a */
    public void mo856a(String str) {
        this.f2331k = str;
    }

    /* renamed from: g */
    public String mo862g() {
        return this.f2331k;
    }

    /* renamed from: h */
    public C0673p mo863h() {
        return this.f2324d;
    }

    /* renamed from: i */
    public C0673p mo864i() {
        return this.f2328h;
    }

    /* renamed from: j */
    public C0673p mo865j() {
        return this.f2329i;
    }
}
