package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.v */
class C0740v implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2506a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2507b;

    C0740v(C0709k c0709k, C0420b c0420b) {
        this.f2507b = c0709k;
        this.f2506a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2507b.m3503b(c0672a);
        if (this.f2506a != null) {
            this.f2506a.onLoginOk(c0672a);
        }
    }

    public void onLoginError(C0672a c0672a, String str) {
        if (this.f2506a != null) {
            this.f2506a.onLoginError(c0672a, str);
        }
    }
}
